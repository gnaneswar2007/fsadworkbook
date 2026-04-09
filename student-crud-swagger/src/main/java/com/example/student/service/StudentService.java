package com.example.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentService {

@Autowired
private StudentRepository repo;

public Student saveStudent(Student student){
return repo.save(student);
}

public List<Student> getAllStudents(){
return repo.findAll();
}

public Student getStudentById(Long id){
return repo.findById(id).orElse(null);
}

public Student updateStudent(Long id, Student student){

Student s = repo.findById(id).orElse(null);

if(s != null){
s.setName(student.getName());
s.setEmail(student.getEmail());
s.setCourse(student.getCourse());
return repo.save(s);
}

return null;
}

public void deleteStudent(Long id){
repo.deleteById(id);
}

}