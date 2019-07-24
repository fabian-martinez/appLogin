package com.loginapp.loginapp.dao;

import com.loginapp.loginapp.model.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session,String> {}