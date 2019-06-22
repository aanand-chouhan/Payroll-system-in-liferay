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
 * Provides a wrapper for {@link Admin_detailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Admin_detailsLocalService
 * @generated
 */
@ProviderType
public class Admin_detailsLocalServiceWrapper
	implements Admin_detailsLocalService,
		ServiceWrapper<Admin_detailsLocalService> {
	public Admin_detailsLocalServiceWrapper(
		Admin_detailsLocalService admin_detailsLocalService) {
		_admin_detailsLocalService = admin_detailsLocalService;
	}

	/**
	* Adds the admin_details to the database. Also notifies the appropriate model listeners.
	*
	* @param admin_details the admin_details
	* @return the admin_details that was added
	*/
	@Override
	public com.vy.payroll.model.Admin_details addAdmin_details(
		com.vy.payroll.model.Admin_details admin_details) {
		return _admin_detailsLocalService.addAdmin_details(admin_details);
	}

	/**
	* Creates a new admin_details with the primary key. Does not add the admin_details to the database.
	*
	* @param admin_id the primary key for the new admin_details
	* @return the new admin_details
	*/
	@Override
	public com.vy.payroll.model.Admin_details createAdmin_details(int admin_id) {
		return _admin_detailsLocalService.createAdmin_details(admin_id);
	}

	/**
	* Deletes the admin_details from the database. Also notifies the appropriate model listeners.
	*
	* @param admin_details the admin_details
	* @return the admin_details that was removed
	*/
	@Override
	public com.vy.payroll.model.Admin_details deleteAdmin_details(
		com.vy.payroll.model.Admin_details admin_details) {
		return _admin_detailsLocalService.deleteAdmin_details(admin_details);
	}

	/**
	* Deletes the admin_details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details that was removed
	* @throws PortalException if a admin_details with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.Admin_details deleteAdmin_details(int admin_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _admin_detailsLocalService.deleteAdmin_details(admin_id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _admin_detailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _admin_detailsLocalService.dynamicQuery();
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
		return _admin_detailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _admin_detailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _admin_detailsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _admin_detailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _admin_detailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.vy.payroll.model.Admin_details fetchAdmin_details(int admin_id) {
		return _admin_detailsLocalService.fetchAdmin_details(admin_id);
	}

	@Override
	public java.util.List<com.vy.payroll.model.Admin_details> findByUNameId(
		String userName, String password) {
		return _admin_detailsLocalService.findByUNameId(userName, password);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _admin_detailsLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the admin_details with the primary key.
	*
	* @param admin_id the primary key of the admin_details
	* @return the admin_details
	* @throws PortalException if a admin_details with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.Admin_details getAdmin_details(int admin_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _admin_detailsLocalService.getAdmin_details(admin_id);
	}

	/**
	* Returns a range of all the admin_detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin_detailses
	* @param end the upper bound of the range of admin_detailses (not inclusive)
	* @return the range of admin_detailses
	*/
	@Override
	public java.util.List<com.vy.payroll.model.Admin_details> getAdmin_detailses(
		int start, int end) {
		return _admin_detailsLocalService.getAdmin_detailses(start, end);
	}

	/**
	* Returns the number of admin_detailses.
	*
	* @return the number of admin_detailses
	*/
	@Override
	public int getAdmin_detailsesCount() {
		return _admin_detailsLocalService.getAdmin_detailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _admin_detailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _admin_detailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _admin_detailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the admin_details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param admin_details the admin_details
	* @return the admin_details that was updated
	*/
	@Override
	public com.vy.payroll.model.Admin_details updateAdmin_details(
		com.vy.payroll.model.Admin_details admin_details) {
		return _admin_detailsLocalService.updateAdmin_details(admin_details);
	}

	@Override
	public Admin_detailsLocalService getWrappedService() {
		return _admin_detailsLocalService;
	}

	@Override
	public void setWrappedService(
		Admin_detailsLocalService admin_detailsLocalService) {
		_admin_detailsLocalService = admin_detailsLocalService;
	}

	private Admin_detailsLocalService _admin_detailsLocalService;
}