package ec.edu.ups.coursesapp.repository;

import ec.edu.ups.coursesapp.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {
    List<Course> findByCategory(String category);
}
