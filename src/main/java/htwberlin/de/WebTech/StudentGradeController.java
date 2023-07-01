package htwberlin.de.WebTech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentGradeController {
    @Autowired
    StudentGradeService service;
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/grades")
    public StudentGrade createStudentGrade(@RequestBody StudentGrade studentGrade) {
        return service.save(studentGrade);
    }

    @GetMapping("/grades")
    public List<StudentGrade> getAllGrades() {

        return service.getAll();
    }

    @GetMapping("/grades/{studentId}/{courseId}")
    public StudentGrade getStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        logger.info("GET request on route grades with studentId: {} and courseId: {}", studentId, courseId);
        StudentGradeKey grade = new StudentGradeKey(studentId, courseId);
        return service.get(grade);
    }

    @DeleteMapping("/grades/delete/{studentId}/{courseId}")
    public void deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
        logger.info("DELETE request on route grades with studentId: {} and courseId: {}", studentId, courseId);
        StudentGradeKey id = new StudentGradeKey(studentId, courseId);
        service.delete(id);
        logger.info("SUCCESS");
    }


}
