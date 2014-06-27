package com.etech.dao;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
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
import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.etech.entity.TdataCenter;

@Repository
public class EtechComDao extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(EtechComDao.class);
	@Resource
	private SessionFactory sessionFactory;

	// 当对象和他的级联对象都没有id的时候,可以一起级联保存
	public void merge(Object object) {
		HibernateTemplate ht = super.getHibernateTemplate();
		ht.merge(object);
		ht.flush();
	}

	// 当对象有id，他的级联对象都没有id的时候,可以一起级联保存
	public void saveOrUpdata(Object object) {
		HibernateTemplate ht = getHibernateTemplate();
		ht.saveOrUpdate(object);
		ht.flush();
	}

	// 以HQL的方式保存对象
	public Integer saveOrUpdate(final String hql) {
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				int result = query.executeUpdate();
				return result;
			}
		});
		return 0;
	}
	public void update(Class<?> clazz,String property,final Object value,String updateProperty,final Object updateValue){
		final String hql="update from "+clazz.getName()+" as entity set entity."+updateProperty+" =:updateValue where entity."+property+" =:value";
		getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setParameter("updateValue",updateValue);
				query.setParameter("value", value);
				log.debug(query.getQueryString());
				query.executeUpdate();
				return null;
			}
			
		});
	}
	// 以对象的方式删除对象
	public void delete(Object object) {
		this.getHibernateTemplate().delete(object);
	}

	// 以HQL的方式删除对象
	public void delete(final String hql) {
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.executeUpdate();
				return null;
			}
		});

	}

	/** Begin Author:wuqiwei Data:2014-05-22 AddReason:根据id的方式删除对象 */
	public void delete(Class<?> clazz, final Integer id) {
		final String clazzName = clazz.getName();
		final String hql = "delete from " + clazzName + " where id=:id";
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				query.executeUpdate();
				return null;
			}
		});
	}

	/** End Author:wuqiwei Data:2014-05-22 AddReason:根据id的方式删除对象 */
	public void delete(Class<?> clazz, String property, final Object value) {
		final String hql = "delete from " + clazz.getName()
				+ " as entity where entity." + property + " =:value";
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setParameter("value", value);
				query.executeUpdate();
				return null;
			}
		});
	}
	public void deleteBySQL(final String sql){
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createSQLQuery(sql);
				query.executeUpdate();
				return null;
			}
		});
	}
	// 获取单一对象
	public Object getObjectByHQL(final String hql) {
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
	public Object getObjectByProperty(Class<?> clazz,final Object property, final Object value) {
		final String hql = "from " + clazz.getName() + " as entity where entity."+ property + " =:value";
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
	public List<?> getListByProperty(Class<?> clazz,final Object property, final Object value) {
		final String hql = "from " + clazz.getName() + " as entity where entity."+ property + " =:value";
		log.debug("current hql:" + hql);
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
	// 获取多个对象
	public List<?> getObjecListByHQL(final String hql) {
		return (List<?>) this.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.list();
					}
				});
	}

	// 以对象的方式获取对象。
	public Object getObjecById(Class<?> clazz, Integer id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public List<?> getPageDateList(final String hql, final Integer currentPage,
			final Integer perPageCount, Class<?> clazz) {
		String hqlCount = "select count (*) from " + clazz.getName();
		final Long totalCount = (Long) getObjectByHQL(hqlCount);
		if (totalCount == null) {
			return null;
		}
		return (List<?>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						// 该方法是设置从哪一行开始
						Integer pageIndex = currentPage;
						Integer perCount = perPageCount;
						if ((pageIndex != null && currentPage != 0)|| (perCount != null && perPageCount != 0)) {
							// 如果当前页大于最大页,则当前页等于最大页
							// 使用ceil的时候注意：一定要把参数转换为float类型。
							if (currentPage > ((int) Math.ceil((float) totalCount / perCount))) {
								pageIndex = (int) Math.ceil((float) totalCount/ perCount);
							}
							// 如果当前页小于第一页则等于第一页
							if (pageIndex < 1) {
								pageIndex = 1;
							}
							query.setFirstResult(perCount * (pageIndex - 1)); // 此处是
																				// 页和开始行的关系
																				// y=perPageCount(x-1)
							// 设置到哪里结束
							// query.setMaxResults(perPageCount*nowPage-1); //
							// 之前理解错误不是"此处是开始行和结束行之间的关系 z=perPageCount*x-1;"
							// 二是每次获取多少条记录
							query.setMaxResults(perCount);// 获取多少条数据。
						}
						return query.list();
					}
				});
	}

	/* Begin Name:wuqiwei Date:2013-11-5 07:24:40 AddReason:返回一定数量的行数 */
	public List<?> getPageDateList(final String hql, final Integer num) {
		Assert.assertNotNull(num);
		return (List<?>) getHibernateTemplate().execute(new HibernateCallback<Object>() {

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

	/* Begin Author:wuqiwei Date:2013-04-06 AddReason:使用hibernatesearch完成全文搜索 */
	@SuppressWarnings("unchecked")
	public  List<?> getListByHSearch(Class<?> clazz, String key,String[] properties,int currentPage,int perCount) {
		Assert.assertTrue(currentPage>=0);
		Assert.assertTrue(perCount>=0);
		Session session = sessionFactory.getCurrentSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		Transaction tx = fullTextSession.beginTransaction();
		MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_36, properties, new IKAnalyzer());
		parser.setDefaultOperator(QueryParser.OR_OPERATOR);
		BooleanQuery booleanQuery = new BooleanQuery();// 用BooleanQuery来做搜索条件的组合，即多条件查询
		try {
			booleanQuery.add(parser.parse(key), Occur.SHOULD);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(booleanQuery, clazz);
		int total=fullTextQuery.getResultSize();
		// 分页
		if (currentPage > ((int) Math.ceil((float) total / perCount))) {
			currentPage = (int) Math.ceil((float) total/ perCount);
		}
		// 如果当前页小于第一页则等于第一页
		if (currentPage < 1) {
			currentPage = 1;
		}
		fullTextQuery.setFirstResult(perCount * (currentPage - 1));
		fullTextQuery.setMaxResults(perCount);
		
		List<TdataCenter> list = (List<TdataCenter>) fullTextQuery.list();
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
		QueryScorer queryScorer = new QueryScorer(booleanQuery);
		Highlighter highlighter = new Highlighter(formatter, queryScorer);
		Analyzer analyzer = new IKAnalyzer();
		List<TdataCenter> highlightResult=new ArrayList<TdataCenter>();
		for (TdataCenter dataCenter : list) {
			TdataCenter data=null;
			try {
				data = (TdataCenter) dataCenter.clone();
				highlightResult.add(data);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			for (String fieldName : properties) {
				// 运用反射得到具体的标题内容
				Method method = BeanUtils.getPropertyDescriptor(clazz, fieldName).getReadMethod();
				Object fieldValue = ReflectionUtils.invokeMethod(method, data);
				String hightLightFieldValue = null;
				if (fieldValue instanceof String) {
					try {
						// 获得高亮关键字
						hightLightFieldValue = highlighter.getBestFragment(analyzer, fieldName,ObjectUtils.toString(fieldValue));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					// 这个判断很关键，否则如果标题或内容中没有关键字的话，就会出现不显示的问题。
					if (hightLightFieldValue != null) {
						// 运用反射设置结果集中的关键字高亮
						method = BeanUtils.getPropertyDescriptor(clazz, fieldName).getWriteMethod();
						ReflectionUtils.invokeMethod(method, data,hightLightFieldValue); 
						//setField(ReflectionUtils.findField(searchResultClass,fieldName), e,hightLightFieldValue);
					}
				}
			}
		}
		tx.commit();
		return highlightResult;
	}
	/* End Author:wuqiwei Date:2013-04-06 AddReason:使用hibernatesearch完成全文搜索 */

	public List<?> getListByProperty(Class<?> clazz, String property,final Object value, final int num) {
		final String hql = "from " + clazz.getName() + " as entity where entity."+ property + " =:value";
		log.debug("current hql:" + hql);
		return (List<?>) getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setParameter("value", value);
				query.setFirstResult(0);
				query.setMaxResults(num);
				List<?> list = query.list();
				return list;
			}
		});
	}

	public List<?> getListByClass(final Class<?> clazz, final Integer num) {
		return (List<?>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
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
}
