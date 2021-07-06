package np.com.boharasunil.db.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunilbohara
 */
public class JdbcTemplate<T> {

    public List<T> query(String sql, RowMapper<T> mapper) throws Exception {
        List<T> rows = new ArrayList<>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            rows.add(mapper.mapRow(rs));
        }
        conn.close();
        return rows;
    }

    private void setParameters(PreparedStatement pstmt, Object[] params) throws SQLException {
        int i = 1;
        for (Object param : params) {
            pstmt.setObject(i, param);
            i++;
        }
    }

    public T queryForObject(String sql, Object[] params,RowMapper<T> mapper) throws Exception {
        T row = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            row = mapper.mapRow(rs);
        }
        return row;
    }

    public int update(String sql, Object[] params) throws Exception {
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        setParameters(pstmt, params);
        int result = pstmt.executeUpdate();
        return result;
    }

}
