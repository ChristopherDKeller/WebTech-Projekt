package htwberlin.de.WebTech;

import jakarta.persistence.*;

@Entity
public class StudentGrade {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    StudentGradeKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    int grade;

    // getters, and setters

    public StudentGradeKey getId() {
        return id;
    }

    public void setId(StudentGradeKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
