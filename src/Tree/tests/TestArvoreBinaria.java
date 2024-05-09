package Tree.tests;

import Tree.ArvoreBinaria;
import Tree.No;

public class TestArvoreBinaria {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(50);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);
        // Valores adicionados anteriormente
//        arvore.inserir(15);
//        arvore.inserir(35);
//        arvore.inserir(65);
//        arvore.inserir(85);
//        arvore.inserir(10);
//        arvore.inserir(45);
//        arvore.inserir(75);
//        arvore.inserir(90);
//        // Novos valores adicionados abaixo
//        arvore.inserir(5);
//        arvore.inserir(25);
//        arvore.inserir(55);
//        arvore.inserir(95);
//        arvore.inserir(17);
//        arvore.inserir(37);
//        arvore.inserir(67);
//        arvore.inserir(87);

        // Inserindo números ímpares até 100
        // for (int i = 1; i <= 100; i += 2) arvore.inserir(i);

        ArvoreBinaria<Integer> copia = new ArvoreBinaria<>(arvore);
        @SuppressWarnings("unchecked")
        ArvoreBinaria<Integer> clone = (ArvoreBinaria<Integer>) arvore.clone();


        System.out.println("Arvore balanceada está balanceada? " + arvore.estaBalanceada());
        System.out.println("Arvore: " + arvore);
        arvore.balancearArvore();
        System.out.println("Arvore balanceada: " + arvore);
        System.out.println("Arvore balanceada está balanceada? " + arvore.estaBalanceada());

        System.out.println();
        System.out.println("hashCode da árvore: " + arvore.hashCode());
        System.out.println("hashCode do copia:  " + copia.hashCode());
        System.out.println("hashCode do copia:  " + clone.hashCode());

        System.out.println("arvore.equals(copia): " + arvore.equals(copia));
        System.out.println("arvore.equals(clone): " + arvore.equals(clone));

        System.out.println("Árvore: " + arvore);
        System.out.println("Cópia:  " + copia);
        System.out.println("Clone:  " + clone);

        System.out.println("A árvore está balanceada? " + arvore.estaBalanceada());

        // Verificar Altura
        System.out.println("Altura da árvore: " + arvore.altura());

        // Verificar Profundidade
        System.out.println("Profundidade do nó 80: " + arvore.profundidade(new No<>(80)));

        // Verificar o tamanho da árvore
        System.out.println("Tamanho da árvore: " + arvore.tamanho());

        // Imprimir a árvore
        System.out.println("Árvore: " + arvore);

        // Verificar se a árvore está vazia
        System.out.println("Árvore está vazia? " + arvore.estaVazio());

        // Limpar a árvore
        arvore.limpar();

        // Verificar se a árvore está vazia novamente
        System.out.println("Árvore está vazia? " + arvore.estaVazio());
    }
}