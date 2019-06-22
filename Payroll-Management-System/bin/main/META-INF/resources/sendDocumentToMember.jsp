<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>


<% long eno=ParamUtil.getLong(request, "eno");
String eNO=String.valueOf(eno);
   out.print(eno);
%>


<portlet:actionURL name="sendDocument" var="sendDocURL" >
	<portlet:param name="eno" value="<%=eNO %>"/>
	<portlet:param name="is_uploaded" value="1"/>
</portlet:actionURL>
 <portlet:renderURL var="dashboardURL">
	<portlet:param name="jspPage" value="/dashboard.jsp"/>
</portlet:renderURL>
 
<aui:form name="fm" action="<%=sendDocURL.toString()%>" method="post" enctype="multipart/form-data">
    <aui:input name="document" type="file">
    	 <aui:validator name="acceptFiles">'pdf'</aui:validator>
    </aui:input>
    <aui:button type="submit" value="Upload" />
    <aui:button type="submit" onClick="<%=dashboardURL %>" value="Back"/>
</aui:form>
