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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.vy.payroll.exception.NoSuchLeaveRequestException;
import com.vy.payroll.model.LeaveRequest;
import com.vy.payroll.model.impl.LeaveRequestImpl;
import com.vy.payroll.model.impl.LeaveRequestModelImpl;
import com.vy.payroll.service.persistence.LeaveRequestPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the leave request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveRequestPersistence
 * @see com.vy.payroll.service.persistence.LeaveRequestUtil
 * @generated
 */
@ProviderType
public class LeaveRequestPersistenceImpl extends BasePersistenceImpl<LeaveRequest>
	implements LeaveRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveRequestUtil} to access the leave request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRequestModelImpl.FINDER_CACHE_ENABLED, LeaveRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRequestModelImpl.FINDER_CACHE_ENABLED, LeaveRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LeaveRequestPersistenceImpl() {
		setModelClass(LeaveRequest.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("date", "date_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the leave request in the entity cache if it is enabled.
	 *
	 * @param leaveRequest the leave request
	 */
	@Override
	public void cacheResult(LeaveRequest leaveRequest) {
		entityCache.putResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRequestImpl.class, leaveRequest.getPrimaryKey(), leaveRequest);

		leaveRequest.resetOriginalValues();
	}

	/**
	 * Caches the leave requests in the entity cache if it is enabled.
	 *
	 * @param leaveRequests the leave requests
	 */
	@Override
	public void cacheResult(List<LeaveRequest> leaveRequests) {
		for (LeaveRequest leaveRequest : leaveRequests) {
			if (entityCache.getResult(
						LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
						LeaveRequestImpl.class, leaveRequest.getPrimaryKey()) == null) {
				cacheResult(leaveRequest);
			}
			else {
				leaveRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave requests.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave request.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveRequest leaveRequest) {
		entityCache.removeResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRequestImpl.class, leaveRequest.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveRequest> leaveRequests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveRequest leaveRequest : leaveRequests) {
			entityCache.removeResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
				LeaveRequestImpl.class, leaveRequest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave request with the primary key. Does not add the leave request to the database.
	 *
	 * @param request_id the primary key for the new leave request
	 * @return the new leave request
	 */
	@Override
	public LeaveRequest create(int request_id) {
		LeaveRequest leaveRequest = new LeaveRequestImpl();

		leaveRequest.setNew(true);
		leaveRequest.setPrimaryKey(request_id);

		return leaveRequest;
	}

	/**
	 * Removes the leave request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param request_id the primary key of the leave request
	 * @return the leave request that was removed
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest remove(int request_id)
		throws NoSuchLeaveRequestException {
		return remove((Serializable)request_id);
	}

	/**
	 * Removes the leave request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave request
	 * @return the leave request that was removed
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest remove(Serializable primaryKey)
		throws NoSuchLeaveRequestException {
		Session session = null;

		try {
			session = openSession();

			LeaveRequest leaveRequest = (LeaveRequest)session.get(LeaveRequestImpl.class,
					primaryKey);

			if (leaveRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveRequest);
		}
		catch (NoSuchLeaveRequestException nsee) {
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
	protected LeaveRequest removeImpl(LeaveRequest leaveRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveRequest)) {
				leaveRequest = (LeaveRequest)session.get(LeaveRequestImpl.class,
						leaveRequest.getPrimaryKeyObj());
			}

			if (leaveRequest != null) {
				session.delete(leaveRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveRequest != null) {
			clearCache(leaveRequest);
		}

		return leaveRequest;
	}

	@Override
	public LeaveRequest updateImpl(LeaveRequest leaveRequest) {
		boolean isNew = leaveRequest.isNew();

		Session session = null;

		try {
			session = openSession();

			if (leaveRequest.isNew()) {
				session.save(leaveRequest);

				leaveRequest.setNew(false);
			}
			else {
				leaveRequest = (LeaveRequest)session.merge(leaveRequest);
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

		entityCache.putResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
			LeaveRequestImpl.class, leaveRequest.getPrimaryKey(), leaveRequest,
			false);

		leaveRequest.resetOriginalValues();

		return leaveRequest;
	}

	/**
	 * Returns the leave request with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave request
	 * @return the leave request
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveRequestException {
		LeaveRequest leaveRequest = fetchByPrimaryKey(primaryKey);

		if (leaveRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveRequest;
	}

	/**
	 * Returns the leave request with the primary key or throws a {@link NoSuchLeaveRequestException} if it could not be found.
	 *
	 * @param request_id the primary key of the leave request
	 * @return the leave request
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest findByPrimaryKey(int request_id)
		throws NoSuchLeaveRequestException {
		return findByPrimaryKey((Serializable)request_id);
	}

	/**
	 * Returns the leave request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave request
	 * @return the leave request, or <code>null</code> if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
				LeaveRequestImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LeaveRequest leaveRequest = (LeaveRequest)serializable;

		if (leaveRequest == null) {
			Session session = null;

			try {
				session = openSession();

				leaveRequest = (LeaveRequest)session.get(LeaveRequestImpl.class,
						primaryKey);

				if (leaveRequest != null) {
					cacheResult(leaveRequest);
				}
				else {
					entityCache.putResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
						LeaveRequestImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
					LeaveRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveRequest;
	}

	/**
	 * Returns the leave request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param request_id the primary key of the leave request
	 * @return the leave request, or <code>null</code> if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest fetchByPrimaryKey(int request_id) {
		return fetchByPrimaryKey((Serializable)request_id);
	}

	@Override
	public Map<Serializable, LeaveRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LeaveRequest> map = new HashMap<Serializable, LeaveRequest>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LeaveRequest leaveRequest = fetchByPrimaryKey(primaryKey);

			if (leaveRequest != null) {
				map.put(primaryKey, leaveRequest);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
					LeaveRequestImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LeaveRequest)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEAVEREQUEST_WHERE_PKS_IN);

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

			for (LeaveRequest leaveRequest : (List<LeaveRequest>)q.list()) {
				map.put(leaveRequest.getPrimaryKeyObj(), leaveRequest);

				cacheResult(leaveRequest);

				uncachedPrimaryKeys.remove(leaveRequest.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LeaveRequestModelImpl.ENTITY_CACHE_ENABLED,
					LeaveRequestImpl.class, primaryKey, nullModel);
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
	 * Returns all the leave requests.
	 *
	 * @return the leave requests
	 */
	@Override
	public List<LeaveRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @return the range of leave requests
	 */
	@Override
	public List<LeaveRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave requests
	 */
	@Override
	public List<LeaveRequest> findAll(int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of leave requests
	 */
	@Override
	public List<LeaveRequest> findAll(int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator,
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

		List<LeaveRequest> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveRequest>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEAVEREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEREQUEST;

				if (pagination) {
					sql = sql.concat(LeaveRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveRequest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveRequest>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveRequest leaveRequest : findAll()) {
			remove(leaveRequest);
		}
	}

	/**
	 * Returns the number of leave requests.
	 *
	 * @return the number of leave requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEAVEREQUEST);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave request persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LeaveRequestImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LEAVEREQUEST = "SELECT leaveRequest FROM LeaveRequest leaveRequest";
	private static final String _SQL_SELECT_LEAVEREQUEST_WHERE_PKS_IN = "SELECT leaveRequest FROM LeaveRequest leaveRequest WHERE request_id IN (";
	private static final String _SQL_COUNT_LEAVEREQUEST = "SELECT COUNT(leaveRequest) FROM LeaveRequest leaveRequest";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveRequest exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(LeaveRequestPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
}