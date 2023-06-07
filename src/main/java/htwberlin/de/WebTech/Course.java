package htwberlin.de.WebTech;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "course_id")
    Set<StudentGrade> grades;
   private String name;


    public Course( String name) {

        this.name = name;
    }

    public Course(Long id) {
        this.id = id;
    }

    public Course() {

    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long courseID) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + id +
                ", courseName='" + name + '\'' +
                '}';
    }
}
