package br.com.arcus.utils;

import java.util.List;

public interface Dao {
	public void insert(Object arg0);
	public void update(Object arg0);
	public void delete(Object arg0);
	public Object select(Object arg0);
	public List<?> select();
}
