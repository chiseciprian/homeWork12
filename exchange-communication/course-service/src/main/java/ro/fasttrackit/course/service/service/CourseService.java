package ro.fasttrackit.course.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.course.service.controller.exception.EntityNotFoundException;
import ro.fasttrackit.course.service.model.domain.request.CourseRequestDto;
import ro.fasttrackit.course.service.model.domain.response.CourseResponseDto;
import ro.fasttrackit.course.service.model.entity.Course;
import ro.fasttrackit.course.service.repository.CourseRepository;
import ro.fasttrackit.course.service.service.mapper.CourseMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseResponseDto> getAll() {
        return courseMapper.mapEntitiesListToResponseDto(courseRepository.findAll());
    }

    public CourseResponseDto addCourse(CourseRequestDto request) {
        Course course = courseRepository.save(courseMapper.mapRequestDtoToEntity(request));
        return courseMapper.mapEntityToResponseDto(course);
    }

    public CourseResponseDto getCourse(String courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course with id " + courseId + " not found"));
        return courseMapper.mapEntityToResponseDto(course);
    }
}
