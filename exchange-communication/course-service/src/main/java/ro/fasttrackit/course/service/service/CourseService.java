package ro.fasttrackit.course.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ro.fasttrackit.course.service.model.entity.Course;
import ro.fasttrackit.course.service.repository.CourseRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourse(String courseId) {
        return courseRepository.findById(courseId);
    }
}
