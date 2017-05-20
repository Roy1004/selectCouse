package com.book.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.book.entity.Course;

public interface CourseDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Course transientInstance);

	public abstract void delete(Course persistentInstance);

	public abstract Course findById(java.lang.String id);

	public abstract List<Course> findByExample(Course instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Course merge(Course detachedInstance);

	public abstract void attachDirty(Course instance);

	public abstract void attachClean(Course instance);

}