package com.plg.springvalidationexample.repository;

import com.plg.springvalidationexample.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
