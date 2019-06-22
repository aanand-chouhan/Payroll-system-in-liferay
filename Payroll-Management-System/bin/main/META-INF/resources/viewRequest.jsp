<%@page import="com.vy.payroll.service.LeaveRequestLocalServiceUtil"%>
<%@page import="com.vy.payroll.service.AdvanceSalaryRecordLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
  <%@ page import="com.vy.payroll.service.AdvanceSalaryRecordLocalServiceUtil" %>
 <%@ page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
 <%@ page import="com.vy.payroll.model.AdvanceSalaryRecord" %>
 <%@ page import="com.vy.payroll.model.LeaveRequest" %>
 
 <%
 	String isViewed="no";
 	int count= AdvanceSalaryRecordLocalServiceUtil.getAdvanceSalaryRecordsCount();
 	List<AdvanceSalaryRecord> advSalrequest=AdvanceSalaryRecordLocalServiceUtil.getAdvanceSalaryRecords(0,count);
 	int end=LeaveRequestLocalServiceUtil.getLeaveRequestsCount();
 	List<LeaveRequest> leaveRequest=LeaveRequestLocalServiceUtil.getLeaveRequests(0,end);
 	AdvanceSalaryRecordLocalServiceUtil.updateRequestIsChecked();
 %>
 
 <h3>Advance Salary Request</h3>
  <liferay-ui:search-container emptyResultsMessage="There is no Request to display">
    <liferay-ui:search-container-results
        results="<%=ListUtil.subList(advSalrequest,searchContainer.getStart(),searchContainer.getEnd())%>" />
 
    <liferay-ui:search-container-row className="com.vy.payroll.model.AdvanceSalaryRecord"  modelVar="req">
		<liferay-ui:search-container-column-text name="Employee id" property="eid"/>
		<liferay-ui:search-container-column-text name="Request no" property="request_id"/>
		<liferay-ui:search-container-column-text name="Reason" property="reason"/>
		<liferay-ui:search-container-column-date name="Date" property="date"/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>


<h3>Leave Request</h3>
<liferay-ui:search-container emptyResultsMessage="There is no Request to display" >
    <liferay-ui:search-container-results results="<%=ListUtil.subList(leaveRequest,searchContainer.getStart(),searchContainer.getEnd())%>" />
    <liferay-ui:search-container-row className="com.vy.payroll.model.LeaveRequest"  modelVar="req"  > 
		<liferay-ui:search-container-column-text name="Employee id" property="eid"/>
		<liferay-ui:search-container-column-text name="Request no" property="request_id"/>
		<liferay-ui:search-container-column-text name="Reason" property="reason"/>
		<liferay-ui:search-container-column-date name="Date" property="date"/>
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<portlet:renderURL var="dashboardURL">
	<portlet:param name="jspPage" value="/dashboard.jsp"/>
</portlet:renderURL>

  <aui:button type="submit" onClick="<%=dashboardURL %>" value="Back"/>