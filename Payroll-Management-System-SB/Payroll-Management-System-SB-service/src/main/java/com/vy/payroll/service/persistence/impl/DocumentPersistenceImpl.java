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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.vy.payroll.exception.NoSuchDocumentException;
import com.vy.payroll.model.Document;
import com.vy.payroll.model.impl.DocumentImpl;
import com.vy.payroll.model.impl.DocumentModelImpl;
import com.vy.payroll.service.persistence.DocumentPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentPersistence
 * @see com.vy.payroll.service.persistence.DocumentUtil
 * @generated
 */
@ProviderType
public class DocumentPersistenceImpl extends BasePersistenceImpl<Document>
	implements DocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentUtil} to access the document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPID = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmpId",
			new String[] { Long.class.getName() },
			DocumentModelImpl.ENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPID = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the document where eno = &#63; or throws a {@link NoSuchDocumentException} if it could not be found.
	 *
	 * @param eno the eno
	 * @return the matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByEmpId(long eno) throws NoSuchDocumentException {
		Document document = fetchByEmpId(eno);

		if (document == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("eno=");
			msg.append(eno);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDocumentException(msg.toString());
		}

		return document;
	}

	/**
	 * Returns the document where eno = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eno the eno
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByEmpId(long eno) {
		return fetchByEmpId(eno, true);
	}

	/**
	 * Returns the document where eno = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eno the eno
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByEmpId(long eno, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { eno };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPID,
					finderArgs, this);
		}

		if (result instanceof Document) {
			Document document = (Document)result;

			if ((eno != document.getEno())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPID_ENO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eno);

				List<Document> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DocumentPersistenceImpl.fetchByEmpId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Document document = list.get(0);

					result = document;

					cacheResult(document);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPID, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Document)result;
		}
	}

	/**
	 * Removes the document where eno = &#63; from the database.
	 *
	 * @param eno the eno
	 * @return the document that was removed
	 */
	@Override
	public Document removeByEmpId(long eno) throws NoSuchDocumentException {
		Document document = findByEmpId(eno);

		return remove(document);
	}

	/**
	 * Returns the number of documents where eno = &#63;.
	 *
	 * @param eno the eno
	 * @return the number of matching documents
	 */
	@Override
	public int countByEmpId(long eno) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPID;

		Object[] finderArgs = new Object[] { eno };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPID_ENO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eno);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPID_ENO_2 = "document.eno = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENTEMPID =
		new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentEmpId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTEMPID =
		new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumentEmpId",
			new String[] { Long.class.getName() },
			DocumentModelImpl.ENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENTEMPID = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentEmpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the documents where eno = &#63;.
	 *
	 * @param eno the eno
	 * @return the matching documents
	 */
	@Override
	public List<Document> findByDocumentEmpId(long eno) {
		return findByDocumentEmpId(eno, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Document> findByDocumentEmpId(long eno, int start, int end) {
		return findByDocumentEmpId(eno, start, end, null);
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
	@Override
	public List<Document> findByDocumentEmpId(long eno, int start, int end,
		OrderByComparator<Document> orderByComparator) {
		return findByDocumentEmpId(eno, start, end, orderByComparator, true);
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
	@Override
	public List<Document> findByDocumentEmpId(long eno, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTEMPID;
			finderArgs = new Object[] { eno };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENTEMPID;
			finderArgs = new Object[] { eno, start, end, orderByComparator };
		}

		List<Document> list = null;

		if (retrieveFromCache) {
			list = (List<Document>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Document document : list) {
					if ((eno != document.getEno())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTEMPID_ENO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eno);

				if (!pagination) {
					list = (List<Document>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Document>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first document in the ordered set where eno = &#63;.
	 *
	 * @param eno the eno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByDocumentEmpId_First(long eno,
		OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {
		Document document = fetchByDocumentEmpId_First(eno, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eno=");
		msg.append(eno);

		msg.append("}");

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the first document in the ordered set where eno = &#63;.
	 *
	 * @param eno the eno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByDocumentEmpId_First(long eno,
		OrderByComparator<Document> orderByComparator) {
		List<Document> list = findByDocumentEmpId(eno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document in the ordered set where eno = &#63;.
	 *
	 * @param eno the eno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByDocumentEmpId_Last(long eno,
		OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {
		Document document = fetchByDocumentEmpId_Last(eno, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eno=");
		msg.append(eno);

		msg.append("}");

		throw new NoSuchDocumentException(msg.toString());
	}

	/**
	 * Returns the last document in the ordered set where eno = &#63;.
	 *
	 * @param eno the eno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByDocumentEmpId_Last(long eno,
		OrderByComparator<Document> orderByComparator) {
		int count = countByDocumentEmpId(eno);

		if (count == 0) {
			return null;
		}

		List<Document> list = findByDocumentEmpId(eno, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document[] findByDocumentEmpId_PrevAndNext(long docId, long eno,
		OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {
		Document document = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByDocumentEmpId_PrevAndNext(session, document, eno,
					orderByComparator, true);

			array[1] = document;

			array[2] = getByDocumentEmpId_PrevAndNext(session, document, eno,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByDocumentEmpId_PrevAndNext(Session session,
		Document document, long eno,
		OrderByComparator<Document> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTEMPID_ENO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eno);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(document);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Document> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents where eno = &#63; from the database.
	 *
	 * @param eno the eno
	 */
	@Override
	public void removeByDocumentEmpId(long eno) {
		for (Document document : findByDocumentEmpId(eno, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(document);
		}
	}

	/**
	 * Returns the number of documents where eno = &#63;.
	 *
	 * @param eno the eno
	 * @return the number of matching documents
	 */
	@Override
	public int countByDocumentEmpId(long eno) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOCUMENTEMPID;

		Object[] finderArgs = new Object[] { eno };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTEMPID_ENO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eno);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DOCUMENTEMPID_ENO_2 = "document.eno = ?";

	public DocumentPersistenceImpl() {
		setModelClass(Document.class);
	}

	/**
	 * Caches the document in the entity cache if it is enabled.
	 *
	 * @param document the document
	 */
	@Override
	public void cacheResult(Document document) {
		entityCache.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey(), document);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPID,
			new Object[] { document.getEno() }, document);

		document.resetOriginalValues();
	}

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	@Override
	public void cacheResult(List<Document> documents) {
		for (Document document : documents) {
			if (entityCache.getResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
						DocumentImpl.class, document.getPrimaryKey()) == null) {
				cacheResult(document);
			}
			else {
				document.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all documents.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the document.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Document document) {
		entityCache.removeResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DocumentModelImpl)document, true);
	}

	@Override
	public void clearCache(List<Document> documents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Document document : documents) {
			entityCache.removeResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
				DocumentImpl.class, document.getPrimaryKey());

			clearUniqueFindersCache((DocumentModelImpl)document, true);
		}
	}

	protected void cacheUniqueFindersCache(DocumentModelImpl documentModelImpl) {
		Object[] args = new Object[] { documentModelImpl.getEno() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPID, args,
			documentModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DocumentModelImpl documentModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { documentModelImpl.getEno() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPID, args);
		}

		if ((documentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { documentModelImpl.getOriginalEno() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPID, args);
		}
	}

	/**
	 * Creates a new document with the primary key. Does not add the document to the database.
	 *
	 * @param docId the primary key for the new document
	 * @return the new document
	 */
	@Override
	public Document create(long docId) {
		Document document = new DocumentImpl();

		document.setNew(true);
		document.setPrimaryKey(docId);

		return document;
	}

	/**
	 * Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docId the primary key of the document
	 * @return the document that was removed
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	@Override
	public Document remove(long docId) throws NoSuchDocumentException {
		return remove((Serializable)docId);
	}

	/**
	 * Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document
	 * @return the document that was removed
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	@Override
	public Document remove(Serializable primaryKey)
		throws NoSuchDocumentException {
		Session session = null;

		try {
			session = openSession();

			Document document = (Document)session.get(DocumentImpl.class,
					primaryKey);

			if (document == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(document);
		}
		catch (NoSuchDocumentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Document removeImpl(Document document) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(document)) {
				document = (Document)session.get(DocumentImpl.class,
						document.getPrimaryKeyObj());
			}

			if (document != null) {
				session.delete(document);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (document != null) {
			clearCache(document);
		}

		return document;
	}

	@Override
	public Document updateImpl(Document document) {
		boolean isNew = document.isNew();

		if (!(document instanceof DocumentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(document.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(document);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in document proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Document implementation " +
				document.getClass());
		}

		DocumentModelImpl documentModelImpl = (DocumentModelImpl)document;

		Session session = null;

		try {
			session = openSession();

			if (document.isNew()) {
				session.save(document);

				document.setNew(false);
			}
			else {
				session.evict(document);
				session.saveOrUpdate(document);
			}

			session.flush();
			session.clear();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { documentModelImpl.getEno() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTEMPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTEMPID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((documentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTEMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { documentModelImpl.getOriginalEno() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTEMPID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTEMPID,
					args);

				args = new Object[] { documentModelImpl.getEno() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTEMPID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTEMPID,
					args);
			}
		}

		entityCache.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey(), document, false);

		clearUniqueFindersCache(documentModelImpl, false);
		cacheUniqueFindersCache(documentModelImpl);

		document.resetOriginalValues();

		return document;
	}

	/**
	 * Returns the document with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the document
	 * @return the document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	@Override
	public Document findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentException {
		Document document = fetchByPrimaryKey(primaryKey);

		if (document == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return document;
	}

	/**
	 * Returns the document with the primary key or throws a {@link NoSuchDocumentException} if it could not be found.
	 *
	 * @param docId the primary key of the document
	 * @return the document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	@Override
	public Document findByPrimaryKey(long docId) throws NoSuchDocumentException {
		return findByPrimaryKey((Serializable)docId);
	}

	/**
	 * Returns the document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document
	 * @return the document, or <code>null</code> if a document with the primary key could not be found
	 */
	@Override
	public Document fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
				DocumentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Document document = (Document)serializable;

		if (document == null) {
			Session session = null;

			try {
				session = openSession();

				document = (Document)session.get(DocumentImpl.class, primaryKey);

				if (document != null) {
					cacheResult(document);
				}
				else {
					entityCache.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
						DocumentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
					DocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return document;
	}

	/**
	 * Returns the document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docId the primary key of the document
	 * @return the document, or <code>null</code> if a document with the primary key could not be found
	 */
	@Override
	public Document fetchByPrimaryKey(long docId) {
		return fetchByPrimaryKey((Serializable)docId);
	}

	@Override
	public Map<Serializable, Document> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Document> map = new HashMap<Serializable, Document>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Document document = fetchByPrimaryKey(primaryKey);

			if (document != null) {
				map.put(primaryKey, document);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
					DocumentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Document)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DOCUMENT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Document document : (List<Document>)q.list()) {
				map.put(document.getPrimaryKeyObj(), document);

				cacheResult(document);

				uncachedPrimaryKeys.remove(document.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
					DocumentImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the documents.
	 *
	 * @return the documents
	 */
	@Override
	public List<Document> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Document> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Document> findAll(int start, int end,
		OrderByComparator<Document> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Document> findAll(int start, int end,
		OrderByComparator<Document> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Document> list = null;

		if (retrieveFromCache) {
			list = (List<Document>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENT;

				if (pagination) {
					sql = sql.concat(DocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Document>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Document>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the documents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Document document : findAll()) {
			remove(document);
		}
	}

	/**
	 * Returns the number of documents.
	 *
	 * @return the number of documents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCUMENT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DocumentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DOCUMENT = "SELECT document FROM Document document";
	private static final String _SQL_SELECT_DOCUMENT_WHERE_PKS_IN = "SELECT document FROM Document document WHERE docId IN (";
	private static final String _SQL_SELECT_DOCUMENT_WHERE = "SELECT document FROM Document document WHERE ";
	private static final String _SQL_COUNT_DOCUMENT = "SELECT COUNT(document) FROM Document document";
	private static final String _SQL_COUNT_DOCUMENT_WHERE = "SELECT COUNT(document) FROM Document document WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "document.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Document exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Document exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DocumentPersistenceImpl.class);
}