package api.users.es.domain.model;

import java.util.List;

public interface CommonRepository<T, ID> {
	
    T create(T domain) throws Exception;
    
    T update(T domain) throws Exception;

    void delete(ID id) throws Exception;

    T findById(ID id) throws Exception;

    List<T> findAll();
}
