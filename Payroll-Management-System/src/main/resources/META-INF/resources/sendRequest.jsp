<%@ include file="/init.jsp" %>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
 <head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>
 </head>
 <style>
	body {
    height: 100%;
    background-color: #daddde;
}
</style>
 
 <portlet:renderURL var="advanceSalURL">
 		<portlet:param name="jspPage" value="/advanceSalRequest.jsp"/>
 </portlet:renderURL>
 <portlet:renderURL var="leaveURL">
 		<portlet:param name="jspPage" value="/leave.jsp"/>
 </portlet:renderURL>
 <portlet:renderURL var="logoutURl">
	<portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>
 
 
 
 <nav class="navbar navbar-inverse">
 	<div class="container-fluid" >
 		<ul class="nav navbar-nav">
 			<li><a href="<%=advanceSalURL%>" > Apply For Advance Salary</a></li>
 			<li><a href="<%=leaveURL%>" > Apply For Leave</a></li>
 		</ul>
 		 <ul class="nav navbar-nav navbar-right">
      <li ><a href="<%=logoutURl %>">Log out</a></li>
    </ul>
 	</div>
 </nav>
 
 
<div class="container"  style="margin-top:50px">
  <div class="row">
  	<div class="colo-md-6">
		<h1>Payroll management system</h1>
  	</div>
  	<div class="colo-md-6">
  		<h2>sending requests</h2>
  	</div>
  </div>
</div>