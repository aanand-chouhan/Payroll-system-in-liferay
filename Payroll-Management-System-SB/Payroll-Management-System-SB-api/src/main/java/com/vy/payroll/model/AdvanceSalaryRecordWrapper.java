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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link AdvanceSalaryRecord}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdvanceSalaryRecord
 * @generated
 */
@ProviderType
public class AdvanceSalaryRecordWrapper implements AdvanceSalaryRecord,
	ModelWrapper<AdvanceSalaryRecord> {
	public AdvanceSalaryRecordWrapper(AdvanceSalaryRecord advanceSalaryRecord) {
		_advanceSalaryRecord = advanceSalaryRecord;
	}

	@Override
	public Class<?> getModelClass() {
		return AdvanceSalaryRecord.class;
	}

	@Override
	public String getModelClassName() {
		return AdvanceSalaryRecord.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("request_id", getRequest_id());
		attributes.put("eid", getEid());
		attributes.put("reason", getReason());
		attributes.put("is_checked", getIs_checked());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer request_id = (Integer)attributes.get("request_id");

		if (request_id != null) {
			setRequest_id(request_id);
		}

		String eid = (String)attributes.get("eid");

		if (eid != null) {
			setEid(eid);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String is_checked = (String)attributes.get("is_checked");

		if (is_checked != null) {
			setIs_checked(is_checked);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@Override
	public Object clone() {
		return new AdvanceSalaryRecordWrapper((AdvanceSalaryRecord)_advanceSalaryRecord.clone());
	}

	@Override
	public int compareTo(AdvanceSalaryRecord advanceSalaryRecord) {
		return _advanceSalaryRecord.compareTo(advanceSalaryRecord);
	}

	/**
	* Returns the date of this advance salary record.
	*
	* @return the date of this advance salary record
	*/
	@Override
	public Date getDate() {
		return _advanceSalaryRecord.getDate();
	}

	/**
	* Returns the eid of this advance salary record.
	*
	* @return the eid of this advance salary record
	*/
	@Override
	public String getEid() {
		return _advanceSalaryRecord.getEid();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _advanceSalaryRecord.getExpandoBridge();
	}

	/**
	* Returns the is_checked of this advance salary record.
	*
	* @return the is_checked of this advance salary record
	*/
	@Override
	public String getIs_checked() {
		return _advanceSalaryRecord.getIs_checked();
	}

	/**
	* Returns the primary key of this advance salary record.
	*
	* @return the primary key of this advance salary record
	*/
	@Override
	public int getPrimaryKey() {
		return _advanceSalaryRecord.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _advanceSalaryRecord.getPrimaryKeyObj();
	}

	/**
	* Returns the reason of this advance salary record.
	*
	* @return the reason of this advance salary record
	*/
	@Override
	public String getReason() {
		return _advanceSalaryRecord.getReason();
	}

	/**
	* Returns the request_id of this advance salary record.
	*
	* @return the request_id of this advance salary record
	*/
	@Override
	public int getRequest_id() {
		return _advanceSalaryRecord.getRequest_id();
	}

	@Override
	public int hashCode() {
		return _advanceSalaryRecord.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _advanceSalaryRecord.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _advanceSalaryRecord.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _advanceSalaryRecord.isNew();
	}

	@Override
	public void persist() {
		_advanceSalaryRecord.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_advanceSalaryRecord.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this advance salary record.
	*
	* @param date the date of this advance salary record
	*/
	@Override
	public void setDate(Date date) {
		_advanceSalaryRecord.setDate(date);
	}

	/**
	* Sets the eid of this advance salary record.
	*
	* @param eid the eid of this advance salary record
	*/
	@Override
	public void setEid(String eid) {
		_advanceSalaryRecord.setEid(eid);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_advanceSalaryRecord.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_advanceSalaryRecord.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_advanceSalaryRecord.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the is_checked of this advance salary record.
	*
	* @param is_checked the is_checked of this advance salary record
	*/
	@Override
	public void setIs_checked(String is_checked) {
		_advanceSalaryRecord.setIs_checked(is_checked);
	}

	@Override
	public void setNew(boolean n) {
		_advanceSalaryRecord.setNew(n);
	}

	/**
	* Sets the primary key of this advance salary record.
	*
	* @param primaryKey the primary key of this advance salary record
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_advanceSalaryRecord.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_advanceSalaryRecord.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reason of this advance salary record.
	*
	* @param reason the reason of this advance salary record
	*/
	@Override
	public void setReason(String reason) {
		_advanceSalaryRecord.setReason(reason);
	}

	/**
	* Sets the request_id of this advance salary record.
	*
	* @param request_id the request_id of this advance salary record
	*/
	@Override
	public void setRequest_id(int request_id) {
		_advanceSalaryRecord.setRequest_id(request_id);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AdvanceSalaryRecord> toCacheModel() {
		return _advanceSalaryRecord.toCacheModel();
	}

	@Override
	public AdvanceSalaryRecord toEscapedModel() {
		return new AdvanceSalaryRecordWrapper(_advanceSalaryRecord.toEscapedModel());
	}

	@Override
	public String toString() {
		return _advanceSalaryRecord.toString();
	}

	@Override
	public AdvanceSalaryRecord toUnescapedModel() {
		return new AdvanceSalaryRecordWrapper(_advanceSalaryRecord.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _advanceSalaryRecord.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdvanceSalaryRecordWrapper)) {
			return false;
		}

		AdvanceSalaryRecordWrapper advanceSalaryRecordWrapper = (AdvanceSalaryRecordWrapper)obj;

		if (Objects.equals(_advanceSalaryRecord,
					advanceSalaryRecordWrapper._advanceSalaryRecord)) {
			return true;
		}

		return false;
	}

	@Override
	public AdvanceSalaryRecord getWrappedModel() {
		return _advanceSalaryRecord;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _advanceSalaryRecord.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _advanceSalaryRecord.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_advanceSalaryRecord.resetOriginalValues();
	}

	private final AdvanceSalaryRecord _advanceSalaryRecord;
}