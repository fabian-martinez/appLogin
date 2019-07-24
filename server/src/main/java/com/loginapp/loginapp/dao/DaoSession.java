package com.loginapp.loginapp.dao;

import com.loginapp.loginapp.model.Session;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DaoSession {

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void createSession() throws Exception {
        try {
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName("org.h2.Driver");
            ds.setUrl("jdbc:h2:mem:testdb");
            ds.setUsername("sa");
            ds.setPassword("");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
            jdbcTemplate.update("INSERT INTO session (SESSION_ID, EXPIRATION_DATE, STATE, USER_ACTIVE) VALUES(?,?,?,?)",
                    session.getSessionId(),session.getExpirationDate(),session.isState(),session.getUserActive());
        }catch (Exception ex){
            throw new Exception("Invalid Access.");
        }

    }

    public Session getSessionById(String sessionId){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:testdb");
        ds.setUsername("sa");
        ds.setPassword("");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        return jdbcTemplate.queryForObject("select * from session where session_id=?", new Object[] { sessionId },
                new BeanPropertyRowMapper<Session>(Session.class));
    }
}
