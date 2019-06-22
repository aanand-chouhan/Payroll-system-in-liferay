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
 * Provides a wrapper for {@link PayslipDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayslipDetailsLocalService
 * @generated
 */
@ProviderType
public class PayslipDetailsLocalServiceWrapper
	implements PayslipDetailsLocalService,
		ServiceWrapper<PayslipDetailsLocalService> {
	public PayslipDetailsLocalServiceWrapper(
		PayslipDetailsLocalService payslipDetailsLocalService) {
		_payslipDetailsLocalService = payslipDetailsLocalService;
	}

	/**
	* Adds the payslip details to the database. Also notifies the appropriate model listeners.
	*
	* @param payslipDetails the payslip details
	* @return the payslip details that was added
	*/
	@Override
	public com.vy.payroll.model.PayslipDetails addPayslipDetails(
		com.vy.payroll.model.PayslipDetails payslipDetails) {
		return _payslipDetailsLocalService.addPayslipDetails(payslipDetails);
	}

	/**
	* Creates a new payslip details with the primary key. Does not add the payslip details to the database.
	*
	* @param ctcId the primary key for the new payslip details
	* @return the new payslip details
	*/
	@Override
	public com.vy.payroll.model.PayslipDetails createPayslipDetails(long ctcId) {
		return _payslipDetailsLocalService.createPayslipDetails(ctcId);
	}

	/**
	* Deletes the payslip details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ctcId the primary key of the payslip details
	* @return the payslip details that was removed
	* @throws PortalException if a payslip details with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.PayslipDetails deletePayslipDetails(long ctcId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payslipDetailsLocalService.deletePayslipDetails(ctcId);
	}

	/**
	* Deletes the payslip details from the database. Also notifies the appropriate model listeners.
	*
	* @param payslipDetails the payslip details
	* @return the payslip details that was removed
	*/
	@Override
	public com.vy.payroll.model.PayslipDetails deletePayslipDetails(
		com.vy.payroll.model.PayslipDetails payslipDetails) {
		return _payslipDetailsLocalService.deletePayslipDetails(payslipDetails);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payslipDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payslipDetailsLocalService.dynamicQuery();
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
		return _payslipDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _payslipDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _payslipDetailsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _payslipDetailsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _payslipDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.vy.payroll.model.PayslipDetails fetchPayslipDetails(long ctcId) {
		return _payslipDetailsLocalService.fetchPayslipDetails(ctcId);
	}

	@Override
	public java.util.List<com.vy.payroll.model.PayslipDetails> findByMonthId(
		int month, String eid) {
		return _payslipDetailsLocalService.findByMonthId(month, eid);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _payslipDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _payslipDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _payslipDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Returns the payslip details with the primary key.
	*
	* @param ctcId the primary key of the payslip details
	* @return the payslip details
	* @throws PortalException if a payslip details with the primary key could not be found
	*/
	@Override
	public com.vy.payroll.model.PayslipDetails getPayslipDetails(long ctcId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payslipDetailsLocalService.getPayslipDetails(ctcId);
	}

	/**
	* Returns a range of all the payslip detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.vy.payroll.model.impl.PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payslip detailses
	* @param end the upper bound of the range of payslip detailses (not inclusive)
	* @return the range of payslip detailses
	*/
	@Override
	public java.util.List<com.vy.payroll.model.PayslipDetails> getPayslipDetailses(
		int start, int end) {
		return _payslipDetailsLocalService.getPayslipDetailses(start, end);
	}

	/**
	* Returns the number of payslip detailses.
	*
	* @return the number of payslip detailses
	*/
	@Override
	public int getPayslipDetailsesCount() {
		return _payslipDetailsLocalService.getPayslipDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _payslipDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the payslip details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param payslipDetails the payslip details
	* @return the payslip details that was updated
	*/
	@Override
	public com.vy.payroll.model.PayslipDetails updatePayslipDetails(
		com.vy.payroll.model.PayslipDetails payslipDetails) {
		return _payslipDetailsLocalService.updatePayslipDetails(payslipDetails);
	}

	@Override
	public PayslipDetailsLocalService getWrappedService() {
		return _payslipDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		PayslipDetailsLocalService payslipDetailsLocalService) {
		_payslipDetailsLocalService = payslipDetailsLocalService;
	}

	private PayslipDetailsLocalService _payslipDetailsLocalService;
}