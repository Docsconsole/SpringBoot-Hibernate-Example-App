package com.docsconsole.tutorials.service;

import com.docsconsole.tutorials.dao.CourseDAOImpl;
import com.docsconsole.tutorials.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CourseServiceImpl {

    @Autowired
    CourseDAOImpl courseDAOImpl;


    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.ok(courseDAOImpl.getAllCourses());
    }

    public ResponseEntity<?> saveCourse(Course course) {
        String status = courseDAOImpl.saveCourse(course);
        return ResponseEntity.ok(status);
    }

    public ResponseEntity<?> deleteCourse(Course course) {
        Boolean isCourseDeleted = courseDAOImpl.deleteCourse(course);
        Map map = new HashMap();
        map.put("Deleted", isCourseDeleted);
        return ResponseEntity.ok(map);
    }
}
