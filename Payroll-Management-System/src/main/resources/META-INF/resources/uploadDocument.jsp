<%@ include file="/init.jsp" %>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
 
 <%long empNo=(Long)session.getAttribute("EmpNO"); 
 	String eno=String.valueOf(empNo);
 %>
 
<portlet:actionURL name="uploadDocument" var="uploadDocURL" >
	<portlet:param name="eno" value="<%=eno %>"/>
</portlet:actionURL>
 <portlet:renderURL var="dashboardURL">
	<portlet:param name="jspPage" value="/EmployeeDashboard.jsp"/>
</portlet:renderURL>
 
<aui:form name="fm" action="<%=uploadDocURL.toString()%>" method="post" enctype="multipart/form-data">
    <aui:input name="document" type="file">
    	 <aui:validator name="acceptFiles">'pdf'</aui:validator>
    </aui:input>
    <aui:button type="submit" value="Upload" />
    <aui:button type="submit" onClick="<%=dashboardURL %>" value="Back"/>
</aui:form>



  
  