package ro.fasttrackit.course.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.course.service.model.domain.request.CourseStudentRequestDto;
import ro.fasttrackit.course.service.model.domain.response.CourseStudentResponseDto;
import ro.fasttrackit.course.service.service.CourseStudentService;

import java.util.List;

@RestController
@RequestMapping("course")
@RequiredArgsConstructor
public class CourseStudentController {
    private final CourseStudentService courseStudentService;

    @GetMapping(path = "{courseId}/students")
    List<String> studentsByCourse(@PathVariable String courseId) {
        return courseStudentService.studentsByCourse(courseId);
    }

    @PostMapping(path = "{courseId}/students")
    CourseStudentResponseDto enrollStudentToCourse(@PathVariable String courseId, @RequestBody CourseStudentRequestDto request) {
        return courseStudentService.enrollStudentToCourse(courseId, request);
    }
}
