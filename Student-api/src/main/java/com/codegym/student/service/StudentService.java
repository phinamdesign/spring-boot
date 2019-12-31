package com.codegym.student.service;

import com.codegym.student.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student> findById(Long id);

    Iterable<Student> findAll();

    Student save(Student student);

    void delete(Long id);

    Iterable<Student> findStudentByName(String name);

    Iterable<Student> findStudentByAddress(String address);

    List<Student> findAllByAge(Long age, Pageable pageable);
}
