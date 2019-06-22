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

import com.vy.payroll.model.Department;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Department in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Department
 * @generated
 */
@ProviderType
public class DepartmentCacheModel implements CacheModel<Department>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DepartmentCacheModel)) {
			return false;
		}

		DepartmentCacheModel departmentCacheModel = (DepartmentCacheModel)obj;

		if (dno == departmentCacheModel.dno) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dno);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{dno=");
		sb.append(dno);
		sb.append(", dName=");
		sb.append(dName);
		sb.append(", eid=");
		sb.append(eid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Department toEntityModel() {
		DepartmentImpl departmentImpl = new DepartmentImpl();

		departmentImpl.setDno(dno);

		if (dName == null) {
			departmentImpl.setDName("");
		}
		else {
			departmentImpl.setDName(dName);
		}

		if (eid == null) {
			departmentImpl.setEid("");
		}
		else {
			departmentImpl.setEid(eid);
		}

		departmentImpl.resetOriginalValues();

		return departmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dno = objectInput.readInt();
		dName = objectInput.readUTF();
		eid = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(dno);

		if (dName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dName);
		}

		if (eid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eid);
		}
	}

	public int dno;
	public String dName;
	public String eid;
}