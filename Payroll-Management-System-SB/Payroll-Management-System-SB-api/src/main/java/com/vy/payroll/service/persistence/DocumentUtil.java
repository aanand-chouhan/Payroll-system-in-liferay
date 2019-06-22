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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.vy.payroll.model.Document;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the document service. This utility wraps {@link com.vy.payroll.service.persistence.impl.DocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentPersistence
 * @see com.vy.payroll.service.persistence.impl.DocumentPersistenceImpl
 * @generated
 */
@ProviderType
public class DocumentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Document document) {
		getPersistence().clearCache(document);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Document> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Document> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Document update(Document document) {
		return getPersistence().update(document);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Document update(Document document,
		ServiceContext serviceContext) {
		return getPersistence().update(document, serviceContext);
	}

	/**
	* Returns the document where eno = &#63; or throws a {@link NoSuchDocumentException} if it could not be found.
	*
	* @param eno the eno
	* @return the matching document
	* @throws NoSuchDocumentException if a matching document could not be found
	*/
	public static Document findByEmpId(long eno)
		throws com.vy.payroll.exception.NoSuchDocumentException {
		return getPersistence().findByEmpId(eno);
	}

	/**
	* Returns the document where eno = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eno the eno
	* @return the matching document, or <code>null</code> if a matching document could not be found
	*/
	public static Document fetchByEmpId(long eno) {
		return getPersistence().fetchByEmpId(eno);
	}

	/**
	* Returns the document where eno = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eno the eno
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching document, or <code>null</code> if a matching document could not be found
	*/
	public static Document fetchByEmpId(long eno, boolean retrieveFromCache) {
		return getPersistence().fetchByEmpId(eno, retrieveFromCache);
	}

	/**
	* Removes the document where eno = &#63; from the database.
	*
	* @param eno the eno
	* @return the document that was removed
	*/
	public static Document removeByEmpId(long eno)
		throws com.vy.payroll.exception.NoSuchDocumentException {
		return getPersistence().removeByEmpId(eno);
	}

	/**
	* Returns the number of documents where eno = &#63;.
	*
	* @param eno the eno
	* @return the number of matching documents
	*/
	public static int countByEmpId(long eno) {
		return getPersistence().countByEmpId(eno);
	}

	/**
	* Returns all the documents where eno = &#63;.
	*
	* @param eno the eno
	* @return the matching documents
	*/
	public static List<Document> findByDocumentEmpId(long eno) {
		return getPersistence().findByDocumentEmpId(eno);
	}

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
	public static List<Document> findByDocumentEmpId(long eno, int start,
		int end) {
		return getPersistence().findByDocumentEmpId(eno, start, end);
	}

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
	public static List<Document> findByDocumentEmpId(long eno, int start,
		int end, OrderByComparator<Document> orderByComparator) {
		return getPersistence()
				   .findByDocumentEmpId(eno, start, end, orderByComparator);
	}

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
	public static List<Document> findByDocumentEmpId(long eno, int start,
		int end, OrderByComparator<Document> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDocumentEmpId(eno, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first document in the ordered set where eno = &#63;.
	*
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document
	* @throws NoSuchDocumentException if a matching document could not be found
	*/
	public static Document findByDocumentEmpId_First(long eno,
		OrderByComparator<Document> orderByComparator)
		throws com.vy.payroll.exception.NoSuchDocumentException {
		return getPersistence().findByDocumentEmpId_First(eno, orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where eno = &#63;.
	*
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document, or <code>null</code> if a matching document could not be found
	*/
	public static Document fetchByDocumentEmpId_First(long eno,
		OrderByComparator<Document> orderByComparator) {
		return getPersistence()
				   .fetchByDocumentEmpId_First(eno, orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where eno = &#63;.
	*
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document
	* @throws NoSuchDocumentException if a matching document could not be found
	*/
	public static Document findByDocumentEmpId_Last(long eno,
		OrderByComparator<Document> orderByComparator)
		throws com.vy.payroll.exception.NoSuchDocumentException {
		return getPersistence().findByDocumentEmpId_Last(eno, orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where eno = &#63;.
	*
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document, or <code>null</code> if a matching document could not be found
	*/
	public static Document fetchByDocumentEmpId_Last(long eno,
		OrderByComparator<Document> orderByComparator) {
		return getPersistence().fetchByDocumentEmpId_Last(eno, orderByComparator);
	}

	/**
	* Returns the documents before and after the current document in the ordered set where eno = &#63;.
	*
	* @param docId the primary key of the current document
	* @param eno the eno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document
	* @throws NoSuchDocumentException if a document with the primary key could not be found
	*/
	public static Document[] findByDocumentEmpId_PrevAndNext(long docId,
		long eno, OrderByComparator<Document> orderByComparator)
		throws com.vy.payroll.exception.NoSuchDocumentException {
		return getPersistence()
				   .findByDocumentEmpId_PrevAndNext(docId, eno,
			orderByComparator);
	}

	/**
	* Removes all the documents where eno = &#63; from the database.
	*
	* @param eno the eno
	*/
	public static void removeByDocumentEmpId(long eno) {
		getPersistence().removeByDocumentEmpId(eno);
	}

	/**
	* Returns the number of documents where eno = &#63;.
	*
	* @param eno the eno
	* @return the number of matching documents
	*/
	public static int countByDocumentEmpId(long eno) {
		return getPersistence().countByDocumentEmpId(eno);
	}

	/**
	* Caches the document in the entity cache if it is enabled.
	*
	* @param document the document
	*/
	public static void cacheResult(Document document) {
		getPersistence().cacheResult(document);
	}

	/**
	* Caches the documents in the entity cache if it is enabled.
	*
	* @param documents the documents
	*/
	public static void cacheResult(List<Document> documents) {
		getPersistence().cacheResult(documents);
	}

	/**
	* Creates a new document with the primary key. Does not add the document to the database.
	*
	* @param docId the primary key for the new document
	* @return the new document
	*/
	public static Document create(long docId) {
		return getPersistence().create(docId);
	}

	/**
	* Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param docId the primary key of the document
	* @return the document that was removed
	* @throws NoSuchDocumentException if a document with the primary key could not be found
	*/
	public static Document remove(long docId)
		throws com.vy.payroll.exception.NoSuchDocumentException {
		return getPersistence().remove(docId);
	}

	public static Document updateImpl(Document document) {
		return getPersistence().updateImpl(document);
	}

	/**
	* Returns the document with the primary key or throws a {@link NoSuchDocumentException} if it could not be found.
	*
	* @param docId the primary key of the document
	* @return the document
	* @throws NoSuchDocumentException if a document with the primary key could not be found
	*/
	public static Document findByPrimaryKey(long docId)
		throws com.vy.payroll.exception.NoSuchDocumentException {
		return getPersistence().findByPrimaryKey(docId);
	}

	/**
	* Returns the document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param docId the primary key of the document
	* @return the document, or <code>null</code> if a document with the primary key could not be found
	*/
	public static Document fetchByPrimaryKey(long docId) {
		return getPersistence().fetchByPrimaryKey(docId);
	}

	public static java.util.Map<java.io.Serializable, Document> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the documents.
	*
	* @return the documents
	*/
	public static List<Document> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Document> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Document> findAll(int start, int end,
		OrderByComparator<Document> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Document> findAll(int start, int end,
		OrderByComparator<Document> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the documents from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of documents.
	*
	* @return the number of documents
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DocumentPersistence, DocumentPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DocumentPersistence.class);

		ServiceTracker<DocumentPersistence, DocumentPersistence> serviceTracker = new ServiceTracker<DocumentPersistence, DocumentPersistence>(bundle.getBundleContext(),
				DocumentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}