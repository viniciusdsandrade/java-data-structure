package TestMandatoryMethods;

import java.util.Arrays;
import java.util.List;

import javax.print.event.PrintEvent;

import Queue.Queue;

public class MainRetainAll {

    public static void main(String[] args) throws Exception {

        Queue<Integer> fila = new Queue<>(3);
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        List<Integer> colecao = Arrays.asList(2, 3, 4, 5);
        System.out.println("Fila antes da retail: " + fila.toArray()); // esperada:
        Boolean resultado = fila.retainAll(colecao);
        System.out.println("Resultado da retail: " + resultado); // esperada: true
        System.out.println("Fila depois da retail: " + fila.toArray()); // esperada: [2, 3]
        
        // [2, 3]

    }
}
