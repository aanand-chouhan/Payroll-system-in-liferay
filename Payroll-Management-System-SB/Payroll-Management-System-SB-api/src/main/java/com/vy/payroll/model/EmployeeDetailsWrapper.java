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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @generated
 */
@ProviderType
public class EmployeeDetailsWrapper implements EmployeeDetails,
	ModelWrapper<EmployeeDetails> {
	public EmployeeDetailsWrapper(EmployeeDetails employeeDetails) {
		_employeeDetails = employeeDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeDetails.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eno", getEno());
		attributes.put("eid", getEid());
		attributes.put("eName", getEName());
		attributes.put("email", getEmail());
		attributes.put("password", getPassword());
		attributes.put("gender", getGender());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("panCardNo", getPanCardNo());
		attributes.put("adharCardNo", getAdharCardNo());
		attributes.put("uanNo", getUanNo());
		attributes.put("dob", getDob());
		attributes.put("doj", getDoj());
		attributes.put("designation", getDesignation());
		attributes.put("role", getRole());
		attributes.put("address", getAddress());
		attributes.put("qualificationS", getQualificationS());
		attributes.put("image", getImage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eno = (Long)attributes.get("eno");

		if (eno != null) {
			setEno(eno);
		}

		String eid = (String)attributes.get("eid");

		if (eid != null) {
			setEid(eid);
		}

		String eName = (String)attributes.get("eName");

		if (eName != null) {
			setEName(eName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Integer mobileNo = (Integer)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String panCardNo = (String)attributes.get("panCardNo");

		if (panCardNo != null) {
			setPanCardNo(panCardNo);
		}

		Long adharCardNo = (Long)attributes.get("adharCardNo");

		if (adharCardNo != null) {
			setAdharCardNo(adharCardNo);
		}

		Long uanNo = (Long)attributes.get("uanNo");

		if (uanNo != null) {
			setUanNo(uanNo);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		Date doj = (Date)attributes.get("doj");

		if (doj != null) {
			setDoj(doj);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String qualificationS = (String)attributes.get("qualificationS");

		if (qualificationS != null) {
			setQualificationS(qualificationS);
		}

		Blob image = (Blob)attributes.get("image");

		if (image != null) {
			setImage(image);
		}
	}

	@Override
	public Object clone() {
		return new EmployeeDetailsWrapper((EmployeeDetails)_employeeDetails.clone());
	}

	@Override
	public int compareTo(EmployeeDetails employeeDetails) {
		return _employeeDetails.compareTo(employeeDetails);
	}

	/**
	* Returns the address of this employee details.
	*
	* @return the address of this employee details
	*/
	@Override
	public String getAddress() {
		return _employeeDetails.getAddress();
	}

	/**
	* Returns the adhar card no of this employee details.
	*
	* @return the adhar card no of this employee details
	*/
	@Override
	public long getAdharCardNo() {
		return _employeeDetails.getAdharCardNo();
	}

	/**
	* Returns the designation of this employee details.
	*
	* @return the designation of this employee details
	*/
	@Override
	public String getDesignation() {
		return _employeeDetails.getDesignation();
	}

	/**
	* Returns the dob of this employee details.
	*
	* @return the dob of this employee details
	*/
	@Override
	public Date getDob() {
		return _employeeDetails.getDob();
	}

	/**
	* Returns the doj of this employee details.
	*
	* @return the doj of this employee details
	*/
	@Override
	public Date getDoj() {
		return _employeeDetails.getDoj();
	}

	/**
	* Returns the eid of this employee details.
	*
	* @return the eid of this employee details
	*/
	@Override
	public String getEid() {
		return _employeeDetails.getEid();
	}

	/**
	* Returns the email of this employee details.
	*
	* @return the email of this employee details
	*/
	@Override
	public String getEmail() {
		return _employeeDetails.getEmail();
	}

	/**
	* Returns the e name of this employee details.
	*
	* @return the e name of this employee details
	*/
	@Override
	public String getEName() {
		return _employeeDetails.getEName();
	}

	/**
	* Returns the eno of this employee details.
	*
	* @return the eno of this employee details
	*/
	@Override
	public long getEno() {
		return _employeeDetails.getEno();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _employeeDetails.getExpandoBridge();
	}

	/**
	* Returns the gender of this employee details.
	*
	* @return the gender of this employee details
	*/
	@Override
	public String getGender() {
		return _employeeDetails.getGender();
	}

	/**
	* Returns the image of this employee details.
	*
	* @return the image of this employee details
	*/
	@Override
	public Blob getImage() {
		return _employeeDetails.getImage();
	}

	/**
	* Returns the mobile no of this employee details.
	*
	* @return the mobile no of this employee details
	*/
	@Override
	public int getMobileNo() {
		return _employeeDetails.getMobileNo();
	}

	/**
	* Returns the pan card no of this employee details.
	*
	* @return the pan card no of this employee details
	*/
	@Override
	public String getPanCardNo() {
		return _employeeDetails.getPanCardNo();
	}

	/**
	* Returns the password of this employee details.
	*
	* @return the password of this employee details
	*/
	@Override
	public String getPassword() {
		return _employeeDetails.getPassword();
	}

	/**
	* Returns the primary key of this employee details.
	*
	* @return the primary key of this employee details
	*/
	@Override
	public long getPrimaryKey() {
		return _employeeDetails.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeDetails.getPrimaryKeyObj();
	}

	/**
	* Returns the qualification s of this employee details.
	*
	* @return the qualification s of this employee details
	*/
	@Override
	public String getQualificationS() {
		return _employeeDetails.getQualificationS();
	}

	/**
	* Returns the role of this employee details.
	*
	* @return the role of this employee details
	*/
	@Override
	public String getRole() {
		return _employeeDetails.getRole();
	}

	/**
	* Returns the uan no of this employee details.
	*
	* @return the uan no of this employee details
	*/
	@Override
	public long getUanNo() {
		return _employeeDetails.getUanNo();
	}

	@Override
	public int hashCode() {
		return _employeeDetails.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _employeeDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _employeeDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _employeeDetails.isNew();
	}

	@Override
	public void persist() {
		_employeeDetails.persist();
	}

	/**
	* Sets the address of this employee details.
	*
	* @param address the address of this employee details
	*/
	@Override
	public void setAddress(String address) {
		_employeeDetails.setAddress(address);
	}

	/**
	* Sets the adhar card no of this employee details.
	*
	* @param adharCardNo the adhar card no of this employee details
	*/
	@Override
	public void setAdharCardNo(long adharCardNo) {
		_employeeDetails.setAdharCardNo(adharCardNo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employeeDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the designation of this employee details.
	*
	* @param designation the designation of this employee details
	*/
	@Override
	public void setDesignation(String designation) {
		_employeeDetails.setDesignation(designation);
	}

	/**
	* Sets the dob of this employee details.
	*
	* @param dob the dob of this employee details
	*/
	@Override
	public void setDob(Date dob) {
		_employeeDetails.setDob(dob);
	}

	/**
	* Sets the doj of this employee details.
	*
	* @param doj the doj of this employee details
	*/
	@Override
	public void setDoj(Date doj) {
		_employeeDetails.setDoj(doj);
	}

	/**
	* Sets the eid of this employee details.
	*
	* @param eid the eid of this employee details
	*/
	@Override
	public void setEid(String eid) {
		_employeeDetails.setEid(eid);
	}

	/**
	* Sets the email of this employee details.
	*
	* @param email the email of this employee details
	*/
	@Override
	public void setEmail(String email) {
		_employeeDetails.setEmail(email);
	}

	/**
	* Sets the e name of this employee details.
	*
	* @param eName the e name of this employee details
	*/
	@Override
	public void setEName(String eName) {
		_employeeDetails.setEName(eName);
	}

	/**
	* Sets the eno of this employee details.
	*
	* @param eno the eno of this employee details
	*/
	@Override
	public void setEno(long eno) {
		_employeeDetails.setEno(eno);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_employeeDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_employeeDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_employeeDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gender of this employee details.
	*
	* @param gender the gender of this employee details
	*/
	@Override
	public void setGender(String gender) {
		_employeeDetails.setGender(gender);
	}

	/**
	* Sets the image of this employee details.
	*
	* @param image the image of this employee details
	*/
	@Override
	public void setImage(Blob image) {
		_employeeDetails.setImage(image);
	}

	/**
	* Sets the mobile no of this employee details.
	*
	* @param mobileNo the mobile no of this employee details
	*/
	@Override
	public void setMobileNo(int mobileNo) {
		_employeeDetails.setMobileNo(mobileNo);
	}

	@Override
	public void setNew(boolean n) {
		_employeeDetails.setNew(n);
	}

	/**
	* Sets the pan card no of this employee details.
	*
	* @param panCardNo the pan card no of this employee details
	*/
	@Override
	public void setPanCardNo(String panCardNo) {
		_employeeDetails.setPanCardNo(panCardNo);
	}

	/**
	* Sets the password of this employee details.
	*
	* @param password the password of this employee details
	*/
	@Override
	public void setPassword(String password) {
		_employeeDetails.setPassword(password);
	}

	/**
	* Sets the primary key of this employee details.
	*
	* @param primaryKey the primary key of this employee details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employeeDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_employeeDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the qualification s of this employee details.
	*
	* @param qualificationS the qualification s of this employee details
	*/
	@Override
	public void setQualificationS(String qualificationS) {
		_employeeDetails.setQualificationS(qualificationS);
	}

	/**
	* Sets the role of this employee details.
	*
	* @param role the role of this employee details
	*/
	@Override
	public void setRole(String role) {
		_employeeDetails.setRole(role);
	}

	/**
	* Sets the uan no of this employee details.
	*
	* @param uanNo the uan no of this employee details
	*/
	@Override
	public void setUanNo(long uanNo) {
		_employeeDetails.setUanNo(uanNo);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EmployeeDetails> toCacheModel() {
		return _employeeDetails.toCacheModel();
	}

	@Override
	public EmployeeDetails toEscapedModel() {
		return new EmployeeDetailsWrapper(_employeeDetails.toEscapedModel());
	}

	@Override
	public String toString() {
		return _employeeDetails.toString();
	}

	@Override
	public EmployeeDetails toUnescapedModel() {
		return new EmployeeDetailsWrapper(_employeeDetails.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _employeeDetails.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeDetailsWrapper)) {
			return false;
		}

		EmployeeDetailsWrapper employeeDetailsWrapper = (EmployeeDetailsWrapper)obj;

		if (Objects.equals(_employeeDetails,
					employeeDetailsWrapper._employeeDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public EmployeeDetails getWrappedModel() {
		return _employeeDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _employeeDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _employeeDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_employeeDetails.resetOriginalValues();
	}

	private final EmployeeDetails _employeeDetails;
}