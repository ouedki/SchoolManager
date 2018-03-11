package com.SchoolManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolManager.models.Role;

public interface RoleRepositoryDao extends JpaRepository<Role, String>{

}
