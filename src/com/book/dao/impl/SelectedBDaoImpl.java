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

import com.book.dao.SelectedBDao;
import com.book.entity.SelectedB;
import com.book.entity.SelectedBId;


@Transactional
@Repository
public class SelectedBDaoImpl implements SelectedBDao {
	private static final Logger log = LoggerFactory
			.getLogger(SelectedBDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedBDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedBDao#save(com.book.entity.SelectedB)
	 */
	@Override
	public void save(SelectedB transientInstance) {
		log.debug("saving SelectedB instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedBDao#delete(com.book.entity.SelectedB)
	 */
	@Override
	public void delete(SelectedB persistentInstance) {
		log.debug("deleting SelectedB instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedBDao#findById(com.book.entity.SelectedBId)
	 */
	@Override
	public SelectedB findById(com.book.entity.SelectedBId id) {
		log.debug("getting SelectedB instance with id: " + id);
		try {
			SelectedB instance = (SelectedB) getCurrentSession().get(
					"com.book.entity.SelectedB", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedBDao#findByExample(com.book.entity.SelectedB)
	 */
	@Override
	public List<SelectedB> findByExample(SelectedB instance) {
		log.debug("finding SelectedB instance by example");
		try {
			List<SelectedB> results = (List<SelectedB>) getCurrentSession()
					.createCriteria("com.book.entity.SelectedB")
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
	 * @see com.book.dao.impl.SelectedBDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SelectedB instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SelectedB as model where model."
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
	 * @see com.book.dao.impl.SelectedBDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all SelectedB instances");
		try {
			String queryString = "from SelectedB";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedBDao#merge(com.book.entity.SelectedB)
	 */
	@Override
	public SelectedB merge(SelectedB detachedInstance) {
		log.debug("merging SelectedB instance");
		try {
			SelectedB result = (SelectedB) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedBDao#attachDirty(com.book.entity.SelectedB)
	 */
	@Override
	public void attachDirty(SelectedB instance) {
		log.debug("attaching dirty SelectedB instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SelectedBDao#attachClean(com.book.entity.SelectedB)
	 */
	@Override
	public void attachClean(SelectedB instance) {
		log.debug("attaching clean SelectedB instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SelectedBDao getFromApplicationContext(ApplicationContext ctx) {
		return (SelectedBDao) ctx.getBean("SelectedBDAO");
	}
}