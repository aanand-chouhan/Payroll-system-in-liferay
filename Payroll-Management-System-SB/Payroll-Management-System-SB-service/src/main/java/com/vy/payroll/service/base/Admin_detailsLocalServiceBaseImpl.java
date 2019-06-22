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

package com.vy.payroll.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.vy.payroll.model.Admin_details;
import com.vy.payroll.service.Admin_detailsLocalService;
import com.vy.payroll.service.persistence.Admin_detailsPersistence;
import com.vy.payroll.service.persistence.AdvanceSalaryRecordFinder;
import com.vy.payroll.service.persistence.AdvanceSalaryRecordPersistence;
import com.vy.payroll.service.persistence.CtcDetailPersistence;
import com.vy.payroll.service.persistence.DepartmentPersistence;
import com.vy.payroll.service.persistence.DocumentFinder;
import com.vy.payroll.service.persistence.DocumentPersistence;
import com.vy.payroll.service.persistence.EmployeeDetailsPersistence;
import com.vy.payroll.service.persistence.LeaveRequestFinder;
import com.vy.payroll.service.persistence.LeaveRequestPersistence;
import com.vy.payroll.service.persistence.PayslipDetailsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the admin_details local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.vy.payroll.service.impl.Admin_detailsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.impl.Admin_detailsLocalServiceImpl
 * @see com.vy.payroll.service.Admin_detailsLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class Admin_detailsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements Admin_detailsLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.vy.payroll.service.Admin_detailsLocalServiceUtil} to access the admin_details local service.
	 */

	/**
	 * Adds the admin_details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param admin_details the admin_details
	 * @return the admin_details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Admin_details addAdmin_details(Admin_details admin_details) {
		admin_details.setNew(true);

		return admin_detailsPersistence.update(admin_details);
	}

	/**
	 * Creates a new admin_details with the primary key. Does not add the admin_details to the database.
	 *
	 * @param admin_id the primary key for the new admin_details
	 * @return the new admin_details
	 */
	@Override
	@Transactional(enabled = false)
	public Admin_details createAdmin_details(int admin_id) {
		return admin_detailsPersistence.create(admin_id);
	}

	/**
	 * Deletes the admin_details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param admin_id the primary key of the admin_details
	 * @return the admin_details that was removed
	 * @throws PortalException if a admin_details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Admin_details deleteAdmin_details(int admin_id)
		throws PortalException {
		return admin_detailsPersistence.remove(admin_id);
	}

	/**
	 * Deletes the admin_details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param admin_details the admin_details
	 * @return the admin_details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Admin_details deleteAdmin_details(Admin_details admin_details) {
		return admin_detailsPersistence.remove(admin_details);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Admin_details.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return admin_detailsPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return admin_detailsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return admin_detailsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return admin_detailsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return admin_detailsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Admin_details fetchAdmin_details(int admin_id) {
		return admin_detailsPersistence.fetchByPrimaryKey(admin_id);
	}

	/**
	 * Returns the admin_details with the primary key.
	 *
	 * @param admin_id the primary key of the admin_details
	 * @return the admin_details
	 * @throws PortalException if a admin_details with the primary key could not be found
	 */
	@Override
	public Admin_details getAdmin_details(int admin_id)
		throws PortalException {
		return admin_detailsPersistence.findByPrimaryKey(admin_id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(admin_detailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Admin_details.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("admin_id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(admin_detailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Admin_details.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("admin_id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(admin_detailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Admin_details.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("admin_id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return admin_detailsLocalService.deleteAdmin_details((Admin_details)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return admin_detailsPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Admin_details> getAdmin_detailses(int start, int end) {
		return admin_detailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of admin_detailses.
	 *
	 * @return the number of admin_detailses
	 */
	@Override
	public int getAdmin_detailsesCount() {
		return admin_detailsPersistence.countAll();
	}

	/**
	 * Updates the admin_details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param admin_details the admin_details
	 * @return the admin_details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Admin_details updateAdmin_details(Admin_details admin_details) {
		return admin_detailsPersistence.update(admin_details);
	}

	/**
	 * Returns the admin_details local service.
	 *
	 * @return the admin_details local service
	 */
	public Admin_detailsLocalService getAdmin_detailsLocalService() {
		return admin_detailsLocalService;
	}

	/**
	 * Sets the admin_details local service.
	 *
	 * @param admin_detailsLocalService the admin_details local service
	 */
	public void setAdmin_detailsLocalService(
		Admin_detailsLocalService admin_detailsLocalService) {
		this.admin_detailsLocalService = admin_detailsLocalService;
	}

	/**
	 * Returns the admin_details persistence.
	 *
	 * @return the admin_details persistence
	 */
	public Admin_detailsPersistence getAdmin_detailsPersistence() {
		return admin_detailsPersistence;
	}

	/**
	 * Sets the admin_details persistence.
	 *
	 * @param admin_detailsPersistence the admin_details persistence
	 */
	public void setAdmin_detailsPersistence(
		Admin_detailsPersistence admin_detailsPersistence) {
		this.admin_detailsPersistence = admin_detailsPersistence;
	}

	/**
	 * Returns the advance salary record local service.
	 *
	 * @return the advance salary record local service
	 */
	public com.vy.payroll.service.AdvanceSalaryRecordLocalService getAdvanceSalaryRecordLocalService() {
		return advanceSalaryRecordLocalService;
	}

	/**
	 * Sets the advance salary record local service.
	 *
	 * @param advanceSalaryRecordLocalService the advance salary record local service
	 */
	public void setAdvanceSalaryRecordLocalService(
		com.vy.payroll.service.AdvanceSalaryRecordLocalService advanceSalaryRecordLocalService) {
		this.advanceSalaryRecordLocalService = advanceSalaryRecordLocalService;
	}

	/**
	 * Returns the advance salary record persistence.
	 *
	 * @return the advance salary record persistence
	 */
	public AdvanceSalaryRecordPersistence getAdvanceSalaryRecordPersistence() {
		return advanceSalaryRecordPersistence;
	}

	/**
	 * Sets the advance salary record persistence.
	 *
	 * @param advanceSalaryRecordPersistence the advance salary record persistence
	 */
	public void setAdvanceSalaryRecordPersistence(
		AdvanceSalaryRecordPersistence advanceSalaryRecordPersistence) {
		this.advanceSalaryRecordPersistence = advanceSalaryRecordPersistence;
	}

	/**
	 * Returns the advance salary record finder.
	 *
	 * @return the advance salary record finder
	 */
	public AdvanceSalaryRecordFinder getAdvanceSalaryRecordFinder() {
		return advanceSalaryRecordFinder;
	}

	/**
	 * Sets the advance salary record finder.
	 *
	 * @param advanceSalaryRecordFinder the advance salary record finder
	 */
	public void setAdvanceSalaryRecordFinder(
		AdvanceSalaryRecordFinder advanceSalaryRecordFinder) {
		this.advanceSalaryRecordFinder = advanceSalaryRecordFinder;
	}

	/**
	 * Returns the ctc detail local service.
	 *
	 * @return the ctc detail local service
	 */
	public com.vy.payroll.service.CtcDetailLocalService getCtcDetailLocalService() {
		return ctcDetailLocalService;
	}

	/**
	 * Sets the ctc detail local service.
	 *
	 * @param ctcDetailLocalService the ctc detail local service
	 */
	public void setCtcDetailLocalService(
		com.vy.payroll.service.CtcDetailLocalService ctcDetailLocalService) {
		this.ctcDetailLocalService = ctcDetailLocalService;
	}

	/**
	 * Returns the ctc detail persistence.
	 *
	 * @return the ctc detail persistence
	 */
	public CtcDetailPersistence getCtcDetailPersistence() {
		return ctcDetailPersistence;
	}

	/**
	 * Sets the ctc detail persistence.
	 *
	 * @param ctcDetailPersistence the ctc detail persistence
	 */
	public void setCtcDetailPersistence(
		CtcDetailPersistence ctcDetailPersistence) {
		this.ctcDetailPersistence = ctcDetailPersistence;
	}

	/**
	 * Returns the department local service.
	 *
	 * @return the department local service
	 */
	public com.vy.payroll.service.DepartmentLocalService getDepartmentLocalService() {
		return departmentLocalService;
	}

	/**
	 * Sets the department local service.
	 *
	 * @param departmentLocalService the department local service
	 */
	public void setDepartmentLocalService(
		com.vy.payroll.service.DepartmentLocalService departmentLocalService) {
		this.departmentLocalService = departmentLocalService;
	}

	/**
	 * Returns the department persistence.
	 *
	 * @return the department persistence
	 */
	public DepartmentPersistence getDepartmentPersistence() {
		return departmentPersistence;
	}

	/**
	 * Sets the department persistence.
	 *
	 * @param departmentPersistence the department persistence
	 */
	public void setDepartmentPersistence(
		DepartmentPersistence departmentPersistence) {
		this.departmentPersistence = departmentPersistence;
	}

	/**
	 * Returns the document local service.
	 *
	 * @return the document local service
	 */
	public com.vy.payroll.service.DocumentLocalService getDocumentLocalService() {
		return documentLocalService;
	}

	/**
	 * Sets the document local service.
	 *
	 * @param documentLocalService the document local service
	 */
	public void setDocumentLocalService(
		com.vy.payroll.service.DocumentLocalService documentLocalService) {
		this.documentLocalService = documentLocalService;
	}

	/**
	 * Returns the document persistence.
	 *
	 * @return the document persistence
	 */
	public DocumentPersistence getDocumentPersistence() {
		return documentPersistence;
	}

	/**
	 * Sets the document persistence.
	 *
	 * @param documentPersistence the document persistence
	 */
	public void setDocumentPersistence(DocumentPersistence documentPersistence) {
		this.documentPersistence = documentPersistence;
	}

	/**
	 * Returns the document finder.
	 *
	 * @return the document finder
	 */
	public DocumentFinder getDocumentFinder() {
		return documentFinder;
	}

	/**
	 * Sets the document finder.
	 *
	 * @param documentFinder the document finder
	 */
	public void setDocumentFinder(DocumentFinder documentFinder) {
		this.documentFinder = documentFinder;
	}

	/**
	 * Returns the employee details local service.
	 *
	 * @return the employee details local service
	 */
	public com.vy.payroll.service.EmployeeDetailsLocalService getEmployeeDetailsLocalService() {
		return employeeDetailsLocalService;
	}

	/**
	 * Sets the employee details local service.
	 *
	 * @param employeeDetailsLocalService the employee details local service
	 */
	public void setEmployeeDetailsLocalService(
		com.vy.payroll.service.EmployeeDetailsLocalService employeeDetailsLocalService) {
		this.employeeDetailsLocalService = employeeDetailsLocalService;
	}

	/**
	 * Returns the employee details persistence.
	 *
	 * @return the employee details persistence
	 */
	public EmployeeDetailsPersistence getEmployeeDetailsPersistence() {
		return employeeDetailsPersistence;
	}

	/**
	 * Sets the employee details persistence.
	 *
	 * @param employeeDetailsPersistence the employee details persistence
	 */
	public void setEmployeeDetailsPersistence(
		EmployeeDetailsPersistence employeeDetailsPersistence) {
		this.employeeDetailsPersistence = employeeDetailsPersistence;
	}

	/**
	 * Returns the leave request local service.
	 *
	 * @return the leave request local service
	 */
	public com.vy.payroll.service.LeaveRequestLocalService getLeaveRequestLocalService() {
		return leaveRequestLocalService;
	}

	/**
	 * Sets the leave request local service.
	 *
	 * @param leaveRequestLocalService the leave request local service
	 */
	public void setLeaveRequestLocalService(
		com.vy.payroll.service.LeaveRequestLocalService leaveRequestLocalService) {
		this.leaveRequestLocalService = leaveRequestLocalService;
	}

	/**
	 * Returns the leave request persistence.
	 *
	 * @return the leave request persistence
	 */
	public LeaveRequestPersistence getLeaveRequestPersistence() {
		return leaveRequestPersistence;
	}

	/**
	 * Sets the leave request persistence.
	 *
	 * @param leaveRequestPersistence the leave request persistence
	 */
	public void setLeaveRequestPersistence(
		LeaveRequestPersistence leaveRequestPersistence) {
		this.leaveRequestPersistence = leaveRequestPersistence;
	}

	/**
	 * Returns the leave request finder.
	 *
	 * @return the leave request finder
	 */
	public LeaveRequestFinder getLeaveRequestFinder() {
		return leaveRequestFinder;
	}

	/**
	 * Sets the leave request finder.
	 *
	 * @param leaveRequestFinder the leave request finder
	 */
	public void setLeaveRequestFinder(LeaveRequestFinder leaveRequestFinder) {
		this.leaveRequestFinder = leaveRequestFinder;
	}

	/**
	 * Returns the payslip details local service.
	 *
	 * @return the payslip details local service
	 */
	public com.vy.payroll.service.PayslipDetailsLocalService getPayslipDetailsLocalService() {
		return payslipDetailsLocalService;
	}

	/**
	 * Sets the payslip details local service.
	 *
	 * @param payslipDetailsLocalService the payslip details local service
	 */
	public void setPayslipDetailsLocalService(
		com.vy.payroll.service.PayslipDetailsLocalService payslipDetailsLocalService) {
		this.payslipDetailsLocalService = payslipDetailsLocalService;
	}

	/**
	 * Returns the payslip details persistence.
	 *
	 * @return the payslip details persistence
	 */
	public PayslipDetailsPersistence getPayslipDetailsPersistence() {
		return payslipDetailsPersistence;
	}

	/**
	 * Sets the payslip details persistence.
	 *
	 * @param payslipDetailsPersistence the payslip details persistence
	 */
	public void setPayslipDetailsPersistence(
		PayslipDetailsPersistence payslipDetailsPersistence) {
		this.payslipDetailsPersistence = payslipDetailsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.vy.payroll.model.Admin_details",
			admin_detailsLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.vy.payroll.model.Admin_details");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return Admin_detailsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Admin_details.class;
	}

	protected String getModelClassName() {
		return Admin_details.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = admin_detailsPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = Admin_detailsLocalService.class)
	protected Admin_detailsLocalService admin_detailsLocalService;
	@BeanReference(type = Admin_detailsPersistence.class)
	protected Admin_detailsPersistence admin_detailsPersistence;
	@BeanReference(type = com.vy.payroll.service.AdvanceSalaryRecordLocalService.class)
	protected com.vy.payroll.service.AdvanceSalaryRecordLocalService advanceSalaryRecordLocalService;
	@BeanReference(type = AdvanceSalaryRecordPersistence.class)
	protected AdvanceSalaryRecordPersistence advanceSalaryRecordPersistence;
	@BeanReference(type = AdvanceSalaryRecordFinder.class)
	protected AdvanceSalaryRecordFinder advanceSalaryRecordFinder;
	@BeanReference(type = com.vy.payroll.service.CtcDetailLocalService.class)
	protected com.vy.payroll.service.CtcDetailLocalService ctcDetailLocalService;
	@BeanReference(type = CtcDetailPersistence.class)
	protected CtcDetailPersistence ctcDetailPersistence;
	@BeanReference(type = com.vy.payroll.service.DepartmentLocalService.class)
	protected com.vy.payroll.service.DepartmentLocalService departmentLocalService;
	@BeanReference(type = DepartmentPersistence.class)
	protected DepartmentPersistence departmentPersistence;
	@BeanReference(type = com.vy.payroll.service.DocumentLocalService.class)
	protected com.vy.payroll.service.DocumentLocalService documentLocalService;
	@BeanReference(type = DocumentPersistence.class)
	protected DocumentPersistence documentPersistence;
	@BeanReference(type = DocumentFinder.class)
	protected DocumentFinder documentFinder;
	@BeanReference(type = com.vy.payroll.service.EmployeeDetailsLocalService.class)
	protected com.vy.payroll.service.EmployeeDetailsLocalService employeeDetailsLocalService;
	@BeanReference(type = EmployeeDetailsPersistence.class)
	protected EmployeeDetailsPersistence employeeDetailsPersistence;
	@BeanReference(type = com.vy.payroll.service.LeaveRequestLocalService.class)
	protected com.vy.payroll.service.LeaveRequestLocalService leaveRequestLocalService;
	@BeanReference(type = LeaveRequestPersistence.class)
	protected LeaveRequestPersistence leaveRequestPersistence;
	@BeanReference(type = LeaveRequestFinder.class)
	protected LeaveRequestFinder leaveRequestFinder;
	@BeanReference(type = com.vy.payroll.service.PayslipDetailsLocalService.class)
	protected com.vy.payroll.service.PayslipDetailsLocalService payslipDetailsLocalService;
	@BeanReference(type = PayslipDetailsPersistence.class)
	protected PayslipDetailsPersistence payslipDetailsPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}