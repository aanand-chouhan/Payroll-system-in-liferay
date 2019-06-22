<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>

<portlet:renderURL var="registerURL">
<portlet:param name="jspPage" value="/registration.jsp"/>
</portlet:renderURL>
<%
	PortletURL loginURL = renderResponse.createActionURL();
	loginURL.setParameter(ActionRequest.ACTION_NAME, "isValidUserLogin");
%>

<aui:form name="fm" method="POST" action="<%=loginURL.toString()%>">
	<aui:input name="uName" label="user name" />
	<aui:input name="pwd" type="password" label="password"/>
	<aui:button-row>
            <aui:button type="submit" value="login"/>
            <aui:button type="submit" onClick="<%=registerURL%>" value="click to register"/>
    </aui:button-row>
</aui:form>
<a href="<%=registerURL%>">click to register</a>