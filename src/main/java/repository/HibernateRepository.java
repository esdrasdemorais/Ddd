
package com.esdrasmorais.util.repository;

import java.net.UnknownHostException;
import java.util.List;

import com.esdrasmorais.util.repository.interfaces.IClient;
import com.esdrasmorais.util.repository.interfaces.IContext;
import com.esdrasmorais.util.repository.interfaces.IDb;

public class HibernateRepository<T> extends RepositoryImpl<T> {
	public HibernateRepository(IContext context, IClient client, IDb db) {
		super(context, client, db);
	}

	@Override
	public Context get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context connect(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> find(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(T object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init(IContext context) throws UnknownHostException {
		// TODO Auto-generated method stub	
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
