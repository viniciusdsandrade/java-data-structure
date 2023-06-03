package TestMandatoryMethods;

import Queue.Queue;

public class MainFilaArrayConstrutorCopia {
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

        // test copy constructor
        Queue<Integer> copiaFila = new Queue<>(fila);
        Queue<Integer> copiaOutraFila = new Queue<>(outraFila);
        Queue<Integer> copiaFilaPequena = new Queue<>(filaPequena);

        System.out.println("Cópia fila:             " + copiaFila.toArray());
        System.out.println("Cópia outraFila:        " + copiaOutraFila.toArray());
        System.out.println("Cópia filaPequena:      " + copiaFilaPequena.toArray());
        System.out.println();

    }
}
