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

import com.vy.payroll.exception.NoSuchAdmin_detailsException;
import com.vy.payroll.model.Admin_details;
import com.vy.payroll.model.impl.Admin_detailsImpl;
import com.vy.payroll.model.impl.Admin_detailsModelImpl;
import com.vy.payroll.service.persistence.Admin_detailsPersistence;

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
 * The persistence implementation for the admin_details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Admin_detailsPersistence
 * @see com.vy.payroll.service.persistence.Admin_detailsUtil
 * @generated
 */
@ProviderType
public class Admin_detailsPersistenceImpl extends BasePersistenceImpl<Admin_details>
	implements Admin_detailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Admin_detailsUtil} to access the admin_details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Admin_detailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsModelImpl.FINDER_CACHE_ENABLED,
			Admin_detailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsModelImpl.FINDER_CACHE_ENABLED,
			Admin_detailsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNAMEID = new FinderPath(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsModelImpl.FINDER_CACHE_ENABLED,
			Admin_detailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUNameId",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNAMEID =
		new FinderPath(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsModelImpl.FINDER_CACHE_ENABLED,
			Admin_detailsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUNameId",
			new String[] { String.class.getName(), String.class.getName() },
			Admin_detailsModelImpl.USERNAME_COLUMN_BITMASK |
			Admin_detailsModelImpl.PASSWORD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNAMEID = new FinderPath(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUNameId",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the admin_detailses where userName = &#63; and password = &#63;.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the matching admin_detailses
	 */
	@Override
	public List<Admin_details> findByUNameId(String userName, String password) {
		return findByUNameId(userName, password, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the admin_detailses where userName = &#63; and password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param start the lower bound of the range of admin_detailses
	 * @param end the upper bound of the range of admin_detailses (not inclusive)
	 * @return the range of matching admin_detailses
	 */
	@Override
	public List<Admin_details> findByUNameId(String userName, String password,
		int start, int end) {
		return findByUNameId(userName, password, start, end, null);
	}

	/**
	 * Returns an ordered range of all the admin_detailses where userName = &#63; and password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param start the lower bound of the range of admin_detailses
	 * @param end the upper bound of the range of admin_detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching admin_detailses
	 */
	@Override
	public List<Admin_details> findByUNameId(String userName, String password,
		int start, int end, OrderByComparator<Admin_details> orderByComparator) {
		return findByUNameId(userName, password, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the admin_detailses where userName = &#63; and password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param start the lower bound of the range of admin_detailses
	 * @param end the upper bound of the range of admin_detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching admin_detailses
	 */
	@Override
	public List<Admin_details> findByUNameId(String userName, String password,
		int start, int end, OrderByComparator<Admin_details> orderByComparator,
		boolean retrieveFromCache) {
		userName = Objects.toString(userName, "");
		password = Objects.toString(password, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNAMEID;
			finderArgs = new Object[] { userName, password };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UNAMEID;
			finderArgs = new Object[] {
					userName, password,
					
					start, end, orderByComparator
				};
		}

		List<Admin_details> list = null;

		if (retrieveFromCache) {
			list = (List<Admin_details>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Admin_details admin_details : list) {
					if (!userName.equals(admin_details.getUserName()) ||
							!password.equals(admin_details.getPassword())) {
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

			query.append(_SQL_SELECT_ADMIN_DETAILS_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				query.append(_FINDER_COLUMN_UNAMEID_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_UNAMEID_USERNAME_2);
			}

			boolean bindPassword = false;

			if (password.isEmpty()) {
				query.append(_FINDER_COLUMN_UNAMEID_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_UNAMEID_PASSWORD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Admin_detailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

				if (bindPassword) {
					qPos.add(password);
				}

				if (!pagination) {
					list = (List<Admin_details>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Admin_details>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first admin_details in the ordered set where userName = &#63; and password = &#63;.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching admin_details
	 * @throws NoSuchAdmin_detailsException if a matching admin_details could not be found
	 */
	@Override
	public Admin_details findByUNameId_First(String userName, String password,
		OrderByComparator<Admin_details> orderByComparator)
		throws NoSuchAdmin_detailsException {
		Admin_details admin_details = fetchByUNameId_First(userName, password,
				orderByComparator);

		if (admin_details != null) {
			return admin_details;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append(", password=");
		msg.append(password);

		msg.append("}");

		throw new NoSuchAdmin_detailsException(msg.toString());
	}

	/**
	 * Returns the first admin_details in the ordered set where userName = &#63; and password = &#63;.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching admin_details, or <code>null</code> if a matching admin_details could not be found
	 */
	@Override
	public Admin_details fetchByUNameId_First(String userName, String password,
		OrderByComparator<Admin_details> orderByComparator) {
		List<Admin_details> list = findByUNameId(userName, password, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last admin_details in the ordered set where userName = &#63; and password = &#63;.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching admin_details
	 * @throws NoSuchAdmin_detailsException if a matching admin_details could not be found
	 */
	@Override
	public Admin_details findByUNameId_Last(String userName, String password,
		OrderByComparator<Admin_details> orderByComparator)
		throws NoSuchAdmin_detailsException {
		Admin_details admin_details = fetchByUNameId_Last(userName, password,
				orderByComparator);

		if (admin_details != null) {
			return admin_details;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append(", password=");
		msg.append(password);

		msg.append("}");

		throw new NoSuchAdmin_detailsException(msg.toString());
	}

	/**
	 * Returns the last admin_details in the ordered set where userName = &#63; and password = &#63;.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching admin_details, or <code>null</code> if a matching admin_details could not be found
	 */
	@Override
	public Admin_details fetchByUNameId_Last(String userName, String password,
		OrderByComparator<Admin_details> orderByComparator) {
		int count = countByUNameId(userName, password);

		if (count == 0) {
			return null;
		}

		List<Admin_details> list = findByUNameId(userName, password, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the admin_detailses before and after the current admin_details in the ordered set where userName = &#63; and password = &#63;.
	 *
	 * @param admin_id the primary key of the current admin_details
	 * @param userName the user name
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next admin_details
	 * @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	 */
	@Override
	public Admin_details[] findByUNameId_PrevAndNext(int admin_id,
		String userName, String password,
		OrderByComparator<Admin_details> orderByComparator)
		throws NoSuchAdmin_detailsException {
		userName = Objects.toString(userName, "");
		password = Objects.toString(password, "");

		Admin_details admin_details = findByPrimaryKey(admin_id);

		Session session = null;

		try {
			session = openSession();

			Admin_details[] array = new Admin_detailsImpl[3];

			array[0] = getByUNameId_PrevAndNext(session, admin_details,
					userName, password, orderByComparator, true);

			array[1] = admin_details;

			array[2] = getByUNameId_PrevAndNext(session, admin_details,
					userName, password, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Admin_details getByUNameId_PrevAndNext(Session session,
		Admin_details admin_details, String userName, String password,
		OrderByComparator<Admin_details> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ADMIN_DETAILS_WHERE);

		boolean bindUserName = false;

		if (userName.isEmpty()) {
			query.append(_FINDER_COLUMN_UNAMEID_USERNAME_3);
		}
		else {
			bindUserName = true;

			query.append(_FINDER_COLUMN_UNAMEID_USERNAME_2);
		}

		boolean bindPassword = false;

		if (password.isEmpty()) {
			query.append(_FINDER_COLUMN_UNAMEID_PASSWORD_3);
		}
		else {
			bindPassword = true;

			query.append(_FINDER_COLUMN_UNAMEID_PASSWORD_2);
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
			query.append(Admin_detailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserName) {
			qPos.add(userName);
		}

		if (bindPassword) {
			qPos.add(password);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(admin_details);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Admin_details> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the admin_detailses where userName = &#63; and password = &#63; from the database.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	@Override
	public void removeByUNameId(String userName, String password) {
		for (Admin_details admin_details : findByUNameId(userName, password,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(admin_details);
		}
	}

	/**
	 * Returns the number of admin_detailses where userName = &#63; and password = &#63;.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the number of matching admin_detailses
	 */
	@Override
	public int countByUNameId(String userName, String password) {
		userName = Objects.toString(userName, "");
		password = Objects.toString(password, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UNAMEID;

		Object[] finderArgs = new Object[] { userName, password };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADMIN_DETAILS_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				query.append(_FINDER_COLUMN_UNAMEID_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_UNAMEID_USERNAME_2);
			}

			boolean bindPassword = false;

			if (password.isEmpty()) {
				query.append(_FINDER_COLUMN_UNAMEID_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_UNAMEID_PASSWORD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
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

	private static final String _FINDER_COLUMN_UNAMEID_USERNAME_1 = "admin_details.userName IS NULL AND ";
	private static final String _FINDER_COLUMN_UNAMEID_USERNAME_2 = "admin_details.userName = ? AND ";
	private static final String _FINDER_COLUMN_UNAMEID_USERNAME_3 = "(admin_details.userName IS NULL OR admin_details.userName = '') AND ";
	private static final String _FINDER_COLUMN_UNAMEID_PASSWORD_1 = "admin_details.password IS NULL";
	private static final String _FINDER_COLUMN_UNAMEID_PASSWORD_2 = "admin_details.password = ?";
	private static final String _FINDER_COLUMN_UNAMEID_PASSWORD_3 = "(admin_details.password IS NULL OR admin_details.password = '')";

	public Admin_detailsPersistenceImpl() {
		setModelClass(Admin_details.class);

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
	 * Caches the admin_details in the entity cache if it is enabled.
	 *
	 * @param admin_details the admin_details
	 */
	@Override
	public void cacheResult(Admin_details admin_details) {
		entityCache.putResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsImpl.class, admin_details.getPrimaryKey(),
			admin_details);

		admin_details.resetOriginalValues();
	}

	/**
	 * Caches the admin_detailses in the entity cache if it is enabled.
	 *
	 * @param admin_detailses the admin_detailses
	 */
	@Override
	public void cacheResult(List<Admin_details> admin_detailses) {
		for (Admin_details admin_details : admin_detailses) {
			if (entityCache.getResult(
						Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
						Admin_detailsImpl.class, admin_details.getPrimaryKey()) == null) {
				cacheResult(admin_details);
			}
			else {
				admin_details.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all admin_detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Admin_detailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the admin_details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Admin_details admin_details) {
		entityCache.removeResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsImpl.class, admin_details.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Admin_details> admin_detailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Admin_details admin_details : admin_detailses) {
			entityCache.removeResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
				Admin_detailsImpl.class, admin_details.getPrimaryKey());
		}
	}

	/**
	 * Creates a new admin_details with the primary key. Does not add the admin_details to the database.
	 *
	 * @param admin_id the primary key for the new admin_details
	 * @return the new admin_details
	 */
	@Override
	public Admin_details create(int admin_id) {
		Admin_details admin_details = new Admin_detailsImpl();

		admin_details.setNew(true);
		admin_details.setPrimaryKey(admin_id);

		return admin_details;
	}

	/**
	 * Removes the admin_details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param admin_id the primary key of the admin_details
	 * @return the admin_details that was removed
	 * @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	 */
	@Override
	public Admin_details remove(int admin_id)
		throws NoSuchAdmin_detailsException {
		return remove((Serializable)admin_id);
	}

	/**
	 * Removes the admin_details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the admin_details
	 * @return the admin_details that was removed
	 * @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	 */
	@Override
	public Admin_details remove(Serializable primaryKey)
		throws NoSuchAdmin_detailsException {
		Session session = null;

		try {
			session = openSession();

			Admin_details admin_details = (Admin_details)session.get(Admin_detailsImpl.class,
					primaryKey);

			if (admin_details == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdmin_detailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(admin_details);
		}
		catch (NoSuchAdmin_detailsException nsee) {
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
	protected Admin_details removeImpl(Admin_details admin_details) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(admin_details)) {
				admin_details = (Admin_details)session.get(Admin_detailsImpl.class,
						admin_details.getPrimaryKeyObj());
			}

			if (admin_details != null) {
				session.delete(admin_details);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (admin_details != null) {
			clearCache(admin_details);
		}

		return admin_details;
	}

	@Override
	public Admin_details updateImpl(Admin_details admin_details) {
		boolean isNew = admin_details.isNew();

		if (!(admin_details instanceof Admin_detailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(admin_details.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(admin_details);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in admin_details proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Admin_details implementation " +
				admin_details.getClass());
		}

		Admin_detailsModelImpl admin_detailsModelImpl = (Admin_detailsModelImpl)admin_details;

		Session session = null;

		try {
			session = openSession();

			if (admin_details.isNew()) {
				session.save(admin_details);

				admin_details.setNew(false);
			}
			else {
				admin_details = (Admin_details)session.merge(admin_details);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Admin_detailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					admin_detailsModelImpl.getUserName(),
					admin_detailsModelImpl.getPassword()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UNAMEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNAMEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((admin_detailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNAMEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						admin_detailsModelImpl.getOriginalUserName(),
						admin_detailsModelImpl.getOriginalPassword()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UNAMEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNAMEID,
					args);

				args = new Object[] {
						admin_detailsModelImpl.getUserName(),
						admin_detailsModelImpl.getPassword()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UNAMEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNAMEID,
					args);
			}
		}

		entityCache.putResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
			Admin_detailsImpl.class, admin_details.getPrimaryKey(),
			admin_details, false);

		admin_details.resetOriginalValues();

		return admin_details;
	}

	/**
	 * Returns the admin_details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin_details
	 * @return the admin_details
	 * @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	 */
	@Override
	public Admin_details findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdmin_detailsException {
		Admin_details admin_details = fetchByPrimaryKey(primaryKey);

		if (admin_details == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdmin_detailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return admin_details;
	}

	/**
	 * Returns the admin_details with the primary key or throws a {@link NoSuchAdmin_detailsException} if it could not be found.
	 *
	 * @param admin_id the primary key of the admin_details
	 * @return the admin_details
	 * @throws NoSuchAdmin_detailsException if a admin_details with the primary key could not be found
	 */
	@Override
	public Admin_details findByPrimaryKey(int admin_id)
		throws NoSuchAdmin_detailsException {
		return findByPrimaryKey((Serializable)admin_id);
	}

	/**
	 * Returns the admin_details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin_details
	 * @return the admin_details, or <code>null</code> if a admin_details with the primary key could not be found
	 */
	@Override
	public Admin_details fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
				Admin_detailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Admin_details admin_details = (Admin_details)serializable;

		if (admin_details == null) {
			Session session = null;

			try {
				session = openSession();

				admin_details = (Admin_details)session.get(Admin_detailsImpl.class,
						primaryKey);

				if (admin_details != null) {
					cacheResult(admin_details);
				}
				else {
					entityCache.putResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
						Admin_detailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
					Admin_detailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return admin_details;
	}

	/**
	 * Returns the admin_details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param admin_id the primary key of the admin_details
	 * @return the admin_details, or <code>null</code> if a admin_details with the primary key could not be found
	 */
	@Override
	public Admin_details fetchByPrimaryKey(int admin_id) {
		return fetchByPrimaryKey((Serializable)admin_id);
	}

	@Override
	public Map<Serializable, Admin_details> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Admin_details> map = new HashMap<Serializable, Admin_details>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Admin_details admin_details = fetchByPrimaryKey(primaryKey);

			if (admin_details != null) {
				map.put(primaryKey, admin_details);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
					Admin_detailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Admin_details)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ADMIN_DETAILS_WHERE_PKS_IN);

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

			for (Admin_details admin_details : (List<Admin_details>)q.list()) {
				map.put(admin_details.getPrimaryKeyObj(), admin_details);

				cacheResult(admin_details);

				uncachedPrimaryKeys.remove(admin_details.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Admin_detailsModelImpl.ENTITY_CACHE_ENABLED,
					Admin_detailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the admin_detailses.
	 *
	 * @return the admin_detailses
	 */
	@Override
	public List<Admin_details> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the admin_detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin_detailses
	 * @param end the upper bound of the range of admin_detailses (not inclusive)
	 * @return the range of admin_detailses
	 */
	@Override
	public List<Admin_details> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the admin_detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin_detailses
	 * @param end the upper bound of the range of admin_detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of admin_detailses
	 */
	@Override
	public List<Admin_details> findAll(int start, int end,
		OrderByComparator<Admin_details> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the admin_detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Admin_detailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin_detailses
	 * @param end the upper bound of the range of admin_detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of admin_detailses
	 */
	@Override
	public List<Admin_details> findAll(int start, int end,
		OrderByComparator<Admin_details> orderByComparator,
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

		List<Admin_details> list = null;

		if (retrieveFromCache) {
			list = (List<Admin_details>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ADMIN_DETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADMIN_DETAILS;

				if (pagination) {
					sql = sql.concat(Admin_detailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Admin_details>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Admin_details>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the admin_detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Admin_details admin_details : findAll()) {
			remove(admin_details);
		}
	}

	/**
	 * Returns the number of admin_detailses.
	 *
	 * @return the number of admin_detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADMIN_DETAILS);

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
		return Admin_detailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the admin_details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Admin_detailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ADMIN_DETAILS = "SELECT admin_details FROM Admin_details admin_details";
	private static final String _SQL_SELECT_ADMIN_DETAILS_WHERE_PKS_IN = "SELECT admin_details FROM Admin_details admin_details WHERE admin_id IN (";
	private static final String _SQL_SELECT_ADMIN_DETAILS_WHERE = "SELECT admin_details FROM Admin_details admin_details WHERE ";
	private static final String _SQL_COUNT_ADMIN_DETAILS = "SELECT COUNT(admin_details) FROM Admin_details admin_details";
	private static final String _SQL_COUNT_ADMIN_DETAILS_WHERE = "SELECT COUNT(admin_details) FROM Admin_details admin_details WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "admin_details.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Admin_details exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Admin_details exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Admin_detailsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"password"
			});
}