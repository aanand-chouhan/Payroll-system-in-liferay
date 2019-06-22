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

import com.vy.payroll.exception.NoSuchEmployeeDetailsException;
import com.vy.payroll.model.EmployeeDetails;
import com.vy.payroll.model.impl.EmployeeDetailsImpl;
import com.vy.payroll.model.impl.EmployeeDetailsModelImpl;
import com.vy.payroll.service.persistence.EmployeeDetailsPersistence;

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
 * The persistence implementation for the employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsPersistence
 * @see com.vy.payroll.service.persistence.EmployeeDetailsUtil
 * @generated
 */
@ProviderType
public class EmployeeDetailsPersistenceImpl extends BasePersistenceImpl<EmployeeDetails>
	implements EmployeeDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeDetailsUtil} to access the employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILPWD = new FinderPath(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmailPwd",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILPWD =
		new FinderPath(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmailPwd",
			new String[] { String.class.getName(), String.class.getName() },
			EmployeeDetailsModelImpl.EMAIL_COLUMN_BITMASK |
			EmployeeDetailsModelImpl.PASSWORD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILPWD = new FinderPath(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailPwd",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the employee detailses where email = &#63; and password = &#63;.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByEmailPwd(String email, String password) {
		return findByEmailPwd(email, password, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses where email = &#63; and password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param password the password
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByEmailPwd(String email, String password,
		int start, int end) {
		return findByEmailPwd(email, password, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses where email = &#63; and password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param password the password
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByEmailPwd(String email, String password,
		int start, int end, OrderByComparator<EmployeeDetails> orderByComparator) {
		return findByEmailPwd(email, password, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the employee detailses where email = &#63; and password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param password the password
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByEmailPwd(String email, String password,
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean retrieveFromCache) {
		email = Objects.toString(email, "");
		password = Objects.toString(password, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILPWD;
			finderArgs = new Object[] { email, password };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILPWD;
			finderArgs = new Object[] {
					email, password,
					
					start, end, orderByComparator
				};
		}

		List<EmployeeDetails> list = null;

		if (retrieveFromCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetails employeeDetails : list) {
					if (!email.equals(employeeDetails.getEmail()) ||
							!password.equals(employeeDetails.getPassword())) {
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

			query.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAILPWD_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAILPWD_EMAIL_2);
			}

			boolean bindPassword = false;

			if (password.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAILPWD_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_EMAILPWD_PASSWORD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				if (bindPassword) {
					qPos.add(password);
				}

				if (!pagination) {
					list = (List<EmployeeDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmployeeDetails>)QueryUtil.list(q,
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
	 * Returns the first employee details in the ordered set where email = &#63; and password = &#63;.
	 *
	 * @param email the email
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByEmailPwd_First(String email, String password,
		OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {
		EmployeeDetails employeeDetails = fetchByEmailPwd_First(email,
				password, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append(", password=");
		msg.append(password);

		msg.append("}");

		throw new NoSuchEmployeeDetailsException(msg.toString());
	}

	/**
	 * Returns the first employee details in the ordered set where email = &#63; and password = &#63;.
	 *
	 * @param email the email
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByEmailPwd_First(String email, String password,
		OrderByComparator<EmployeeDetails> orderByComparator) {
		List<EmployeeDetails> list = findByEmailPwd(email, password, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee details in the ordered set where email = &#63; and password = &#63;.
	 *
	 * @param email the email
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByEmailPwd_Last(String email, String password,
		OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {
		EmployeeDetails employeeDetails = fetchByEmailPwd_Last(email, password,
				orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append(", password=");
		msg.append(password);

		msg.append("}");

		throw new NoSuchEmployeeDetailsException(msg.toString());
	}

	/**
	 * Returns the last employee details in the ordered set where email = &#63; and password = &#63;.
	 *
	 * @param email the email
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByEmailPwd_Last(String email, String password,
		OrderByComparator<EmployeeDetails> orderByComparator) {
		int count = countByEmailPwd(email, password);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetails> list = findByEmailPwd(email, password, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where email = &#63; and password = &#63;.
	 *
	 * @param eno the primary key of the current employee details
	 * @param email the email
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails[] findByEmailPwd_PrevAndNext(long eno, String email,
		String password, OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {
		email = Objects.toString(email, "");
		password = Objects.toString(password, "");

		EmployeeDetails employeeDetails = findByPrimaryKey(eno);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails[] array = new EmployeeDetailsImpl[3];

			array[0] = getByEmailPwd_PrevAndNext(session, employeeDetails,
					email, password, orderByComparator, true);

			array[1] = employeeDetails;

			array[2] = getByEmailPwd_PrevAndNext(session, employeeDetails,
					email, password, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDetails getByEmailPwd_PrevAndNext(Session session,
		EmployeeDetails employeeDetails, String email, String password,
		OrderByComparator<EmployeeDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			query.append(_FINDER_COLUMN_EMAILPWD_EMAIL_3);
		}
		else {
			bindEmail = true;

			query.append(_FINDER_COLUMN_EMAILPWD_EMAIL_2);
		}

		boolean bindPassword = false;

		if (password.isEmpty()) {
			query.append(_FINDER_COLUMN_EMAILPWD_PASSWORD_3);
		}
		else {
			bindPassword = true;

			query.append(_FINDER_COLUMN_EMAILPWD_PASSWORD_2);
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
			query.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmail) {
			qPos.add(email);
		}

		if (bindPassword) {
			qPos.add(password);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employeeDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmployeeDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee detailses where email = &#63; and password = &#63; from the database.
	 *
	 * @param email the email
	 * @param password the password
	 */
	@Override
	public void removeByEmailPwd(String email, String password) {
		for (EmployeeDetails employeeDetails : findByEmailPwd(email, password,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses where email = &#63; and password = &#63;.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByEmailPwd(String email, String password) {
		email = Objects.toString(email, "");
		password = Objects.toString(password, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILPWD;

		Object[] finderArgs = new Object[] { email, password };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAILPWD_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAILPWD_EMAIL_2);
			}

			boolean bindPassword = false;

			if (password.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAILPWD_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_EMAILPWD_PASSWORD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				if (bindPassword) {
					qPos.add(password);
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

	private static final String _FINDER_COLUMN_EMAILPWD_EMAIL_1 = "employeeDetails.email IS NULL AND ";
	private static final String _FINDER_COLUMN_EMAILPWD_EMAIL_2 = "employeeDetails.email = ? AND ";
	private static final String _FINDER_COLUMN_EMAILPWD_EMAIL_3 = "(employeeDetails.email IS NULL OR employeeDetails.email = '') AND ";
	private static final String _FINDER_COLUMN_EMAILPWD_PASSWORD_1 = "employeeDetails.password IS NULL";
	private static final String _FINDER_COLUMN_EMAILPWD_PASSWORD_2 = "employeeDetails.password = ?";
	private static final String _FINDER_COLUMN_EMAILPWD_PASSWORD_3 = "(employeeDetails.password IS NULL OR employeeDetails.password = '')";

	public EmployeeDetailsPersistenceImpl() {
		setModelClass(EmployeeDetails.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("password", "password_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	@Override
	public void cacheResult(EmployeeDetails employeeDetails) {
		entityCache.putResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsImpl.class, employeeDetails.getPrimaryKey(),
			employeeDetails);

		employeeDetails.resetOriginalValues();
	}

	/**
	 * Caches the employee detailses in the entity cache if it is enabled.
	 *
	 * @param employeeDetailses the employee detailses
	 */
	@Override
	public void cacheResult(List<EmployeeDetails> employeeDetailses) {
		for (EmployeeDetails employeeDetails : employeeDetailses) {
			if (entityCache.getResult(
						EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeDetailsImpl.class,
						employeeDetails.getPrimaryKey()) == null) {
				cacheResult(employeeDetails);
			}
			else {
				employeeDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employee detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDetails employeeDetails) {
		entityCache.removeResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsImpl.class, employeeDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmployeeDetails> employeeDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmployeeDetails employeeDetails : employeeDetailses) {
			entityCache.removeResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeDetailsImpl.class, employeeDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param eno the primary key for the new employee details
	 * @return the new employee details
	 */
	@Override
	public EmployeeDetails create(long eno) {
		EmployeeDetails employeeDetails = new EmployeeDetailsImpl();

		employeeDetails.setNew(true);
		employeeDetails.setPrimaryKey(eno);

		return employeeDetails;
	}

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eno the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails remove(long eno)
		throws NoSuchEmployeeDetailsException {
		return remove((Serializable)eno);
	}

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails remove(Serializable primaryKey)
		throws NoSuchEmployeeDetailsException {
		Session session = null;

		try {
			session = openSession();

			EmployeeDetails employeeDetails = (EmployeeDetails)session.get(EmployeeDetailsImpl.class,
					primaryKey);

			if (employeeDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employeeDetails);
		}
		catch (NoSuchEmployeeDetailsException nsee) {
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
	protected EmployeeDetails removeImpl(EmployeeDetails employeeDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDetails)) {
				employeeDetails = (EmployeeDetails)session.get(EmployeeDetailsImpl.class,
						employeeDetails.getPrimaryKeyObj());
			}

			if (employeeDetails != null) {
				session.delete(employeeDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employeeDetails != null) {
			clearCache(employeeDetails);
		}

		return employeeDetails;
	}

	@Override
	public EmployeeDetails updateImpl(EmployeeDetails employeeDetails) {
		boolean isNew = employeeDetails.isNew();

		if (!(employeeDetails instanceof EmployeeDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(employeeDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDetails proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDetails implementation " +
				employeeDetails.getClass());
		}

		EmployeeDetailsModelImpl employeeDetailsModelImpl = (EmployeeDetailsModelImpl)employeeDetails;

		Session session = null;

		try {
			session = openSession();

			if (employeeDetails.isNew()) {
				session.save(employeeDetails);

				employeeDetails.setNew(false);
			}
			else {
				session.evict(employeeDetails);
				session.saveOrUpdate(employeeDetails);
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

		if (!EmployeeDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					employeeDetailsModelImpl.getEmail(),
					employeeDetailsModelImpl.getPassword()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILPWD, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILPWD,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((employeeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILPWD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeDetailsModelImpl.getOriginalEmail(),
						employeeDetailsModelImpl.getOriginalPassword()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILPWD, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILPWD,
					args);

				args = new Object[] {
						employeeDetailsModelImpl.getEmail(),
						employeeDetailsModelImpl.getPassword()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILPWD, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILPWD,
					args);
			}
		}

		entityCache.putResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailsImpl.class, employeeDetails.getPrimaryKey(),
			employeeDetails, false);

		employeeDetails.resetOriginalValues();

		return employeeDetails;
	}

	/**
	 * Returns the employee details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDetailsException {
		EmployeeDetails employeeDetails = fetchByPrimaryKey(primaryKey);

		if (employeeDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employeeDetails;
	}

	/**
	 * Returns the employee details with the primary key or throws a {@link NoSuchEmployeeDetailsException} if it could not be found.
	 *
	 * @param eno the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails findByPrimaryKey(long eno)
		throws NoSuchEmployeeDetailsException {
		return findByPrimaryKey((Serializable)eno);
	}

	/**
	 * Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee details
	 * @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EmployeeDetails employeeDetails = (EmployeeDetails)serializable;

		if (employeeDetails == null) {
			Session session = null;

			try {
				session = openSession();

				employeeDetails = (EmployeeDetails)session.get(EmployeeDetailsImpl.class,
						primaryKey);

				if (employeeDetails != null) {
					cacheResult(employeeDetails);
				}
				else {
					entityCache.putResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employeeDetails;
	}

	/**
	 * Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eno the primary key of the employee details
	 * @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails fetchByPrimaryKey(long eno) {
		return fetchByPrimaryKey((Serializable)eno);
	}

	@Override
	public Map<Serializable, EmployeeDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EmployeeDetails> map = new HashMap<Serializable, EmployeeDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EmployeeDetails employeeDetails = fetchByPrimaryKey(primaryKey);

			if (employeeDetails != null) {
				map.put(primaryKey, employeeDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EmployeeDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE_PKS_IN);

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

			for (EmployeeDetails employeeDetails : (List<EmployeeDetails>)q.list()) {
				map.put(employeeDetails.getPrimaryKeyObj(), employeeDetails);

				cacheResult(employeeDetails);

				uncachedPrimaryKeys.remove(employeeDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmployeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the employee detailses.
	 *
	 * @return the employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
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

		List<EmployeeDetails> list = null;

		if (retrieveFromCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMPLOYEEDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDETAILS;

				if (pagination) {
					sql = sql.concat(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmployeeDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmployeeDetails>)QueryUtil.list(q,
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
	 * Removes all the employee detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDetails employeeDetails : findAll()) {
			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEEDETAILS);

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
		return EmployeeDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmployeeDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMPLOYEEDETAILS = "SELECT employeeDetails FROM EmployeeDetails employeeDetails";
	private static final String _SQL_SELECT_EMPLOYEEDETAILS_WHERE_PKS_IN = "SELECT employeeDetails FROM EmployeeDetails employeeDetails WHERE eno IN (";
	private static final String _SQL_SELECT_EMPLOYEEDETAILS_WHERE = "SELECT employeeDetails FROM EmployeeDetails employeeDetails WHERE ";
	private static final String _SQL_COUNT_EMPLOYEEDETAILS = "SELECT COUNT(employeeDetails) FROM EmployeeDetails employeeDetails";
	private static final String _SQL_COUNT_EMPLOYEEDETAILS_WHERE = "SELECT COUNT(employeeDetails) FROM EmployeeDetails employeeDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmployeeDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmployeeDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EmployeeDetailsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"password"
			});
}