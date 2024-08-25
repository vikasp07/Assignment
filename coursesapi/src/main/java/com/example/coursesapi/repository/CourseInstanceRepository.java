package com.example.coursesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coursesapi.model.CourseInstance;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
}
