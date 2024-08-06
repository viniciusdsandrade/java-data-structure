package Tree.tests;

import Tree.ArvoreBinaria;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore1 = new ArvoreBinaria<>();
        arvore1.inserir(30);
        arvore1.inserir(70);
        arvore1.inserir(20);
        arvore1.inserir(40);
        arvore1.inserir(60);
        arvore1.inserir(80);
        arvore1.inserir(50);
        System.out.println("Árvore 1: " + arvore1);

        // Testando o construtor de cópia
        ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>(arvore1);
        System.out.println("Árvore 1 com construtor de cópia: " + arvore2);

        // Testando o metodo clone
        @SuppressWarnings("unchecked")
        ArvoreBinaria<Integer> arvore3 = (ArvoreBinaria<Integer>) arvore1.clone();
        System.out.println("Árvore 1 com método clone: " + arvore3);

        // Agora vamos fazer alterações na árvore 1 e verificar se as alterações
        // Vamos Balançar a árvore 1
        arvore1.balancear();
        System.out.println("Árvore 1 balanceada: " + arvore1);

        // Verificando se as alterações foram feitas nas outras árvores
        System.out.println("Árvore 2: " + arvore2);
        System.out.println("Árvore 3: " + arvore3);

        // Agora vamos espelhar a árvore 1 e verificar se as alterações foram feitas nas outras árvores
        arvore1.espelhar();
        System.out.println("Árvore 1 espelhada: " + arvore1);
        System.out.println("Árvore 2: " + arvore2);
        System.out.println("Árvore 3: " + arvore3);
    }
}