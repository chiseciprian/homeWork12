package ro.fasttrackit.tema12.student.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.tema12.student.service.model.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
