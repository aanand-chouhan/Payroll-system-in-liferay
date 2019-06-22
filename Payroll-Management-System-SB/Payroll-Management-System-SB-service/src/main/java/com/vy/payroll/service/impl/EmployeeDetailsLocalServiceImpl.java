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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.vy.payroll.model.EmployeeDetails;
import com.vy.payroll.service.EmployeeDetailsLocalServiceUtil;
import com.vy.payroll.service.base.EmployeeDetailsLocalServiceBaseImpl;
import com.vy.payroll.service.persistence.EmployeeDetailsUtil;

/**
 * The implementation of the employee details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vy.payroll.service.EmployeeDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsLocalServiceBaseImpl
 * @see com.vy.payroll.service.EmployeeDetailsLocalServiceUtil
 */
public class EmployeeDetailsLocalServiceImpl
	extends EmployeeDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.vy.payroll.service.EmployeeDetailsLocalServiceUtil} to access the employee details local service.
	 */
	
	public  List<EmployeeDetails> findByEmailPwd(String email,
			String password) {
			return EmployeeDetailsUtil.findByEmailPwd(email, password);
		}
	
	public String getImage(long id) throws PortalException, SQLException, IOException {
		System.out.println("EmployeeDetailsLocalServiceImpl.getImage()");
		 EmployeeDetails emp = EmployeeDetailsLocalServiceUtil.getEmployeeDetails(id);
	       	Blob image=emp.getImage();
	      
	      // System.out.println( image.getBinaryStream());
	       	
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
			System.out.println(base64Image);
			return base64Image;
	}
}