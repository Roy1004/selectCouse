package com.book.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.book.entity.Sortcourse;

public interface SortcourseDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Sortcourse transientInstance);

	public abstract void delete(Sortcourse persistentInstance);

	public abstract Sortcourse findById(com.book.entity.SortcourseId id);

	public abstract List<Sortcourse> findByExample(Sortcourse instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Sortcourse merge(Sortcourse detachedInstance);

	public abstract void attachDirty(Sortcourse instance);

	public abstract void attachClean(Sortcourse instance);

}