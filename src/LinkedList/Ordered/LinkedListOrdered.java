package LinkedList.Ordered;


import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class LinkedListOrdered<X extends Comparable<X>> implements Cloneable, Comparable<LinkedListOrdered<X>> {

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
            if (modelo == null) throw new Exception("Nó não pode ser nulo");

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

            hash *= prime + ((this.elemento == null) ? 0 : this.elemento.hashCode());

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
            if (proximo != null)
                return elemento + " -> " + proximo.elemento;
            else
                return elemento.toString();
        }
    }
    
    private Node primeiro;
    private int tamanho;
    
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

    public void add(X element) throws Exception {
        // TODO: implement this method
    }

    @Override
    public Object clone() {

        LinkedListOrdered<X> clone = null;

        try {
            clone = new LinkedListOrdered<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    public LinkedListOrdered(LinkedListOrdered<X> modelo) {

        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");

        // TODO: implement this method
    }

    @Override
    public String toString() {
        return null;
        // TODO: implement this method
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        if (hash < 0) hash = -hash;

        return hash;
        // TODO: implement this method
    }

    @Override
    public boolean equals(Object obj) {
        return false;
        // TODO: implement this method
    }

    @Override
    public int compareTo(LinkedListOrdered<X> o) {
        return 0;
        // TODO: implement this method
    }
}
