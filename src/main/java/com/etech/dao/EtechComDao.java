package com.etech.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.util.Version;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.junit.Assert;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.etech.entity.Tgoods;

public class EtechComDao extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(EtechComDao.class);
	@Resource
	private SessionFactory sessionFactory;

	/**merge方法保存或更新数据库之后,对象变为持久对象*/ 
	public void merge(Object object) {
		HibernateTemplate ht = super.getHibernateTemplate();
		ht.merge(object);
		ht.flush();
	}

	/**saveOrUpdata方法保存或更新到数据库之后,对象变为托管对象*/ 
	public void saveOrUpdata(Object object) {
		HibernateTemplate ht = getHibernateTemplate();
		ht.saveOrUpdate(object);
		ht.flush();
	}

	/** Begin Author:wuqiwei Data:2014-05-22 AddReason:根据id的方式删除对象 */
	public void delete(Class<?> clazz, final Integer id) {
		Object object = this.getHibernateTemplate().get(clazz, id);
		getHibernateTemplate().delete(object);
		this.getHibernateTemplate().flush();
	}
	/** End Author:wuqiwei Data:2014-05-22 AddReason:根据id的方式删除对象 */
	public void delete(Object entity){
		this.getHibernateTemplate().delete(entity);
		this.getHibernateTemplate().flush();
	}
	
	/** Begin Author:wuqiwei Data:2014-05-22 AddReason:根据属性的方式删除对象 */
	public void delete(Class<?> clazz, String property, final Object value) {
		HibernateTemplate ht = getHibernateTemplate();
		List<?> objectList = this.findObjectList(clazz, property, value);
		for (Object entity : objectList) {
			ht.delete(entity);
			ht.flush();
		}
	}
	
	/** End Author:wuqiwei Data:2014-05-22 AddReason:根据属性的方式删除对象 */

	// 获取单一对象
	public Object findObject(final String hql) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.uniqueResult();
					}
				});
	}

	/** Begin Author:wuqiwei Data:2014-05-12 AddReason:根据属性获取对象 */
	public Object findObject(Class<?> clazz, final Object property,
			final Object value) {
		final String hql = "from " + clazz.getName()+ " as entity where entity." + property + " =:value";
		log.debug("current hql:" + hql);
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setParameter("value", value);
						return query.uniqueResult();
					}
				});
	}
	/** End Author:wuqiwei Data:2014-05-12 AddReason:根据属性获取对象 */

	/** Begin Author:wuqiwei Data:2014-05-12 AddReason:根据id获取对象 */
	public Object findObject(Class<?> clazz, Integer id) {
		return getHibernateTemplate().get(clazz, id);
	}
	/** End Author:wuqiwei Data:2014-05-12 AddReason:根据id获取对象 */

	public List<?> findObjectList(Class<?> clazz, final Object property,
			final Object value) {
		final String hql = "from " + clazz.getName()+ " as entity where entity." + property + " =:value order by id desc";
		return (List<?>) this.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setParameter("value", value);
						return query.list();
					}
				});
	}
	public List<?> findObjectList(final Class<?> clazz){
		
		return (List<?>)getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
					String hql="from "+clazz.getName();
					Query query = session.createQuery(hql);
					return query.list();
			}
			
		});
	}
 
	public List<?> findObjectList(final Class<?> clazz, final Integer num) {
		return (List<?>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + clazz.getName();
						Query query = session.createQuery(hql);
						query.setFirstResult(0);
						query.setMaxResults(num);
						List<?> list = query.list();
						return list;
					}
				});
	}

	public List<?> findObjectList(final Class<?> clazz, final String property,
			final Object value, final int num) {
		return (List<?>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + clazz.getName()+ " as entity where entity." + property + " =:value";
						Query query = session.createQuery(hql);
						query.setParameter("value", value);
						query.setFirstResult(0);
						query.setMaxResults(num);
						List<?> list = query.list();
						return list;
					}
				});
	}

	public Page<?> getPageDateList(final String hql, final Pageable pageable) {
		return (Page<?>)getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@SuppressWarnings("unchecked")
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				double total = (Double) query.uniqueResult();
				query = session.createQuery(hql);
				int totalPages = (int) Math.ceil((double) total / (double) pageable.getPageSize());
				if (totalPages < pageable.getPageNumber()) {
					pageable.setPageNumber(totalPages);
				}
				query.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
				query.setMaxResults(pageable.getPageSize());
			    @SuppressWarnings("rawtypes")
				Page page = new Page(query.list(), (int)total, pageable);
			    return page;
			}
		});
	}

	/** Begin Name:wuqiwei Date:2013-11-5 07:24:40 AddReason:返回一定数量的行数 */
	public List<?> findObjectList(final String hql, final Integer num) {
		Assert.assertNotNull(num);
		return (List<?>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setFirstResult(0);
						query.setMaxResults(num);
						List<?> list = query.list();
						return list;
					}
				});
	}
	/* End Name:wuqiwei Date:2013-11-5 07:24:40 AddReason:返回一定数量的行数 */

	/** Begin Author:wuqiwei Date:2013-04-06 AddReason:使用hibernatesearch完成关键字全文搜索 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page<?> findObjectListByKeyWord(Class<?> clazz, String key,String[] fileds, final Pageable pageable) {
		Session session = sessionFactory.getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		Transaction tx = fullTextSession.beginTransaction();
		MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_36, fileds, new IKAnalyzer());
		parser.setDefaultOperator(QueryParser.OR_OPERATOR);
		// 用BooleanQuery来做搜索条件的组合，即多条件查询
		BooleanQuery booleanQuery = new BooleanQuery();
		try {
			booleanQuery.add(parser.parse(key), Occur.SHOULD);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(booleanQuery, clazz);
		int total = fullTextQuery.getResultSize();
		int totalPages = (int) Math.ceil((double) total / (double) pageable.getPageSize());
		if (totalPages < pageable.getPageNumber()) {
			pageable.setPageNumber(totalPages);
		}
		fullTextQuery.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
		fullTextQuery.setMaxResults(pageable.getPageSize());
		List<?> list = fullTextQuery.list();
		tx.commit();
		return new Page(list, total, pageable);
	}
	/* End Author:wuqiwei Date:2013-04-06 AddReason:使用hibernatesearch完成关键字全文搜索 */

	public void update(final Integer goodsId,final short isOnSale) {
		final String hql = "update from Tgoods as goods set goods.isOnSale=:isOnSale where goods.goodsId=:goodsId";
		getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setParameter("goodsId",goodsId);
				query.setParameter("isOnSale", isOnSale);
				log.debug(query.getQueryString());
				query.executeUpdate();
				return null;
			}
			
		});
	}

	/**
	 * 
	 * @param isOnSale
	 * @param shopId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Tgoods> findList(final short isOnSale,final Integer shopId) {
		System.out.println(isOnSale+"---"+shopId);
		final String hql = "select goods from Tgoods goods where goods.shopId = :shopId and goods.isOnSale = :isOnSale ";
		return (List<Tgoods>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setParameter("shopId",shopId);
						query.setParameter("isOnSale", isOnSale);
						query.setFirstResult(0);
						List<?> list = query.list();
						return list;
					}
				});
	}


}
