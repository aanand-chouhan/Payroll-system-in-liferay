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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.vy.payroll.model.PayslipDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PayslipDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PayslipDetails
 * @generated
 */
@ProviderType
public class PayslipDetailsCacheModel implements CacheModel<PayslipDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayslipDetailsCacheModel)) {
			return false;
		}

		PayslipDetailsCacheModel payslipDetailsCacheModel = (PayslipDetailsCacheModel)obj;

		if (ctcId == payslipDetailsCacheModel.ctcId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ctcId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{ctcId=");
		sb.append(ctcId);
		sb.append(", ctc=");
		sb.append(ctc);
		sb.append(", hra=");
		sb.append(hra);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ca=");
		sb.append(ca);
		sb.append(", ta=");
		sb.append(ta);
		sb.append(", pf=");
		sb.append(pf);
		sb.append(", sa=");
		sb.append(sa);
		sb.append(", incomeTax=");
		sb.append(incomeTax);
		sb.append(", netSalary=");
		sb.append(netSalary);
		sb.append(", month=");
		sb.append(month);
		sb.append(", eid=");
		sb.append(eid);
		sb.append(", basicSalary=");
		sb.append(basicSalary);
		sb.append(", proffesionalTax=");
		sb.append(proffesionalTax);
		sb.append(", TaxablAmt=");
		sb.append(TaxablAmt);
		sb.append(", gratuity=");
		sb.append(gratuity);
		sb.append(", grossSalary=");
		sb.append(grossSalary);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayslipDetails toEntityModel() {
		PayslipDetailsImpl payslipDetailsImpl = new PayslipDetailsImpl();

		payslipDetailsImpl.setCtcId(ctcId);
		payslipDetailsImpl.setCtc(ctc);
		payslipDetailsImpl.setHra(hra);
		payslipDetailsImpl.setMa(ma);
		payslipDetailsImpl.setCa(ca);
		payslipDetailsImpl.setTa(ta);
		payslipDetailsImpl.setPf(pf);
		payslipDetailsImpl.setSa(sa);
		payslipDetailsImpl.setIncomeTax(incomeTax);
		payslipDetailsImpl.setNetSalary(netSalary);
		payslipDetailsImpl.setMonth(month);

		if (eid == null) {
			payslipDetailsImpl.setEid("");
		}
		else {
			payslipDetailsImpl.setEid(eid);
		}

		payslipDetailsImpl.setBasicSalary(basicSalary);
		payslipDetailsImpl.setProffesionalTax(proffesionalTax);
		payslipDetailsImpl.setTaxablAmt(TaxablAmt);
		payslipDetailsImpl.setGratuity(gratuity);
		payslipDetailsImpl.setGrossSalary(grossSalary);

		payslipDetailsImpl.resetOriginalValues();

		return payslipDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ctcId = objectInput.readLong();

		ctc = objectInput.readInt();

		hra = objectInput.readInt();

		ma = objectInput.readInt();

		ca = objectInput.readInt();

		ta = objectInput.readInt();

		pf = objectInput.readInt();

		sa = objectInput.readInt();

		incomeTax = objectInput.readInt();

		netSalary = objectInput.readInt();

		month = objectInput.readInt();
		eid = objectInput.readUTF();

		basicSalary = objectInput.readInt();

		proffesionalTax = objectInput.readInt();

		TaxablAmt = objectInput.readInt();

		gratuity = objectInput.readInt();

		grossSalary = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ctcId);

		objectOutput.writeInt(ctc);

		objectOutput.writeInt(hra);

		objectOutput.writeInt(ma);

		objectOutput.writeInt(ca);

		objectOutput.writeInt(ta);

		objectOutput.writeInt(pf);

		objectOutput.writeInt(sa);

		objectOutput.writeInt(incomeTax);

		objectOutput.writeInt(netSalary);

		objectOutput.writeInt(month);

		if (eid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eid);
		}

		objectOutput.writeInt(basicSalary);

		objectOutput.writeInt(proffesionalTax);

		objectOutput.writeInt(TaxablAmt);

		objectOutput.writeInt(gratuity);

		objectOutput.writeInt(grossSalary);
	}

	public long ctcId;
	public int ctc;
	public int hra;
	public int ma;
	public int ca;
	public int ta;
	public int pf;
	public int sa;
	public int incomeTax;
	public int netSalary;
	public int month;
	public String eid;
	public int basicSalary;
	public int proffesionalTax;
	public int TaxablAmt;
	public int gratuity;
	public int grossSalary;
}