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

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vy.payroll.service.http.PayslipDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.http.PayslipDetailsServiceSoap
 * @generated
 */
@ProviderType
public class PayslipDetailsSoap implements Serializable {
	public static PayslipDetailsSoap toSoapModel(PayslipDetails model) {
		PayslipDetailsSoap soapModel = new PayslipDetailsSoap();

		soapModel.setCtcId(model.getCtcId());
		soapModel.setCtc(model.getCtc());
		soapModel.setHra(model.getHra());
		soapModel.setMa(model.getMa());
		soapModel.setCa(model.getCa());
		soapModel.setTa(model.getTa());
		soapModel.setPf(model.getPf());
		soapModel.setSa(model.getSa());
		soapModel.setIncomeTax(model.getIncomeTax());
		soapModel.setNetSalary(model.getNetSalary());
		soapModel.setMonth(model.getMonth());
		soapModel.setEid(model.getEid());
		soapModel.setBasicSalary(model.getBasicSalary());
		soapModel.setProffesionalTax(model.getProffesionalTax());
		soapModel.setTaxablAmt(model.getTaxablAmt());
		soapModel.setGratuity(model.getGratuity());
		soapModel.setGrossSalary(model.getGrossSalary());

		return soapModel;
	}

	public static PayslipDetailsSoap[] toSoapModels(PayslipDetails[] models) {
		PayslipDetailsSoap[] soapModels = new PayslipDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayslipDetailsSoap[][] toSoapModels(PayslipDetails[][] models) {
		PayslipDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayslipDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayslipDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayslipDetailsSoap[] toSoapModels(List<PayslipDetails> models) {
		List<PayslipDetailsSoap> soapModels = new ArrayList<PayslipDetailsSoap>(models.size());

		for (PayslipDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayslipDetailsSoap[soapModels.size()]);
	}

	public PayslipDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _ctcId;
	}

	public void setPrimaryKey(long pk) {
		setCtcId(pk);
	}

	public long getCtcId() {
		return _ctcId;
	}

	public void setCtcId(long ctcId) {
		_ctcId = ctcId;
	}

	public int getCtc() {
		return _ctc;
	}

	public void setCtc(int ctc) {
		_ctc = ctc;
	}

	public int getHra() {
		return _hra;
	}

	public void setHra(int hra) {
		_hra = hra;
	}

	public int getMa() {
		return _ma;
	}

	public void setMa(int ma) {
		_ma = ma;
	}

	public int getCa() {
		return _ca;
	}

	public void setCa(int ca) {
		_ca = ca;
	}

	public int getTa() {
		return _ta;
	}

	public void setTa(int ta) {
		_ta = ta;
	}

	public int getPf() {
		return _pf;
	}

	public void setPf(int pf) {
		_pf = pf;
	}

	public int getSa() {
		return _sa;
	}

	public void setSa(int sa) {
		_sa = sa;
	}

	public int getIncomeTax() {
		return _incomeTax;
	}

	public void setIncomeTax(int incomeTax) {
		_incomeTax = incomeTax;
	}

	public int getNetSalary() {
		return _netSalary;
	}

	public void setNetSalary(int netSalary) {
		_netSalary = netSalary;
	}

	public int getMonth() {
		return _month;
	}

	public void setMonth(int month) {
		_month = month;
	}

	public String getEid() {
		return _eid;
	}

	public void setEid(String eid) {
		_eid = eid;
	}

	public int getBasicSalary() {
		return _basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		_basicSalary = basicSalary;
	}

	public int getProffesionalTax() {
		return _proffesionalTax;
	}

	public void setProffesionalTax(int proffesionalTax) {
		_proffesionalTax = proffesionalTax;
	}

	public int getTaxablAmt() {
		return _TaxablAmt;
	}

	public void setTaxablAmt(int TaxablAmt) {
		_TaxablAmt = TaxablAmt;
	}

	public int getGratuity() {
		return _gratuity;
	}

	public void setGratuity(int gratuity) {
		_gratuity = gratuity;
	}

	public int getGrossSalary() {
		return _grossSalary;
	}

	public void setGrossSalary(int grossSalary) {
		_grossSalary = grossSalary;
	}

	private long _ctcId;
	private int _ctc;
	private int _hra;
	private int _ma;
	private int _ca;
	private int _ta;
	private int _pf;
	private int _sa;
	private int _incomeTax;
	private int _netSalary;
	private int _month;
	private String _eid;
	private int _basicSalary;
	private int _proffesionalTax;
	private int _TaxablAmt;
	private int _gratuity;
	private int _grossSalary;
}