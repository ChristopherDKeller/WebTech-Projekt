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

}
