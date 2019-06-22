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
 * Provides a wrapper for {@link AdvanceSalaryRecordLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AdvanceSalaryRecordLocalService
 * @generated
 */
@ProviderType
public class AdvanceSalaryRecordLocalServiceWrapper
	implements AdvanceSalaryRecordLocalService,
		ServiceWrapper<AdvanceSalaryRecordLocalService> {
	public AdvanceSalaryRecordLocalServiceWrapper(
		AdvanceSalaryRecordLocalService advanceSalaryRecordLocalService) {
		_advanceSalaryRecordLocalService = advanceSalaryRecordLocalService;
	}

	/**
	* Adds the advance salary record to the database. Also notifies the appropriate model listeners.
	*
	* @param advanceSalaryRecord the advance salary record
	* @return the advance salary record that was added
	*/
	@Override
	public com.vy.payroll.model.AdvanceSalaryRecord addAdvanceSalaryRecord(
		com.vy.payroll.model.AdvanceSalaryRecord advanceSalaryRecord) {
		return _advanceSalaryRecordLocalService.addAdvanceSalaryRecord(advanceSalaryRecord);
	}

	/**
	* Creates a new advance salary record with the primary key. Does not add the advance salary record to the database.
	*
	* @param request_id the primary key for the new advance salary record
	* @return the new advance salary record
	*/
	@Override
	public com.vy.payroll.model.AdvanceSalaryRecord createAdvanceSalaryRecord(
		int request_id) {
		return _advanceSalaryRecordLocalService.createAdvanceSalaryRecord(request_id);
	}

	/**
	* Deletes the advance salary record from the database. Also notifies the appropriate model listeners.
	*
	* @param advanceSalaryRecord the advance salary record
	* @return the advance salary record that was removed
	*/
	@Override
	public com.vy.payroll.model.AdvanceSalaryRecord deleteAdvanceSalaryRecord(
		com.vy.payroll.model.AdvanceSalaryRecord advanceSalaryRecord) {
		return _advanceSalaryRecordLocalService.deleteAdvanceSalaryRecord(advanceSalaryRecord);
	}

	/**
	* Deletes the advance salary record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param request_id the primary key of the advance salary record
	* @return the advance salary record that was removed
	* @throws PortalException if a advance salary record with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.AdvanceSalaryRecord deleteAdvanceSalaryRecord(
		int request_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _advanceSalaryRecordLocalService.deleteAdvanceSalaryRecord(request_id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _advanceSalaryRecordLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _advanceSalaryRecordLocalService.dynamicQuery();
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
		return _advanceSalaryRecordLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _advanceSalaryRecordLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _advanceSalaryRecordLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _advanceSalaryRecordLocalService.dynamicQueryCount(dynamicQuery);
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
		return _advanceSalaryRecordLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.vy.payroll.model.AdvanceSalaryRecord fetchAdvanceSalaryRecord(
		int request_id) {
		return _advanceSalaryRecordLocalService.fetchAdvanceSalaryRecord(request_id);
	}

	@Override
	public java.util.List<com.vy.payroll.model.AdvanceSalaryRecord> findByIsChecked(
		String is_checked) {
		return _advanceSalaryRecordLocalService.findByIsChecked(is_checked);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _advanceSalaryRecordLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<Object[]> getAdvanceSalAndLeaveReqData() {
		return _advanceSalaryRecordLocalService.getAdvanceSalAndLeaveReqData();
	}

	/**
	* Returns the advance salary record with the primary key.
	*
	* @param request_id the primary key of the advance salary record
	* @return the advance salary record
	* @throws PortalException if a advance salary record with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.AdvanceSalaryRecord getAdvanceSalaryRecord(
		int request_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _advanceSalaryRecordLocalService.getAdvanceSalaryRecord(request_id);
	}

	/**
	* Returns a range of all the advance salary records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of advance salary records
	* @param end the upper bound of the range of advance salary records (not inclusive)
	* @return the range of advance salary records
	*/
	@Override
	public java.util.List<com.vy.payroll.model.AdvanceSalaryRecord> getAdvanceSalaryRecords(
		int start, int end) {
		return _advanceSalaryRecordLocalService.getAdvanceSalaryRecords(start,
			end);
	}

	/**
	* Returns the number of advance salary records.
	*
	* @return the number of advance salary records
	*/
	@Override
	public int getAdvanceSalaryRecordsCount() {
		return _advanceSalaryRecordLocalService.getAdvanceSalaryRecordsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _advanceSalaryRecordLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _advanceSalaryRecordLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _advanceSalaryRecordLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int isRequestViewed(String isRequestChecked) {
		return _advanceSalaryRecordLocalService.isRequestViewed(isRequestChecked);
	}

	/**
	* Updates the advance salary record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advanceSalaryRecord the advance salary record
	* @return the advance salary record that was updated
	*/
	@Override
	public com.vy.payroll.model.AdvanceSalaryRecord updateAdvanceSalaryRecord(
		com.vy.payroll.model.AdvanceSalaryRecord advanceSalaryRecord) {
		return _advanceSalaryRecordLocalService.updateAdvanceSalaryRecord(advanceSalaryRecord);
	}

	@Override
	public int updateRequestIsChecked() {
		return _advanceSalaryRecordLocalService.updateRequestIsChecked();
	}

	@Override
	public AdvanceSalaryRecordLocalService getWrappedService() {
		return _advanceSalaryRecordLocalService;
	}

	@Override
	public void setWrappedService(
		AdvanceSalaryRecordLocalService advanceSalaryRecordLocalService) {
		_advanceSalaryRecordLocalService = advanceSalaryRecordLocalService;
	}

	private AdvanceSalaryRecordLocalService _advanceSalaryRecordLocalService;
}