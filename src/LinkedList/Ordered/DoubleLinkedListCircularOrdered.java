package LinkedList.Ordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListCircularOrdered<X extends Comparable<X>> implements Cloneable {

    public class Node implements Cloneable {
        public X elemento;
        public Node proximo;
        public Node anterior;

        public Node() {
        }
        public Node(X elemento) {
            this.elemento = elemento;
            this.proximo = null;
            this.anterior = null;
        }
        public X getElemento() {
            return elemento;
        }
        public Node getProximo() {
            return proximo;
        }
        public Node getAnterior() {
            return anterior;
        }

        @SuppressWarnings("unchecked")
        public Node(Node modelo) {
            if (modelo == null) throw new IllegalArgumentException("Modelo não pode ser nulo.");

            this.elemento = (X) verifyAndCopy(modelo.elemento);
            this.proximo = (Node) verifyAndCopy(modelo.proximo);
            this.anterior = (Node) verifyAndCopy(modelo.anterior);
        }

        @Override
        public Object clone() {
            Node clone = null;
            try {
                clone = new Node(this);
            } catch (Exception ignored) {
            }
            return clone;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Node no = (Node) obj;

            return Objects.equals(this.elemento, no.elemento);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int hash = 1;

            hash *= prime + (this.elemento == null ? 0 : this.elemento.hashCode());

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        public String toString() {
            if (proximo != null)
                return elemento + " <-> " + proximo.elemento;
            else
                return elemento.toString();
        }
    }

    public Node primeiro;
    public Node ultimo;
    public int tamanho;

    public DoubleLinkedListCircularOrdered() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    public Node getPrimeiro() {
        return primeiro;
    }
    public Node getUltimo() {
        return ultimo;
    }
    public int getTamanho() {
        return tamanho;
    }

    @SuppressWarnings("unchecked")
    public void add(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento ausente");

        Node novo = new Node((X) verifyAndCopy(elemento));

        if (this.tamanho == 0) {
            this.primeiro = novo;
            this.ultimo = novo;
            novo.proximo = novo; // Circular: o próximo do novo nó é ele mesmo
            novo.anterior = novo; // Circular: o anterior do novo nó é ele mesmo
            tamanho++;
            return;
        }

        Node atual = this.primeiro;
        Node anterior = null;
        while (atual != null && atual.elemento.compareTo(elemento) < 0) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (anterior == null) {
            novo.proximo = this.primeiro;
            novo.anterior = this.ultimo;
            this.primeiro.anterior = novo;
            this.primeiro = novo;
            this.ultimo.proximo = novo; // Ajuste para manter a circularidade
        } else {
            // Inserir no meio ou no final
            anterior.proximo = novo;
            novo.anterior = anterior;
            novo.proximo = atual;
            if (atual != null) {
                atual.anterior = novo;
            } else {
                // Inserir no final
                this.ultimo.proximo = novo;
                novo.anterior = this.ultimo;
                this.ultimo = novo;
                this.primeiro.anterior = novo; // Ajuste para manter a circularidade
            }
        }

        tamanho++;
    }


    public X get(int indice) {
        if (indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Posição inválida.");

        Node temp = primeiro;
        for (int i = 0; i < indice; i++)
            temp = temp.proximo;

        return temp.elemento;
    }

    public X getFirst() {
        if (primeiro == null) return null;

        return primeiro.elemento;
    }

    public X getLast() {
        if (ultimo == null) return null;

        return ultimo.elemento;
    }

    public void removeFirst() {
        if (tamanho == 0) return;

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
            tamanho = 0;
            return;
        }

        primeiro.proximo.anterior = ultimo;
        ultimo.proximo = primeiro.proximo;
        primeiro = primeiro.proximo;

        tamanho--;
    }

    public void removeLast() {
        if (tamanho == 0) return;

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
            tamanho = 0;
            return;
        }

        ultimo.anterior.proximo = primeiro;
        primeiro.anterior = ultimo.anterior;
        ultimo = ultimo.anterior;

        tamanho--;
    }

    public void removeAt(int posicao) {
        if (posicao < 0 || posicao > tamanho) throw new IndexOutOfBoundsException("Posição inválida.");

        if (posicao == 0) {
            removeFirst();
            return;
        }

        if (posicao == tamanho - 1) {
            removeLast();
            return;
        }

        Node temp = primeiro;
        for (int i = 0; i < posicao; i++)
            temp = temp.proximo;

        temp.anterior.proximo = temp.proximo;
        temp.proximo.anterior = temp.anterior;

        tamanho--;
    }

    public boolean contains(X elemento) {
        if (elemento == null) return false;

        Node temp = primeiro;
        while (temp != null) {
            if (temp.elemento.equals(elemento)) return true;
            temp = temp.proximo;
        }

        return false;
    }

    public int indexOf(X elemento) {
        if (elemento == null) return -1;

        Node temp = primeiro;
        int indice = 0;
        while (temp != null) {
            if (temp.elemento.equals(elemento)) return indice;
            temp = temp.proximo;
            indice++;
        }

        return -1;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void clear() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedListCircularOrdered(DoubleLinkedListCircularOrdered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Lista não pode ser nula.");

        if (modelo.primeiro == null) {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho = 0;
            return;
        }

        Node primeiro = modelo.primeiro;
        while (primeiro != null && primeiro != modelo.ultimo) {
            this.add((X) verifyAndCopy(primeiro.elemento));
            primeiro = primeiro.proximo;
        }

        if (primeiro != null)
            this.add((X) verifyAndCopy(primeiro.elemento));

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    public Object clone() {
        DoubleLinkedListCircularOrdered<X> clone = null;
        try {
            clone = new DoubleLinkedListCircularOrdered<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        DoubleLinkedListCircularOrdered<X> that = (DoubleLinkedListCircularOrdered<X>) obj;

        if (this.primeiro == null && that.primeiro != null) return true;
        if (this.primeiro != null && that.primeiro == null) return false;
        if (this.primeiro == null) return true;

        Node tempThis = this.primeiro;
        Node tempThat = that.primeiro;

        for (int i = 0; i < this.tamanho; i++) {
            if (!tempThis.equals(tempThat))
                return false;
            tempThis = tempThis.proximo;
            tempThat = tempThat.proximo;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        Node auxiliar = primeiro;
        for (int i = 0; i < tamanho; i++) {
            hash *= prime + (auxiliar.elemento == null ? 0 : auxiliar.elemento.hashCode());
            auxiliar = auxiliar.proximo;
        }

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        if (primeiro == null) return "[]";

        StringBuilder result = new StringBuilder("[");
        Node temp = primeiro;
        boolean primeiroElemento = true;

        do {
            if (!primeiroElemento)
                result.append(" <-> ");
            else
                primeiroElemento = false;
            result.append(temp.elemento);
            temp = temp.proximo;
        } while (temp != primeiro);

        result.append("]");
        return result.toString();
    }
}