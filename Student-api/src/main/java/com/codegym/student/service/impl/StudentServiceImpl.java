package com.codegym.student.service.impl;

import com.codegym.student.model.Student;
import com.codegym.student.repository.StudentRepository;
import com.codegym.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public Iterable<Student> findStudentByAddress(String address) {
        return studentRepository.findStudentByAddress(address);
    }

    @Override
    public List<Student> findAllByAge(Long age, Pageable pageable) {
        return null;
    }


}
