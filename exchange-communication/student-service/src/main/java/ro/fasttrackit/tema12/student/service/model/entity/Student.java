package ro.fasttrackit.tema12.student.service.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    private String studentId;
    @NonNull
    private String name;
    @NonNull
    private int age;
}
