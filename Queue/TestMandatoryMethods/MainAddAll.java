package TestMandatoryMethods;

import java.util.Arrays;
import java.util.List;

import Queue.Queue;

public class MainAddAll {
    public static void main(String[] args) throws Exception {
        Queue<Integer> fila = new Queue<>(3);
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        List<Integer> colecao = Arrays.asList(4, 5, 6);

        System.out.println("Fila antes da adição: " + fila.toArray());
        boolean modificado = fila.addAll(colecao);
        System.out.println("Modificado: " + modificado); // Saída esperada: true
        System.out.println("Fila após adição: " + fila.toArray()); // Saída esperada: [1, 2, 3, 4, 5, 6]

    }
}
