package Tree.tests;

import Tree.ArvoreBinaria;

import java.util.Arrays;

public class TestArvoreBinaria {
    public static void main(String[] args) throws Exception {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        System.out.println("### Testes da Árvore Binária de Busca ###");
        System.out.println("\n1. Inserindo elementos na árvore:");
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);
        arvore.inserir(50);

        ArvoreBinaria<Integer> arvoreClone = new ArvoreBinaria<>(arvore);
        @SuppressWarnings("unchecked")
        ArvoreBinaria<Integer> arvoreClone2 = (ArvoreBinaria<Integer>) arvore.clone();

        int elementosEmComumArvoreEArvoreClone = arvore.elementosEmComum(arvoreClone);
        int elementosEmComumArvoreEArvoreClone2 = arvore.elementosEmComum(arvoreClone2);

        System.out.println("Árvore: " + arvore);
        System.out.println("arvoreCopia: " + arvoreClone);
        System.out.println("arvoreClone: " + arvoreClone2);

        System.out.println("Elementos em comum entre arvore e arvoreCopia: " + elementosEmComumArvoreEArvoreClone);
        System.out.println("Elementos em comum entre arvore e arvoreClone: " + elementosEmComumArvoreEArvoreClone2);

        System.out.println("Árvore inicial: " + arvore);
        System.out.println("isBalanceada:   " + arvore.estaBalanceada());
        System.out.println("Altura:         " + arvore.altura());
        System.out.println("Maior elemento: " + arvore.getMaior());
        System.out.println("Menor elemento: " + arvore.getMenor());

        System.out.println("Testes de travessia em String");
        System.out.println("Travessia   in-order (String):      " + arvore.inOrderTraverse());
        System.out.println("Travessia  pre-order (String):      " + arvore.preOrderTraverse());
        System.out.println("Travessia post-order (String):      " + arvore.postOrderTraverse());

        System.out.println("Testes de travessia em LinkedList");
        System.out.println("Travessia   in-order (LinkedList):  " + arvore.inOrderToList());
        System.out.println("Travessia  pre-order (LinkedList):  " + arvore.preOrderToList());
        System.out.println("Travessia post-order (LinkedList):  " + arvore.postOrderToList());

        System.out.println("Testes de travessia em array");
        System.out.println("Travessia   in-order (Array):       " + Arrays.toString(arvore.inOrderToArray()));
        System.out.println("Travessia  pre-order (Array):       " + Arrays.toString(arvore.preOrderToArray()));
        System.out.println("Travessia post-order (Array):       " + Arrays.toString(arvore.postOrderToArray()));

        System.out.println("Balanceando a árvore...");
        arvore.balancear(); // Chamada única para balancear
        System.out.println("Árvore balanceada:  " + arvore);
        System.out.println("isBalanceada:       " + arvore.estaBalanceada()); // Verifica após balancear
        System.out.println("Testes de travessia em String");
        System.out.println("Travessia   in-order (String):      " + arvore.inOrderTraverse());
        System.out.println("Travessia  pre-order (String):      " + arvore.preOrderTraverse());
        System.out.println("Travessia post-order (String):      " + arvore.postOrderTraverse());

        System.out.println("Testes de travessia em LinkedList");
        System.out.println("Travessia   in-order (LinkedList):  " + arvore.inOrderToList());
        System.out.println("Travessia  pre-order (LinkedList):  " + arvore.preOrderToList());
        System.out.println("Travessia post-order (LinkedList):  " + arvore.postOrderToList());

        System.out.println("Testes de travessia em array");
        System.out.println("Travessia   in-order (Array):       " + Arrays.toString(arvore.inOrderToArray()));
        System.out.println("Travessia  pre-order (Array):       " + Arrays.toString(arvore.preOrderToArray()));
        System.out.println("Travessia post-order (Array):       " + Arrays.toString(arvore.postOrderToArray()));

        System.out.println("Espelhando a árvore...");
        arvore.espelhar();
        System.out.println("Árvore espelhada:    " + arvore);

        System.out.println("Altura:             " + arvore.altura());

        System.out.println("\n2. Removendo elementos da árvore:");
        arvore.remova(50);
        System.out.println("Removendo 50: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada());
        arvore.balancear(); // Chamada única para balancear
        System.out.println("arvore balanceada: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada()); // Verifica após balancear
        arvore.remova(30);
        System.out.println("Removendo 30: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada());
        arvore.balancear(); // Chamada única para balancear
        System.out.println("arvore balanceada: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada()); // Verifica após balancear
        arvore.remova(40);
        System.out.println("Removendo 40: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada());
        arvore.balancear(); // Chamada única para balancear
        System.out.println("arvore balanceada: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada()); // Verifica após balancear
        arvore.remova(80);
        System.out.println("Removendo 80: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada());
        arvore.balancear(); // Chamada única para balancear
        System.out.println("arvore balanceada: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada()); // Verifica após balancear
        arvore.remova(20);
        System.out.println("Removendo 20: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada());
        arvore.balancear(); // Chamada única para balancear
        System.out.println("arvore balanceada: " + arvore);
        System.out.println("isBalanceada: " + arvore.estaBalanceada()); // Verifica após balancear

        System.out.println("----------------------------------------------------------------");
        ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>();
        System.out.println("\n1. Inserindo elementos na árvore:");
        arvore2.inserir(5);
        arvore2.inserir(10);
        arvore2.inserir(30);
        arvore2.inserir(70);
        arvore2.inserir(20);
        arvore2.inserir(40);
        arvore2.inserir(60);
        arvore2.inserir(80);
        arvore2.inserir(50);
        System.out.println("Árvore inicial: " + arvore2);
        System.out.println("isBalanceada:   " + arvore2.estaBalanceada());
        arvore2.balancear();
        arvore2.balancear();

        System.out.println("Árvore balanceada:  " + arvore2);
        System.out.println("isBalanceada:   " + arvore2.estaBalanceada());
        arvore2.balancear();
        System.out.println("Árvore balanceada:  " + arvore2);
        System.out.println("isBalanceada:   " + arvore2.estaBalanceada());
        arvore2.balancear();
        System.out.println("Árvore balanceada:  " + arvore2);
        System.out.println("isBalanceada:   " + arvore2.estaBalanceada());
        arvore2.balancear();
        System.out.println("Árvore balanceada:  " + arvore2);
        System.out.println("isBalanceada:   " + arvore2.estaBalanceada());
    }
}