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
 * This class is a wrapper for {@link PayslipDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayslipDetails
 * @generated
 */
@ProviderType
public class PayslipDetailsWrapper implements PayslipDetails,
	ModelWrapper<PayslipDetails> {
	public PayslipDetailsWrapper(PayslipDetails payslipDetails) {
		_payslipDetails = payslipDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return PayslipDetails.class;
	}

	@Override
	public String getModelClassName() {
		return PayslipDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ctcId", getCtcId());
		attributes.put("ctc", getCtc());
		attributes.put("hra", getHra());
		attributes.put("ma", getMa());
		attributes.put("ca", getCa());
		attributes.put("ta", getTa());
		attributes.put("pf", getPf());
		attributes.put("sa", getSa());
		attributes.put("incomeTax", getIncomeTax());
		attributes.put("netSalary", getNetSalary());
		attributes.put("month", getMonth());
		attributes.put("eid", getEid());
		attributes.put("basicSalary", getBasicSalary());
		attributes.put("proffesionalTax", getProffesionalTax());
		attributes.put("TaxablAmt", getTaxablAmt());
		attributes.put("gratuity", getGratuity());
		attributes.put("grossSalary", getGrossSalary());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ctcId = (Long)attributes.get("ctcId");

		if (ctcId != null) {
			setCtcId(ctcId);
		}

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

		Integer netSalary = (Integer)attributes.get("netSalary");

		if (netSalary != null) {
			setNetSalary(netSalary);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		String eid = (String)attributes.get("eid");

		if (eid != null) {
			setEid(eid);
		}

		Integer basicSalary = (Integer)attributes.get("basicSalary");

		if (basicSalary != null) {
			setBasicSalary(basicSalary);
		}

		Integer proffesionalTax = (Integer)attributes.get("proffesionalTax");

		if (proffesionalTax != null) {
			setProffesionalTax(proffesionalTax);
		}

		Integer TaxablAmt = (Integer)attributes.get("TaxablAmt");

		if (TaxablAmt != null) {
			setTaxablAmt(TaxablAmt);
		}

		Integer gratuity = (Integer)attributes.get("gratuity");

		if (gratuity != null) {
			setGratuity(gratuity);
		}

		Integer grossSalary = (Integer)attributes.get("grossSalary");

		if (grossSalary != null) {
			setGrossSalary(grossSalary);
		}
	}

	@Override
	public Object clone() {
		return new PayslipDetailsWrapper((PayslipDetails)_payslipDetails.clone());
	}

	@Override
	public int compareTo(PayslipDetails payslipDetails) {
		return _payslipDetails.compareTo(payslipDetails);
	}

	/**
	* Returns the basic salary of this payslip details.
	*
	* @return the basic salary of this payslip details
	*/
	@Override
	public int getBasicSalary() {
		return _payslipDetails.getBasicSalary();
	}

	/**
	* Returns the ca of this payslip details.
	*
	* @return the ca of this payslip details
	*/
	@Override
	public int getCa() {
		return _payslipDetails.getCa();
	}

	/**
	* Returns the ctc of this payslip details.
	*
	* @return the ctc of this payslip details
	*/
	@Override
	public int getCtc() {
		return _payslipDetails.getCtc();
	}

	/**
	* Returns the ctc ID of this payslip details.
	*
	* @return the ctc ID of this payslip details
	*/
	@Override
	public long getCtcId() {
		return _payslipDetails.getCtcId();
	}

	/**
	* Returns the eid of this payslip details.
	*
	* @return the eid of this payslip details
	*/
	@Override
	public String getEid() {
		return _payslipDetails.getEid();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _payslipDetails.getExpandoBridge();
	}

	/**
	* Returns the gratuity of this payslip details.
	*
	* @return the gratuity of this payslip details
	*/
	@Override
	public int getGratuity() {
		return _payslipDetails.getGratuity();
	}

	/**
	* Returns the gross salary of this payslip details.
	*
	* @return the gross salary of this payslip details
	*/
	@Override
	public int getGrossSalary() {
		return _payslipDetails.getGrossSalary();
	}

	/**
	* Returns the hra of this payslip details.
	*
	* @return the hra of this payslip details
	*/
	@Override
	public int getHra() {
		return _payslipDetails.getHra();
	}

	/**
	* Returns the income tax of this payslip details.
	*
	* @return the income tax of this payslip details
	*/
	@Override
	public int getIncomeTax() {
		return _payslipDetails.getIncomeTax();
	}

	/**
	* Returns the ma of this payslip details.
	*
	* @return the ma of this payslip details
	*/
	@Override
	public int getMa() {
		return _payslipDetails.getMa();
	}

	/**
	* Returns the month of this payslip details.
	*
	* @return the month of this payslip details
	*/
	@Override
	public int getMonth() {
		return _payslipDetails.getMonth();
	}

	/**
	* Returns the net salary of this payslip details.
	*
	* @return the net salary of this payslip details
	*/
	@Override
	public int getNetSalary() {
		return _payslipDetails.getNetSalary();
	}

	/**
	* Returns the pf of this payslip details.
	*
	* @return the pf of this payslip details
	*/
	@Override
	public int getPf() {
		return _payslipDetails.getPf();
	}

	/**
	* Returns the primary key of this payslip details.
	*
	* @return the primary key of this payslip details
	*/
	@Override
	public long getPrimaryKey() {
		return _payslipDetails.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payslipDetails.getPrimaryKeyObj();
	}

	/**
	* Returns the proffesional tax of this payslip details.
	*
	* @return the proffesional tax of this payslip details
	*/
	@Override
	public int getProffesionalTax() {
		return _payslipDetails.getProffesionalTax();
	}

	/**
	* Returns the sa of this payslip details.
	*
	* @return the sa of this payslip details
	*/
	@Override
	public int getSa() {
		return _payslipDetails.getSa();
	}

	/**
	* Returns the ta of this payslip details.
	*
	* @return the ta of this payslip details
	*/
	@Override
	public int getTa() {
		return _payslipDetails.getTa();
	}

	/**
	* Returns the taxabl amt of this payslip details.
	*
	* @return the taxabl amt of this payslip details
	*/
	@Override
	public int getTaxablAmt() {
		return _payslipDetails.getTaxablAmt();
	}

	@Override
	public int hashCode() {
		return _payslipDetails.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _payslipDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _payslipDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _payslipDetails.isNew();
	}

	@Override
	public void persist() {
		_payslipDetails.persist();
	}

	/**
	* Sets the basic salary of this payslip details.
	*
	* @param basicSalary the basic salary of this payslip details
	*/
	@Override
	public void setBasicSalary(int basicSalary) {
		_payslipDetails.setBasicSalary(basicSalary);
	}

	/**
	* Sets the ca of this payslip details.
	*
	* @param ca the ca of this payslip details
	*/
	@Override
	public void setCa(int ca) {
		_payslipDetails.setCa(ca);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payslipDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the ctc of this payslip details.
	*
	* @param ctc the ctc of this payslip details
	*/
	@Override
	public void setCtc(int ctc) {
		_payslipDetails.setCtc(ctc);
	}

	/**
	* Sets the ctc ID of this payslip details.
	*
	* @param ctcId the ctc ID of this payslip details
	*/
	@Override
	public void setCtcId(long ctcId) {
		_payslipDetails.setCtcId(ctcId);
	}

	/**
	* Sets the eid of this payslip details.
	*
	* @param eid the eid of this payslip details
	*/
	@Override
	public void setEid(String eid) {
		_payslipDetails.setEid(eid);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_payslipDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_payslipDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_payslipDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gratuity of this payslip details.
	*
	* @param gratuity the gratuity of this payslip details
	*/
	@Override
	public void setGratuity(int gratuity) {
		_payslipDetails.setGratuity(gratuity);
	}

	/**
	* Sets the gross salary of this payslip details.
	*
	* @param grossSalary the gross salary of this payslip details
	*/
	@Override
	public void setGrossSalary(int grossSalary) {
		_payslipDetails.setGrossSalary(grossSalary);
	}

	/**
	* Sets the hra of this payslip details.
	*
	* @param hra the hra of this payslip details
	*/
	@Override
	public void setHra(int hra) {
		_payslipDetails.setHra(hra);
	}

	/**
	* Sets the income tax of this payslip details.
	*
	* @param incomeTax the income tax of this payslip details
	*/
	@Override
	public void setIncomeTax(int incomeTax) {
		_payslipDetails.setIncomeTax(incomeTax);
	}

	/**
	* Sets the ma of this payslip details.
	*
	* @param ma the ma of this payslip details
	*/
	@Override
	public void setMa(int ma) {
		_payslipDetails.setMa(ma);
	}

	/**
	* Sets the month of this payslip details.
	*
	* @param month the month of this payslip details
	*/
	@Override
	public void setMonth(int month) {
		_payslipDetails.setMonth(month);
	}

	/**
	* Sets the net salary of this payslip details.
	*
	* @param netSalary the net salary of this payslip details
	*/
	@Override
	public void setNetSalary(int netSalary) {
		_payslipDetails.setNetSalary(netSalary);
	}

	@Override
	public void setNew(boolean n) {
		_payslipDetails.setNew(n);
	}

	/**
	* Sets the pf of this payslip details.
	*
	* @param pf the pf of this payslip details
	*/
	@Override
	public void setPf(int pf) {
		_payslipDetails.setPf(pf);
	}

	/**
	* Sets the primary key of this payslip details.
	*
	* @param primaryKey the primary key of this payslip details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payslipDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_payslipDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the proffesional tax of this payslip details.
	*
	* @param proffesionalTax the proffesional tax of this payslip details
	*/
	@Override
	public void setProffesionalTax(int proffesionalTax) {
		_payslipDetails.setProffesionalTax(proffesionalTax);
	}

	/**
	* Sets the sa of this payslip details.
	*
	* @param sa the sa of this payslip details
	*/
	@Override
	public void setSa(int sa) {
		_payslipDetails.setSa(sa);
	}

	/**
	* Sets the ta of this payslip details.
	*
	* @param ta the ta of this payslip details
	*/
	@Override
	public void setTa(int ta) {
		_payslipDetails.setTa(ta);
	}

	/**
	* Sets the taxabl amt of this payslip details.
	*
	* @param TaxablAmt the taxabl amt of this payslip details
	*/
	@Override
	public void setTaxablAmt(int TaxablAmt) {
		_payslipDetails.setTaxablAmt(TaxablAmt);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PayslipDetails> toCacheModel() {
		return _payslipDetails.toCacheModel();
	}

	@Override
	public PayslipDetails toEscapedModel() {
		return new PayslipDetailsWrapper(_payslipDetails.toEscapedModel());
	}

	@Override
	public String toString() {
		return _payslipDetails.toString();
	}

	@Override
	public PayslipDetails toUnescapedModel() {
		return new PayslipDetailsWrapper(_payslipDetails.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _payslipDetails.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayslipDetailsWrapper)) {
			return false;
		}

		PayslipDetailsWrapper payslipDetailsWrapper = (PayslipDetailsWrapper)obj;

		if (Objects.equals(_payslipDetails,
					payslipDetailsWrapper._payslipDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public PayslipDetails getWrappedModel() {
		return _payslipDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _payslipDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _payslipDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_payslipDetails.resetOriginalValues();
	}

	private final PayslipDetails _payslipDetails;
}