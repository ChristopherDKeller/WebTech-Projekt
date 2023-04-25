package htwberlin.de.WebTech;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private int matrikelnr;

        public Student() {}

        public Student(String name, int matrikelnr) {
            this.name = name;
            this.matrikelnr = matrikelnr;
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