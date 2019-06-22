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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vy.payroll.service.http.EmployeeDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.http.EmployeeDetailsServiceSoap
 * @generated
 */
@ProviderType
public class EmployeeDetailsSoap implements Serializable {
	public static EmployeeDetailsSoap toSoapModel(EmployeeDetails model) {
		EmployeeDetailsSoap soapModel = new EmployeeDetailsSoap();

		soapModel.setEno(model.getEno());
		soapModel.setEid(model.getEid());
		soapModel.setEName(model.getEName());
		soapModel.setEmail(model.getEmail());
		soapModel.setPassword(model.getPassword());
		soapModel.setGender(model.getGender());
		soapModel.setMobileNo(model.getMobileNo());
		soapModel.setPanCardNo(model.getPanCardNo());
		soapModel.setAdharCardNo(model.getAdharCardNo());
		soapModel.setUanNo(model.getUanNo());
		soapModel.setDob(model.getDob());
		soapModel.setDoj(model.getDoj());
		soapModel.setDesignation(model.getDesignation());
		soapModel.setRole(model.getRole());
		soapModel.setAddress(model.getAddress());
		soapModel.setQualificationS(model.getQualificationS());
		soapModel.setImage(model.getImage());

		return soapModel;
	}

	public static EmployeeDetailsSoap[] toSoapModels(EmployeeDetails[] models) {
		EmployeeDetailsSoap[] soapModels = new EmployeeDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDetailsSoap[][] toSoapModels(
		EmployeeDetails[][] models) {
		EmployeeDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeDetailsSoap[] toSoapModels(
		List<EmployeeDetails> models) {
		List<EmployeeDetailsSoap> soapModels = new ArrayList<EmployeeDetailsSoap>(models.size());

		for (EmployeeDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeDetailsSoap[soapModels.size()]);
	}

	public EmployeeDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _eno;
	}

	public void setPrimaryKey(long pk) {
		setEno(pk);
	}

	public long getEno() {
		return _eno;
	}

	public void setEno(long eno) {
		_eno = eno;
	}

	public String getEid() {
		return _eid;
	}

	public void setEid(String eid) {
		_eid = eid;
	}

	public String getEName() {
		return _eName;
	}

	public void setEName(String eName) {
		_eName = eName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public int getMobileNo() {
		return _mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		_mobileNo = mobileNo;
	}

	public String getPanCardNo() {
		return _panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		_panCardNo = panCardNo;
	}

	public long getAdharCardNo() {
		return _adharCardNo;
	}

	public void setAdharCardNo(long adharCardNo) {
		_adharCardNo = adharCardNo;
	}

	public long getUanNo() {
		return _uanNo;
	}

	public void setUanNo(long uanNo) {
		_uanNo = uanNo;
	}

	public Date getDob() {
		return _dob;
	}

	public void setDob(Date dob) {
		_dob = dob;
	}

	public Date getDoj() {
		return _doj;
	}

	public void setDoj(Date doj) {
		_doj = doj;
	}

	public String getDesignation() {
		return _designation;
	}

	public void setDesignation(String designation) {
		_designation = designation;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getQualificationS() {
		return _qualificationS;
	}

	public void setQualificationS(String qualificationS) {
		_qualificationS = qualificationS;
	}

	public Blob getImage() {
		return _image;
	}

	public void setImage(Blob image) {
		_image = image;
	}

	private long _eno;
	private String _eid;
	private String _eName;
	private String _email;
	private String _password;
	private String _gender;
	private int _mobileNo;
	private String _panCardNo;
	private long _adharCardNo;
	private long _uanNo;
	private Date _dob;
	private Date _doj;
	private String _designation;
	private String _role;
	private String _address;
	private String _qualificationS;
	private Blob _image;
}