package ro.fasttrackit.course.service.service.mapper;

import org.springframework.stereotype.Service;
import ro.fasttrackit.course.service.model.domain.request.CourseStudentRequestDto;
import ro.fasttrackit.course.service.model.domain.response.CourseStudentResponseDto;
import ro.fasttrackit.course.service.model.entity.CourseStudent;

@Service
public class CourseStudentMapper {

    public CourseStudent mapRequestDtoToEntity(String courseId, CourseStudentRequestDto request) {
        CourseStudent courseStudent = new CourseStudent();
        courseStudent.setCourseId(courseId);
        courseStudent.setStudentId(request.getStudentId());
        courseStudent.setGrade(request.getGrade());
        return courseStudent;
    }

    public CourseStudentResponseDto mapEntityToResponseDto(CourseStudent courseStudent) {
        CourseStudentResponseDto courseStudentResponseDto = new CourseStudentResponseDto();
        courseStudentResponseDto.setCourseStudentId(courseStudent.getCourseStudentId());
        courseStudentResponseDto.setStudentId(courseStudent.getStudentId());
        courseStudentResponseDto.setCourseId(courseStudent.getCourseId());
        courseStudentResponseDto.setGrade(courseStudent.getGrade());
        return courseStudentResponseDto;
    }
}
