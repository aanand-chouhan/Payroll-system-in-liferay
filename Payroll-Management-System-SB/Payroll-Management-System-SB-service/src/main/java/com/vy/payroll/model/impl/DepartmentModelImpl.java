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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.vy.payroll.model.Department;
import com.vy.payroll.model.DepartmentModel;
import com.vy.payroll.model.DepartmentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Department service. Represents a row in the &quot;department&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DepartmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DepartmentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentImpl
 * @see Department
 * @see DepartmentModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DepartmentModelImpl extends BaseModelImpl<Department>
	implements DepartmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a department model instance should use the {@link Department} interface instead.
	 */
	public static final String TABLE_NAME = "department";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dno", Types.INTEGER },
			{ "dName", Types.VARCHAR },
			{ "eid", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dno", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("dName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eid", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table department (dno INTEGER not null primary key,dName VARCHAR(75) null,eid VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table department";
	public static final String ORDER_BY_JPQL = " ORDER BY department.dno ASC";
	public static final String ORDER_BY_SQL = " ORDER BY department.dno ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.vy.payroll.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.vy.payroll.model.Department"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.vy.payroll.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.vy.payroll.model.Department"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Department toModel(DepartmentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Department model = new DepartmentImpl();

		model.setDno(soapModel.getDno());
		model.setDName(soapModel.getDName());
		model.setEid(soapModel.getEid());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Department> toModels(DepartmentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Department> models = new ArrayList<Department>(soapModels.length);

		for (DepartmentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.vy.payroll.service.util.ServiceProps.get(
				"lock.expiration.time.com.vy.payroll.model.Department"));

	public DepartmentModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _dno;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setDno(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dno;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Department.class;
	}

	@Override
	public String getModelClassName() {
		return Department.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dno", getDno());
		attributes.put("dName", getDName());
		attributes.put("eid", getEid());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer dno = (Integer)attributes.get("dno");

		if (dno != null) {
			setDno(dno);
		}

		String dName = (String)attributes.get("dName");

		if (dName != null) {
			setDName(dName);
		}

		String eid = (String)attributes.get("eid");

		if (eid != null) {
			setEid(eid);
		}
	}

	@JSON
	@Override
	public int getDno() {
		return _dno;
	}

	@Override
	public void setDno(int dno) {
		_dno = dno;
	}

	@JSON
	@Override
	public String getDName() {
		if (_dName == null) {
			return "";
		}
		else {
			return _dName;
		}
	}

	@Override
	public void setDName(String dName) {
		_dName = dName;
	}

	@JSON
	@Override
	public String getEid() {
		if (_eid == null) {
			return "";
		}
		else {
			return _eid;
		}
	}

	@Override
	public void setEid(String eid) {
		_eid = eid;
	}

	@Override
	public Department toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Department)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DepartmentImpl departmentImpl = new DepartmentImpl();

		departmentImpl.setDno(getDno());
		departmentImpl.setDName(getDName());
		departmentImpl.setEid(getEid());

		departmentImpl.resetOriginalValues();

		return departmentImpl;
	}

	@Override
	public int compareTo(Department department) {
		int primaryKey = department.getPrimaryKey();

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

		if (!(obj instanceof Department)) {
			return false;
		}

		Department department = (Department)obj;

		int primaryKey = department.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
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
	}

	@Override
	public CacheModel<Department> toCacheModel() {
		DepartmentCacheModel departmentCacheModel = new DepartmentCacheModel();

		departmentCacheModel.dno = getDno();

		departmentCacheModel.dName = getDName();

		String dName = departmentCacheModel.dName;

		if ((dName != null) && (dName.length() == 0)) {
			departmentCacheModel.dName = null;
		}

		departmentCacheModel.eid = getEid();

		String eid = departmentCacheModel.eid;

		if ((eid != null) && (eid.length() == 0)) {
			departmentCacheModel.eid = null;
		}

		return departmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{dno=");
		sb.append(getDno());
		sb.append(", dName=");
		sb.append(getDName());
		sb.append(", eid=");
		sb.append(getEid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.vy.payroll.model.Department");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dno</column-name><column-value><![CDATA[");
		sb.append(getDno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dName</column-name><column-value><![CDATA[");
		sb.append(getDName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eid</column-name><column-value><![CDATA[");
		sb.append(getEid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Department.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Department.class, ModelWrapper.class
		};
	private int _dno;
	private String _dName;
	private String _eid;
	private Department _escapedModel;
}