package com.student.controller;

import com.student.model.Student;
import com.student.exception.StudentNotFoundException;
import com.student.exception.InvalidInputException;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    // URL: http://localhost:8080/student/{id}

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {

        if (id < 0) {
            throw new InvalidInputException("Student ID cannot be negative");
        }

        if (id != 1) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return new Student(1, "Rahul", "Computer Science");
    }
}