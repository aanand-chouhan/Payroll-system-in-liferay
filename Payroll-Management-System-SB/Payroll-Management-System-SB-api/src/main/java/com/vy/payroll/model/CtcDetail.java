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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the CtcDetail service. Represents a row in the &quot;ctc_details&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CtcDetailModel
 * @see com.vy.payroll.model.impl.CtcDetailImpl
 * @see com.vy.payroll.model.impl.CtcDetailModelImpl
 * @generated
 */
@ImplementationClassName("com.vy.payroll.model.impl.CtcDetailImpl")
@ProviderType
public interface CtcDetail extends CtcDetailModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.vy.payroll.model.impl.CtcDetailImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CtcDetail, Integer> CTC_ACCESSOR = new Accessor<CtcDetail, Integer>() {
			@Override
			public Integer get(CtcDetail ctcDetail) {
				return ctcDetail.getCtc();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<CtcDetail> getTypeClass() {
				return CtcDetail.class;
			}
		};
}