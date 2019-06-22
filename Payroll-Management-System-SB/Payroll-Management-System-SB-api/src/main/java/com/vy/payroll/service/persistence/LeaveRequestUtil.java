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

package com.vy.payroll.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.vy.payroll.model.LeaveRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the leave request service. This utility wraps {@link com.vy.payroll.service.persistence.impl.LeaveRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequestPersistence
 * @see com.vy.payroll.service.persistence.impl.LeaveRequestPersistenceImpl
 * @generated
 */
@ProviderType
public class LeaveRequestUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LeaveRequest leaveRequest) {
		getPersistence().clearCache(leaveRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveRequest update(LeaveRequest leaveRequest) {
		return getPersistence().update(leaveRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveRequest update(LeaveRequest leaveRequest,
		ServiceContext serviceContext) {
		return getPersistence().update(leaveRequest, serviceContext);
	}

	/**
	* Caches the leave request in the entity cache if it is enabled.
	*
	* @param leaveRequest the leave request
	*/
	public static void cacheResult(LeaveRequest leaveRequest) {
		getPersistence().cacheResult(leaveRequest);
	}

	/**
	* Caches the leave requests in the entity cache if it is enabled.
	*
	* @param leaveRequests the leave requests
	*/
	public static void cacheResult(List<LeaveRequest> leaveRequests) {
		getPersistence().cacheResult(leaveRequests);
	}

	/**
	* Creates a new leave request with the primary key. Does not add the leave request to the database.
	*
	* @param request_id the primary key for the new leave request
	* @return the new leave request
	*/
	public static LeaveRequest create(int request_id) {
		return getPersistence().create(request_id);
	}

	/**
	* Removes the leave request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request that was removed
	* @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	*/
	public static LeaveRequest remove(int request_id)
		throws com.vy.payroll.exception.NoSuchLeaveRequestException {
		return getPersistence().remove(request_id);
	}

	public static LeaveRequest updateImpl(LeaveRequest leaveRequest) {
		return getPersistence().updateImpl(leaveRequest);
	}

	/**
	* Returns the leave request with the primary key or throws a {@link NoSuchLeaveRequestException} if it could not be found.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request
	* @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	*/
	public static LeaveRequest findByPrimaryKey(int request_id)
		throws com.vy.payroll.exception.NoSuchLeaveRequestException {
		return getPersistence().findByPrimaryKey(request_id);
	}

	/**
	* Returns the leave request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request, or <code>null</code> if a leave request with the primary key could not be found
	*/
	public static LeaveRequest fetchByPrimaryKey(int request_id) {
		return getPersistence().fetchByPrimaryKey(request_id);
	}

	public static java.util.Map<java.io.Serializable, LeaveRequest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the leave requests.
	*
	* @return the leave requests
	*/
	public static List<LeaveRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the leave requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave requests
	* @param end the upper bound of the range of leave requests (not inclusive)
	* @return the range of leave requests
	*/
	public static List<LeaveRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the leave requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave requests
	* @param end the upper bound of the range of leave requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leave requests
	*/
	public static List<LeaveRequest> findAll(int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the leave requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave requests
	* @param end the upper bound of the range of leave requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of leave requests
	*/
	public static List<LeaveRequest> findAll(int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the leave requests from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of leave requests.
	*
	* @return the number of leave requests
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LeaveRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LeaveRequestPersistence, LeaveRequestPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LeaveRequestPersistence.class);

		ServiceTracker<LeaveRequestPersistence, LeaveRequestPersistence> serviceTracker =
			new ServiceTracker<LeaveRequestPersistence, LeaveRequestPersistence>(bundle.getBundleContext(),
				LeaveRequestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}