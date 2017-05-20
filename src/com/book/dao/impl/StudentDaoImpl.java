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

import com.book.dao.StudentDao;
import com.book.entity.Student;


@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {
	private static final Logger log = LoggerFactory.getLogger(StudentDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.book.dao.impl.StudentDao#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.book.dao.impl.StudentDao#save(com.book.entity.Student)
	 */
	@Override
	public void save(Student transientInstance) {
		log.debug("saving Student instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.StudentDao#delete(com.book.entity.Student)
	 */
	@Override
	public void delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.StudentDao#findById(java.lang.String)
	 */
	@Override
	public Student findById(java.lang.String id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getCurrentSession().get(
					"com.book.entity.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.StudentDao#findByExample(com.book.entity.Student)
	 */
	@Override
	public List<Student> findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List<Student> results = (List<Student>) getCurrentSession()
					.createCriteria("com.book.entity.Student")
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
	 * @see com.book.dao.impl.StudentDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
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
	public List findByProperty2(String propertyName1, Object value1,
			String propertyName2, Object value2) {
		try {
			String queryString = "from Student as model where model."
					+ propertyName1 + " = ? and "+propertyName2 + " = ? ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value1);
			queryObject.setParameter(1, value2);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.StudentDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.StudentDao#merge(com.book.entity.Student)
	 */
	@Override
	public Student merge(Student detachedInstance) {
		log.debug("merging Student instance");
		try {
			Student result = (Student) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.StudentDao#attachDirty(com.book.entity.Student)
	 */
	@Override
	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.book.dao.impl.StudentDao#attachClean(com.book.entity.Student)
	 */
	@Override
	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentDao getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDao) ctx.getBean("StudentDAO");
	}

	
}