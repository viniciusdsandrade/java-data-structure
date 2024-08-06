package Tree.tests;

import Tree.ArvoreBinaria;

public class TestEqualsAndHashCode {

    public static void main(String[] args) {
        System.out.println("### Testes da Árvore Binária de Busca ###");
        System.out.println("\n1. Inserindo elementos na árvore:");
        ArvoreBinaria<Integer> arvore1 = new ArvoreBinaria<>();
        arvore1.inserir(30);
        arvore1.inserir(70);
        arvore1.inserir(20);
        arvore1.inserir(40);
        arvore1.inserir(60);
        arvore1.inserir(80);
        arvore1.inserir(50);
        System.out.println("Árvore 1: " + arvore1);

        ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>();
        arvore2.inserir(30);
        arvore2.inserir(70);
        arvore2.inserir(20);
        arvore2.inserir(40);
        arvore2.inserir(60);
        arvore2.inserir(80);
        arvore2.inserir(50);
        System.out.println("Árvore 2: " + arvore2);
        System.out.println("arvore1.equals(arvore2): " + arvore1.equals(arvore2));

        // Testando o hashCode
        System.out.println("arvore1.hashCode(): " + arvore1.hashCode());
        System.out.println("arvore2.hashCode(): " + arvore2.hashCode());

        // Agora vamos balancear a 'arvore1' e depois tentar comparar se ela continua 'equals' a 'arvore2'
        arvore1.balancear();

        System.out.println("Árvore 1: " + arvore1);
        System.out.println("Árvore 2: " + arvore2);

        System.out.println("arvore1.equals(arvore2): " + arvore1.equals(arvore2));

        System.out.println("arvore1.hashCode(): " + arvore1.hashCode());
        System.out.println("arvore2.hashcode(): " + arvore2.hashCode());
    }
}
