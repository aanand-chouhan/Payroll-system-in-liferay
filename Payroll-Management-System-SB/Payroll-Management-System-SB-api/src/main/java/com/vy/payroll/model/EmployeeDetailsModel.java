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

import java.util.Date;

/**
 * The base model interface for the EmployeeDetails service. Represents a row in the &quot;emp_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.vy.payroll.model.impl.EmployeeDetailsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.vy.payroll.model.impl.EmployeeDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @see com.vy.payroll.model.impl.EmployeeDetailsImpl
 * @see com.vy.payroll.model.impl.EmployeeDetailsModelImpl
 * @generated
 */
@ProviderType
public interface EmployeeDetailsModel extends BaseModel<EmployeeDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee details model instance should use the {@link EmployeeDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this employee details.
	 *
	 * @return the primary key of this employee details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee details.
	 *
	 * @param primaryKey the primary key of this employee details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the eno of this employee details.
	 *
	 * @return the eno of this employee details
	 */
	public long getEno();

	/**
	 * Sets the eno of this employee details.
	 *
	 * @param eno the eno of this employee details
	 */
	public void setEno(long eno);

	/**
	 * Returns the eid of this employee details.
	 *
	 * @return the eid of this employee details
	 */
	@AutoEscape
	public String getEid();

	/**
	 * Sets the eid of this employee details.
	 *
	 * @param eid the eid of this employee details
	 */
	public void setEid(String eid);

	/**
	 * Returns the e name of this employee details.
	 *
	 * @return the e name of this employee details
	 */
	@AutoEscape
	public String getEName();

	/**
	 * Sets the e name of this employee details.
	 *
	 * @param eName the e name of this employee details
	 */
	public void setEName(String eName);

	/**
	 * Returns the email of this employee details.
	 *
	 * @return the email of this employee details
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this employee details.
	 *
	 * @param email the email of this employee details
	 */
	public void setEmail(String email);

	/**
	 * Returns the password of this employee details.
	 *
	 * @return the password of this employee details
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this employee details.
	 *
	 * @param password the password of this employee details
	 */
	public void setPassword(String password);

	/**
	 * Returns the gender of this employee details.
	 *
	 * @return the gender of this employee details
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this employee details.
	 *
	 * @param gender the gender of this employee details
	 */
	public void setGender(String gender);

	/**
	 * Returns the mobile no of this employee details.
	 *
	 * @return the mobile no of this employee details
	 */
	public int getMobileNo();

	/**
	 * Sets the mobile no of this employee details.
	 *
	 * @param mobileNo the mobile no of this employee details
	 */
	public void setMobileNo(int mobileNo);

	/**
	 * Returns the pan card no of this employee details.
	 *
	 * @return the pan card no of this employee details
	 */
	@AutoEscape
	public String getPanCardNo();

	/**
	 * Sets the pan card no of this employee details.
	 *
	 * @param panCardNo the pan card no of this employee details
	 */
	public void setPanCardNo(String panCardNo);

	/**
	 * Returns the adhar card no of this employee details.
	 *
	 * @return the adhar card no of this employee details
	 */
	public long getAdharCardNo();

	/**
	 * Sets the adhar card no of this employee details.
	 *
	 * @param adharCardNo the adhar card no of this employee details
	 */
	public void setAdharCardNo(long adharCardNo);

	/**
	 * Returns the uan no of this employee details.
	 *
	 * @return the uan no of this employee details
	 */
	public long getUanNo();

	/**
	 * Sets the uan no of this employee details.
	 *
	 * @param uanNo the uan no of this employee details
	 */
	public void setUanNo(long uanNo);

	/**
	 * Returns the dob of this employee details.
	 *
	 * @return the dob of this employee details
	 */
	public Date getDob();

	/**
	 * Sets the dob of this employee details.
	 *
	 * @param dob the dob of this employee details
	 */
	public void setDob(Date dob);

	/**
	 * Returns the doj of this employee details.
	 *
	 * @return the doj of this employee details
	 */
	public Date getDoj();

	/**
	 * Sets the doj of this employee details.
	 *
	 * @param doj the doj of this employee details
	 */
	public void setDoj(Date doj);

	/**
	 * Returns the designation of this employee details.
	 *
	 * @return the designation of this employee details
	 */
	@AutoEscape
	public String getDesignation();

	/**
	 * Sets the designation of this employee details.
	 *
	 * @param designation the designation of this employee details
	 */
	public void setDesignation(String designation);

	/**
	 * Returns the role of this employee details.
	 *
	 * @return the role of this employee details
	 */
	@AutoEscape
	public String getRole();

	/**
	 * Sets the role of this employee details.
	 *
	 * @param role the role of this employee details
	 */
	public void setRole(String role);

	/**
	 * Returns the address of this employee details.
	 *
	 * @return the address of this employee details
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this employee details.
	 *
	 * @param address the address of this employee details
	 */
	public void setAddress(String address);

	/**
	 * Returns the qualification s of this employee details.
	 *
	 * @return the qualification s of this employee details
	 */
	@AutoEscape
	public String getQualificationS();

	/**
	 * Sets the qualification s of this employee details.
	 *
	 * @param qualificationS the qualification s of this employee details
	 */
	public void setQualificationS(String qualificationS);

	/**
	 * Returns the image of this employee details.
	 *
	 * @return the image of this employee details
	 */
	public Blob getImage();

	/**
	 * Sets the image of this employee details.
	 *
	 * @param image the image of this employee details
	 */
	public void setImage(Blob image);

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
	public int compareTo(EmployeeDetails employeeDetails);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmployeeDetails> toCacheModel();

	@Override
	public EmployeeDetails toEscapedModel();

	@Override
	public EmployeeDetails toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}