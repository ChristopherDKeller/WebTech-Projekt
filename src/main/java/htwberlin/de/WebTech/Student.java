package htwberlin.de.WebTech;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "student_id")
        Set<StudentGrade> grades;
        private String name;
        private Integer matrikelnr;

        public Student(String name, Integer matrikelnr) {
            this.name = name;
            this.matrikelnr = matrikelnr;
        }

    public Student(Long id) {
        this.id = id;
    }

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMatrikelnr() {
            return matrikelnr;
        }

        public void setPrice(int price) {
            this.matrikelnr = matrikelnr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;

            Student student = (Student) o;

            if (getMatrikelnr() != student.getMatrikelnr()) return false;
            if (getId() != null ? !getId().equals(student.getId()) : student.getId() != null) return false;
            return getName() != null ? getName().equals(student.getName()) : student.getName() == null;
        }

        @Override
        public String toString() {
            return "Thing{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + matrikelnr +
                    '}';
        }
}
