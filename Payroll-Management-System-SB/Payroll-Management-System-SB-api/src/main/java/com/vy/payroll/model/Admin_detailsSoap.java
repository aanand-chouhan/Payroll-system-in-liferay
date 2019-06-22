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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vy.payroll.service.http.Admin_detailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.http.Admin_detailsServiceSoap
 * @generated
 */
@ProviderType
public class Admin_detailsSoap implements Serializable {
	public static Admin_detailsSoap toSoapModel(Admin_details model) {
		Admin_detailsSoap soapModel = new Admin_detailsSoap();

		soapModel.setAdmin_id(model.getAdmin_id());
		soapModel.setUserName(model.getUserName());
		soapModel.setPassword(model.getPassword());

		return soapModel;
	}

	public static Admin_detailsSoap[] toSoapModels(Admin_details[] models) {
		Admin_detailsSoap[] soapModels = new Admin_detailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Admin_detailsSoap[][] toSoapModels(Admin_details[][] models) {
		Admin_detailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Admin_detailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Admin_detailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Admin_detailsSoap[] toSoapModels(List<Admin_details> models) {
		List<Admin_detailsSoap> soapModels = new ArrayList<Admin_detailsSoap>(models.size());

		for (Admin_details model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Admin_detailsSoap[soapModels.size()]);
	}

	public Admin_detailsSoap() {
	}

	public int getPrimaryKey() {
		return _admin_id;
	}

	public void setPrimaryKey(int pk) {
		setAdmin_id(pk);
	}

	public int getAdmin_id() {
		return _admin_id;
	}

	public void setAdmin_id(int admin_id) {
		_admin_id = admin_id;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	private int _admin_id;
	private String _userName;
	private String _password;
}