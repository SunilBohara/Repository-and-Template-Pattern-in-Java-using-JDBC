package np.com.boharasunil.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import np.com.boharasunil.db.core.DbConnection;
import np.com.boharasunil.db.core.JdbcTemplate;
import np.com.boharasunil.db.core.RowMapper;
import np.com.boharasunil.entity.Student;
import np.com.boharasunil.repository.StudentRepository;

/**
 *
 * @author sunilbohara
 */
public class StudentRepositoryImpl implements StudentRepository {

    private JdbcTemplate<Student> studentTemplate = new JdbcTemplate<>();

    @Override
    public List<Student> findAll() throws Exception {
        String sql = "select * from student_list";

        return studentTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs) throws Exception {
                Student student = new Student();
                student.setSid(rs.getInt("s_id"));
                student.setFullName(rs.getString("fullname"));
                student.setGender(rs.getString("gender"));
                student.setAddress(rs.getString("address"));
                student.setEmail(rs.getString("email"));
                student.setContactNo(rs.getLong("contactNO"));
                return student;
            }
        ;
    }

    );
    }

    @Override
    public Student findByInput(Object object) throws Exception {
        String sql = "select * from student_list where id = ? or s_id = ? or fullname = ? or gender = ? or address = ? or "
                + "email = ? or contactNo = ?";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setObject(1, object);
        pstmt.setObject(2, object);
        pstmt.setObject(3, object);
        pstmt.setObject(4, object);
        pstmt.setObject(5, object);
        pstmt.setObject(6, object);
        pstmt.setObject(7, object);
        ResultSet rs = pstmt.executeQuery();
        Student student = null;
        if (rs.next()) {
            student = new Student(rs.getInt("s_id"), rs.getString("fullname"), rs.getString("gender"),
                    rs.getString("address"), rs.getString("email"), rs.getLong("contactNo"));
        } else {
            System.out.println("oops.. sorry data not found!");
        }
        conn.close();
        return student;
    }

    @Override
    public int insert(Student student) throws Exception {
        Connection conn = DbConnection.getConnection();
        String sql = "insert into student_list(s_id,fullname,gender,address,email,contactNo) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, student.getSid());
        pstmt.setString(2, student.getFullName());
        pstmt.setString(3, student.getGender());
        pstmt.setString(4, student.getAddress());
        pstmt.setString(5, student.getEmail());
        pstmt.setLong(6, student.getContactNo());
        int result = pstmt.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public int update(Student student, Object object) throws Exception {
        String sql = "update student_list set s_id = ? ,fullname = ?, gender = ?, address = ?, email = ?, contactNo = ?"
                + " where s_id = ?;";
        Connection conn = DbConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, student.getSid());
        pstmt.setString(2, student.getFullName());
        pstmt.setString(3, student.getGender());
        pstmt.setString(4, student.getAddress());
        pstmt.setString(5, student.getEmail());
        pstmt.setLong(6, student.getContactNo());
        pstmt.setObject(7, object);
        int result = pstmt.executeUpdate();
        return result;
    }

    @Override
    public int delete(int id) throws Exception {
        Connection conn = DbConnection.getConnection();
        String sql = "delete from student_list where s_id = ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        conn.close();
        return result;
    }
}
