package com.plg.springvalidationexample.model.dto.repository;

import java.util.UUID;

import com.plg.springvalidationexample.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

}
