package task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFileTest {
    TextFile TestObject = new TextFile();
    TextFile file1 = new TextFile("C:\\Program Files", "Song lyrics");
    @Test
    void get_setAbsolutePath() {
        TestObject.setAbsolutePath("C:\\Program Files");
        assertEquals(TestObject.getAbsolutePath(), "C:\\Program Files");
    }

    @Test
    void get_setDescription() {
        TestObject.setDescription("Song lyrics");
        assertEquals(TestObject.getDescription(), "Song lyrics");
    }

    @Test
    void testToString() {
        String actual = "TextFile{absolutePath='C:\\Program Files', description='Song lyrics'}";
        assertEquals(actual, file1.toString());
    }
}