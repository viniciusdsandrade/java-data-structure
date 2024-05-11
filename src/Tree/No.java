package Tree;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

/**
 * A classe No representa um nó em uma árvore binária de busca.
 * Cada nó contém um valor do tipo X que implementa a interface Comparable,
 * e referências para os seus filhos esquerdo e direito.
 *
 * @param <X> O tipo de dado armazenado no nó, deve implementar a interface Comparable.
 */
public class No<X extends Comparable<X>> implements Cloneable, Comparable<No<X>> {

    /**
     * O valor armazenado no nó.
     */
    private X valor;

    /**
     * A referência para o filho esquerdo do nó.
     */
    private No<X> esquerda;

    /**
     * A referência para o filho direito do nó.
     */
    private No<X> direita;

    /**
     * Construtor padrão que cria um nó vazio.
     */
    public No() {
    }

    /**
     * Construtor que cria um nó com o valor especificado.
     *
     * @param valor O valor a ser armazenado no nó, não pode ser nulo.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public No(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        this.valor = valor;
        esquerda = null;
        direita = null;
    }

    /**
     * Construtor que cria um nó com o valor especificado e referências para os filhos esquerdo e direito.
     *
     * @param esquerda A referência para o filho esquerdo do nó.
     * @param valor    O valor a ser armazenado no nó.
     * @param direita  A referência para o filho direito do nó.
     */
    public No(No<X> esquerda, X valor, No<X> direita) {
        this.esquerda = esquerda;
        this.valor = valor;
        this.direita = direita;
    }

    /**
     * Retorna o valor armazenado no nó, garantindo que seja retornado uma cópia ou o valor original dependendo da configuração de cópia.
     *
     * @return O valor armazenado no nó.
     */
    @SuppressWarnings("unchecked")
    public X getValor() {
        return (X) verifyAndCopy(valor);
    }

    /**
     * Retorna a referência para o filho esquerdo do nó.
     *
     * @return A referência para o filho esquerdo do nó.
     */
    public No<X> getEsquerda() {
        return esquerda;
    }

    /**
     * Retorna a referência para o filho direito do nó.
     *
     * @return A referência para o filho direito do nó.
     */
    public No<X> getDireita() {
        return direita;
    }

    /**
     * Define o valor armazenado no nó.
     *
     * @param valor O novo valor a ser armazenado no nó, não pode ser nulo.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public void setValor(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        this.valor = valor;
    }

    /**
     * Define a referência para o filho esquerdo do nó.
     *
     * @param esquerda A nova referência para o filho esquerdo do nó.
     */
    public void setEsquerda(No<X> esquerda) {
        this.esquerda = esquerda;
    }

    /**
     * Define a referência para o filho direito do nó.
     *
     * @param direita A nova referência para o filho direito do nó.
     */
    public void setDireita(No<X> direita) {
        this.direita = direita;
    }

    /**
     * Busca um nó na subárvore com raiz neste nó que contém o valor especificado.
     *
     * @param valor O valor a ser buscado.
     * @return O nó que contém o valor, ou nulo se o valor não for encontrado.
     */
    public No<X> buscarNo(X valor) {
        if (valor == null) return null;
        int comparacao = valor.compareTo(this.valor);
        if (comparacao == 0) return this;
        if (comparacao < 0 && this.esquerda != null) return this.esquerda.buscarNo(valor);
        if (comparacao > 0 && this.direita != null) return this.direita.buscarNo(valor);
        return null;
    }

    /**
     * Busca o valor mínimo na subárvore com raiz neste nó.
     *
     * @return O valor mínimo na subárvore.
     */
    public X buscarMinimo() {
        if (this.esquerda == null)
            return this.valor;
        else
            return this.esquerda.buscarMinimo();
    }

    /**
     * Busca o valor máximo na subárvore com raiz neste nó.
     *
     * @return O valor máximo na subárvore.
     */
    public X buscarMaximo() {
        if (this.direita == null)
            return this.valor;
        else
            return this.direita.buscarMaximo();
    }

    /**
     * Verifica se o nó é uma folha, ou seja, se não possui filhos.
     *
     * @return True se o nó for uma folha, False caso contrário.
     */
    public boolean isFolha() {
        return esquerda == null && direita == null;
    }

    /**
     * Verifica se o nó possui ambos os filhos.
     *
     * @return True se o nó possuir ambos os filhos, False caso contrário.
     */
    public boolean temAmbosFilhos() {
        return esquerda != null && direita != null;
    }

    /**
     * Verifica se o nó possui apenas um filho.
     *
     * @return True se o nó possuir apenas um filho, False caso contrário.
     */
    public boolean temUmFilho() {
        return (esquerda != null && direita == null) || (esquerda == null && direita != null);
    }

    /**
     * Construtor de cópia que cria um novo nó com base em um nó modelo, realizando uma cópia profunda dos valores.
     *
     * @param modelo O nó modelo a ser copiado, não pode ser nulo.
     * @throws IllegalArgumentException Se o nó modelo fornecido for nulo.
     */
    @SuppressWarnings("unchecked")
    public No(No<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");

        this.valor = (X) verifyAndCopy(modelo.getValor());

        if (modelo.esquerda != null)
            this.esquerda = new No<>(modelo.esquerda);
        else
            this.esquerda = null;

        if (modelo.direita != null)
            this.direita = new No<>(modelo.direita);
        else
            this.direita = null;
    }

    /**
     * Cria e retorna um clone deste nó, realizando uma cópia profunda dos valores.
     *
     * @return Um clone deste nó.
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
     * Verifica se este nó é igual a outro objeto.
     *
     * @param o O objeto a ser comparado.
     * @return True se os objetos forem iguais, False caso contrário.
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
     * Método auxiliar para verificar a igualdade entre dois nós, recursivamente.
     *
     * @param no1 O primeiro nó a ser comparado.
     * @param no2 O segundo nó a ser comparado.
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
     * Retorna o código hash para este nó.
     *
     * @return O código hash para este nó.
     */
    @Override
    public int hashCode() {
        return hashCode(this);
    }

    /**
     * Método auxiliar para calcular o código hash de um nó, recursivamente.
     *
     * @param no O nó para o qual o código hash deve ser calculado.
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
     * Retorna uma representação em string deste nó.
     *
     * @return Uma representação em string deste nó.
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
     * Compara este nó com outro nó.
     *
     * @param other O nó a ser comparado.
     * @return Um valor negativo se este nó for menor que o outro nó, zero se forem iguais,
     * ou um valor positivo se este nó for maior que o outro nó.
     * @throws NullPointerException Se o outro nó for nulo.
     */
    @Override
    public int compareTo(No<X> other) {
        if (other == null) throw new NullPointerException("Cannot compare with null node");
        return this.valor.compareTo(other.valor);
    }
}