package com.anmv.demo.repository;

import com.anmv.demo.entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    List<Department> getAllDepartments();

    Department getDepartmentById(int id);

    void createNewDepartment(Department department);

    void updateDepartment(int id, String newName);

    void updateDepartment(Department department);

    void deleteDepartment(int id);
}
