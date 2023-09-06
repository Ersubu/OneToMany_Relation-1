package com.dakr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dakr.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}