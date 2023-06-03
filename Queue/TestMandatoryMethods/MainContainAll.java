package TestMandatoryMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import Queue.Queue;

public class MainContainAll {
    public static void main(String[] args) throws Exception {
        Queue<String> fila = new Queue<>(5);
        fila.enqueue("a");
        fila.enqueue("b");
        fila.enqueue("c");

        List<String> colecao = Arrays.asList("a", "c");

        boolean contemTodos = fila.containsAll(colecao);
        System.out.println("Contém todos: " + contemTodos); // Sa

        Queue<Integer> fila2 = new Queue<>(5);
        fila2.enqueue(1);
        fila2.enqueue(2);
        fila2.enqueue(3);

        List<Integer> colecao2 = new ArrayList<>();

        try {
            boolean contemTodos2 = fila2.containsAll(colecao2);
            System.out.println("Contém todos: " + contemTodos2); 
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção esperada: " + e.getMessage());
        }

        Queue<Character> fila3 = new Queue<>(5);

        List<Character> colecao3 = Arrays.asList('a', 'b', 'c');

        try {
            boolean contemTodos3 = fila3.containsAll(colecao3);
            System.out.println("Contém todos: " + contemTodos3); // Saída esperada: EmptyStackException
        } catch (EmptyStackException e) {
            System.out.println("Exceção esperada: " + e.getMessage());
        }

        Queue<Integer> fila4 = new Queue<>(5);
        fila4.enqueue(1);
        fila4.enqueue(2);
        fila4.enqueue(3);

        List<Integer> colecao4 = Arrays.asList(4, 5, 6);

        boolean contemTodos4 = fila.containsAll(colecao4);
        System.out.println("Contém todos: " + contemTodos4); // Saída esperada: false

    }
}
