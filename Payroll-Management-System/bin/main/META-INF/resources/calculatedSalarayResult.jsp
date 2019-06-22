<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%PortletURL insertPayslipURL= renderResponse.createActionURL();
	insertPayslipURL.setParameter(ActionRequest.ACTION_NAME,"insertPayslipData");	
%>
<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/viewEmployee.jsp"/>
</portlet:renderURL>
<c:choose>

	<c:when test="${!empty calculatedSalary}">
		<aui:form method="POST" action="<%= insertPayslipURL.toString() %>" name="<portlet:namespace />fm">
			<aui:input name="id" type="text" value="${calculatedSalary.eid}" readonly="readonly" lable="ID"/>
			<aui:input name="CTC" type="text" value="${calculatedSalary.ctc}" readonly="readonly" lable="CTC"/>
			<aui:input name="ContributionAmount" type="text" value="${calculatedSalary.ca}" readonly="readonly" lable="Contribution Amount"/>
			<aui:input name="MedicalAllowance" type="text" value="${calculatedSalary.ma}" readonly="readonly" lable="Medical Allowance"/>
			<aui:input name="TravellingAllwance" type="text" value="${calculatedSalary.ta}" readonly="readonly" lable="Travelling allwance"/>
			<aui:input name="incomeTax" type="text" value="${calculatedSalary.incomeTax}" readonly="readonly" lable="Income Tax"/>
			<aui:input name="professionalTax" type="text" value="${calculatedSalary.proffesionalTax}" readonly="readonly" lable="Professional Tax"/>
			<aui:input name="gratuity" type="text" value="${calculatedSalary.gratuity}" readonly="readonly" lable="Gratuity"/>
			<aui:input name="grossSalary" type="text" value="${calculatedSalary.grossSalary}" readonly="readonly" lable="Gross Salary"/>
			<aui:input name="basicSalary" type="text" value="${calculatedSalary.basicSalary}" readonly="readonly" lable="Basic Salary"/>
			<aui:input name="SpecialAllowance" type="text" value="${calculatedSalary.sa}" readonly="readonly" lable="Special Allowance"/>
			<aui:input name="netSalary" type="text" value="${calculatedSalary.netSalary}" readonly="readonly" lable="Net Salary"/>
			<aui:input name="taxableAmt" type="text" value="${calculatedSalary.taxablAmt}" readonly="readonly" lable="Taxable Amount"/>
			<aui:input name="month" type="text" value="${calculatedSalary.month}" readonly="readonly" lable="Month" />
			<aui:input name="HouseRentalAllowance" type="text" value="${calculatedSalary.hra}" readonly="readonly" lable="House Rental Allowance"/>
			<aui:input name="ProvidentFund" type="text" value="${calculatedSalary.pf}" readonly="readonly" lable="Provident Fund"/>
		
	
	<aui:button-row>
            <aui:button type="submit" value="Save"/>
            <aui:button type="submit" onClick="<%=backURL %>" value="Back"/>
            
    </aui:button-row>

</aui:form>
	</c:when>
</c:choose>


