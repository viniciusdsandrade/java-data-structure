package LinkedList.Unordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class LinkedListCircularUnordered<X> implements Cloneable {

    public class Node implements Cloneable {
        public X elemento;
        public Node proximo;

        public Node() {
        }
        public Node(X elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
        public Node getProximo() {
            return proximo;
        }
        public X getElemento() {
            return elemento;
        }

        @SuppressWarnings("unchecked")
        public Node(Node modelo)  {
            if (modelo == null) throw new IllegalArgumentException("Modelo não pode ser nulo.");

            this.elemento = (X) verifyAndCopy(modelo.elemento);
            this.proximo = (Node) verifyAndCopy(modelo.proximo);
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

            Node that = (Node) obj;

            return Objects.equals(this.elemento, that.elemento);
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
                return elemento + " -> " + proximo.elemento;
            else
                return elemento.toString();
        }
    }

    public Node primeiro;
    public Node ultimo;
    public int tamanho;

    public LinkedListCircularUnordered() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
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
    public void addFirst(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo.");

        Node novo = new Node((X) verifyAndCopy(elemento));

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
            novo.proximo = primeiro;
            tamanho++;
            return;
        }

        novo.proximo = primeiro;
        primeiro = novo;
        ultimo.proximo = primeiro;

        tamanho++;
    }

    @SuppressWarnings("unchecked")
    public void addLast(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo.");

        Node novo = new Node((X) verifyAndCopy(elemento));

        if (primeiro == null)
            primeiro = novo;
        else
            ultimo.proximo = novo;

        ultimo = novo;
        ultimo.proximo = primeiro;

        tamanho++;
    }

    @SuppressWarnings("unchecked")
    public void addAt(int posicao, X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo.");
        if (posicao < 0 || posicao > tamanho) throw new IndexOutOfBoundsException("Posição inválida.");

        if (posicao == 0) {
            addFirst(elemento);
            return;
        }

        if (posicao == tamanho) {
            addLast(elemento);
            return;
        }

        Node novo = new Node((X) verifyAndCopy(elemento));
        Node temp = primeiro;

        for (int i = 0; i < posicao - 1; i++)
            temp = temp.proximo;

        novo.proximo = temp.proximo;
        temp.proximo = novo;

        tamanho++;
    }

    public X getFirst() {
        if (primeiro == null) return null;

        return primeiro.elemento;
    }

    public X getLast() {
        if (ultimo == null) return null;

        return ultimo.elemento;
    }

    public X get(int posicao) {
        if (posicao < 0 || posicao >= tamanho) throw new IndexOutOfBoundsException("Posição inválida.");
        
        Node temp = primeiro;
        
        for (int i = 0; i < posicao; i++) 
            temp = temp.proximo;

        return temp.elemento;
    }

    public void removeFirst() {
        if (primeiro == null) return;
        
        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
            tamanho--;
            return;
        }

        primeiro = primeiro.proximo;
        ultimo.proximo = primeiro;
        tamanho--;
    }

    public void removeLast() {
        if (primeiro == null) return;
        
        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
            tamanho--;
            return;
        }

        Node temp = primeiro;
        while (temp.proximo != ultimo) {
            temp = temp.proximo;
        }

        ultimo = temp;
        ultimo.proximo = primeiro;
        tamanho--;
    }

    public void removeAt(int posicao) {
        if (posicao < 0 || posicao >= tamanho) throw new IndexOutOfBoundsException("Posição inválida.");
        
        if (posicao == 0) {
            removeFirst();
            return;
        }

        if (posicao == tamanho - 1) {
            removeLast();
            return;
        }

        Node temp = primeiro;
        for (int i = 0; i < posicao - 1; i++) 
            temp = temp.proximo;

        temp.proximo = temp.proximo.proximo;
        tamanho--;
    }

    public boolean contains(X elemento) {
        Node temp = primeiro;
        for (int i = 0; i < tamanho; i++) {
            if (temp.elemento.equals(elemento))
                return true;
            temp = temp.proximo;
        }

        return false;
    }

    public int indexOf(X elemento) {
        if (elemento == null ) return -1;

        Node temp = primeiro;
        for (int i = 0; i < tamanho; i++) {
            if (temp.elemento.equals(elemento))
                return i;
            temp = temp.proximo;
        }

        return -1;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void rotate(int passos){
        if (primeiro == null || primeiro.proximo == null) return;

        passos = passos % tamanho;
        if (passos < 0) passos += tamanho;
        if (passos == 0) return;

        Node aux = primeiro;
        for (int i = 0; i < passos; i++)
            aux = aux.proximo;

        Node novoHead = aux.proximo;
        Node oldLast = ultimo;
        ultimo = aux;
        ultimo.proximo = null;
        oldLast.proximo = primeiro;
        primeiro = novoHead;
    }

    @SuppressWarnings("unchecked")
    public LinkedListCircularUnordered(LinkedListCircularUnordered<X> modelo)  {
        if (modelo == null) throw new IllegalArgumentException("Lista não pode ser nula");

        if (modelo.primeiro == null) {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho = 0;
            return;
        }

        Node auxiliar = modelo.primeiro;
        Node copia = new Node((X) verifyAndCopy(auxiliar.elemento));
        this.primeiro = copia;

        while (auxiliar.proximo != modelo.primeiro) {
            auxiliar = auxiliar.proximo;
            copia.proximo = new Node((X) verifyAndCopy(auxiliar.elemento));
            copia = copia.proximo;
        }

        copia.proximo = this.primeiro;
        this.ultimo = copia;
        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() {
        LinkedListCircularUnordered<X> clone = null;
        try {
            clone = new LinkedListCircularUnordered<>(this);
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

        LinkedListCircularUnordered<X> that = (LinkedListCircularUnordered<X>) obj;

        if (this.primeiro == null) return true;
        if (this.tamanho != that.tamanho) return false;

        Node tempThis = this.primeiro;
        Node tempThat = that.primeiro;

        for (int i = 0; i < this.tamanho; i++) {
            if (!tempThis.equals(tempThat)) return false;
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
            if (temp == null) break;
            if (!primeiroElemento) 
                result.append(" -> ");
            else 
                primeiroElemento = false;
            result.append(temp.elemento);
            temp = temp.proximo;
        } while (temp != primeiro && temp != null);

        result.append("]");
        return result.toString();
    }
}