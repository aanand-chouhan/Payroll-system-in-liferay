<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.vy.payroll.service.AdvanceSalaryRecordLocalServiceUtil"%>
<%@page import="com.vy.payroll.service.LeaveRequestLocalServiceUtil"%>

<head>
  <title>Payroll System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  <link rel = "stylesheet" type = "text/css" href = "css/style.css" />
</head>


<portlet:renderURL var="registerURL">
<portlet:param name="jspPage" value="/registration.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="loginURL">
<portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewEmpURL">
<portlet:param name="jspPage" value="/viewEmployee.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewRequestURL">
<portlet:param name="jspPage" value="/viewRequest.jsp"/>
</portlet:renderURL>
<%	String isRequestChecked="no";
	int notify=AdvanceSalaryRecordLocalServiceUtil.isRequestViewed(isRequestChecked);
	int leaveRequest=LeaveRequestLocalServiceUtil.isRequestViewed(isRequestChecked);
	LeaveRequestLocalServiceUtil.updateRequestViewed();
%>
<script>
   		function requestCame(){
    	    document.getElementById("notification").innerHTML="<%=notify%>";
    }
   	 	function requestViewed(){
   	 		document.getElementById("notification").innerHTML="";
    }
   	 function leaveRequestCame(){
 	    document.getElementById("notification").innerHTML="<%=leaveRequest%>";
 }
 </script>
			<c:if test="<%=notify != 0 %>">
				<script type="text/javascript">
					requestCame(); 
 				</script>
			</c:if> 
			<c:if test="<%=leaveRequest != 0 %>">
				<script type="text/javascript">
				leaveRequestCame(); 
 				</script>
			</c:if> 
			
			
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="http://www.vidyayug.com/"><img src="/o/custom-module/image/logo.png" alt="logo"></a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="<%=registerURL%>" >Add New Employee</a></li>
      <li><a href="<%=viewEmpURL%>">view Employee</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
			<li>
				<a href="<%=viewRequestURL%>" onclick="requestViewed()" data-toggle="tooltip" title="notification">
					<span class="glyphicon glyphicon-bell"></span> 
					<span class="badge" id="notification" style="color: black; background-color: white; padding: 0px 0px 0px 0px; margin-top: -7px;"></span>
				</a>
		   </li>
			<li>
				<a href="<%=loginURL%>" data-toggle="tooltip" title="logout" class="logout"><span class="glyphicon glyphicon-log-out"></span></a>
			</li>
		</ul>
  </div>
</nav>
  
<div class="container"  style="margin-top:50px">
  <div class="row">
  	<div class="colo-md-12">
  		<h1>Payroll management system</h1>
  		<h3>Admin dashboard</h3>
  	</div>
  
  </div>
</div>
<footer>
	<div class="navbar-header">
      <a class="navbar-brand" href="http://www.vidyayug.com/">Vidhyayug</a>
    </div>
    
</footer>

<script>
$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip();   
});
</script>
    