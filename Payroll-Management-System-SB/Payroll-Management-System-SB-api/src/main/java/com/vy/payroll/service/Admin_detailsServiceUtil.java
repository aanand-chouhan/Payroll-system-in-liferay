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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Admin_details. This utility wraps
 * {@link com.vy.payroll.service.impl.Admin_detailsServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see Admin_detailsService
 * @see com.vy.payroll.service.base.Admin_detailsServiceBaseImpl
 * @see com.vy.payroll.service.impl.Admin_detailsServiceImpl
 * @generated
 */
@ProviderType
public class Admin_detailsServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vy.payroll.service.impl.Admin_detailsServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Admin_detailsService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Admin_detailsService, Admin_detailsService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(Admin_detailsService.class);

		ServiceTracker<Admin_detailsService, Admin_detailsService> serviceTracker =
			new ServiceTracker<Admin_detailsService, Admin_detailsService>(bundle.getBundleContext(),
				Admin_detailsService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}