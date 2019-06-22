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
 * The extended model interface for the Admin_details service. Represents a row in the &quot;admin_details&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Admin_detailsModel
 * @see com.vy.payroll.model.impl.Admin_detailsImpl
 * @see com.vy.payroll.model.impl.Admin_detailsModelImpl
 * @generated
 */
@ImplementationClassName("com.vy.payroll.model.impl.Admin_detailsImpl")
@ProviderType
public interface Admin_details extends Admin_detailsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.vy.payroll.model.impl.Admin_detailsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Admin_details, Integer> ADMIN_ID_ACCESSOR = new Accessor<Admin_details, Integer>() {
			@Override
			public Integer get(Admin_details admin_details) {
				return admin_details.getAdmin_id();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<Admin_details> getTypeClass() {
				return Admin_details.class;
			}
		};
}