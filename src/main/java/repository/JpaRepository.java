
package com.esdrasmorais.util.repository;

import java.net.UnknownHostException;
import java.util.List;

import com.esdrasmorais.util.repository.interfaces.IClient;
import com.esdrasmorais.util.repository.interfaces.IContext;
import com.esdrasmorais.util.repository.interfaces.IDb;

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
	public boolean save(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object object) {
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
