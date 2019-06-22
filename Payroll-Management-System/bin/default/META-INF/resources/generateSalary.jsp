<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>


<portlet:renderURL var="backURL">
<portlet:param name="jspPage" value="/viewEmployee.jsp"/>
</portlet:renderURL>
	
	<%
	PortletURL generateSalaryURL = renderResponse.createActionURL();
generateSalaryURL.setParameter(ActionRequest.ACTION_NAME, "generateSalary");
%>


<%
	long eNo=Integer.parseInt(request.getParameter("eno"));
	String id=request.getParameter("eid");
	out.println("eid in update page"+id);
%>


<aui:form action="<%=generateSalaryURL.toString() %>" method="POST" name="<portlet:namespace/>frm">
	<aui:input type="text" name="ctc" lable="Enter CTC"/>
	<aui:select name="month">
		<aui:option value="0">select month</aui:option>
		<aui:option value="1">1</aui:option>
		<aui:option value="2">2</aui:option>
		<aui:option value="3">3</aui:option>
	</aui:select>
	<aui:input name="eid" type="hidden" value="<%= id %>"/>
	<aui:input name="eNo" type="hidden" value="<%= eNo %>"/>
	<aui:input name="extraId" type="hidden" value="<%=0 %>"/>
	<aui:button-row>
            <aui:button type="submit" value="Calculate"/>
            <aui:button type="submit" onClick="<%=backURL%>" value="Back"/>
    </aui:button-row>
</aui:form>