package ro.fasttrackit.course.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.course.service.controller.exception.EntityNotFoundException;
import ro.fasttrackit.course.service.model.entity.Course;
import ro.fasttrackit.course.service.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    List<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping(path = "{courseId}")
    Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course with id " + courseId + " not found"));
    }
}
