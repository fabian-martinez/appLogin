package com.loginapp.loginapp.dao;

import com.loginapp.loginapp.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DaoUser {

    private User user;

    public User getUser() {
        if (user != null){
        return user;}
        else {
            return user = new User();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void createUser(User user) throws Exception {
        try {
            this.user = user;
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName("org.h2.Driver");
            ds.setUrl("jdbc:h2:mem:testdb");
            ds.setUsername("sa");
            ds.setPassword("");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
            jdbcTemplate.update("INSERT INTO user (USER_NAME, LASTNAME, NAME, PASS, SALT) VALUES(?,?,?,?,?)",
                    user.getUserName(),user.getLastName(),user.getName(),user.getPass(),user.getSalt());
        }catch (Exception ex){
            throw new Exception("Invalid Access.");
        }
    }

    public User getUserByUsername(String userName){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:testdb");
        ds.setUsername("sa");
        ds.setPassword("");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        return jdbcTemplate.queryForObject("select * from user where user_name=?", new Object[] { userName },
                new BeanPropertyRowMapper<User>(User.class));
    }
}
