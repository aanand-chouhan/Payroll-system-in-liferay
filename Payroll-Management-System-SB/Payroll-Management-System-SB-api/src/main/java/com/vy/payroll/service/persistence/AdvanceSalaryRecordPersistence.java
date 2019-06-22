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

import com.vy.payroll.exception.NoSuchAdvanceSalaryRecordException;
import com.vy.payroll.model.AdvanceSalaryRecord;

/**
 * The persistence interface for the advance salary record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.persistence.impl.AdvanceSalaryRecordPersistenceImpl
 * @see AdvanceSalaryRecordUtil
 * @generated
 */
@ProviderType
public interface AdvanceSalaryRecordPersistence extends BasePersistence<AdvanceSalaryRecord> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdvanceSalaryRecordUtil} to access the advance salary record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the advance salary records where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @return the matching advance salary records
	*/
	public java.util.List<AdvanceSalaryRecord> findByIsChecked(
		String is_checked);

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
	public java.util.List<AdvanceSalaryRecord> findByIsChecked(
		String is_checked, int start, int end);

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
	public java.util.List<AdvanceSalaryRecord> findByIsChecked(
		String is_checked, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator);

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
	public java.util.List<AdvanceSalaryRecord> findByIsChecked(
		String is_checked, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advance salary record
	* @throws NoSuchAdvanceSalaryRecordException if a matching advance salary record could not be found
	*/
	public AdvanceSalaryRecord findByIsChecked_First(String is_checked,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws NoSuchAdvanceSalaryRecordException;

	/**
	* Returns the first advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advance salary record, or <code>null</code> if a matching advance salary record could not be found
	*/
	public AdvanceSalaryRecord fetchByIsChecked_First(String is_checked,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator);

	/**
	* Returns the last advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advance salary record
	* @throws NoSuchAdvanceSalaryRecordException if a matching advance salary record could not be found
	*/
	public AdvanceSalaryRecord findByIsChecked_Last(String is_checked,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws NoSuchAdvanceSalaryRecordException;

	/**
	* Returns the last advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advance salary record, or <code>null</code> if a matching advance salary record could not be found
	*/
	public AdvanceSalaryRecord fetchByIsChecked_Last(String is_checked,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator);

	/**
	* Returns the advance salary records before and after the current advance salary record in the ordered set where is_checked = &#63;.
	*
	* @param request_id the primary key of the current advance salary record
	* @param is_checked the is_checked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next advance salary record
	* @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	*/
	public AdvanceSalaryRecord[] findByIsChecked_PrevAndNext(int request_id,
		String is_checked,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws NoSuchAdvanceSalaryRecordException;

	/**
	* Removes all the advance salary records where is_checked = &#63; from the database.
	*
	* @param is_checked the is_checked
	*/
	public void removeByIsChecked(String is_checked);

	/**
	* Returns the number of advance salary records where is_checked = &#63;.
	*
	* @param is_checked the is_checked
	* @return the number of matching advance salary records
	*/
	public int countByIsChecked(String is_checked);

	/**
	* Caches the advance salary record in the entity cache if it is enabled.
	*
	* @param advanceSalaryRecord the advance salary record
	*/
	public void cacheResult(AdvanceSalaryRecord advanceSalaryRecord);

	/**
	* Caches the advance salary records in the entity cache if it is enabled.
	*
	* @param advanceSalaryRecords the advance salary records
	*/
	public void cacheResult(
		java.util.List<AdvanceSalaryRecord> advanceSalaryRecords);

	/**
	* Creates a new advance salary record with the primary key. Does not add the advance salary record to the database.
	*
	* @param request_id the primary key for the new advance salary record
	* @return the new advance salary record
	*/
	public AdvanceSalaryRecord create(int request_id);

	/**
	* Removes the advance salary record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the advance salary record
	* @return the advance salary record that was removed
	* @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	*/
	public AdvanceSalaryRecord remove(int request_id)
		throws NoSuchAdvanceSalaryRecordException;

	public AdvanceSalaryRecord updateImpl(
		AdvanceSalaryRecord advanceSalaryRecord);

	/**
	* Returns the advance salary record with the primary key or throws a {@link NoSuchAdvanceSalaryRecordException} if it could not be found.
	*
	* @param request_id the primary key of the advance salary record
	* @return the advance salary record
	* @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	*/
	public AdvanceSalaryRecord findByPrimaryKey(int request_id)
		throws NoSuchAdvanceSalaryRecordException;

	/**
	* Returns the advance salary record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param request_id the primary key of the advance salary record
	* @return the advance salary record, or <code>null</code> if a advance salary record with the primary key could not be found
	*/
	public AdvanceSalaryRecord fetchByPrimaryKey(int request_id);

	@Override
	public java.util.Map<java.io.Serializable, AdvanceSalaryRecord> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the advance salary records.
	*
	* @return the advance salary records
	*/
	public java.util.List<AdvanceSalaryRecord> findAll();

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
	public java.util.List<AdvanceSalaryRecord> findAll(int start, int end);

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
	public java.util.List<AdvanceSalaryRecord> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator);

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
	public java.util.List<AdvanceSalaryRecord> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdvanceSalaryRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the advance salary records from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of advance salary records.
	*
	* @return the number of advance salary records
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}