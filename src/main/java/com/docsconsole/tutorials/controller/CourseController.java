package com.docsconsole.tutorials.controller;


import com.docsconsole.tutorials.model.Course;
import com.docsconsole.tutorials.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course/api")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<?> saveCourse(@RequestBody Course course) {
        try {
            return courseServiceImpl.saveCourse(course);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCourse(@RequestBody Course course) {
        try {
            return courseServiceImpl.deleteCourse(course);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/all")
    public ResponseEntity<?> getAllCourses() {
        try {
            return courseServiceImpl.getAllCourses();
        } catch (Exception ex) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}