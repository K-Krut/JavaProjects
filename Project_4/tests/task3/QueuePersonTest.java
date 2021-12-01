package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueuePersonTest {
    QueuePerson TestObject = new QueuePerson();

    @Test
    void getSurname() {
        TestObject.setSurname("Ivanov");
        assertEquals(TestObject.getSurname(), "Ivanov");
    }

    @Test
    void setSurname() {
        TestObject.setName("Ivan");
        assertEquals(TestObject.getName(), "Ivan");
    }

    @Test
    void getName() {
        TestObject.setName("Ivan");
        assertEquals(TestObject.getName(), "Ivan");
    }

    @Test
    void setName() {
        TestObject.setSurname("Ivanov");
        assertEquals(TestObject.getSurname(), "Ivanov");
    }

    @Test
    void getMiddleName() {
        TestObject.setMiddleName("Ivanovich");
        assertEquals(TestObject.getMiddleName(), "Ivanovich");
    }

    @Test
    void setMiddleName() {
        TestObject.setMiddleName("Ivanovich");
        assertEquals(TestObject.getMiddleName(), "Ivanovich");
    }

//    @Test
//    void getAddress() {
//        TestObject.setAddress(new AddressValue("Kyiv","Yanhelia","5",0));
//        assertEquals(TestObject.getAddress(),
//                "AddressValue{city='Kyiv', street='Yanhelia', streetNumber='5', apartmentNumber=0}");
//    }
//
//    @Test
//    void setAddress() {
//        TestObject.setAddress(new AddressValue("Kyiv","Yanhelia","5",0));
//        assertEquals(TestObject.getAddress(),
//                "AddressValue{city='Kyiv', street='Yanhelia', streetNumber='5', apartmentNumber=0}");
//    }

    @Test
    void getQueue() {
        TestObject.setQueue(1);
        assertEquals(TestObject.getQueue(), 1);
    }

    @Test
    void setQueue() {
        TestObject.setQueue(1);
        assertEquals(TestObject.getQueue(), 1);
    }
}