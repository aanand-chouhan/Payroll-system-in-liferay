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
 * Provides the local service utility for Admin_details. This utility wraps
 * {@link com.vy.payroll.service.impl.Admin_detailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Admin_detailsLocalService
 * @see com.vy.payroll.service.base.Admin_detailsLocalServiceBaseImpl
 * @see com.vy.payroll.service.impl.Admin_detailsLocalServiceImpl
 * @generated
 */
@ProviderType
public class Admin_detailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vy.payroll.service.impl.Admin_detailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the admin_details to the database. Also notifies the appropriate model listeners.
	*
	* @param admin_details the admin_details
	* @return the admin_details that was added
	*/
	public static com.vy.payroll.model.Admin_details addAdmin_details(
		com.vy.payroll.model.Admin_details admin_details) {
		return getService().addAdmin_details(admin_details);
	}

	/**
	* Creates a new admin_details with the primary key. Does not add the admin_details to the database.
	*
	* @param admin_id the primary key for the new admin_details
	* @return the new admin_details
	*/
	public static com.vy.payroll.model.Admin_details createAdmin_details(
		int admin_id) {
		return getService().createAdmin_details(admin_id);
	}

	/**
	* Deletes the admin_details from the database. Also notifies the appropriate model listeners.
	*
	* @param admin_details the admin_details
	* @return the admin_details that was removed
	*/
	public static com.vy.payroll.model.Admin_details deleteAdmin_details(
		com.vy.payroll.model.Admin_details admin_details) {
		return getService().deleteAdmin_details(admin_details);
	}

	/**
	* Deletes the admin_details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details that was removed
	* @throws PortalException if a admin_details with the primary key could not be found
	*/
	public static com.vy.payroll.model.Admin_details deleteAdmin_details(
		int admin_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAdmin_details(admin_id);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.vy.payroll.model.Admin_details fetchAdmin_details(
		int admin_id) {
		return getService().fetchAdmin_details(admin_id);
	}

	public static java.util.List<com.vy.payroll.model.Admin_details> findByUNameId(
		String userName, String password) {
		return getService().findByUNameId(userName, password);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the admin_details with the primary key.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details
	* @throws PortalException if a admin_details with the primary key could not be found
	*/
	public static com.vy.payroll.model.Admin_details getAdmin_details(
		int admin_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAdmin_details(admin_id);
	}

	/**
	* Returns a range of all the admin_detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin_detailses
	* @param end the upper bound of the range of admin_detailses (not inclusive)
	* @return the range of admin_detailses
	*/
	public static java.util.List<com.vy.payroll.model.Admin_details> getAdmin_detailses(
		int start, int end) {
		return getService().getAdmin_detailses(start, end);
	}

	/**
	* Returns the number of admin_detailses.
	*
	* @return the number of admin_detailses
	*/
	public static int getAdmin_detailsesCount() {
		return getService().getAdmin_detailsesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the admin_details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param admin_details the admin_details
	* @return the admin_details that was updated
	*/
	public static com.vy.payroll.model.Admin_details updateAdmin_details(
		com.vy.payroll.model.Admin_details admin_details) {
		return getService().updateAdmin_details(admin_details);
	}

	public static Admin_detailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Admin_detailsLocalService, Admin_detailsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(Admin_detailsLocalService.class);

		ServiceTracker<Admin_detailsLocalService, Admin_detailsLocalService> serviceTracker =
			new ServiceTracker<Admin_detailsLocalService, Admin_detailsLocalService>(bundle.getBundleContext(),
				Admin_detailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}