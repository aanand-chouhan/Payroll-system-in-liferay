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

import com.vy.payroll.exception.NoSuchCtcDetailException;
import com.vy.payroll.model.CtcDetail;

/**
 * The persistence interface for the ctc detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vy.payroll.service.persistence.impl.CtcDetailPersistenceImpl
 * @see CtcDetailUtil
 * @generated
 */
@ProviderType
public interface CtcDetailPersistence extends BasePersistence<CtcDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CtcDetailUtil} to access the ctc detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ctc detail in the entity cache if it is enabled.
	*
	* @param ctcDetail the ctc detail
	*/
	public void cacheResult(CtcDetail ctcDetail);

	/**
	* Caches the ctc details in the entity cache if it is enabled.
	*
	* @param ctcDetails the ctc details
	*/
	public void cacheResult(java.util.List<CtcDetail> ctcDetails);

	/**
	* Creates a new ctc detail with the primary key. Does not add the ctc detail to the database.
	*
	* @param ctc the primary key for the new ctc detail
	* @return the new ctc detail
	*/
	public CtcDetail create(int ctc);

	/**
	* Removes the ctc detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ctc the primary key of the ctc detail
	* @return the ctc detail that was removed
	* @throws NoSuchCtcDetailException if a ctc detail with the primary key could not be found
	*/
	public CtcDetail remove(int ctc) throws NoSuchCtcDetailException;

	public CtcDetail updateImpl(CtcDetail ctcDetail);

	/**
	* Returns the ctc detail with the primary key or throws a {@link NoSuchCtcDetailException} if it could not be found.
	*
	* @param ctc the primary key of the ctc detail
	* @return the ctc detail
	* @throws NoSuchCtcDetailException if a ctc detail with the primary key could not be found
	*/
	public CtcDetail findByPrimaryKey(int ctc) throws NoSuchCtcDetailException;

	/**
	* Returns the ctc detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ctc the primary key of the ctc detail
	* @return the ctc detail, or <code>null</code> if a ctc detail with the primary key could not be found
	*/
	public CtcDetail fetchByPrimaryKey(int ctc);

	@Override
	public java.util.Map<java.io.Serializable, CtcDetail> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ctc details.
	*
	* @return the ctc details
	*/
	public java.util.List<CtcDetail> findAll();

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
	public java.util.List<CtcDetail> findAll(int start, int end);

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
	public java.util.List<CtcDetail> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CtcDetail> orderByComparator);

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
	public java.util.List<CtcDetail> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CtcDetail> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ctc details from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ctc details.
	*
	* @return the number of ctc details
	*/
	public int countAll();
}