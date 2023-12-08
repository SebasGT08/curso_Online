package ec.edu.ups.assignmentsapp.repository;

import ec.edu.ups.assignmentsapp.model.CourseAssignment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseAssignmentRepository extends MongoRepository<CourseAssignment, String> {
    List<CourseAssignment> findByUserId(String userId);
}
