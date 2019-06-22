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
 * This class is used by SOAP remote services, specifically {@link com.vy.payroll.service.http.CtcDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.http.CtcDetailServiceSoap
 * @generated
 */
@ProviderType
public class CtcDetailSoap implements Serializable {
	public static CtcDetailSoap toSoapModel(CtcDetail model) {
		CtcDetailSoap soapModel = new CtcDetailSoap();

		soapModel.setCtc(model.getCtc());
		soapModel.setHra(model.getHra());
		soapModel.setMa(model.getMa());
		soapModel.setCa(model.getCa());
		soapModel.setTa(model.getTa());
		soapModel.setPf(model.getPf());
		soapModel.setSa(model.getSa());
		soapModel.setIncomeTax(model.getIncomeTax());
		soapModel.setProffesionalTax(model.getProffesionalTax());
		soapModel.setBasicSalary(model.getBasicSalary());
		soapModel.setContributionAmt(model.getContributionAmt());
		soapModel.setGratuity(model.getGratuity());

		return soapModel;
	}

	public static CtcDetailSoap[] toSoapModels(CtcDetail[] models) {
		CtcDetailSoap[] soapModels = new CtcDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CtcDetailSoap[][] toSoapModels(CtcDetail[][] models) {
		CtcDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CtcDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CtcDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CtcDetailSoap[] toSoapModels(List<CtcDetail> models) {
		List<CtcDetailSoap> soapModels = new ArrayList<CtcDetailSoap>(models.size());

		for (CtcDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CtcDetailSoap[soapModels.size()]);
	}

	public CtcDetailSoap() {
	}

	public int getPrimaryKey() {
		return _ctc;
	}

	public void setPrimaryKey(int pk) {
		setCtc(pk);
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

	public int getProffesionalTax() {
		return _proffesionalTax;
	}

	public void setProffesionalTax(int proffesionalTax) {
		_proffesionalTax = proffesionalTax;
	}

	public int getBasicSalary() {
		return _basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		_basicSalary = basicSalary;
	}

	public int getContributionAmt() {
		return _contributionAmt;
	}

	public void setContributionAmt(int contributionAmt) {
		_contributionAmt = contributionAmt;
	}

	public int getGratuity() {
		return _gratuity;
	}

	public void setGratuity(int gratuity) {
		_gratuity = gratuity;
	}

	private int _ctc;
	private int _hra;
	private int _ma;
	private int _ca;
	private int _ta;
	private int _pf;
	private int _sa;
	private int _incomeTax;
	private int _proffesionalTax;
	private int _basicSalary;
	private int _contributionAmt;
	private int _gratuity;
}