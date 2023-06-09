package htwberlin.de.WebTech;

import jakarta.persistence.*;

@Entity
public class StudentGrade {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private StudentGradeKey id = new StudentGradeKey();

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student_id;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private Course course_id;

    private double grade;

    public StudentGrade(Student student_id, Course course_id, double grade) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
    }

    public StudentGrade() {

    }

    // getters, and setters

    public StudentGradeKey getId() {
        return id;
    }

    public void setId(StudentGradeKey id) {
        this.id = id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public Course getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Course course_id) {
        this.course_id = course_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
