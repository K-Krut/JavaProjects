package task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressValueTest {

    AddressValue TestObject = new AddressValue();

    @Test
    void getCity() {
        TestObject.setCity("Kyiv");
        assertEquals(TestObject.getCity(), "Kyiv");
    }

    @Test
    void setCity() {
        TestObject.setCity("Kyiv");
        assertEquals(TestObject.getCity(), "Kyiv");

    }
    @Test
    void getStreet() {
        TestObject.setStreet("Yanhelia");
        assertEquals(TestObject.getStreet(), "Yanhelia");
    }

    @Test
    void setStreet() {
        TestObject.setStreet("Yanhelia");
        assertEquals(TestObject.getStreet(), "Yanhelia");
    }

    @Test
    void getStreetNumber() {
        TestObject.setStreetNumber("5");
        assertEquals(TestObject.getStreetNumber(), "5");
    }

    @Test
    void setStreetNumber() {
        TestObject.setStreetNumber("5");
        assertEquals(TestObject.getStreetNumber(), "5");
    }

    @Test
    void getApartmentNumber() {
        TestObject.setApartmentNumber(0);
        assertEquals(TestObject.getApartmentNumber(), 0);
    }

    @Test
    void setApartmentNumber() {
        TestObject.setApartmentNumber(0);
        assertEquals(TestObject.getApartmentNumber(), 0);
    }
}