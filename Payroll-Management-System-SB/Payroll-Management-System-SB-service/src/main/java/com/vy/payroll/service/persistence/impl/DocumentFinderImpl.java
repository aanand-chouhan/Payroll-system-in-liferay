package com.vy.payroll.service.persistence.impl;

import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.vy.payroll.model.Document;
import com.vy.payroll.model.impl.DocumentImpl;
import com.vy.payroll.service.persistence.DocumentFinder;

public class DocumentFinderImpl extends DocumentFinderBaseImpl implements DocumentFinder{
	private static final String DOCS="com.vy.payroll.service.persistence.DocumentFinder.documentUpdate";
	private static final String ISDOCREVIEWED="getIsDocReviewed";
			public int updateDocReview(int eno) {
				
				int is_check=0;
				Session session=null;
				  try{
				   //open ORM Session
				     session=openSession();
				    //get sql query return in default.xml
				   String sql=CustomSQLUtil.get(getClass(), DOCS);
				   System.out.println("1 step "+sql);
				   SQLQuery sqlQuery=session.createSQLQuery(sql);
				   System.out.println("2 step");
				   sqlQuery.setCacheable(false);
				   //Add entity to be searched
				   System.out.println("3 step");
				    sqlQuery.addEntity("Document",DocumentImpl.class);
				    //Replace positional parameters in the query
				    QueryPos queryPos=QueryPos.getInstance(sqlQuery);
				    System.out.println("4 step");
				   queryPos.add(is_check);
				   queryPos.add(eno);
				   System.out.println("5 step "+ eno);
				  //Execute query and return result
				   return sqlQuery.executeUpdate();
				  }catch(Exception e){
				   e.printStackTrace();
				  }finally {
				   closeSession(session);
				  }
				  
				  return 5;
				 }
			
			
			
			public int isDocReviewed(int eno) {
				Session session=null;
				  try{
				   //open ORM Session
				     session=openSession();
				    //get sql query return in default.xml
				   String sql=CustomSQLUtil.get(getClass(), ISDOCREVIEWED);
				   System.out.println("1 step "+sql);
				   SQLQuery sqlQuery=session.createSQLQuery(sql);
				   System.out.println("2 step");
				   sqlQuery.setCacheable(false);
				   //Add entity to be searched
				   System.out.println("3 step");
				    sqlQuery.addEntity("Document",DocumentImpl.class);
				    //Replace positional parameters in the query
				    QueryPos queryPos=QueryPos.getInstance(sqlQuery);
				    System.out.println("4 step");
				   queryPos.add(eno);
				   System.out.println("5 step "+ eno);
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
