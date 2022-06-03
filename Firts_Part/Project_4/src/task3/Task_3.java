// Создайте приложение для добавления очередника в
// очередь и просмотра очереди. Список (5 записей)
// создается в программе и является объектом класса LinkedList.
// Запись списка является объектом QueuePerson, содержащим
// поля фамилии, имени и отчества очередника (все поля типа String),
// поле типа AddressValue для адреса очередника и
// приоритет очередника (типа int). В свою очередь,
// поле типа AddressValue содержит три поля типа String:
// наименование города, наименование улицы и номер дома,
// а также поле типа int – номер квартиры (если номер
// квартиры равен 0, дом, в котором проживает субъект,
// не имеет квартир). Записи в очереди сортируются в
// соответствии с приоритетом, и очередник добавляется
// последним в очереди своего приоритета.
// Предусмотреть возможность расчета количества
// очередников каждого приоритета, используя HashMap.

package task3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Task_3 {
    public static LinkedList<QueuePerson> addPersonToQueue(QueuePerson person, LinkedList<QueuePerson> queue) {
        int counter = 0;
        Iterator<QueuePerson> iterator = queue.iterator();
        while (iterator.hasNext() && person.getQueue() >= iterator.next().getQueue()) {
            ++counter;
        }
        queue.add(counter, person);
        return queue;
    }

    public static HashMap<Integer, Integer> countPriorities(LinkedList<QueuePerson> queuePersonList) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (QueuePerson person : queuePersonList) {
            int key = person.getQueue();
            if (!counter.containsKey(key)) {
                counter.put(key, 1);
            }
            else {
                counter.put(key, counter.get(key) + 1);
            }
        }
        return counter;
    }
    public static void PrintingQueue(LinkedList<QueuePerson> list){
        for (QueuePerson person : list) {
            System.out.println(person);
        }
    }
    public static void PrintingPriorities(LinkedList<QueuePerson> list){
        for (Map.Entry<Integer, Integer> entry: countPriorities(list).entrySet()) {
            System.out.printf("%d priority : %d people%n", entry.getKey(), entry.getValue());
        }
    }
    public static void main(String[] args) {
        LinkedList<QueuePerson> queuePersonList = new LinkedList<>();

        queuePersonList = addPersonToQueue(new QueuePerson("Ivanov", "Ivan", "Ivanovich",
                new AddressValue("Kyiv","Yanhelia","5",0),1) , queuePersonList);
        queuePersonList = addPersonToQueue(new QueuePerson("Petrov", "Petro", "Petrovich",
                new AddressValue("Kyiv","Yanhelia","7",0),2) , queuePersonList);
        queuePersonList = addPersonToQueue(new QueuePerson("Lukinskyi", "Dymitr", "Dmytrovych",
                new AddressValue("Kyiv","Yanhelia","5",0),3) , queuePersonList);
        queuePersonList = addPersonToQueue(new QueuePerson("Kovalskyi", "Andriy", "Oleksandrovych",
                new AddressValue("Kyiv","Yanhelia","5",0),1) , queuePersonList);
        queuePersonList = addPersonToQueue(new QueuePerson("Koval", "Pavlo", "Ivanovich",
                new AddressValue("Kyiv","Yanhelia","5",0),2) , queuePersonList);

        PrintingQueue(queuePersonList);
        PrintingPriorities(queuePersonList);

    }
}
