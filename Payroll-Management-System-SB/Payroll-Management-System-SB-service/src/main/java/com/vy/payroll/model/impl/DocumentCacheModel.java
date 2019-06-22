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

import com.vy.payroll.model.Document;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Document
 * @generated
 */
@ProviderType
public class DocumentCacheModel implements CacheModel<Document>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentCacheModel)) {
			return false;
		}

		DocumentCacheModel documentCacheModel = (DocumentCacheModel)obj;

		if (docId == documentCacheModel.docId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, docId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{docId=");
		sb.append(docId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", mimeType=");
		sb.append(mimeType);
		sb.append(", eno=");
		sb.append(eno);
		sb.append(", is_uploaded=");
		sb.append(is_uploaded);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocId(docId);

		if (name == null) {
			documentImpl.setName("");
		}
		else {
			documentImpl.setName(name);
		}

		if (mimeType == null) {
			documentImpl.setMimeType("");
		}
		else {
			documentImpl.setMimeType(mimeType);
		}

		documentImpl.setEno(eno);
		documentImpl.setIs_uploaded(is_uploaded);

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		docId = objectInput.readLong();
		name = objectInput.readUTF();
		mimeType = objectInput.readUTF();

		eno = objectInput.readLong();

		is_uploaded = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(docId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (mimeType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mimeType);
		}

		objectOutput.writeLong(eno);

		objectOutput.writeInt(is_uploaded);
	}

	public long docId;
	public String name;
	public String mimeType;
	public long eno;
	public int is_uploaded;
}