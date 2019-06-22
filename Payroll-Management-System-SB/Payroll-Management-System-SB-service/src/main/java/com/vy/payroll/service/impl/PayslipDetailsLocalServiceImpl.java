/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.vy.payroll.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.vy.payroll.model.PayslipDetails;
import com.vy.payroll.service.base.PayslipDetailsLocalServiceBaseImpl;
import com.vy.payroll.service.persistence.PayslipDetailsUtil;

/**
 * The implementation of the payslip details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vy.payroll.service.PayslipDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayslipDetailsLocalServiceBaseImpl
 * @see com.vy.payroll.service.PayslipDetailsLocalServiceUtil
 */
public class PayslipDetailsLocalServiceImpl
	extends PayslipDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.vy.payroll.service.PayslipDetailsLocalServiceUtil} to access the payslip details local service.
	 */
	public  List<PayslipDetails> findByMonthId(int month, String eid) {
		return PayslipDetailsUtil.findByMonthId(month, eid);
	}

	
	
	/*public void htmlToJsp() {
		 try {
			 String url = new File("/ViewEmployeePayslip.jsp").toURI().toURL().toString();
			  OutputStream file = new FileOutputStream(new File("HTMLtoPDF.pdf"));
			  com.itextpdf.text.Document document = new com.itextpdf.text.Document();
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
		    
	}*/

}