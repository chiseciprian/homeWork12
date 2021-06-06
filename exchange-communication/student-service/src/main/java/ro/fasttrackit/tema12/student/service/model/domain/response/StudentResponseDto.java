package ro.fasttrackit.tema12.student.service.model.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseDto {
    private String studentId;
    private String name;
    private int age;
}
