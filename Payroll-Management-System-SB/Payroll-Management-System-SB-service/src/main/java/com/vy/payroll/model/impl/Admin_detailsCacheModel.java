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

import com.vy.payroll.model.Admin_details;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Admin_details in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Admin_details
 * @generated
 */
@ProviderType
public class Admin_detailsCacheModel implements CacheModel<Admin_details>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Admin_detailsCacheModel)) {
			return false;
		}

		Admin_detailsCacheModel admin_detailsCacheModel = (Admin_detailsCacheModel)obj;

		if (admin_id == admin_detailsCacheModel.admin_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, admin_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{admin_id=");
		sb.append(admin_id);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", password=");
		sb.append(password);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Admin_details toEntityModel() {
		Admin_detailsImpl admin_detailsImpl = new Admin_detailsImpl();

		admin_detailsImpl.setAdmin_id(admin_id);

		if (userName == null) {
			admin_detailsImpl.setUserName("");
		}
		else {
			admin_detailsImpl.setUserName(userName);
		}

		if (password == null) {
			admin_detailsImpl.setPassword("");
		}
		else {
			admin_detailsImpl.setPassword(password);
		}

		admin_detailsImpl.resetOriginalValues();

		return admin_detailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		admin_id = objectInput.readInt();
		userName = objectInput.readUTF();
		password = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(admin_id);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}
	}

	public int admin_id;
	public String userName;
	public String password;
}