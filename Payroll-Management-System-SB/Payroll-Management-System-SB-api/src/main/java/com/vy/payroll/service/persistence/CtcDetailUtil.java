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

import com.vy.payroll.model.CtcDetail;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ctc detail service. This utility wraps {@link com.vy.payroll.service.persistence.impl.CtcDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CtcDetailPersistence
 * @see com.vy.payroll.service.persistence.impl.CtcDetailPersistenceImpl
 * @generated
 */
@ProviderType
public class CtcDetailUtil {
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
	public static void clearCache(CtcDetail ctcDetail) {
		getPersistence().clearCache(ctcDetail);
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
	public static List<CtcDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CtcDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CtcDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CtcDetail> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CtcDetail update(CtcDetail ctcDetail) {
		return getPersistence().update(ctcDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CtcDetail update(CtcDetail ctcDetail,
		ServiceContext serviceContext) {
		return getPersistence().update(ctcDetail, serviceContext);
	}

	/**
	* Caches the ctc detail in the entity cache if it is enabled.
	*
	* @param ctcDetail the ctc detail
	*/
	public static void cacheResult(CtcDetail ctcDetail) {
		getPersistence().cacheResult(ctcDetail);
	}

	/**
	* Caches the ctc details in the entity cache if it is enabled.
	*
	* @param ctcDetails the ctc details
	*/
	public static void cacheResult(List<CtcDetail> ctcDetails) {
		getPersistence().cacheResult(ctcDetails);
	}

	/**
	* Creates a new ctc detail with the primary key. Does not add the ctc detail to the database.
	*
	* @param ctc the primary key for the new ctc detail
	* @return the new ctc detail
	*/
	public static CtcDetail create(int ctc) {
		return getPersistence().create(ctc);
	}

	/**
	* Removes the ctc detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ctc the primary key of the ctc detail
	* @return the ctc detail that was removed
	* @throws NoSuchCtcDetailException if a ctc detail with the primary key could not be found
	*/
	public static CtcDetail remove(int ctc)
		throws com.vy.payroll.exception.NoSuchCtcDetailException {
		return getPersistence().remove(ctc);
	}

	public static CtcDetail updateImpl(CtcDetail ctcDetail) {
		return getPersistence().updateImpl(ctcDetail);
	}

	/**
	* Returns the ctc detail with the primary key or throws a {@link NoSuchCtcDetailException} if it could not be found.
	*
	* @param ctc the primary key of the ctc detail
	* @return the ctc detail
	* @throws NoSuchCtcDetailException if a ctc detail with the primary key could not be found
	*/
	public static CtcDetail findByPrimaryKey(int ctc)
		throws com.vy.payroll.exception.NoSuchCtcDetailException {
		return getPersistence().findByPrimaryKey(ctc);
	}

	/**
	* Returns the ctc detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ctc the primary key of the ctc detail
	* @return the ctc detail, or <code>null</code> if a ctc detail with the primary key could not be found
	*/
	public static CtcDetail fetchByPrimaryKey(int ctc) {
		return getPersistence().fetchByPrimaryKey(ctc);
	}

	public static java.util.Map<java.io.Serializable, CtcDetail> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ctc details.
	*
	* @return the ctc details
	*/
	public static List<CtcDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ctc details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CtcDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ctc details
	* @param end the upper bound of the range of ctc details (not inclusive)
	* @return the range of ctc details
	*/
	public static List<CtcDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ctc details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CtcDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ctc details
	* @param end the upper bound of the range of ctc details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ctc details
	*/
	public static List<CtcDetail> findAll(int start, int end,
		OrderByComparator<CtcDetail> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ctc details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CtcDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ctc details
	* @param end the upper bound of the range of ctc details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ctc details
	*/
	public static List<CtcDetail> findAll(int start, int end,
		OrderByComparator<CtcDetail> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ctc details from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ctc details.
	*
	* @return the number of ctc details
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CtcDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CtcDetailPersistence, CtcDetailPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CtcDetailPersistence.class);

		ServiceTracker<CtcDetailPersistence, CtcDetailPersistence> serviceTracker =
			new ServiceTracker<CtcDetailPersistence, CtcDetailPersistence>(bundle.getBundleContext(),
				CtcDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}