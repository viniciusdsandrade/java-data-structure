package LinkedList.Disordered;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListDisordered<X> implements Cloneable {

    public class Node implements Cloneable {
        public X elemento;
        public Node proximo;
        public Node anterior;

        public Node() {
        }
        public Node(X elemento) {
            this.elemento = elemento;
            this.proximo = null;
            this.anterior = null;
        }
        public X getElemento() {
            return elemento;
        }
        public Node getProximo() {
            return proximo;
        }
        public Node getAnterior() {
            return anterior;
        }

        @SuppressWarnings("unchecked")
        public Node(Node modelo) {
            if (modelo == null) throw new IllegalArgumentException("Modelo ausente");

            this.elemento = (X) verifyAndCopy(modelo.elemento);
            this.proximo = (Node) verifyAndCopy(modelo.proximo);
            this.anterior = (Node) verifyAndCopy(modelo.anterior);
        }

        @Override
        public Object clone() {
            Node clone = null;

            try {
                clone = new Node(this);
            } catch (Exception ignored) {
            }
            
            return clone;
        }
    }

    public Node primeiro;
    public Node ultimo;
    private int tamanho;

    public DoubleLinkedListDisordered() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }
    public Node getPrimeiro() {
        return primeiro;
    }
    public Node getUltimo() {
        return ultimo;
    }
    public int getTamanho() {
        return tamanho;
    }

    public void add(X elemento) {
        Node novo = new Node(elemento);

        if (primeiro == null) {
            primeiro = novo;
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
        }
        ultimo = novo;
        tamanho++;
    }

    @Override
    public Object clone() {

        DoubleLinkedListDisordered<X> clone = null;

        try {
            clone = new DoubleLinkedListDisordered<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedListDisordered(DoubleLinkedListDisordered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo ausente");

        Node atual = modelo.primeiro;
        Node novo;

        while (atual != null) {
            novo = new Node();
            novo.elemento = (X) verifyAndCopy(atual.elemento);
            novo.anterior = ultimo;
            if (ultimo != null) {
                ultimo.proximo = novo;
            } else {
                primeiro = novo;
            }
            ultimo = novo;
            atual = atual.proximo;
        }

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    public String toString() {
        if (primeiro == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        Node temp = primeiro;
        boolean primeiroElemento = true;

        while (temp != null) {
            if (!primeiroElemento) {
                result.append(" <-> ");
            } else {
                primeiroElemento = false;
            }
            result.append(temp.elemento);
            temp = temp.proximo;
        }

        result.append("]");
        return result.toString();
    }
}