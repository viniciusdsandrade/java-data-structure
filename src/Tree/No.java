package Tree;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class No<X extends Comparable<X>> implements Cloneable, Comparable<No<X>> {
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

    public boolean isFolha() {  // isLeaf() -> isFolha()
        return esquerda == null && direita == null;
    }

    public boolean temAmbosFilhos() {  // hasBothChildren() -> temAmbosFilhos()
        return esquerda != null && direita != null;
    }

    public boolean temUmFilho() {  // hasOneChild() -> temUmFilho()
        return (esquerda != null && direita == null) || (esquerda == null && direita != null);
    }

    @SuppressWarnings("unchecked")
    public No(No<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");
        this.valor = (X) verifyAndCopy(modelo.getValor());

        if (modelo.esquerda != null)
            this.esquerda = new No<>(modelo.esquerda); // Recursive deep copy
        else
            this.esquerda = null;

        if (modelo.direita != null)
            this.direita = new No<>(modelo.direita); // Recursive deep copy
        else
            this.direita = null;
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
        if (o == null || getClass() != o.getClass()) return false;

        No<?> that = (No<?>) o;

        return Objects.equals(this.valor, that.valor) &&
                equals(this.esquerda, that.esquerda) &&
                equals(this.direita, that.direita);
    }

    private boolean equals(No<X> no1, No<?> no2) {
        if (no1 == no2) return true;
        if (no1 == null || no2 == null) return false;
        if (!no1.valor.equals(no2.valor)) return false;

        return equals(no1.esquerda, no2.esquerda) &&
                equals(no1.direita, no2.direita);
    }

    @Override
    public int hashCode() {
        return hashCode(this);
    }

    private int hashCode(No<X> no) {
        final int prime = 31;
        int hash = 1;

        if (no == null) return 0;

        hash *= prime + ((no.valor == null) ? 0 : no.valor.hashCode());
        hash *= prime + hashCode(no.esquerda);
        hash *= prime + hashCode(no.direita);

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
    public int compareTo(No<X> other) {
        if (other == null) throw new NullPointerException("Cannot compare with null node");
        return this.valor.compareTo(other.valor);
    }
}
