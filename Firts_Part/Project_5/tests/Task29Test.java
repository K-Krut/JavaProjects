package task5;

import org.junit.Test;
import task29.Graduate;
import task29.Student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Task29Test {
    private Student student = new Student("James Carter", 3, 3460L);
    private Graduate graduate = new Graduate("Oliver Twist", 4, 3333L, "Medicine");

    @Test
    public void checkThatStudentsAreNotTheSame() {
        assertNotEquals(student, graduate);
    }

    @Test
    public void checkStudentsEquality() {
        Student newStudent = student;
        assertEquals(student, newStudent);
    }

    @Test
    public void checkGraduateAndStudentWithSameDataEquality() {
        Graduate graduateOne = new Graduate("James Carter", 3, 3460L);
        assertEquals(student,graduateOne);
        assertNotEquals(graduateOne,student);
    }

}
