<%@page import="com.vy.payroll.service.DocumentLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletSession"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
 <%@ page import="com.vy.payroll.service.EmployeeDetailsLocalServiceUtil"%>
 <%@ page import="com.vy.payroll.model.EmployeeDetails"%>
 <%@ page import="java.sql.Blob"%>
<%@ page import="javax.xml.bind.DatatypeConverter"%>
<head>
  <title>Payroll System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	 <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>


 
<style>
	body {
    height: 100%;
    background-color: #daddde;
}
</style>
 <%   
   long employeeNo=(Long)session.getAttribute("EmpNO");
   int eno=(int)employeeNo;
  //String empNO=String.valueOf(employeeNo);
  // out.print(empNo);
  	%>
		<%
			//int isDocReviewed=(Integer)session.getAttribute("isDocReviewedStatus");
			int isDocReviewed=DocumentLocalServiceUtil.isDocReviewed(eno);
			EmployeeDetails emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetails(employeeNo);
			//out.print(emp.getImage());
			Blob blob= emp.getImage();
			int myblobLength = (int) blob.length();  
			byte[] myblobAsBytes = blob.getBytes(1, myblobLength);
			String image = DatatypeConverter.printBase64Binary(myblobAsBytes); 
			String eName=emp.getEName();
			String eRole=emp.getRole();
			
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

<header>
<div class="wrapper">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
    	<div class="toggle-button" >
				<span></span>
				<span></span>
				<span></span>
		</div>
   		 <div id="sidebar">
			<div class="sidebar-header">
				<div class="user-pic">
					<img class="mr-3 mt-3 rounded-circle "	src="data:image/jpeg;base64,<%=image %>" alt="User picture">
				</div>
				<div class="user-info">
						<span class="user-name" ><strong><%=eName %></strong></span><br>
						<span class="user-role"><%=eRole %></span> 
						<span class="user-status"> <i class="fa fa-circle"></i> <span>Online</span>
						</span>
				</div>
			
			</div>
				
				<ul id="sideMenu" class="nav navbar-nav">
					 <li ><a href="<%=viewEmployeeURL %>" >View Profile</a></li>
      			   	 <li><a href="<%=viewPayslipURL %>">View Payslip</a></li>
      				 <li><a href="<%=uploadDocURL %>">Upload document</a></li>
     				 <li><a href="<%=viewDocURL %>" onclick="setDocReview()">View document<span class="badge" id="notification" style="color:black;background-color:white"></span></a></li>
     				 <li><a href="<%=sendRequestURL %>" onclick="setDocReview()">Send Request<span class="badge" id="notification" style="color:black;background-color:white"></span></a></li>
      
				</ul>
		 </div>	
	
    <ul class="nav navbar-nav navbar-right">
      <li class="logout"><a href="<%=logoutURl %>" data-toggle="tooltip" title="logout"><span class="glyphicon glyphicon-log-out"></span></a></li>
    </ul>
   </div>
</nav>
</header>
<script type="text/javascript">
	/* function togglesidebar(){
		document.getElementById("sidebar").classList.toggle('active');
	} */
	$('document').ready(function(){
		$('[data-toggle="tooltip"]').tooltip();
		$('#sidebar').hide();
		$('.toggle-button').click(function(){
			$('#sidebar').toggle(50);
		});
	});
</script>




