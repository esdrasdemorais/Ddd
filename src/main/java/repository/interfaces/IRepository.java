
package com.esdrasmorais.util.repository.interfaces;

import java.util.List;

public interface IRepository<T> {
	public List<T> findAll();

	public T findById(Long id);

	public List<T> find(String query, Object[] params);

	public boolean save(T object);

	public boolean remove(T object);

	public void dispose();
}
