package ro.fasttrackit.course.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.course.service.model.entity.CourseStudent;
import ro.fasttrackit.course.service.repository.CourseStudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseStudentService {
    private final CourseStudentRepository courseStudentRepository;

    public CourseStudent enrollStudentToCourse(String courseId, CourseStudent courseStudent) {
        courseStudent.setCourseId(courseId);
        return courseStudentRepository.save(courseStudent);
    }

    public List<String> studentsByCourse(String courseId) {
        List<CourseStudent> studentsByCourseId = courseStudentRepository.findAllByCourseId(courseId);
        return studentsByCourseId.stream()
                .map(CourseStudent::getStudentId)
                .collect(Collectors.toList());
    }
}
