package htwberlin.de.WebTech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository repo;

    public Course save(Course course) {
        return repo.save(course);
    }

    public Course get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Course> getAll() {
        Iterable<Course> iterator = repo.findAll();
        List<Course> course = new ArrayList<Course>();
        for (Course c : iterator)  course.add(c);
        return course;
    }
    public void delete(Long id) {

        repo.deleteById(id);
    }


}
