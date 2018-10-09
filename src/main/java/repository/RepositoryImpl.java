
package com.esdrasmorais.util.repository;

import java.util.List;

import com.esdrasmorais.util.repository.interfaces.IClient;
import com.esdrasmorais.util.repository.interfaces.IContext;
import com.esdrasmorais.util.repository.interfaces.IDb;

public abstract class RepositoryImpl<T> extends Context {
	public RepositoryImpl(IContext context, IClient client, IDb db) {
		super(context, client, db);
	}
	
	public abstract <T> List<T> find(String query, Object[] params);

	public abstract boolean save(T object);

	public abstract boolean remove(T object);
	
	public abstract List<T> findAll();

	public abstract T findById(Long id);
	
	public abstract void dispose();
}