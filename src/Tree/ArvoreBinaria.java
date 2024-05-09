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

    public void inserir(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        raiz = inserir(raiz, valor);
    }

    private No<T> inserir(No<T> noAtual, T valor) {
        if (noAtual == null) return new No<>(valor);

        if (valor.compareTo(noAtual.getValor()) < 0)
            noAtual.setEsquerda(inserir(noAtual.getEsquerda(), valor));
        else if (valor.compareTo(noAtual.getValor()) > 0)
            noAtual.setDireita(inserir(noAtual.getDireita(), valor));

        return noAtual;
    }

    public boolean estaBalanceada() {
        return estaBalanceada(raiz);
    }

    private boolean estaBalanceada(No<T> no) {
        if (no == null) return true;
        int alturaEsquerda = altura(no.getEsquerda());
        int alturaDireita = altura(no.getDireita());
        return Math.abs(alturaEsquerda - alturaDireita) <= 1 &&
                estaBalanceada(no.getEsquerda()) &&
                estaBalanceada(no.getDireita());
    }

    private No<T> rotacaoEsquerda(No<T> no) {
        No<T> novaRaiz = no.getDireita();
        no.setDireita(novaRaiz.getEsquerda());
        novaRaiz.setEsquerda(no);
        return novaRaiz;
    }

    private No<T> rotacaoDireita(No<T> no) {
        No<T> novaRaiz = no.getEsquerda();
        no.setEsquerda(novaRaiz.getDireita());
        novaRaiz.setDireita(no);
        return novaRaiz;
    }

    private No<T> balancear(No<T> no) {
        if (no == null) return null;

        if (altura(no.getEsquerda()) - altura(no.getDireita()) > 1) {
            if (altura(no.getEsquerda().getEsquerda()) < altura(no.getEsquerda().getDireita())) {
                no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            }
            no = rotacaoDireita(no);
        } else if (altura(no.getDireita()) - altura(no.getEsquerda()) > 1) {
            if (altura(no.getDireita().getDireita()) < altura(no.getDireita().getEsquerda())) {
                no.setDireita(rotacaoDireita(no.getDireita()));
            }
            no = rotacaoEsquerda(no);
        }

        return no;
    }

    public void balancearArvore() {
        raiz = balancear(raiz);
    }

    public void espelhar() {
        espelhar(raiz);
    }

    private void espelhar(No<T> no) {
        if (no == null) return;
        No<T> temp = no.getEsquerda();
        no.setEsquerda(no.getDireita());
        no.setDireita(temp);
        espelhar(no.getEsquerda());
        espelhar(no.getDireita());
    }

    public boolean contem(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        return contem(raiz, valor);
    }

    private boolean contem(No<T> noAtual, T valor) {
        if (noAtual == null) return false;
        if (valor.compareTo(noAtual.getValor()) == 0) return true;

        if (valor.compareTo(noAtual.getValor()) < 0)
            return contem(noAtual.getEsquerda(), valor);
        else
            return contem(noAtual.getDireita(), valor);
    }

    public No<T> achar(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        return achar(raiz, valor);
    }

    private No<T> achar(No<T> noAtual, T valor) {
        if (noAtual == null) return null;
        if (valor.compareTo(noAtual.getValor()) == 0) return noAtual;

        if (valor.compareTo(noAtual.getValor()) < 0)
            return achar(noAtual.getEsquerda(), valor);
        else
            return achar(noAtual.getDireita(), valor);
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(No<T> no) {
        if (no == null) return -1;
        return 1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita()));
    }

    public int profundidade(No<T> no) {
        return profundidade(raiz, no, 0);
    }

    private int profundidade(No<T> noAtual, No<T> noProcurado, int profundidadeAtual) {
        if (noAtual == null || noAtual == noProcurado) return profundidadeAtual;
        int profundidadeEsquerda = profundidade(noAtual.getEsquerda(), noProcurado, profundidadeAtual + 1);
        if (profundidadeEsquerda != -1) return profundidadeEsquerda;
        return profundidade(noAtual.getDireita(), noProcurado, profundidadeAtual + 1);
    }

    public boolean estaVazio() {
        return raiz == null;
    }

    public void limpar() {
        raiz = null;
    }

    public int tamanho() {
        if (raiz == null) return 0;
        return tamanho(raiz);
    }

    private int tamanho(No<T> no) {
        if (no == null) return 0;

        if (no.getEsquerda() == null && no.getDireita() == null) return 1;
        if (no.getEsquerda() == null && no.getDireita() != null) return 1 + tamanho(no.getDireita());
        if (no.getEsquerda() != null && no.getDireita() == null) return 1 + tamanho(no.getEsquerda());

        return 1 + tamanho(no.getEsquerda()) + tamanho(no.getDireita());
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
