package TestMandatoryMethods;

import Queue.Queue;

public class MainFilaArrayCompareTo {
    public static void main(String[] args) throws Exception {

        // Create new Queue
        Queue<Integer> fila = new Queue<Integer>(10);
        // Test enqueue
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);

        Queue<Integer> outraFila = new Queue<Integer>(10);
        outraFila.enqueue(1);
        outraFila.enqueue(2);
        outraFila.enqueue(3);
        outraFila.enqueue(4);
        outraFila.enqueue(5);

        Queue<Integer> filaPequena = new Queue<Integer>(10);
        filaPequena.enqueue(1);
        filaPequena.enqueue(2);
        System.out.println();

        System.out.println("fila      percorreFila:     " + fila.toArray());
        System.out.println("outraFila percorreFila:     " + outraFila.toArray());
        System.out.println("filaPequena percorreFila:   " + filaPequena.toArray());
        System.out.println("\n");

        // Test compareTo
        System.out.println("CompareTo fila      and    filaPequena: " + fila.compareTo(filaPequena));
        System.out.println("CompareTo outraFila and    outraFila:   " + outraFila.compareTo(outraFila));
        System.out.println("CompareTo filaPequena and    fila:      " + filaPequena.compareTo(fila));
        System.out.println();
    }
}
