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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.vy.payroll.model.Document;
import com.vy.payroll.model.DocumentDocumentBlobModel;
import com.vy.payroll.model.DocumentModel;
import com.vy.payroll.model.DocumentSoap;
import com.vy.payroll.service.DocumentLocalServiceUtil;

import java.io.Serializable;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Document service. Represents a row in the &quot;emp_documents&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DocumentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DocumentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentImpl
 * @see Document
 * @see DocumentModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DocumentModelImpl extends BaseModelImpl<Document>
	implements DocumentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document model instance should use the {@link Document} interface instead.
	 */
	public static final String TABLE_NAME = "emp_documents";
	public static final Object[][] TABLE_COLUMNS = {
			{ "docId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "mimeType", Types.VARCHAR },
			{ "document", Types.BLOB },
			{ "eno", Types.BIGINT },
			{ "is_uploaded", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("docId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mimeType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("document", Types.BLOB);
		TABLE_COLUMNS_MAP.put("eno", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("is_uploaded", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table emp_documents (docId LONG not null primary key,name VARCHAR(75) null,mimeType VARCHAR(75) null,document BLOB,eno LONG,is_uploaded INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table emp_documents";
	public static final String ORDER_BY_JPQL = " ORDER BY document.docId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY emp_documents.docId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.vy.payroll.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.vy.payroll.model.Document"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.vy.payroll.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.vy.payroll.model.Document"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.vy.payroll.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.vy.payroll.model.Document"),
			true);
	public static final long ENO_COLUMN_BITMASK = 1L;
	public static final long DOCID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Document toModel(DocumentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Document model = new DocumentImpl();

		model.setDocId(soapModel.getDocId());
		model.setName(soapModel.getName());
		model.setMimeType(soapModel.getMimeType());
		model.setDocument(soapModel.getDocument());
		model.setEno(soapModel.getEno());
		model.setIs_uploaded(soapModel.getIs_uploaded());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Document> toModels(DocumentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Document> models = new ArrayList<Document>(soapModels.length);

		for (DocumentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.vy.payroll.service.util.ServiceProps.get(
				"lock.expiration.time.com.vy.payroll.model.Document"));

	public DocumentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _docId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDocId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _docId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getDocId() {
		return _docId;
	}

	@Override
	public void setDocId(long docId) {
		_docId = docId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getMimeType() {
		if (_mimeType == null) {
			return "";
		}
		else {
			return _mimeType;
		}
	}

	@Override
	public void setMimeType(String mimeType) {
		_mimeType = mimeType;
	}

	@JSON
	@Override
	public Blob getDocument() {
		if (_documentBlobModel == null) {
			try {
				_documentBlobModel = DocumentLocalServiceUtil.getDocumentBlobModel(getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_documentBlobModel != null) {
			blob = _documentBlobModel.getDocumentBlob();
		}

		return blob;
	}

	@Override
	public void setDocument(Blob document) {
		if (_documentBlobModel == null) {
			_documentBlobModel = new DocumentDocumentBlobModel(getPrimaryKey(),
					document);
		}
		else {
			_documentBlobModel.setDocumentBlob(document);
		}
	}

	@JSON
	@Override
	public long getEno() {
		return _eno;
	}

	@Override
	public void setEno(long eno) {
		_columnBitmask |= ENO_COLUMN_BITMASK;

		if (!_setOriginalEno) {
			_setOriginalEno = true;

			_originalEno = _eno;
		}

		_eno = eno;
	}

	public long getOriginalEno() {
		return _originalEno;
	}

	@JSON
	@Override
	public int getIs_uploaded() {
		return _is_uploaded;
	}

	@Override
	public void setIs_uploaded(int is_uploaded) {
		_is_uploaded = is_uploaded;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Document.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Document toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Document)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocId(getDocId());
		documentImpl.setName(getName());
		documentImpl.setMimeType(getMimeType());
		documentImpl.setEno(getEno());
		documentImpl.setIs_uploaded(getIs_uploaded());

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public int compareTo(Document document) {
		long primaryKey = document.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Document)) {
			return false;
		}

		Document document = (Document)obj;

		long primaryKey = document.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		DocumentModelImpl documentModelImpl = this;

		documentModelImpl._documentBlobModel = null;

		documentModelImpl._originalEno = documentModelImpl._eno;

		documentModelImpl._setOriginalEno = false;

		documentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Document> toCacheModel() {
		DocumentCacheModel documentCacheModel = new DocumentCacheModel();

		documentCacheModel.docId = getDocId();

		documentCacheModel.name = getName();

		String name = documentCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			documentCacheModel.name = null;
		}

		documentCacheModel.mimeType = getMimeType();

		String mimeType = documentCacheModel.mimeType;

		if ((mimeType != null) && (mimeType.length() == 0)) {
			documentCacheModel.mimeType = null;
		}

		documentCacheModel.eno = getEno();

		documentCacheModel.is_uploaded = getIs_uploaded();

		return documentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{docId=");
		sb.append(getDocId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", mimeType=");
		sb.append(getMimeType());
		sb.append(", eno=");
		sb.append(getEno());
		sb.append(", is_uploaded=");
		sb.append(getIs_uploaded());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.vy.payroll.model.Document");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>docId</column-name><column-value><![CDATA[");
		sb.append(getDocId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mimeType</column-name><column-value><![CDATA[");
		sb.append(getMimeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eno</column-name><column-value><![CDATA[");
		sb.append(getEno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>is_uploaded</column-name><column-value><![CDATA[");
		sb.append(getIs_uploaded());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Document.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Document.class, ModelWrapper.class
		};
	private long _docId;
	private String _name;
	private String _mimeType;
	private DocumentDocumentBlobModel _documentBlobModel;
	private long _eno;
	private long _originalEno;
	private boolean _setOriginalEno;
	private int _is_uploaded;
	private long _columnBitmask;
	private Document _escapedModel;
}