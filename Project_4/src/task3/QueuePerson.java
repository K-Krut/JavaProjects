package task3;

import java.util.Objects;

public class QueuePerson {

    private String surname;
    private String name;
    private String middleName;

    private AddressValue address;
    private int queue;

    public QueuePerson(String surname, String name, String middleName, AddressValue address, int queue) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.queue = queue;
    }

    public QueuePerson() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public AddressValue getAddress() {
        return address;
    }

    public void setAddress(AddressValue address) {
        this.address = address;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QueuePerson)) return false;
        QueuePerson that = (QueuePerson) o;
        return getQueue() == that.getQueue() && getSurname().equals(that.getSurname()) && getName().equals(that.getName()) && getMiddleName().equals(that.getMiddleName()) && getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getMiddleName(), getAddress(), getQueue());
    }


    @Override
    public String toString() {
        return "QueuePerson{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address=" + address +
                ", queue=" + queue +
                '}';
    }
}
