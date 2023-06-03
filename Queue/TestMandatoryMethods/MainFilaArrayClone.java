package TestMandatoryMethods;

import Queue.Queue;

public class MainFilaArrayClone {
    public static void main(String[] args) throws Exception {

        // Create new Queue
        Queue<Integer> fila = new Queue<Integer>(10);
        // Test enqueue
        fila.enqueue(1);
        fila. enqueue(2);
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
        filaPequena.enqueue(3);
        System.out.println();

        System.out.println("fila      percorreFila:     " + fila.toArray());
        System.out.println("outraFila percorreFila:     " + outraFila.toArray());
        System.out.println("filaPequena percorreFila:   " + filaPequena.toArray());
        System.out.println("\n");

        // Test the clone method
        Queue<Integer> cloneFila = (Queue<Integer>) fila.clone();
        Queue<Integer> cloneOutraFila = (Queue<Integer>) outraFila.clone();
        Queue<Integer> cloneFilaPequena = (Queue<Integer>) filaPequena.clone();

        System.out.println("Clone fila:             " + cloneFila.toArray());
        System.out.println("clone outraFila:        " + cloneOutraFila.toArray());
        System.out.println("Cloned filaPequena:     " + cloneFilaPequena.toArray());
        System.out.println();
    }
}
