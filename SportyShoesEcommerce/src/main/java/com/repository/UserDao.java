package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beans.Users;

@Repository
public interface UserDao extends CrudRepository<Users, String>{

}
