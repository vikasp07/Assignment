package com.example.coursesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coursesapi.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
