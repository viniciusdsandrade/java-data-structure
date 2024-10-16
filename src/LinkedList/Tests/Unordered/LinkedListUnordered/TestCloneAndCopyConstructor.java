package LinkedList.Tests.Unordered.LinkedListUnordered;

import LinkedList.Unordered.LinkedListUnordered;

import java.util.LinkedList;
import java.util.List;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        // Teste de cópia vazia
        LinkedListUnordered<Integer> emptyList = new LinkedListUnordered<>();
        LinkedListUnordered<Integer> emptyListCopyConstructor = new LinkedListUnordered<>(emptyList);
        @SuppressWarnings("unchecked")
        LinkedListUnordered<Integer> emptyListClone = (LinkedListUnordered<Integer>) emptyList.clone();
        System.out.println("Teste de cópia vazia:");
        System.out.println("Lista original vazia:                           " + emptyList);
        System.out.println("Cópia da lista vazia com construtor de copia:   " + emptyListCopyConstructor);
        System.out.println("Cópia da lista vazia usando método clone:       " + emptyListClone);
        System.out.println();

        // Teste de hash code
        int emptyListHashCode = emptyList.hashCode();
        int emptyListCopyConstructorHashCode = emptyListCopyConstructor.hashCode();
        int emptyListCloneHashCode = emptyListClone.hashCode();

        System.out.println("Hash code da lista original vazia:                              " + emptyListHashCode);
        System.out.println("Hash code da cópia da lista vazia usando clone:                 " + emptyListCloneHashCode);
        System.out.println("Hash code da cópia da lista vazia usando construtor de cópia:   " + emptyListCopyConstructorHashCode);
        System.out.println();

        LinkedListUnordered<List<LinkedListUnordered<Integer>>> listList = new LinkedListUnordered<>(); // Um LinkedListDisordered de uma lista de LinkedListDisordered de inteiros
        LinkedListUnordered<LinkedListUnordered<List<Integer>>> listListList = new LinkedListUnordered<>(); // Um LinkedListDisordered de um LinkedListDisordered de uma lista de inteiros

        LinkedListUnordered<Integer> list1 = new LinkedListUnordered<>();
        List<Integer> list2 = new LinkedList<>();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        list2.addLast(3);
        list2.addLast(2);
        list2.addLast(1);

        List<LinkedListUnordered<Integer>> list3 = new LinkedList<>();
        list3.addLast(list1);
        list3.addLast(list1);
        list3.addLast(list1);

        LinkedListUnordered<List<Integer>> list4 = new LinkedListUnordered<>();
        list4.addLast(list2);
        list4.addLast(list2);
        list4.addLast(list2);

        listList.addLast(list3);
        listList.addLast(list3);
        listList.addLast(list3);

        listListList.addLast(list4);
        listListList.addLast(list4);
        listListList.addLast(list4);

        LinkedListUnordered<List<LinkedListUnordered<Integer>>> listListCopyConstructor = new LinkedListUnordered<>(listList);
        @SuppressWarnings("unchecked")
        LinkedListUnordered<List<LinkedListUnordered<Integer>>> listListClone = (LinkedListUnordered<List<LinkedListUnordered<Integer>>>) listList.clone();

        LinkedListUnordered<LinkedListUnordered<List<Integer>>> listListListCopyConstructor = new LinkedListUnordered<>(listListList);
        @SuppressWarnings("unchecked")
        LinkedListUnordered<LinkedListUnordered<List<Integer>>> listListListClone = (LinkedListUnordered<LinkedListUnordered<List<Integer>>>) listListList.clone();


        System.out.println("listlist:                       " + listList);
        System.out.println("listlistCopyConstructor:        " + listListCopyConstructor);
        System.out.println("listlistClone:                  " + listListClone);
        System.out.println();
        System.out.println("listlistList:                   " + listListList);
        System.out.println("listlistListCopyConstructor:    " + listListListCopyConstructor);
        System.out.println("listlistListClone:              " + listListListClone);
        System.out.println();

        System.out.println("listlist.hashCode():                        " + listList.hashCode());
        System.out.println("listlistCopyConstructor.hashCode():         " + listListCopyConstructor.hashCode());
        System.out.println("listlistClone.hashCode():                   " + listListClone.hashCode());
        System.out.println();
        System.out.println("listlistList.hashCode():                    " + listListList.hashCode());
        System.out.println("listlistListCopyConstructor.hashCode():     " + listListListCopyConstructor.hashCode());
        System.out.println("listlistListClone.hashCode():               " + listListListClone.hashCode());
        System.out.println();

        // Agora vou testar as modificações da lista original e ver se as cópias são afetadas
        listList.addLast(list3);
        listListList.addLast(list4);

        System.out.println("listlist após modificações:                       " + listList);
        System.out.println("listlistCopyConstructor após modificações:        " + listListCopyConstructor);
        System.out.println("listlistClone após modificações:                  " + listListClone);
        System.out.println();

        System.out.println("listlistList após modificações:                   " + listListList);
        System.out.println("listlistListCopyConstructor após modificações:    " + listListListCopyConstructor);
        System.out.println("listlistListClone após modificações:              " + listListListClone);
        System.out.println();

        // Novo hashCode
        System.out.println("listlist.hashCode() após modificações:       " + listList.hashCode());
        System.out.println("listlistCopyConstructor.hashCode() :         " + listListCopyConstructor.hashCode());
        System.out.println("listlistClone.hashCode() :                   " + listListClone.hashCode());
        System.out.println();
        System.out.println("listlistList.hashCode() após modificações:   " + listListList.hashCode());
        System.out.println("listlistListCopyConstructor.hashCode() :     " + listListListCopyConstructor.hashCode());
        System.out.println("listlistListClone.hashCode() :               " + listListListClone.hashCode());

        try {
            LinkedListUnordered<Integer> nullList = null;
            LinkedListUnordered<Integer> nullListClone = new LinkedListUnordered<>(nullList);
            System.out.println("Teste de clonagem de lista encadeada nula:");
            System.out.println("Cópia de lista encadeada nula: " + nullListClone);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção ao tentar clonar lista encadeada nula: " + e.getMessage());
        }

    }
}

