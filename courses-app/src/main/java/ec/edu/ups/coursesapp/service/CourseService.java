package ec.edu.ups.coursesapp.service;

import ec.edu.ups.coursesapp.model.Course;
import ec.edu.ups.coursesapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    public Course updateCourse(String id, Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCoursesByCategory(String category) {
        return courseRepository.findByCategory(category);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    

}
