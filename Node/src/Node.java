package Node.src;

import java.util.Objects;

public class Node<X> implements Cloneable {

    public X data;
    public Node<X> next;

    public Node(X data) {

        if (data == null)
            throw new IllegalArgumentException("Valor não pode ser nulo");

        this.data = data;
        this.next = null;
    }

    public Node(X valor, Node<X> next) {

        if (valor == null)
            throw new IllegalArgumentException("Valor não pode ser nulo");

        this.data = valor;
        this.next = next;
    }

    public X getData() {
        return this.data;
    }

    public Node<X> getNext() {
        return this.next;
    }

    public void setData(X valor) {
        if (valor == null)
            throw new IllegalArgumentException("Valor não pode ser nulo");

        this.data = valor;
    }

    public void setNext(Node<X> next) {
        this.next = next;
    }

    public Node(Node<X> no) {
        this.data = no.data;
        this.next = no.next;
    }

    @Override
    public Node<X> clone() {

        Node<X> clone = null;

        try {
            clone = new Node<X>(this.data, this.next);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.data == null) ? 0 : this.data.hashCode());
        hash *= prime + ((this.next == null) ? 0 : this.next.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Node<?> no = (Node<?>) (obj);

        return Objects.equals(this.data, no.data) &&
                Objects.equals(this.next, no.next);
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
