package com.example.hibernateNew;

import com.example.hibernateNew.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

   @Autowired
    StudentService studentService;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/student/getAllStudents")
    private List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }
    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("student/getStudent/{id}")
    private Student getStudent(@PathVariable("id") int id)
    {
        return studentService.getStudentById(id);
    }
    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/student/removeStudent/{id}")
    private boolean deleteStudent(@PathVariable("id") int id)
    {
        return studentService.delete(id);

    }
    //creating post mapping that post the student detail in the database
    @PostMapping("student/addStudent")
    private int saveStudent(@RequestBody Student student)
    {
        studentService.saveOrUpdate(student);
        return student.getId();
    }

    @GetMapping("/student/bulkAddition/{size}")
    private boolean bulkAddition(@PathVariable("size") Integer size)
    {
        return studentService.bulkAddition(size);
    }

    @GetMapping("/student/bulkAdditionWithBatch/{size}")
    private boolean bulkAdditionWithBatch(@PathVariable("size") Integer size)
    {
        return studentService.bulkAdditionWithBatch(size);
    }
}
