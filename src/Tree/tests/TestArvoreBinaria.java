package Tree.tests;

import LinkedList.Disordered.LinkedListDisordered;
import LinkedList.Ordered.LinkedListOrdered;
import Tree.ArvoreBinaria;
import Tree.No;

public class TestArvoreBinaria {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        System.out.println("### Testes da Árvore Binária de Busca ###");

        // Testando inserção e impressão da árvore
        System.out.println("\n1. Inserindo elementos na árvore:");
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);
        System.out.println("Árvore inicial:\n" + arvore);

        // Testando método contem
        System.out.println("\n2. Testando método contem():");
        System.out.println("Contém 50? " + arvore.contem(50));
        System.out.println("Contém 25? " + arvore.contem(25));

        // Testando método achar
        System.out.println("\n3. Testando método achar():");
        System.out.println("Nó 70: " + arvore.achar(70));
        System.out.println("Nó 25: " + arvore.achar(25)); // Deve retornar null

        // Testando métodos de verificação de balanceamento
        System.out.println("\n4. Testando balanceamento:");
        System.out.println("  4.1. Árvore está balanceada? " + arvore.estaBalanceada());
        arvore.inserir(10);
        arvore.inserir(5);
        System.out.println("  4.2. Árvore está balanceada após inserções? " + arvore.estaBalanceada());
        System.out.println("  4.3. Árvore desbalanceada:\n" + arvore);

        // Testando balanceamento da árvore
        System.out.println("\n  4.4. Balanceando a árvore:");
        arvore.balancearArvore();
        System.out.println("  4.5. Árvore balanceada:\n" + arvore);
        System.out.println("  4.6. Árvore está balanceada após balanceamento? " + arvore.estaBalanceada());

        // Testando espelhamento da árvore
        System.out.println("\n5. Espelhando a árvore:");
        arvore.espelhar();
        System.out.println("  5.1. Árvore espelhada:\n" + arvore);

        // Testando métodos de cópia
        System.out.println("\n6. Testando métodos de cópia:");
        ArvoreBinaria<Integer> copia = new ArvoreBinaria<>(arvore);
        @SuppressWarnings("unchecked")
        ArvoreBinaria<Integer> clone = (ArvoreBinaria<Integer>) arvore.clone();
        System.out.println("  6.1. hashCode da árvore: " + arvore.hashCode());
        System.out.println("  6.2. hashCode da cópia:  " + copia.hashCode());
        System.out.println("  6.3. hashCode do clone:  " + clone.hashCode());
        System.out.println("  6.4. arvore.equals(copia): " + arvore.equals(copia));
        System.out.println("  6.5. arvore.equals(clone): " + arvore.equals(clone));

        // Testando altura e profundidade
        System.out.println("\n7. Testando altura e profundidade:");
        System.out.println("  7.1. Altura da árvore: " + arvore.altura());
        System.out.println("  7.2. Profundidade do nó 80: " + arvore.profundidade(new No<>(80)));
        System.out.println("  7.3. Profundidade do nó 5: " + arvore.profundidade(new No<>(5)));

        // Testando tamanho da árvore
        System.out.println("\n8. Testando tamanho da árvore:");
        System.out.println("  8.1. Tamanho da árvore: " + arvore.tamanho());

        // Testando método limpar
        System.out.println("\n9. Testando método limpar:");
        System.out.println("  9.1. Árvore está vazia? " + arvore.estaVazio());
        arvore.limpar();
        System.out.println("  9.2. Árvore está vazia após limpar? " + arvore.estaVazio());
        System.out.println("  9.3. Árvore após limpar:\n" + arvore);

        // Testando método toLinkedList
        System.out.println("\n10. Testando método toLinkedList():");
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);
        System.out.println("  10.1. Árvore:\n" + arvore);
        LinkedListOrdered<Integer> linkedList = arvore.toLinkedList();
        System.out.println("  10.2. LinkedList: " + linkedList);
    }
}