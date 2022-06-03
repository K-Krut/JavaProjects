package task29;

import java.util.Objects;

/**
 * Class that implements graduate students
 * extends Student class
 */
public class Graduate extends Student{
    private String topicOfDiploma;

    /**
     * Constructor with no parameters
     */
    public Graduate() {
        super();
    }

    /**
     * Constructor of the Graduate class
     * @param topicOfDiploma -- string that represent topic of the diploma
     */
    public Graduate(String topicOfDiploma) {
        this.topicOfDiploma = topicOfDiploma;
    }

    /**
     * Constructor of the Graduate class
     * @param name -- name of the student
     * @param grade -- grade of the student
     * @param id -- id of the student
     */
    public Graduate(String name, int grade, Long id) {
        super(name, grade, id);
    }

    /**
     * Constructor of the Graduate class
     * @param name -- name of the student
     * @param grade -- grade of the student
     * @param id -- id of the student
     * @param topicOfDiploma -- string that represent topic of the diploma
     */
    public Graduate(String name, int grade, Long id, String topicOfDiploma) {
        super(name, grade, id);
        this.topicOfDiploma = topicOfDiploma;
    }

    /**
     * Method for comparison Graduate objects
     * @param o - Student object
     * @return bool
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graduate)) return false;
        if (!super.equals(o)) return false;
        Graduate graduate = (Graduate) o;
        return topicOfDiploma.equals(graduate.topicOfDiploma);
    }

    /**
     * Method for hashing Graduate object
     * @return int -- hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topicOfDiploma);
    }

    /**
     * Method for printing Graduate objects
     * @return string representative
     */
    @Override
    public String toString() {
        return "Graduate{" +
                "topicOfDiploma='" + topicOfDiploma + '\'' +
                "} " + super.toString();
    }
}
