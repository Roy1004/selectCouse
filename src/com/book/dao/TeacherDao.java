package com.book.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.book.entity.Teacher;

public interface TeacherDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Teacher transientInstance);

	public abstract void delete(Teacher persistentInstance);

	public abstract Teacher findById(java.lang.String id);

	public abstract List<Teacher> findByExample(Teacher instance);

	public abstract List findByProperty(String propertyName, Object value);
	
	public abstract List findByProperty3(
			String p1, Object v1,String p2, Object v2,String p3, Object v3);

	public abstract List findAll();

	public abstract Teacher merge(Teacher detachedInstance);

	public abstract void attachDirty(Teacher instance);

	public abstract void attachClean(Teacher instance);

}