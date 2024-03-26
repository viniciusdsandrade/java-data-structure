package LinkedList.Tests.Disordered.DoubleLinkedListDisordered;

import LinkedList.Disordered.DoubleLinkedListDisordered;

public class TestDoubleLinkedListDisordered {
    public static void main(String[] args) {
        // Criando uma instância da lista duplamente ligada
        DoubleLinkedListDisordered<Integer> lista = new DoubleLinkedListDisordered<>();

        // Adicionando alguns elementos à lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        // Testando a impressão da lista para verificar a ordem
        System.out.println("Lista (frente para trás): " + lista);

        // Testando a impressão reversa da lista para verificar a ordem reversa
        System.out.println("Lista (trás para frente): " + printReversed(lista));

        // Verificando a conexão dos nós para frente
        validateForwardConnection(lista);

        // Verificando a conexão dos nós para trás
        validateBackwardConnection(lista);
    }

    // Método para imprimir a lista na ordem inversa (do último para o primeiro)
    private static String printReversed(DoubleLinkedListDisordered<?> lista) {
        if (lista == null || lista.getUltimo() == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        DoubleLinkedListDisordered.Node temp = lista.getUltimo();
        boolean primeiroElemento = true;

        while (temp != null) {
            if (!primeiroElemento) {
                result.append(" <-> ");
            } else {
                primeiroElemento = false;
            }
            result.append(temp.elemento);
            temp = temp.anterior;
        }

        result.append("]");
        return result.toString();
    }

    // Método para validar a conexão dos nós para frente
    private static void validateForwardConnection(DoubleLinkedListDisordered<?> lista) {
        DoubleLinkedListDisordered.Node temp = lista.getPrimeiro();

        while (temp != null && temp.proximo != null) {
            if (temp.proximo.anterior != temp) {
                System.out.println("Erro: Nó " + temp.elemento + " não está conectado corretamente para frente.");
                return;
            }
            temp = temp.proximo;
        }
        System.out.println("Todos os nós estão conectados corretamente para frente.");
    }

    // Método para validar a conexão dos nós para trás
    private static void validateBackwardConnection(DoubleLinkedListDisordered<?> lista) {
        DoubleLinkedListDisordered.Node temp = lista.getUltimo();

        while (temp != null && temp.anterior != null) {
            if (temp.anterior.proximo != temp) {
                System.out.println("Erro: Nó " + temp.elemento + " não está conectado corretamente para trás.");
                return;
            }
            temp = temp.anterior;
        }
        System.out.println("Todos os nós estão conectados corretamente para trás.");
    }
}
