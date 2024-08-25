package com.example.coursesapi.service;

import com.example.coursesapi.model.CourseInstance;
import com.example.coursesapi.repository.CourseInstanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInstanceService {

    private final CourseInstanceRepository courseInstanceRepository;

    public CourseInstanceService(CourseInstanceRepository courseInstanceRepository) {
        this.courseInstanceRepository = courseInstanceRepository;
    }

    public List<CourseInstance> getAllCourseInstances() {
        return courseInstanceRepository.findAll();
    }

    public CourseInstance getCourseInstanceById(Long id) {
        return courseInstanceRepository.findById(id).orElse(null);
    }

    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    public CourseInstance updateCourseInstance(Long id, CourseInstance courseInstance) {
        CourseInstance existingInstance = courseInstanceRepository.findById(id).orElse(null);
        if (existingInstance != null) {
            existingInstance.setCourse(courseInstance.getCourse());
            existingInstance.setSemester(courseInstance.getSemester());
            existingInstance.setAcademicYear(courseInstance.getAcademicYear()); // Updated setter method name
            return courseInstanceRepository.save(existingInstance);
        } else {
            return null;
        }
    }

    public void deleteCourseInstance(Long id) {
        courseInstanceRepository.deleteById(id);
    }
}
