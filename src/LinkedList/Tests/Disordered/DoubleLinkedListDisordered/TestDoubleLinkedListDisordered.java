package LinkedList.Tests.Disordered.DoubleLinkedListDisordered;

import LinkedList.Disordered.DoubleLinkedListDisordered;

public class TestDoubleLinkedListDisordered {
    public static void main(String[] args) {
        DoubleLinkedListDisordered<Integer> list = new DoubleLinkedListDisordered<>();

        // Teste 1: Verificar se a lista está vazia
        System.out.println("Tamanho da lista: " + list.getTamanho()); // Deve imprimir 0

        // Teste 2: Adicionar elementos à lista
        list.primeiro = list.new Node(1);
        list.primeiro.proximo = list.new Node(2);
        list.primeiro.proximo.anterior = list.primeiro;
        list.tamanho = 2;

        System.out.println("Tamanho da lista: " + list.getTamanho()); // Deve imprimir 2

        // Teste 3: Verificar se os elementos estão corretamente ligados
        System.out.println("Primeiro elemento: " + list.getPrimeiro().elemento); // Deve imprimir 1
        System.out.println("Segundo elemento: " + list.getPrimeiro().proximo.elemento); // Deve imprimir 2
        System.out.println("Anterior do segundo elemento: " + list.getPrimeiro().proximo.anterior.elemento); // Deve imprimir 1
    }

}
