package np.com.boharasunil.repository;

import java.util.List;

/**
 *
 * @author sunilbohara
 */
public interface CRUDMasterRepository<T> {

    List<T> findAll() throws Exception;

    T findByInput(Object object) throws Exception;

    int insert(T model) throws Exception;

    int update(T model, Object object) throws Exception;

    int delete(int id) throws Exception;
}
