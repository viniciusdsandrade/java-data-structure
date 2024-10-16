package LinkedList.Ordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListOrdered<X extends Comparable<X>> implements Cloneable {

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
        @SuppressWarnings("MethodDoesntCallSuperMethod")
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

            Node other = (Node) obj;

            return Objects.equals(this.elemento, other.elemento);
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
    public int tamanho;

    public DoubleLinkedListOrdered() {
        this.primeiro = null;
        this.tamanho = 0;
    }
    public Node getPrimeiro() {
        return primeiro;
    }
    public int getTamanho() {
        return tamanho;
    }

    @SuppressWarnings("unchecked")
    public void add(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento ausente.");

        Node novo = new Node((X) verifyAndCopy(elemento));

        if (this.primeiro == null) { // Se a lista estiver vazia
            this.primeiro = novo;
            tamanho++;
            return;
        }

        Node atual = this.primeiro;
        Node anterior = null;

        // Encontra a posição correta para inserir o novo nó
        while (atual != null && atual.elemento.compareTo(elemento) < 0) {
            anterior = atual;
            atual = atual.proximo;
        }

        // Insere o novo nó na posição correta
        if (anterior == null) { // Inserir no início da lista
            novo.proximo = this.primeiro;
            this.primeiro.anterior = novo;
            this.primeiro = novo;
        } else { // Inserir no meio ou final da lista
            anterior.proximo = novo;
            novo.anterior = anterior;
            if (atual != null) {
                atual.anterior = novo;
            }
            novo.proximo = atual;
        }

        tamanho++;
    }

    public X get(int index) {
        if (index < 0 || index >= tamanho) return null;

        Node temp = primeiro;

        for (int i = 0; i < index; i++)
            temp = temp.proximo;

        return temp.elemento;
    }

    public X getFirst() {
        if (primeiro == null) return null;

        return primeiro.elemento;
    }

    public X getLast() {
        if (primeiro == null) return null;

        Node temp = primeiro;

        while (temp.proximo != null)
            temp = temp.proximo;

        return temp.elemento;
    }

    public void removeFirst() {
        if (primeiro == null) return;

        primeiro = primeiro.proximo;
        tamanho--;
    }

    public void removeLast() {
        if (primeiro == null) return;

        Node temp = primeiro;
        Node anterior = null;

        while (temp.proximo != null) {
            anterior = temp;
            temp = temp.proximo;
        }

        if (anterior == null) {
            primeiro = null;
        } else {
            anterior.proximo = null;
        }

        tamanho--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= tamanho) return;

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == tamanho - 1) {
            removeLast();
            return;
        }

        Node temp = primeiro;
        Node anterior = null;

        for (int i = 0; i < index; i++) {
            anterior = temp;
            temp = temp.proximo;
        }

        anterior.proximo = temp.proximo;
        tamanho--;
    }

    public boolean contains(X elemento) {
        Node temp = primeiro;

        while (temp != null) {
            if (temp.elemento.equals(elemento)) {
                return true;
            }

            temp = temp.proximo;
        }

        return false;
    }

    public int indexOf(X elemento) {
        Node temp = primeiro;
        int index = 0;

        while (temp != null) {
            if (temp.elemento.equals(elemento)) {
                return index;
            }

            temp = temp.proximo;
            index++;
        }

        return -1;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void clear() {
        primeiro = null;
        tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedListOrdered(DoubleLinkedListOrdered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Lista não pode ser nula.");

        if (modelo.primeiro == null) {
            this.primeiro = null;
            this.tamanho = 0;
            return;
        }

        Node atual = modelo.primeiro;
        Node anterior = null;
        while (atual != null) {
            Node novo = new Node((X) verifyAndCopy(atual.elemento));
            if (anterior == null) {
                this.primeiro = novo;
            } else {
                anterior.proximo = novo;
                novo.anterior = anterior;
            }
            anterior = novo;
            atual = atual.proximo;
        }

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() {
        DoubleLinkedListOrdered<X> clone = null;
        try {
            clone = new DoubleLinkedListOrdered<>(this);
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

        DoubleLinkedListOrdered<X> that = (DoubleLinkedListOrdered<X>) obj;

        if (this.tamanho != that.tamanho) return false;

        Node temp1 = this.primeiro;
        Node temp2 = that.primeiro;

        while (temp1 != null) {
            if (!temp1.equals(temp2)) return false;
            temp1 = temp1.proximo;
            temp2 = temp2.proximo;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        Node temp = this.primeiro;
        while (temp != null) {
            hash *= prime + (temp.elemento == null ? 0 : temp.elemento.hashCode());
            temp = temp.proximo;
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

        while (temp != null) {
            if (!primeiroElemento)
                result.append(" <-> ");
            else
                primeiroElemento = false;

            result.append(temp.elemento);
            temp = temp.proximo;
        }

        result.append("]");
        return result.toString();
    }
}
