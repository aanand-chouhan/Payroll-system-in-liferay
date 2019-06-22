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

package com.vy.payroll.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import com.vy.payroll.model.LeaveRequest;
import com.vy.payroll.service.persistence.LeaveRequestPersistence;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveRequestFinderBaseImpl extends BasePersistenceImpl<LeaveRequest> {
	public LeaveRequestFinderBaseImpl() {
		setModelClass(LeaveRequest.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("date", "date_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getLeaveRequestPersistence().getBadColumnNames();
	}

	/**
	 * Returns the leave request persistence.
	 *
	 * @return the leave request persistence
	 */
	public LeaveRequestPersistence getLeaveRequestPersistence() {
		return leaveRequestPersistence;
	}

	/**
	 * Sets the leave request persistence.
	 *
	 * @param leaveRequestPersistence the leave request persistence
	 */
	public void setLeaveRequestPersistence(
		LeaveRequestPersistence leaveRequestPersistence) {
		this.leaveRequestPersistence = leaveRequestPersistence;
	}

	@BeanReference(type = LeaveRequestPersistence.class)
	protected LeaveRequestPersistence leaveRequestPersistence;
	private static final Log _log = LogFactoryUtil.getLog(LeaveRequestFinderBaseImpl.class);
}