package ro.fasttrackit.course.service.service.mapper;

import org.springframework.stereotype.Service;
import ro.fasttrackit.course.service.model.domain.request.CourseRequestDto;
import ro.fasttrackit.course.service.model.domain.response.CourseResponseDto;
import ro.fasttrackit.course.service.model.entity.Course;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseMapper {

    public List<CourseResponseDto> mapEntitiesListToResponseDto(List<Course> entities) {
        return entities.stream()
                .map(this::mapEntityToResponseDto)
                .collect(Collectors.toList());
    }

    public CourseResponseDto mapEntityToResponseDto(Course entity) {
        CourseResponseDto response = new CourseResponseDto();
        response.setCourseId(entity.getCourseId());
        response.setDiscipline(entity.getDiscipline());
        return response;
    }

    public Course mapRequestDtoToEntity(CourseRequestDto request) {
        Course course = new Course();
        course.setDiscipline(request.getDiscipline());
        return course;
    }
}
