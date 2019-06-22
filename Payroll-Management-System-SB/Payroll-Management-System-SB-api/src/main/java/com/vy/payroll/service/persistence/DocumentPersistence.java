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

package com.vy.payroll.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.vy.payroll.exception.NoSuchDocumentException;
import com.vy.payroll.model.Document;

/**
 * The persistence interface for the document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.persistence.impl.DocumentPersistenceImpl
 * @see DocumentUtil
 * @generated
 */
@ProviderType
public interface DocumentPersistence extends BasePersistence<Document> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentUtil} to access the document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the document where eno = &#63; or throws a {@link NoSuchDocumentException} if it could not be found.
	*
	* @param eno the eno
	* @return the matching document
	* @throws NoSuchDocumentException if a matching document could not be found
	*/
	public Document findByEmpId(long eno) throws NoSuchDocumentException;

	/**
	* Returns the document where eno = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eno the eno
	* @return the matching document, or <code>null</code> if a matching document could not be found
	*/
	public Document fetchByEmpId(long eno);

	/**
	* Returns the document where eno = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eno the eno
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching document, or <code>null</code> if a matching document could not be found
	*/
	public Document fetchByEmpId(long eno, boolean retrieveFromCache);

	/**
	* Removes the document where eno = &#63; from the database.
	*
	* @param eno the eno
	* @return the document that was removed
	*/
	public Document removeByEmpId(long eno) throws NoSuchDocumentException;

	/**
	* Returns the number of documents where eno = &#63;.
	*
	* @param eno the eno
	* @return the number of matching documents
	*/
	public int countByEmpId(long eno);

	/**
	* Returns all the documents where eno = &#63;.
	*
	* @param eno the eno
	* @return the matching documents
	*/
	public java.util.List<Document> findByDocumentEmpId(long eno);

	/**
	* Returns a range of all the documents where eno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eno the eno
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of matching documents
	*/
	public java.util.List<Document> findByDocumentEmpId(long eno, int start,
		int end);

	/**
	* Returns an ordered range of all the documents where eno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eno the eno
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching documents
	*/
	public java.util.List<Document> findByDocumentEmpId(long eno, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator);

	/**
	* Returns an ordered range of all the documents where eno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eno the eno
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching documents
	*/
	public java.util.List<Document> findByDocumentEmpId(long eno, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first document in the ordered set where eno = &#63;.
	*
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document
	* @throws NoSuchDocumentException if a matching document could not be found
	*/
	public Document findByDocumentEmpId_First(long eno,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException;

	/**
	* Returns the first document in the ordered set where eno = &#63;.
	*
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document, or <code>null</code> if a matching document could not be found
	*/
	public Document fetchByDocumentEmpId_First(long eno,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator);

	/**
	* Returns the last document in the ordered set where eno = &#63;.
	*
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document
	* @throws NoSuchDocumentException if a matching document could not be found
	*/
	public Document findByDocumentEmpId_Last(long eno,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException;

	/**
	* Returns the last document in the ordered set where eno = &#63;.
	*
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document, or <code>null</code> if a matching document could not be found
	*/
	public Document fetchByDocumentEmpId_Last(long eno,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator);

	/**
	* Returns the documents before and after the current document in the ordered set where eno = &#63;.
	*
	* @param docId the primary key of the current document
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document
	* @throws NoSuchDocumentException if a document with the primary key could not be found
	*/
	public Document[] findByDocumentEmpId_PrevAndNext(long docId, long eno,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException;

	/**
	* Removes all the documents where eno = &#63; from the database.
	*
	* @param eno the eno
	*/
	public void removeByDocumentEmpId(long eno);

	/**
	* Returns the number of documents where eno = &#63;.
	*
	* @param eno the eno
	* @return the number of matching documents
	*/
	public int countByDocumentEmpId(long eno);

	/**
	* Caches the document in the entity cache if it is enabled.
	*
	* @param document the document
	*/
	public void cacheResult(Document document);

	/**
	* Caches the documents in the entity cache if it is enabled.
	*
	* @param documents the documents
	*/
	public void cacheResult(java.util.List<Document> documents);

	/**
	* Creates a new document with the primary key. Does not add the document to the database.
	*
	* @param docId the primary key for the new document
	* @return the new document
	*/
	public Document create(long docId);

	/**
	* Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param docId the primary key of the document
	* @return the document that was removed
	* @throws NoSuchDocumentException if a document with the primary key could not be found
	*/
	public Document remove(long docId) throws NoSuchDocumentException;

	public Document updateImpl(Document document);

	/**
	* Returns the document with the primary key or throws a {@link NoSuchDocumentException} if it could not be found.
	*
	* @param docId the primary key of the document
	* @return the document
	* @throws NoSuchDocumentException if a document with the primary key could not be found
	*/
	public Document findByPrimaryKey(long docId) throws NoSuchDocumentException;

	/**
	* Returns the document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param docId the primary key of the document
	* @return the document, or <code>null</code> if a document with the primary key could not be found
	*/
	public Document fetchByPrimaryKey(long docId);

	@Override
	public java.util.Map<java.io.Serializable, Document> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the documents.
	*
	* @return the documents
	*/
	public java.util.List<Document> findAll();

	/**
	* Returns a range of all the documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of documents
	*/
	public java.util.List<Document> findAll(int start, int end);

	/**
	* Returns an ordered range of all the documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of documents
	*/
	public java.util.List<Document> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator);

	/**
	* Returns an ordered range of all the documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of documents
	*/
	public java.util.List<Document> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the documents from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of documents.
	*
	* @return the number of documents
	*/
	public int countAll();
}