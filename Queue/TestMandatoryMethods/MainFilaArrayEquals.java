package TestMandatoryMethods;

import Queue.Queue;

public class MainFilaArrayEquals {
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

        // Test equals with original copy
        System.out.println("fila      is Equals Fila        ?   " + fila.equals(fila));
        System.out.println("fila is Equals outraFila        ?   " + fila.equals(outraFila));
        System.out.println("fila is Equals filaPequena      ?   " + fila.equals(filaPequena));
        System.out.println();

        System.out.println("outraFila is Equals outraFila   ?  " + outraFila.equals(outraFila));
        System.out.println("outraFila is Equals fila        ?  " + outraFila.equals(fila));
        System.out.println("outraFila is Equals filaPequena ?  " + outraFila.equals(filaPequena));
        System.out.println();

        System.out.println("filaPequena is Equals filaPequena ? " + filaPequena.equals(filaPequena));
        System.out.println("filaPequena is Equals fila        ? " + filaPequena.equals(fila));
        System.out.println("filaPequena is Equals outraFila   ? " + filaPequena.equals(outraFila));
        System.out.println();

    }
}
