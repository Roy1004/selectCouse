package com.book.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.book.entity.Student;

public interface StudentDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Student transientInstance);

	public abstract void delete(Student persistentInstance);

	public abstract Student findById(java.lang.String id);

	public abstract List<Student> findByExample(Student instance);

	public abstract List findByProperty(String propertyName, Object value);
	
	public abstract List findByProperty2(
			String propertyName1, Object value1,String propertyName2, Object value2);
	

	public abstract List findAll();

	public abstract Student merge(Student detachedInstance);

	public abstract void attachDirty(Student instance);

	public abstract void attachClean(Student instance);

}