package com.example.courseapi.controller;

import com.example.courseapi.model.Course;
import com.example.courseapi.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")   // Base URL: http://localhost:8080/courses
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // -----------------------------------------------------
    // ADD COURSE
    // Method: POST
    // URL: http://localhost:8080/courses
    // -----------------------------------------------------
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        Course saved = courseService.addCourse(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // -----------------------------------------------------
    // GET ALL COURSES
    // Method: GET
    // URL: http://localhost:8080/courses
    // -----------------------------------------------------
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {

        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // -----------------------------------------------------
    // GET COURSE BY ID
    // Method: GET
    // URL: http://localhost:8080/courses/{id}
    // Example: http://localhost:8080/courses/1
    // -----------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {

        Course course = courseService.getCourseById(id);

        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");
        }

        return ResponseEntity.ok(course);
    }

    // -----------------------------------------------------
    // UPDATE COURSE
    // Method: PUT
    // URL: http://localhost:8080/courses/{id}
    // Example: http://localhost:8080/courses/1
    // -----------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody Course course) {

        Course updated = courseService.updateCourse(id, course);

        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");
        }

        return ResponseEntity.ok(updated);
    }

    // -----------------------------------------------------
    // DELETE COURSE
    // Method: DELETE
    // URL: http://localhost:8080/courses/{id}
    // Example: http://localhost:8080/courses/1
    // -----------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        boolean deleted = courseService.deleteCourse(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");
        }

        return ResponseEntity.ok("Course deleted successfully");
    }

    // -----------------------------------------------------
    // SEARCH COURSE BY TITLE
    // Method: GET
    // URL: http://localhost:8080/courses/search/{title}
    // Example: http://localhost:8080/courses/search/java
    // -----------------------------------------------------
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourses(@PathVariable String title) {

        return ResponseEntity.ok(courseService.searchByTitle(title));
    }
}