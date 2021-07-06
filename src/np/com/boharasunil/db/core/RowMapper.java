package np.com.boharasunil.db.core;

import java.sql.ResultSet;

/**
 *
 * @author sunilbohara
 */
public interface RowMapper<T> {
    public T mapRow(ResultSet rs) throws Exception;
}
