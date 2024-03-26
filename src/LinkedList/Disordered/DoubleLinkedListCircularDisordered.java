package LinkedList.Disordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListCircularDisordered<X> implements Cloneable {

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

        @SuppressWarnings("unchecked")
        public Node(Node modelo) {
            if (modelo == null) throw new IllegalArgumentException("Modelo não pode ser nulo.");

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

            hash *= prime + (elemento == null ? 0 : elemento.hashCode());

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Node that = (Node) obj;

            return Objects.equals(this.elemento, that.elemento);
        }

        @Override
        public String toString() {
            return elemento.toString();
        }
    }

    public Node primeiro;
    public Node ultimo;
    private int tamanho;

    public DoubleLinkedListCircularDisordered() {
        primeiro = null;
        ultimo = null;
    }

    public Node getPrimeiro() {
        return primeiro;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void addLast(X elemento) {
        Node novo = new Node(elemento);

        if (primeiro == null) {
            primeiro = novo;
            novo.proximo = novo; // O novo nó aponta para si mesmo
            novo.anterior = novo; // O novo nó aponta para si mesmo
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            novo.proximo = primeiro; // Torna o novo nó circular
            primeiro.anterior = novo; // Atualiza o anterior do primeiro nó para o novo nó
        }

        ultimo = novo;
        tamanho++;
    }

    public void addFirst(X elemento) {
        Node novo = new Node(elemento);

        if (primeiro == null) {
            primeiro = novo;
            novo.proximo = novo; // O novo nó aponta para si mesmo
            novo.anterior = novo; // O novo nó aponta para si mesmo
            ultimo = novo;
        } else {
            novo.proximo = primeiro;
            novo.anterior = ultimo;
            primeiro.anterior = novo;
            ultimo.proximo = novo;
            primeiro = novo;
        }

        tamanho++;
    }

    public void addAt(int indice, X elemento) {
        if (indice < 0) throw new IllegalArgumentException("Índice não pode ser negativo.");

        if (indice == 0) {
            addFirst(elemento);
            return;
        }

        Node temp = primeiro;
        for (int i = 0; i < indice - 1; i++) {
            if (temp == null) throw new IllegalArgumentException("Índice fora dos limites da lista.");
            temp = temp.proximo;
        }

        if (temp == null) throw new IllegalArgumentException("Índice fora dos limites da lista.");

        Node novo = new Node(elemento);
        novo.proximo = temp.proximo;
        novo.anterior = temp;
        temp.proximo.anterior = novo;
        temp.proximo = novo;

        tamanho++;
    }

    public void removeFirst() {
        if (primeiro == null) return;

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
            return;
        }

        primeiro.proximo.anterior = ultimo;
        ultimo.proximo = primeiro.proximo;
        primeiro = primeiro.proximo;

        tamanho--;
    }

    public void removeLast() {
        if (primeiro == null) return;

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
            return;
        }

        ultimo.anterior.proximo = primeiro;
        primeiro.anterior = ultimo.anterior;
        ultimo = ultimo.anterior;

        tamanho--;
    }

    public void removeAt(int indice) {
        if (indice < 0) throw new IllegalArgumentException("Índice não pode ser negativo.");

        if (indice == 0) {
            removeFirst();
            return;
        }

        Node temp = primeiro;
        for (int i = 0; i < indice; i++) {
            if (temp == null) throw new IllegalArgumentException("Índice fora dos limites da lista.");
            temp = temp.proximo;
        }

        if (temp == null) throw new IllegalArgumentException("Índice fora dos limites da lista.");

        temp.anterior.proximo = temp.proximo;
        temp.proximo.anterior = temp.anterior;

        tamanho--;
    }

    public X get(int indice) {
        if (indice < 0) throw new IllegalArgumentException("Índice não pode ser negativo.");

        Node temp = primeiro;
        for (int i = 0; i < indice; i++) {
            if (temp == null) throw new IllegalArgumentException("Índice fora dos limites da lista.");
            temp = temp.proximo;
        }

        if (temp == null) throw new IllegalArgumentException("Índice fora dos limites da lista.");

        return temp.elemento;
    }

    public X getFirst() {
        if (primeiro == null) throw new IllegalArgumentException("Lista vazia.");

        return primeiro.elemento;
    }

    public X getLast() {
        if (ultimo == null) throw new IllegalArgumentException("Lista vazia.");

        return ultimo.elemento;
    }

    public X contains(X elemento) {
        if (primeiro == null) return null;

        Node temp = primeiro;
        do {
            if (Objects.equals(temp.elemento, elemento)) return temp.elemento;
            temp = temp.proximo;
        } while (temp != primeiro);

        return null;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedListCircularDisordered(DoubleLinkedListCircularDisordered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Lista não pode ser nula.");

        Node temp = modelo.primeiro;
        while (temp != null && temp != modelo.ultimo) {
            this.addLast((X) verifyAndCopy(temp.elemento));
            temp = temp.proximo;
        }

        if (modelo.ultimo != null)
            this.addLast((X) verifyAndCopy(modelo.ultimo.elemento));

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    public Object clone() {
        DoubleLinkedListCircularDisordered<X> clone = null;

        try {
            clone = new DoubleLinkedListCircularDisordered<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        // Incorpora os hashes dos primeiros e últimos nós
        hash *= prime + (this.primeiro == null ? 0 : this.primeiro.hashCode());
        hash *= prime + (this.ultimo == null ? 0 : this.ultimo.hashCode());

        // Percorre a lista para calcular o hashCode dos elementos
        Node temp = primeiro;
        while (temp != null && temp != ultimo) {
            hash *= prime + (temp.elemento == null ? 0 : temp.elemento.hashCode());
            temp = temp.proximo;
        }

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        DoubleLinkedListCircularDisordered<X> that = (DoubleLinkedListCircularDisordered<X>) obj;

        if (this.primeiro == null && that.primeiro != null) return false;
        if (this.primeiro != null && that.primeiro == null) return false;
        if (this.primeiro == null) return true;

        Node tempThis = primeiro;
        Node tempThat = that.primeiro;

        do {
            if (!Objects.equals(tempThis.elemento, tempThat.elemento)) return false;
            tempThis = tempThis.proximo;
            tempThat = tempThat.proximo;
        } while (tempThis != primeiro && tempThat != that.primeiro);

        return true;
    }

    @Override
    public String toString() {
        if (primeiro == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        Node temp = primeiro;
        boolean primeiroElemento = true;

        do {
            if (!primeiroElemento) {
                result.append(" <-> ");
            } else {
                primeiroElemento = false;
            }
            result.append(temp.elemento);
            temp = temp.proximo;
        } while (temp != primeiro);

        result.append("]");
        return result.toString();
    }
}