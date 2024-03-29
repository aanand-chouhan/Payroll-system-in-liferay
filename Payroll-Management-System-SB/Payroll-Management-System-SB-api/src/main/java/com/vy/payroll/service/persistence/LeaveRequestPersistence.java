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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.vy.payroll.exception.NoSuchLeaveRequestException;
import com.vy.payroll.model.LeaveRequest;

/**
 * The persistence interface for the leave request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.persistence.impl.LeaveRequestPersistenceImpl
 * @see LeaveRequestUtil
 * @generated
 */
@ProviderType
public interface LeaveRequestPersistence extends BasePersistence<LeaveRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveRequestUtil} to access the leave request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the leave request in the entity cache if it is enabled.
	*
	* @param leaveRequest the leave request
	*/
	public void cacheResult(LeaveRequest leaveRequest);

	/**
	* Caches the leave requests in the entity cache if it is enabled.
	*
	* @param leaveRequests the leave requests
	*/
	public void cacheResult(java.util.List<LeaveRequest> leaveRequests);

	/**
	* Creates a new leave request with the primary key. Does not add the leave request to the database.
	*
	* @param request_id the primary key for the new leave request
	* @return the new leave request
	*/
	public LeaveRequest create(int request_id);

	/**
	* Removes the leave request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request that was removed
	* @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	*/
	public LeaveRequest remove(int request_id)
		throws NoSuchLeaveRequestException;

	public LeaveRequest updateImpl(LeaveRequest leaveRequest);

	/**
	* Returns the leave request with the primary key or throws a {@link NoSuchLeaveRequestException} if it could not be found.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request
	* @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	*/
	public LeaveRequest findByPrimaryKey(int request_id)
		throws NoSuchLeaveRequestException;

	/**
	* Returns the leave request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param request_id the primary key of the leave request
	* @return the leave request, or <code>null</code> if a leave request with the primary key could not be found
	*/
	public LeaveRequest fetchByPrimaryKey(int request_id);

	@Override
	public java.util.Map<java.io.Serializable, LeaveRequest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the leave requests.
	*
	* @return the leave requests
	*/
	public java.util.List<LeaveRequest> findAll();

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
	public java.util.List<LeaveRequest> findAll(int start, int end);

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
	public java.util.List<LeaveRequest> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveRequest> orderByComparator);

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
	public java.util.List<LeaveRequest> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the leave requests from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of leave requests.
	*
	* @return the number of leave requests
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}