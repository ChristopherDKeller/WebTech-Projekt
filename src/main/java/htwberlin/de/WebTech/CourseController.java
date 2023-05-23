package htwberlin.de.WebTech;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService service;
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/course")
    public Course createCourse(@RequestBody Course course) {

        return service.save(course);
    }
    @GetMapping("/course")
    public List<Course> getAllCourses() {

        return service.getAll();
    }

}
