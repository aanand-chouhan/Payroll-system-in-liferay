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

import com.vy.payroll.exception.NoSuchEmployeeDetailsException;
import com.vy.payroll.model.EmployeeDetails;

/**
 * The persistence interface for the employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.persistence.impl.EmployeeDetailsPersistenceImpl
 * @see EmployeeDetailsUtil
 * @generated
 */
@ProviderType
public interface EmployeeDetailsPersistence extends BasePersistence<EmployeeDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDetailsUtil} to access the employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the employee detailses where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @return the matching employee detailses
	*/
	public java.util.List<EmployeeDetails> findByEmailPwd(String email,
		String password);

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
	public java.util.List<EmployeeDetails> findByEmailPwd(String email,
		String password, int start, int end);

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
	public java.util.List<EmployeeDetails> findByEmailPwd(String email,
		String password, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator);

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
	public java.util.List<EmployeeDetails> findByEmailPwd(String email,
		String password, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee details
	* @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	*/
	public EmployeeDetails findByEmailPwd_First(String email, String password,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	* Returns the first employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	*/
	public EmployeeDetails fetchByEmailPwd_First(String email, String password,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator);

	/**
	* Returns the last employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee details
	* @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	*/
	public EmployeeDetails findByEmailPwd_Last(String email, String password,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	* Returns the last employee details in the ordered set where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	*/
	public EmployeeDetails fetchByEmailPwd_Last(String email, String password,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator);

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
	public EmployeeDetails[] findByEmailPwd_PrevAndNext(long eno, String email,
		String password,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	* Removes all the employee detailses where email = &#63; and password = &#63; from the database.
	*
	* @param email the email
	* @param password the password
	*/
	public void removeByEmailPwd(String email, String password);

	/**
	* Returns the number of employee detailses where email = &#63; and password = &#63;.
	*
	* @param email the email
	* @param password the password
	* @return the number of matching employee detailses
	*/
	public int countByEmailPwd(String email, String password);

	/**
	* Caches the employee details in the entity cache if it is enabled.
	*
	* @param employeeDetails the employee details
	*/
	public void cacheResult(EmployeeDetails employeeDetails);

	/**
	* Caches the employee detailses in the entity cache if it is enabled.
	*
	* @param employeeDetailses the employee detailses
	*/
	public void cacheResult(java.util.List<EmployeeDetails> employeeDetailses);

	/**
	* Creates a new employee details with the primary key. Does not add the employee details to the database.
	*
	* @param eno the primary key for the new employee details
	* @return the new employee details
	*/
	public EmployeeDetails create(long eno);

	/**
	* Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eno the primary key of the employee details
	* @return the employee details that was removed
	* @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	*/
	public EmployeeDetails remove(long eno)
		throws NoSuchEmployeeDetailsException;

	public EmployeeDetails updateImpl(EmployeeDetails employeeDetails);

	/**
	* Returns the employee details with the primary key or throws a {@link NoSuchEmployeeDetailsException} if it could not be found.
	*
	* @param eno the primary key of the employee details
	* @return the employee details
	* @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	*/
	public EmployeeDetails findByPrimaryKey(long eno)
		throws NoSuchEmployeeDetailsException;

	/**
	* Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eno the primary key of the employee details
	* @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	*/
	public EmployeeDetails fetchByPrimaryKey(long eno);

	@Override
	public java.util.Map<java.io.Serializable, EmployeeDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the employee detailses.
	*
	* @return the employee detailses
	*/
	public java.util.List<EmployeeDetails> findAll();

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
	public java.util.List<EmployeeDetails> findAll(int start, int end);

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
	public java.util.List<EmployeeDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator);

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
	public java.util.List<EmployeeDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the employee detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of employee detailses.
	*
	* @return the number of employee detailses
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}