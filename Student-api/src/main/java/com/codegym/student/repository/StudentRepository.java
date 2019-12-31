package com.codegym.student.repository;

import com.codegym.student.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Iterable<Student> findStudentByName(String name);
    Iterable<Student> findStudentByAddress(String address);
    List<Student> findAllByAge(Long age, Pageable pageable);
}

