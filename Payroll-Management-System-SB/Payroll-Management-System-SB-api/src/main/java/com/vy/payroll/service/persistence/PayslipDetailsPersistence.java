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

import com.vy.payroll.exception.NoSuchPayslipDetailsException;
import com.vy.payroll.model.PayslipDetails;

/**
 * The persistence interface for the payslip details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.persistence.impl.PayslipDetailsPersistenceImpl
 * @see PayslipDetailsUtil
 * @generated
 */
@ProviderType
public interface PayslipDetailsPersistence extends BasePersistence<PayslipDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayslipDetailsUtil} to access the payslip details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the payslip detailses where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @return the matching payslip detailses
	*/
	public java.util.List<PayslipDetails> findByMonthId(int month, String eid);

	/**
	* Returns a range of all the payslip detailses where month = &#63; and eid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param month the month
	* @param eid the eid
	* @param start the lower bound of the range of payslip detailses
	* @param end the upper bound of the range of payslip detailses (not inclusive)
	* @return the range of matching payslip detailses
	*/
	public java.util.List<PayslipDetails> findByMonthId(int month, String eid,
		int start, int end);

	/**
	* Returns an ordered range of all the payslip detailses where month = &#63; and eid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param month the month
	* @param eid the eid
	* @param start the lower bound of the range of payslip detailses
	* @param end the upper bound of the range of payslip detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching payslip detailses
	*/
	public java.util.List<PayslipDetails> findByMonthId(int month, String eid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator);

	/**
	* Returns an ordered range of all the payslip detailses where month = &#63; and eid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param month the month
	* @param eid the eid
	* @param start the lower bound of the range of payslip detailses
	* @param end the upper bound of the range of payslip detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching payslip detailses
	*/
	public java.util.List<PayslipDetails> findByMonthId(int month, String eid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payslip details
	* @throws NoSuchPayslipDetailsException if a matching payslip details could not be found
	*/
	public PayslipDetails findByMonthId_First(int month, String eid,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator)
		throws NoSuchPayslipDetailsException;

	/**
	* Returns the first payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payslip details, or <code>null</code> if a matching payslip details could not be found
	*/
	public PayslipDetails fetchByMonthId_First(int month, String eid,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator);

	/**
	* Returns the last payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payslip details
	* @throws NoSuchPayslipDetailsException if a matching payslip details could not be found
	*/
	public PayslipDetails findByMonthId_Last(int month, String eid,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator)
		throws NoSuchPayslipDetailsException;

	/**
	* Returns the last payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payslip details, or <code>null</code> if a matching payslip details could not be found
	*/
	public PayslipDetails fetchByMonthId_Last(int month, String eid,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator);

	/**
	* Returns the payslip detailses before and after the current payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param ctcId the primary key of the current payslip details
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next payslip details
	* @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	*/
	public PayslipDetails[] findByMonthId_PrevAndNext(long ctcId, int month,
		String eid,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator)
		throws NoSuchPayslipDetailsException;

	/**
	* Removes all the payslip detailses where month = &#63; and eid = &#63; from the database.
	*
	* @param month the month
	* @param eid the eid
	*/
	public void removeByMonthId(int month, String eid);

	/**
	* Returns the number of payslip detailses where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @return the number of matching payslip detailses
	*/
	public int countByMonthId(int month, String eid);

	/**
	* Caches the payslip details in the entity cache if it is enabled.
	*
	* @param payslipDetails the payslip details
	*/
	public void cacheResult(PayslipDetails payslipDetails);

	/**
	* Caches the payslip detailses in the entity cache if it is enabled.
	*
	* @param payslipDetailses the payslip detailses
	*/
	public void cacheResult(java.util.List<PayslipDetails> payslipDetailses);

	/**
	* Creates a new payslip details with the primary key. Does not add the payslip details to the database.
	*
	* @param ctcId the primary key for the new payslip details
	* @return the new payslip details
	*/
	public PayslipDetails create(long ctcId);

	/**
	* Removes the payslip details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ctcId the primary key of the payslip details
	* @return the payslip details that was removed
	* @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	*/
	public PayslipDetails remove(long ctcId)
		throws NoSuchPayslipDetailsException;

	public PayslipDetails updateImpl(PayslipDetails payslipDetails);

	/**
	* Returns the payslip details with the primary key or throws a {@link NoSuchPayslipDetailsException} if it could not be found.
	*
	* @param ctcId the primary key of the payslip details
	* @return the payslip details
	* @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	*/
	public PayslipDetails findByPrimaryKey(long ctcId)
		throws NoSuchPayslipDetailsException;

	/**
	* Returns the payslip details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ctcId the primary key of the payslip details
	* @return the payslip details, or <code>null</code> if a payslip details with the primary key could not be found
	*/
	public PayslipDetails fetchByPrimaryKey(long ctcId);

	@Override
	public java.util.Map<java.io.Serializable, PayslipDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the payslip detailses.
	*
	* @return the payslip detailses
	*/
	public java.util.List<PayslipDetails> findAll();

	/**
	* Returns a range of all the payslip detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payslip detailses
	* @param end the upper bound of the range of payslip detailses (not inclusive)
	* @return the range of payslip detailses
	*/
	public java.util.List<PayslipDetails> findAll(int start, int end);

	/**
	* Returns an ordered range of all the payslip detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payslip detailses
	* @param end the upper bound of the range of payslip detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of payslip detailses
	*/
	public java.util.List<PayslipDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator);

	/**
	* Returns an ordered range of all the payslip detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payslip detailses
	* @param end the upper bound of the range of payslip detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of payslip detailses
	*/
	public java.util.List<PayslipDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayslipDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the payslip detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of payslip detailses.
	*
	* @return the number of payslip detailses
	*/
	public int countAll();
}