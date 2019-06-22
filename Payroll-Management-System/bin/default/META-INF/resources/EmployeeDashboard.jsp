<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>

</head>
<!-- <header id="header">
	<a href="/EmployeeDetails.jsp">View Profile</a>
	<a href="/EmployeePayslip.jsp">View Payslip</a>
	<a href="/view.jsp">Log out</a>
</header> -->
<portlet:renderURL var="viewEmployeeURL">
	<portlet:param name="eno" value="${eno }"/>
	<portlet:param name="jspPage" value="/EmployeeDetails.jsp"/>
	
</portlet:renderURL>
<portlet:renderURL var="viewPayslipURL">
<portlet:param name="eno" value="${eno }"/>
	<portlet:param name="jspPage" value="/EmployeePayslip.jsp"/>
	
</portlet:renderURL>
<portlet:renderURL var="logoutURl">
	<portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>
<aui:form >

<aui:button-row>
	<aui:button type="submit" onClick="<%=viewEmployeeURL %>" value="View Details"/>
	<aui:button type="submit" onClick="<%=viewPayslipURL %>" value="View Payslip"/>
	<aui:button type="submit" onClick="<%=logoutURl %>" value="log out"/>
	
</aui:button-row>

</aui:form>
<style>
 	.header{
 			    background-color: #29353d;
    			height: 50px;
   				 text-align: center;
   				 padding: 15px;
 		}
</style>

