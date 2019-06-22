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

import com.vy.payroll.model.EmployeeDetails;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the employee details service. This utility wraps {@link com.vy.payroll.service.persistence.impl.EmployeeDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsPersistence
 * @see com.vy.payroll.service.persistence.impl.EmployeeDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class EmployeeDetailsUtil {
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
	public static void clearCache(EmployeeDetails employeeDetails) {
		getPersistence().clearCache(employeeDetails);
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
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDetails update(EmployeeDetails employeeDetails) {
		return getPersistence().update(employeeDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDetails update(EmployeeDetails employeeDetails,
		ServiceContext serviceContext) {
		return getPersistence().update(employeeDetails, serviceContext);
	}

	/**
	* Returns all the employee detailses where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @return the matching employee detailses
	*/
	public static List<EmployeeDetails> findByEmailPwd(String email,
		String password) {
		return getPersistence().findByEmailPwd(email, password);
	}

	/**
	* Returns a range of all the employee detailses where email = &#63; and password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param password the password
	* @param start the lower bound of the range of employee detailses
	* @param end the upper bound of the range of employee detailses (not inclusive)
	* @return the range of matching employee detailses
	*/
	public static List<EmployeeDetails> findByEmailPwd(String email,
		String password, int start, int end) {
		return getPersistence().findByEmailPwd(email, password, start, end);
	}

	/**
	* Returns an ordered range of all the employee detailses where email = &#63; and password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param password the password
	* @param start the lower bound of the range of employee detailses
	* @param end the upper bound of the range of employee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching employee detailses
	*/
	public static List<EmployeeDetails> findByEmailPwd(String email,
		String password, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {
		return getPersistence()
				   .findByEmailPwd(email, password, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the employee detailses where email = &#63; and password = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param password the password
	* @param start the lower bound of the range of employee detailses
	* @param end the upper bound of the range of employee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching employee detailses
	*/
	public static List<EmployeeDetails> findByEmailPwd(String email,
		String password, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEmailPwd(email, password, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee details
	* @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	*/
	public static EmployeeDetails findByEmailPwd_First(String email,
		String password, OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.vy.payroll.exception.NoSuchEmployeeDetailsException {
		return getPersistence()
				   .findByEmailPwd_First(email, password, orderByComparator);
	}

	/**
	* Returns the first employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	*/
	public static EmployeeDetails fetchByEmailPwd_First(String email,
		String password, OrderByComparator<EmployeeDetails> orderByComparator) {
		return getPersistence()
				   .fetchByEmailPwd_First(email, password, orderByComparator);
	}

	/**
	* Returns the last employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee details
	* @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	*/
	public static EmployeeDetails findByEmailPwd_Last(String email,
		String password, OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.vy.payroll.exception.NoSuchEmployeeDetailsException {
		return getPersistence()
				   .findByEmailPwd_Last(email, password, orderByComparator);
	}

	/**
	* Returns the last employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	*/
	public static EmployeeDetails fetchByEmailPwd_Last(String email,
		String password, OrderByComparator<EmployeeDetails> orderByComparator) {
		return getPersistence()
				   .fetchByEmailPwd_Last(email, password, orderByComparator);
	}

	/**
	* Returns the employee detailses before and after the current employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param eno the primary key of the current employee details
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next employee details
	* @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	*/
	public static EmployeeDetails[] findByEmailPwd_PrevAndNext(long eno,
		String email, String password,
		OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.vy.payroll.exception.NoSuchEmployeeDetailsException {
		return getPersistence()
				   .findByEmailPwd_PrevAndNext(eno, email, password,
			orderByComparator);
	}

	/**
	* Removes all the employee detailses where email = &#63; and password = &#63; from the database.
	*
	* @param email the email
	* @param password the password
	*/
	public static void removeByEmailPwd(String email, String password) {
		getPersistence().removeByEmailPwd(email, password);
	}

	/**
	* Returns the number of employee detailses where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @return the number of matching employee detailses
	*/
	public static int countByEmailPwd(String email, String password) {
		return getPersistence().countByEmailPwd(email, password);
	}

	/**
	* Caches the employee details in the entity cache if it is enabled.
	*
	* @param employeeDetails the employee details
	*/
	public static void cacheResult(EmployeeDetails employeeDetails) {
		getPersistence().cacheResult(employeeDetails);
	}

	/**
	* Caches the employee detailses in the entity cache if it is enabled.
	*
	* @param employeeDetailses the employee detailses
	*/
	public static void cacheResult(List<EmployeeDetails> employeeDetailses) {
		getPersistence().cacheResult(employeeDetailses);
	}

	/**
	* Creates a new employee details with the primary key. Does not add the employee details to the database.
	*
	* @param eno the primary key for the new employee details
	* @return the new employee details
	*/
	public static EmployeeDetails create(long eno) {
		return getPersistence().create(eno);
	}

	/**
	* Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eno the primary key of the employee details
	* @return the employee details that was removed
	* @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	*/
	public static EmployeeDetails remove(long eno)
		throws com.vy.payroll.exception.NoSuchEmployeeDetailsException {
		return getPersistence().remove(eno);
	}

	public static EmployeeDetails updateImpl(EmployeeDetails employeeDetails) {
		return getPersistence().updateImpl(employeeDetails);
	}

	/**
	* Returns the employee details with the primary key or throws a {@link NoSuchEmployeeDetailsException} if it could not be found.
	*
	* @param eno the primary key of the employee details
	* @return the employee details
	* @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	*/
	public static EmployeeDetails findByPrimaryKey(long eno)
		throws com.vy.payroll.exception.NoSuchEmployeeDetailsException {
		return getPersistence().findByPrimaryKey(eno);
	}

	/**
	* Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eno the primary key of the employee details
	* @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	*/
	public static EmployeeDetails fetchByPrimaryKey(long eno) {
		return getPersistence().fetchByPrimaryKey(eno);
	}

	public static java.util.Map<java.io.Serializable, EmployeeDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the employee detailses.
	*
	* @return the employee detailses
	*/
	public static List<EmployeeDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the employee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee detailses
	* @param end the upper bound of the range of employee detailses (not inclusive)
	* @return the range of employee detailses
	*/
	public static List<EmployeeDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the employee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee detailses
	* @param end the upper bound of the range of employee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employee detailses
	*/
	public static List<EmployeeDetails> findAll(int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee detailses
	* @param end the upper bound of the range of employee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employee detailses
	*/
	public static List<EmployeeDetails> findAll(int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the employee detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of employee detailses.
	*
	* @return the number of employee detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EmployeeDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeDetailsPersistence, EmployeeDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeDetailsPersistence.class);

		ServiceTracker<EmployeeDetailsPersistence, EmployeeDetailsPersistence> serviceTracker =
			new ServiceTracker<EmployeeDetailsPersistence, EmployeeDetailsPersistence>(bundle.getBundleContext(),
				EmployeeDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}