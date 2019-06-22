<%@ include file="/init.jsp" %>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
 <%@ page import="com.vy.payroll.service.DocumentLocalServiceUtil" %>
 <%@ page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="com.vy.payroll.model.Document" %>

 
 <%long empNo=(Long)session.getAttribute("EmpNO"); 
 	String eno=String.valueOf(empNo);
 	
 	int count= DocumentLocalServiceUtil.getDocumentsCount() ;
 	List<Document> documents=DocumentLocalServiceUtil.findByDocumentEmpId(empNo);
 	
   
 	//out.print(documents);
 %>
 <%
 int id=Integer.valueOf(eno);
 int result = DocumentLocalServiceUtil.updateDocsReview(id);
 %>
 <liferay-ui:search-container emptyResultsMessage="There is no data to display">
    <liferay-ui:search-container-results
        results="<%=ListUtil.subList(documents,searchContainer.getStart(),searchContainer.getEnd())%>" />
 
    <liferay-ui:search-container-row
        className="com.vy.payroll.model.Document"  modelVar="doc">
 
        <portlet:resourceURL var="viewURL">
            <portlet:param name="dataId" value="<%=eno%>" />
            <portlet:param name="docId" value="${doc.docId}" />
        </portlet:resourceURL>
         
        <liferay-ui:search-container-column-text value="<%=String.valueOf(row.getPos() + 1)%>" name="Serial No" />
        <liferay-ui:search-container-column-text  href="<%=viewURL.toString() %>" property="name" name="File Name"  />
        <liferay-ui:search-container-column-text   property="docId" name="Doc ID"  />
 		
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<portlet:renderURL var="dashboardURL">
	<portlet:param name="jspPage" value="/EmployeeDashboard.jsp"/>
</portlet:renderURL>

  <aui:button type="submit" onClick="<%=dashboardURL %>" value="Back"/>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  