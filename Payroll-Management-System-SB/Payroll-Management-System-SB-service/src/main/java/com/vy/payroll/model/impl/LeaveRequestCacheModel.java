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

import com.vy.payroll.model.LeaveRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequest
 * @generated
 */
@ProviderType
public class LeaveRequestCacheModel implements CacheModel<LeaveRequest>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveRequestCacheModel)) {
			return false;
		}

		LeaveRequestCacheModel leaveRequestCacheModel = (LeaveRequestCacheModel)obj;

		if (request_id == leaveRequestCacheModel.request_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, request_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{request_id=");
		sb.append(request_id);
		sb.append(", eid=");
		sb.append(eid);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", is_checked=");
		sb.append(is_checked);
		sb.append(", date=");
		sb.append(date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveRequest toEntityModel() {
		LeaveRequestImpl leaveRequestImpl = new LeaveRequestImpl();

		leaveRequestImpl.setRequest_id(request_id);

		if (eid == null) {
			leaveRequestImpl.setEid("");
		}
		else {
			leaveRequestImpl.setEid(eid);
		}

		if (reason == null) {
			leaveRequestImpl.setReason("");
		}
		else {
			leaveRequestImpl.setReason(reason);
		}

		if (is_checked == null) {
			leaveRequestImpl.setIs_checked("");
		}
		else {
			leaveRequestImpl.setIs_checked(is_checked);
		}

		if (date == Long.MIN_VALUE) {
			leaveRequestImpl.setDate(null);
		}
		else {
			leaveRequestImpl.setDate(new Date(date));
		}

		leaveRequestImpl.resetOriginalValues();

		return leaveRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		request_id = objectInput.readInt();
		eid = objectInput.readUTF();
		reason = objectInput.readUTF();
		is_checked = objectInput.readUTF();
		date = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(request_id);

		if (eid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eid);
		}

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (is_checked == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(is_checked);
		}

		objectOutput.writeLong(date);
	}

	public int request_id;
	public String eid;
	public String reason;
	public String is_checked;
	public long date;
}