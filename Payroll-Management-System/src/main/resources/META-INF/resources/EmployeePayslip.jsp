<%@page import="com.vy.payroll.service.PayslipDetailsLocalServiceUtil"%>
<%@page import="com.vy.payroll.model.PayslipDetails"%>
<%@ include file="/init.jsp" %>
<%@ page import="com.vy.payroll.model.EmployeeDetails"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.vy.payroll.service.EmployeeDetailsLocalServiceUtil"%>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
 <%-- <%
  	String id=ParamUtil.getString(request, "id");
 	String eno=ParamUtil.getString(request,"eno");
  	%> --%>


<portlet:renderURL var="payslipURL">
<%-- <portlet:param name="eid" value="<%=id %>"/> --%>
<portlet:param name="jspPage" value="/ViewEmployeePayslip.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="dashboardURL">
<%-- <portlet:param name="eno" value="<%=eno %>"/> --%>
<portlet:param name="jspPage" value="/EmployeeDashboard.jsp"/>
</portlet:renderURL>
<aui:form method="post" action="<%=payslipURL.toString() %>"> 
	<aui:select name="month">
		<aui:option value="0">select month</aui:option>
		<aui:option value="1">1</aui:option>
		<aui:option value="2">2</aui:option>
		<aui:option value="3">3</aui:option>
	</aui:select>
	<aui:button-row>
            <aui:button type="submit" value="View payslip" />
           <%--  <aui:button type="hidden"  name="eid" value="<%=id %>"/>
            <aui:button type="hidden"  name="eid" value="<%=eno %>"/> --%>
            <aui:button type="submit" onClick="<%=dashboardURL%>" value="Back"/>
    </aui:button-row>
</aui:form>