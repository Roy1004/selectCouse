package com.book.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.book.entity.TeacherCourse;

public interface TeacherCourseDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(TeacherCourse transientInstance);

	public abstract void delete(TeacherCourse persistentInstance);

	public abstract TeacherCourse findById(com.book.entity.TeacherCourseId id);

	public abstract List<TeacherCourse> findByExample(TeacherCourse instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract TeacherCourse merge(TeacherCourse detachedInstance);

	public abstract void attachDirty(TeacherCourse instance);

	public abstract void attachClean(TeacherCourse instance);

}