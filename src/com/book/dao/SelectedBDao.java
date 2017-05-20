package com.book.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.book.entity.SelectedB;

public interface SelectedBDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(SelectedB transientInstance);

	public abstract void delete(SelectedB persistentInstance);

	public abstract SelectedB findById(com.book.entity.SelectedBId id);

	public abstract List<SelectedB> findByExample(SelectedB instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract SelectedB merge(SelectedB detachedInstance);

	public abstract void attachDirty(SelectedB instance);

	public abstract void attachClean(SelectedB instance);

}