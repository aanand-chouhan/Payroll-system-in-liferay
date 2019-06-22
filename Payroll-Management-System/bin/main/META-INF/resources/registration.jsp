<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>

<%
	PortletURL registerMemberURL = renderResponse.createActionURL();
registerMemberURL.setParameter(ActionRequest.ACTION_NAME, "registerMember");
%>

<portlet:renderURL var="loginURL">
<portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="action" var="actionURL" />


<aui:form method="POST" action="<%= registerMemberURL.toString() %>" name="<portlet:namespace />fm" enctype="multipart/form-data">
	<aui:input name="name" type="text">
		<aui:validator name="alpha"/>
	</aui:input>
	<aui:input name="email" type="email">
		 <aui:validator name="email"/>
	</aui:input>
	<aui:input name="pwd" type="password" />
	<aui:input name="panCardNo" type="text" />
	<aui:input name="adharCardNo" type="text">
		<aui:validator name="number"/>
		<aui:validator name="minLength">12</aui:validator>
		<aui:validator name="maxLength">12</aui:validator>
	</aui:input>
	<aui:input name="uanNo" type="text" >
		<aui:validator name="number"/>
		<aui:validator name="minLength">12</aui:validator>
		<aui:validator name="maxLength">12</aui:validator>
	</aui:input>
	<aui:input name="mobileNo" type="text">
		 <aui:validator name="number"/>
		 <aui:validator name="minLength">10</aui:validator>
		<aui:validator name="maxLength">10</aui:validator>
	</aui:input>
	<aui:input name="gender" type="radio" value="male" label="Male"  />
	<aui:input name="gender" type="radio" value="female" label="Female" />
	<aui:input name="dob" type="date" >
		 <aui:validator name="date"/>
	</aui:input>
	<aui:input name="doj" type="date">
			<aui:validator name="date"/>
	</aui:input>
	<aui:input name="designation" type="text" />
	<aui:input name="role" type="text" />
	<aui:input name="address" type="text" />
	<aui:input name="qualification" type="text" />
	<aui:input name="image" type="file" >
		 <aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
	</aui:input>
	
	<aui:button-row>
            <aui:button type="submit" value="Register"/>
            <aui:button type="submit" onClick="<%=loginURL %>" value="Back"/>
            
    </aui:button-row>

</aui:form>