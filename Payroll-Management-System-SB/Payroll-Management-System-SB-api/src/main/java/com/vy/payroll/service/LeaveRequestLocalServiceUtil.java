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
 * Provides the local service utility for LeaveRequest. This utility wraps
 * {@link com.vy.payroll.service.impl.LeaveRequestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequestLocalService
 * @see com.vy.payroll.service.base.LeaveRequestLocalServiceBaseImpl
 * @see com.vy.payroll.service.impl.LeaveRequestLocalServiceImpl
 * @generated
 */
@ProviderType
public class LeaveRequestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vy.payroll.service.impl.LeaveRequestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the leave request to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRequest the leave request
	* @return the leave request that was added
	*/
	public static com.vy.payroll.model.LeaveRequest addLeaveRequest(
		com.vy.payroll.model.LeaveRequest leaveRequest) {
		return getService().addLeaveRequest(leaveRequest);
	}

	/**
	* Creates a new leave request with the primary key. Does not add the leave request to the database.
	*
	* @param request_id the primary key for the new leave request
	* @return the new leave request
	*/
	public static com.vy.payroll.model.LeaveRequest createLeaveRequest(
		int request_id) {
		return getService().createLeaveRequest(request_id);
	}

	/**
	* Deletes the leave request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request that was removed
	* @throws PortalException if a leave request with the primary key could not be found
	*/
	public static com.vy.payroll.model.LeaveRequest deleteLeaveRequest(
		int request_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLeaveRequest(request_id);
	}

	/**
	* Deletes the leave request from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRequest the leave request
	* @return the leave request that was removed
	*/
	public static com.vy.payroll.model.LeaveRequest deleteLeaveRequest(
		com.vy.payroll.model.LeaveRequest leaveRequest) {
		return getService().deleteLeaveRequest(leaveRequest);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.vy.payroll.model.LeaveRequest fetchLeaveRequest(
		int request_id) {
		return getService().fetchLeaveRequest(request_id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the leave request with the primary key.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request
	* @throws PortalException if a leave request with the primary key could not be found
	*/
	public static com.vy.payroll.model.LeaveRequest getLeaveRequest(
		int request_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLeaveRequest(request_id);
	}

	/**
	* Returns a range of all the leave requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave requests
	* @param end the upper bound of the range of leave requests (not inclusive)
	* @return the range of leave requests
	*/
	public static java.util.List<com.vy.payroll.model.LeaveRequest> getLeaveRequests(
		int start, int end) {
		return getService().getLeaveRequests(start, end);
	}

	/**
	* Returns the number of leave requests.
	*
	* @return the number of leave requests
	*/
	public static int getLeaveRequestsCount() {
		return getService().getLeaveRequestsCount();
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

	public static int isRequestViewed(String isRequestChecked) {
		return getService().isRequestViewed(isRequestChecked);
	}

	/**
	* Updates the leave request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveRequest the leave request
	* @return the leave request that was updated
	*/
	public static com.vy.payroll.model.LeaveRequest updateLeaveRequest(
		com.vy.payroll.model.LeaveRequest leaveRequest) {
		return getService().updateLeaveRequest(leaveRequest);
	}

	public static int updateRequestViewed() {
		return getService().updateRequestViewed();
	}

	public static LeaveRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveRequestLocalService, LeaveRequestLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveRequestLocalService.class);

		ServiceTracker<LeaveRequestLocalService, LeaveRequestLocalService> serviceTracker =
			new ServiceTracker<LeaveRequestLocalService, LeaveRequestLocalService>(bundle.getBundleContext(),
				LeaveRequestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}