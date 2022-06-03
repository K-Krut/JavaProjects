package task5;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class for archiving messages from forum
 */
public class MessagesArchive {

    private static ArrayList<Message> messages = new ArrayList<>();

    /**
     * Getter of the messages
     * @return ArrayList with messages
     */
    public static ArrayList<Message> getMessages() {
        return messages;
    }

    /**
     * Method for adding message to archive
     * @param author -- author of the message
     * @param topic -- topic of the message
     * @param text -- text of the message
     * @return bool
     */
    public static boolean addMessage(String author, String topic, String text) {
        return messages.add(new Message(author, topic, text));
    }

    /**
     * Method for printing messages of the forum
     */
    public static void showMessages() {
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(i + " " + messages.get(i));
        }
    }

    /**
     * Method for clearing forum archive
     */
    public static void clearMessages() {
        messages = new ArrayList<>();
    }

    /**
     * Method for editing existent message
     * @param index -- index of the message
     * @param author -- new author of the message
     * @param topic -- new topic of the message
     * @param text -- new text of the message
     * @return bool
     */
    public static boolean changeMessage(int index, String author, String topic, String text) {
        if (messages.get(index) == null)
            return false;

        Message message = messages.get(index);
        if (author.length() > 0) message.setAuthor(author);
        if (topic.length() > 0) message.setTopic(topic);
        if (text.length() > 0) message.setText(text);
        message.setUpdatedAt(new Date(System.currentTimeMillis()));
        return true;
    }
}
