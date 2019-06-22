package com.vy.portlet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.vy.constants.PayrollManagementSystemPortletKeys;
import com.vy.payroll.model.Admin_details;
import com.vy.payroll.model.CtcDetail;
import com.vy.payroll.model.EmployeeDetails;
import com.vy.payroll.model.PayslipDetails;
import com.vy.payroll.service.Admin_detailsLocalServiceUtil;
import com.vy.payroll.service.CtcDetailLocalServiceUtil;
import com.vy.payroll.service.EmployeeDetailsLocalServiceUtil;
import com.vy.payroll.service.PayslipDetailsLocalServiceUtil;

/**
 * @author vidyayug
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PayrollManagementSystemPortletKeys.PayrollManagementSystem,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PayrollManagementSystemPortlet extends MVCPortlet {
	
	
	public void isValidUserLogin(ActionRequest req,ActionResponse res) {
		String uName=ParamUtil.getString(req,"uName");
		String pwd=ParamUtil.getString(req,"pwd");
		System.out.println(uName+" "+pwd);
		String userName=null,password=null;
		/*PortletRequestDispatcher ds=null;
		String path="/dashboard.jsp";*/
		if(uName.equals("admin@gmail.com")) {
			List<Admin_details> list=Admin_detailsLocalServiceUtil.findByUNameId(uName, pwd);
			System.out.println(list);
				for(Admin_details s:list) {
					System.out.println(userName=s.getUserName());
					System.out.println(password=s.getPassword());
				}//for
		 
				if(uName.equals(userName)&&pwd.equals(password)) {
				System.out.println("in if block");
				res.setRenderParameter("jspPage","/dashboard.jsp");
			  /*	ds=getPortletContext().getRequestDispatcher(path);
				try {
					ds.forward(req, res);
					System.out.println("in if after forward ");
				} catch (PortletException | IOException e) {
					e.printStackTrace();
				*/
				}//if
				
		}//if
			else {
				List<EmployeeDetails> listEmp=EmployeeDetailsLocalServiceUtil.findByEmailPwd(uName, pwd);
				if(uName.equals(listEmp.get(0).getEmail())&&pwd.equals(listEmp.get(0).getPassword())) {
					System.out.println("in else block");
					req.setAttribute("eno",listEmp.get(0).getEno());
					res.setRenderParameter("jspPage","/EmployeeDashboard.jsp");
				}
				/*
				 * ds=getPortletContext().getRequestDispatcher("/error.jsp");
			try {
				ds.forward(req, res);
				System.out.println("in else after forward ");
			} catch (PortletException | IOException e) {
				e.printStackTrace();
			}*/
			}
			}
			

	public void updateMember(ActionRequest req, ActionResponse res) {
		String  name=ParamUtil.getString(req,"name");
		String 	panCardNo=ParamUtil.getString(req,"panCardNo");
		String 	gender=ParamUtil.getString(req,"gender");
		String 	address=ParamUtil.getString(req,"address");
		String 	qualification=ParamUtil.getString(req,"qualification");
		String 	designation=ParamUtil.getString(req,"designation");
		String 	role=ParamUtil.getString(req,"role");
		long id=Long.parseLong(ParamUtil.getString(req, "eid"));
		System.out.println("id in update controller method : "+id);
		EmployeeDetails emp=null;
		try {
			emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetails(id);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emp.setAddress(address);
		emp.setPanCardNo(panCardNo);
		emp.setGender(gender);
		emp.setDesignation(designation);
		emp.setRole(role);
		emp.setQualificationS(qualification);
		emp.setEName(name);
		EmployeeDetailsLocalServiceUtil.updateEmployeeDetails(emp);
	}
	
	
	public void registerMember(ActionRequest req, ActionResponse res) {
		System.out.println("PayrollManagementSystemPortlet.registerMember()");
		String  name=ParamUtil.getString(req,"name");
		String 	email=ParamUtil.getString(req,"email");
		String 	pwd=ParamUtil.getString(req,"pwd");
		String 	panCardNo=ParamUtil.getString(req,"panCardNo");
		int 	adharCardNo=ParamUtil.getInteger(req,"adharCardNo");
		int 	uanNo=ParamUtil.getInteger(req,"uanNo");
		int 	mobileNo=ParamUtil.getInteger(req,"mobileNo");
		String 	gender=ParamUtil.getString(req,"gender");
		String 	dob=ParamUtil.getString(req,"dob");
		String 	doj=ParamUtil.getString(req,"doj");
		String 	designation=ParamUtil.getString(req,"designation");
		String 	address=ParamUtil.getString(req,"address");
		String 	role=ParamUtil.getString(req,"role");
		String 	qualification=ParamUtil.getString(req,"qualification");
		long id= CounterLocalServiceUtil.increment();
		EmployeeDetails emp=EmployeeDetailsLocalServiceUtil.createEmployeeDetails(id);
		
		emp.setEName(name);
		emp.setAddress(address);
		emp.setAdharCardNo(adharCardNo);
		emp.setDesignation(designation);
		emp.setDob(dateConversion(dob));
		emp.setRole(role);
		emp.setDoj(dateConversion(doj));
		emp.setEid("vy-"+id);
		emp.setEmail(email);
		//emp.setEno(101);
		emp.setGender(gender);
		emp.setMobileNo(mobileNo);
		emp.setPanCardNo(panCardNo);
		emp.setPassword(pwd);
		emp.setQualificationS(qualification);
		emp.setUanNo(uanNo);
		System.out.println(emp);
		emp= EmployeeDetailsLocalServiceUtil.addEmployeeDetails(emp);
			
	}
	//======================================= DATE CONVERSION =====================================================
	public java.sql.Date dateConversion(String date){
		SimpleDateFormat sdf1 = null;
		Date uDate = null;
		java.sql.Date sDate = null;
		long ms = 0;
		try 
	{
			// DATE OF conversion
			// convert date class obj to sql date classs obj
			sdf1 = new SimpleDateFormat("yyyy-mm-dd");
			if (date != null) {
				System.out.println("in doj before area");
				uDate = sdf1.parse(date);// gives java.util.Date class object
				System.out.println("in doj area");
			}
			if (uDate != null) {
				System.out.println("in before dob area");
				ms = uDate.getTime();
				System.out.println("in dob area");
			}
			// convert into sql date class object
			sDate = new java.sql.Date(ms);
			System.out.println("in doj area" + sDate);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return sDate;
	}// dateConversion
	
	//======================================= END DATE CONVERSION =====================================================
	
	//======================================= DELETE EMPLOYEE =====================================================
	public void deleteEmployee(ActionRequest req, ActionResponse res) {
		long id=ParamUtil.getLong(req,"eid");
		try {
			EmployeeDetailsLocalServiceUtil.deleteEmployeeDetails(id);
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
	//======================================= END DELETE EMPLOYEE =====================================================
	
	
	
	public void generateSalary(ActionRequest req, ActionResponse res) {
		int eTaxableAmt,eHRA,eMA,eTA,ePF,eCA,eSA,eIncomeTax=0,ePprofessionalTax,eBasicSalary,eGratuity,eNetSalary,eGrossSalary;
		
		String eId=ParamUtil.getString(req,"eid");
		long eNo=ParamUtil.getLong(req,"eNo");
		int eCTC=Integer.parseInt(ParamUtil.getString(req, "ctc"));
		int month=Integer.parseInt(ParamUtil.getString(req,"month"));
		CtcDetail ctcDetail=null;
		//List<PayslipDetails> listCTC=new ArrayList();
		int ctcId= (int) CounterLocalServiceUtil.increment();
		PayslipDetails payslip= PayslipDetailsLocalServiceUtil.createPayslipDetails(ctcId);
		try {
			 ctcDetail= CtcDetailLocalServiceUtil.getCtcDetail(eCTC);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		//=================	BASIC SALARY CALCULATION======================================
		
			eBasicSalary=(eCTC*ctcDetail.getBasicSalary())/100;
			System.out.println(ctcDetail.getBasicSalary());
			System.out.println("e basic salary "+eBasicSalary);
			ePF=(eBasicSalary*ctcDetail.getPf())/100;
			System.out.println(ctcDetail.getPf());
			System.out.println("Provident fund "+ePF);
			eGratuity=(eBasicSalary*ctcDetail.getGratuity())/100;
			System.out.println(ctcDetail.getGratuity());
			System.out.println("gratuity "+eGratuity);
			eHRA=(eBasicSalary*ctcDetail.getHra())/100;
			System.out.println(ctcDetail.getHra());
			System.out.println("HRA"+eHRA);
			eCA=ctcDetail.getCa();
			System.out.println("CA"+eCA);
			eMA=ctcDetail.getMa();
			System.out.println("MA "+eMA);
			eTA=ctcDetail.getTa();
			System.out.println("ta"+eTA);
			eSA=ctcDetail.getSa();
			System.out.println("sa"+eSA);
			ePprofessionalTax=ctcDetail.getProffesionalTax();
			System.out.println("pt"+ePprofessionalTax);
			eGrossSalary=eCTC-((eBasicSalary*ctcDetail.getContributionAmt())/100)-eGratuity;
			System.out.println("before contribution "+((eBasicSalary*ctcDetail.getContributionAmt()/100)));
			System.out.println("Contrbution "+(ctcDetail.getContributionAmt()));
			System.out.println("E gross Salary"+ eGrossSalary);
			eTaxableAmt=eGrossSalary-ePF-eCA-eHRA-eMA-eTA-eSA-ePprofessionalTax;
			System.out.println("taxable amount "+eTaxableAmt);
			if(eCTC<=250000) {
				eIncomeTax=0;
			System.out.println(eIncomeTax);
			}
			else if((eCTC>250000) && (eCTC<=500000)) {
			eIncomeTax=(eTaxableAmt*ctcDetail.getIncomeTax())/100;
			System.out.println("500000  "+ctcDetail.getIncomeTax());
			System.out.println("tax "+eIncomeTax);
			}//if
			else if((eCTC>500000) &&( eCTC<=1000000)) {
				eIncomeTax=(eTaxableAmt*(ctcDetail.getIncomeTax()+10))/100;
				System.out.println("1000000  "+eIncomeTax);
				System.out.println("tax"+eIncomeTax);
			}//else if
			
			eNetSalary=eGrossSalary-ePF-ePprofessionalTax;
			System.out.println("net salary "+eNetSalary);
		
			payslip.setCa(eCA);
			payslip.setCtc(eCTC);
			payslip.setEid(eId);
			payslip.setHra(eHRA);
			payslip.setMa(eMA);
			payslip.setIncomeTax(eIncomeTax);
			payslip.setTa(eTA);
			payslip.setSa(eSA);
			payslip.setPf(ePF);
			payslip.setNetSalary(eNetSalary);
			payslip.setTaxablAmt(eTaxableAmt);
			payslip.setGratuity(eGratuity);
			payslip.setGrossSalary(eGrossSalary);
			payslip.setProffesionalTax(ePprofessionalTax);
			payslip.setMonth(month);
			payslip.setBasicSalary(eBasicSalary);
			req.setAttribute("calculatedSalary",payslip);
			res.setRenderParameter("jspPage","/calculatedSalarayResult.jsp");
			
			
	}
	
	public void insertPayslipData(ActionRequest req, ActionResponse res){
		int ctcId= (int) CounterLocalServiceUtil.increment();
		PayslipDetails payslip= PayslipDetailsLocalServiceUtil.createPayslipDetails(ctcId);
		
		
		payslip.setEid(ParamUtil.getString(req,"id"));
		payslip.setCtc(Integer.parseInt(ParamUtil.getString(req, "CTC")));
		payslip.setMonth(Integer.parseInt(ParamUtil.getString(req,"month")));
		payslip.setMa(Integer.parseInt(ParamUtil.getString(req,"MedicalAllowance")));
		payslip.setCa(Integer.parseInt(ParamUtil.getString(req,"ContributionAmount")));
		payslip.setTa(Integer.parseInt(ParamUtil.getString(req,"TravellingAllwance")));
		payslip.setIncomeTax(Integer.parseInt(ParamUtil.getString(req,"incomeTax")));
		payslip.setProffesionalTax(Integer.parseInt(ParamUtil.getString(req,"professionalTax")));
		payslip.setGratuity(Integer.parseInt(ParamUtil.getString(req,"gratuity")));
		payslip.setGrossSalary(Integer.parseInt(ParamUtil.getString(req,"grossSalary")));
		payslip.setBasicSalary(Integer.parseInt(ParamUtil.getString(req,"basicSalary")));
		payslip.setSa(Integer.parseInt(ParamUtil.getString(req,"SpecialAllowance")));
		payslip.setNetSalary(Integer.parseInt(ParamUtil.getString(req,"netSalary")));
		payslip.setTaxablAmt(Integer.parseInt(ParamUtil.getString(req,"taxableAmt")));
		payslip.setHra(Integer.parseInt(ParamUtil.getString(req,"HouseRentalAllowance")));
		payslip.setPf(Integer.parseInt(ParamUtil.getString(req,"ProvidentFund")));
		
		payslip=PayslipDetailsLocalServiceUtil.addPayslipDetails(payslip);
		res.setRenderParameter("jspPage","/viewEmployee.jsp");
		System.out.println(payslip);
		
	}
	
	
	
}





















