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
 * This class is used by SOAP remote services, specifically {@link com.vy.payroll.service.http.DepartmentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.http.DepartmentServiceSoap
 * @generated
 */
@ProviderType
public class DepartmentSoap implements Serializable {
	public static DepartmentSoap toSoapModel(Department model) {
		DepartmentSoap soapModel = new DepartmentSoap();

		soapModel.setDno(model.getDno());
		soapModel.setDName(model.getDName());
		soapModel.setEid(model.getEid());

		return soapModel;
	}

	public static DepartmentSoap[] toSoapModels(Department[] models) {
		DepartmentSoap[] soapModels = new DepartmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DepartmentSoap[][] toSoapModels(Department[][] models) {
		DepartmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DepartmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DepartmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DepartmentSoap[] toSoapModels(List<Department> models) {
		List<DepartmentSoap> soapModels = new ArrayList<DepartmentSoap>(models.size());

		for (Department model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DepartmentSoap[soapModels.size()]);
	}

	public DepartmentSoap() {
	}

	public int getPrimaryKey() {
		return _dno;
	}

	public void setPrimaryKey(int pk) {
		setDno(pk);
	}

	public int getDno() {
		return _dno;
	}

	public void setDno(int dno) {
		_dno = dno;
	}

	public String getDName() {
		return _dName;
	}

	public void setDName(String dName) {
		_dName = dName;
	}

	public String getEid() {
		return _eid;
	}

	public void setEid(String eid) {
		_eid = eid;
	}

	private int _dno;
	private String _dName;
	private String _eid;
}