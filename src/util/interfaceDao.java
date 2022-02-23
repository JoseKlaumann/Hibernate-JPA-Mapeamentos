package util;

import java.util.List;

public interface interfaceDao <T> {
	
	void insert (T obj);
	void update (T obj);
	void delete (Long id);
	T findById  (Long id);
	List <T>    findAll();
}
