package PriorityQueue.Test.PriorityQueue;

import PriorityQueue.PriorityQueue;

import java.util.EmptyStackException;

public class TestPriorityQueue {
    public static void main(String[] args) {
        System.out.println("===== Iniciando Testes da PriorityQueue =====\n");

        // 1. Teste do Construtor Padrão e Metodo isEmpty
        System.out.println("1. Teste do Construtor Padrão e Método isEmpty");
        PriorityQueue<String> pq = new PriorityQueue<String>();
        System.out.println("Fila está vazia? " + (pq.isEmpty() ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println();

        // 2. Teste do Metodo enqueue
        System.out.println("2. Teste do Método enqueue");
        pq.enqueue("Task1", 2);
        pq.enqueue("Task2", 4);
        pq.enqueue("Task3", 4);
        pq.enqueue("Task4", 3);
        System.out.println("Fila após enqueues: " + pq);
        System.out.println("Fila está vazia? " + (pq.isEmpty() ? "Sim (Falhou)" : "Não (Passou)"));
        System.out.println();

        // 3. Teste do Metodo peek
        System.out.println("3. Teste do Método peek");
        try {
            String peeked = pq.peek();
            System.out.println("Elemento no topo (esperado: Task2 ou Task3): " + peeked);
        } catch (EmptyStackException e) {
            System.err.println("Exceção lançada no peek quando não deveria.");
        }
        System.out.println();

        // 4. Teste do Metodo dequeue e ordem de remoção
        System.out.println("4. Teste do Método dequeue e ordem de remoção");
        try {
            String removed1 = pq.dequeue();
            System.out.println("Dequeue 1 (esperado: Task2): " + removed1);
            System.out.println("Fila após dequeue 1: " + pq);

            String removed2 = pq.dequeue();
            System.out.println("Dequeue 2 (esperado: Task3): " + removed2);
            System.out.println("Fila após dequeue 2: " + pq);

            String removed3 = pq.dequeue();
            System.out.println("Dequeue 3 (esperado: Task4): " + removed3);
            System.out.println("Fila após dequeue 3: " + pq);

            String removed4 = pq.dequeue();
            System.out.println("Dequeue 4 (esperado: Task1): " + removed4);
            System.out.println("Fila após dequeue 4: " + pq);

            // Tentativa de dequeue em fila vazia
            System.out.println("Tentando fazer dequeue em uma fila vazia...");
            pq.dequeue();
            System.out.println("Falhou: Dequeue não lançou exceção em fila vazia.");
        } catch (EmptyStackException e) {
            System.err.println("Passou: Exceção lançada ao tentar dequeue em fila vazia.");
        }
        System.out.println();

        // 5. Teste do Metodo isEmpty após dequeues
        System.out.println("5. Teste do Método isEmpty após dequeues");
        System.out.println("Fila está vazia? " + (pq.isEmpty() ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println();

        // 6. Teste de Redimensionamento para Cima (resizeUp)
        System.out.println("6. Teste de Redimensionamento para Cima (resizeUp)");
        PriorityQueue<Integer> intPQ = new PriorityQueue<Integer>(2); // Inicializando com tamanho 2
        intPQ.enqueue(1, 1);
        intPQ.enqueue(2, 2);
        System.out.println("Fila de inteiros após enqueues: " + intPQ);
        System.out.println("Fila está cheia? " + (intPQ.isFull() ? "Sim (Passou)" : "Não (Falhou)"));

        // Enqueue adicional para forçar resizeUp
        intPQ.enqueue(3, 3);
        System.out.println("Fila após enqueue adicional (forçando resizeUp): " + intPQ);
        System.out.println("Fila está cheia? " + (intPQ.isFull() ? "Sim (Falhou)" : "Não (Passou)"));
        System.out.println();

        // 7. Teste do Metodo clone
        System.out.println("7. Teste do Método clone");
        PriorityQueue<String> originalPQ = new PriorityQueue<String>();
        originalPQ.enqueue("A", 1);
        originalPQ.enqueue("B", 2);
        originalPQ.enqueue("C", 3);
        System.out.println("Original PQ: " + originalPQ);

        @SuppressWarnings("unchecked")
        PriorityQueue<String> clonedPQ = (PriorityQueue<String>) originalPQ.clone();
        System.out.println("Cloned PQ: " + clonedPQ.toString());

        System.out.println("Original PQ == Cloned PQ? " + (originalPQ.equals(clonedPQ) ? "Sim (Passou)" : "Não (Falhou)"));

        // Modificar o clone e verificar a independência
        clonedPQ.enqueue("D", 4);
        System.out.println("Após modificar o clone:");
        System.out.println("Original PQ: " + originalPQ);
        System.out.println("Cloned PQ: " + clonedPQ);
        System.out.println("Original PQ == Cloned PQ após modificação? " + (!originalPQ.equals(clonedPQ) ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println();

        // 8. Teste do Metodo equals e hashCode
        System.out.println("8. Teste do Método equals e hashCode");
        PriorityQueue<String> pq1 = new PriorityQueue<String>();
        pq1.enqueue("X", 10);
        pq1.enqueue("Y", 20);

        PriorityQueue<String> pq2 = new PriorityQueue<String>();
        pq2.enqueue("X", 10);
        pq2.enqueue("Y", 20);

        System.out.println("PQ1: " + pq1);
        System.out.println("PQ2: " + pq2);
        System.out.println("PQ1.equals(PQ2)? " + (pq1.equals(pq2) ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println("PQ1.hashCode() == PQ2.hashCode()? " + (pq1.hashCode() == pq2.hashCode() ? "Sim (Passou)" : "Não (Falhou)"));

        // Modificar pq2 e testar novamente
        pq2.enqueue("Z", 30);
        System.out.println("Após adicionar 'Z' em PQ2:");
        System.out.println("PQ1: " + pq1);
        System.out.println("PQ2: " + pq2);
        System.out.println("PQ1.equals(PQ2) após modificação? " + (!pq1.equals(pq2) ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println("PQ1.hashCode() == PQ2.hashCode()? " + (pq1.hashCode() == pq2.hashCode() ? "Sim (Falhou)" : "Não (Passou)"));
        System.out.println();

        // 9. Teste do Metodo toArray e toString
        System.out.println("9. Teste do Método toArray e toString");
        PriorityQueue<String> pq3 = new PriorityQueue<String>();
        pq3.enqueue("Alpha", 5);
        pq3.enqueue("Beta", 3);
        pq3.enqueue("Gamma", 4);
        System.out.println("PQ3.toArray(): " + pq3.toArray());
        System.out.println("PQ3.toString(): " + pq3);
        System.out.println();

        // 10. Teste de Exceções
        System.out.println("10. Teste de Exceções");
        PriorityQueue<String> emptyPQ = new PriorityQueue<String>();
        try {
            emptyPQ.peek();
            System.out.println("Falhou: Peek não lançou exceção em fila vazia.");
        } catch (EmptyStackException e) {
            System.err.println("Passou: Peek lançou exceção em fila vazia.");
        }

        try {
            emptyPQ.dequeue();
            System.out.println("Falhou: Dequeue não lançou exceção em fila vazia.");
        } catch (EmptyStackException e) {
            System.err.println("Passou: Dequeue lançou exceção em fila vazia.");
        }
        System.out.println();

        System.out.println("===== Testes Concluídos =====");
    }
}
