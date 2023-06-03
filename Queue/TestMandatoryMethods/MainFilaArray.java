package TestMandatoryMethods;

import java.util.EmptyStackException;
import Queue.Queue;

public class MainFilaArray {
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
        filaPequena.enqueue(3);
        System.out.println();

        System.out.println("Percorrendo a Fila (FIFO - First in First Out) \n");
        System.out.println("Primeiros adicionados sempre serão os primeiros");
        System.out.println("fila      percorreFila:     " + fila.toArray());
        System.out.println("outraFila percorreFila:     " + outraFila.toArray());
        System.out.println("filaPequena percorreFila:   " + filaPequena.toArray());
        System.out.println("\n");

        // Test size()
        System.out.println("fila       Size:    " + fila.size());
        System.out.println("outraFila  Size:    " + fila.size());
        System.out.println("filaPequena  Size:  " + fila.size());
        System.out.println();

        // Test isEmpty()
        System.out.println("fila       Is empty?    " + fila.isEmpty());
        System.out.println("outraFila  Is empty?    " + outraFila.isEmpty());
        System.out.println("filaPequena  Is empty?  " + filaPequena.isEmpty());
        System.out.println();

        // Test peek()
        System.out.println("fila         Peek: " + fila.peek());
        System.out.println("outraFila    Peek: " + outraFila.peek());
        System.out.println("filaPequena  Peek: " + filaPequena.peek());
        System.out.println();

        // Test Pop()
        System.out.println("fila        - Dequeue()  : " + fila.dequeue());
        System.out.println("outraFila   - Dequeue()  : " + outraFila.dequeue());
        System.out.println("filaPequena - Dequeue()  : " + filaPequena.dequeue());
        System.out.println();

        // toArray()
        System.out.println("fila      percorreFila:     " + fila.toArray());
        System.out.println("outraFila percorreFila:     " + outraFila.toArray());
        System.out.println("filaPequena percorreFila:   " + filaPequena.toArray());
        System.out.println();

        // Test peek()
        System.out.println("fila         Peek: " + fila.peek());
        System.out.println("outraFila    Peek: " + outraFila.peek());
        System.out.println("filaPequena  Peek: " + filaPequena.peek());
        System.out.println();

        // Test Pop()
        System.out.println("fila        - Dequeue()  : " + fila.dequeue());
        System.out.println("outraFila   - Dequeue()  : " + outraFila.dequeue());
        System.out.println("filaPequena - Dequeue()  : " + filaPequena.dequeue());
        System.out.println();

        // toArray()
        System.out.println("fila      percorreFila:     " + fila.toArray());
        System.out.println("outraFila percorreFila:     " + outraFila.toArray());
        System.out.println("filaPequena percorreFila:   " + filaPequena.toArray());
        System.out.println();

        // Test peek()
        System.out.println("fila         Peek: " + fila.peek());
        System.out.println("outraFila    Peek: " + outraFila.peek());
        System.out.println("filaPequena  Peek: " + filaPequena.peek());
        System.out.println();

        System.out.println("**********************************************************");
        System.out.println("Testando método dequeue()\n");
        System.out.println("Recolocando elementos subtraidos nos ultimos 2 pop()\n");

        System.out.println("Fila Antes de adicionar");
        System.out.println("fila :       " + fila.toArray());
        System.out.println("outraFila:   " + outraFila.toArray());
        System.out.println("filaPequena: " + filaPequena.toArray());
        System.out.println();

        fila.enqueue(6);
        fila.enqueue(7);

        outraFila.enqueue(6);
        outraFila.enqueue(7);

        filaPequena.enqueue(2);
        filaPequena.enqueue(3);

        System.out.println("Fila Depois de adicionar");
        System.out.println("fila :       " + fila.toArray());
        System.out.println("outraFila:   " + outraFila.toArray());
        System.out.println("filaPequena: " + filaPequena.toArray());
        System.out.println();

        // Test dequeueAll()
        System.out.println("Esvaziando todas as Filas");
        System.out.println("Test dequeueAll()");
        System.out.println("fila        - DequeueAll()  : " + fila.dequeueAll());
        System.out.println("outraFila   - DequeueAll()  : " + outraFila.dequeueAll());
        System.out.println("filaPequena - DequeueAll()  : " + filaPequena.dequeueAll());
        System.out.println();

        System.out.println("**********************Test peek()***************************\n");
        try {
            try {
                System.out.println("test the peek() ");
                System.out.println("Peek() fila: " + fila.peek());
                System.out.println();
            } catch (EmptyStackException e) {
                System.err.println("fila vazia, impossível pegar o elemento do topo!\n");
            }

            try {
                System.out.println("test the peek() ");
                System.out.println("Peek() outraFila:    " + outraFila.peek());
                System.out.println();
            } catch (EmptyStackException e) {
                System.err.println("outraFila vazia, impossível pegar o elemento do topo!\n");
            }

            try {
                System.out.println("test the peek() ");
                System.out.println("Peek() filaPequena:" + filaPequena.peek());
                System.out.println();
            } catch (EmptyStackException e) {
                System.err.println("filaPequena Vazia, impossível pegar o elemento do topo!\n");
            }
        } catch (Exception e) {
            System.err.println("Exception no método peek()");
        }

        try {
            System.out.println("**********************Test dequeue()***************************\n");

            try {
                // test the peek method
                System.out.println("test the dequeue() ");
                System.out.println("dequeue() fila: " + fila.dequeue());
                System.out.println();
            } catch (EmptyStackException e) {
                System.err.println("fila vazia, impossível eliminar o elemento do topo!\n");
            }

            try {
                // test the peek method
                System.out.println("test the dequeue() ");
                System.out.println("dequeue() outraFila:    " + outraFila.dequeue());
                System.out.println();
            } catch (EmptyStackException e) {
                System.err.println("outraFila vazia,   impossível eliminar o elemento do topo!\n");
            }

            try {
                // test the peek method
                System.out.println("test the dequeue() ");
                System.out.println("dequeue() filaPequena:" + filaPequena.dequeue());
                System.out.println();
            } catch (EmptyStackException e) {
                System.err.println("filaPequena Vazia,   impossível eliminar o elemento do topo!\n");
            }
        } catch (Exception e) {
            System.err.println("Exception no método dequeue()");
        }

        // Test isEmpty()
        System.out.println("fila       Is empty?    " + fila.isEmpty());
        System.out.println("outraFila  Is empty?    " + outraFila.isEmpty());
        System.out.println("filaPequena  Is empty?  " + filaPequena.isEmpty());
        System.out.println();

    }
}