package com.example.coursesapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coursesapi.model.CourseInstance;
import com.example.coursesapi.service.CourseInstanceService;

@RestController
@RequestMapping("/api/course-instances")
public class CourseInstanceController {

    private final CourseInstanceService courseInstanceService;

    public CourseInstanceController(CourseInstanceService courseInstanceService) {
        this.courseInstanceService = courseInstanceService;
    }

    @GetMapping
    public ResponseEntity<List<CourseInstance>> getAllCourseInstances() {
        return new ResponseEntity<>(courseInstanceService.getAllCourseInstances(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseInstance> getCourseInstanceById(@PathVariable Long id) {
        return new ResponseEntity<>(courseInstanceService.getCourseInstanceById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance courseInstance) {
        return new ResponseEntity<>(courseInstanceService.createCourseInstance(courseInstance), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseInstance> updateCourseInstance(@PathVariable Long id, @RequestBody CourseInstance courseInstance) {
        return new ResponseEntity<>(courseInstanceService.updateCourseInstance(id, courseInstance), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseInstance(@PathVariable Long id) {
        courseInstanceService.deleteCourseInstance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
