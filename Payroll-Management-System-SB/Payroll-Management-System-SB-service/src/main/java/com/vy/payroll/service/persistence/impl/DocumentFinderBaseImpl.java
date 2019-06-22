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

package com.vy.payroll.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import com.vy.payroll.model.Document;
import com.vy.payroll.service.persistence.DocumentPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentFinderBaseImpl extends BasePersistenceImpl<Document> {
	public DocumentFinderBaseImpl() {
		setModelClass(Document.class);
	}

	/**
	 * Returns the document persistence.
	 *
	 * @return the document persistence
	 */
	public DocumentPersistence getDocumentPersistence() {
		return documentPersistence;
	}

	/**
	 * Sets the document persistence.
	 *
	 * @param documentPersistence the document persistence
	 */
	public void setDocumentPersistence(DocumentPersistence documentPersistence) {
		this.documentPersistence = documentPersistence;
	}

	@BeanReference(type = DocumentPersistence.class)
	protected DocumentPersistence documentPersistence;
}