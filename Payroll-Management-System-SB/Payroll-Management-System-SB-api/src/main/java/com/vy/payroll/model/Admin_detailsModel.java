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

/**
 * The base model interface for the Admin_details service. Represents a row in the &quot;admin_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.vy.payroll.model.impl.Admin_detailsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.vy.payroll.model.impl.Admin_detailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Admin_details
 * @see com.vy.payroll.model.impl.Admin_detailsImpl
 * @see com.vy.payroll.model.impl.Admin_detailsModelImpl
 * @generated
 */
@ProviderType
public interface Admin_detailsModel extends BaseModel<Admin_details> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a admin_details model instance should use the {@link Admin_details} interface instead.
	 */

	/**
	 * Returns the primary key of this admin_details.
	 *
	 * @return the primary key of this admin_details
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this admin_details.
	 *
	 * @param primaryKey the primary key of this admin_details
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the admin_id of this admin_details.
	 *
	 * @return the admin_id of this admin_details
	 */
	public int getAdmin_id();

	/**
	 * Sets the admin_id of this admin_details.
	 *
	 * @param admin_id the admin_id of this admin_details
	 */
	public void setAdmin_id(int admin_id);

	/**
	 * Returns the user name of this admin_details.
	 *
	 * @return the user name of this admin_details
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this admin_details.
	 *
	 * @param userName the user name of this admin_details
	 */
	public void setUserName(String userName);

	/**
	 * Returns the password of this admin_details.
	 *
	 * @return the password of this admin_details
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this admin_details.
	 *
	 * @param password the password of this admin_details
	 */
	public void setPassword(String password);

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
	public int compareTo(Admin_details admin_details);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Admin_details> toCacheModel();

	@Override
	public Admin_details toEscapedModel();

	@Override
	public Admin_details toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}