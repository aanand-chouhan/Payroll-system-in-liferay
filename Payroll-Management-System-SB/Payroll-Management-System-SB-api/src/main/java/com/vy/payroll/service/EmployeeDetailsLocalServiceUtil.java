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
 * Provides the local service utility for EmployeeDetails. This utility wraps
 * {@link com.vy.payroll.service.impl.EmployeeDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsLocalService
 * @see com.vy.payroll.service.base.EmployeeDetailsLocalServiceBaseImpl
 * @see com.vy.payroll.service.impl.EmployeeDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
public class EmployeeDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vy.payroll.service.impl.EmployeeDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the employee details to the database. Also notifies the appropriate model listeners.
	*
	* @param employeeDetails the employee details
	* @return the employee details that was added
	*/
	public static com.vy.payroll.model.EmployeeDetails addEmployeeDetails(
		com.vy.payroll.model.EmployeeDetails employeeDetails) {
		return getService().addEmployeeDetails(employeeDetails);
	}

	/**
	* Creates a new employee details with the primary key. Does not add the employee details to the database.
	*
	* @param eno the primary key for the new employee details
	* @return the new employee details
	*/
	public static com.vy.payroll.model.EmployeeDetails createEmployeeDetails(
		long eno) {
		return getService().createEmployeeDetails(eno);
	}

	/**
	* Deletes the employee details from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeDetails the employee details
	* @return the employee details that was removed
	*/
	public static com.vy.payroll.model.EmployeeDetails deleteEmployeeDetails(
		com.vy.payroll.model.EmployeeDetails employeeDetails) {
		return getService().deleteEmployeeDetails(employeeDetails);
	}

	/**
	* Deletes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eno the primary key of the employee details
	* @return the employee details that was removed
	* @throws PortalException if a employee details with the primary key could not be found
	*/
	public static com.vy.payroll.model.EmployeeDetails deleteEmployeeDetails(
		long eno) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEmployeeDetails(eno);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.vy.payroll.model.EmployeeDetails fetchEmployeeDetails(
		long eno) {
		return getService().fetchEmployeeDetails(eno);
	}

	public static java.util.List<com.vy.payroll.model.EmployeeDetails> findByEmailPwd(
		String email, String password) {
		return getService().findByEmailPwd(email, password);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the employee details with the primary key.
	*
	* @param eno the primary key of the employee details
	* @return the employee details
	* @throws PortalException if a employee details with the primary key could not be found
	*/
	public static com.vy.payroll.model.EmployeeDetails getEmployeeDetails(
		long eno) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEmployeeDetails(eno);
	}

	/**
	* Returns a range of all the employee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee detailses
	* @param end the upper bound of the range of employee detailses (not inclusive)
	* @return the range of employee detailses
	*/
	public static java.util.List<com.vy.payroll.model.EmployeeDetails> getEmployeeDetailses(
		int start, int end) {
		return getService().getEmployeeDetailses(start, end);
	}

	/**
	* Returns the number of employee detailses.
	*
	* @return the number of employee detailses
	*/
	public static int getEmployeeDetailsesCount() {
		return getService().getEmployeeDetailsesCount();
	}

	public static String getImage(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			java.sql.SQLException, java.io.IOException {
		return getService().getImage(id);
	}

	public static com.vy.payroll.model.EmployeeDetailsImageBlobModel getImageBlobModel(
		java.io.Serializable primaryKey) {
		return getService().getImageBlobModel(primaryKey);
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
	* Updates the employee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employeeDetails the employee details
	* @return the employee details that was updated
	*/
	public static com.vy.payroll.model.EmployeeDetails updateEmployeeDetails(
		com.vy.payroll.model.EmployeeDetails employeeDetails) {
		return getService().updateEmployeeDetails(employeeDetails);
	}

	public static EmployeeDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeDetailsLocalService, EmployeeDetailsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeDetailsLocalService.class);

		ServiceTracker<EmployeeDetailsLocalService, EmployeeDetailsLocalService> serviceTracker =
			new ServiceTracker<EmployeeDetailsLocalService, EmployeeDetailsLocalService>(bundle.getBundleContext(),
				EmployeeDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}