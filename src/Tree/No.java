package Tree;

import java.util.Objects;

/**
 * Representa um nó em uma árvore binária.
 *
 * @param <X> O tipo de dado armazenado no nó.
 */
public class No<X extends Comparable<X>> implements Cloneable, Comparable<No<X>> {
    private X valor;
    private No<X> esquerda;
    private No<X> direita;

    /**
     * Construtor padrão.
     */
    public No() {
    }

    /**
     * Construtor que recebe o valor do nó.
     *
     * @param valor O valor a ser armazenado no nó.
     * @throws IllegalArgumentException Se o valor for nulo.
     */
    public No(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        this.valor = valor;
        esquerda = null;
        direita = null;
    }

    /**
     * Construtor que recebe os nós esquerdo e direito, e o valor do nó.
     *
     * @param esquerda O nó esquerdo.
     * @param valor    O valor a ser armazenado no nó.
     * @param direita  O nó direito.
     */
    public No(No<X> esquerda, X valor, No<X> direita) {
        this.valor = valor;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    /**
     * Retorna o valor do nó.
     *
     * @return O valor do nó.
     */
    @SuppressWarnings("unchecked")
    public X getValor() {
        return (X) ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy(valor);
    }

    /**
     * Retorna o nó esquerdo.
     *
     * @return O nó esquerdo.
     */
    public No<X> getEsquerda() {
        return esquerda;
    }

    /**
     * Retorna o nó direito.
     *
     * @return O nó direito.
     */
    public No<X> getDireita() {
        return direita;
    }

    /**
     * Define o valor do nó.
     *
     * @param valor O novo valor do nó.
     * @throws IllegalArgumentException Se o valor for nulo.
     */
    public void setValor(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        this.valor = valor;
    }

    /**
     * Define o nó esquerdo.
     *
     * @param esquerda O novo nó esquerdo.
     */
    public void setEsquerda(No<X> esquerda) {
        this.esquerda = esquerda;
    }

    /**
     * Define o nó direito.
     *
     * @param direita O novo nó direito.
     */
    public void setDireita(No<X> direita) {
        this.direita = direita;
    }

    /**
     * Verifica se o nó é uma folha (não tem filhos).
     *
     * @return True se o nó for uma folha, False caso contrário.
     */
    public boolean isFolha() {
        return esquerda == null && direita == null;
    }

    /**
     * Verifica se o nó tem ambos os filhos (esquerdo e direito).
     *
     * @return True se o nó tiver ambos os filhos, False caso contrário.
     */
    public boolean temAmbosFilhos() {
        return esquerda != null && direita != null;
    }

    /**
     * Verifica se o nó tem apenas um filho (esquerdo ou direito).
     *
     * @return True se o nó tiver apenas um filho, False caso contrário.
     */
    public boolean temUmFilho() {
        return (esquerda != null && direita == null) || (esquerda == null && direita != null);
    }

    /**
     * Construtor de cópia profunda.
     *
     * @param modelo O nó a ser copiado.
     * @throws IllegalArgumentException Se o modelo for nulo.
     */
    @SuppressWarnings("unchecked")
    public No(No<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");
        this.valor = (X) ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy(modelo.getValor());
        if (modelo.esquerda != null)
            this.esquerda = new No<>(modelo.esquerda); // Cópia profunda recursiva
        else
            this.esquerda = null;
        if (modelo.direita != null)
            this.direita = new No<>(modelo.direita); // Cópia profunda recursiva
        else
            this.direita = null;
    }

    /**
     * Cria uma cópia profunda do nó.
     *
     * @return Uma cópia profunda do nó.
     */
    @Override
    public Object clone() {
        No<X> clone = null;
        try {
            clone = new No<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    /**
     * Verifica se o nó é igual a outro objeto.
     *
     * @param o O objeto a ser comparado.
     * @return True se os nós forem iguais, False caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        No<?> that = (No<?>) o;
        return Objects.equals(this.valor, that.valor) &&
                equals(this.esquerda, that.esquerda) &&
                equals(this.direita, that.direita);
    }

    /**
     * Método auxiliar para verificar a igualdade de dois nós.
     *
     * @param no1 O primeiro nó.
     * @param no2 O segundo nó.
     * @return True se os nós forem iguais, False caso contrário.
     */
    private boolean equals(No<X> no1, No<?> no2) {
        if (no1 == no2) return true;
        if (no1 == null || no2 == null) return false;
        if (!no1.valor.equals(no2.valor)) return false;
        return equals(no1.esquerda, no2.esquerda) &&
                equals(no1.direita, no2.direita);
    }

    /**
     * Retorna o código hash do nó.
     *
     * @return O código hash do nó.
     */
    @Override
    public int hashCode() {
        return hashCode(this);
    }

    /**
     * Método auxiliar para calcular o código hash de um nó.
     *
     * @param no O nó.
     * @return O código hash do nó.
     */
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

    /**
     * Retorna a representação em String do nó.
     *
     * @return A representação em String do nó.
     */
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

    /**
     * Compara o nó com outro nó.
     *
     * @param other O outro nó a ser comparado.
     * @return Um valor negativo, zero ou positivo se o nó for menor, igual ou maior que o outro nó, respectivamente.
     * @throws NullPointerException Se o outro nó for nulo.
     */
    @Override
    public int compareTo(No<X> other) {
        if (other == null) throw new NullPointerException("Cannot compare with null node");
        return this.valor.compareTo(other.valor);
    }
}