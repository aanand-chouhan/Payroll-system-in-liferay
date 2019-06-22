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

package com.vy.payroll.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.vy.payroll.model.EmployeeDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @generated
 */
@ProviderType
public class EmployeeDetailsCacheModel implements CacheModel<EmployeeDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeDetailsCacheModel)) {
			return false;
		}

		EmployeeDetailsCacheModel employeeDetailsCacheModel = (EmployeeDetailsCacheModel)obj;

		if (eno == employeeDetailsCacheModel.eno) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eno);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{eno=");
		sb.append(eno);
		sb.append(", eid=");
		sb.append(eid);
		sb.append(", eName=");
		sb.append(eName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", password=");
		sb.append(password);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", panCardNo=");
		sb.append(panCardNo);
		sb.append(", adharCardNo=");
		sb.append(adharCardNo);
		sb.append(", uanNo=");
		sb.append(uanNo);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", doj=");
		sb.append(doj);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", role=");
		sb.append(role);
		sb.append(", address=");
		sb.append(address);
		sb.append(", qualificationS=");
		sb.append(qualificationS);

		return sb.toString();
	}

	@Override
	public EmployeeDetails toEntityModel() {
		EmployeeDetailsImpl employeeDetailsImpl = new EmployeeDetailsImpl();

		employeeDetailsImpl.setEno(eno);

		if (eid == null) {
			employeeDetailsImpl.setEid("");
		}
		else {
			employeeDetailsImpl.setEid(eid);
		}

		if (eName == null) {
			employeeDetailsImpl.setEName("");
		}
		else {
			employeeDetailsImpl.setEName(eName);
		}

		if (email == null) {
			employeeDetailsImpl.setEmail("");
		}
		else {
			employeeDetailsImpl.setEmail(email);
		}

		if (password == null) {
			employeeDetailsImpl.setPassword("");
		}
		else {
			employeeDetailsImpl.setPassword(password);
		}

		if (gender == null) {
			employeeDetailsImpl.setGender("");
		}
		else {
			employeeDetailsImpl.setGender(gender);
		}

		employeeDetailsImpl.setMobileNo(mobileNo);

		if (panCardNo == null) {
			employeeDetailsImpl.setPanCardNo("");
		}
		else {
			employeeDetailsImpl.setPanCardNo(panCardNo);
		}

		employeeDetailsImpl.setAdharCardNo(adharCardNo);
		employeeDetailsImpl.setUanNo(uanNo);

		if (dob == Long.MIN_VALUE) {
			employeeDetailsImpl.setDob(null);
		}
		else {
			employeeDetailsImpl.setDob(new Date(dob));
		}

		if (doj == Long.MIN_VALUE) {
			employeeDetailsImpl.setDoj(null);
		}
		else {
			employeeDetailsImpl.setDoj(new Date(doj));
		}

		if (designation == null) {
			employeeDetailsImpl.setDesignation("");
		}
		else {
			employeeDetailsImpl.setDesignation(designation);
		}

		if (role == null) {
			employeeDetailsImpl.setRole("");
		}
		else {
			employeeDetailsImpl.setRole(role);
		}

		if (address == null) {
			employeeDetailsImpl.setAddress("");
		}
		else {
			employeeDetailsImpl.setAddress(address);
		}

		if (qualificationS == null) {
			employeeDetailsImpl.setQualificationS("");
		}
		else {
			employeeDetailsImpl.setQualificationS(qualificationS);
		}

		employeeDetailsImpl.resetOriginalValues();

		return employeeDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eno = objectInput.readLong();
		eid = objectInput.readUTF();
		eName = objectInput.readUTF();
		email = objectInput.readUTF();
		password = objectInput.readUTF();
		gender = objectInput.readUTF();

		mobileNo = objectInput.readInt();
		panCardNo = objectInput.readUTF();

		adharCardNo = objectInput.readLong();

		uanNo = objectInput.readLong();
		dob = objectInput.readLong();
		doj = objectInput.readLong();
		designation = objectInput.readUTF();
		role = objectInput.readUTF();
		address = objectInput.readUTF();
		qualificationS = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eno);

		if (eid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eid);
		}

		if (eName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeInt(mobileNo);

		if (panCardNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panCardNo);
		}

		objectOutput.writeLong(adharCardNo);

		objectOutput.writeLong(uanNo);
		objectOutput.writeLong(dob);
		objectOutput.writeLong(doj);

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (qualificationS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(qualificationS);
		}
	}

	public long eno;
	public String eid;
	public String eName;
	public String email;
	public String password;
	public String gender;
	public int mobileNo;
	public String panCardNo;
	public long adharCardNo;
	public long uanNo;
	public long dob;
	public long doj;
	public String designation;
	public String role;
	public String address;
	public String qualificationS;
}