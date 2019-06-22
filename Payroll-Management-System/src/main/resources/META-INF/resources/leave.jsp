<%@ include file="/init.jsp" %>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
 
  <% String eid=(String)session.getAttribute("EmpID"); %>
 <portlet:actionURL name="leaveRequest" var="applyleaveReqURL">
 	<portlet:param name="eid" value="<%=eid %>"/>
 </portlet:actionURL>
 
 <portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/sendRequest.jsp"/>
</portlet:renderURL>
 

<aui:form action="<%= applyleaveReqURL %>" method="post" name="fm" >
	<aui:input type="text" autoSize="true" name="reason" label="Reason"/>
	<aui:button type="submit" value="send"/>
	  <aui:button type="submit" onClick="<%=backURL %>" value="Back"/>
</aui:form>