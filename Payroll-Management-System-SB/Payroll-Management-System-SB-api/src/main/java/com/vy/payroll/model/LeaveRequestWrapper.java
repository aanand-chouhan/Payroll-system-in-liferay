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
 * This class is a wrapper for {@link LeaveRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequest
 * @generated
 */
@ProviderType
public class LeaveRequestWrapper implements LeaveRequest,
	ModelWrapper<LeaveRequest> {
	public LeaveRequestWrapper(LeaveRequest leaveRequest) {
		_leaveRequest = leaveRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveRequest.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveRequest.class.getName();
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
		return new LeaveRequestWrapper((LeaveRequest)_leaveRequest.clone());
	}

	@Override
	public int compareTo(LeaveRequest leaveRequest) {
		return _leaveRequest.compareTo(leaveRequest);
	}

	/**
	* Returns the date of this leave request.
	*
	* @return the date of this leave request
	*/
	@Override
	public Date getDate() {
		return _leaveRequest.getDate();
	}

	/**
	* Returns the eid of this leave request.
	*
	* @return the eid of this leave request
	*/
	@Override
	public String getEid() {
		return _leaveRequest.getEid();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _leaveRequest.getExpandoBridge();
	}

	/**
	* Returns the is_checked of this leave request.
	*
	* @return the is_checked of this leave request
	*/
	@Override
	public String getIs_checked() {
		return _leaveRequest.getIs_checked();
	}

	/**
	* Returns the primary key of this leave request.
	*
	* @return the primary key of this leave request
	*/
	@Override
	public int getPrimaryKey() {
		return _leaveRequest.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveRequest.getPrimaryKeyObj();
	}

	/**
	* Returns the reason of this leave request.
	*
	* @return the reason of this leave request
	*/
	@Override
	public String getReason() {
		return _leaveRequest.getReason();
	}

	/**
	* Returns the request_id of this leave request.
	*
	* @return the request_id of this leave request
	*/
	@Override
	public int getRequest_id() {
		return _leaveRequest.getRequest_id();
	}

	@Override
	public int hashCode() {
		return _leaveRequest.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _leaveRequest.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveRequest.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _leaveRequest.isNew();
	}

	@Override
	public void persist() {
		_leaveRequest.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveRequest.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this leave request.
	*
	* @param date the date of this leave request
	*/
	@Override
	public void setDate(Date date) {
		_leaveRequest.setDate(date);
	}

	/**
	* Sets the eid of this leave request.
	*
	* @param eid the eid of this leave request
	*/
	@Override
	public void setEid(String eid) {
		_leaveRequest.setEid(eid);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_leaveRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_leaveRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_leaveRequest.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the is_checked of this leave request.
	*
	* @param is_checked the is_checked of this leave request
	*/
	@Override
	public void setIs_checked(String is_checked) {
		_leaveRequest.setIs_checked(is_checked);
	}

	@Override
	public void setNew(boolean n) {
		_leaveRequest.setNew(n);
	}

	/**
	* Sets the primary key of this leave request.
	*
	* @param primaryKey the primary key of this leave request
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_leaveRequest.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_leaveRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reason of this leave request.
	*
	* @param reason the reason of this leave request
	*/
	@Override
	public void setReason(String reason) {
		_leaveRequest.setReason(reason);
	}

	/**
	* Sets the request_id of this leave request.
	*
	* @param request_id the request_id of this leave request
	*/
	@Override
	public void setRequest_id(int request_id) {
		_leaveRequest.setRequest_id(request_id);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LeaveRequest> toCacheModel() {
		return _leaveRequest.toCacheModel();
	}

	@Override
	public LeaveRequest toEscapedModel() {
		return new LeaveRequestWrapper(_leaveRequest.toEscapedModel());
	}

	@Override
	public String toString() {
		return _leaveRequest.toString();
	}

	@Override
	public LeaveRequest toUnescapedModel() {
		return new LeaveRequestWrapper(_leaveRequest.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _leaveRequest.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveRequestWrapper)) {
			return false;
		}

		LeaveRequestWrapper leaveRequestWrapper = (LeaveRequestWrapper)obj;

		if (Objects.equals(_leaveRequest, leaveRequestWrapper._leaveRequest)) {
			return true;
		}

		return false;
	}

	@Override
	public LeaveRequest getWrappedModel() {
		return _leaveRequest;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _leaveRequest.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _leaveRequest.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_leaveRequest.resetOriginalValues();
	}

	private final LeaveRequest _leaveRequest;
}