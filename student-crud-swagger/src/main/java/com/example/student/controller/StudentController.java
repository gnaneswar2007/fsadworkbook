package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

@Autowired
private StudentService service;

@Operation(summary="Add new student")
@ApiResponse(responseCode="200", description="Student added successfully")
@PostMapping
public Student addStudent(@RequestBody Student student){
return service.saveStudent(student);
}

@Operation(summary="Get all students")
@ApiResponse(responseCode="200", description="Students retrieved successfully")
@GetMapping
public List<Student> getAllStudents(){
return service.getAllStudents();
}

@Operation(summary="Get student by ID")
@ApiResponse(responseCode="200", description="Student found")
@GetMapping("/{id}")
public Student getStudent(@PathVariable Long id){
return service.getStudentById(id);
}

@Operation(summary="Update student")
@ApiResponse(responseCode="200", description="Student updated successfully")
@PutMapping("/{id}")
public Student updateStudent(@PathVariable Long id,
@RequestBody Student student){

return service.updateStudent(id, student);
}

@Operation(summary="Delete student")
@ApiResponse(responseCode="200", description="Student deleted successfully")
@DeleteMapping("/{id}")
public void deleteStudent(@PathVariable Long id){
service.deleteStudent(id);
}

}