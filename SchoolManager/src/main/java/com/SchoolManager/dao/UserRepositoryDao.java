package com.SchoolManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolManager.models.User;

public interface UserRepositoryDao extends JpaRepository<User, String>{

}
