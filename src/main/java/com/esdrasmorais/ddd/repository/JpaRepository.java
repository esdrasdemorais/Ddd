
package com.esdrasmorais.ddd.repository;

import java.net.UnknownHostException;
import java.util.List;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.interfaces.IDb;

public class JpaRepository extends RepositoryImpl {

	public JpaRepository(Context context, IClient client, IDb db) {
		super(context, client, db);
	}
	// private EntityManagerFactory factory;

	@Override
	public void init(IContext context) throws UnknownHostException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IContext get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List find(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean remove(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

//    @Override
//    public <T> List<T> find(String query, Object[] params) {
//
//    }

}
