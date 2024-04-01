package LinkedList.Tests.Disordered.DoubleLinkedListCircularDisordered;

import LinkedList.Disordered.DoubleLinkedListCircularDisordered;

public class TestDoubleLinkedListCircularDisordered {

    public static boolean verificaDuplamenteLigada(DoubleLinkedListCircularDisordered<Integer> lista) {
        // Se a lista estiver vazia ou tiver apenas um elemento, ela é considerada duplamente ligada
        if (lista.getPrimeiro() == null || lista.getPrimeiro() == lista.getUltimo()) return true;

        // Começamos a verificação a partir do primeiro nó
        DoubleLinkedListCircularDisordered<Integer>.Node atual = lista.getPrimeiro();

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

    public static <X> boolean verificaCircularidade(DoubleLinkedListCircularDisordered<X> lista) {
        // Se a lista estiver vazia, ela não é circular
        if (lista.getPrimeiro() == null || lista.getUltimo() == null) return false;

        // Verificamos se o nó anterior ao primeiro é o último e se o nó seguinte ao último é o primeiro
        boolean anteriorDoPrimeiroApontaUltimo = lista.primeiro.anterior == lista.ultimo;
        boolean proximoDoUltimoApontaPrimeiro = lista.ultimo.proximo == lista.primeiro;

        // Se ambas as condições forem verdadeiras, a lista é circular
        return anteriorDoPrimeiroApontaUltimo && proximoDoUltimoApontaPrimeiro;
    }

    public static void main(String[] args) {
        DoubleLinkedListCircularDisordered<Integer> int_list = new DoubleLinkedListCircularDisordered<>();
        int_list.addFirst(1);
        int_list.addFirst(2);
        int_list.addFirst(3);
        int_list.addFirst(4);
        int_list.addFirst(5);

        System.out.println("Lista:          " + int_list);
        // Verificação do encadeamento de todos os nós
        boolean isDuplamenteLigada = verificaDuplamenteLigada(int_list);
        boolean isCircular = verificaCircularidade(int_list);

        // Impressão dos resultados
        System.out.println("Nós estão duplamente ligados: " + isDuplamenteLigada);
        System.out.println("A lista é circular:           " + isCircular);

        DoubleLinkedListCircularDisordered<Character> chars = new DoubleLinkedListCircularDisordered<>();
        chars.addLast('n');
        chars.addLast('i');
        chars.addLast('c');
        chars.addLast('i');
        chars.addLast('u');
        chars.addLast('s');
        chars.addFirst('v');
        System.out.println(chars);
        chars.addAt('i', 1);
        System.out.println(chars);

        chars.rotate(3);
        System.out.println("rotate(3):  " + chars);

        chars.rotate(-3);
        System.out.println("rotate(-3): " + chars);

        chars.reverse();
        System.out.println("reverse():  " + chars);

        DoubleLinkedListCircularDisordered<Integer> list = new DoubleLinkedListCircularDisordered<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
    }
}
