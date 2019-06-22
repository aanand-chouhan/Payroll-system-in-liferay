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

import java.util.List;

import com.vy.payroll.model.Admin_details;
import com.vy.payroll.service.base.Admin_detailsLocalServiceBaseImpl;
import com.vy.payroll.service.persistence.Admin_detailsUtil;

/**
 * The implementation of the admin_details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vy.payroll.service.Admin_detailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Admin_detailsLocalServiceBaseImpl
 * @see com.vy.payroll.service.Admin_detailsLocalServiceUtil
 */
public class Admin_detailsLocalServiceImpl
	extends Admin_detailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.vy.payroll.service.Admin_detailsLocalServiceUtil} to access the admin_details local service.
	 */
	public  List<Admin_details> findByUNameId(String userName,
			String password) {
			return Admin_detailsUtil.findByUNameId(userName, password);
		}
	
}