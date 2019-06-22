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
 * This class is a wrapper for {@link Admin_details}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Admin_details
 * @generated
 */
@ProviderType
public class Admin_detailsWrapper implements Admin_details,
	ModelWrapper<Admin_details> {
	public Admin_detailsWrapper(Admin_details admin_details) {
		_admin_details = admin_details;
	}

	@Override
	public Class<?> getModelClass() {
		return Admin_details.class;
	}

	@Override
	public String getModelClassName() {
		return Admin_details.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("admin_id", getAdmin_id());
		attributes.put("userName", getUserName());
		attributes.put("password", getPassword());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer admin_id = (Integer)attributes.get("admin_id");

		if (admin_id != null) {
			setAdmin_id(admin_id);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}
	}

	@Override
	public Object clone() {
		return new Admin_detailsWrapper((Admin_details)_admin_details.clone());
	}

	@Override
	public int compareTo(Admin_details admin_details) {
		return _admin_details.compareTo(admin_details);
	}

	/**
	* Returns the admin_id of this admin_details.
	*
	* @return the admin_id of this admin_details
	*/
	@Override
	public int getAdmin_id() {
		return _admin_details.getAdmin_id();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _admin_details.getExpandoBridge();
	}

	/**
	* Returns the password of this admin_details.
	*
	* @return the password of this admin_details
	*/
	@Override
	public String getPassword() {
		return _admin_details.getPassword();
	}

	/**
	* Returns the primary key of this admin_details.
	*
	* @return the primary key of this admin_details
	*/
	@Override
	public int getPrimaryKey() {
		return _admin_details.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _admin_details.getPrimaryKeyObj();
	}

	/**
	* Returns the user name of this admin_details.
	*
	* @return the user name of this admin_details
	*/
	@Override
	public String getUserName() {
		return _admin_details.getUserName();
	}

	@Override
	public int hashCode() {
		return _admin_details.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _admin_details.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _admin_details.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _admin_details.isNew();
	}

	@Override
	public void persist() {
		_admin_details.persist();
	}

	/**
	* Sets the admin_id of this admin_details.
	*
	* @param admin_id the admin_id of this admin_details
	*/
	@Override
	public void setAdmin_id(int admin_id) {
		_admin_details.setAdmin_id(admin_id);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_admin_details.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_admin_details.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_admin_details.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_admin_details.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_admin_details.setNew(n);
	}

	/**
	* Sets the password of this admin_details.
	*
	* @param password the password of this admin_details
	*/
	@Override
	public void setPassword(String password) {
		_admin_details.setPassword(password);
	}

	/**
	* Sets the primary key of this admin_details.
	*
	* @param primaryKey the primary key of this admin_details
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_admin_details.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_admin_details.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user name of this admin_details.
	*
	* @param userName the user name of this admin_details
	*/
	@Override
	public void setUserName(String userName) {
		_admin_details.setUserName(userName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Admin_details> toCacheModel() {
		return _admin_details.toCacheModel();
	}

	@Override
	public Admin_details toEscapedModel() {
		return new Admin_detailsWrapper(_admin_details.toEscapedModel());
	}

	@Override
	public String toString() {
		return _admin_details.toString();
	}

	@Override
	public Admin_details toUnescapedModel() {
		return new Admin_detailsWrapper(_admin_details.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _admin_details.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Admin_detailsWrapper)) {
			return false;
		}

		Admin_detailsWrapper admin_detailsWrapper = (Admin_detailsWrapper)obj;

		if (Objects.equals(_admin_details, admin_detailsWrapper._admin_details)) {
			return true;
		}

		return false;
	}

	@Override
	public Admin_details getWrappedModel() {
		return _admin_details;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _admin_details.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _admin_details.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_admin_details.resetOriginalValues();
	}

	private final Admin_details _admin_details;
}