<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%-- <table class="table table-striped">
	<tr>
	<td>
		<div class="custom-file" class="container mt-3">
			<form action="uploaddocumenturl" method="POST"
				enctype="multipart/form-data">
				<input type="file" name="document" class="custom-file-input" id="customFile">
				  <label class="custom-file-label" for="customFile">upload documents</label>
				<!-- Enter document name::<input type="text" name ="docName"> -->
				//<input type="hidden" name="email" value="${memberEmail}"> 
				<button type="submit" class="btn btn-primary" >Upload</button>
			</form>
			</div>
		</td>
	</tr>
</table> --%>
<portlet:renderURL var="registerURL">
<portlet:param name="jspPage" value="/registration.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="loginURL">
<portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewEmpURL">
<portlet:param name="jspPage" value="/viewEmployee.jsp"/>
</portlet:renderURL>

<aui:button-row>
            <aui:button type="submit" value="Add New Employee" onClick="<%=registerURL%>"/>
            <aui:button type="submit" value="view Employee" onClick="<%=viewEmpURL%>"/>
            <aui:button type="submit" onClick="<%=loginURL %>" value="logout"/>
            
</aui:button-row>