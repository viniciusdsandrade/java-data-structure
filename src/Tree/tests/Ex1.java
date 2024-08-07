package Tree.tests;

import java.util.Arrays;

public class Ex1 {

    /**
     * Gera um array de números inteiros aleatórios dentro de um intervalo especificado.
     *
     * @param qnt A quantidade de números inteiros a serem gerados.
     * @param min O valor mínimo (inclusive) que um número gerado pode ter.
     * @param max O valor máximo (inclusive) que um número gerado pode ter.
     * @return Um array de números inteiros aleatórios com a quantidade especificada.
     */
    public static int[] generateRandom(int qnt, int min, int max) {
        int[] arr = new int[qnt];
        for (int i = 0; i < qnt; i++)
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
        return arr;
    }

    /**
     * Ordena um array de números inteiros usando o algoritmo de ordenação por seleção (Selection Sort).
     *
     * <p>O Selection Sort é um algoritmo de ordenação simples que funciona dividindo o array em duas partes:
     * a parte ordenada no início e a parte não ordenada no restante. A cada iteração, o algoritmo seleciona o
     * menor (ou maior, dependendo da ordem) elemento da parte não ordenada e o troca com o primeiro elemento
     * não ordenado, movendo o limite entre as duas partes para frente.</p>
     *
     * <p>O processo continua até que todos os elementos estejam na parte ordenada. Como o algoritmo sempre
     * percorre o array inteiro para encontrar o próximo menor elemento, ele é menos eficiente para grandes
     * conjuntos de dados, com complexidade de tempo de {@code O(n²)}.</p>
     *
     * <p>Embora seja mais eficiente que o Bubble Sort em termos de número de trocas, o Selection Sort ainda
     * não é adequado para ordenar grandes arrays em comparação com algoritmos mais eficientes como Quicksort
     * ou Merge Sort.</p>
     *
     * @param arr O array de números inteiros a ser ordenado.
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int aux = arr[i];
            arr[i] = arr[min];
            arr[min] = aux;
        }
    }

    /**
     * Ordena um array de números inteiros utilizando o metodo {@code Arrays.sort()} da classe {@code Arrays},
     * que implementa o algoritmo de ordenação Dual-Pivot Quicksort.
     *
     * <p>O Dual-Pivot Quicksort é uma versão otimizada do Quicksort tradicional, que utiliza dois pivôs em vez de um.
     * O algoritmo divide o array em três partes:
     * <ul>
     *   <li>Elementos menores que o primeiro pivô;</li>
     *   <li>Elementos entre os dois pivôs;</li>
     *   <li>Elementos maiores que o segundo pivô.</li>
     * </ul>
     * Cada uma dessas partes é ordenada recursivamente, resultando em um desempenho eficiente na maioria dos casos.
     * O Dual-Pivot Quicksort é conhecido por sua rapidez e eficiência, tendo complexidade de tempo média de
     * {@code O(n log n)}.</p>
     *
     * @param arr O array de números inteiros a ser ordenado.
     */
    public static void sortUsingArraysSort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * Ordena um array de números inteiros utilizando o algoritmo de ordenação por bolha (Bubble Sort).
     *
     * <p>O Bubble Sort é um algoritmo de ordenação simples que funciona repetidamente percorrendo o array,
     * comparando elementos adjacentes e trocando-os se estiverem na ordem incorreta. Esse processo "empurra"
     * os maiores elementos para o final do array em cada iteração, como bolhas que flutuam para a superfície.</p>
     *
     * <p>O algoritmo continua repetindo esse processo até que o array esteja ordenado. Uma otimização comum
     * é interromper o algoritmo se nenhuma troca for realizada durante uma iteração, o que indica que o array
     * já está ordenado.</p>
     *
     * <p>Embora o Bubble Sort seja fácil de entender e implementar, ele é ineficiente para grandes conjuntos de
     * dados devido à sua complexidade de tempo de {@code O(n²)}, onde {@code n} é o número de elementos no array.</p>
     *
     * @param arr O array de números inteiros a ser ordenado.
     */
    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    /**
     * Ordena um array de números inteiros utilizando o algoritmo Merge Sort.
     *
     * <p>O Merge Sort é um algoritmo de ordenação que segue a abordagem "divisão e conquista". Ele divide o array
     * em duas metades, ordena cada metade recursivamente e, em seguida, mescla as duas metades ordenadas.</p>
     *
     * <p>Esse algoritmo tem uma complexidade de tempo de {@code O(n log n)}, sendo mais eficiente do que algoritmos
     * como Bubble Sort e Selection Sort, especialmente para grandes conjuntos de dados.</p>
     *
     * @param arr O array de números inteiros a ser ordenado.
     */
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    /**
     * Ordena um array de números inteiros utilizando o algoritmo Heap Sort.
     *
     * <p>O Heap Sort é um algoritmo de ordenação que utiliza uma estrutura de dados chamada heap. O array é
     * transformado em um heap (max-heap para ordenação crescente), e então o maior elemento é extraído e
     * colocado na posição correta no array.</p>
     *
     * <p>O Heap Sort tem uma complexidade de tempo de {@code O(n log n)} e é eficiente em termos de espaço,
     * pois ordena o array in-place, sem necessidade de espaço adicional significativo.</p>
     *
     * @param arr O array de números inteiros a ser ordenado.
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }


    public static void main(String[] args) {
        int[] arrOriginal = generateRandom(1000, 0, 1000);
        System.out.println("Original:            " + Arrays.toString(arrOriginal));

        int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
        int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
        int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
        int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
        int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);

        long start1 = System.nanoTime();
        selectionSort(arrCopy1);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        sortUsingArraysSort(arrCopy2);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        bubbleSort(arrCopy3);
        long end3 = System.nanoTime();

        long start4 = System.nanoTime();
        mergeSort(arrCopy4);
        long end4 = System.nanoTime();

        long start5 = System.nanoTime();
        heapSort(arrCopy5);
        long end5 = System.nanoTime();

        long runtime1 = end1 - start1;
        long runtime2 = end2 - start2;
        long runtime3 = end3 - start3;
        long runtime4 = end4 - start4;
        long runtime5 = end5 - start5;

        System.out.println("selectionSort:       " + Arrays.toString(arrCopy1));
        System.out.println("bubbleSort:          " + Arrays.toString(arrCopy3));
        System.out.println("mergeSort:           " + Arrays.toString(arrCopy4));
        System.out.println("heapSort:            " + Arrays.toString(arrCopy5));
        System.out.println("sortUsingArraysSort: " + Arrays.toString(arrCopy2));

        System.out.printf("Tempo de execução do método selectionSort:       %.3f ms%n", runtime1 / 1_000_000.0);
        System.out.printf("Tempo de execução do método bubbleSort:          %.3f ms%n", runtime3 / 1_000_000.0);
        System.out.printf("Tempo de execução do método mergeSort:           %.3f ms%n", runtime4 / 1_000_000.0);
        System.out.printf("Tempo de execução do método heapSort:            %.3f ms%n", runtime5 / 1_000_000.0);
        System.out.printf("Tempo de execução do método sortUsingArraysSort: %.3f ms%n", runtime2 / 1_000_000.0);
    }
}
