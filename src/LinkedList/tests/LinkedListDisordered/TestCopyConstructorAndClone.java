package LinkedList.tests.LinkedListDisordered;

import LinkedList.LinkedListDisordered;

import java.util.LinkedList;
import java.util.List;

public class TestCopyConstructorAndClone {
    public static void main(String[] args) {
        // Teste de cópia vazia
        LinkedListDisordered<Integer> emptyList = new LinkedListDisordered<>();
        LinkedListDisordered<Integer> emptyListCopyConstructor = new LinkedListDisordered<>(emptyList);
        LinkedListDisordered<Integer> emptyListClone = (LinkedListDisordered<Integer>) emptyList.clone();
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

        LinkedListDisordered<List<LinkedListDisordered<Integer>>> listList = new LinkedListDisordered<>(); // Um LinkedListDisordered de uma lista de LinkedListDisordered de inteiros
        LinkedListDisordered<LinkedListDisordered<List<Integer>>> listListList = new LinkedListDisordered<>(); // Um LinkedListDisordered de um LinkedListDisordered de uma lista de inteiros

        LinkedListDisordered<Integer> list1 = new LinkedListDisordered<>();
        List<Integer> list2 = new LinkedList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(3);
        list2.add(2);
        list2.add(1);

        List<LinkedListDisordered<Integer>> list3 = new LinkedList<>();
        list3.add(list1);
        list3.add(list1);
        list3.add(list1);

        LinkedListDisordered<List<Integer>> list4 = new LinkedListDisordered<>();
        list4.add(list2);
        list4.add(list2);
        list4.add(list2);

        listList.add(list3);
        listList.add(list3);
        listList.add(list3);

        listListList.add(list4);
        listListList.add(list4);
        listListList.add(list4);

        LinkedListDisordered<List<LinkedListDisordered<Integer>>> listListCopyConstructor = new LinkedListDisordered<>(listList);
        LinkedListDisordered<List<LinkedListDisordered<Integer>>> listListClone = (LinkedListDisordered<List<LinkedListDisordered<Integer>>>) listList.clone();

        LinkedListDisordered<LinkedListDisordered<List<Integer>>> listListListCopyConstructor = new LinkedListDisordered<>(listListList);
        LinkedListDisordered<LinkedListDisordered<List<Integer>>> listListListClone = (LinkedListDisordered<LinkedListDisordered<List<Integer>>>) listListList.clone();


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
            LinkedListDisordered<Integer> nullList = null;
            LinkedListDisordered<Integer> nullListClone = new LinkedListDisordered<>(nullList);
            System.out.println("Teste de clonagem de lista encadeada nula:");
            System.out.println("Cópia de lista encadeada nula: " + nullListClone);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção ao tentar clonar lista encadeada nula: " + e.getMessage());
        }

    }
}

