package LinkedList.Tests.Unordered.DoubleLinkedListCircularUnordered;

import LinkedList.Unordered.DoubleLinkedListCircularUnordered;

public class TestDoubleLinkedListCircularUnordered {

    // Método para verificar se a lista é duplamente ligada
    public static <X> boolean verificaDuplamenteLigada(DoubleLinkedListCircularUnordered<X> lista) {
        // Se a lista estiver vazia ou tiver apenas um elemento, ela é considerada duplamente ligada
        if (lista.getPrimeiro() == null || lista.getPrimeiro() == lista.getUltimo()) return true;

        // Começamos a verificação a partir do primeiro nó
        DoubleLinkedListCircularUnordered<X>.Node atual = lista.getPrimeiro();

        // Percorremos a lista até o último nó
        while (atual != lista.getUltimo()) {
            // Se o nó anterior ao próximo não for o nó atual, a lista não está duplamente ligada
            if (atual.proximo.anterior != atual)
                return false;

            // Avançamos para o próximo nó
            atual = atual.proximo;
        }

        // Verificamos se o nó anterior ao primeiro é o último, o que é esperado em uma lista duplamente ligada
        return lista.getPrimeiro().anterior == lista.getUltimo();
    }

    // Método para verificar se a lista é circular
    public static <X> boolean verificaCircularidade(DoubleLinkedListCircularUnordered<X> lista) {
        // Se a lista estiver vazia, ela não é circular
        if (lista.getPrimeiro() == null || lista.getUltimo() == null) return false;

        // Verificamos se o nó anterior ao primeiro é o último e se o nó seguinte ao último é o primeiro
        boolean anteriorDoPrimeiroApontaUltimo = lista.primeiro.anterior == lista.ultimo;
        boolean proximoDoUltimoApontaPrimeiro = lista.ultimo.proximo == lista.primeiro;

        // Se ambas as condições forem verdadeiras, a lista é circular
        return anteriorDoPrimeiroApontaUltimo && proximoDoUltimoApontaPrimeiro;
    }

    public static void main(String[] args) {
        DoubleLinkedListCircularUnordered<Integer> int_list = new DoubleLinkedListCircularUnordered<>();
        int_list.addFirst(1);
        int_list.addFirst(2);
        int_list.addFirst(3);
        int_list.addFirst(4);
        int_list.addFirst(5);

        System.out.println("Lista:          " + int_list);
        boolean isDuplamenteLigada = verificaDuplamenteLigada(int_list);
        boolean isCircular = verificaCircularidade(int_list);

        // Impressão dos resultados
        System.out.println("Nós  duplamente ligados: " + isDuplamenteLigada);
        System.out.println("Lista é circular:        " + isCircular);

        // Adicionando um elemento ao final da lista
        int_list.addLast(6);
        System.out.println("int_list.addLast(6):    " + int_list);

        // Adicionando elemento 7 na posição 4 da lista
        int_list.addAt(7, 3);
        System.out.println("int_list.addAt(7, 3):   " + int_list);
        
        // Removendo o elemento 7 da lista
        int_list.removeAt(3);
        System.out.println("int_list.removeAt(3):   " + int_list);
        
        // Removendo o primeiro elemento da lista
        int_list.removeFirst();
        System.out.println("int_list.removeFirst(): " + int_list);
        
        // Removendo o último elemento da lista
        int_list.removeLast();
        System.out.println("int_list.removeLast():  " + int_list);
        
        // Removendo o elemento 3 elemento da lista
        int_list.removeAt(2);
        System.out.println("int_list.removeAt(2):   " + int_list);
        
        int first = int_list.getFirst();
        int last = int_list.getLast();
        int at = int_list.get(1);
        
        // Impressão dos resultados
        System.out.println("lista:              " + int_list);
        System.out.println("int_list.getFirst() " + first);
        System.out.println("int_list.getLast()  " + last);
        System.out.println("int_list.get(1):    " + at);
        
        int indexOf = int_list.indexOf(3);
        System.out.println("Index of 3 in list: " + indexOf);
        
        boolean containsThree = int_list.contains(3);
        System.out.println("Contains 3:         " + containsThree);
        
        boolean containsFour = int_list.contains(4);
        System.out.println("Contains 4:         " + containsFour);
        
        boolean containsFive = int_list.contains(5);
        System.out.println("Contains 5:         " + containsFive);

        System.out.println("int_list: " + int_list);
        int_list.reverse();
        System.out.println("reverse:  " + int_list);
        
        int_list.addFirst(1);
        System.out.println("addFirst(1): " + int_list);

        int_list.rotate(0);
        System.out.println("rotate(0): " + int_list);

        int_list.rotate(1);
        System.out.println("rotate(1): " + int_list);
        
        int_list.rotate(1);
        System.out.println("rotate(1): " + int_list);
        
        int_list.rotate(1);
        System.out.println("rotate(1): " + int_list);

        int_list.rotate(1);
        System.out.println("rotate(1): " + int_list);
        
        int_list.rotate(4);
        System.out.println("rotate(4): " + int_list);

        boolean isEmpty = int_list.isEmpty();
        System.out.println("isEmpty:  " + isEmpty);
        int_list.clear();
        System.out.println("clear:    " + int_list);
        
        isEmpty = int_list.isEmpty();
        System.out.println("isEmpty:  " + isEmpty);

        DoubleLinkedListCircularUnordered<Integer> int_list2 = new DoubleLinkedListCircularUnordered<>();
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.addFirst(1);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.addFirst(2);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
    }
}
