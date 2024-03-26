package LinkedList.Ordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class LinkedListCircularOrdered<X extends Comparable<X>> implements Cloneable, Comparable<LinkedListCircularOrdered<X>> {
    
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
    
    public LinkedListCircularOrdered(LinkedListCircularOrdered<X> modelo) throws Exception {
        if (modelo == null) throw new Exception("Modelo ausente");
        // TODO: Implement this method
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
    public int compareTo(LinkedListCircularOrdered<X> o) {
        return 0;

        // Todo: Implement this method
    }
}