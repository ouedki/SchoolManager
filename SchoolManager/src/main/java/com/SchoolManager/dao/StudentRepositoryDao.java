package com.SchoolManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolManager.models.Student;

public interface StudentRepositoryDao extends JpaRepository<Student, Long> {

}
