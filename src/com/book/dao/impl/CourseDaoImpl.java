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

import com.book.dao.CourseDao;
import com.book.entity.Course;


@Transactional
@Repository
public class CourseDaoImpl implements CourseDao {
	private static final Logger log = LoggerFactory.getLogger(CourseDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
	
	}


	@Override
	public void save(Course transientInstance) {
		log.debug("saving Course instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}


	@Override
	public void delete(Course persistentInstance) {
		log.debug("deleting Course instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}


	@Override
	public Course findById(java.lang.String id) {
		log.debug("getting Course instance with id: " + id);
		try {
			Course instance = (Course) getCurrentSession().get(
					"com.book.entity.Course", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	
	@Override
	public List<Course> findByExample(Course instance) {
		log.debug("finding Course instance by example");
		try {
			List<Course> results = (List<Course>) getCurrentSession()
					.createCriteria("com.book.entity.Course")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Course instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Course as model where model."
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
	 * @see com.book.dao.impl.CourseDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Course instances");
		try {
			String queryString = "from Course";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.CourseDao#merge(com.book.entity.Course)
	 */
	@Override
	public Course merge(Course detachedInstance) {
		log.debug("merging Course instance");
		try {
			Course result = (Course) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.CourseDao#attachDirty(com.book.entity.Course)
	 */
	@Override
	public void attachDirty(Course instance) {
		log.debug("attaching dirty Course instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.CourseDao#attachClean(com.book.entity.Course)
	 */
	@Override
	public void attachClean(Course instance) {
		log.debug("attaching clean Course instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CourseDao getFromApplicationContext(ApplicationContext ctx) {
		return (CourseDao) ctx.getBean("CourseDAO");
	}
}