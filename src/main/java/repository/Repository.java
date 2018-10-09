
package com.esdrasmorais.util.repository;

import java.util.List;

import com.esdrasmorais.util.repository.interfaces.IRepository;

public class Repository<T> implements IRepository<T> {
	private RepositoryImpl repositoryImpl;

	public List<T> find(String query, Object[] params) {
		return repositoryImpl.find(query, params);
	}

	public boolean save(T object) {
		return repositoryImpl.save(object);
	}

	public boolean remove(T object) {
		return repositoryImpl.remove(object);
	}

	@Override
	public List<T> findAll() {
		return repositoryImpl.findAll();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public T findById(Long id) {
		return (T) repositoryImpl.findById(id);
	}
}
