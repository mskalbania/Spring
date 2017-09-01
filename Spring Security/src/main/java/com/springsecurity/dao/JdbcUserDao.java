package com.springsecurity.dao;

import com.springsecurity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("Duplicates")
@Repository
public class JdbcUserDao implements UserDao {

    private static final String INSERT_USERS_QUERY = "INSERT INTO users (username,password,enabled) VALUES(?,?,TRUE)";
    private static final String INSERT_ROLE_QUERY = "INSERT INTO user_roles (username, role) VALUES(?,'ROLE_USER')";
    private static final String EXIST_USERS_QUERY = "SELECT count(*) FROM users WHERE username = ?";
    private static final String GET_USERS_QUERY = "SELECT * FROM users INNER JOIN user_roles " +
            "WHERE users.username = user_roles.username";

    private static final String DISABLE_QUERY = "UPDATE users SET enabled = 0 WHERE username = ?";
    private static final String ENABLE_QUERY = "UPDATE users SET enabled = 1 WHERE username = ?";
    private static final String UPDATE_ROLE_QUERY = "UPDATE user_roles SET role = ? WHERE username = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(User user) {
        String username = user.getUsername();
        if (exist(username)) {
            return false;
        }
        jdbcTemplate.update(INSERT_USERS_QUERY, username, user.getPassword());
        jdbcTemplate.update(INSERT_ROLE_QUERY, username);

        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setRole(parseRole(resultSet.getString("role")));
                user.setEnabled(resultSet.getBoolean("enabled"));
                return user;
            }
        });
    }

    @Override
    public List<User> getByUsername(String username) {
        return jdbcTemplate.query(GET_USERS_QUERY + " AND users.username LIKE ?",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user = new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setRole(parseRole(resultSet.getString("role")));
                        user.setEnabled(resultSet.getBoolean("enabled"));
                        return user;
                    }
                }, "%" + username + "%");
    }

    @Override
    public void disable(String username) {
        jdbcTemplate.update(DISABLE_QUERY, username);
    }

    @Override
    public void enable(String username) {
        jdbcTemplate.update(ENABLE_QUERY, username);
    }

    @Override
    public void updateRole(User user) {
        String username = user.getUsername();
        String newRole = "ROLE_" + user.getRole();
        jdbcTemplate.update(UPDATE_ROLE_QUERY, newRole, username);
    }

    private User.Role parseRole(String role) {
        if (role.equals("ROLE_USER")) {
            return User.Role.USER;
        } else if (role.equals("ROLE_ADMIN")) {
            return User.Role.ADMIN;
        } else {
            return null;
        }
    }

    private boolean exist(String username) {
        Integer count = jdbcTemplate.queryForObject(EXIST_USERS_QUERY, Integer.class, username);
        return count > 0;
    }
}
