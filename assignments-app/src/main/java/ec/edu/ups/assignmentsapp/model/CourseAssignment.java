package ec.edu.ups.assignmentsapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "course_assignments")
public class CourseAssignment {
    
    @Id
    private String id;
    private String userId;
    private String courseId;

    // Constructor por defecto
    public CourseAssignment() {
    }

    // Constructor con parámetros
    public CourseAssignment(String userId, String courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    // Getter y setter para id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter y setter para userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter y setter para courseId
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    // Método toString para representar el objeto como cadena
    @Override
    public String toString() {
        return "CourseAssignment{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}