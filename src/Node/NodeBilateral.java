package Node;

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
        NodeBilateral<?> clone = null;

        try {
            clone = new NodeBilateral<>(this);
        } catch (Exception ignored) {
        }
        
        return clone;
    }
}
