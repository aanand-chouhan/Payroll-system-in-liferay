<%@ include file="/init.jsp" %>
<%@ page import="com.vy.payroll.model.EmployeeDetails"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.vy.payroll.service.EmployeeDetailsLocalServiceUtil"%>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%
  	long eno=ParamUtil.getLong(request, "eno");
	EmployeeDetails emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetails(eno);
	emp.getEid()
%>


		
		
		<c:choose>
		
		<c:when test="${empty emp}">
		<div class="table-responsive">
			<table class="table table-bordered" >
			  <thead class="thead-light ">
				<tr>
					<!-- <th>ENO</th> -->
					<th>Member ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Mobile Number</th>
					<th>Pan Number</th>
					<th>Adhar Number</th>
					<th>UAN Number</th>
					<th>Date of joing</th>
					<th>Designation</th>
					<th>Role</th>
					<th>Address</th>
					<th>Date of birth</th>
					<th>Qualification</th>
					
					
				</tr>
					
				<tr>
					<td><input type="text" name="eNo" value="<%= emp.getEid() %>" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="name" value="<%= emp.getEName() %>" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="email" value="<%= emp.getEmail() %>" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="gender" value="<%= emp.getGender() %>" readonly="readonly" style="border:none"> </td>
					<td><input type="text" name="mobileNO" value="<%= emp.getMobileNo() %>" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="panNO" value="<%= emp.getPanCardNo() %>" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="adharNo" value="$<%= emp.getAdharCardNo() %>" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="uan" value="<%= emp.getUanNo() %>" style="border:none"></td>
					<td><input type="text" name="doj" value="<%= emp.getDoj() %>" style="border:none"></td>
					<td><input type="text" name="desg" value="<%= emp.getDesignation() %>" style="border:none"></td>
					<td><input type="text" name="role" value="<%= emp.getRole() %>" style="border:none"></td>
					<td><input type="text" name="addrs" value="<%= emp.getAddress() %>" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="dob" value="<%= emp.getDob() %>" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="qualification" value="<%= emp.getQualificationS() %>" readonly="readonly" style="border:none"></td>
					
				</tr>
				
				</thead>
			</table>
			
		</div>
		</c:when>
		<c:otherwise>
		No data
	</c:otherwise>
	</c:choose>

<%--   <%
  	long eno=(long)request.getAttribute("eno");
	EmployeeDetails emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetails(eno);
	List<EmployeeDetails> list=new ArrayList();
	list.add(emp);
%>


<liferay-ui:search-container  delta="5" deltaConfigurable="true" emptyResultsMessage="Oops. There Are No Employee To Display, Please add Employee"  total="<%=EmployeeDetailsLocalServiceUtil.getEmployeeDetails(eno) %>">
 <liferay-ui:search-container-results results="<%=EmployeeDetailsLocalServiceUtil.getEmployeeDetails(eno) %>" />
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
   </liferay-ui:search-container-row>
 <liferay-ui:search-iterator />
</liferay-ui:search-container> --%>


<portlet:renderURL var="dashboardURL">
<portlet:param name="jspPage" value="/EmployeeDashboard.jsp"/>
</portlet:renderURL>

  <aui:button type="submit" onClick="<%=dashboardURL %>" value="Back"/>
  