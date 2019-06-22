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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the document column in Document.
 *
 * @author Brian Wing Shun Chan
 * @see Document
 * @generated
 */
@ProviderType
public class DocumentDocumentBlobModel {
	public DocumentDocumentBlobModel() {
	}

	public DocumentDocumentBlobModel(long docId) {
		_docId = docId;
	}

	public DocumentDocumentBlobModel(long docId, Blob documentBlob) {
		_docId = docId;
		_documentBlob = documentBlob;
	}

	public long getDocId() {
		return _docId;
	}

	public void setDocId(long docId) {
		_docId = docId;
	}

	public Blob getDocumentBlob() {
		return _documentBlob;
	}

	public void setDocumentBlob(Blob documentBlob) {
		_documentBlob = documentBlob;
	}

	private long _docId;
	private Blob _documentBlob;
}