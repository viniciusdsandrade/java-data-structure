package LinkedList.Ordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListOrdered<X extends Comparable<X>> implements Cloneable {

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
        public Node(Node modelo) throws Exception {
            if (modelo == null) throw new Exception("Modelo não pode ser nulo.");

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

        @Override
        public int hashCode() {
            final int prime = 31;
            int hash = 1;

            hash *= prime + (this.elemento == null ? 0 : this.elemento.hashCode());

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Node other = (Node) obj;

            return Objects.equals(this.elemento, other.elemento);
        }

        @Override
        public String toString() {
            return this.elemento.toString();
        }
    }

    public Node primeiro;
    private int tamanho;

    public DoubleLinkedListOrdered() {
        this.primeiro = null;
        this.tamanho = 0;
    }
    public Node getPrimeiro() {
        return primeiro;
    }
    public int getTamanho() {
        return tamanho;
    }

    public void add(X elemento) {
        Node novo = new Node(elemento);
        Node temp = primeiro;
        Node anterior = null;

        while (temp != null && temp.elemento.compareTo(elemento) < 0) {
            anterior = temp;
            temp = temp.proximo;
        }

        if (anterior == null) {
            novo.proximo = primeiro;
            primeiro = novo;
        } else {
            novo.proximo = anterior.proximo;
            anterior.proximo = novo;
        }

        tamanho++;
    }

    public X get(int index) {
        if (index < 0 || index >= tamanho) return null;

        Node temp = primeiro;

        for (int i = 0; i < index; i++)
            temp = temp.proximo;

        return temp.elemento;
    }

    public X getFirst() {
        if (primeiro == null) return null;

        return primeiro.elemento;
    }

    public X getLast() {
        if (primeiro == null) return null;

        Node temp = primeiro;

        while (temp.proximo != null)
            temp = temp.proximo;

        return temp.elemento;
    }

    public void removeFirst() {
        if (primeiro == null) return;

        primeiro = primeiro.proximo;
        tamanho--;
    }

    public void removeLast() {
        if (primeiro == null) return;

        Node temp = primeiro;
        Node anterior = null;

        while (temp.proximo != null) {
            anterior = temp;
            temp = temp.proximo;
        }

        if (anterior == null) {
            primeiro = null;
        } else {
            anterior.proximo = null;
        }

        tamanho--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= tamanho) return;

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == tamanho - 1) {
            removeLast();
            return;
        }

        Node temp = primeiro;
        Node anterior = null;

        for (int i = 0; i < index; i++) {
            anterior = temp;
            temp = temp.proximo;
        }

        anterior.proximo = temp.proximo;
        tamanho--;
    }

    public int indexOf(X elemento) {
        Node temp = primeiro;
        int index = 0;

        while (temp != null) {
            if (temp.elemento.equals(elemento)) {
                return index;
            }

            temp = temp.proximo;
            index++;
        }

        return -1;
    }

    public void clear() {
        primeiro = null;
        tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedListOrdered(DoubleLinkedListOrdered<X> modelo) throws Exception {
        if (modelo == null) throw new Exception("Modelo ausente.");

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
        this.primeiro = (Node) verifyAndCopy(modelo.primeiro);
    }

    @Override
    public Object clone() {
        DoubleLinkedListOrdered<X> clone = null;
        try {
            clone = new DoubleLinkedListOrdered<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public String toString() {
        if (primeiro == null) return "[]";

        StringBuilder result = new StringBuilder("[");
        Node temp = primeiro;
        boolean primeiroElemento = true;

        while (temp != null) {
            if (!primeiroElemento)
                result.append(" <-> ");
            else
                primeiroElemento = false;

            result.append(temp.elemento);
            temp = temp.proximo;
        }

        result.append("]");
        return result.toString();
    }
}
