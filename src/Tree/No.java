package Tree;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class No<X extends Comparable<X>> implements Cloneable, Comparable<X> {
    private X valor;
    private No<X> esquerda;
    private No<X> direita;

    public No() {
    }
    public No(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
    public No(No<X> esquerda, X valor, No<X> direita) {
        this.valor = valor;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @SuppressWarnings("unchecked")
    public X getValor() {
        return (X) verifyAndCopy(valor);
    }

    public No<X> getEsquerda() {
        return esquerda;
    }

    public No<X> getDireita() {
        return direita;
    }

    public void setValor(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        this.valor = valor;
    }

    public void setEsquerda(No<X> esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(No<X> direita) {
        this.direita = direita;
    }

    public No(No<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");
        this.valor = modelo.valor;
        this.esquerda = modelo.esquerda;
        this.direita = modelo.direita;
    }

    @Override
    public Object clone() {
        No<X> clone = null;
        try {
            clone = new No<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        No<?> that = (No<?>) o;

        return Objects.equals(this.valor, that.valor) &&
                Objects.equals(this.esquerda, that.esquerda) &&
                Objects.equals(this.direita, that.direita);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + (valor == null ? 0 : valor.hashCode());
        hash *= prime + (esquerda == null ? 0 : esquerda.hashCode());
        hash *= prime + (direita == null ? 0 : direita.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{ ");
        if (this.esquerda != null) sb.append(this.esquerda);
        sb.append(" } L { ");
        if (this.valor != null) sb.append(this.valor);
        sb.append(" } R { ");
        if (this.direita != null) sb.append(this.direita);
        sb.append(" }");

        return sb.toString();
    }

    @Override
    public int compareTo(X o) {
        return this.valor.compareTo(o);
    }
}
