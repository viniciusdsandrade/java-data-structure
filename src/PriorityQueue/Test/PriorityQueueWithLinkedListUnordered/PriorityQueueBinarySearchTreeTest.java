package PriorityQueue.Test.PriorityQueueWithLinkedListUnordered;

import PriorityQueue.PriorityQueueBinarySearchTree;

import java.util.NoSuchElementException;

public class PriorityQueueBinarySearchTreeTest {

    public static void main(String[] args) {
        System.out.println("Iniciando testes da PriorityQueueBinarySearchTree...\n");

        testEnqueue();
        testDequeue();
        testPeek();
        testSize();
        testEstaVazio();
        testToString();
        testClone();
        testEquals();

        System.out.println("\nTodos os testes foram concluídos.");
    }

    // Teste do método enqueue
    private static void testEnqueue() {
        System.out.println("Teste: enqueue()");
        PriorityQueueBinarySearchTree<String> pq = new PriorityQueueBinarySearchTree<String>();

        try {
            pq.enqueue("A", 5);
            pq.enqueue("B", 3);
            pq.enqueue("C", 8);
            pq.enqueue("D", 1);
            pq.enqueue("E", 10);
            System.out.println("enqueue() executado com sucesso.");
            System.out.println("Fila após enfileiramento: " + pq);
        } catch (Exception e) {
            System.out.println("Erro no enqueue(): " + e.getMessage());
        }

        // Teste de enfileiramento com elemento nulo
        try {
            pq.enqueue(null, 4);
            System.out.println("Erro: enqueue() permitiu elemento nulo.");
        } catch (IllegalArgumentException e) {
            System.out.println("enqueue() corretamente lançou IllegalArgumentException para elemento nulo.");
        }

        System.out.println();
    }

    // Teste do método dequeue
    private static void testDequeue() {
        System.out.println("Teste: dequeue()");
        PriorityQueueBinarySearchTree<String> pq = new PriorityQueueBinarySearchTree<String>();
        pq.enqueue("A", 5);
        pq.enqueue("B", 3);
        pq.enqueue("C", 8);
        pq.enqueue("D", 1);
        pq.enqueue("E", 10);

        try {
            String elemento = pq.dequeue();
            System.out.println("Elemento desenfileirado: " + elemento);
            assert elemento.equals("E") : "Desenfileirou o elemento errado.";
            System.out.println("dequeue() executado com sucesso.");
            System.out.println("Fila após desenfileiramento: " + pq);
        } catch (Exception e) {
            System.out.println("Erro no dequeue(): " + e.getMessage());
        }

        // Teste de desenfileiramento em fila vazia
        PriorityQueueBinarySearchTree<String> pqVazia = new PriorityQueueBinarySearchTree<String>();
        try {
            pqVazia.dequeue();
            System.out.println("Erro: dequeue() permitiu desenfileirar de uma fila vazia.");
        } catch (NoSuchElementException e) {
            System.out.println("dequeue() corretamente lançou NoSuchElementException para fila vazia.");
        }

        System.out.println();
    }

    // Teste do método peek
    private static void testPeek() {
        System.out.println("Teste: peek()");
        PriorityQueueBinarySearchTree<String> pq = new PriorityQueueBinarySearchTree<String>();
        pq.enqueue("A", 5);
        pq.enqueue("B", 3);
        pq.enqueue("C", 8);

        try {
            String elemento = pq.peek();
            System.out.println("Elemento no topo: " + elemento);
            assert elemento.equals("C") : "peek() retornou o elemento errado.";
            System.out.println("peek() executado com sucesso.");
            System.out.println("Fila após peek(): " + pq);
        } catch (Exception e) {
            System.err.println("Erro no peek(): " + e.getMessage());
        }

        // Teste de peek em fila vazia
        PriorityQueueBinarySearchTree<String> pqVazia = new PriorityQueueBinarySearchTree<String>();
        try {
            pqVazia.peek();
            System.err.println("Erro: peek() permitiu visualizar elemento de uma fila vazia.");
        } catch (NoSuchElementException e) {
            System.out.println("peek() corretamente lançou NoSuchElementException para fila vazia.");
        }

        System.out.println();
    }

