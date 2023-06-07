package htwberlin.de.WebTech;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentGradeKey implements Serializable {
    @Column(name = "student_id")
    Long student_id;

    @Column(name = "course_id")
    Long course_id;


    // standard constructors, getters, and setters

    public StudentGradeKey(Long student_id, Long course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public StudentGradeKey() {
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGradeKey that = (StudentGradeKey) o;
        return Objects.equals(student_id, that.student_id) && Objects.equals(course_id, that.course_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, course_id);
    }
}