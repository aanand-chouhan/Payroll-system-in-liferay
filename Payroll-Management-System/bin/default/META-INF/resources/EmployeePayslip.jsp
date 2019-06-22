<%@page import="com.vy.payroll.service.PayslipDetailsLocalServiceUtil"%>
<%@page import="com.vy.payroll.model.PayslipDetails"%>
<%@ include file="/init.jsp" %>
<%@ page import="com.vy.payroll.model.EmployeeDetails"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.vy.payroll.service.EmployeeDetailsLocalServiceUtil"%>
 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%
  	long eno=ParamUtil.getLong(request, "eno");
	PayslipDetails payslip=PayslipDetailsLocalServiceUtil.g	
%>