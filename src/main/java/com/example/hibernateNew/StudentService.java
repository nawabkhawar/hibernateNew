package com.example.hibernateNew;

import com.example.hibernateNew.entity.Student;

import java.util.List;


public interface StudentService
    {
        public boolean addStudent(Student student);

        public Student getStudentById(Integer id);

        public List<Student> getAllStudent();

        public Student saveOrUpdate(Student student);

        public boolean delete(Integer id);
    }


