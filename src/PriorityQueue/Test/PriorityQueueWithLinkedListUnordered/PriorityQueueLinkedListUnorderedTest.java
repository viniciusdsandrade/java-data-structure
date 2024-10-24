package PriorityQueue.Test.PriorityQueueWithLinkedListUnordered;

import PriorityQueue.PriorityQueueLinkedListUnordered;

import java.util.EmptyStackException;

public class PriorityQueueLinkedListUnorderedTest {
    public static void main(String[] args) {
        System.out.println("===== Iniciando Testes da PriorityQueueLinkedListUnordered =====\n");

        System.out.println("1. Teste do Construtor Padrão e Método isEmpty");
        PriorityQueueLinkedListUnordered<String> pq = new PriorityQueueLinkedListUnordered<String>();
        System.out.println("Fila está vazia? " + (pq.isEmpty() ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println("Tamanho da fila: " + pq.size() + " (Esperado: 0)\n");

        System.out.println("2. Teste do Método enqueue");
        pq.enqueue("Task1", 2);
        pq.enqueue("Task2", 4);
        pq.enqueue("Task3", 4);
        pq.enqueue("Task4", 3);
        System.out.println("Fila após enqueues: " + pq);
        System.out.println("Fila está vazia? " + (pq.isEmpty() ? "Sim (Falhou)" : "Não (Passou)"));
        System.out.println("Tamanho da fila: " + pq.size() + " (Esperado: 4)\n");

        System.out.println("3. Teste do Método peek");
        try {
            String peeked = pq.peek();
            System.out.println("Elemento no topo (esperado: Task2 ou Task3): " + peeked);
        } catch (EmptyStackException e) {
            System.err.println("Exceção lançada no peek quando não deveria.");
        }
        System.out.println();

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

        System.out.println("5. Teste do Método isEmpty após dequeues");
        System.out.println("Fila está vazia? " + (pq.isEmpty() ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println("Tamanho da fila: " + pq.size() + " (Esperado: 0)\n");

        System.out.println("6. Teste do Método clear");
        pq.enqueue("Task5", 5);
        pq.enqueue("Task6", 1);
        pq.enqueue("Task7", 3);
        System.out.println("Fila antes de clear: " + pq);
        System.out.println("Tamanho da fila: " + pq.size() + " (Esperado: 3)");
        pq.clear();
        System.out.println("Fila após clear: " + pq);
        System.out.println("Fila está vazia? " + (pq.isEmpty() ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println("Tamanho da fila: " + pq.size() + " (Esperado: 0)\n");

        System.out.println("7. Teste do Método clone");
        PriorityQueueLinkedListUnordered<String> pq0 = new PriorityQueueLinkedListUnordered<String>();
        pq0.enqueue("A", 1);
        pq0.enqueue("B", 2);
        pq0.enqueue("C", 3);
        System.out.println("Original PQ: " + pq0);

        @SuppressWarnings("unchecked")
        PriorityQueueLinkedListUnordered<String> pqClone = (PriorityQueueLinkedListUnordered<String>) pq0.clone();
        System.out.println("Cloned PQ: " + pqClone);

        System.out.println("Original PQ == Cloned PQ? " + (pq0.equals(pqClone) ? "Sim (Passou)" : "Não (Falhou)"));

        // Modificar o clone e verificar a independência
        pqClone.enqueue("D", 4);
        System.out.println("Após adicionar Task6 ao clone:");
        System.out.println("Original PQ: " + pq0);
        System.out.println("Cloned PQ: " + pqClone);
        System.out.println("Original PQ == Cloned PQ após modificação? " + (!pq0.equals(pqClone) ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println();

        System.out.println("8. Teste do Método equals e hashCode");
        PriorityQueueLinkedListUnordered<String> pq1 = new PriorityQueueLinkedListUnordered<String>();
        pq1.enqueue("X", 10);
        pq1.enqueue("Y", 20);

        PriorityQueueLinkedListUnordered<String> pq2 = new PriorityQueueLinkedListUnordered<String>();
        pq2.enqueue("X", 10);
        pq2.enqueue("Y", 20);

        System.out.println("PQ1: " + pq1);
        System.out.println("PQ2: " + pq2);
        System.out.println("PQ1.equals(PQ2)? " + (pq1.equals(pq2) ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println("PQ1.hashCode() == PQ2.hashCode()? " + (pq1.hashCode() == pq2.hashCode() ? "Sim (Passou)" : "Não (Falhou)"));

        pq2.enqueue("Z", 30);
        System.out.println("Após adicionar 'Z' em PQ2:");
        System.out.println("PQ1: " + pq1);
        System.out.println("PQ2: " + pq2);
        System.out.println("PQ1.equals(PQ2) após modificação? " + (!pq1.equals(pq2) ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println("PQ1.hashCode() == PQ2.hashCode()? " + (pq1.hashCode() == pq2.hashCode() ? "Sim (Falhou)" : "Não (Passou)"));
        System.out.println();

        System.out.println("9. Teste dos Métodos toString");
        PriorityQueueLinkedListUnordered<String> pq3 = new PriorityQueueLinkedListUnordered<String>();
        pq3.enqueue("Alpha", 5);
        pq3.enqueue("Beta", 3);
        pq3.enqueue("Gamma", 4);
        System.out.println("PQ3: " + pq3);


        System.out.println("10. Teste de Exceções");
        PriorityQueueLinkedListUnordered<String> emptyPQ = new PriorityQueueLinkedListUnordered<String>();
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

        System.out.println("11. Teste de Inserção com Prioridades Iguais (FIFO)");
        PriorityQueueLinkedListUnordered<String> pq4 = new PriorityQueueLinkedListUnordered<String>();
        pq4.enqueue("First", 5);
        pq4.enqueue("Second", 5);
        pq4.enqueue("Third", 5);
        System.out.println("Fila após enqueues com prioridades iguais: " + pq4);
        System.out.println("Dequeue 1 (esperado: First): " + pq4.dequeue());
        System.out.println("Dequeue 2 (esperado: Second): " + pq4.dequeue());
        System.out.println("Dequeue 3 (esperado: Third): " + pq4.dequeue());
        System.out.println("Fila após dequeues: " + pq4);
        System.out.println("Fila está vazia? " + (pq4.isEmpty() ? "Sim (Passou)" : "Não (Falhou)"));
        System.out.println();

        System.out.println("12. Teste do Método size");
        PriorityQueueLinkedListUnordered<Integer> pq5 = new PriorityQueueLinkedListUnordered<Integer>();
        System.out.println("Tamanho inicial: " + pq5.size() + " (Esperado: 0)");
        pq5.enqueue(10, 1);
        pq5.enqueue(20, 2);
        pq5.enqueue(30, 3);
        System.out.println("Tamanho após enqueues: " + pq5.size() + " (Esperado: 3)");
        pq5.dequeue();
        System.out.println("Tamanho após um dequeue: " + pq5.size() + " (Esperado: 2)");
        pq5.clear();
        System.out.println("Tamanho após clear: " + pq5.size() + " (Esperado: 0)");
        System.out.println();

        System.out.println("===== Testes Concluídos =====");
    }
}
