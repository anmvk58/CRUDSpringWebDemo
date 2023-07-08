package com.anmv.demo.controller;

import com.anmv.demo.entity.Department;
import com.anmv.demo.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping
    public List<Department> getAllDepartments(){
        return service.getAllDepartments();
    }

    @GetMapping(value = "/{id}")
    public Department getDepartmentByID(@PathVariable(name = "id") int id) {
        return service.getDepartmentById(id);
    }

    @PostMapping
    public void createNewDepartment(@RequestBody Department department){
        service.createNewDepartment(department);
    }

    @PutMapping(value = "/{id}")
    public void updateDepartment(@PathVariable(name = "id") int id, @RequestBody String newName){
        service.updateDepartment(id, newName);
    }

    @PutMapping(value = "/update/{id}")
    public void updateDepartment(@PathVariable(name = "id") int id, @RequestBody Department department){
        department.setDepartmentId(id);
        service.updateDepartment(department);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable(name = "id") int id){
        service.deleteDepartment(id);
    }
}
