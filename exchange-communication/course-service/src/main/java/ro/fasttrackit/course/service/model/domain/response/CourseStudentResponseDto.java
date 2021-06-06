package ro.fasttrackit.course.service.model.domain.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseStudentResponseDto {
    private String courseStudentId;
    private String courseId;
    private String studentId;
    private int grade;
}
