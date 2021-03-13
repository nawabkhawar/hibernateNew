package com.example.hibernateNew;

import com.example.hibernateNew.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public boolean addStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
         boolean saving  = (boolean)session.save(student);
        return saving;
    }

    public Student getStudentById(Integer id) {
        return null;
    }

    public Student saveOrUpdate(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
       // session.flush();
        return student;
    }

    public List<Student> getAllStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from Student").list();
        return students;
    }
}
