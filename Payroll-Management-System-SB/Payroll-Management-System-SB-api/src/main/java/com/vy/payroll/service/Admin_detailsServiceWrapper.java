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

package com.vy.payroll.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Admin_detailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see Admin_detailsService
 * @generated
 */
@ProviderType
public class Admin_detailsServiceWrapper implements Admin_detailsService,
	ServiceWrapper<Admin_detailsService> {
	public Admin_detailsServiceWrapper(
		Admin_detailsService admin_detailsService) {
		_admin_detailsService = admin_detailsService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _admin_detailsService.getOSGiServiceIdentifier();
	}

	@Override
	public Admin_detailsService getWrappedService() {
		return _admin_detailsService;
	}

	@Override
	public void setWrappedService(Admin_detailsService admin_detailsService) {
		_admin_detailsService = admin_detailsService;
	}

	private Admin_detailsService _admin_detailsService;
}