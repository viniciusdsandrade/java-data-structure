package LinkedList.Unordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListCircularUnordered<X> implements Cloneable {

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
            if (modelo == null) throw new IllegalArgumentException("Modelo não pode ser nulo.");

            this.elemento = (X) verifyAndCopy(modelo.elemento);
            this.proximo = (Node) verifyAndCopy(modelo.proximo);
            this.anterior = (Node) verifyAndCopy(modelo.anterior);
        }

        @Override
        @SuppressWarnings("MethodDoesntCallSuperMethod")
        public Object clone() {
            Node clone = null;
            try {
                clone = new Node(this);
            } catch (Exception ignored) {
            }
            return clone;
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
        public int hashCode() {
            final int prime = 31;
            int hash = 1;

            hash *= prime + (this.elemento == null ? 0 : this.elemento.hashCode());

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        public String toString() {
            if (proximo != null)
                return elemento + " <-> " + proximo.elemento;
            else
                return elemento.toString();
        }
    }

    public Node primeiro;
    public Node ultimo;
    public int tamanho;

    public DoubleLinkedListCircularUnordered() {
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

    @SuppressWarnings("unchecked")
    public void addLast(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo.");

        Node novo = new Node((X) verifyAndCopy(elemento));

        if (primeiro == null) {
            primeiro = novo;
            novo.proximo = novo; // O novo nó aponta para si mesmo
            novo.anterior = novo; // O novo nó aponta para si mesmo
            ultimo = novo;
            tamanho++;
            return;
        }

        ultimo.proximo = novo;
        novo.anterior = ultimo;
        novo.proximo = primeiro; // Torna o novo nó circular
        primeiro.anterior = novo; // Atualiza o anterior do primeiro nó para o novo nó
        ultimo = novo;
        tamanho++;
    }

    @SuppressWarnings("unchecked")
    public void addFirst(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo.");

        Node novo = new Node((X) verifyAndCopy(elemento));

        if (primeiro == null) {
            primeiro = novo;
            novo.proximo = novo; // O novo nó aponta para si mesmo
            novo.anterior = novo; // O novo nó aponta para si mesmo
            ultimo = novo;
            tamanho++;
            return;
        }

        novo.proximo = primeiro;
        novo.anterior = ultimo;
        primeiro.anterior = novo;
        ultimo.proximo = novo;
        primeiro = novo;

        tamanho++;
    }

    @SuppressWarnings("unchecked")
    public void addAt(X elemento, int indice) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo.");
        if (indice < 0 || indice > tamanho) throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");

        if (indice == 0) {
            addFirst(elemento);
            return;
        }

        if (indice == tamanho) {
            addLast(elemento);
            return;
        }

        Node novo = new Node((X) verifyAndCopy(elemento));
        Node temp = primeiro;
        for (int i = 0; i < indice; i++)
            temp = temp.proximo;

        novo.proximo = temp;
        novo.anterior = temp.anterior;
        temp.anterior.proximo = novo;
        temp.anterior = novo;

        tamanho++;
    }

    public X get(int indice) {
        if (indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");

        Node temp = primeiro;
        for (int i = 0; i < indice; i++)
            temp = temp.proximo;

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

    public void removeFirst() {
        if (primeiro == null) return;

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
            tamanho--;
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
            tamanho--;
            return;
        }

        ultimo.anterior.proximo = primeiro;
        primeiro.anterior = ultimo.anterior;
        ultimo = ultimo.anterior;

        tamanho--;
    }

    public void removeAt(int indice) {
        if (indice < 0 || indice > tamanho) throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");

        if (indice == 0) {
            removeFirst();
            return;
        }

        if (indice == tamanho - 1) {
            removeLast();
            return;
        }

        Node temp = primeiro;
        for (int i = 0; i < indice; i++)
            temp = temp.proximo;

        temp.anterior.proximo = temp.proximo;
        temp.proximo.anterior = temp.anterior;

        tamanho--;
    }

    public boolean contains(X elemento) {
        if (elemento == null) return false;

        Node temp = primeiro;
        do {
            if (temp.elemento.equals(elemento)) return true;
            temp = temp.proximo;
        } while (temp != primeiro);

        return false;
    }

    public int indexOf(X elemento) {
        if (elemento == null) return -1;

        Node temp = primeiro;
        int indice = 0;
        do {
            if (temp.elemento.equals(elemento)) return indice;
            temp = temp.proximo;
            indice++;
        } while (temp != primeiro);

        return -1;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void reverse() {
        if (primeiro == null) return;

        Node temp = primeiro;
        do {
            Node aux = temp.proximo;
            temp.proximo = temp.anterior;
            temp.anterior = aux;
            temp = temp.anterior;
        } while (temp != primeiro);

        Node aux = primeiro;
        primeiro = ultimo;
        ultimo = aux;
    }

    public void rotate(int passos) {
        if (primeiro == null) return;

        if (passos < 0) {
            passos = tamanho + passos % tamanho;
        }

        for (int i = 0; i < passos; i++) {
            Node aux = primeiro;
            primeiro = primeiro.proximo;
            ultimo = ultimo.proximo;
        }
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedListCircularUnordered(DoubleLinkedListCircularUnordered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Lista não pode ser nula.");

        if (modelo.primeiro == null) {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho = 0;
            return;
        }

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
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() {
        DoubleLinkedListCircularUnordered<X> clone = null;
        try {
            clone = new DoubleLinkedListCircularUnordered<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        DoubleLinkedListCircularUnordered<X> that = (DoubleLinkedListCircularUnordered<X>) obj;

        if (this.primeiro == null) return true;
        if (this.tamanho != that.tamanho) return false;

        Node tempThis = this.primeiro;
        Node tempThat = that.primeiro;

        for (int i = 0; i < this.tamanho; i++) {
            if (!tempThis.equals(tempThat)) return false;
            tempThis = tempThis.proximo;
            tempThat = tempThat.proximo;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        Node auxiliar = primeiro;

        for (int i = 0; i < tamanho; i++) {
            hash *= prime + (auxiliar.elemento == null ? 0 : auxiliar.elemento.hashCode());
            auxiliar = auxiliar.proximo;
        }

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        if (primeiro == null) return "[]";

        StringBuilder result = new StringBuilder("[");
        Node temp = primeiro;
        boolean primeiroElemento = true;

        do {
            if (!primeiroElemento)
                result.append(" <-> ");
            else
                primeiroElemento = false;
            result.append(temp.elemento);
            temp = temp.proximo;
        } while (temp != primeiro);

        result.append("]");
        return result.toString();
    }
}