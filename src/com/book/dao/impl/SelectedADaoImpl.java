package com.book.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.dao.SelectedADao;
import com.book.entity.SelectedA;
import com.book.entity.SelectedAId;


@Transactional
@Repository
public class SelectedADaoImpl implements SelectedADao {
	private static final Logger log = LoggerFactory
			.getLogger(SelectedADaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {

	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#save(com.book.entity.SelectedA)
	 */
	@Override
	public void save(SelectedA transientInstance) {
		log.debug("saving SelectedA instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#delete(com.book.entity.SelectedA)
	 */
	@Override
	public void delete(SelectedA persistentInstance) {
		log.debug("deleting SelectedA instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#findById(com.book.entity.SelectedAId)
	 */
	@Override
	public SelectedA findById(com.book.entity.SelectedAId id) {
		log.debug("getting SelectedA instance with id: " + id);
		try {
			SelectedA instance = (SelectedA) getCurrentSession().get(
					"com.book.entity.SelectedA", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#findByExample(com.book.entity.SelectedA)
	 */
	@Override
	public List<SelectedA> findByExample(SelectedA instance) {
		log.debug("finding SelectedA instance by example");
		try {
			List<SelectedA> results = (List<SelectedA>) getCurrentSession()
					.createCriteria("com.book.entity.SelectedA")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SelectedA instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SelectedA as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all SelectedA instances");
		try {
			String queryString = "from SelectedA";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#merge(com.book.entity.SelectedA)
	 */
	@Override
	public SelectedA merge(SelectedA detachedInstance) {
		log.debug("merging SelectedA instance");
		try {
			SelectedA result = (SelectedA) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#attachDirty(com.book.entity.SelectedA)
	 */
	@Override
	public void attachDirty(SelectedA instance) {
		log.debug("attaching dirty SelectedA instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedADao#attachClean(com.book.entity.SelectedA)
	 */
	@Override
	public void attachClean(SelectedA instance) {
		log.debug("attaching clean SelectedA instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SelectedADao getFromApplicationContext(ApplicationContext ctx) {
		return (SelectedADao) ctx.getBean("SelectedADAO");
	}
}