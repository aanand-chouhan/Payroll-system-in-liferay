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

import com.vy.payroll.model.PayslipDetails;
import com.vy.payroll.service.PayslipDetailsLocalServiceUtil;

/**
 * The extended model base implementation for the PayslipDetails service. Represents a row in the &quot;payslip_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PayslipDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayslipDetailsImpl
 * @see PayslipDetails
 * @generated
 */
@ProviderType
public abstract class PayslipDetailsBaseImpl extends PayslipDetailsModelImpl
	implements PayslipDetails {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a payslip details model instance should use the {@link PayslipDetails} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			PayslipDetailsLocalServiceUtil.addPayslipDetails(this);
		}
		else {
			PayslipDetailsLocalServiceUtil.updatePayslipDetails(this);
		}
	}
}