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

import com.book.dao.TeacherCourseDao;
import com.book.entity.TeacherCourse;
import com.book.entity.TeacherCourseId;


@Transactional
@Repository
public class TeacherCourseDaoImpl implements TeacherCourseDao {
	private static final Logger log = LoggerFactory
			.getLogger(TeacherCourseDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherCourseDao#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.book.dao.impl.TeacherCourseDao#save(com.book.entity.TeacherCourse)
	 */
	@Override
	public void save(TeacherCourse transientInstance) {
		log.debug("saving TeacherCourse instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherCourseDao#delete(com.book.entity.TeacherCourse)
	 */
	@Override
	public void delete(TeacherCourse persistentInstance) {
		log.debug("deleting TeacherCourse instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherCourseDao#findById(com.book.entity.TeacherCourseId)
	 */
	@Override
	public TeacherCourse findById(com.book.entity.TeacherCourseId id) {
		log.debug("getting TeacherCourse instance with id: " + id);
		try {
			TeacherCourse instance = (TeacherCourse) getCurrentSession().get(
					"com.book.entity.TeacherCourse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherCourseDao#findByExample(com.book.entity.TeacherCourse)
	 */
	@Override
	public List<TeacherCourse> findByExample(TeacherCourse instance) {
		log.debug("finding TeacherCourse instance by example");
		try {
			List<TeacherCourse> results = (List<TeacherCourse>) getCurrentSession()
					.createCriteria("com.book.entity.TeacherCourse")
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
	 * @see com.book.dao.impl.TeacherCourseDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TeacherCourse instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TeacherCourse as model where model."
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
	 * @see com.book.dao.impl.TeacherCourseDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TeacherCourse instances");
		try {
			String queryString = "from TeacherCourse";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherCourseDao#merge(com.book.entity.TeacherCourse)
	 */
	@Override
	public TeacherCourse merge(TeacherCourse detachedInstance) {
		log.debug("merging TeacherCourse instance");
		try {
			TeacherCourse result = (TeacherCourse) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherCourseDao#attachDirty(com.book.entity.TeacherCourse)
	 */
	@Override
	public void attachDirty(TeacherCourse instance) {
		log.debug("attaching dirty TeacherCourse instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.TeacherCourseDao#attachClean(com.book.entity.TeacherCourse)
	 */
	@Override
	public void attachClean(TeacherCourse instance) {
		log.debug("attaching clean TeacherCourse instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherCourseDao getFromApplicationContext(
			ApplicationContext ctx) {
		return (TeacherCourseDao) ctx.getBean("TeacherCourseDAO");
	}
}