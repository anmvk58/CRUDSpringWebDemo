package com.anmv.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Column(name = "DepartmentId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String departmentName;

    public Department() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
