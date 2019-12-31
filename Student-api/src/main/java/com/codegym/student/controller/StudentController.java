package com.codegym.student.controller;

import com.codegym.student.model.Student;
import com.codegym.student.search.SearchByAddress;
import com.codegym.student.search.SearchByName;
import com.codegym.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("student")
    public ResponseEntity<?> listStudent(){
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("student")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("student/{id}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student, @PathVariable Long id){
        Optional<Student> student1 = studentService.findById(id);
        if (!student1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student1.get().setName(student.getName());
        student1.get().setAge(student.getAge());
        student1.get().setAddress(student.getAddress());
        studentService.save(student1.get());
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("student/search-by-name")
    public ResponseEntity<?> searchByName(@RequestBody SearchByName searchByName){
        if (searchByName.getName() == "" || searchByName.getName() == null){
            List<Student> students = (List<Student>) studentService.findAll();
            if (students.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }

        List<Student> students = (List<Student>) studentService.findStudentByName(searchByName.getName());
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("student/search-by-address")
    public ResponseEntity<?> searchByAddress(@RequestBody SearchByAddress searchByAddress){
        if (searchByAddress.getAddress() == "" || searchByAddress.getAddress() == null){
            List<Student> students = (List<Student>) studentService.findAll();
            if (students.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }

        List<Student> students = (List<Student>) studentService.findStudentByAddress(searchByAddress.getAddress());
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
