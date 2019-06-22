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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.vy.payroll.exception.NoSuchAdvanceSalaryRecordException;
import com.vy.payroll.model.AdvanceSalaryRecord;
import com.vy.payroll.model.impl.AdvanceSalaryRecordImpl;
import com.vy.payroll.model.impl.AdvanceSalaryRecordModelImpl;
import com.vy.payroll.service.persistence.AdvanceSalaryRecordPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the advance salary record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdvanceSalaryRecordPersistence
 * @see com.vy.payroll.service.persistence.AdvanceSalaryRecordUtil
 * @generated
 */
@ProviderType
public class AdvanceSalaryRecordPersistenceImpl extends BasePersistenceImpl<AdvanceSalaryRecord>
	implements AdvanceSalaryRecordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdvanceSalaryRecordUtil} to access the advance salary record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdvanceSalaryRecordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordModelImpl.FINDER_CACHE_ENABLED,
			AdvanceSalaryRecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordModelImpl.FINDER_CACHE_ENABLED,
			AdvanceSalaryRecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISCHECKED =
		new FinderPath(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordModelImpl.FINDER_CACHE_ENABLED,
			AdvanceSalaryRecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsChecked",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHECKED =
		new FinderPath(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordModelImpl.FINDER_CACHE_ENABLED,
			AdvanceSalaryRecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsChecked",
			new String[] { String.class.getName() },
			AdvanceSalaryRecordModelImpl.IS_CHECKED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISCHECKED = new FinderPath(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsChecked",
			new String[] { String.class.getName() });

	/**
	 * Returns all the advance salary records where is_checked = &#63;.
	 *
	 * @param is_checked the is_checked
	 * @return the matching advance salary records
	 */
	@Override
	public List<AdvanceSalaryRecord> findByIsChecked(String is_checked) {
		return findByIsChecked(is_checked, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the advance salary records where is_checked = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_checked the is_checked
	 * @param start the lower bound of the range of advance salary records
	 * @param end the upper bound of the range of advance salary records (not inclusive)
	 * @return the range of matching advance salary records
	 */
	@Override
	public List<AdvanceSalaryRecord> findByIsChecked(String is_checked,
		int start, int end) {
		return findByIsChecked(is_checked, start, end, null);
	}

	/**
	 * Returns an ordered range of all the advance salary records where is_checked = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_checked the is_checked
	 * @param start the lower bound of the range of advance salary records
	 * @param end the upper bound of the range of advance salary records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching advance salary records
	 */
	@Override
	public List<AdvanceSalaryRecord> findByIsChecked(String is_checked,
		int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		return findByIsChecked(is_checked, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the advance salary records where is_checked = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_checked the is_checked
	 * @param start the lower bound of the range of advance salary records
	 * @param end the upper bound of the range of advance salary records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching advance salary records
	 */
	@Override
	public List<AdvanceSalaryRecord> findByIsChecked(String is_checked,
		int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator,
		boolean retrieveFromCache) {
		is_checked = Objects.toString(is_checked, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHECKED;
			finderArgs = new Object[] { is_checked };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISCHECKED;
			finderArgs = new Object[] { is_checked, start, end, orderByComparator };
		}

		List<AdvanceSalaryRecord> list = null;

		if (retrieveFromCache) {
			list = (List<AdvanceSalaryRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AdvanceSalaryRecord advanceSalaryRecord : list) {
					if (!is_checked.equals(advanceSalaryRecord.getIs_checked())) {
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

			query.append(_SQL_SELECT_ADVANCESALARYRECORD_WHERE);

			boolean bindIs_checked = false;

			if (is_checked.isEmpty()) {
				query.append(_FINDER_COLUMN_ISCHECKED_IS_CHECKED_3);
			}
			else {
				bindIs_checked = true;

				query.append(_FINDER_COLUMN_ISCHECKED_IS_CHECKED_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvanceSalaryRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIs_checked) {
					qPos.add(is_checked);
				}

				if (!pagination) {
					list = (List<AdvanceSalaryRecord>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AdvanceSalaryRecord>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first advance salary record in the ordered set where is_checked = &#63;.
	 *
	 * @param is_checked the is_checked
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching advance salary record
	 * @throws NoSuchAdvanceSalaryRecordException if a matching advance salary record could not be found
	 */
	@Override
	public AdvanceSalaryRecord findByIsChecked_First(String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws NoSuchAdvanceSalaryRecordException {
		AdvanceSalaryRecord advanceSalaryRecord = fetchByIsChecked_First(is_checked,
				orderByComparator);

		if (advanceSalaryRecord != null) {
			return advanceSalaryRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("is_checked=");
		msg.append(is_checked);

		msg.append("}");

		throw new NoSuchAdvanceSalaryRecordException(msg.toString());
	}

	/**
	 * Returns the first advance salary record in the ordered set where is_checked = &#63;.
	 *
	 * @param is_checked the is_checked
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching advance salary record, or <code>null</code> if a matching advance salary record could not be found
	 */
	@Override
	public AdvanceSalaryRecord fetchByIsChecked_First(String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		List<AdvanceSalaryRecord> list = findByIsChecked(is_checked, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last advance salary record in the ordered set where is_checked = &#63;.
	 *
	 * @param is_checked the is_checked
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching advance salary record
	 * @throws NoSuchAdvanceSalaryRecordException if a matching advance salary record could not be found
	 */
	@Override
	public AdvanceSalaryRecord findByIsChecked_Last(String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws NoSuchAdvanceSalaryRecordException {
		AdvanceSalaryRecord advanceSalaryRecord = fetchByIsChecked_Last(is_checked,
				orderByComparator);

		if (advanceSalaryRecord != null) {
			return advanceSalaryRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("is_checked=");
		msg.append(is_checked);

		msg.append("}");

		throw new NoSuchAdvanceSalaryRecordException(msg.toString());
	}

	/**
	 * Returns the last advance salary record in the ordered set where is_checked = &#63;.
	 *
	 * @param is_checked the is_checked
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching advance salary record, or <code>null</code> if a matching advance salary record could not be found
	 */
	@Override
	public AdvanceSalaryRecord fetchByIsChecked_Last(String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		int count = countByIsChecked(is_checked);

		if (count == 0) {
			return null;
		}

		List<AdvanceSalaryRecord> list = findByIsChecked(is_checked, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the advance salary records before and after the current advance salary record in the ordered set where is_checked = &#63;.
	 *
	 * @param request_id the primary key of the current advance salary record
	 * @param is_checked the is_checked
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next advance salary record
	 * @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	 */
	@Override
	public AdvanceSalaryRecord[] findByIsChecked_PrevAndNext(int request_id,
		String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator)
		throws NoSuchAdvanceSalaryRecordException {
		is_checked = Objects.toString(is_checked, "");

		AdvanceSalaryRecord advanceSalaryRecord = findByPrimaryKey(request_id);

		Session session = null;

		try {
			session = openSession();

			AdvanceSalaryRecord[] array = new AdvanceSalaryRecordImpl[3];

			array[0] = getByIsChecked_PrevAndNext(session, advanceSalaryRecord,
					is_checked, orderByComparator, true);

			array[1] = advanceSalaryRecord;

			array[2] = getByIsChecked_PrevAndNext(session, advanceSalaryRecord,
					is_checked, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdvanceSalaryRecord getByIsChecked_PrevAndNext(Session session,
		AdvanceSalaryRecord advanceSalaryRecord, String is_checked,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVANCESALARYRECORD_WHERE);

		boolean bindIs_checked = false;

		if (is_checked.isEmpty()) {
			query.append(_FINDER_COLUMN_ISCHECKED_IS_CHECKED_3);
		}
		else {
			bindIs_checked = true;

			query.append(_FINDER_COLUMN_ISCHECKED_IS_CHECKED_2);
		}

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
			query.append(AdvanceSalaryRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIs_checked) {
			qPos.add(is_checked);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advanceSalaryRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvanceSalaryRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the advance salary records where is_checked = &#63; from the database.
	 *
	 * @param is_checked the is_checked
	 */
	@Override
	public void removeByIsChecked(String is_checked) {
		for (AdvanceSalaryRecord advanceSalaryRecord : findByIsChecked(
				is_checked, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(advanceSalaryRecord);
		}
	}

	/**
	 * Returns the number of advance salary records where is_checked = &#63;.
	 *
	 * @param is_checked the is_checked
	 * @return the number of matching advance salary records
	 */
	@Override
	public int countByIsChecked(String is_checked) {
		is_checked = Objects.toString(is_checked, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISCHECKED;

		Object[] finderArgs = new Object[] { is_checked };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVANCESALARYRECORD_WHERE);

			boolean bindIs_checked = false;

			if (is_checked.isEmpty()) {
				query.append(_FINDER_COLUMN_ISCHECKED_IS_CHECKED_3);
			}
			else {
				bindIs_checked = true;

				query.append(_FINDER_COLUMN_ISCHECKED_IS_CHECKED_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIs_checked) {
					qPos.add(is_checked);
				}

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

	private static final String _FINDER_COLUMN_ISCHECKED_IS_CHECKED_1 = "advanceSalaryRecord.is_checked IS NULL";
	private static final String _FINDER_COLUMN_ISCHECKED_IS_CHECKED_2 = "advanceSalaryRecord.is_checked = ?";
	private static final String _FINDER_COLUMN_ISCHECKED_IS_CHECKED_3 = "(advanceSalaryRecord.is_checked IS NULL OR advanceSalaryRecord.is_checked = '')";

	public AdvanceSalaryRecordPersistenceImpl() {
		setModelClass(AdvanceSalaryRecord.class);

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
	 * Caches the advance salary record in the entity cache if it is enabled.
	 *
	 * @param advanceSalaryRecord the advance salary record
	 */
	@Override
	public void cacheResult(AdvanceSalaryRecord advanceSalaryRecord) {
		entityCache.putResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordImpl.class, advanceSalaryRecord.getPrimaryKey(),
			advanceSalaryRecord);

		advanceSalaryRecord.resetOriginalValues();
	}

	/**
	 * Caches the advance salary records in the entity cache if it is enabled.
	 *
	 * @param advanceSalaryRecords the advance salary records
	 */
	@Override
	public void cacheResult(List<AdvanceSalaryRecord> advanceSalaryRecords) {
		for (AdvanceSalaryRecord advanceSalaryRecord : advanceSalaryRecords) {
			if (entityCache.getResult(
						AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
						AdvanceSalaryRecordImpl.class,
						advanceSalaryRecord.getPrimaryKey()) == null) {
				cacheResult(advanceSalaryRecord);
			}
			else {
				advanceSalaryRecord.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all advance salary records.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AdvanceSalaryRecordImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the advance salary record.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdvanceSalaryRecord advanceSalaryRecord) {
		entityCache.removeResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordImpl.class, advanceSalaryRecord.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdvanceSalaryRecord> advanceSalaryRecords) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdvanceSalaryRecord advanceSalaryRecord : advanceSalaryRecords) {
			entityCache.removeResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
				AdvanceSalaryRecordImpl.class,
				advanceSalaryRecord.getPrimaryKey());
		}
	}

	/**
	 * Creates a new advance salary record with the primary key. Does not add the advance salary record to the database.
	 *
	 * @param request_id the primary key for the new advance salary record
	 * @return the new advance salary record
	 */
	@Override
	public AdvanceSalaryRecord create(int request_id) {
		AdvanceSalaryRecord advanceSalaryRecord = new AdvanceSalaryRecordImpl();

		advanceSalaryRecord.setNew(true);
		advanceSalaryRecord.setPrimaryKey(request_id);

		return advanceSalaryRecord;
	}

	/**
	 * Removes the advance salary record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param request_id the primary key of the advance salary record
	 * @return the advance salary record that was removed
	 * @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	 */
	@Override
	public AdvanceSalaryRecord remove(int request_id)
		throws NoSuchAdvanceSalaryRecordException {
		return remove((Serializable)request_id);
	}

	/**
	 * Removes the advance salary record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the advance salary record
	 * @return the advance salary record that was removed
	 * @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	 */
	@Override
	public AdvanceSalaryRecord remove(Serializable primaryKey)
		throws NoSuchAdvanceSalaryRecordException {
		Session session = null;

		try {
			session = openSession();

			AdvanceSalaryRecord advanceSalaryRecord = (AdvanceSalaryRecord)session.get(AdvanceSalaryRecordImpl.class,
					primaryKey);

			if (advanceSalaryRecord == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdvanceSalaryRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(advanceSalaryRecord);
		}
		catch (NoSuchAdvanceSalaryRecordException nsee) {
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
	protected AdvanceSalaryRecord removeImpl(
		AdvanceSalaryRecord advanceSalaryRecord) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(advanceSalaryRecord)) {
				advanceSalaryRecord = (AdvanceSalaryRecord)session.get(AdvanceSalaryRecordImpl.class,
						advanceSalaryRecord.getPrimaryKeyObj());
			}

			if (advanceSalaryRecord != null) {
				session.delete(advanceSalaryRecord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (advanceSalaryRecord != null) {
			clearCache(advanceSalaryRecord);
		}

		return advanceSalaryRecord;
	}

	@Override
	public AdvanceSalaryRecord updateImpl(
		AdvanceSalaryRecord advanceSalaryRecord) {
		boolean isNew = advanceSalaryRecord.isNew();

		if (!(advanceSalaryRecord instanceof AdvanceSalaryRecordModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(advanceSalaryRecord.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(advanceSalaryRecord);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in advanceSalaryRecord proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AdvanceSalaryRecord implementation " +
				advanceSalaryRecord.getClass());
		}

		AdvanceSalaryRecordModelImpl advanceSalaryRecordModelImpl = (AdvanceSalaryRecordModelImpl)advanceSalaryRecord;

		Session session = null;

		try {
			session = openSession();

			if (advanceSalaryRecord.isNew()) {
				session.save(advanceSalaryRecord);

				advanceSalaryRecord.setNew(false);
			}
			else {
				advanceSalaryRecord = (AdvanceSalaryRecord)session.merge(advanceSalaryRecord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AdvanceSalaryRecordModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					advanceSalaryRecordModelImpl.getIs_checked()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISCHECKED, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHECKED,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((advanceSalaryRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHECKED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advanceSalaryRecordModelImpl.getOriginalIs_checked()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ISCHECKED, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHECKED,
					args);

				args = new Object[] { advanceSalaryRecordModelImpl.getIs_checked() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ISCHECKED, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISCHECKED,
					args);
			}
		}

		entityCache.putResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
			AdvanceSalaryRecordImpl.class, advanceSalaryRecord.getPrimaryKey(),
			advanceSalaryRecord, false);

		advanceSalaryRecord.resetOriginalValues();

		return advanceSalaryRecord;
	}

	/**
	 * Returns the advance salary record with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the advance salary record
	 * @return the advance salary record
	 * @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	 */
	@Override
	public AdvanceSalaryRecord findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdvanceSalaryRecordException {
		AdvanceSalaryRecord advanceSalaryRecord = fetchByPrimaryKey(primaryKey);

		if (advanceSalaryRecord == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdvanceSalaryRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return advanceSalaryRecord;
	}

	/**
	 * Returns the advance salary record with the primary key or throws a {@link NoSuchAdvanceSalaryRecordException} if it could not be found.
	 *
	 * @param request_id the primary key of the advance salary record
	 * @return the advance salary record
	 * @throws NoSuchAdvanceSalaryRecordException if a advance salary record with the primary key could not be found
	 */
	@Override
	public AdvanceSalaryRecord findByPrimaryKey(int request_id)
		throws NoSuchAdvanceSalaryRecordException {
		return findByPrimaryKey((Serializable)request_id);
	}

	/**
	 * Returns the advance salary record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the advance salary record
	 * @return the advance salary record, or <code>null</code> if a advance salary record with the primary key could not be found
	 */
	@Override
	public AdvanceSalaryRecord fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
				AdvanceSalaryRecordImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AdvanceSalaryRecord advanceSalaryRecord = (AdvanceSalaryRecord)serializable;

		if (advanceSalaryRecord == null) {
			Session session = null;

			try {
				session = openSession();

				advanceSalaryRecord = (AdvanceSalaryRecord)session.get(AdvanceSalaryRecordImpl.class,
						primaryKey);

				if (advanceSalaryRecord != null) {
					cacheResult(advanceSalaryRecord);
				}
				else {
					entityCache.putResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
						AdvanceSalaryRecordImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
					AdvanceSalaryRecordImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return advanceSalaryRecord;
	}

	/**
	 * Returns the advance salary record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param request_id the primary key of the advance salary record
	 * @return the advance salary record, or <code>null</code> if a advance salary record with the primary key could not be found
	 */
	@Override
	public AdvanceSalaryRecord fetchByPrimaryKey(int request_id) {
		return fetchByPrimaryKey((Serializable)request_id);
	}

	@Override
	public Map<Serializable, AdvanceSalaryRecord> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AdvanceSalaryRecord> map = new HashMap<Serializable, AdvanceSalaryRecord>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AdvanceSalaryRecord advanceSalaryRecord = fetchByPrimaryKey(primaryKey);

			if (advanceSalaryRecord != null) {
				map.put(primaryKey, advanceSalaryRecord);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
					AdvanceSalaryRecordImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AdvanceSalaryRecord)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ADVANCESALARYRECORD_WHERE_PKS_IN);

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

			for (AdvanceSalaryRecord advanceSalaryRecord : (List<AdvanceSalaryRecord>)q.list()) {
				map.put(advanceSalaryRecord.getPrimaryKeyObj(),
					advanceSalaryRecord);

				cacheResult(advanceSalaryRecord);

				uncachedPrimaryKeys.remove(advanceSalaryRecord.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AdvanceSalaryRecordModelImpl.ENTITY_CACHE_ENABLED,
					AdvanceSalaryRecordImpl.class, primaryKey, nullModel);
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
	 * Returns all the advance salary records.
	 *
	 * @return the advance salary records
	 */
	@Override
	public List<AdvanceSalaryRecord> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the advance salary records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of advance salary records
	 * @param end the upper bound of the range of advance salary records (not inclusive)
	 * @return the range of advance salary records
	 */
	@Override
	public List<AdvanceSalaryRecord> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the advance salary records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of advance salary records
	 * @param end the upper bound of the range of advance salary records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of advance salary records
	 */
	@Override
	public List<AdvanceSalaryRecord> findAll(int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the advance salary records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdvanceSalaryRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of advance salary records
	 * @param end the upper bound of the range of advance salary records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of advance salary records
	 */
	@Override
	public List<AdvanceSalaryRecord> findAll(int start, int end,
		OrderByComparator<AdvanceSalaryRecord> orderByComparator,
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

		List<AdvanceSalaryRecord> list = null;

		if (retrieveFromCache) {
			list = (List<AdvanceSalaryRecord>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ADVANCESALARYRECORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADVANCESALARYRECORD;

				if (pagination) {
					sql = sql.concat(AdvanceSalaryRecordModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdvanceSalaryRecord>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AdvanceSalaryRecord>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the advance salary records from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AdvanceSalaryRecord advanceSalaryRecord : findAll()) {
			remove(advanceSalaryRecord);
		}
	}

	/**
	 * Returns the number of advance salary records.
	 *
	 * @return the number of advance salary records
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADVANCESALARYRECORD);

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
		return AdvanceSalaryRecordModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the advance salary record persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AdvanceSalaryRecordImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ADVANCESALARYRECORD = "SELECT advanceSalaryRecord FROM AdvanceSalaryRecord advanceSalaryRecord";
	private static final String _SQL_SELECT_ADVANCESALARYRECORD_WHERE_PKS_IN = "SELECT advanceSalaryRecord FROM AdvanceSalaryRecord advanceSalaryRecord WHERE request_id IN (";
	private static final String _SQL_SELECT_ADVANCESALARYRECORD_WHERE = "SELECT advanceSalaryRecord FROM AdvanceSalaryRecord advanceSalaryRecord WHERE ";
	private static final String _SQL_COUNT_ADVANCESALARYRECORD = "SELECT COUNT(advanceSalaryRecord) FROM AdvanceSalaryRecord advanceSalaryRecord";
	private static final String _SQL_COUNT_ADVANCESALARYRECORD_WHERE = "SELECT COUNT(advanceSalaryRecord) FROM AdvanceSalaryRecord advanceSalaryRecord WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "advanceSalaryRecord.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdvanceSalaryRecord exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdvanceSalaryRecord exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AdvanceSalaryRecordPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
}