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

package com.vy.payroll.service.impl;

import java.util.List;

import com.vy.payroll.exception.NoSuchDocumentException;
import com.vy.payroll.model.Document;
import com.vy.payroll.service.base.DocumentLocalServiceBaseImpl;
import com.vy.payroll.service.persistence.DocumentFinder;
import com.vy.payroll.service.persistence.DocumentUtil;

/**
 * The implementation of the document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vy.payroll.service.DocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentLocalServiceBaseImpl
 * @see com.vy.payroll.service.DocumentLocalServiceUtil
 */
public class DocumentLocalServiceImpl extends DocumentLocalServiceBaseImpl {


	public  Document fetchByEmpId(long eno) throws NoSuchDocumentException {
		return DocumentUtil.findByEmpId(eno);
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.vy.payroll.service.DocumentLocalServiceUtil} to access the document local service.
	 */

	@Override
	public List<Document> findByEmpId(long eno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  List<Document> findByDocumentEmpId(long eno) {
		return DocumentUtil.findByDocumentEmpId(eno);
	}
	
	public int updateDocsReview(int eno) {
		return	documentFinder.updateDocReview(eno);
	}
	
	public int isDocReviewed(int eno) {
		return documentFinder.isDocReviewed(eno);
	}

}