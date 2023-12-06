package ec.edu.ups.assignmentsapp.controller;

import ec.edu.ups.assignmentsapp.model.CourseAssignment;
import ec.edu.ups.assignmentsapp.service.CourseAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class CourseAssignmentController {

    @Autowired
    private CourseAssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<CourseAssignment> createAssignment(@RequestBody CourseAssignment assignment) {
        CourseAssignment newAssignment = assignmentService.assignCourseToUser(
                assignment.getUserId(), assignment.getCourseId());
        return ResponseEntity.ok(newAssignment);
    }

    @GetMapping
    public ResponseEntity<List<CourseAssignment>> getAllAssignments() {
        List<CourseAssignment> assignments = assignmentService.getAllAssignments();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseAssignment> getAssignmentById(@PathVariable String id) {
        return assignmentService.getAssignmentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseAssignment> updateAssignment(@PathVariable String id, 
                                                             @RequestBody CourseAssignment assignment) {
        CourseAssignment updatedAssignment = assignmentService.updateAssignment(id, assignment);
        return ResponseEntity.ok(updatedAssignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable String id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.ok().build();
    }
}