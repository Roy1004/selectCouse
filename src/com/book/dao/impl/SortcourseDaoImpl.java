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

import com.book.dao.SortcourseDao;
import com.book.entity.Sortcourse;
import com.book.entity.SortcourseId;


@Transactional
@Repository
public class SortcourseDaoImpl implements SortcourseDao {
	private static final Logger log = LoggerFactory
			.getLogger(SortcourseDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SortcourseDao#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.book.dao.impl.SortcourseDao#save(com.book.entity.Sortcourse)
	 */
	@Override
	public void save(Sortcourse transientInstance) {
		log.debug("saving Sortcourse instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SortcourseDao#delete(com.book.entity.Sortcourse)
	 */
	@Override
	public void delete(Sortcourse persistentInstance) {
		log.debug("deleting Sortcourse instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SortcourseDao#findById(com.book.entity.SortcourseId)
	 */
	@Override
	public Sortcourse findById(com.book.entity.SortcourseId id) {
		log.debug("getting Sortcourse instance with id: " + id);
		try {
			Sortcourse instance = (Sortcourse) getCurrentSession().get(
					"com.book.entity.Sortcourse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SortcourseDao#findByExample(com.book.entity.Sortcourse)
	 */
	@Override
	public List<Sortcourse> findByExample(Sortcourse instance) {
		log.debug("finding Sortcourse instance by example");
		try {
			List<Sortcourse> results = (List<Sortcourse>) getCurrentSession()
					.createCriteria("com.book.entity.Sortcourse")
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
	 * @see com.book.dao.impl.SortcourseDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sortcourse instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sortcourse as model where model."
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
	 * @see com.book.dao.impl.SortcourseDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Sortcourse instances");
		try {
			String queryString = "from Sortcourse";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SortcourseDao#merge(com.book.entity.Sortcourse)
	 */
	@Override
	public Sortcourse merge(Sortcourse detachedInstance) {
		log.debug("merging Sortcourse instance");
		try {
			Sortcourse result = (Sortcourse) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SortcourseDao#attachDirty(com.book.entity.Sortcourse)
	 */
	@Override
	public void attachDirty(Sortcourse instance) {
		log.debug("attaching dirty Sortcourse instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.SortcourseDao#attachClean(com.book.entity.Sortcourse)
	 */
	@Override
	public void attachClean(Sortcourse instance) {
		log.debug("attaching clean Sortcourse instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SortcourseDao getFromApplicationContext(ApplicationContext ctx) {
		return (SortcourseDao) ctx.getBean("SortcourseDAO");
	}
}