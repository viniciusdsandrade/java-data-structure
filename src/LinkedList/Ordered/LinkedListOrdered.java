package LinkedList.Ordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class LinkedListOrdered<X extends Comparable<X>> implements Cloneable {

    public class Node implements Cloneable {
        public X elemento;
        public Node proximo;

        public Node() {
        }
        public Node(X elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
        public X getElemento() {
            return elemento;
        }
        public Node getProximo() {
            return proximo;
        }

        @SuppressWarnings("unchecked")
        public Node(Node modelo) {
            if (modelo == null) throw new IllegalArgumentException("Nó não pode ser nulo");

            this.elemento = (X) verifyAndCopy(modelo.elemento);
            this.proximo = (Node) verifyAndCopy(modelo.proximo);
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

            Node other = (Node) obj;

            return Objects.equals(this.elemento, other.elemento);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int hash = 1;

            hash *= prime + ((this.elemento == null) ? 0 : this.elemento.hashCode());

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        public String toString() {
            if (proximo != null)
                return elemento + " -> " + proximo.elemento;
            else
                return elemento.toString();
        }
    }

    public Node primeiro;
    public int tamanho;

    public LinkedListOrdered() {
        primeiro = null;
        tamanho = 0;
    }
    public Node getPrimeiro() {
        return primeiro;
    }
    public int getTamanho() {
        return tamanho;
    }

    @SuppressWarnings("unchecked")
    public void add(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento nulo");

        Node novo = new Node((X) verifyAndCopy(elemento));
        Node anterior = null;
        Node atual = primeiro;

        while (atual != null && elemento.compareTo(atual.elemento) > 0) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (anterior == null) {
            novo.proximo = primeiro;
            primeiro = novo;
        } else {
            novo.proximo = atual;
            anterior.proximo = novo;
        }

        tamanho++;
    }

    public X get(int indice) {
        if (indice < 0 || indice > tamanho) throw new IndexOutOfBoundsException("Index inválido");

        Node atual = primeiro;

        for (int i = 0; i < indice; i++)
            atual = atual.proximo;

        return atual.elemento;
    }

    public X getFirst() {
        if (primeiro == null) return null;

        return primeiro.elemento;
    }

    public X getLast() {
        if (primeiro == null) return null;

        Node atual = primeiro;

        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        return atual.elemento;
    }

    public void deleteFirst() {
        if (primeiro == null) return;

        primeiro = primeiro.proximo;
        tamanho--;
    }

    public void deleteLast() {
        if (primeiro == null) return;

        if (primeiro.proximo == null) {
            primeiro = null;
            tamanho--;
            return;
        }

        Node atual = primeiro;
        Node anterior = null;

        while (atual.proximo != null) {
            anterior = atual;
            atual = atual.proximo;
        }

        anterior.proximo = null;
        tamanho--;
    }

    public void deleteAt(int indice) {
        if (indice < 0 || indice > tamanho) return;

        if (indice == 0) {
            deleteFirst();
            return;
        }

        if (indice == tamanho - 1) {
            deleteLast();
            return;
        }

        Node atual = primeiro;
        Node anterior = null;

        for (int i = 0; i < indice; i++) {
            anterior = atual;
            atual = atual.proximo;
        }

        anterior.proximo = atual.proximo;
        tamanho--;
    }

    public boolean contains(X elemento) {
        if (elemento == null) return false;

        Node atual = primeiro;

        while (atual != null) {
            if (atual.elemento.equals(elemento)) return true;

            atual = atual.proximo;
        }

        return false;
    }

    public int indexOf(X elemento) {
        if (elemento == null) return -1;

        Node atual = primeiro;
        int indice = 0;

        while (atual != null) {
            if (atual.elemento.equals(elemento)) return indice;

            atual = atual.proximo;
            indice++;
        }

        return -1;
    }

    public boolean isEmpty() {
        return primeiro == null;
    }

    public void clear() {
        primeiro = null;
        tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    public LinkedListOrdered(LinkedListOrdered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Lista não pode ser nula.");

        if (modelo.primeiro == null) {
            this.primeiro = null;
            this.tamanho = 0;
            return;
        }

        Node atual = modelo.primeiro;
        Node anterior = null;

        while (atual != null) {
            Node novo = new Node((X) verifyAndCopy(atual.elemento));
            if (anterior == null)
                this.primeiro = novo;
            else
                anterior.proximo = novo;

            anterior = novo;
            atual = atual.proximo;
        }

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() {
        LinkedListOrdered<X> clone = null;
        try {
            clone = new LinkedListOrdered<>(this);
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

        LinkedListOrdered<X> that = (LinkedListOrdered<X>) obj;

        if (this.tamanho != that.tamanho) return false;

        Node thisNode = this.primeiro;
        Node thatNode = that.primeiro;

        while (thisNode != null && thatNode != null) {
            if (!Objects.equals(thisNode.elemento, thatNode.elemento)) return false;
            thisNode = thisNode.proximo;
            thatNode = thatNode.proximo;
        }

        return thisNode == null &&
                thatNode == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + this.tamanho;

        for (Node atual = primeiro; atual != null; atual = atual.proximo)
            hash *= prime + ((atual.elemento == null) ? 0 : atual.elemento.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node atual = primeiro;
        while (atual != null) {
            result.append(atual.elemento);
            if (atual.proximo != null)
                result.append(" -> ");
            atual = atual.proximo;
        }
        result.append("]");
        return result.toString();
    }
}