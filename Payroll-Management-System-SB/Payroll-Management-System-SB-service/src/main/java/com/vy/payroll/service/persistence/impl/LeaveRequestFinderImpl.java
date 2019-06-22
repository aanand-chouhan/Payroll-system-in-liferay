package com.vy.payroll.service.persistence.impl;

import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.vy.payroll.model.impl.AdvanceSalaryRecordImpl;
import com.vy.payroll.model.impl.LeaveRequestImpl;
import com.vy.payroll.service.persistence.LeaveRequestFinder;

public class LeaveRequestFinderImpl extends LeaveRequestFinderBaseImpl implements LeaveRequestFinder {
	private static final String UPDATEISCHECKED="com.vy.payroll.service.persistence.LeaveRequestFinder.updateIsViewed"; 
	private static final String ISREQUESTVIEWED="com.vy.payroll.service.persistence.LeaveRequestFinderr.IsRequestViewed";
	public int updateRequestIsChecked() {
		
		String is_check="yes";
		String NotCheck="no";
		Session session=null;
		  try{
		   //open ORM Session
		     session=openSession();
		    //get sql query return in default.xml
		   String sql=CustomSQLUtil.get(getClass(), UPDATEISCHECKED);
		   System.out.println("1 step "+sql);
		   SQLQuery sqlQuery=session.createSQLQuery(sql);
		   System.out.println("2 step");
		   sqlQuery.setCacheable(false);
		   //Add entity to be searched
		   System.out.println("3 step");
		    sqlQuery.addEntity("LeaveRequest",LeaveRequestImpl.class);
		    //Replace positional parameters in the query
		    QueryPos queryPos=QueryPos.getInstance(sqlQuery);
		    System.out.println("4 step");
		   queryPos.add(is_check);
		   queryPos.add(NotCheck);
		   System.out.println("5 step ");
		  //Execute query and return result
		   return sqlQuery.executeUpdate();
		  }catch(Exception e){
		   e.printStackTrace();
		  }finally {
		   closeSession(session);
		  }
		  
		  return 5;
		 }
	
	public int isRequestViewed(String isRequestChecked) {
		Session session=null;
		  try{
		   //open ORM Session
		     session=openSession();
		    //get sql query return in default.xml
		   String sql=CustomSQLUtil.get(getClass(), ISREQUESTVIEWED);
		   System.out.println("1 step "+sql);
		   SQLQuery sqlQuery=session.createSQLQuery(sql);
		   System.out.println("2 step");
		   sqlQuery.setCacheable(false);
		   //Add entity to be searched
		   System.out.println("3 step");
		    sqlQuery.addEntity("LeaveRequest",LeaveRequestImpl.class);
		    //Replace positional parameters in the query
		    QueryPos queryPos=QueryPos.getInstance(sqlQuery);
		    System.out.println("4 step");
		   queryPos.add(isRequestChecked);
		   System.out.println("5 step ");
		  //Execute query and return result
		   List s=(List)sqlQuery.list();
		   System.out.println(s.size()+" size");
		   return s.size();
		  }catch(Exception e){
		   e.printStackTrace();
		  }finally {
		   closeSession(session);
		  }
		  
		  return 5;
		
	}
}
