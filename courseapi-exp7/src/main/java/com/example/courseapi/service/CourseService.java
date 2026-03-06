package com.example.courseapi.service;

import com.example.courseapi.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    // Add Course
    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courses;
    }

    // Get course by id
    public Course getCourseById(int id) {
        return courses.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update course
    public Course updateCourse(int id, Course updatedCourse) {

        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return c;
            }
        }
        return null;
    }

    // Delete course
    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getCourseId() == id);
    }

    // Search by title
    public List<Course> searchByTitle(String title) {

        List<Course> result = new ArrayList<>();

        for (Course c : courses) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }

        return result;
    }
}