    private static void testSize() {
        System.out.println("Teste: size()");
        PriorityQueueBinarySearchTree<String> pq = new PriorityQueueBinarySearchTree<String>();
        assert pq.size() == 0 : "Size inicial deve ser 0.";
        pq.enqueue("A", 5);
        pq.enqueue("B", 3);
        pq.enqueue("C", 8);
        assert pq.size() == 3 : "Size após enfileiramento deve ser 3.";
        System.out.println("size() retornou corretamente: " + pq.size());
        System.out.println();
    }

    private static void testEstaVazio() {
        System.out.println("Teste: estaVazio()");
        PriorityQueueBinarySearchTree<String> pq = new PriorityQueueBinarySearchTree<String>();
        assert pq.estaVazio() : "Fila recém-criada deve estar vazia.";
        pq.enqueue("A", 5);
        assert !pq.estaVazio() : "Fila com elementos não deve estar vazia.";
        System.out.println("estaVazio() retornou corretamente.");
        System.out.println();
    }

    private static void testToString() {
        System.out.println("Teste: toString()");
        PriorityQueueBinarySearchTree<String> pq = new PriorityQueueBinarySearchTree<String>();
        pq.enqueue("A", 5);
        pq.enqueue("B", 3);
        pq.enqueue("C", 8);
        pq.enqueue("D", 1);
        pq.enqueue("E", 10);

        String representacao = pq.toString();
        System.out.println("Representação da fila: " + representacao);
        // A representação depende da ordem in-order da árvore binária de busca
        // Não há uma forma específica esperada sem saber a implementação da árvore
        System.out.println("toString() executado com sucesso.");
        System.out.println();
    }

    private static void testClone() {
        System.out.println("Teste: clone()");
        PriorityQueueBinarySearchTree<String> pq = new PriorityQueueBinarySearchTree<String>();
        pq.enqueue("A", 5);
        pq.enqueue("B", 3);
        pq.enqueue("C", 8);

        PriorityQueueBinarySearchTree<String> pqClone = pq.clone();

        System.out.println("Fila original: " + pq);
        System.out.println("Fila clonada: " + pqClone);

        assert pq.equals(pqClone) : "Clone deve ser igual ao original.";

        // Modificando o clone e verificando a independência
        pqClone.enqueue("D", 10);
        assert !pq.equals(pqClone) : "Após modificação, clone e original não devem ser iguais.";

        System.out.println("clone() executado com sucesso e verificação de independência realizada.");
        System.out.println();
    }

    private static void testEquals() {
        System.out.println("Teste: equals()");
        PriorityQueueBinarySearchTree<String> pq1 = new PriorityQueueBinarySearchTree<String>();
        PriorityQueueBinarySearchTree<String> pq2 = new PriorityQueueBinarySearchTree<String>();
        PriorityQueueBinarySearchTree<String> pq3 = new PriorityQueueBinarySearchTree<String>();

        pq1.enqueue("A", 5);
        pq1.enqueue("B", 3);
        pq1.enqueue("C", 8);

        pq2.enqueue("A", 5);
        pq2.enqueue("B", 3);
        pq2.enqueue("C", 8);

        pq3.enqueue("A", 5);
        pq3.enqueue("B", 4); // Prioridade diferente
        pq3.enqueue("C", 8);

        // Teste de igualdade
        assert pq1.equals(pq2) : "pq1 deve ser igual a pq2.";
        assert !pq1.equals(pq3) : "pq1 não deve ser igual a pq3.";
        assert !pq1.equals(null) : "pq1 não deve ser igual a null.";
        assert !pq1.equals("Fila") : "pq1 não deve ser igual a um objeto de outro tipo.";

        System.out.println("equals() retornou corretamente para diferentes cenários.");
        System.out.println();
    }
}
