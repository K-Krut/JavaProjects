package task5;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Task5Test {

    @Before
    public void clearMessages() {
        MessagesArchive.clearMessages();
    }

    @Test
    public void checkIfCanAddMessages() {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("James Carter", "Medicine", "I was wondering if you could explain me this"));
        MessagesArchive.addMessage("James Carter", "Medicine", "I was wondering if you could explain me this");
        assertEquals(messages, MessagesArchive.getMessages());
    }

//    @Test
//    public void checkIfCanChangeMessages() {
//        ArrayList<Message> messages = new ArrayList<>();
//        messages.add(new Message("James Carter", "Programming", "I was wondering if you would change this"));
//        MessagesArchive.addMessage("James Carter", "Medicine", "I was wondering if you could explain me this");
//        MessagesArchive.changeMessage(0, "","Programming", "I was wondering if you would change this");
//        assertEquals(messages, MessagesArchive.getMessages());
//    }

    @Test(expected = NullPointerException.class)
    public void checkEqualityOfEmptyMessage() {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message(null, null, null));
        MessagesArchive.addMessage(null, null, null);
        assertEquals(messages,MessagesArchive.getMessages());
    }

    @Test
    public void checkIfCanShowMessages() {
        MessagesArchive.addMessage("James Carter", "Medicine", "I was wondering if you could explain me this");
        assertNotNull(MessagesArchive.getMessages());
    }
}
