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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.sql.Blob;

/**
 * The base model interface for the Document service. Represents a row in the &quot;emp_documents&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.vy.payroll.model.impl.DocumentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.vy.payroll.model.impl.DocumentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Document
 * @see com.vy.payroll.model.impl.DocumentImpl
 * @see com.vy.payroll.model.impl.DocumentModelImpl
 * @generated
 */
@ProviderType
public interface DocumentModel extends BaseModel<Document> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a document model instance should use the {@link Document} interface instead.
	 */

	/**
	 * Returns the primary key of this document.
	 *
	 * @return the primary key of this document
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this document.
	 *
	 * @param primaryKey the primary key of this document
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the doc ID of this document.
	 *
	 * @return the doc ID of this document
	 */
	public long getDocId();

	/**
	 * Sets the doc ID of this document.
	 *
	 * @param docId the doc ID of this document
	 */
	public void setDocId(long docId);

	/**
	 * Returns the name of this document.
	 *
	 * @return the name of this document
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this document.
	 *
	 * @param name the name of this document
	 */
	public void setName(String name);

	/**
	 * Returns the mime type of this document.
	 *
	 * @return the mime type of this document
	 */
	@AutoEscape
	public String getMimeType();

	/**
	 * Sets the mime type of this document.
	 *
	 * @param mimeType the mime type of this document
	 */
	public void setMimeType(String mimeType);

	/**
	 * Returns the document of this document.
	 *
	 * @return the document of this document
	 */
	public Blob getDocument();

	/**
	 * Sets the document of this document.
	 *
	 * @param document the document of this document
	 */
	public void setDocument(Blob document);

	/**
	 * Returns the eno of this document.
	 *
	 * @return the eno of this document
	 */
	public long getEno();

	/**
	 * Sets the eno of this document.
	 *
	 * @param eno the eno of this document
	 */
	public void setEno(long eno);

	/**
	 * Returns the is_uploaded of this document.
	 *
	 * @return the is_uploaded of this document
	 */
	public int getIs_uploaded();

	/**
	 * Sets the is_uploaded of this document.
	 *
	 * @param is_uploaded the is_uploaded of this document
	 */
	public void setIs_uploaded(int is_uploaded);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Document document);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Document> toCacheModel();

	@Override
	public Document toEscapedModel();

	@Override
	public Document toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}