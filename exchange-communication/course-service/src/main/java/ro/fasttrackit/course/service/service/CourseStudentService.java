package ro.fasttrackit.course.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.course.service.model.domain.request.CourseStudentRequestDto;
import ro.fasttrackit.course.service.model.domain.response.CourseStudentResponseDto;
import ro.fasttrackit.course.service.model.entity.CourseStudent;
import ro.fasttrackit.course.service.repository.CourseStudentRepository;
import ro.fasttrackit.course.service.service.mapper.CourseStudentMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseStudentService {
    private final CourseStudentRepository courseStudentRepository;
    private final CourseStudentMapper courseStudentMapper;

    public CourseStudentResponseDto enrollStudentToCourse(String courseId, CourseStudentRequestDto request) {
        CourseStudent courseStudent = courseStudentRepository.save(courseStudentMapper.mapRequestDtoToEntity(courseId, request));
        return courseStudentMapper.mapEntityToResponseDto(courseStudent);
    }

    public List<String> studentsByCourse(String courseId) {
        List<CourseStudent> studentsByCourseId = courseStudentRepository.findAllByCourseId(courseId);
        return studentsByCourseId.stream()
                .map(CourseStudent::getStudentId)
                .collect(Collectors.toList());
    }
}
