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
 * Provides a wrapper for {@link LeaveRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequestLocalService
 * @generated
 */
@ProviderType
public class LeaveRequestLocalServiceWrapper implements LeaveRequestLocalService,
	ServiceWrapper<LeaveRequestLocalService> {
	public LeaveRequestLocalServiceWrapper(
		LeaveRequestLocalService leaveRequestLocalService) {
		_leaveRequestLocalService = leaveRequestLocalService;
	}

	/**
	* Adds the leave request to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRequest the leave request
	* @return the leave request that was added
	*/
	@Override
	public com.vy.payroll.model.LeaveRequest addLeaveRequest(
		com.vy.payroll.model.LeaveRequest leaveRequest) {
		return _leaveRequestLocalService.addLeaveRequest(leaveRequest);
	}

	/**
	* Creates a new leave request with the primary key. Does not add the leave request to the database.
	*
	* @param request_id the primary key for the new leave request
	* @return the new leave request
	*/
	@Override
	public com.vy.payroll.model.LeaveRequest createLeaveRequest(int request_id) {
		return _leaveRequestLocalService.createLeaveRequest(request_id);
	}

	/**
	* Deletes the leave request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request that was removed
	* @throws PortalException if a leave request with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.LeaveRequest deleteLeaveRequest(int request_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveRequestLocalService.deleteLeaveRequest(request_id);
	}

	/**
	* Deletes the leave request from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveRequest the leave request
	* @return the leave request that was removed
	*/
	@Override
	public com.vy.payroll.model.LeaveRequest deleteLeaveRequest(
		com.vy.payroll.model.LeaveRequest leaveRequest) {
		return _leaveRequestLocalService.deleteLeaveRequest(leaveRequest);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveRequestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveRequestLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _leaveRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _leaveRequestLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _leaveRequestLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _leaveRequestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _leaveRequestLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.vy.payroll.model.LeaveRequest fetchLeaveRequest(int request_id) {
		return _leaveRequestLocalService.fetchLeaveRequest(request_id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _leaveRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _leaveRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the leave request with the primary key.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request
	* @throws PortalException if a leave request with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.LeaveRequest getLeaveRequest(int request_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveRequestLocalService.getLeaveRequest(request_id);
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
	@Override
	public java.util.List<com.vy.payroll.model.LeaveRequest> getLeaveRequests(
		int start, int end) {
		return _leaveRequestLocalService.getLeaveRequests(start, end);
	}

	/**
	* Returns the number of leave requests.
	*
	* @return the number of leave requests
	*/
	@Override
	public int getLeaveRequestsCount() {
		return _leaveRequestLocalService.getLeaveRequestsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveRequestLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _leaveRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int isRequestViewed(String isRequestChecked) {
		return _leaveRequestLocalService.isRequestViewed(isRequestChecked);
	}

	/**
	* Updates the leave request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveRequest the leave request
	* @return the leave request that was updated
	*/
	@Override
	public com.vy.payroll.model.LeaveRequest updateLeaveRequest(
		com.vy.payroll.model.LeaveRequest leaveRequest) {
		return _leaveRequestLocalService.updateLeaveRequest(leaveRequest);
	}

	@Override
	public int updateRequestViewed() {
		return _leaveRequestLocalService.updateRequestViewed();
	}

	@Override
	public LeaveRequestLocalService getWrappedService() {
		return _leaveRequestLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveRequestLocalService leaveRequestLocalService) {
		_leaveRequestLocalService = leaveRequestLocalService;
	}

	private LeaveRequestLocalService _leaveRequestLocalService;
}