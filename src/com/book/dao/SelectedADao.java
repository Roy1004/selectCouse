package com.book.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.book.entity.SelectedA;

public interface SelectedADao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(SelectedA transientInstance);

	public abstract void delete(SelectedA persistentInstance);

	public abstract SelectedA findById(com.book.entity.SelectedAId id);

	public abstract List<SelectedA> findByExample(SelectedA instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract SelectedA merge(SelectedA detachedInstance);

	public abstract void attachDirty(SelectedA instance);

	public abstract void attachClean(SelectedA instance);

}