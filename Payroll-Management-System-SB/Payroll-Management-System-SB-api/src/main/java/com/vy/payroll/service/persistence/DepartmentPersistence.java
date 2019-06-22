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

import com.vy.payroll.exception.NoSuchDepartmentException;
import com.vy.payroll.model.Department;

/**
 * The persistence interface for the department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.persistence.impl.DepartmentPersistenceImpl
 * @see DepartmentUtil
 * @generated
 */
@ProviderType
public interface DepartmentPersistence extends BasePersistence<Department> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartmentUtil} to access the department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the department in the entity cache if it is enabled.
	*
	* @param department the department
	*/
	public void cacheResult(Department department);

	/**
	* Caches the departments in the entity cache if it is enabled.
	*
	* @param departments the departments
	*/
	public void cacheResult(java.util.List<Department> departments);

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param dno the primary key for the new department
	* @return the new department
	*/
	public Department create(int dno);

	/**
	* Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dno the primary key of the department
	* @return the department that was removed
	* @throws NoSuchDepartmentException if a department with the primary key could not be found
	*/
	public Department remove(int dno) throws NoSuchDepartmentException;

	public Department updateImpl(Department department);

	/**
	* Returns the department with the primary key or throws a {@link NoSuchDepartmentException} if it could not be found.
	*
	* @param dno the primary key of the department
	* @return the department
	* @throws NoSuchDepartmentException if a department with the primary key could not be found
	*/
	public Department findByPrimaryKey(int dno)
		throws NoSuchDepartmentException;

	/**
	* Returns the department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dno the primary key of the department
	* @return the department, or <code>null</code> if a department with the primary key could not be found
	*/
	public Department fetchByPrimaryKey(int dno);

	@Override
	public java.util.Map<java.io.Serializable, Department> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the departments.
	*
	* @return the departments
	*/
	public java.util.List<Department> findAll();

	/**
	* Returns a range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of departments
	*/
	public java.util.List<Department> findAll(int start, int end);

	/**
	* Returns an ordered range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of departments
	*/
	public java.util.List<Department> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Department> orderByComparator);

	/**
	* Returns an ordered range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of departments
	*/
	public java.util.List<Department> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Department> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the departments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	*/
	public int countAll();
}