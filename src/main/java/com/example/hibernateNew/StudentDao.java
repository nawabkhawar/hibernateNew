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
        for(int i=0;i<100;i++){
            Student student1 = new Student("nawab"+i,i,"email"+i);
        }
        boolean saving  = (boolean)session.save(student);
        return saving;
    }

    public Student getStudentById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        Student student2 = session.get(Student.class, 16);
        return student;
    }

    public boolean removeStudentById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        try{
            session.remove(student);
            return true;
        }catch(Exception e){
            return false;
        }

    }


    public Student saveOrUpdate(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
        student.setAge(18);
       // session.flush();
        return student;
    }

    public boolean bulkAddition(Integer size) {
        Session session = this.sessionFactory.getCurrentSession();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Student student1 = new Student("nawab" + i, i, "email" + i);
            session.save(student1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("totalTime:" + (endTime-startTime));
        return true;
    }

    public boolean bulkAdditionWithBatch(Integer size) {
        Session session = this.sessionFactory.getCurrentSession();
        long startTime = System.currentTimeMillis();
        int batchSize =25;
        for (int i = 0; i < size; i++) {
            Student student1 = new Student("nawab" + i, i, "email" + i);
            session.save(student1);
            if(i >0 && i%batchSize==0){
                session.clear();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("totalTime:" + (endTime-startTime));
        return true;
    }

    public List<Student> getAllStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from Student").list();
        List<Student> students2 = session.createQuery("from Student").list();
        return students;

    }
}
