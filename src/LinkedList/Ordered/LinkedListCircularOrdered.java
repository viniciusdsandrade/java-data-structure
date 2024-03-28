package LinkedList.Ordered;
import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class LinkedListCircularOrdered<X extends Comparable<X>> implements Cloneable {

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
        public Node(Node modelo) throws Exception {
            if (modelo == null) throw new Exception("Modelo não pode ser nulo.");

            this.elemento = (X) verifyAndCopy(modelo.elemento);
            this.proximo = (Node) verifyAndCopy(modelo.proximo);
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

            Node that = (Node) obj;

            return Objects.equals(this.elemento, that.elemento);
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
    public Node ultimo;
    public int tamanho;

    public LinkedListCircularOrdered() {
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
            ultimo = novo;
            novo.proximo = primeiro;
            return;
        }

        if (primeiro.elemento.compareTo(elemento) > 0) {
            novo.proximo = primeiro;
            primeiro = novo;
            ultimo.proximo = primeiro;
            tamanho++;
            return;
        }

        if (ultimo.elemento.compareTo(elemento) < 0) {
            ultimo.proximo = novo;
            ultimo = novo;
            ultimo.proximo = primeiro;
            tamanho++;
            return;
        }

        Node temp = primeiro;
        while (temp.proximo != primeiro && temp.proximo.elemento.compareTo(elemento) < 0) {
            temp = temp.proximo;
        }

        novo.proximo = temp.proximo;
        temp.proximo = novo;
        tamanho++;
    }

    public void removeFirst() {
        if (primeiro == null) return;

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
            tamanho--;
            return;
        }

        primeiro = primeiro.proximo;
        ultimo.proximo = primeiro;
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

        Node temp = primeiro;
        while (temp.proximo != ultimo) {
            temp = temp.proximo;
        }

        ultimo = temp;
        ultimo.proximo = primeiro;
        tamanho--;
    }

    public void remoteAt(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return;

        if (posicao == 0) {
            removeFirst();
            return;
        }

        if (posicao == tamanho - 1) {
            removeLast();
            return;
        }

        Node temp = primeiro;
        for (int i = 0; i < posicao - 1; i++) {
            temp = temp.proximo;
        }

        temp.proximo = temp.proximo.proximo;
        tamanho--;
    }

    public X get(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return null;

        Node temp = primeiro;
        for (int i = 0; i < posicao; i++) {
            temp = temp.proximo;
        }

        return temp.elemento;
    }

    public X getFirst() {
        if (primeiro == null) return null;

        return primeiro.elemento;
    }

    public X getLast() {
        if (ultimo == null) return null;

        return ultimo.elemento;
    }

    public int indexOf(X elemento) {
        Node temp = primeiro;
        for (int i = 0; i < tamanho; i++) {
            if (temp.elemento.equals(elemento)) return i;
            temp = temp.proximo;
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
    public LinkedListCircularOrdered(LinkedListCircularOrdered<X> modelo) throws Exception {
        if (modelo == null) throw new Exception("Modelo ausente");

        this.primeiro = (Node) verifyAndCopy(modelo.primeiro);
        this.ultimo = (Node) verifyAndCopy(modelo.ultimo);
        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    public Object clone() {

        LinkedListCircularOrdered<X> clone = null;

        try {
            clone = new LinkedListCircularOrdered<>(this);
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

        LinkedListCircularOrdered<X> that = (LinkedListCircularOrdered<X>) obj;

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

        Node aux = this.primeiro;

        while (aux != null) {
            hash *= prime + aux.elemento.hashCode();
            aux = aux.proximo;
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
            if (!primeiroElemento) {
                result.append(" -> ");
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