package Tree.tests;

import Tree.ArvoreBinaria;

public class TestArvoreBinaria {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.insert(50);
        arvore.insert(30);
        arvore.insert(70);
        arvore.insert(20);
        arvore.insert(40);
        arvore.insert(60);
        arvore.insert(80);

        ArvoreBinaria<Integer> copia = new ArvoreBinaria<>(arvore);
        @SuppressWarnings("unchecked")
        ArvoreBinaria<Integer> clone = (ArvoreBinaria<Integer>) arvore.clone();

        System.out.println("hashCode da árvore: " + arvore.hashCode());
        System.out.println("hashCode do copia:  " + copia.hashCode());
        System.out.println("hashCode do copia:  " + clone.hashCode());

        System.out.println("arvore.equals(copia): " + arvore.equals(copia));
        System.out.println("arvore.equals(clone): " + arvore.equals(clone));

        System.out.println("Árvore: " + arvore);
        System.out.println("Cópia:  " + copia);
        System.out.println("Clone:  " + clone);

        // Verificar o tamanho da árvore
        System.out.println("Tamanho da árvore: " + arvore.size());

        // Imprimir a árvore
        System.out.println("Árvore: " + arvore);

        // Verificar se a árvore está vazia
        System.out.println("Árvore está vazia? " + arvore.isEmpty());

        // Limpar a árvore
        arvore.clear();

        // Verificar se a árvore está vazia novamente
        System.out.println("Árvore está vazia? " + arvore.isEmpty());
    }
}