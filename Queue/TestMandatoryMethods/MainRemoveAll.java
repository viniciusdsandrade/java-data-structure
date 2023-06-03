package TestMandatoryMethods;

import java.util.Arrays;
import java.util.List;

import Queue.Queue;

public class MainRemoveAll {
    public static void main(String[] args) throws Exception {
        Queue<Integer> fila = new Queue<>(5);
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);

        List<Integer> colecao = Arrays.asList(2, 4, 6);

        System.out.println("Fila antes da remoção: " + fila.toArray());
        boolean modificado = fila.removeAll(colecao);
        System.out.println("Modificado: " + modificado); // Saída esperada: true
        System.out.println("Fila após remoção: " + fila.toArray()); // Saída esperada: [1, 3, 5]

    }
}
