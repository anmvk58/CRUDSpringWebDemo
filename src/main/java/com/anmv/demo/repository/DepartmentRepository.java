package com.anmv.demo.repository;

import com.anmv.demo.entity.Department;
import com.anmv.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository{
    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        this.hibernateUtils = HibernateUtils.getInstance();
    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Query<Department> query = session.createQuery("FROM Department");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Department getDepartmentById(int id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            Department department = session.get(Department.class, id);
            return department;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void createNewDepartment(Department department) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // create hql query
            session.save(department);
            System.out.println("Create suceess !");

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateDepartment(int id, String newName) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get department
            Department department = (Department) session.load(Department.class, id);
            // update
            department.setDepartmentName(newName);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateDepartment(Department department) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // delete
            session.update(department);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteDepartment(int id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            // get department
            Department department = (Department) session.load(Department.class, id);
            // delete
            session.delete(department);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
