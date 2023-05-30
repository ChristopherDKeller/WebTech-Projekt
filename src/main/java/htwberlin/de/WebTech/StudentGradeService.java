package htwberlin.de.WebTech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentGradeService {

    @Autowired
    StudentGradeRepository repo;

    public StudentGrade save(StudentGrade studentGrade) {
        return repo.save(studentGrade);
    }

    public StudentGrade get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<StudentGrade> getAll() {
        Iterable<StudentGrade> iterator = repo.findAll();
        List<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
        for (StudentGrade studentGrade : iterator)  studentGrades.add(studentGrade);
        return studentGrades;
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
