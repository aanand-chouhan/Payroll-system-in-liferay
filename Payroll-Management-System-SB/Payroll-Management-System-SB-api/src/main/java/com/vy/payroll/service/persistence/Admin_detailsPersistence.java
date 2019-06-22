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

import com.vy.payroll.exception.NoSuchAdmin_detailsException;
import com.vy.payroll.model.Admin_details;

/**
 * The persistence interface for the admin_details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.persistence.impl.Admin_detailsPersistenceImpl
 * @see Admin_detailsUtil
 * @generated
 */
@ProviderType
public interface Admin_detailsPersistence extends BasePersistence<Admin_details> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Admin_detailsUtil} to access the admin_details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the admin_detailses where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @return the matching admin_detailses
	*/
	public java.util.List<Admin_details> findByUNameId(String userName,
		String password);

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
	public java.util.List<Admin_details> findByUNameId(String userName,
		String password, int start, int end);

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
	public java.util.List<Admin_details> findByUNameId(String userName,
		String password, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator);

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
	public java.util.List<Admin_details> findByUNameId(String userName,
		String password, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin_details
	* @throws NoSuchAdmin_detailsException if a matching admin_details could not be found
	*/
	public Admin_details findByUNameId_First(String userName, String password,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator)
		throws NoSuchAdmin_detailsException;

	/**
	* Returns the first admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin_details, or <code>null</code> if a matching admin_details could not be found
	*/
	public Admin_details fetchByUNameId_First(String userName, String password,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator);

	/**
	* Returns the last admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin_details
	* @throws NoSuchAdmin_detailsException if a matching admin_details could not be found
	*/
	public Admin_details findByUNameId_Last(String userName, String password,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator)
		throws NoSuchAdmin_detailsException;

	/**
	* Returns the last admin_details in the ordered set where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin_details, or <code>null</code> if a matching admin_details could not be found
	*/
	public Admin_details fetchByUNameId_Last(String userName, String password,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator);

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
	public Admin_details[] findByUNameId_PrevAndNext(int admin_id,
		String userName, String password,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator)
		throws NoSuchAdmin_detailsException;

	/**
	* Removes all the admin_detailses where userName = &#63; and password = &#63; from the database.
	*
	* @param userName the user name
	* @param password the password
	*/
	public void removeByUNameId(String userName, String password);

	/**
	* Returns the number of admin_detailses where userName = &#63; and password = &#63;.
	*
	* @param userName the user name
	* @param password the password
	* @return the number of matching admin_detailses
	*/
	public int countByUNameId(String userName, String password);

	/**
	* Caches the admin_details in the entity cache if it is enabled.
	*
	* @param admin_details the admin_details
	*/
	public void cacheResult(Admin_details admin_details);

	/**
	* Caches the admin_detailses in the entity cache if it is enabled.
	*
	* @param admin_detailses the admin_detailses
	*/
	public void cacheResult(java.util.List<Admin_details> admin_detailses);

	/**
	* Creates a new admin_details with the primary key. Does not add the admin_details to the database.
	*
	* @param admin_id the primary key for the new admin_details
	* @return the new admin_details
	*/
	public Admin_details create(int admin_id);

	/**
	* Removes the admin_details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details that was removed
	* @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	*/
	public Admin_details remove(int admin_id)
		throws NoSuchAdmin_detailsException;

	public Admin_details updateImpl(Admin_details admin_details);

	/**
	* Returns the admin_details with the primary key or throws a {@link NoSuchAdmin_detailsException} if it could not be found.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details
	* @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	*/
	public Admin_details findByPrimaryKey(int admin_id)
		throws NoSuchAdmin_detailsException;

	/**
	* Returns the admin_details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details, or <code>null</code> if a admin_details with the primary key could not be found
	*/
	public Admin_details fetchByPrimaryKey(int admin_id);

	@Override
	public java.util.Map<java.io.Serializable, Admin_details> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the admin_detailses.
	*
	* @return the admin_detailses
	*/
	public java.util.List<Admin_details> findAll();

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
	public java.util.List<Admin_details> findAll(int start, int end);

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
	public java.util.List<Admin_details> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator);

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
	public java.util.List<Admin_details> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Admin_details> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the admin_detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of admin_detailses.
	*
	* @return the number of admin_detailses
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}