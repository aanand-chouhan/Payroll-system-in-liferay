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
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.vy.payroll.exception.NoSuchPayslipDetailsException;
import com.vy.payroll.model.PayslipDetails;
import com.vy.payroll.model.impl.PayslipDetailsImpl;
import com.vy.payroll.model.impl.PayslipDetailsModelImpl;
import com.vy.payroll.service.persistence.PayslipDetailsPersistence;

import java.io.Serializable;

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
 * The persistence implementation for the payslip details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayslipDetailsPersistence
 * @see com.vy.payroll.service.persistence.PayslipDetailsUtil
 * @generated
 */
@ProviderType
public class PayslipDetailsPersistenceImpl extends BasePersistenceImpl<PayslipDetails>
	implements PayslipDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PayslipDetailsUtil} to access the payslip details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PayslipDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsModelImpl.FINDER_CACHE_ENABLED,
			PayslipDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsModelImpl.FINDER_CACHE_ENABLED,
			PayslipDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHID = new FinderPath(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsModelImpl.FINDER_CACHE_ENABLED,
			PayslipDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMonthId",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHID =
		new FinderPath(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsModelImpl.FINDER_CACHE_ENABLED,
			PayslipDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMonthId",
			new String[] { Integer.class.getName(), String.class.getName() },
			PayslipDetailsModelImpl.MONTH_COLUMN_BITMASK |
			PayslipDetailsModelImpl.EID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHID = new FinderPath(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMonthId",
			new String[] { Integer.class.getName(), String.class.getName() });

	/**
	 * Returns all the payslip detailses where month = &#63; and eid = &#63;.
	 *
	 * @param month the month
	 * @param eid the eid
	 * @return the matching payslip detailses
	 */
	@Override
	public List<PayslipDetails> findByMonthId(int month, String eid) {
		return findByMonthId(month, eid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the payslip detailses where month = &#63; and eid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param month the month
	 * @param eid the eid
	 * @param start the lower bound of the range of payslip detailses
	 * @param end the upper bound of the range of payslip detailses (not inclusive)
	 * @return the range of matching payslip detailses
	 */
	@Override
	public List<PayslipDetails> findByMonthId(int month, String eid, int start,
		int end) {
		return findByMonthId(month, eid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payslip detailses where month = &#63; and eid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param month the month
	 * @param eid the eid
	 * @param start the lower bound of the range of payslip detailses
	 * @param end the upper bound of the range of payslip detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payslip detailses
	 */
	@Override
	public List<PayslipDetails> findByMonthId(int month, String eid, int start,
		int end, OrderByComparator<PayslipDetails> orderByComparator) {
		return findByMonthId(month, eid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payslip detailses where month = &#63; and eid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param month the month
	 * @param eid the eid
	 * @param start the lower bound of the range of payslip detailses
	 * @param end the upper bound of the range of payslip detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching payslip detailses
	 */
	@Override
	public List<PayslipDetails> findByMonthId(int month, String eid, int start,
		int end, OrderByComparator<PayslipDetails> orderByComparator,
		boolean retrieveFromCache) {
		eid = Objects.toString(eid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHID;
			finderArgs = new Object[] { month, eid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHID;
			finderArgs = new Object[] { month, eid, start, end, orderByComparator };
		}

		List<PayslipDetails> list = null;

		if (retrieveFromCache) {
			list = (List<PayslipDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PayslipDetails payslipDetails : list) {
					if ((month != payslipDetails.getMonth()) ||
							!eid.equals(payslipDetails.getEid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PAYSLIPDETAILS_WHERE);

			query.append(_FINDER_COLUMN_MONTHID_MONTH_2);

			boolean bindEid = false;

			if (eid.isEmpty()) {
				query.append(_FINDER_COLUMN_MONTHID_EID_3);
			}
			else {
				bindEid = true;

				query.append(_FINDER_COLUMN_MONTHID_EID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayslipDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(month);

				if (bindEid) {
					qPos.add(eid);
				}

				if (!pagination) {
					list = (List<PayslipDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayslipDetails>)QueryUtil.list(q,
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
	 * Returns the first payslip details in the ordered set where month = &#63; and eid = &#63;.
	 *
	 * @param month the month
	 * @param eid the eid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payslip details
	 * @throws NoSuchPayslipDetailsException if a matching payslip details could not be found
	 */
	@Override
	public PayslipDetails findByMonthId_First(int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator)
		throws NoSuchPayslipDetailsException {
		PayslipDetails payslipDetails = fetchByMonthId_First(month, eid,
				orderByComparator);

		if (payslipDetails != null) {
			return payslipDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("month=");
		msg.append(month);

		msg.append(", eid=");
		msg.append(eid);

		msg.append("}");

		throw new NoSuchPayslipDetailsException(msg.toString());
	}

	/**
	 * Returns the first payslip details in the ordered set where month = &#63; and eid = &#63;.
	 *
	 * @param month the month
	 * @param eid the eid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payslip details, or <code>null</code> if a matching payslip details could not be found
	 */
	@Override
	public PayslipDetails fetchByMonthId_First(int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator) {
		List<PayslipDetails> list = findByMonthId(month, eid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payslip details in the ordered set where month = &#63; and eid = &#63;.
	 *
	 * @param month the month
	 * @param eid the eid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payslip details
	 * @throws NoSuchPayslipDetailsException if a matching payslip details could not be found
	 */
	@Override
	public PayslipDetails findByMonthId_Last(int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator)
		throws NoSuchPayslipDetailsException {
		PayslipDetails payslipDetails = fetchByMonthId_Last(month, eid,
				orderByComparator);

		if (payslipDetails != null) {
			return payslipDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("month=");
		msg.append(month);

		msg.append(", eid=");
		msg.append(eid);

		msg.append("}");

		throw new NoSuchPayslipDetailsException(msg.toString());
	}

	/**
	 * Returns the last payslip details in the ordered set where month = &#63; and eid = &#63;.
	 *
	 * @param month the month
	 * @param eid the eid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payslip details, or <code>null</code> if a matching payslip details could not be found
	 */
	@Override
	public PayslipDetails fetchByMonthId_Last(int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator) {
		int count = countByMonthId(month, eid);

		if (count == 0) {
			return null;
		}

		List<PayslipDetails> list = findByMonthId(month, eid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the payslip detailses before and after the current payslip details in the ordered set where month = &#63; and eid = &#63;.
	 *
	 * @param ctcId the primary key of the current payslip details
	 * @param month the month
	 * @param eid the eid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payslip details
	 * @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	 */
	@Override
	public PayslipDetails[] findByMonthId_PrevAndNext(long ctcId, int month,
		String eid, OrderByComparator<PayslipDetails> orderByComparator)
		throws NoSuchPayslipDetailsException {
		eid = Objects.toString(eid, "");

		PayslipDetails payslipDetails = findByPrimaryKey(ctcId);

		Session session = null;

		try {
			session = openSession();

			PayslipDetails[] array = new PayslipDetailsImpl[3];

			array[0] = getByMonthId_PrevAndNext(session, payslipDetails, month,
					eid, orderByComparator, true);

			array[1] = payslipDetails;

			array[2] = getByMonthId_PrevAndNext(session, payslipDetails, month,
					eid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PayslipDetails getByMonthId_PrevAndNext(Session session,
		PayslipDetails payslipDetails, int month, String eid,
		OrderByComparator<PayslipDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PAYSLIPDETAILS_WHERE);

		query.append(_FINDER_COLUMN_MONTHID_MONTH_2);

		boolean bindEid = false;

		if (eid.isEmpty()) {
			query.append(_FINDER_COLUMN_MONTHID_EID_3);
		}
		else {
			bindEid = true;

			query.append(_FINDER_COLUMN_MONTHID_EID_2);
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
			query.append(PayslipDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(month);

		if (bindEid) {
			qPos.add(eid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payslipDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PayslipDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payslip detailses where month = &#63; and eid = &#63; from the database.
	 *
	 * @param month the month
	 * @param eid the eid
	 */
	@Override
	public void removeByMonthId(int month, String eid) {
		for (PayslipDetails payslipDetails : findByMonthId(month, eid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(payslipDetails);
		}
	}

	/**
	 * Returns the number of payslip detailses where month = &#63; and eid = &#63;.
	 *
	 * @param month the month
	 * @param eid the eid
	 * @return the number of matching payslip detailses
	 */
	@Override
	public int countByMonthId(int month, String eid) {
		eid = Objects.toString(eid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHID;

		Object[] finderArgs = new Object[] { month, eid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PAYSLIPDETAILS_WHERE);

			query.append(_FINDER_COLUMN_MONTHID_MONTH_2);

			boolean bindEid = false;

			if (eid.isEmpty()) {
				query.append(_FINDER_COLUMN_MONTHID_EID_3);
			}
			else {
				bindEid = true;

				query.append(_FINDER_COLUMN_MONTHID_EID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(month);

				if (bindEid) {
					qPos.add(eid);
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

	private static final String _FINDER_COLUMN_MONTHID_MONTH_2 = "payslipDetails.month = ? AND ";
	private static final String _FINDER_COLUMN_MONTHID_EID_1 = "payslipDetails.eid IS NULL";
	private static final String _FINDER_COLUMN_MONTHID_EID_2 = "payslipDetails.eid = ?";
	private static final String _FINDER_COLUMN_MONTHID_EID_3 = "(payslipDetails.eid IS NULL OR payslipDetails.eid = '')";

	public PayslipDetailsPersistenceImpl() {
		setModelClass(PayslipDetails.class);
	}

	/**
	 * Caches the payslip details in the entity cache if it is enabled.
	 *
	 * @param payslipDetails the payslip details
	 */
	@Override
	public void cacheResult(PayslipDetails payslipDetails) {
		entityCache.putResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsImpl.class, payslipDetails.getPrimaryKey(),
			payslipDetails);

		payslipDetails.resetOriginalValues();
	}

	/**
	 * Caches the payslip detailses in the entity cache if it is enabled.
	 *
	 * @param payslipDetailses the payslip detailses
	 */
	@Override
	public void cacheResult(List<PayslipDetails> payslipDetailses) {
		for (PayslipDetails payslipDetails : payslipDetailses) {
			if (entityCache.getResult(
						PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
						PayslipDetailsImpl.class, payslipDetails.getPrimaryKey()) == null) {
				cacheResult(payslipDetails);
			}
			else {
				payslipDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all payslip detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayslipDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payslip details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayslipDetails payslipDetails) {
		entityCache.removeResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsImpl.class, payslipDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PayslipDetails> payslipDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PayslipDetails payslipDetails : payslipDetailses) {
			entityCache.removeResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
				PayslipDetailsImpl.class, payslipDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new payslip details with the primary key. Does not add the payslip details to the database.
	 *
	 * @param ctcId the primary key for the new payslip details
	 * @return the new payslip details
	 */
	@Override
	public PayslipDetails create(long ctcId) {
		PayslipDetails payslipDetails = new PayslipDetailsImpl();

		payslipDetails.setNew(true);
		payslipDetails.setPrimaryKey(ctcId);

		return payslipDetails;
	}

	/**
	 * Removes the payslip details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctcId the primary key of the payslip details
	 * @return the payslip details that was removed
	 * @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	 */
	@Override
	public PayslipDetails remove(long ctcId)
		throws NoSuchPayslipDetailsException {
		return remove((Serializable)ctcId);
	}

	/**
	 * Removes the payslip details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payslip details
	 * @return the payslip details that was removed
	 * @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	 */
	@Override
	public PayslipDetails remove(Serializable primaryKey)
		throws NoSuchPayslipDetailsException {
		Session session = null;

		try {
			session = openSession();

			PayslipDetails payslipDetails = (PayslipDetails)session.get(PayslipDetailsImpl.class,
					primaryKey);

			if (payslipDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayslipDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payslipDetails);
		}
		catch (NoSuchPayslipDetailsException nsee) {
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
	protected PayslipDetails removeImpl(PayslipDetails payslipDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payslipDetails)) {
				payslipDetails = (PayslipDetails)session.get(PayslipDetailsImpl.class,
						payslipDetails.getPrimaryKeyObj());
			}

			if (payslipDetails != null) {
				session.delete(payslipDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payslipDetails != null) {
			clearCache(payslipDetails);
		}

		return payslipDetails;
	}

	@Override
	public PayslipDetails updateImpl(PayslipDetails payslipDetails) {
		boolean isNew = payslipDetails.isNew();

		if (!(payslipDetails instanceof PayslipDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payslipDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payslipDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payslipDetails proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayslipDetails implementation " +
				payslipDetails.getClass());
		}

		PayslipDetailsModelImpl payslipDetailsModelImpl = (PayslipDetailsModelImpl)payslipDetails;

		Session session = null;

		try {
			session = openSession();

			if (payslipDetails.isNew()) {
				session.save(payslipDetails);

				payslipDetails.setNew(false);
			}
			else {
				payslipDetails = (PayslipDetails)session.merge(payslipDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PayslipDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					payslipDetailsModelImpl.getMonth(),
					payslipDetailsModelImpl.getEid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((payslipDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payslipDetailsModelImpl.getOriginalMonth(),
						payslipDetailsModelImpl.getOriginalEid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHID,
					args);

				args = new Object[] {
						payslipDetailsModelImpl.getMonth(),
						payslipDetailsModelImpl.getEid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHID,
					args);
			}
		}

		entityCache.putResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
			PayslipDetailsImpl.class, payslipDetails.getPrimaryKey(),
			payslipDetails, false);

		payslipDetails.resetOriginalValues();

		return payslipDetails;
	}

	/**
	 * Returns the payslip details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the payslip details
	 * @return the payslip details
	 * @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	 */
	@Override
	public PayslipDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayslipDetailsException {
		PayslipDetails payslipDetails = fetchByPrimaryKey(primaryKey);

		if (payslipDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayslipDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payslipDetails;
	}

	/**
	 * Returns the payslip details with the primary key or throws a {@link NoSuchPayslipDetailsException} if it could not be found.
	 *
	 * @param ctcId the primary key of the payslip details
	 * @return the payslip details
	 * @throws NoSuchPayslipDetailsException if a payslip details with the primary key could not be found
	 */
	@Override
	public PayslipDetails findByPrimaryKey(long ctcId)
		throws NoSuchPayslipDetailsException {
		return findByPrimaryKey((Serializable)ctcId);
	}

	/**
	 * Returns the payslip details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payslip details
	 * @return the payslip details, or <code>null</code> if a payslip details with the primary key could not be found
	 */
	@Override
	public PayslipDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
				PayslipDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PayslipDetails payslipDetails = (PayslipDetails)serializable;

		if (payslipDetails == null) {
			Session session = null;

			try {
				session = openSession();

				payslipDetails = (PayslipDetails)session.get(PayslipDetailsImpl.class,
						primaryKey);

				if (payslipDetails != null) {
					cacheResult(payslipDetails);
				}
				else {
					entityCache.putResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
						PayslipDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
					PayslipDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payslipDetails;
	}

	/**
	 * Returns the payslip details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ctcId the primary key of the payslip details
	 * @return the payslip details, or <code>null</code> if a payslip details with the primary key could not be found
	 */
	@Override
	public PayslipDetails fetchByPrimaryKey(long ctcId) {
		return fetchByPrimaryKey((Serializable)ctcId);
	}

	@Override
	public Map<Serializable, PayslipDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PayslipDetails> map = new HashMap<Serializable, PayslipDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PayslipDetails payslipDetails = fetchByPrimaryKey(primaryKey);

			if (payslipDetails != null) {
				map.put(primaryKey, payslipDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
					PayslipDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PayslipDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PAYSLIPDETAILS_WHERE_PKS_IN);

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

			for (PayslipDetails payslipDetails : (List<PayslipDetails>)q.list()) {
				map.put(payslipDetails.getPrimaryKeyObj(), payslipDetails);

				cacheResult(payslipDetails);

				uncachedPrimaryKeys.remove(payslipDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PayslipDetailsModelImpl.ENTITY_CACHE_ENABLED,
					PayslipDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the payslip detailses.
	 *
	 * @return the payslip detailses
	 */
	@Override
	public List<PayslipDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payslip detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payslip detailses
	 * @param end the upper bound of the range of payslip detailses (not inclusive)
	 * @return the range of payslip detailses
	 */
	@Override
	public List<PayslipDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payslip detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payslip detailses
	 * @param end the upper bound of the range of payslip detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payslip detailses
	 */
	@Override
	public List<PayslipDetails> findAll(int start, int end,
		OrderByComparator<PayslipDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payslip detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayslipDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payslip detailses
	 * @param end the upper bound of the range of payslip detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of payslip detailses
	 */
	@Override
	public List<PayslipDetails> findAll(int start, int end,
		OrderByComparator<PayslipDetails> orderByComparator,
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

		List<PayslipDetails> list = null;

		if (retrieveFromCache) {
			list = (List<PayslipDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PAYSLIPDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYSLIPDETAILS;

				if (pagination) {
					sql = sql.concat(PayslipDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PayslipDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayslipDetails>)QueryUtil.list(q,
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
	 * Removes all the payslip detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayslipDetails payslipDetails : findAll()) {
			remove(payslipDetails);
		}
	}

	/**
	 * Returns the number of payslip detailses.
	 *
	 * @return the number of payslip detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAYSLIPDETAILS);

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
		return PayslipDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payslip details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PayslipDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PAYSLIPDETAILS = "SELECT payslipDetails FROM PayslipDetails payslipDetails";
	private static final String _SQL_SELECT_PAYSLIPDETAILS_WHERE_PKS_IN = "SELECT payslipDetails FROM PayslipDetails payslipDetails WHERE ctcId IN (";
	private static final String _SQL_SELECT_PAYSLIPDETAILS_WHERE = "SELECT payslipDetails FROM PayslipDetails payslipDetails WHERE ";
	private static final String _SQL_COUNT_PAYSLIPDETAILS = "SELECT COUNT(payslipDetails) FROM PayslipDetails payslipDetails";
	private static final String _SQL_COUNT_PAYSLIPDETAILS_WHERE = "SELECT COUNT(payslipDetails) FROM PayslipDetails payslipDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payslipDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PayslipDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PayslipDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PayslipDetailsPersistenceImpl.class);
}