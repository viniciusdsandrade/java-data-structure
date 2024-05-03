package Node;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class NodeBilateral<X> implements Cloneable {

    public X elemento;
    public NodeBilateral<X> proximo;
    public NodeBilateral<X> anterior;

    public NodeBilateral() {
    }

    public NodeBilateral(X elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public X getElemento() {
        return elemento;
    }

    public NodeBilateral<X> getProximo() {
        return proximo;
    }

    public NodeBilateral<X> getAnterior() {
        return anterior;
    }

    @SuppressWarnings("unchecked")
    public NodeBilateral(NodeBilateral<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo ausente");

        this.elemento = (X) verifyAndCopy(modelo.elemento);
        this.proximo = (NodeBilateral<X>) verifyAndCopy(modelo.proximo);
        this.anterior = (NodeBilateral<X>) verifyAndCopy(modelo.anterior);
    }

    @Override
    public Object clone() {
        NodeBilateral<X> clone = null;
        try {
            clone = new NodeBilateral<X>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeBilateral<?> that = (NodeBilateral<?>) o;

        if (!Objects.equals(elemento, that.elemento)) return false;

        NodeBilateral<?> currentThis = this.proximo;
        NodeBilateral<?> currentThat = that.proximo;

        for (; currentThis != null && currentThat != null; currentThis = currentThis.proximo, currentThat = currentThat.proximo) {
            if (!Objects.equals(currentThis.elemento, currentThat.elemento)) return false;
        }

        return currentThis == null && currentThat == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        NodeBilateral<?> current = this;
        for (; current != null; current = current.proximo)
            hash *= prime + Objects.hashCode(current.elemento);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return this.elemento.toString();
    }
}
