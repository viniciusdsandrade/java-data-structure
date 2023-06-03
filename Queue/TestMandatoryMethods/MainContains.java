package TestMandatoryMethods;

import Queue.Queue;

public class MainContains {
    public static void main(String[] args) throws Exception {

        Queue<String> fila = new Queue<>(5);
        fila.enqueue("a");
        fila.enqueue("b");
        fila.enqueue("c");

        boolean contemElemento = fila.contains("b");
        System.out.println("Contém elemento 'b': " + contemElemento); // Saída esperada: true

        Queue<Integer> fila2 = new Queue<>(5);
        fila2.enqueue(1);
        fila2.enqueue(2);
        fila2.enqueue(3);

        boolean contemElemento2 = fila2.contains(4);
        System.out.println("Contém elemento '4': " + contemElemento2); // Saída esperada: false

        Queue<String> fila3 = new Queue<>(5);
        fila3.enqueue("a");
        fila3.enqueue("b");
        //fila3.enqueue(null);

        try {
            boolean contemElemento3 = fila3.contains("");
            System.out.println("Contém elemento nulo: " + contemElemento3); // Saída esperada: NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Exceção esperada: " + e.getMessage());
        }

        Queue<Character> fila4 = new Queue<>(5);

        boolean contemElemento4 = fila4.contains('a');
        System.out.println("Contém elemento 'a': " + contemElemento4); // Saída esperada: false

    }
}
