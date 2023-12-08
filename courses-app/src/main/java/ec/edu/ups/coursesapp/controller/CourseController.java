package ec.edu.ups.coursesapp.controller;

import ec.edu.ups.coursesapp.model.Course;
import ec.edu.ups.coursesapp.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course newCourse = courseService.createCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable String id) {
        Optional<Course> course = courseService.getCourse(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Course>> getCoursesByCategory(@PathVariable String category) {
        List<Course> courses = courseService.getCoursesByCategory(category);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses() {
        try {
            List<Course> courses = courseService.getAllCourses();
            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al obtener todos los cursos: " + e.getMessage());
        }
    }

    
    

}
