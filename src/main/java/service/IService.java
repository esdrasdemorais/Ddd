
package com.esdrasmorais.util.service;

import java.util.List;

public interface IService<T> {
	public List<T> findAll();

	public T findById(Long id);

	public List<T> find(String query, Object[] params);

	public boolean save(T object);

	public boolean remove(T object);

	public void dispose();
}