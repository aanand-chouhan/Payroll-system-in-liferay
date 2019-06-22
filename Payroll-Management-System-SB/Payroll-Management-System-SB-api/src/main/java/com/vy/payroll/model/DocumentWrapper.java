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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.sql.Blob;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Document}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Document
 * @generated
 */
@ProviderType
public class DocumentWrapper implements Document, ModelWrapper<Document> {
	public DocumentWrapper(Document document) {
		_document = document;
	}

	@Override
	public Class<?> getModelClass() {
		return Document.class;
	}

	@Override
	public String getModelClassName() {
		return Document.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("docId", getDocId());
		attributes.put("name", getName());
		attributes.put("mimeType", getMimeType());
		attributes.put("document", getDocument());
		attributes.put("eno", getEno());
		attributes.put("is_uploaded", getIs_uploaded());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long docId = (Long)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String mimeType = (String)attributes.get("mimeType");

		if (mimeType != null) {
			setMimeType(mimeType);
		}

		Blob document = (Blob)attributes.get("document");

		if (document != null) {
			setDocument(document);
		}

		Long eno = (Long)attributes.get("eno");

		if (eno != null) {
			setEno(eno);
		}

		Integer is_uploaded = (Integer)attributes.get("is_uploaded");

		if (is_uploaded != null) {
			setIs_uploaded(is_uploaded);
		}
	}

	@Override
	public Object clone() {
		return new DocumentWrapper((Document)_document.clone());
	}

	@Override
	public int compareTo(Document document) {
		return _document.compareTo(document);
	}

	/**
	* Returns the doc ID of this document.
	*
	* @return the doc ID of this document
	*/
	@Override
	public long getDocId() {
		return _document.getDocId();
	}

	/**
	* Returns the document of this document.
	*
	* @return the document of this document
	*/
	@Override
	public Blob getDocument() {
		return _document.getDocument();
	}

	/**
	* Returns the eno of this document.
	*
	* @return the eno of this document
	*/
	@Override
	public long getEno() {
		return _document.getEno();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _document.getExpandoBridge();
	}

	/**
	* Returns the is_uploaded of this document.
	*
	* @return the is_uploaded of this document
	*/
	@Override
	public int getIs_uploaded() {
		return _document.getIs_uploaded();
	}

	/**
	* Returns the mime type of this document.
	*
	* @return the mime type of this document
	*/
	@Override
	public String getMimeType() {
		return _document.getMimeType();
	}

	/**
	* Returns the name of this document.
	*
	* @return the name of this document
	*/
	@Override
	public String getName() {
		return _document.getName();
	}

	/**
	* Returns the primary key of this document.
	*
	* @return the primary key of this document
	*/
	@Override
	public long getPrimaryKey() {
		return _document.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _document.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _document.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _document.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _document.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _document.isNew();
	}

	@Override
	public void persist() {
		_document.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_document.setCachedModel(cachedModel);
	}

	/**
	* Sets the doc ID of this document.
	*
	* @param docId the doc ID of this document
	*/
	@Override
	public void setDocId(long docId) {
		_document.setDocId(docId);
	}

	/**
	* Sets the document of this document.
	*
	* @param document the document of this document
	*/
	@Override
	public void setDocument(Blob document) {
		_document.setDocument(document);
	}

	/**
	* Sets the eno of this document.
	*
	* @param eno the eno of this document
	*/
	@Override
	public void setEno(long eno) {
		_document.setEno(eno);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_document.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_document.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_document.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the is_uploaded of this document.
	*
	* @param is_uploaded the is_uploaded of this document
	*/
	@Override
	public void setIs_uploaded(int is_uploaded) {
		_document.setIs_uploaded(is_uploaded);
	}

	/**
	* Sets the mime type of this document.
	*
	* @param mimeType the mime type of this document
	*/
	@Override
	public void setMimeType(String mimeType) {
		_document.setMimeType(mimeType);
	}

	/**
	* Sets the name of this document.
	*
	* @param name the name of this document
	*/
	@Override
	public void setName(String name) {
		_document.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_document.setNew(n);
	}

	/**
	* Sets the primary key of this document.
	*
	* @param primaryKey the primary key of this document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_document.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_document.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Document> toCacheModel() {
		return _document.toCacheModel();
	}

	@Override
	public Document toEscapedModel() {
		return new DocumentWrapper(_document.toEscapedModel());
	}

	@Override
	public String toString() {
		return _document.toString();
	}

	@Override
	public Document toUnescapedModel() {
		return new DocumentWrapper(_document.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _document.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentWrapper)) {
			return false;
		}

		DocumentWrapper documentWrapper = (DocumentWrapper)obj;

		if (Objects.equals(_document, documentWrapper._document)) {
			return true;
		}

		return false;
	}

	@Override
	public Document getWrappedModel() {
		return _document;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _document.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _document.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_document.resetOriginalValues();
	}

	private final Document _document;
}