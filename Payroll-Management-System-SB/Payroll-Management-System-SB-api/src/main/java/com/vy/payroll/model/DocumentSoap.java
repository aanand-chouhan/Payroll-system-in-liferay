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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vy.payroll.service.http.DocumentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.http.DocumentServiceSoap
 * @generated
 */
@ProviderType
public class DocumentSoap implements Serializable {
	public static DocumentSoap toSoapModel(Document model) {
		DocumentSoap soapModel = new DocumentSoap();

		soapModel.setDocId(model.getDocId());
		soapModel.setName(model.getName());
		soapModel.setMimeType(model.getMimeType());
		soapModel.setDocument(model.getDocument());
		soapModel.setEno(model.getEno());
		soapModel.setIs_uploaded(model.getIs_uploaded());

		return soapModel;
	}

	public static DocumentSoap[] toSoapModels(Document[] models) {
		DocumentSoap[] soapModels = new DocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentSoap[][] toSoapModels(Document[][] models) {
		DocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentSoap[] toSoapModels(List<Document> models) {
		List<DocumentSoap> soapModels = new ArrayList<DocumentSoap>(models.size());

		for (Document model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocumentSoap[soapModels.size()]);
	}

	public DocumentSoap() {
	}

	public long getPrimaryKey() {
		return _docId;
	}

	public void setPrimaryKey(long pk) {
		setDocId(pk);
	}

	public long getDocId() {
		return _docId;
	}

	public void setDocId(long docId) {
		_docId = docId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMimeType() {
		return _mimeType;
	}

	public void setMimeType(String mimeType) {
		_mimeType = mimeType;
	}

	public Blob getDocument() {
		return _document;
	}

	public void setDocument(Blob document) {
		_document = document;
	}

	public long getEno() {
		return _eno;
	}

	public void setEno(long eno) {
		_eno = eno;
	}

	public int getIs_uploaded() {
		return _is_uploaded;
	}

	public void setIs_uploaded(int is_uploaded) {
		_is_uploaded = is_uploaded;
	}

	private long _docId;
	private String _name;
	private String _mimeType;
	private Blob _document;
	private long _eno;
	private int _is_uploaded;
}