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
			<aui:input name="id" type="text" placeholder="${calculatedSalary.eid}" readonly="readonly" lable="ID"/>
			<aui:input name="CTC" type="text" placeholder="${calculatedSalary.ctc}" readonly="readonly" lable="CTC"/>
			<aui:input name="ContributionAmount" type="text" placeholder="${calculatedSalary.ca}" readonly="readonly" lable="Contribution Amount"/>
			<aui:input name="MedicalAllowance" type="text" placeholder="${calculatedSalary.ma}" readonly="readonly" lable="Medical Allowance"/>
			<aui:input name="TravellingAllwance" type="text" placeholder="${calculatedSalary.ta}" readonly="readonly" lable="Travelling allwance"/>
			<aui:input name="incomeTax" type="text" placeholder="${calculatedSalary.incomeTax}" readonly="readonly" lable="Income Tax"/>
			<aui:input name="professionalTax" type="text" placeholder="${calculatedSalary.pf}" readonly="readonly" lable="Professional Tax"/>
			<aui:input name="gratuity" type="text" placeholder="${calculatedSalary.gratuity}" readonly="readonly" lable="Gratuity"/>
			<aui:input name="grossSalary" type="text" placeholder="${calculatedSalary.grossSalary}" readonly="readonly" lable="Gross Salary"/>
			<aui:input name="basicSalary" type="text" placeholder="${calculatedSalary.basicSalary}" readonly="readonly" lable="Basic Salary"/>
			<aui:input name="SpecialAllowance" type="text" placeholder="${calculatedSalary.sa}" readonly="readonly" lable="Special Allowance"/>
			<aui:input name="netSalary" type="text" placeholder="${calculatedSalary.netSalary}" readonly="readonly" lable="Net Salary"/>
			<aui:input name="taxableAmt" type="text" placeholder="${calculatedSalary.taxablAmt}" readonly="readonly" lable="Taxable Amount"/>
			<aui:input name="month" type="text" placeholder="${calculatedSalary.month}" readonly="readonly" lable="Month" />
			<aui:input name="HouseRentalAllowance" type="text" placeholder="${calculatedSalary.hra}" readonly="readonly" lable="House Rental Allowance"/>
			<aui:input name="ProvidentFund" type="text" placeholder="${calculatedSalary.pf}" readonly="readonly" lable="Provident Fund"/>
		
	
	<aui:button-row>
            <aui:button type="submit" value="Save"/>
            <aui:button type="submit" onClick="<%=backURL %>" value="Back"/>
            
    </aui:button-row>

</aui:form>
	</c:when>
</c:choose>


