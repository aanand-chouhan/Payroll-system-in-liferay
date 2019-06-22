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

import com.vy.payroll.model.CtcDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CtcDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CtcDetail
 * @generated
 */
@ProviderType
public class CtcDetailCacheModel implements CacheModel<CtcDetail>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CtcDetailCacheModel)) {
			return false;
		}

		CtcDetailCacheModel ctcDetailCacheModel = (CtcDetailCacheModel)obj;

		if (ctc == ctcDetailCacheModel.ctc) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ctc);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{ctc=");
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
		sb.append(", proffesionalTax=");
		sb.append(proffesionalTax);
		sb.append(", basicSalary=");
		sb.append(basicSalary);
		sb.append(", contributionAmt=");
		sb.append(contributionAmt);
		sb.append(", gratuity=");
		sb.append(gratuity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CtcDetail toEntityModel() {
		CtcDetailImpl ctcDetailImpl = new CtcDetailImpl();

		ctcDetailImpl.setCtc(ctc);
		ctcDetailImpl.setHra(hra);
		ctcDetailImpl.setMa(ma);
		ctcDetailImpl.setCa(ca);
		ctcDetailImpl.setTa(ta);
		ctcDetailImpl.setPf(pf);
		ctcDetailImpl.setSa(sa);
		ctcDetailImpl.setIncomeTax(incomeTax);
		ctcDetailImpl.setProffesionalTax(proffesionalTax);
		ctcDetailImpl.setBasicSalary(basicSalary);
		ctcDetailImpl.setContributionAmt(contributionAmt);
		ctcDetailImpl.setGratuity(gratuity);

		ctcDetailImpl.resetOriginalValues();

		return ctcDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ctc = objectInput.readInt();

		hra = objectInput.readInt();

		ma = objectInput.readInt();

		ca = objectInput.readInt();

		ta = objectInput.readInt();

		pf = objectInput.readInt();

		sa = objectInput.readInt();

		incomeTax = objectInput.readInt();

		proffesionalTax = objectInput.readInt();

		basicSalary = objectInput.readInt();

		contributionAmt = objectInput.readInt();

		gratuity = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ctc);

		objectOutput.writeInt(hra);

		objectOutput.writeInt(ma);

		objectOutput.writeInt(ca);

		objectOutput.writeInt(ta);

		objectOutput.writeInt(pf);

		objectOutput.writeInt(sa);

		objectOutput.writeInt(incomeTax);

		objectOutput.writeInt(proffesionalTax);

		objectOutput.writeInt(basicSalary);

		objectOutput.writeInt(contributionAmt);

		objectOutput.writeInt(gratuity);
	}

	public int ctc;
	public int hra;
	public int ma;
	public int ca;
	public int ta;
	public int pf;
	public int sa;
	public int incomeTax;
	public int proffesionalTax;
	public int basicSalary;
	public int contributionAmt;
	public int gratuity;
}