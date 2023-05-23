package htwberlin.de.WebTech;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long courseID;

    @ManyToMany(mappedBy = "isInCourse")
    Set<Student> hasStudent;
   private String courseName;


    public Course(Long courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public Course() {

    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
