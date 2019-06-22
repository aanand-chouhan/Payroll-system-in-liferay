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

import com.vy.payroll.model.AdvanceSalaryRecord;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the advance salary record service. This utility wraps {@link com.vy.payroll.service.persistence.impl.AdvanceSalaryRecordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdvanceSalaryRecordPersistence
 * @see com.vy.payroll.service.persistence.impl.AdvanceSalaryRecordPersistenceImpl
 * @generated
 */
@ProviderType
public class AdvanceSalaryRecordUtil {
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
	public static void clearCache(AdvanceSalaryRecord advanceSalaryRecord) {
		getPersistence().clearCache(advanceSalaryRecord);
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
	public static List<AdvanceSalaryRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdvanceSalaryRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdvanceSalaryRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AdvanceSalaryRecord update(
		AdvanceSalaryRecord advanceSalaryRecord) {
		return getPersistence().update(advanceSalaryRecord);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AdvanceSalaryRecord update(
		AdvanceSalaryRecord advanceSalaryRecord, ServiceContext serviceContext) {
		return getPersistence().update(advanceSalaryRecord, serviceContext);
	}

	/**
	* Returns all the advance salary records where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @return the matching advance salary records
	*/
	public static List<AdvanceSalaryRecord> findByIsChecked(String is_checked) {
		return getPersistence().findByIsChecked(is_checked);
	}

	/**
	* Returns a range of all the advance salary records where is_checked = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_checked the is_checked
	* @param start the lower bound of the range of advance salary records
	* @param end the upper bound of the range of advance salary records (not inclusive)
	* @return the range of matching advance salary records
	*/
	public static List<AdvanceSalaryRecord> findByIsChecked(String is_checked,
		int start, int end) {
		return getPersistence().findByIsChecked(is_checked, start, end);
	}

	/**
	* Returns an ordered range of all the advance salary records where is_checked = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_checked the is_checked
	* @param start the lower bound of the range of advance salary records
	* @param end the upper bound of the range of advance salary records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching advance salary records
	*/
	public static List<AdvanceSalaryRecord> findByIsChecked(String is_checked,
		int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		return getPersistence()
				   .findByIsChecked(is_checked, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the advance salary records where is_checked = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param is_checked the is_checked
	* @param start the lower bound of the range of advance salary records
	* @param end the upper bound of the range of advance salary records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching advance salary records
	*/
	public static List<AdvanceSalaryRecord> findByIsChecked(String is_checked,
		int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIsChecked(is_checked, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advance salary record
	* @throws NoSuchAdvanceSalaryRecordException if a matching advance salary record could not be found
	*/
	public static AdvanceSalaryRecord findByIsChecked_First(String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws com.vy.payroll.exception.NoSuchAdvanceSalaryRecordException {
		return getPersistence()
				   .findByIsChecked_First(is_checked, orderByComparator);
	}

	/**
	* Returns the first advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advance salary record, or <code>null</code> if a matching advance salary record could not be found
	*/
	public static AdvanceSalaryRecord fetchByIsChecked_First(
		String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		return getPersistence()
				   .fetchByIsChecked_First(is_checked, orderByComparator);
	}

	/**
	* Returns the last advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advance salary record
	* @throws NoSuchAdvanceSalaryRecordException if a matching advance salary record could not be found
	*/
	public static AdvanceSalaryRecord findByIsChecked_Last(String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws com.vy.payroll.exception.NoSuchAdvanceSalaryRecordException {
		return getPersistence()
				   .findByIsChecked_Last(is_checked, orderByComparator);
	}

	/**
	* Returns the last advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advance salary record, or <code>null</code> if a matching advance salary record could not be found
	*/
	public static AdvanceSalaryRecord fetchByIsChecked_Last(String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		return getPersistence()
				   .fetchByIsChecked_Last(is_checked, orderByComparator);
	}

	/**
	* Returns the advance salary records before and after the current advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param request_id the primary key of the current advance salary record
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next advance salary record
	* @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	*/
	public static AdvanceSalaryRecord[] findByIsChecked_PrevAndNext(
		int request_id, String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws com.vy.payroll.exception.NoSuchAdvanceSalaryRecordException {
		return getPersistence()
				   .findByIsChecked_PrevAndNext(request_id, is_checked,
			orderByComparator);
	}

	/**
	* Removes all the advance salary records where is_checked = &#63; from the database.
	*
	* @param is_checked the is_checked
	*/
	public static void removeByIsChecked(String is_checked) {
		getPersistence().removeByIsChecked(is_checked);
	}

	/**
	* Returns the number of advance salary records where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @return the number of matching advance salary records
	*/
	public static int countByIsChecked(String is_checked) {
		return getPersistence().countByIsChecked(is_checked);
	}

	/**
	* Caches the advance salary record in the entity cache if it is enabled.
	*
	* @param advanceSalaryRecord the advance salary record
	*/
	public static void cacheResult(AdvanceSalaryRecord advanceSalaryRecord) {
		getPersistence().cacheResult(advanceSalaryRecord);
	}

	/**
	* Caches the advance salary records in the entity cache if it is enabled.
	*
	* @param advanceSalaryRecords the advance salary records
	*/
	public static void cacheResult(
		List<AdvanceSalaryRecord> advanceSalaryRecords) {
		getPersistence().cacheResult(advanceSalaryRecords);
	}

	/**
	* Creates a new advance salary record with the primary key. Does not add the advance salary record to the database.
	*
	* @param request_id the primary key for the new advance salary record
	* @return the new advance salary record
	*/
	public static AdvanceSalaryRecord create(int request_id) {
		return getPersistence().create(request_id);
	}

	/**
	* Removes the advance salary record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the advance salary record
	* @return the advance salary record that was removed
	* @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	*/
	public static AdvanceSalaryRecord remove(int request_id)
		throws com.vy.payroll.exception.NoSuchAdvanceSalaryRecordException {
		return getPersistence().remove(request_id);
	}

	public static AdvanceSalaryRecord updateImpl(
		AdvanceSalaryRecord advanceSalaryRecord) {
		return getPersistence().updateImpl(advanceSalaryRecord);
	}

	/**
	* Returns the advance salary record with the primary key or throws a {@link NoSuchAdvanceSalaryRecordException} if it could not be found.
	*
	* @param request_id the primary key of the advance salary record
	* @return the advance salary record
	* @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	*/
	public static AdvanceSalaryRecord findByPrimaryKey(int request_id)
		throws com.vy.payroll.exception.NoSuchAdvanceSalaryRecordException {
		return getPersistence().findByPrimaryKey(request_id);
	}

	/**
	* Returns the advance salary record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param request_id the primary key of the advance salary record
	* @return the advance salary record, or <code>null</code> if a advance salary record with the primary key could not be found
	*/
	public static AdvanceSalaryRecord fetchByPrimaryKey(int request_id) {
		return getPersistence().fetchByPrimaryKey(request_id);
	}

	public static java.util.Map<java.io.Serializable, AdvanceSalaryRecord> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the advance salary records.
	*
	* @return the advance salary records
	*/
	public static List<AdvanceSalaryRecord> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the advance salary records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of advance salary records
	* @param end the upper bound of the range of advance salary records (not inclusive)
	* @return the range of advance salary records
	*/
	public static List<AdvanceSalaryRecord> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the advance salary records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of advance salary records
	* @param end the upper bound of the range of advance salary records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of advance salary records
	*/
	public static List<AdvanceSalaryRecord> findAll(int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the advance salary records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of advance salary records
	* @param end the upper bound of the range of advance salary records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of advance salary records
	*/
	public static List<AdvanceSalaryRecord> findAll(int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the advance salary records from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of advance salary records.
	*
	* @return the number of advance salary records
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AdvanceSalaryRecordPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AdvanceSalaryRecordPersistence, AdvanceSalaryRecordPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AdvanceSalaryRecordPersistence.class);

		ServiceTracker<AdvanceSalaryRecordPersistence, AdvanceSalaryRecordPersistence> serviceTracker =
			new ServiceTracker<AdvanceSalaryRecordPersistence, AdvanceSalaryRecordPersistence>(bundle.getBundleContext(),
				AdvanceSalaryRecordPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}