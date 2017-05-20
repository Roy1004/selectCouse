package com.book.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.book.entity.Message;

public interface MessageDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Message transientInstance);

	public abstract void delete(Message persistentInstance);

	public abstract Message findById(com.book.entity.MessageId id);

	public abstract List<Message> findByExample(Message instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Message merge(Message detachedInstance);

	public abstract void attachDirty(Message instance);

	public abstract void attachClean(Message instance);

}