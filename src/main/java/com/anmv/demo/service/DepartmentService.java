package com.anmv.demo.service;

import com.anmv.demo.entity.Department;
import com.anmv.demo.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> getAllDepartments() {
        return repository.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int id) {
        return repository.getDepartmentById(id);
    }

    @Override
    public void createNewDepartment(Department department) {
        repository.createNewDepartment(department);
    }

    @Override
    public void updateDepartment(int id, String newName) {
        repository.updateDepartment(id, newName);
    }

    @Override
    public void updateDepartment(Department department) {
        repository.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(int id) {
        repository.deleteDepartment(id);
    }
}
