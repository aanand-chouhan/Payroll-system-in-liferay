<%@ include file="/init.jsp"%>
<%@ page import="com.vy.payroll.model.PayslipDetails"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.vy.payroll.service.PayslipDetailsLocalServiceUtil"%>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="com.liferay.portal.kernel.util.ListUtil"%>
 <div id="customers">
  <%
  	 /* String eid=ParamUtil.getString(request, "eid");  */
  	 String empID=(String)session.getAttribute("EmpID"); 
    int month=ParamUtil.getInteger(request,"month");
    String monthdwld=String.valueOf(month);
 	 out.print("month" +month);
	List<PayslipDetails> payslip=PayslipDetailsLocalServiceUtil.findByMonthId(month, empID);
%>


		
		
		<liferay-ui:search-container  delta="5" deltaConfigurable="true" 
  emptyResultsMessage="Oops. There Are No paySlip To Display, Please add paySlip">
  
 <liferay-ui:search-container-results results="<%=ListUtil.subList(payslip, searchContainer.getStart(),searchContainer.getEnd())%>" />
  <liferay-ui:search-container-row className="PayslipDetails" modelVar="paySlip" keyProperty="eno" >
   <liferay-ui:search-container-column-text name="Employee Id" value="${paySlip.eid}"/>
   <liferay-ui:search-container-column-text name="hra" property="${payslip.get(0).getHra()}"/>
   <liferay-ui:search-container-column-text name="ca" property="${payslip.get(0).getCa()}"/>
   <liferay-ui:search-container-column-text name="sa" property="${payslip.get(0).getSa()}"/>
   <liferay-ui:search-container-column-text name="ta" property="${payslip.get(0).getTa()}"/>
   <liferay-ui:search-container-column-text name="ma" property="${payslip.get(0).getMa()}"/>
   <liferay-ui:search-container-column-text name="incomeTax" property="incomeTax"/>
   <%-- <liferay-ui:search-container-column-text name="professionalTax" property="proffesionalTax"/> --%>
   <liferay-ui:search-container-column-text name="month" property="${payslip.get(0).getMonth()}"/>
   <liferay-ui:search-container-column-text name="basicSalary" property="${payslip.get(0).getBasicSalary()}"/>
  </liferay-ui:search-container-row>
	   
 <liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>

<portlet:renderURL var="dashboardURL">
<portlet:param name="jspPage" value="/EmployeeDashboard.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="downloadpdfURL">
	<portlet:param name="resourceId" value="1"/>
	<portlet:param name="month" value="<%=monthdwld %>"/>
	<portlet:param name="eid" value="<%= empID%>"/>
</portlet:resourceURL>
  <aui:button type="submit" onClick="<%=dashboardURL%>" value="Back"/>
  <aui:button type="submit" onClick="<%=downloadpdfURL%>" value="download"/>

 