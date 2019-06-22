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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vy.payroll.service.http.LeaveRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.http.LeaveRequestServiceSoap
 * @generated
 */
@ProviderType
public class LeaveRequestSoap implements Serializable {
	public static LeaveRequestSoap toSoapModel(LeaveRequest model) {
		LeaveRequestSoap soapModel = new LeaveRequestSoap();

		soapModel.setRequest_id(model.getRequest_id());
		soapModel.setEid(model.getEid());
		soapModel.setReason(model.getReason());
		soapModel.setIs_checked(model.getIs_checked());
		soapModel.setDate(model.getDate());

		return soapModel;
	}

	public static LeaveRequestSoap[] toSoapModels(LeaveRequest[] models) {
		LeaveRequestSoap[] soapModels = new LeaveRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveRequestSoap[][] toSoapModels(LeaveRequest[][] models) {
		LeaveRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveRequestSoap[] toSoapModels(List<LeaveRequest> models) {
		List<LeaveRequestSoap> soapModels = new ArrayList<LeaveRequestSoap>(models.size());

		for (LeaveRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveRequestSoap[soapModels.size()]);
	}

	public LeaveRequestSoap() {
	}

	public int getPrimaryKey() {
		return _request_id;
	}

	public void setPrimaryKey(int pk) {
		setRequest_id(pk);
	}

	public int getRequest_id() {
		return _request_id;
	}

	public void setRequest_id(int request_id) {
		_request_id = request_id;
	}

	public String getEid() {
		return _eid;
	}

	public void setEid(String eid) {
		_eid = eid;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public String getIs_checked() {
		return _is_checked;
	}

	public void setIs_checked(String is_checked) {
		_is_checked = is_checked;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	private int _request_id;
	private String _eid;
	private String _reason;
	private String _is_checked;
	private Date _date;
}