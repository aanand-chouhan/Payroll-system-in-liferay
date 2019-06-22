<%@ include file="/init.jsp" %>
<%@ page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.vy.payroll.model.EmployeeDetails"%>
<%@ page import="com.vy.payroll.service.EmployeeDetailsLocalServiceUtil"%>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

 <%
	int count = EmployeeDetailsLocalServiceUtil.getEmployeeDetailsesCount();
	List<EmployeeDetails> emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetailses(0,count);
%>


<liferay-ui:search-container  delta="5" deltaConfigurable="true" 
  emptyResultsMessage="Oops. There Are No Employee To Display, Please add Employee">
  
 <liferay-ui:search-container-results results="<%=ListUtil.subList(emp, searchContainer.getStart(),searchContainer.getEnd())%>" />
  <liferay-ui:search-container-row className="EmployeeDetails" modelVar="employee" keyProperty="eno" >
   <liferay-ui:search-container-column-text name="Employee Id" value="${employee.eid}"/>
   <liferay-ui:search-container-column-text name="Employee Name" property="EName"/>
   <liferay-ui:search-container-column-text name="Email " property="email"/>
   <liferay-ui:search-container-column-text name="gender" property="gender"/>
   <liferay-ui:search-container-column-text name="mobile no" property="mobileNo"/>
   <liferay-ui:search-container-column-text name="pan card" property="panCardNo"/>
   <liferay-ui:search-container-column-text name="Adhar no" property="adharCardNo"/>
   <liferay-ui:search-container-column-text name="UAN no" property="uanNo"/>
   <liferay-ui:search-container-column-text name="dob" property="dob"/>
   <liferay-ui:search-container-column-text name="doj" property="doj"/>
   <liferay-ui:search-container-column-text name="Designation" property="designation"/>
   <liferay-ui:search-container-column-text name="role" property="role"/>
   <liferay-ui:search-container-column-text name="Qualification" property="qualificationS"/>
   <liferay-ui:search-container-column-text name="Address" property="address"/>
	<%-- <liferay-ui:search-container-column-text name="Action">
		<a href="<%=dashboardURL %>">Delete</a>
	</liferay-ui:search-container-column-text> --%>
	<!-- For Delete URL  -->
		<portlet:actionURL var="deleteEmployee" name="deleteEmployee">
		    <%--  <portlet:param name="backURL" value="<%=currentURL %>" /> --%>
		     <portlet:param name="eid" value="${employee.eid}" />
		</portlet:actionURL>
	   <liferay-ui:search-container-column-text name="Delete Employee" value="Delete"  href="${deleteEmployee}"/>
	  
	   <portlet:renderURL var="updateEmployee">
	     <portlet:param name="eid" value="${employee.eno}" />
	     <portlet:param name="mvcPath" value="/employee_update.jsp"/>
       </portlet:renderURL>
	   <liferay-ui:search-container-column-text name="Update Employee" value="Update"  href="${updateEmployee}"/>
			  
 		
 		 <portlet:renderURL var="generateSalaryURL">
	     <portlet:param name="eno" value="${employee.eno}" />
	     <portlet:param name="eid" value="${employee.eid}" />
	     <portlet:param name="mvcPath" value="/generateSalary.jsp"/>
       </portlet:renderURL>
	   <liferay-ui:search-container-column-text name="Generate salary" value="generate"  href="${generateSalaryURL}"/>
	   
  </liferay-ui:search-container-row>
  
 
	   
 <liferay-ui:search-iterator />

</liferay-ui:search-container>


<portlet:renderURL var="dashboardURL">
<portlet:param name="jspPage" value="/dashboard.jsp"/>
</portlet:renderURL>

  <aui:button type="submit" onClick="<%=dashboardURL %>" value="Back"/>
  
  