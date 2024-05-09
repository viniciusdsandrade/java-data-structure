package Tree;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class ArvoreBinaria<T extends Comparable<T>> implements Cloneable {

    private No<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public ArvoreBinaria(No<T> raiz) {
        if (raiz == null) throw new IllegalArgumentException("Raiz nula");
        this.raiz = new No<>(raiz);
    }

    public void insert(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        raiz = insert(raiz, valor);
    }

    private No<T> insert(No<T> noAtual, T valor) {
        if (noAtual == null) return new No<>(valor);

        if (valor.compareTo(noAtual.getValor()) < 0)
            noAtual.setEsquerda(insert(noAtual.getEsquerda(), valor));
        else if (valor.compareTo(noAtual.getValor()) > 0)
            noAtual.setDireita(insert(noAtual.getDireita(), valor));

        return noAtual;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public void clear() {
        raiz = null;
    }

    public int size() {
        if (raiz == null) return 0;
        return size(raiz);
    }

    private int size(No<T> no) {
        if (no == null) return 0;

        if (no.getEsquerda() == null && no.getDireita() == null) return 1;
        if (no.getEsquerda() == null && no.getDireita() != null) return 1 + size(no.getDireita());
        if (no.getEsquerda() != null && no.getDireita() == null) return 1 + size(no.getEsquerda());

        return 1 + size(no.getEsquerda()) + size(no.getDireita());
    }

    @SuppressWarnings("unchecked")
    public ArvoreBinaria(ArvoreBinaria<T> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");
        this.raiz = (No<T>) verifyAndCopy(modelo.raiz);
    }

    @Override
    public Object clone() {
        ArvoreBinaria<T> clone = null;
        try {
            clone = new ArvoreBinaria<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ArvoreBinaria<?> that = (ArvoreBinaria<?>) obj;

        return equals(this.raiz, that.raiz);
    }

    private boolean equals(No<T> no1, No<?> no2) {
        if (no1 == no2) return true;
        if (no1 == null || no2 == null) return false;
        if (!no1.getValor().equals(no2.getValor())) return false;

        return equals(no1.getEsquerda(), no2.getEsquerda()) &&
                equals(no1.getDireita(), no2.getDireita());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + hashCode(raiz, prime);

        if (hash < 0) hash = -hash;

        return hash;
    }

    private int hashCode(No<T> raiz, int prime) {
        if (raiz == null) return 0;
        if (raiz.getEsquerda() == null && raiz.getDireita() == null) return prime * raiz.getValor().hashCode();
        if (raiz.getEsquerda() == null && raiz.getDireita() != null)
            return prime * raiz.getValor().hashCode() + hashCode(raiz.getDireita(), prime);
        if (raiz.getEsquerda() != null && raiz.getDireita() == null)
            return prime * raiz.getValor().hashCode() + hashCode(raiz.getEsquerda(), prime);

        return prime * raiz.getValor().hashCode() + hashCode(raiz.getEsquerda(), prime) + hashCode(raiz.getDireita(), prime);
    }

    @Override
    public String toString() {
        if (raiz == null) return "{ }";
        return "\n" + toString(0, raiz, "", true, new StringBuilder());
    }

    private String toString(int level, No<T> no, String prefixo, boolean isUltimoFilho, StringBuilder sb) {
        sb.append(prefixo);

        if (level == 0) // Condição para a raiz
            sb.append("[");
        else
            sb.append(isUltimoFilho ? "└─" : "├─").append("[");

        sb.append(no.getValor()).append("]").append("\n");

        String prefixoFilho = prefixo + (isUltimoFilho ? "  " : "│   ");

        if (no.getEsquerda() != null)
            toString(level + 1, no.getEsquerda(), prefixoFilho, false, sb);

        if (no.getDireita() != null)
            toString(level + 1, no.getDireita(), prefixoFilho, true, sb);

        return sb.toString();
    }
}
