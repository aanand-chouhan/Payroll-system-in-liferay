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

import com.vy.payroll.model.AdvanceSalaryRecord;
import com.vy.payroll.service.base.AdvanceSalaryRecordLocalServiceBaseImpl;
import com.vy.payroll.service.persistence.AdvanceSalaryRecordUtil;

/**
 * The implementation of the advance salary record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vy.payroll.service.AdvanceSalaryRecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdvanceSalaryRecordLocalServiceBaseImpl
 * @see com.vy.payroll.service.AdvanceSalaryRecordLocalServiceUtil
 */
public class AdvanceSalaryRecordLocalServiceImpl
	extends AdvanceSalaryRecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.vy.payroll.service.AdvanceSalaryRecordLocalServiceUtil} to access the advance salary record local service.
	 */
	
	public  List<AdvanceSalaryRecord> findByIsChecked(String is_checked) {
		return AdvanceSalaryRecordUtil.findByIsChecked(is_checked);
		
	}
	
	public int isRequestViewed(String isRequestChecked) {
		return advanceSalaryRecordFinder.isRequestViewed(isRequestChecked);
	}
	
	
	public int updateRequestIsChecked() {
		return advanceSalaryRecordFinder.updateRequestIsChecked();
	}
	
	public List<Object[]> getAdvanceSalAndLeaveReqData(){
		return advanceSalaryRecordFinder.AdvanceSalAndLeaveReqData();
	}
}