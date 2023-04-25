package htwberlin.de.WebTech;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {
        @Autowired
        StudentService service;
        Logger logger = LoggerFactory.getLogger(StudentController.class);

        @PostMapping("/students")
        public Student createStudent(@RequestBody Student student) {
            return service.save(student);
        }

        @GetMapping("/students/{id}")
        public Student getStudent(@PathVariable String id) {
            logger.info("GET request on route things with {}", id);
            Long studentId = Long.parseLong(id);
            return service.get(studentId);
        }

        @GetMapping("/students")
        public List<Student> getAllStudents() {
            return service.getAll();
        }

    }

