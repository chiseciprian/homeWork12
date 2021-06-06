package ro.fasttrackit.course.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.course.service.model.domain.request.CourseRequestDto;
import ro.fasttrackit.course.service.model.domain.response.CourseResponseDto;
import ro.fasttrackit.course.service.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    List<CourseResponseDto> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    CourseResponseDto addCourse(@RequestBody CourseRequestDto request) {
        return courseService.addCourse(request);
    }

    @GetMapping(path = "{courseId}")
    CourseResponseDto getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }
}
