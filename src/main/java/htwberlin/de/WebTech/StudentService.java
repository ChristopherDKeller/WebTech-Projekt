package htwberlin.de.WebTech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public Student save(Student student) {
        return repo.save(student);
    }

    public Student get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Student> getAll() {
        Iterable<Student> iterator = repo.findAll();
        List<Student> students = new ArrayList<Student>();
        for (Student student : iterator)  students.add(student);
        return students;
    }
}
