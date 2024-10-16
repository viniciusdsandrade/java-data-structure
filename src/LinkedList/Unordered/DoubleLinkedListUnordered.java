package LinkedList.Unordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListUnordered<X> implements Cloneable {

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
            if (obj == null) return false;
            if (this == obj) return true;
            if (this.getClass() != obj.getClass()) return false;

            Node no = (Node) obj;

            return Objects.equals(this.elemento, no.elemento);
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
    public int tamanho;

    public DoubleLinkedListUnordered() {
        primeiro = null;
        tamanho = 0;
    }
    public Node getPrimeiro() {
        return primeiro;
    }
    public Node getUltimo() {
        if (primeiro == null) return null;

        Node temp = primeiro;
        while (temp.proximo != null)
            temp = temp.proximo;

        return temp;
    }
    public int getTamanho() {
        return tamanho;
    }

    @SuppressWarnings("unchecked")
    public void addLast(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento ausente");

        Node novo = new Node((X) verifyAndCopy(elemento));

        if (primeiro == null) {
            primeiro = novo;
            novo.anterior = null;
            novo.proximo = null;
            tamanho++;
            return;
        }

        Node temp = primeiro;
        while (temp.proximo != null)
            temp = temp.proximo;

        temp.proximo = novo;
        novo.anterior = temp;
        novo.proximo = null;

        tamanho++;
    }

    @SuppressWarnings("unchecked")
    public void addFirst(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento ausente");

        Node novo = new Node((X) verifyAndCopy(elemento));

        if (primeiro == null) {
            primeiro = novo;
            primeiro.anterior = null;
            primeiro.proximo = null;
            tamanho++;
            return;
        }

        novo.proximo = primeiro;
        primeiro.anterior = novo;
        primeiro = novo;

        tamanho++;
    }

    @SuppressWarnings("unchecked")
    public void addAt(X elemento, int indice) {
        if (elemento == null) throw new IllegalArgumentException("Elemento ausente");
        if (indice < 0 || indice > tamanho) throw new IllegalArgumentException("Índice inválido");

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
        for (int i = 0; i < indice - 1; i++)
            temp = temp.proximo;

        novo.proximo = temp.proximo;
        novo.anterior = temp;
        temp.proximo.anterior = novo;
        temp.proximo = novo;

        tamanho++;
    }

    public X get(int index) {
        if (index < 0 || index >= tamanho) throw new IllegalArgumentException("Índice inválido");

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

        if (primeiro.proximo == null) {
            primeiro = null;
            tamanho--;
            return;
        }

        primeiro = primeiro.proximo;
        primeiro.anterior = null;

        tamanho--;
    }

    public void removeLast() {
        if (primeiro == null) return;

        if (primeiro.proximo == null) {
            primeiro = null;
            tamanho--;
            return;
        }

        Node temp = primeiro;
        while (temp.proximo.proximo != null)
            temp = temp.proximo;

        temp.proximo = null;
        tamanho--;
    }

    public void removeAt(int indice) {
        if (indice < 0 || indice >= tamanho) throw new IllegalArgumentException("Índice inválido");

        if (indice == 0) {
            removeFirst();
            return;
        }

        if (indice == tamanho - 1) {
            removeLast();
            return;
        }

        Node temp = primeiro;
        for (int i = 0; i < indice - 1; i++)
            temp = temp.proximo;

        temp.proximo = temp.proximo.proximo;
        temp.proximo.anterior = temp;

        tamanho--;
    }

    public boolean contains(X elemento) {
        Node temp = primeiro;

        while (temp != null) {
            if (temp.elemento.equals(elemento))
                return true;
            temp = temp.proximo;
        }

        return false;
    }

    public int indexOf(X elemento) {
        Node temp = primeiro;
        int index = 0;

        while (temp != null) {
            if (temp.elemento.equals(elemento))
                return index;
            temp = temp.proximo;
            index++;
        }

        return -1;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void clear() {
        primeiro = null;
        tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedListUnordered(DoubleLinkedListUnordered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Lista não pode ser nula.");

        if (modelo.primeiro == null) {
            this.primeiro = null;
            this.tamanho = 0;
            return;
        }

        Node temp = modelo.primeiro;
        while (temp != null) {
            this.addLast((X) verifyAndCopy(temp.elemento));
            temp = temp.proximo;
        }

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() {
        DoubleLinkedListUnordered<X> clone = null;
        try {
            clone = new DoubleLinkedListUnordered<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;

        DoubleLinkedListUnordered<X> that = (DoubleLinkedListUnordered<X>) obj;

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

        Node temp = this.primeiro;
        while (temp != null) {
            hash = prime * hash + temp.elemento.hashCode();
            temp = temp.proximo;
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