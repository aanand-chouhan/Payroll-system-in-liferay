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

import com.vy.payroll.model.Admin_details;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the admin_details service. This utility wraps {@link com.vy.payroll.service.persistence.impl.Admin_detailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Admin_detailsPersistence
 * @see com.vy.payroll.service.persistence.impl.Admin_detailsPersistenceImpl
 * @generated
 */
@ProviderType
public class Admin_detailsUtil {
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
	public static void clearCache(Admin_details admin_details) {
		getPersistence().clearCache(admin_details);
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
	public static List<Admin_details> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Admin_details> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Admin_details> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Admin_details> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Admin_details update(Admin_details admin_details) {
		return getPersistence().update(admin_details);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Admin_details update(Admin_details admin_details,
		ServiceContext serviceContext) {
		return getPersistence().update(admin_details, serviceContext);
	}

	/**
	* Returns all the admin_detailses where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @return the matching admin_detailses
	*/
	public static List<Admin_details> findByUNameId(String userName,
		String password) {
		return getPersistence().findByUNameId(userName, password);
	}

	/**
	* Returns a range of all the admin_detailses where userName = &#63; and password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param password the password
	* @param start the lower bound of the range of admin_detailses
	* @param end the upper bound of the range of admin_detailses (not inclusive)
	* @return the range of matching admin_detailses
	*/
	public static List<Admin_details> findByUNameId(String userName,
		String password, int start, int end) {
		return getPersistence().findByUNameId(userName, password, start, end);
	}

	/**
	* Returns an ordered range of all the admin_detailses where userName = &#63; and password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param password the password
	* @param start the lower bound of the range of admin_detailses
	* @param end the upper bound of the range of admin_detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching admin_detailses
	*/
	public static List<Admin_details> findByUNameId(String userName,
		String password, int start, int end,
		OrderByComparator<Admin_details> orderByComparator) {
		return getPersistence()
				   .findByUNameId(userName, password, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the admin_detailses where userName = &#63; and password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param password the password
	* @param start the lower bound of the range of admin_detailses
	* @param end the upper bound of the range of admin_detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching admin_detailses
	*/
	public static List<Admin_details> findByUNameId(String userName,
		String password, int start, int end,
		OrderByComparator<Admin_details> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUNameId(userName, password, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin_details
	* @throws NoSuchAdmin_detailsException if a matching admin_details could not be found
	*/
	public static Admin_details findByUNameId_First(String userName,
		String password, OrderByComparator<Admin_details> orderByComparator)
		throws com.vy.payroll.exception.NoSuchAdmin_detailsException {
		return getPersistence()
				   .findByUNameId_First(userName, password, orderByComparator);
	}

	/**
	* Returns the first admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin_details, or <code>null</code> if a matching admin_details could not be found
	*/
	public static Admin_details fetchByUNameId_First(String userName,
		String password, OrderByComparator<Admin_details> orderByComparator) {
		return getPersistence()
				   .fetchByUNameId_First(userName, password, orderByComparator);
	}

	/**
	* Returns the last admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin_details
	* @throws NoSuchAdmin_detailsException if a matching admin_details could not be found
	*/
	public static Admin_details findByUNameId_Last(String userName,
		String password, OrderByComparator<Admin_details> orderByComparator)
		throws com.vy.payroll.exception.NoSuchAdmin_detailsException {
		return getPersistence()
				   .findByUNameId_Last(userName, password, orderByComparator);
	}

	/**
	* Returns the last admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin_details, or <code>null</code> if a matching admin_details could not be found
	*/
	public static Admin_details fetchByUNameId_Last(String userName,
		String password, OrderByComparator<Admin_details> orderByComparator) {
		return getPersistence()
				   .fetchByUNameId_Last(userName, password, orderByComparator);
	}

	/**
	* Returns the admin_detailses before and after the current admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param admin_id the primary key of the current admin_details
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin_details
	* @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	*/
	public static Admin_details[] findByUNameId_PrevAndNext(int admin_id,
		String userName, String password,
		OrderByComparator<Admin_details> orderByComparator)
		throws com.vy.payroll.exception.NoSuchAdmin_detailsException {
		return getPersistence()
				   .findByUNameId_PrevAndNext(admin_id, userName, password,
			orderByComparator);
	}

	/**
	* Removes all the admin_detailses where userName = &#63; and password = &#63; from the database.
	*
	* @param userName the user name
	* @param password the password
	*/
	public static void removeByUNameId(String userName, String password) {
		getPersistence().removeByUNameId(userName, password);
	}

	/**
	* Returns the number of admin_detailses where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @return the number of matching admin_detailses
	*/
	public static int countByUNameId(String userName, String password) {
		return getPersistence().countByUNameId(userName, password);
	}

	/**
	* Caches the admin_details in the entity cache if it is enabled.
	*
	* @param admin_details the admin_details
	*/
	public static void cacheResult(Admin_details admin_details) {
		getPersistence().cacheResult(admin_details);
	}

	/**
	* Caches the admin_detailses in the entity cache if it is enabled.
	*
	* @param admin_detailses the admin_detailses
	*/
	public static void cacheResult(List<Admin_details> admin_detailses) {
		getPersistence().cacheResult(admin_detailses);
	}

	/**
	* Creates a new admin_details with the primary key. Does not add the admin_details to the database.
	*
	* @param admin_id the primary key for the new admin_details
	* @return the new admin_details
	*/
	public static Admin_details create(int admin_id) {
		return getPersistence().create(admin_id);
	}

	/**
	* Removes the admin_details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details that was removed
	* @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	*/
	public static Admin_details remove(int admin_id)
		throws com.vy.payroll.exception.NoSuchAdmin_detailsException {
		return getPersistence().remove(admin_id);
	}

	public static Admin_details updateImpl(Admin_details admin_details) {
		return getPersistence().updateImpl(admin_details);
	}

	/**
	* Returns the admin_details with the primary key or throws a {@link NoSuchAdmin_detailsException} if it could not be found.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details
	* @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	*/
	public static Admin_details findByPrimaryKey(int admin_id)
		throws com.vy.payroll.exception.NoSuchAdmin_detailsException {
		return getPersistence().findByPrimaryKey(admin_id);
	}

	/**
	* Returns the admin_details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details, or <code>null</code> if a admin_details with the primary key could not be found
	*/
	public static Admin_details fetchByPrimaryKey(int admin_id) {
		return getPersistence().fetchByPrimaryKey(admin_id);
	}

	public static java.util.Map<java.io.Serializable, Admin_details> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the admin_detailses.
	*
	* @return the admin_detailses
	*/
	public static List<Admin_details> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the admin_detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin_detailses
	* @param end the upper bound of the range of admin_detailses (not inclusive)
	* @return the range of admin_detailses
	*/
	public static List<Admin_details> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the admin_detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin_detailses
	* @param end the upper bound of the range of admin_detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of admin_detailses
	*/
	public static List<Admin_details> findAll(int start, int end,
		OrderByComparator<Admin_details> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the admin_detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin_detailses
	* @param end the upper bound of the range of admin_detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of admin_detailses
	*/
	public static List<Admin_details> findAll(int start, int end,
		OrderByComparator<Admin_details> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the admin_detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of admin_detailses.
	*
	* @return the number of admin_detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static Admin_detailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Admin_detailsPersistence, Admin_detailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(Admin_detailsPersistence.class);

		ServiceTracker<Admin_detailsPersistence, Admin_detailsPersistence> serviceTracker =
			new ServiceTracker<Admin_detailsPersistence, Admin_detailsPersistence>(bundle.getBundleContext(),
				Admin_detailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}