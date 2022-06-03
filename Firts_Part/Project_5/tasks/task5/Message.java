package task5;

import java.util.Date;
import java.util.Objects;


/**
 * Class that implement forum
 */
public class Message {
    private String author;
    private String topic;
    private String text;

    private Date createdAt;
    private Date updatedAt;

    /**
     * Constructor with no parameters
     */
    public Message() {

    }

    /**
     * Constructor for the class Message
     * @param author -- describes author of the message
     * @param topic -- describes topic of the message
     * @param text -- contains the text of the message
     *  createdAt -- time of the message creation
     *  updatedAt -- time of the last message update
     */
    public Message(String author, String topic, String text) {
        this.author = author;
        this.topic = topic;
        this.text = text;
        this.createdAt = new Date(System.currentTimeMillis());
        this.updatedAt = this.createdAt;
    }

    /**
     * Getter of the author name
     * @return string representative
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter of the author name
     * @param author -- string representative
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter of the topic of the message
     * @return string representative
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Setter of the message topic
     * @param topic -- topic of the message
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Getter of the message text
     * @return string representative
     */
    public String getText() {
        return text;
    }

    /**
     * Setter of the messages' text
     * @param text -- string representative
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Getter of the time creation
     * @return Date of the message creation
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Setter of the time creation
     * @param createdAt -- Date object that represent the time of the massage creation
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /***
     * Getter of the last update time
     * @return Date object
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Setter of the time of last message update
     * @param updatedAt -- Date represent date of the last message's update
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Method for the comparison the Massage object data
     * @param o -- Message object
     * @return bool
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getAuthor().equals(message.getAuthor()) && getTopic().equals(message.getTopic()) && getText().equals(message.getText());
    }

    /**
     * Method for hashing Message object
     * @return int -- hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTopic(), getText());
    }

    /**
     * Method for printing Message objects
     * @return string representative
     */
    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
