package ro.fasttrackit.course.service.model.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseStudentRequestDto {
    private String studentId;
    private int grade;
}
