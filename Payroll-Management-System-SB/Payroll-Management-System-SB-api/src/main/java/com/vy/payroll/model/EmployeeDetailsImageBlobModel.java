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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the image column in EmployeeDetails.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @generated
 */
@ProviderType
public class EmployeeDetailsImageBlobModel {
	public EmployeeDetailsImageBlobModel() {
	}

	public EmployeeDetailsImageBlobModel(long eno) {
		_eno = eno;
	}

	public EmployeeDetailsImageBlobModel(long eno, Blob imageBlob) {
		_eno = eno;
		_imageBlob = imageBlob;
	}

	public long getEno() {
		return _eno;
	}

	public void setEno(long eno) {
		_eno = eno;
	}

	public Blob getImageBlob() {
		return _imageBlob;
	}

	public void setImageBlob(Blob imageBlob) {
		_imageBlob = imageBlob;
	}

	private long _eno;
	private Blob _imageBlob;
}