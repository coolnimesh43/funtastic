package org.funtastic.service;

import java.util.List;

public interface GenericService<T,R> {

	public R findById(T id);
	public List<R> getAll();
	public R save(R r);
	public void delete(R r);
}
