package task29;

import java.util.Objects;

/**
 * Primary class that implements students
 */
public class Student {
    private String name;
    private int grade;
    private Long id;

    /**
     * Non-parameters constructor of the Student class
     */
    public Student() {

    }

    /**
     * Constructor of the Student class
     * @param name -- name of the stident
     * @param grade -- grade of the student
     * @param id -- id of the student
     */
    public Student(String name, int grade, Long id) {
        this.name = name;
        this.grade = grade;
        this.id = id;
    }

    /**
     * Method for comparison Student objects
     * @param o - Student object
     * @return bool
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return grade == student.grade && name.equals(student.name) && id.equals(student.id);
    }

    /**
     * Method for hashing Student objects
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, grade, id);
    }

    /**
     * Method for printing Student objects
     * @return string representative
     */
    @Override
    public String toString() {
        return "Student:" +
                "\nname='" + name + '\'' +
                "\ngrade=" + grade +
                "\nid=" + id + "\n";
    }
}
