<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@ page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.vy.payroll.model.EmployeeDetails"%>
<%@ page import="com.vy.payroll.service.EmployeeDetailsLocalServiceUtil"%>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
 
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>

<%
	PortletURL updateMemberURL = renderResponse.createActionURL();
updateMemberURL.setParameter(ActionRequest.ACTION_NAME, "updateMember");
%>


<%
	long id=Integer.parseInt(request.getParameter("eid"));
	out.println("eid in update page"+id);
	EmployeeDetails emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetails(id);
	out.println(emp.getPassword()+emp.getPanCardNo()+emp.getUanNo()+"name "+emp.getEName() +" mno "+ emp.getMobileNo()+emp.getAddress()+emp.getAdharCardNo()+emp.getGender()+emp.getQualificationS());
%>

<portlet:renderURL var="viewEmpURL">
<portlet:param name="jspPage" value="/viewEmployee.jsp"/>
</portlet:renderURL>
<aui:form method="POST" action="<%= updateMemberURL.toString() %>" name="<portlet:namespace />fm">
	<aui:input name="name" type="text"  placeholder="<%= emp.getEName() %>"/>
	<aui:input name="panCardNo" type="text" placeholder="<%= emp.getPanCardNo() %>"/>
	<aui:input name="gender" type="radio" value="male" label="Male" placeholder="<%= emp.getGender() %>"/>
	<aui:input name="gender" type="radio" value="female" label="Female" placeholder="<%= emp.getGender() %>"/>
	<aui:input name="address" type="text" placeholder="<%= emp.getAddress() %>"/>
	<aui:input name="qualification" type="text" placeholder="<%= emp.getQualificationS() %>"/>
	<aui:input name="designation" type="text" placeholder="<%= emp.getDesignation() %>"/>
	<aui:input name="role" type="text" placeholder="<%= emp.getRole() %>"/>
	<aui:input name="eid" type="hidden" value="<%= emp.getEno() %>"/>
	
	<aui:button-row>
            <aui:button type="submit" value="Update"/>
            <aui:button type="submit" onClick="<%=viewEmpURL %>" value="Back"/>
            
    </aui:button-row>

</aui:form>