package com.vy.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.DocumentHelper;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vy.constants.PayrollManagementSystemPortletKeys;
import com.vy.payroll.model.Admin_details;
import com.vy.payroll.model.AdvanceSalaryRecord;
import com.vy.payroll.model.CtcDetail;
import com.vy.payroll.model.EmployeeDetails;
import com.vy.payroll.model.LeaveRequest;
import com.vy.payroll.model.PayslipDetails;
import com.vy.payroll.service.Admin_detailsLocalServiceUtil;
import com.vy.payroll.service.AdvanceSalaryRecordLocalServiceUtil;
import com.vy.payroll.service.CtcDetailLocalServiceUtil;
import com.vy.payroll.service.DocumentLocalServiceUtil;
import com.vy.payroll.service.EmployeeDetailsLocalServiceUtil;
import com.vy.payroll.service.LeaveRequestLocalServiceUtil;
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
		"com.liferay.portlet.header-portlet-css=/css/sidebar.css",
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
					HttpServletRequest uploadRequest  = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(req));
					HttpSession session=uploadRequest.getSession();
					uploadRequest.getServletContext().setAttribute("eNO", listEmp.get(0).getEno());
					
					PortletSession ses= req.getPortletSession();
					ses.setAttribute("EmpNO", listEmp.get(0).getEno(), ses.APPLICATION_SCOPE);
					ses.setAttribute("EmpID", listEmp.get(0).getEid(), ses.APPLICATION_SCOPE);

					req.setAttribute("eno",listEmp.get(0).getEno());
					req.setAttribute("eid",listEmp.get(0).getEid());
					
					res.setRenderParameter("jspPage","/EmployeeDashboard.jsp");
				}
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
	
	
	public void registerMember(ActionRequest req, ActionResponse res)  {
		String fileNameWithExt = null;
			OutputBlob blobData=null;
				UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
						fileNameWithExt = uploadRequest.getFileName("image");
							System.out.println("filename"+fileNameWithExt);
						File file=uploadRequest.getFile("image");
						InputStream inputStream=null;
						try {
							inputStream = new FileInputStream(file);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						 blobData = new OutputBlob(inputStream, file.length());
				
		        
		System.out.println("PayrollManagementSystemPortlet.registerMember()");
		String  name=ParamUtil.getString(req,"name");
		String 	email=ParamUtil.getString(req,"email");
		String 	pwd=ParamUtil.getString(req,"pwd");
		String 	panCardNo=ParamUtil.getString(req,"panCardNo");
		long 	adharCardNo=ParamUtil.getLong(req,"adharCardNo");
		long 	uanNo=ParamUtil.getLong(req,"uanNo");
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
		emp.setImage(blobData);
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
	
/*	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)  throws  IOException, PortletException {
		System.out.println("PayrollManagementSystemPortlet.serveResource()");
		 try {
			 PortletSession ses= resourceRequest.getPortletSession();
			  	long empNo=(Long)ses.getAttribute("EmpNO");
			  		long no=ParamUtil.getLong(resourceRequest, "empNO");
	        EmployeeDetails emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetails(no);
	       	Blob image=emp.getImage();
	      
	       System.out.println( image.getBinaryStream());
	       	
	       	InputStream inputStream = image.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			byte[] imageBytes = outputStream.toByteArray();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			inputStream.close();
			outputStream.close();
			
			resourceRequest.setAttribute("image",base64Image);
	           byte[ ] imgData = image.getBytes(1,(int)image.length());
	                    resourceResponse.setContentType("application/image");
	                    OutputStream o = resourceResponse.getPortletOutputStream();
	                    resourceRequest.setAttribute("image",imageBytes);
	                    o.write(imgData);
	                    o.flush();
	                    o.close();
	                    
	                    File outputFile = new File(emp.getImage());
	                    
	                    resourceResponse.setContentType("image/jpg");
	            		OutputStream out = resourceResponse.getPortletOutputStream();
	            		InputStream in = new FileInputStream(outputFile);
	            		IOUtils.copy(in, out);
	            		out.flush();
	       
	       
		}
		catch (Exception e) {
	        //_log.error(e);
		}
	}*/

	
	public void uploadDocument(ActionRequest req, ActionResponse res){
		
			long eno=ParamUtil.getLong(req,"eno");
			int is_uploaded=0;
			try {
				uploadDocsCommonMethod(req,eno,is_uploaded);
				res.setRenderParameter("jspPage","/EmployeeDashboard.jsp");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
	}
	
	
	public void sendDocument(ActionRequest req, ActionResponse res) {
		long eno=ParamUtil.getLong(req,"eno");
		int is_uploaded=ParamUtil.getInteger(req,"is_uploaded");
		try {
			uploadDocsCommonMethod(req,eno,is_uploaded);
			res.setRenderParameter("jspPage","/dashboard.jsp");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void uploadDocsCommonMethod(ActionRequest req,long eno,int is_uploaded) throws FileNotFoundException {

		/* PortalUtil.getUploadPortletRequest used for getting upload uploadRequest
           From the uploaded file get input stream */
		String fileName=null;
		UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(req);
		fileName=uploadRequest.getFileName("document");
		File file=uploadRequest.getFile("document");
		InputStream is=new FileInputStream(file);
		// Below is the actual blob data
		OutputBlob blob=new OutputBlob(is, file.length());
		long id=CounterLocalServiceUtil.increment(com.vy.payroll.model.Document.class.getName());
		com.vy.payroll.model.Document doc=DocumentLocalServiceUtil.createDocument(id);
		doc.setEno(eno);
		doc.setDocument(blob);
		doc.setMimeType(MimeTypesUtil.getContentType(file));
		doc.setName(fileName);
		doc.setIs_uploaded(is_uploaded);
		DocumentLocalServiceUtil.addDocument(doc);
	}
	
    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,
            PortletException {
    	int resourceId=ParamUtil.getInteger(resourceRequest, "resourceId");
    	int month=ParamUtil.getInteger(resourceRequest, "month");
		String eid=resourceRequest.getParameter("eid");
    	if(resourceId==1) {
    		//with the references
    		//https://www.mysamplecode.com/2012/10/java-servlet-example-generate-pdf-itext.html
    		//https://itextpdf.com/en/resources/examples/itext-5-legacy/render-data-table
    		
    		resourceResponse.setContentType("application/application-download");
    		resourceResponse.setProperty("Content-disposition","attachement; filename= Payslip.pdf");
	        OutputStream os = resourceResponse.getPortletOutputStream();
    		System.out.println("rid "+resourceId);
    		System.out.println("id "+eid);
    		System.out.println("month "+month);
    		System.out.println("PayrollManagementSystemPortlet.serveResource()");
    		//create document object
    		  Document document=new Document();
    		  try {
    			  PdfWriter.getInstance(document, os);
    			  document.open();
    			  //create table with 9 column
    			  PdfPTable table=new PdfPTable(9);
    			  table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    			  	  table.addCell("Employee id");
    		          table.addCell("HRA");
    		          table.addCell("CA");
    		          table.addCell("SA");
    		          table.addCell("TA");
    		          table.addCell("MA");
    		          table.addCell("Month");
    		          table.addCell("Income  tax");
    		          table.addCell("Basic Salary");
    			  table.setHeaderRows(1);
    			  table.setWidthPercentage(100);
    			 // table.setWidths(new float[] { 1,1,1,1,1,1,1,1,1});
    			  List<PayslipDetails> payslip=PayslipDetailsLocalServiceUtil.findByMonthId(month, eid);
    			  System.out.println(payslip);
    			  
    			  for (PayslipDetails pay:payslip){
    	        	  System.out.println("adding cells ");
    	    	     table.addCell(""+pay.getEid());
    	    	     table.addCell(""+pay.getHra());
    	    	     table.addCell(""+pay.getCa());
    	    	     table.addCell(""+pay.getSa());
    	    	     table.addCell(""+pay.getTa());
    	    	     table.addCell(""+pay.getMa());
    	    	     table.addCell(""+pay.getMonth());
    	             table.addCell(""+pay.getIncomeTax());
    	             table.addCell(""+pay.getBasicSalary());
    	          }
    			  	document.add(table);
    			  	//HTMLWorker htmlWorker = new HTMLWorker(document);
                    os.flush();
    		        document.close();
    		        resourceResponse.flushBuffer();
    		        os.close();
    			  
			} catch (DocumentException e) {
				e.printStackTrace();
			}
				
    	}//if
    
 
        try {
            long docId = ParamUtil.getLong(resourceRequest, "dataId");
            long docID = ParamUtil.getLong(resourceRequest, "docId");
            //com.vy.payroll.model.Document doc = DocumentLocalServiceUtil.fetchByEmpId(docId);
            com.vy.payroll.model.Document doc = DocumentLocalServiceUtil.getDocument(docID);
            System.out.println("docId"+docID);
            if (doc != null) {
                Blob blob = doc.getDocument();
                byte[] binaryData = blob.getBytes(1, (int) blob.length());
                // resourceResponse.setContentType(doc.getMimeType());
 
                resourceResponse.setContentType("application/application-download");
                resourceResponse.setProperty("Content-disposition","attachement; filename=" + doc.getName());
                OutputStream o = resourceResponse.getPortletOutputStream();
                o.write(binaryData);
                o.flush();
                o.close();
                resourceResponse.flushBuffer();
            }
 
        } catch (Exception e) {
 
        }
        
        
    }
    
    public void advanceSalaryRequest(ActionRequest req,ActionResponse res) {
    	String eid=ParamUtil.getString(req,"eid");
    	String reason=ParamUtil.getString(req,"reason");
    	System.out.println(eid);
    	int recordId=(int)CounterLocalServiceUtil.increment();
    	AdvanceSalaryRecord asr=AdvanceSalaryRecordLocalServiceUtil.createAdvanceSalaryRecord(recordId);
    	asr.setDate(new Date());
    	asr.setEid(eid);
    	asr.setIs_checked("no");
    	asr.setReason(reason);
    	AdvanceSalaryRecordLocalServiceUtil.addAdvanceSalaryRecord(asr);
    	res.setRenderParameter("jspPage","/sendRequest.jsp");
    }
	
    public void leaveRequest(ActionRequest req,ActionResponse res) {
    	String eid=ParamUtil.getString(req,"eid");
    	String reason=ParamUtil.getString(req,"reason");
    	System.out.println(eid);
    	int requestId=(int)CounterLocalServiceUtil.increment();
    	LeaveRequest request=LeaveRequestLocalServiceUtil.createLeaveRequest(requestId);
    	request.setDate(new Date());
    	request.setEid(eid);
    	request.setIs_checked("no");
    	request.setReason(reason);
    	LeaveRequestLocalServiceUtil.addLeaveRequest(request);
    	res.setRenderParameter("jspPage","/sendRequest.jsp");
    }
 
    
	public void downloadPDFpayslip(ActionRequest actionRequest,ActionResponse actionResponse)throws PortletException, IOException {
		
		//PayslipDetailsLocalServiceUtil.htmlToJsp();	System.out.println("PayrollManagementSystemPortlet.downloadPDFpayslip()");
		/* try {
			 String url = new File("/ViewEmployeePayslip.jsp").toURI().toURL().toString();
			  OutputStream file = new FileOutputStream(new File("HTMLtoPDF.pdf"));
			  Document document = new Document();
	            PdfWriter writer = PdfWriter.getInstance(document, file);
	            StringBuilder htmlString = new StringBuilder();
	            htmlString.append(new String("<html><body> This is HMTL to PDF conversion Example<table border='2' align='center'> "));
	            htmlString.append(new String("<tr><td>JavaCodeGeeks</td><td><a href='examples.javacodegeeks.com'>JavaCodeGeeks</a> </td></tr>"));               
	            htmlString.append(new String("<tr> <td> Google Here </td> <td><a href='www.google.com'>Google</a> </td> </tr></table></body></html>"));
	                             
	            document.open();
	            InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
	            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
	            document.close();
	            file.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
    */
		
}

	
	
	
}



















