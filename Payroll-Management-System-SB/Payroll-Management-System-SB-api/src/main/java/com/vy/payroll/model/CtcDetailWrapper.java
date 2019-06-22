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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CtcDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CtcDetail
 * @generated
 */
@ProviderType
public class CtcDetailWrapper implements CtcDetail, ModelWrapper<CtcDetail> {
	public CtcDetailWrapper(CtcDetail ctcDetail) {
		_ctcDetail = ctcDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return CtcDetail.class;
	}

	@Override
	public String getModelClassName() {
		return CtcDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ctc", getCtc());
		attributes.put("hra", getHra());
		attributes.put("ma", getMa());
		attributes.put("ca", getCa());
		attributes.put("ta", getTa());
		attributes.put("pf", getPf());
		attributes.put("sa", getSa());
		attributes.put("incomeTax", getIncomeTax());
		attributes.put("proffesionalTax", getProffesionalTax());
		attributes.put("basicSalary", getBasicSalary());
		attributes.put("contributionAmt", getContributionAmt());
		attributes.put("gratuity", getGratuity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ctc = (Integer)attributes.get("ctc");

		if (ctc != null) {
			setCtc(ctc);
		}

		Integer hra = (Integer)attributes.get("hra");

		if (hra != null) {
			setHra(hra);
		}

		Integer ma = (Integer)attributes.get("ma");

		if (ma != null) {
			setMa(ma);
		}

		Integer ca = (Integer)attributes.get("ca");

		if (ca != null) {
			setCa(ca);
		}

		Integer ta = (Integer)attributes.get("ta");

		if (ta != null) {
			setTa(ta);
		}

		Integer pf = (Integer)attributes.get("pf");

		if (pf != null) {
			setPf(pf);
		}

		Integer sa = (Integer)attributes.get("sa");

		if (sa != null) {
			setSa(sa);
		}

		Integer incomeTax = (Integer)attributes.get("incomeTax");

		if (incomeTax != null) {
			setIncomeTax(incomeTax);
		}

		Integer proffesionalTax = (Integer)attributes.get("proffesionalTax");

		if (proffesionalTax != null) {
			setProffesionalTax(proffesionalTax);
		}

		Integer basicSalary = (Integer)attributes.get("basicSalary");

		if (basicSalary != null) {
			setBasicSalary(basicSalary);
		}

		Integer contributionAmt = (Integer)attributes.get("contributionAmt");

		if (contributionAmt != null) {
			setContributionAmt(contributionAmt);
		}

		Integer gratuity = (Integer)attributes.get("gratuity");

		if (gratuity != null) {
			setGratuity(gratuity);
		}
	}

	@Override
	public Object clone() {
		return new CtcDetailWrapper((CtcDetail)_ctcDetail.clone());
	}

	@Override
	public int compareTo(CtcDetail ctcDetail) {
		return _ctcDetail.compareTo(ctcDetail);
	}

	/**
	* Returns the basic salary of this ctc detail.
	*
	* @return the basic salary of this ctc detail
	*/
	@Override
	public int getBasicSalary() {
		return _ctcDetail.getBasicSalary();
	}

	/**
	* Returns the ca of this ctc detail.
	*
	* @return the ca of this ctc detail
	*/
	@Override
	public int getCa() {
		return _ctcDetail.getCa();
	}

	/**
	* Returns the contribution amt of this ctc detail.
	*
	* @return the contribution amt of this ctc detail
	*/
	@Override
	public int getContributionAmt() {
		return _ctcDetail.getContributionAmt();
	}

	/**
	* Returns the ctc of this ctc detail.
	*
	* @return the ctc of this ctc detail
	*/
	@Override
	public int getCtc() {
		return _ctcDetail.getCtc();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ctcDetail.getExpandoBridge();
	}

	/**
	* Returns the gratuity of this ctc detail.
	*
	* @return the gratuity of this ctc detail
	*/
	@Override
	public int getGratuity() {
		return _ctcDetail.getGratuity();
	}

	/**
	* Returns the hra of this ctc detail.
	*
	* @return the hra of this ctc detail
	*/
	@Override
	public int getHra() {
		return _ctcDetail.getHra();
	}

	/**
	* Returns the income tax of this ctc detail.
	*
	* @return the income tax of this ctc detail
	*/
	@Override
	public int getIncomeTax() {
		return _ctcDetail.getIncomeTax();
	}

	/**
	* Returns the ma of this ctc detail.
	*
	* @return the ma of this ctc detail
	*/
	@Override
	public int getMa() {
		return _ctcDetail.getMa();
	}

	/**
	* Returns the pf of this ctc detail.
	*
	* @return the pf of this ctc detail
	*/
	@Override
	public int getPf() {
		return _ctcDetail.getPf();
	}

	/**
	* Returns the primary key of this ctc detail.
	*
	* @return the primary key of this ctc detail
	*/
	@Override
	public int getPrimaryKey() {
		return _ctcDetail.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ctcDetail.getPrimaryKeyObj();
	}

	/**
	* Returns the proffesional tax of this ctc detail.
	*
	* @return the proffesional tax of this ctc detail
	*/
	@Override
	public int getProffesionalTax() {
		return _ctcDetail.getProffesionalTax();
	}

	/**
	* Returns the sa of this ctc detail.
	*
	* @return the sa of this ctc detail
	*/
	@Override
	public int getSa() {
		return _ctcDetail.getSa();
	}

	/**
	* Returns the ta of this ctc detail.
	*
	* @return the ta of this ctc detail
	*/
	@Override
	public int getTa() {
		return _ctcDetail.getTa();
	}

	@Override
	public int hashCode() {
		return _ctcDetail.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ctcDetail.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ctcDetail.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ctcDetail.isNew();
	}

	@Override
	public void persist() {
		_ctcDetail.persist();
	}

	/**
	* Sets the basic salary of this ctc detail.
	*
	* @param basicSalary the basic salary of this ctc detail
	*/
	@Override
	public void setBasicSalary(int basicSalary) {
		_ctcDetail.setBasicSalary(basicSalary);
	}

	/**
	* Sets the ca of this ctc detail.
	*
	* @param ca the ca of this ctc detail
	*/
	@Override
	public void setCa(int ca) {
		_ctcDetail.setCa(ca);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ctcDetail.setCachedModel(cachedModel);
	}

	/**
	* Sets the contribution amt of this ctc detail.
	*
	* @param contributionAmt the contribution amt of this ctc detail
	*/
	@Override
	public void setContributionAmt(int contributionAmt) {
		_ctcDetail.setContributionAmt(contributionAmt);
	}

	/**
	* Sets the ctc of this ctc detail.
	*
	* @param ctc the ctc of this ctc detail
	*/
	@Override
	public void setCtc(int ctc) {
		_ctcDetail.setCtc(ctc);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ctcDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ctcDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ctcDetail.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gratuity of this ctc detail.
	*
	* @param gratuity the gratuity of this ctc detail
	*/
	@Override
	public void setGratuity(int gratuity) {
		_ctcDetail.setGratuity(gratuity);
	}

	/**
	* Sets the hra of this ctc detail.
	*
	* @param hra the hra of this ctc detail
	*/
	@Override
	public void setHra(int hra) {
		_ctcDetail.setHra(hra);
	}

	/**
	* Sets the income tax of this ctc detail.
	*
	* @param incomeTax the income tax of this ctc detail
	*/
	@Override
	public void setIncomeTax(int incomeTax) {
		_ctcDetail.setIncomeTax(incomeTax);
	}

	/**
	* Sets the ma of this ctc detail.
	*
	* @param ma the ma of this ctc detail
	*/
	@Override
	public void setMa(int ma) {
		_ctcDetail.setMa(ma);
	}

	@Override
	public void setNew(boolean n) {
		_ctcDetail.setNew(n);
	}

	/**
	* Sets the pf of this ctc detail.
	*
	* @param pf the pf of this ctc detail
	*/
	@Override
	public void setPf(int pf) {
		_ctcDetail.setPf(pf);
	}

	/**
	* Sets the primary key of this ctc detail.
	*
	* @param primaryKey the primary key of this ctc detail
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_ctcDetail.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ctcDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the proffesional tax of this ctc detail.
	*
	* @param proffesionalTax the proffesional tax of this ctc detail
	*/
	@Override
	public void setProffesionalTax(int proffesionalTax) {
		_ctcDetail.setProffesionalTax(proffesionalTax);
	}

	/**
	* Sets the sa of this ctc detail.
	*
	* @param sa the sa of this ctc detail
	*/
	@Override
	public void setSa(int sa) {
		_ctcDetail.setSa(sa);
	}

	/**
	* Sets the ta of this ctc detail.
	*
	* @param ta the ta of this ctc detail
	*/
	@Override
	public void setTa(int ta) {
		_ctcDetail.setTa(ta);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CtcDetail> toCacheModel() {
		return _ctcDetail.toCacheModel();
	}

	@Override
	public CtcDetail toEscapedModel() {
		return new CtcDetailWrapper(_ctcDetail.toEscapedModel());
	}

	@Override
	public String toString() {
		return _ctcDetail.toString();
	}

	@Override
	public CtcDetail toUnescapedModel() {
		return new CtcDetailWrapper(_ctcDetail.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _ctcDetail.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CtcDetailWrapper)) {
			return false;
		}

		CtcDetailWrapper ctcDetailWrapper = (CtcDetailWrapper)obj;

		if (Objects.equals(_ctcDetail, ctcDetailWrapper._ctcDetail)) {
			return true;
		}

		return false;
	}

	@Override
	public CtcDetail getWrappedModel() {
		return _ctcDetail;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ctcDetail.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ctcDetail.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ctcDetail.resetOriginalValues();
	}

	private final CtcDetail _ctcDetail;
}