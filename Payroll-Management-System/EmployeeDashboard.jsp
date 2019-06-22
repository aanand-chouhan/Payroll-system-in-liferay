<%@page import="com.vy.payroll.service.DocumentLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletSession"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <title>Payroll System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>


 
<style>
	body {
    height: 100%;
    background-color: #daddde;
}
</style>
 <%   
   long empNo=(Long)session.getAttribute("EmpNO");
   int eno=(int)empNo;
  String empNO=String.valueOf(empNo);
  // out.print(empNo);
  	%>
		<%
		//int isDocReviewed=(Integer)session.getAttribute("isDocReviewedStatus");
			int isDocReviewed=DocumentLocalServiceUtil.isDocReviewed(eno);
		%>
		
  <script>
   		function isDocReview(){
    	    document.getElementById("notification").innerHTML="<%=isDocReviewed%>";
    }
   	 	function setDocReview(){
   	 		document.getElementById("notification").innerHTML="";
    }
 </script>
			<c:if test="<%=isDocReviewed != 0 %>">
				<script type="text/javascript">
					isDocReview(); 
 				</script>
			</c:if> 
		

<div id="body">

  	
<portlet:renderURL var="viewEmployeeURL">
	<%-- <portlet:param name="eno" value="<%=empNO %>"/> --%>
	<portlet:param name="jspPage" value="/EmployeeDetails.jsp"/>
	
</portlet:renderURL>
<portlet:renderURL var="viewPayslipURL">
	<%-- <portlet:param name="id" value="${eid }"/>
	<portlet:param name="eno" value="${eno }"/>
 --%>	<portlet:param name="jspPage" value="/EmployeePayslip.jsp"/>
	
</portlet:renderURL>
<portlet:renderURL var="logoutURl">
	<portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="sendRequestURL">
	<portlet:param name="jspPage" value="/sendRequest.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="uploadDocURL">
	<portlet:param name="jspPage" value="/uploadDocument.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="viewDocURL">
	<portlet:param name="jspPage" value="/viewDocument.jsp"/>
</portlet:renderURL>



<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="http://www.vidyayug.com/">Vidyayug</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="<%=viewEmployeeURL %>" >View Profile</a></li>
      <li><a href="<%=viewPayslipURL %>">View Payslip</a></li>
      <li><a href="<%=uploadDocURL %>">Upload document</a></li>
      <li><a href="<%=viewDocURL %>" onclick="setDocReview()">View document<span class="badge" id="notification" style="color:black;background-color:white"></span></a></li>
      <li><a href="<%=sendRequestURL %>" onclick="setDocReview()">Send Request<span class="badge" id="notification" style="color:black;background-color:white"></span></a></li>

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
  		<h2>Employee dashboard</h2>
  		<p>hello cick me</p>
  	</div>
  </div>
</div>

</div>





