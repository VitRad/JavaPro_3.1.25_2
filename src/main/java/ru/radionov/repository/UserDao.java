package ru.radionov.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.radionov.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            return user;
        }
    }

    public void createUser(User user) {
        String insert = "insert into users (username) values (?)";
        jdbcTemplate.update(insert, user.getUserName());
    }

    public User getUserById(Long id) {
        String select = "select * from users where id = ?";
        return jdbcTemplate.queryForObject(select, new UserRowMapper(), id);
    }

    public List<User> getAllusers() {
        String select = "Select * from users";
        return jdbcTemplate.query(select, new UserRowMapper());
    }

    public void deleteUserById(Long id) {
        String delete = "delete from users where id = ?";
        jdbcTemplate.update(delete, id);
    }
}
