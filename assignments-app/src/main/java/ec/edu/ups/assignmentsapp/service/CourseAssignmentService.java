package ec.edu.ups.assignmentsapp.service;

import ec.edu.ups.assignmentsapp.model.Course;
import ec.edu.ups.assignmentsapp.model.CourseAssignment;
import ec.edu.ups.assignmentsapp.model.User;
import ec.edu.ups.assignmentsapp.repository.CourseAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAssignmentService {

    @Autowired
    private CourseAssignmentRepository assignmentRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String USER_SERVICE_URL = "http://user-service/api/users/";
    private final String COURSE_SERVICE_URL = "http://course-service/api/courses/";

    public CourseAssignment assignCourseToUser(String userId, String courseId) {
        // Verifica que el usuario exista
        ResponseEntity<User> userResponse = restTemplate.getForEntity(USER_SERVICE_URL + userId, User.class);
        
        // Verifica que el curso exista
        ResponseEntity<Course> courseResponse = restTemplate.getForEntity(COURSE_SERVICE_URL + courseId, Course.class);

        if (userResponse.getStatusCode() == HttpStatus.OK && courseResponse.getStatusCode() == HttpStatus.OK) {
            CourseAssignment assignment = new CourseAssignment(userId, courseId);
            return assignmentRepository.save(assignment);
        } else {
            // Maneja el caso en que el usuario o el curso no existan
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario o curso no existen");
        }
    }

    public List<CourseAssignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<CourseAssignment> getAssignmentById(String id) {
        return assignmentRepository.findById(id);
    }

    public CourseAssignment updateAssignment(String id, CourseAssignment updatedAssignment) {
        return assignmentRepository.findById(id)
                .map(assignment -> {
                    assignment.setUserId(updatedAssignment.getUserId());
                    assignment.setCourseId(updatedAssignment.getCourseId());
                    return assignmentRepository.save(assignment);
                })
                .orElseGet(() -> {
                    updatedAssignment.setId(id);
                    return assignmentRepository.save(updatedAssignment);
                });
    }

    public void deleteAssignment(String id) {
        assignmentRepository.deleteById(id);
    }

    public List<CourseAssignment> getAssignmentsByUserId(String userId) {
        return assignmentRepository.findByUserId(userId);
    }

}