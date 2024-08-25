package com.example.coursesapi;

import com.example.coursesapi.model.Course;
import com.example.coursesapi.model.CourseInstance;
import com.example.coursesapi.repository.CourseInstanceRepository;
import com.example.coursesapi.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final CourseInstanceRepository courseInstanceRepository;

    public DataLoader(CourseRepository courseRepository, CourseInstanceRepository courseInstanceRepository) {
        this.courseRepository = courseRepository;
        this.courseInstanceRepository = courseInstanceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert dummy data for courses
        Course cs101 = new Course();
        cs101.setTitle("Computer Science 101");
        cs101.setDescription("Introduction to Computer Science");
        courseRepository.save(cs101);

        Course math101 = new Course();
        math101.setTitle("Mathematics 101");
        math101.setDescription("Introduction to Mathematics");
        courseRepository.save(math101);

        Course physics101 = new Course();
        physics101.setTitle("Physics 101");
        physics101.setDescription("Introduction to Physics");
        courseRepository.save(physics101);

        // Insert dummy data for course instances
        CourseInstance instance1 = new CourseInstance();
        instance1.setCourse(cs101);
        instance1.setSemester("Fall");
        instance1.setAcademicYear("2023-2024");
        courseInstanceRepository.save(instance1);

        CourseInstance instance2 = new CourseInstance();
        instance2.setCourse(math101);
        instance2.setSemester("Spring");
        instance2.setAcademicYear("2023-2024");
        courseInstanceRepository.save(instance2);

        CourseInstance instance3 = new CourseInstance();
        instance3.setCourse(physics101);
        instance3.setSemester("Summer");
        instance3.setAcademicYear("2023-2024");
        courseInstanceRepository.save(instance3);

        CourseInstance instance4 = new CourseInstance();
        instance4.setCourse(cs101);
        instance4.setSemester("Winter");
        instance4.setAcademicYear("2022-2023");
        courseInstanceRepository.save(instance4);

        CourseInstance instance5 = new CourseInstance();
        instance5.setCourse(math101);
        instance5.setSemester("Fall");
        instance5.setAcademicYear("2022-2023");
        courseInstanceRepository.save(instance5);
    }
}
