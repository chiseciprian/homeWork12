package ro.fasttrackit.course.service.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.course.service.model.entity.CourseStudent;

import java.util.List;

@Repository
public interface CourseStudentRepository extends MongoRepository<CourseStudent, String> {
    List<CourseStudent> findAllByCourseId(String courseId);

    void deleteAllByStudentId(String studentId);
}
