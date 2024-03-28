package LinkedList.Disordered;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class DoubleLinkedListDisordered<X> implements Cloneable {

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
            if (modelo == null) throw new IllegalArgumentException("Modelo ausente");

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
    }

    public Node primeiro;
    public int tamanho;

    public DoubleLinkedListDisordered() {
        primeiro = null;
        tamanho = 0;
    }

    public Node getPrimeiro() {
        return primeiro;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void addLast(X elemento) {
        Node novo = new Node(elemento);
        Node temp = primeiro;
        Node anterior = null;

        while (temp != null) {
            anterior = temp;
            temp = temp.proximo;
        }

        if (anterior == null) {
            primeiro = novo;
        } else {
            anterior.proximo = novo;
            novo.anterior = anterior;
        }

        tamanho++;
    }

    public void addFirst(X elemento) {
        Node novo = new Node(elemento);
        Node temp = primeiro;
        Node anterior = null;

        while (temp != null) {
            anterior = temp;
            temp = temp.proximo;
        }

        if (anterior == null) {
            primeiro = novo;
        } else {
            anterior.proximo = novo;
            novo.anterior = anterior;
        }

        tamanho++;
    }

    public void addAt(int index, X elemento) {
        if (index < 0 || index > tamanho) throw new IllegalArgumentException("Índice inválido");

        if (index == 0) {
            addFirst(elemento);
            return;
        }

        if (index == tamanho) {
            addLast(elemento);
            return;
        }

        Node novo = new Node(elemento);
        Node temp = primeiro;
        Node anterior = null;

        for (int i = 0; i < index; i++) {
            anterior = temp;
            temp = temp.proximo;
        }

        anterior.proximo = novo;
        novo.anterior = anterior;
        novo.proximo = temp;
        temp.anterior = novo;

        tamanho++;
    }

    public X get(int index) {
        if (index < 0 || index >= tamanho) throw new IllegalArgumentException("Índice inválido");

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
        while (temp.proximo != null) {
            temp = temp.proximo;
        }

        return temp.elemento;
    }

    public void removeFirst() {
        if (primeiro == null) return;

        if (primeiro.proximo == null) {
            primeiro = null;
            tamanho--;
            return;
        }

        primeiro = primeiro.proximo;
        primeiro.anterior = null;
        tamanho--;
    }

    public void removeLast() {
        if (primeiro == null) return;

        if (primeiro.proximo == null) {
            primeiro = null;
            tamanho--;
            return;
        }

        Node temp = primeiro;
        Node anterior = null;

        while (temp.proximo != null) {
            anterior = temp;
            temp = temp.proximo;
        }

        anterior.proximo = null;
        tamanho--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= tamanho) throw new IllegalArgumentException("Índice inválido");

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
        temp.proximo.anterior = anterior;
        tamanho--;
    }

    public int indexOf(X elemento) {
        Node temp = primeiro;
        int index = 0;

        while (temp != null) {
            if (temp.elemento.equals(elemento))
                return index;
            temp = temp.proximo;
            index++;
        }

        return -1;
    }

    public void clear() {
        primeiro = null;
        tamanho = 0;
    }

    @Override
    public Object clone() {
        DoubleLinkedListDisordered<X> clone = null;
        try {
            clone = new DoubleLinkedListDisordered<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedListDisordered(DoubleLinkedListDisordered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo ausente");

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
        this.primeiro = (Node) verifyAndCopy(modelo.primeiro);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;

        DoubleLinkedListDisordered<X> lista = (DoubleLinkedListDisordered<X>) obj;

        if (this.tamanho != lista.tamanho) return false;

        Node tempThis = this.primeiro;
        Node tempLista = lista.primeiro;

        while (tempThis != null) {
            if (!tempThis.elemento.equals(tempLista.elemento))
                return false;

            tempThis = tempThis.proximo;
            tempLista = tempLista.proximo;
        }

        return true;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        Node temp = this.primeiro;
        while (temp != null) {
            hash = prime * hash + temp.elemento.hashCode();
            temp = temp.proximo;
        }

        if (hash < 0) hash = hash * -1;

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