package com.example.hibernateNew;

import com.example.hibernateNew.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired StudentDao studentDao;

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Cacheable("student")
    @Override
    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student saveOrUpdate(Student student) {
        return studentDao.saveOrUpdate(student);
    }

    @Override
    public boolean bulkAddition(Integer size) {
        return studentDao.bulkAddition(size);
    }

    @Override
    public boolean bulkAdditionWithBatch(Integer size) {
        return studentDao.bulkAdditionWithBatch(size);
    }


    @Override
    public boolean delete(Integer id) {
        return studentDao.removeStudentById(id);
    }
}
