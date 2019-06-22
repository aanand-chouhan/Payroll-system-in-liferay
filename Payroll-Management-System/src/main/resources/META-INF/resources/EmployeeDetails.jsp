<%@ include file="/init.jsp" %>
<%@ include file="/EmployeeDashboard.jsp" %>
<%@ page import="com.vy.payroll.model.EmployeeDetails"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.sql.Blob"%>
<%@ page import="javax.xml.bind.DatatypeConverter"%>
<%@ page import="com.vy.payroll.service.EmployeeDetailsLocalServiceUtil"%>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%
  /* 	 long eno=ParamUtil.getLong(request, "eNO"); 
  	 // long eno=Long.parseLong(request.getParameter("eno"));
  	long empNo=(Long)session.getAttribute("EmpNO");
    //String empNO=String.valueOf(empNo);
	EmployeeDetails emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetails(empNo);
	//out.print(emp.getImage());
	Blob blob= emp.getImage();
	int myblobLength = (int) blob.length();  
	byte[] myblobAsBytes = blob.getBytes(1, myblobLength);
	String image = DatatypeConverter.printBase64Binary(myblobAsBytes);  */
	//out.print(qrCodeDisplay);
%>

	<style>
		div#profile_pic {
  			  background-color: #071850;
   		   	  padding: 10px;
  			  padding-left: 550px;
   		}
		
		img.image {
       		 border-radius: 60px;
   			 height: 100px;
   			 width: 100px;
		}
	</style>					

		
		
		<c:choose>
		
		<c:when test="${empty emp}">
				<div id="profile_pic" >
					<img src="data:image/jpeg;base64,<%=image %>" alt="no Image" height="50px" width="50px" class="image"/>
				</div>


		
		<div class="table-responsive">
			<table class="table table-bordered table-striped">
			  <thead class="thead-light ">
				<tr>
					<!-- <td>ENO</td> -->
					<td>Member ID</td>
					<td><input type="text" name="eNo" value="<%= emp.getEid() %>" readonly="readonly" style="border:none"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%= emp.getEName() %>" readonly="readonly" style="border:none"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" value="<%= emp.getEmail() %>" readonly="readonly" style="border:none"></td>
				</tr>
				<tr>	
					<td>Gender</td>
					<td><input type="text" name="gender" value="<%= emp.getGender() %>" readonly="readonly" style="border:none"> </td>
				</tr>	
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="mobileNO" value="<%= emp.getMobileNo() %>" readonly="readonly" style="border:none"></td>
				</tr>
				<tr>
					<td>Pan Number</td>
					<td><input type="text" name="panNO" value="<%= emp.getPanCardNo() %>" readonly="readonly" style="border:none"></td>
				</tr>
				<tr>	
					<td>Adhar Number</td>
					<td><input type="text" name="adharNo" value="<%= emp.getAdharCardNo() %>" readonly="readonly" style="border:none"></td>
				</tr>
				<tr>	
					<td>UAN Number</td>
					<td><input type="text" name="uan" value="<%= emp.getUanNo() %>" style="border:none" readonly="readonly"></td>
				</tr>
				<tr>	
					<td>Date of joing</td>
					<td><input type="text" name="doj" value="<%= emp.getDoj() %>" style="border:none" readonly="readonly"></td>
				</tr>
				<tr>	
					<td>Designation</td>
					<td><input type="text" name="desg" value="<%= emp.getDesignation() %>" style="border:none" readonly="readonly"></td>
				</tr>
				<tr>	
					<td>Role</td>
					<td><input type="text" name="role" value="<%= emp.getRole() %>" style="border:none" readonly="readonly"></td>
				</tr>
				<tr>	
					<td>Address</td>
					<td><input type="text" name="addrs" value="<%= emp.getAddress() %>" readonly="readonly" style="border:none"></td>
				</tr>
				<tr>	
					<td>Date of birth</td>
					<td><input type="text" name="dob" value="<%= emp.getDob() %>" readonly="readonly" style="border:none"></td>
				</tr>
				<tr>	
					<td>Qualification</td>
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
	<%-- <portlet:param name="EmpNO" value="<%=empNO %>"/> --%>
	<portlet:param name="jspPage" value="/EmployeeDashboard.jsp"/>
</portlet:renderURL>

  <aui:button type="submit" onClick="<%=dashboardURL %>" value="Back"/>
  