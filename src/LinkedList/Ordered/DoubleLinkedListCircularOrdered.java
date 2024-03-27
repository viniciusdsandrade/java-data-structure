package LinkedList.Ordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListCircularOrdered<X extends Comparable<X>> implements Cloneable {

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

            Node no = (Node) obj;

            return Objects.equals(this.elemento, no.elemento);
        }

        @Override
        public String toString() {
            return this.elemento.toString();
        }
    }

    public Node primeiro;
    public Node ultimo;
    public int tamanho;

    public DoubleLinkedListCircularOrdered() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
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

    //Tinho que adicionar os elementos ja de maneira ordenada
    public void add(X elemento) {
        Node novo = new Node(elemento);

        if (this.tamanho == 0) {
            this.primeiro = novo;
            this.ultimo = novo;
            return;
        }

        Node atual = this.primeiro;
        Node anterior = null;
        while (atual != null && atual.elemento.compareTo(elemento) < 0) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (anterior == null) {
            novo.proximo = this.primeiro;
            this.primeiro.anterior = novo;
            this.primeiro = novo;
        } else if (atual == null) {
            this.ultimo.proximo = novo;
            novo.anterior = this.ultimo;
            this.ultimo = novo;
        } else {
            anterior.proximo = novo;
            novo.anterior = anterior;
            novo.proximo = atual;
            atual.anterior = novo;
        }
        tamanho++;
    }
    
    @SuppressWarnings("unchecked")
    public DoubleLinkedListCircularOrdered(DoubleLinkedListCircularOrdered<X> modelo) throws Exception {
        if (modelo == null) throw new Exception("Modelo ausente");

        Node atual = modelo.primeiro;
        while (atual != null && atual != modelo.ultimo) {
            this.add((X) verifyAndCopy(atual.elemento));
            atual = atual.proximo;
        }

        if (atual != null)
            this.add((X) verifyAndCopy(atual.elemento));

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    public Object clone() {
        DoubleLinkedListCircularOrdered<X> clone = null;
        try {
            clone = new DoubleLinkedListCircularOrdered<>(this);
        } catch (Exception ignored) {
        }
        return clone;
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