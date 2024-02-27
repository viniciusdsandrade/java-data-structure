package LinkedList;
/*
extends LinkedList
1 - void add(int index, E element) Inserts the specified element at the specified position in this list.
2 - boolean add(E e) Appends the specified element to the end of this list.
3 - boolean addAll(int index, Collection<? extends E> c) Inserts all of the elements in the specified collection into this list, starting at the specified position.
4 - boolean addAll(Collection<? extends E> c) Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
5 - void addFirst(E e) Inserts the specified element at the beginning of this list.
6 - void addLast(E e) Appends the specified element to the end of this list.
7 - void clear() Removes all of the elements from this list.
8 - Object clone() Returns a shallow copy of this LinkedList.
9 - boolean contains(Object o) Returns true if this list contains the specified element.
10 - Iterator<E> descendingIterator() Returns an iterator over the elements in this deque in reverse sequential order.
11 - E element() Retrieves, but does not remove, the head (first element) of this list.
12 - E get(int index) Returns the element at the specified position in this list.
13 - E getFirst() Returns the first element in this list.
14 - E getLast() Returns the last element in this list.
15 - int indexOf(Object o) Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
16 - int lastIndexOf(Object o) Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
17 - ListIterator<E> listIterator(int index) Returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list.
18 - boolean offer(E e) Adds the specified element as the tail (last element) of this list.
19 - boolean offerFirst(E e) Inserts the specified element at the front of this list.
20 - boolean offerLast(E e) Inserts the specified element at the end of this list.
21 - E peek() Retrieves, but does not remove, the head (first element) of this list.
22 - E peekFirst() Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
23 - E peekLast() Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
24 - E poll() Retrieves and removes the head (first element) of this list.
25 - E pollFirst() Retrieves and removes the first element of this list, or returns null if this list is empty.
26 - E pollLast() Retrieves and removes the last element of this list, or returns null if this list is empty.
27 - E pop() Pops an element from the stack represented by this list.
28 - void push(E e) Pushes an element onto the stack represented by this list.
29 - E remove() Retrieves and removes the head (first element) of this list.
30 - E remove(int index) Removes the element at the specified position in this list.
31 - boolean remove(Object o) Removes the first occurrence of the specified element from this list, if it is present.
32 - E removeFirst() Removes and returns the first element from this list.
33 - boolean removeFirstOccurrence(Object o) Removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
34 - E removeLast() Removes and returns the last element from this list.
35 - boolean removeLastOccurrence(Object o) Removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
36 - LinkedList<E> reversed() Returns a reverse-ordered view of this collection.
37 - E set(int index, E element) Replaces the element at the specified position in this list with the specified element.
38 - int size() Returns the number of elements in this list.
39 - Spliterator<E> spliterator() Creates a late-binding and fail-fast Spliterator over the elements in this list.
40 - Object[] toArray() Returns an array containing all of the elements in this list in proper sequence (from first to last element).
41 - <T> T[] toArray(T[] a) Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.
 */

import java.util.Objects;

public class LinkedListDisordered<X> implements Cloneable {

    public class Node implements Cloneable {

        public X data;
        public Node next;

        public Node(X valor) {
            this.data = valor;
            this.next = null;
        }
        public Node(X valor, Node next) {
            this.data = valor;
            this.next = next;
        }

        public X getData() {
            return data;
        }
        public void setData(X data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }

        /*
         Construtor de cópia
         */
        public Node(Node other) {
            this.data = other.data;
            this.next = other.next;
        }

        @Override
        public final int hashCode() {
            final int prime = 31;
            int hash = 1;

            hash *= prime + ((this.data == null) ? 0 : this.data.hashCode());

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        @SuppressWarnings("unchecked")
        public final boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Node other = (Node) obj;

            return Objects.equals(this.data, other.data);
        }


        @Override
        public final Object clone() {
            Node clone = null;

            try {
                clone = new Node(this);
            } catch (Exception ignored) {
            }

            return clone;
        }

        @Override
        public final String toString() {
            if (this.next != null)
                return "Node{data=" + this.data + ", next=" + this.next.data + "}";
            else
                return "Node{data=" + this.data + ", next=null}";
        }
    }

    private Node head;
    private final int size;

    public LinkedListDisordered() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(X data) {
        if (data == null) throw new IllegalArgumentException("Valor não pode ser nulo");

        Node novo = new Node(data);
        novo.next = head;
        head = novo;
    }

    public void removeFirst() {
        if (head == null)
            throw new IllegalStateException("Lista vazia");

        head = head.next;
    }

    public void addLast(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor não pode ser nulo");

        Node novo = new Node(valor);
        Node aux = head;
        if (aux == null) {
            head = novo;
        } else {
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = novo;
        }
    }

    public void removeLast() {
        if (head == null)
            throw new IllegalStateException("Lista vazia");

        if (head.next == null) {
            head = null;
        } else {
            Node aux = head;
            while (aux.next.next != null) {
                aux = aux.next;
            }
            aux.next = null;
        }
    }

    public void add(X valor) {
        Node novo = new Node(valor);
        Node aux = head;
        if (aux == null) {
            head = novo;
        } else {
            while (aux.next != null) {
                aux = aux.getNext();
            }
            aux.next = novo;
        }
    }

    public boolean contains(X valor) {
        Node aux = head;
        while (aux != null) {
            if (aux.data.equals(valor)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public X getFirst() {
        if (head == null)
            throw new IllegalStateException("Lista vazia");

        return head.data;
    }

    public X getLast() {
        if (head == null)
            throw new IllegalStateException("Lista vazia");

        Node aux = head;
        while (aux.next != null) {
            aux = aux.next;
        }

        return aux.data;
    }

    public X get(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux.data;
    }

    public void clear() {
        head = null;
    }

    public LinkedListDisordered(LinkedListDisordered<X> other) {
        this.head = other.head;
        this.size = other.size;
    }

    @Override
    public Object clone() {
        LinkedListDisordered<X> clone = null;

        try {
            clone = new LinkedListDisordered<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        Node aux = head;
        while (aux != null) {
            hash *= prime + ((aux.data == null) ? 0 : aux.data.hashCode());
            aux = aux.next;
        }

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        LinkedListDisordered<X> other = (LinkedListDisordered<X>) obj;

        if (this.size != other.size) return false;

        Node aux1 = this.head;
        Node aux2 = other.head;

        while (aux1 != null) {
            if (!aux1.equals(aux2)) return false;
            aux1 = aux1.next;
            aux2 = aux2.next;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node aux = head;
        while (aux != null) {
            sb.append(aux.data);
            if (aux.next != null) {
                sb.append(" -> ");
            }
            aux = aux.next;
        }
        sb.append("]");
        return sb.toString();
    }
}