package com.loginapp.loginapp.dao;

import com.loginapp.loginapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String>{ }
