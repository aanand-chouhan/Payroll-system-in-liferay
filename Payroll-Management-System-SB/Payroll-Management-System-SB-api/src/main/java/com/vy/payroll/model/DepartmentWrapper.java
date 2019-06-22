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

package com.vy.payroll.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Department}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Department
 * @generated
 */
@ProviderType
public class DepartmentWrapper implements Department, ModelWrapper<Department> {
	public DepartmentWrapper(Department department) {
		_department = department;
	}

	@Override
	public Class<?> getModelClass() {
		return Department.class;
	}

	@Override
	public String getModelClassName() {
		return Department.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dno", getDno());
		attributes.put("dName", getDName());
		attributes.put("eid", getEid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer dno = (Integer)attributes.get("dno");

		if (dno != null) {
			setDno(dno);
		}

		String dName = (String)attributes.get("dName");

		if (dName != null) {
			setDName(dName);
		}

		String eid = (String)attributes.get("eid");

		if (eid != null) {
			setEid(eid);
		}
	}

	@Override
	public Object clone() {
		return new DepartmentWrapper((Department)_department.clone());
	}

	@Override
	public int compareTo(Department department) {
		return _department.compareTo(department);
	}

	/**
	* Returns the d name of this department.
	*
	* @return the d name of this department
	*/
	@Override
	public String getDName() {
		return _department.getDName();
	}

	/**
	* Returns the dno of this department.
	*
	* @return the dno of this department
	*/
	@Override
	public int getDno() {
		return _department.getDno();
	}

	/**
	* Returns the eid of this department.
	*
	* @return the eid of this department
	*/
	@Override
	public String getEid() {
		return _department.getEid();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _department.getExpandoBridge();
	}

	/**
	* Returns the primary key of this department.
	*
	* @return the primary key of this department
	*/
	@Override
	public int getPrimaryKey() {
		return _department.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _department.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _department.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _department.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _department.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _department.isNew();
	}

	@Override
	public void persist() {
		_department.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_department.setCachedModel(cachedModel);
	}

	/**
	* Sets the d name of this department.
	*
	* @param dName the d name of this department
	*/
	@Override
	public void setDName(String dName) {
		_department.setDName(dName);
	}

	/**
	* Sets the dno of this department.
	*
	* @param dno the dno of this department
	*/
	@Override
	public void setDno(int dno) {
		_department.setDno(dno);
	}

	/**
	* Sets the eid of this department.
	*
	* @param eid the eid of this department
	*/
	@Override
	public void setEid(String eid) {
		_department.setEid(eid);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_department.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_department.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_department.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_department.setNew(n);
	}

	/**
	* Sets the primary key of this department.
	*
	* @param primaryKey the primary key of this department
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_department.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_department.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Department> toCacheModel() {
		return _department.toCacheModel();
	}

	@Override
	public Department toEscapedModel() {
		return new DepartmentWrapper(_department.toEscapedModel());
	}

	@Override
	public String toString() {
		return _department.toString();
	}

	@Override
	public Department toUnescapedModel() {
		return new DepartmentWrapper(_department.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _department.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DepartmentWrapper)) {
			return false;
		}

		DepartmentWrapper departmentWrapper = (DepartmentWrapper)obj;

		if (Objects.equals(_department, departmentWrapper._department)) {
			return true;
		}

		return false;
	}

	@Override
	public Department getWrappedModel() {
		return _department;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _department.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _department.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_department.resetOriginalValues();
	}

	private final Department _department;
}