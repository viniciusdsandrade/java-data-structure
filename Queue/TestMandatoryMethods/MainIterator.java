package TestMandatoryMethods;

import java.util.Iterator;

import Queue.Queue;

public class MainIterator {
    public static void main(String[] args) throws Exception {

        Queue<Integer> fila = new Queue<>(5);
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        Iterator<Integer> iterator = fila.iterator();
        while (iterator.hasNext()) {
            Integer elemento = iterator.next();
            System.out.println(elemento);
        }

        Queue<String> fila2 = new Queue<>(3);
        fila2.enqueue("A");
        fila2.enqueue("B");
        fila2.enqueue("C");

        Iterator<String> iterator2 = fila2.iterator();
        while (iterator2.hasNext()) {
            String elemento = iterator2.next();
            System.out.println(elemento);
        }

        System.out.println("---");

        fila2.dequeue();
        fila2.enqueue("D");

        iterator2 = fila2.iterator();
        while (iterator2.hasNext()) {
            String elemento = iterator2.next();
            System.out.println(elemento);
        }
    }

}
