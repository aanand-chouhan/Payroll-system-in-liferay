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

import com.vy.payroll.model.PayslipDetails;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the payslip details service. This utility wraps {@link com.vy.payroll.service.persistence.impl.PayslipDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayslipDetailsPersistence
 * @see com.vy.payroll.service.persistence.impl.PayslipDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class PayslipDetailsUtil {
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
	public static void clearCache(PayslipDetails payslipDetails) {
		getPersistence().clearCache(payslipDetails);
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
	public static List<PayslipDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PayslipDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PayslipDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PayslipDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PayslipDetails update(PayslipDetails payslipDetails) {
		return getPersistence().update(payslipDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PayslipDetails update(PayslipDetails payslipDetails,
		ServiceContext serviceContext) {
		return getPersistence().update(payslipDetails, serviceContext);
	}

	/**
	* Returns all the payslip detailses where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @return the matching payslip detailses
	*/
	public static List<PayslipDetails> findByMonthId(int month, String eid) {
		return getPersistence().findByMonthId(month, eid);
	}

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
	public static List<PayslipDetails> findByMonthId(int month, String eid,
		int start, int end) {
		return getPersistence().findByMonthId(month, eid, start, end);
	}

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
	public static List<PayslipDetails> findByMonthId(int month, String eid,
		int start, int end, OrderByComparator<PayslipDetails> orderByComparator) {
		return getPersistence()
				   .findByMonthId(month, eid, start, end, orderByComparator);
	}

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
	public static List<PayslipDetails> findByMonthId(int month, String eid,
		int start, int end,
		OrderByComparator<PayslipDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMonthId(month, eid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payslip details
	* @throws NoSuchPayslipDetailsException if a matching payslip details could not be found
	*/
	public static PayslipDetails findByMonthId_First(int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator)
		throws com.vy.payroll.exception.NoSuchPayslipDetailsException {
		return getPersistence()
				   .findByMonthId_First(month, eid, orderByComparator);
	}

	/**
	* Returns the first payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payslip details, or <code>null</code> if a matching payslip details could not be found
	*/
	public static PayslipDetails fetchByMonthId_First(int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator) {
		return getPersistence()
				   .fetchByMonthId_First(month, eid, orderByComparator);
	}

	/**
	* Returns the last payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payslip details
	* @throws NoSuchPayslipDetailsException if a matching payslip details could not be found
	*/
	public static PayslipDetails findByMonthId_Last(int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator)
		throws com.vy.payroll.exception.NoSuchPayslipDetailsException {
		return getPersistence().findByMonthId_Last(month, eid, orderByComparator);
	}

	/**
	* Returns the last payslip details in the ordered set where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payslip details, or <code>null</code> if a matching payslip details could not be found
	*/
	public static PayslipDetails fetchByMonthId_Last(int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator) {
		return getPersistence()
				   .fetchByMonthId_Last(month, eid, orderByComparator);
	}

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
	public static PayslipDetails[] findByMonthId_PrevAndNext(long ctcId,
		int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator)
		throws com.vy.payroll.exception.NoSuchPayslipDetailsException {
		return getPersistence()
				   .findByMonthId_PrevAndNext(ctcId, month, eid,
			orderByComparator);
	}

	/**
	* Removes all the payslip detailses where month = &#63; and eid = &#63; from the database.
	*
	* @param month the month
	* @param eid the eid
	*/
	public static void removeByMonthId(int month, String eid) {
		getPersistence().removeByMonthId(month, eid);
	}

	/**
	* Returns the number of payslip detailses where month = &#63; and eid = &#63;.
	*
	* @param month the month
	* @param eid the eid
	* @return the number of matching payslip detailses
	*/
	public static int countByMonthId(int month, String eid) {
		return getPersistence().countByMonthId(month, eid);
	}

	/**
	* Caches the payslip details in the entity cache if it is enabled.
	*
	* @param payslipDetails the payslip details
	*/
	public static void cacheResult(PayslipDetails payslipDetails) {
		getPersistence().cacheResult(payslipDetails);
	}

	/**
	* Caches the payslip detailses in the entity cache if it is enabled.
	*
	* @param payslipDetailses the payslip detailses
	*/
	public static void cacheResult(List<PayslipDetails> payslipDetailses) {
		getPersistence().cacheResult(payslipDetailses);
	}

	/**
	* Creates a new payslip details with the primary key. Does not add the payslip details to the database.
	*
	* @param ctcId the primary key for the new payslip details
	* @return the new payslip details
	*/
	public static PayslipDetails create(long ctcId) {
		return getPersistence().create(ctcId);
	}

	/**
	* Removes the payslip details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ctcId the primary key of the payslip details
	* @return the payslip details that was removed
	* @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	*/
	public static PayslipDetails remove(long ctcId)
		throws com.vy.payroll.exception.NoSuchPayslipDetailsException {
		return getPersistence().remove(ctcId);
	}

	public static PayslipDetails updateImpl(PayslipDetails payslipDetails) {
		return getPersistence().updateImpl(payslipDetails);
	}

	/**
	* Returns the payslip details with the primary key or throws a {@link NoSuchPayslipDetailsException} if it could not be found.
	*
	* @param ctcId the primary key of the payslip details
	* @return the payslip details
	* @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	*/
	public static PayslipDetails findByPrimaryKey(long ctcId)
		throws com.vy.payroll.exception.NoSuchPayslipDetailsException {
		return getPersistence().findByPrimaryKey(ctcId);
	}

	/**
	* Returns the payslip details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ctcId the primary key of the payslip details
	* @return the payslip details, or <code>null</code> if a payslip details with the primary key could not be found
	*/
	public static PayslipDetails fetchByPrimaryKey(long ctcId) {
		return getPersistence().fetchByPrimaryKey(ctcId);
	}

	public static java.util.Map<java.io.Serializable, PayslipDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the payslip detailses.
	*
	* @return the payslip detailses
	*/
	public static List<PayslipDetails> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PayslipDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PayslipDetails> findAll(int start, int end,
		OrderByComparator<PayslipDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PayslipDetails> findAll(int start, int end,
		OrderByComparator<PayslipDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the payslip detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of payslip detailses.
	*
	* @return the number of payslip detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PayslipDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PayslipDetailsPersistence, PayslipDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayslipDetailsPersistence.class);

		ServiceTracker<PayslipDetailsPersistence, PayslipDetailsPersistence> serviceTracker =
			new ServiceTracker<PayslipDetailsPersistence, PayslipDetailsPersistence>(bundle.getBundleContext(),
				PayslipDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}