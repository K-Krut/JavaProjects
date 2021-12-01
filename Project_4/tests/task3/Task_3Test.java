package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

 class Task_3Test {

    Task_3 TestObject = new Task_3();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    LinkedList<QueuePerson> actual_list = new LinkedList<>();
    HashMap<Integer, Integer> actual_map = new HashMap<>();

    @BeforeEach
    void setUp() {
        actual_list.add(new QueuePerson("Ivanov", "Ivan", "Ivanovich",
                new AddressValue("Kyiv","Yanhelia","5",0),1));
        actual_list.add(new QueuePerson("Petrov", "Petro", "Petrovich",
                new AddressValue("Kyiv","Yanhelia","7",0),2));
        actual_list.add(new QueuePerson("Lukinskyi", "Dymitr", "Dmytrovych",
                new AddressValue("Kyiv","Yanhelia","5",0),3));
        actual_list.add(new QueuePerson("Kovalskyi", "Andriy", "Oleksandrovych",
                new AddressValue("Kyiv","Yanhelia","5",0),1));
        actual_list.add(new QueuePerson("Koval", "Pavlo", "Ivanovich",
                new AddressValue("Kyiv","Yanhelia","5",0),2));

        actual_map.put(1, 2);
        actual_map.put(2, 2);
        actual_map.put(3, 1);

        System.setOut(new PrintStream(output));
    }

    @Test
    void addPersonToQueue() {
        LinkedList<QueuePerson> expected = new LinkedList<>();

        expected = TestObject.addPersonToQueue(new QueuePerson("Ivanov", "Ivan", "Ivanovich",
                new AddressValue("Kyiv","Yanhelia","5",0),1) , expected);
        expected = TestObject.addPersonToQueue(new QueuePerson("Petrov", "Petro", "Petrovich",
                new AddressValue("Kyiv","Yanhelia","7",0),2) , expected);
        expected = TestObject.addPersonToQueue(new QueuePerson("Lukinskyi", "Dymitr", "Dmytrovych",
                new AddressValue("Kyiv","Yanhelia","5",0),3) , expected);
        expected = TestObject.addPersonToQueue(new QueuePerson("Kovalskyi", "Andriy", "Oleksandrovych",
                new AddressValue("Kyiv","Yanhelia","5",0),1) , expected);
        expected = TestObject.addPersonToQueue(new QueuePerson("Koval", "Pavlo", "Ivanovich",
                new AddressValue("Kyiv","Yanhelia","5",0),2) , expected);

        assertEquals(expected.get(0), actual_list.get(0));
        assertEquals(expected.getClass().getSimpleName(), actual_list.getClass().getSimpleName());
    }
}