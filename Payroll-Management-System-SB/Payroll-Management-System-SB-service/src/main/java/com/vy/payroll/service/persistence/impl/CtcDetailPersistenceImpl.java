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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.vy.payroll.exception.NoSuchCtcDetailException;
import com.vy.payroll.model.CtcDetail;
import com.vy.payroll.model.impl.CtcDetailImpl;
import com.vy.payroll.model.impl.CtcDetailModelImpl;
import com.vy.payroll.service.persistence.CtcDetailPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the ctc detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CtcDetailPersistence
 * @see com.vy.payroll.service.persistence.CtcDetailUtil
 * @generated
 */
@ProviderType
public class CtcDetailPersistenceImpl extends BasePersistenceImpl<CtcDetail>
	implements CtcDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CtcDetailUtil} to access the ctc detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CtcDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
			CtcDetailModelImpl.FINDER_CACHE_ENABLED, CtcDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
			CtcDetailModelImpl.FINDER_CACHE_ENABLED, CtcDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
			CtcDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CtcDetailPersistenceImpl() {
		setModelClass(CtcDetail.class);
	}

	/**
	 * Caches the ctc detail in the entity cache if it is enabled.
	 *
	 * @param ctcDetail the ctc detail
	 */
	@Override
	public void cacheResult(CtcDetail ctcDetail) {
		entityCache.putResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
			CtcDetailImpl.class, ctcDetail.getPrimaryKey(), ctcDetail);

		ctcDetail.resetOriginalValues();
	}

	/**
	 * Caches the ctc details in the entity cache if it is enabled.
	 *
	 * @param ctcDetails the ctc details
	 */
	@Override
	public void cacheResult(List<CtcDetail> ctcDetails) {
		for (CtcDetail ctcDetail : ctcDetails) {
			if (entityCache.getResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
						CtcDetailImpl.class, ctcDetail.getPrimaryKey()) == null) {
				cacheResult(ctcDetail);
			}
			else {
				ctcDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ctc details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CtcDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ctc detail.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CtcDetail ctcDetail) {
		entityCache.removeResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
			CtcDetailImpl.class, ctcDetail.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CtcDetail> ctcDetails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CtcDetail ctcDetail : ctcDetails) {
			entityCache.removeResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
				CtcDetailImpl.class, ctcDetail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ctc detail with the primary key. Does not add the ctc detail to the database.
	 *
	 * @param ctc the primary key for the new ctc detail
	 * @return the new ctc detail
	 */
	@Override
	public CtcDetail create(int ctc) {
		CtcDetail ctcDetail = new CtcDetailImpl();

		ctcDetail.setNew(true);
		ctcDetail.setPrimaryKey(ctc);

		return ctcDetail;
	}

	/**
	 * Removes the ctc detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctc the primary key of the ctc detail
	 * @return the ctc detail that was removed
	 * @throws NoSuchCtcDetailException if a ctc detail with the primary key could not be found
	 */
	@Override
	public CtcDetail remove(int ctc) throws NoSuchCtcDetailException {
		return remove((Serializable)ctc);
	}

	/**
	 * Removes the ctc detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ctc detail
	 * @return the ctc detail that was removed
	 * @throws NoSuchCtcDetailException if a ctc detail with the primary key could not be found
	 */
	@Override
	public CtcDetail remove(Serializable primaryKey)
		throws NoSuchCtcDetailException {
		Session session = null;

		try {
			session = openSession();

			CtcDetail ctcDetail = (CtcDetail)session.get(CtcDetailImpl.class,
					primaryKey);

			if (ctcDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCtcDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ctcDetail);
		}
		catch (NoSuchCtcDetailException nsee) {
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
	protected CtcDetail removeImpl(CtcDetail ctcDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ctcDetail)) {
				ctcDetail = (CtcDetail)session.get(CtcDetailImpl.class,
						ctcDetail.getPrimaryKeyObj());
			}

			if (ctcDetail != null) {
				session.delete(ctcDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ctcDetail != null) {
			clearCache(ctcDetail);
		}

		return ctcDetail;
	}

	@Override
	public CtcDetail updateImpl(CtcDetail ctcDetail) {
		boolean isNew = ctcDetail.isNew();

		Session session = null;

		try {
			session = openSession();

			if (ctcDetail.isNew()) {
				session.save(ctcDetail);

				ctcDetail.setNew(false);
			}
			else {
				ctcDetail = (CtcDetail)session.merge(ctcDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
			CtcDetailImpl.class, ctcDetail.getPrimaryKey(), ctcDetail, false);

		ctcDetail.resetOriginalValues();

		return ctcDetail;
	}

	/**
	 * Returns the ctc detail with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ctc detail
	 * @return the ctc detail
	 * @throws NoSuchCtcDetailException if a ctc detail with the primary key could not be found
	 */
	@Override
	public CtcDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCtcDetailException {
		CtcDetail ctcDetail = fetchByPrimaryKey(primaryKey);

		if (ctcDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCtcDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ctcDetail;
	}

	/**
	 * Returns the ctc detail with the primary key or throws a {@link NoSuchCtcDetailException} if it could not be found.
	 *
	 * @param ctc the primary key of the ctc detail
	 * @return the ctc detail
	 * @throws NoSuchCtcDetailException if a ctc detail with the primary key could not be found
	 */
	@Override
	public CtcDetail findByPrimaryKey(int ctc) throws NoSuchCtcDetailException {
		return findByPrimaryKey((Serializable)ctc);
	}

	/**
	 * Returns the ctc detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ctc detail
	 * @return the ctc detail, or <code>null</code> if a ctc detail with the primary key could not be found
	 */
	@Override
	public CtcDetail fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
				CtcDetailImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CtcDetail ctcDetail = (CtcDetail)serializable;

		if (ctcDetail == null) {
			Session session = null;

			try {
				session = openSession();

				ctcDetail = (CtcDetail)session.get(CtcDetailImpl.class,
						primaryKey);

				if (ctcDetail != null) {
					cacheResult(ctcDetail);
				}
				else {
					entityCache.putResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
						CtcDetailImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
					CtcDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ctcDetail;
	}

	/**
	 * Returns the ctc detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ctc the primary key of the ctc detail
	 * @return the ctc detail, or <code>null</code> if a ctc detail with the primary key could not be found
	 */
	@Override
	public CtcDetail fetchByPrimaryKey(int ctc) {
		return fetchByPrimaryKey((Serializable)ctc);
	}

	@Override
	public Map<Serializable, CtcDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CtcDetail> map = new HashMap<Serializable, CtcDetail>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CtcDetail ctcDetail = fetchByPrimaryKey(primaryKey);

			if (ctcDetail != null) {
				map.put(primaryKey, ctcDetail);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
					CtcDetailImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CtcDetail)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CTCDETAIL_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((int)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CtcDetail ctcDetail : (List<CtcDetail>)q.list()) {
				map.put(ctcDetail.getPrimaryKeyObj(), ctcDetail);

				cacheResult(ctcDetail);

				uncachedPrimaryKeys.remove(ctcDetail.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CtcDetailModelImpl.ENTITY_CACHE_ENABLED,
					CtcDetailImpl.class, primaryKey, nullModel);
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
	 * Returns all the ctc details.
	 *
	 * @return the ctc details
	 */
	@Override
	public List<CtcDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ctc details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CtcDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ctc details
	 * @param end the upper bound of the range of ctc details (not inclusive)
	 * @return the range of ctc details
	 */
	@Override
	public List<CtcDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ctc details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CtcDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ctc details
	 * @param end the upper bound of the range of ctc details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ctc details
	 */
	@Override
	public List<CtcDetail> findAll(int start, int end,
		OrderByComparator<CtcDetail> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ctc details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CtcDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ctc details
	 * @param end the upper bound of the range of ctc details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ctc details
	 */
	@Override
	public List<CtcDetail> findAll(int start, int end,
		OrderByComparator<CtcDetail> orderByComparator,
		boolean retrieveFromCache) {
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

		List<CtcDetail> list = null;

		if (retrieveFromCache) {
			list = (List<CtcDetail>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CTCDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CTCDETAIL;

				if (pagination) {
					sql = sql.concat(CtcDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CtcDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CtcDetail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ctc details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CtcDetail ctcDetail : findAll()) {
			remove(ctcDetail);
		}
	}

	/**
	 * Returns the number of ctc details.
	 *
	 * @return the number of ctc details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CTCDETAIL);

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
		return CtcDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ctc detail persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CtcDetailImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CTCDETAIL = "SELECT ctcDetail FROM CtcDetail ctcDetail";
	private static final String _SQL_SELECT_CTCDETAIL_WHERE_PKS_IN = "SELECT ctcDetail FROM CtcDetail ctcDetail WHERE ctc IN (";
	private static final String _SQL_COUNT_CTCDETAIL = "SELECT COUNT(ctcDetail) FROM CtcDetail ctcDetail";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ctcDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CtcDetail exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CtcDetailPersistenceImpl.class);
}