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

import com.book.dao.TeacherDao;
import com.book.entity.Teacher;


@Transactional
@Repository
public class TeacherDaoImpl implements TeacherDao {
	private static final Logger log = LoggerFactory.getLogger(TeacherDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherDao#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.book.dao.impl.TeacherDao#save(com.book.entity.Teacher)
	 */
	@Override
	public void save(Teacher transientInstance) {
		log.debug("saving Teacher instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherDao#delete(com.book.entity.Teacher)
	 */
	@Override
	public void delete(Teacher persistentInstance) {
		log.debug("deleting Teacher instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherDao#findById(java.lang.String)
	 */
	@Override
	public Teacher findById(java.lang.String id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) getCurrentSession().get(
					"com.book.entity.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherDao#findByExample(com.book.entity.Teacher)
	 */
	@Override
	public List<Teacher> findByExample(Teacher instance) {
		log.debug("finding Teacher instance by example");
		try {
			List<Teacher> results = (List<Teacher>) getCurrentSession()
					.createCriteria("com.book.entity.Teacher")
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
	 * @see com.book.dao.impl.TeacherDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Teacher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Teacher as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByProperty3(String p1, Object v1, String p2, Object v2,
			String p3, Object v3) {
		try {
			String queryString = "from Teacher as model where model."
					+ p1 + "= ? and "+p2 + "= ? and "+p3 + "= ? ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, v1);
			queryObject.setParameter(1, v2);
			queryObject.setParameter(2, v3);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherDao#merge(com.book.entity.Teacher)
	 */
	@Override
	public Teacher merge(Teacher detachedInstance) {
		log.debug("merging Teacher instance");
		try {
			Teacher result = (Teacher) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherDao#attachDirty(com.book.entity.Teacher)
	 */
	@Override
	public void attachDirty(Teacher instance) {
		log.debug("attaching dirty Teacher instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherDao#attachClean(com.book.entity.Teacher)
	 */
	@Override
	public void attachClean(Teacher instance) {
		log.debug("attaching clean Teacher instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherDao getFromApplicationContext(ApplicationContext ctx) {
		return (TeacherDao) ctx.getBean("TeacherDAO");
	}


}