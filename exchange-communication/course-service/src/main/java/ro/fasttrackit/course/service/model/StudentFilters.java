package ro.fasttrackit.course.service.model;

import lombok.Value;

@Value
public class StudentFilters {
    String name;
    String studentId;
    Integer age;
    Integer minAge;
    Integer maxAge;
}
