package Node;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class Node<X> implements Cloneable {

    public X elemento;
    public Node<X> proximo;

    public X getElemento() {
        return elemento;
    }
    public Node<X> getProximo() {
        return proximo;
    }
    public Node(X elemento) {

        if (elemento == null)
            throw new IllegalArgumentException("Valor não pode ser nulo");

        this.elemento = elemento;
        this.proximo = null;
    }
    public Node(X valor, Node<X> proximo) {

        if (valor == null)
            throw new IllegalArgumentException("Valor não pode ser nulo");

        this.elemento = valor;
        this.proximo = proximo;
    }

    @SuppressWarnings("unchecked")
    public Node(Node<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Nó não pode ser nulo");

        this.elemento = (X) verifyAndCopy(modelo.elemento);
        this.proximo = (Node<X>)verifyAndCopy(modelo.proximo);
    }

    @Override
    public Node<X> clone() {
        Node<X> clone = null;
        try {
            clone = new Node<X>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Node<?> that = (Node<?>) (obj);

        return Objects.equals(this.elemento, that.elemento) &&
                Objects.equals(this.proximo, that.proximo);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.elemento == null) ? 0 : this.elemento.hashCode());
        hash *= prime + ((this.proximo == null) ? 0 : this.proximo.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }


    @Override
    public String toString() {
        return this.elemento.toString();
    }
}
