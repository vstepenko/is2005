package ua.edu.duan.is2005.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.edu.duan.is2005.entity.StudentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentSqlDao {

    private final JdbcTemplate jdbcTemplate;


    public Optional<StudentEntity> findById(String id){

        String sql = "select * from student where id = ?";

        return Optional.of(jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentRowMapping()));
    }

    private static class StudentRowMapping implements RowMapper<StudentEntity> {

        @Override
        public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(rs.getString("id"));
            studentEntity.setFirstName(rs.getString("first_name"));
            studentEntity.setLastName(rs.getString("last_mame"));
            return studentEntity;
        }
    }
}
