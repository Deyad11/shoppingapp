package com.demo.deepanshu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.deepanshu.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO User (name) VALUES (?)";
        jdbcTemplate.update(sql, user.getName());
    }
    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM User WHERE userId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserMapper());
    }
    
    private static final class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setName(rs.getString("name"));
            return user;
        }
        
    }
}
