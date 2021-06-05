package ro.fasttrackit.tema12.student.service.model;

import lombok.Value;

@Value
public class StudentFilters {
    String name;
    String studentId;
    Integer age;
    Integer minAge;
    Integer maxAge;
}
