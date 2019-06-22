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

package com.vy.payroll.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsLocalService
 * @generated
 */
@ProviderType
public class EmployeeDetailsLocalServiceWrapper
	implements EmployeeDetailsLocalService,
		ServiceWrapper<EmployeeDetailsLocalService> {
	public EmployeeDetailsLocalServiceWrapper(
		EmployeeDetailsLocalService employeeDetailsLocalService) {
		_employeeDetailsLocalService = employeeDetailsLocalService;
	}

	/**
	* Adds the employee details to the database. Also notifies the appropriate model listeners.
	*
	* @param employeeDetails the employee details
	* @return the employee details that was added
	*/
	@Override
	public com.vy.payroll.model.EmployeeDetails addEmployeeDetails(
		com.vy.payroll.model.EmployeeDetails employeeDetails) {
		return _employeeDetailsLocalService.addEmployeeDetails(employeeDetails);
	}

	/**
	* Creates a new employee details with the primary key. Does not add the employee details to the database.
	*
	* @param eno the primary key for the new employee details
	* @return the new employee details
	*/
	@Override
	public com.vy.payroll.model.EmployeeDetails createEmployeeDetails(long eno) {
		return _employeeDetailsLocalService.createEmployeeDetails(eno);
	}

	/**
	* Deletes the employee details from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeDetails the employee details
	* @return the employee details that was removed
	*/
	@Override
	public com.vy.payroll.model.EmployeeDetails deleteEmployeeDetails(
		com.vy.payroll.model.EmployeeDetails employeeDetails) {
		return _employeeDetailsLocalService.deleteEmployeeDetails(employeeDetails);
	}

	/**
	* Deletes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eno the primary key of the employee details
	* @return the employee details that was removed
	* @throws PortalException if a employee details with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.EmployeeDetails deleteEmployeeDetails(long eno)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailsLocalService.deleteEmployeeDetails(eno);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDetailsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _employeeDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _employeeDetailsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _employeeDetailsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _employeeDetailsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _employeeDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.vy.payroll.model.EmployeeDetails fetchEmployeeDetails(long eno) {
		return _employeeDetailsLocalService.fetchEmployeeDetails(eno);
	}

	@Override
	public java.util.List<com.vy.payroll.model.EmployeeDetails> findByEmailPwd(
		String email, String password) {
		return _employeeDetailsLocalService.findByEmailPwd(email, password);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _employeeDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the employee details with the primary key.
	*
	* @param eno the primary key of the employee details
	* @return the employee details
	* @throws PortalException if a employee details with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.EmployeeDetails getEmployeeDetails(long eno)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailsLocalService.getEmployeeDetails(eno);
	}

	/**
	* Returns a range of all the employee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee detailses
	* @param end the upper bound of the range of employee detailses (not inclusive)
	* @return the range of employee detailses
	*/
	@Override
	public java.util.List<com.vy.payroll.model.EmployeeDetails> getEmployeeDetailses(
		int start, int end) {
		return _employeeDetailsLocalService.getEmployeeDetailses(start, end);
	}

	/**
	* Returns the number of employee detailses.
	*
	* @return the number of employee detailses
	*/
	@Override
	public int getEmployeeDetailsesCount() {
		return _employeeDetailsLocalService.getEmployeeDetailsesCount();
	}

	@Override
	public String getImage(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			java.sql.SQLException, java.io.IOException {
		return _employeeDetailsLocalService.getImage(id);
	}

	@Override
	public com.vy.payroll.model.EmployeeDetailsImageBlobModel getImageBlobModel(
		java.io.Serializable primaryKey) {
		return _employeeDetailsLocalService.getImageBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _employeeDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employeeDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the employee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employeeDetails the employee details
	* @return the employee details that was updated
	*/
	@Override
	public com.vy.payroll.model.EmployeeDetails updateEmployeeDetails(
		com.vy.payroll.model.EmployeeDetails employeeDetails) {
		return _employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
	}

	@Override
	public EmployeeDetailsLocalService getWrappedService() {
		return _employeeDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDetailsLocalService employeeDetailsLocalService) {
		_employeeDetailsLocalService = employeeDetailsLocalService;
	}

	private EmployeeDetailsLocalService _employeeDetailsLocalService;
}