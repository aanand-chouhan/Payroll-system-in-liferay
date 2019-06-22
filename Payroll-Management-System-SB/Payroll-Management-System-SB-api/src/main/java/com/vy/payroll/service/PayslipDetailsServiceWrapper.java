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

package com.vy.payroll.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PayslipDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayslipDetailsService
 * @generated
 */
@ProviderType
public class PayslipDetailsServiceWrapper implements PayslipDetailsService,
	ServiceWrapper<PayslipDetailsService> {
	public PayslipDetailsServiceWrapper(
		PayslipDetailsService payslipDetailsService) {
		_payslipDetailsService = payslipDetailsService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _payslipDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public PayslipDetailsService getWrappedService() {
		return _payslipDetailsService;
	}

	@Override
	public void setWrappedService(PayslipDetailsService payslipDetailsService) {
		_payslipDetailsService = payslipDetailsService;
	}

	private PayslipDetailsService _payslipDetailsService;
}