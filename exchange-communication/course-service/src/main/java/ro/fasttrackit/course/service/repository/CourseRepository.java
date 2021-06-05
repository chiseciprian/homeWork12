package ro.fasttrackit.course.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.course.service.model.entity.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    Course findByCourseId(String courseId);
}
