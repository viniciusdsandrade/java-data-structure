package Tree.tests;

import java.util.Arrays;

public class Ex1 {

    /**
     * Gera um array de números inteiros aleatórios em um intervalo especificado.
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
     * Gera um array de números inteiros aleatórios em ordem crescente.
     *
     * <p>O array gerado conterá números inteiros aleatórios dentro de um intervalo
     * especificado e será ordenado em ordem crescente, do menor para o maior.</p>
     *
     * @param size O tamanho do array a ser gerado.
     * @param min  O valor mínimo (inclusive) que um número gerado pode ter.
     * @param max  O valor máximo (inclusive) que um número gerado pode ter.
     * @return Um array de números inteiros aleatórios ordenados em ordem crescente.
     */
    public static int[] generateAscendingRandom(int size, int min, int max) {
        int[] arr = generateRandom(size, min, max);
        Arrays.sort(arr);
        return arr;
    }

    /**
     * Gera um array de números inteiros aleatórios em ordem decrescente.
     *
     * <p>O array gerado conterá números inteiros aleatórios dentro de um intervalo
     * especificado e será ordenado em ordem decrescente, do maior para o menor.</p>
     *
     * @param size O tamanho do array a ser gerado.
     * @param min  O valor mínimo (inclusive) que um número gerado pode ter.
     * @param max  O valor máximo (inclusive) que um número gerado pode ter.
     * @return Um array de números inteiros aleatórios ordenados em ordem decrescente.
     */
    public static int[] generateDescendingRandom(int size, int min, int max) {
        int[] arr = generateRandom(size, min, max);
        Arrays.sort(arr);
        // Inverte o array para ordem decrescente
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
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
    public static void dualPivotQuickSort(int[] arr) {
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

    /**
     * Realiza a ordenação de um array de números inteiros utilizando o algoritmo Insertion Sort.
     *
     * <p>O Insertion Sort é um algoritmo simples que constrói o array ordenado um elemento por vez. É eficiente
     * para pequenos conjuntos de dados e tem uma complexidade de tempo de {@code O(n^2)} no pior caso.</p>
     *
     * @param arr O array de números inteiros a ser ordenado.
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Ordena um array de números inteiros utilizando o algoritmo Counting Sort.
     *
     * <p>O Counting Sort é um algoritmo de ordenação que não é baseado em comparação. Ele conta o número de ocorrências
     * de cada elemento e usa essa informação para colocar os elementos na posição correta. É eficiente para valores
     * inteiros dentro de um intervalo limitado.</p>
     *
     * @param arr O array de números inteiros a ser ordenado.
     * @param max O valor máximo presente no array.
     */
    public static void countingSort(int[] arr, int max) {
        int[] count = new int[max + 1];
        int[] output = new int[arr.length];

        // Store the count of each element
        for (int i : arr) {
            count[i]++;
        }

        // Store the cumulative count
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element in the original array in the count array, and place it in the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements into the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    /**
     * Realiza a ordenação de um array de números inteiros utilizando o algoritmo Radix Sort.
     *
     * <p>O Radix Sort é um algoritmo de ordenação que ordena números inteiros por dígitos, começando pelo dígito menos
     * significativo até o mais significativo. Utiliza o Counting Sort como sub-rotina para ordenar os dígitos.</p>
     *
     * @param arr      O array de números inteiros a ser ordenado.
     * @param maxDigit O maior valor de dígito presente no array (para determinar o número de passes).
     */
    public static void radixSort(int[] arr, int maxDigit) {
        for (int exp = 1; maxDigit / exp > 0; exp *= 10) {
            countingSortForRadix(arr, exp);
        }
    }

    private static void countingSortForRadix(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10]; // Base 10 for digits

        // Store count of occurrences in count[]
        for (int j : arr) {
            count[(j / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to the current digit
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    /**
     * Ordena um array de números inteiros utilizando o algoritmo Bucket Sort.
     *
     * <p>O Bucket Sort distribui os elementos do array em vários 'baldes' (ou buckets), e então ordena cada balde
     * individualmente utilizando um algoritmo de ordenação, como o Insertion Sort. É eficiente para arrays com
     * distribuição uniforme de valores.</p>
     *
     * @param arr        O array de números inteiros a ser ordenado.
     * @param bucketSize O tamanho de cada balde.
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) return;

        int minValue = arr[0];
        int maxValue = arr[0];

        // Find the minimum and maximum values in the array
        for (int value : arr) {
            if (value < minValue) minValue = value;
            if (value > maxValue) maxValue = value;
        }

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        // Distribute the elements into buckets
        for (int j : arr) {
            int index = (j - minValue) / bucketSize;
            buckets[index] = append(buckets[index], j);
        }

        // Sort each bucket and place it back into the original array
        int currentIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length > 0) {
                insertionSort(bucket);
                for (int value : bucket) {
                    arr[currentIndex++] = value;
                }
            }
        }
    }

    private static int[] append(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * Realiza a ordenação de um array de números inteiros utilizando o algoritmo Quick Sort.
     *
     * <p>O Quick Sort é um algoritmo de ordenação eficiente, baseado no conceito de divisão e conquista. Ele seleciona
     * um elemento como pivô e particiona o array em duas subpartes, colocando os elementos menores que o pivô à esquerda
     * e os maiores à direita. A ordenação é realizada recursivamente em cada subparte.</p>
     *
     * <p>O Quick Sort tem uma complexidade de tempo média de {@code O(n log n)} e, no pior caso, {@code O(n^2)}, mas
     * é amplamente utilizado por ser rápido e eficiente na prática.</p>
     *
     * @param arr  O array de números inteiros a ser ordenado.
     * @param low  O índice inicial da subparte do array a ser ordenado.
     * @param high O índice final da subparte do array a ser ordenado.
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pi
            quickSort(arr, pi + 1, high); // After pi
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Ordena um array de números inteiros utilizando o algoritmo de ordenação Shell Sort.
     *
     * <p>O Shell Sort é uma melhoria do Insertion Sort que permite a troca de elementos distantes
     * para reduzir o número total de movimentos necessários. Ele funciona dividindo o array em
     * sublist baseadas em um "gap" (distância entre elementos), que é reduzido progressivamente
     * até que seja 1, momento em que o algoritmo efetivamente realiza um Insertion Sort.</p>
     *
     * <p>O algoritmo começa com um gap grande, geralmente metade do tamanho do array, e vai reduzindo
     * esse gap pela metade a cada iteração. Para cada gap, o algoritmo realiza uma espécie de
     * Insertion Sort nos elementos que estão a essa distância um do outro. Essa abordagem permite
     * que os elementos "caminhem" mais rapidamente em direção à sua posição correta, tornando o
     * processo de ordenação mais eficiente.</p>
     *
     * <p>Embora o Shell Sort seja mais eficiente que o Insertion Sort, sua complexidade de tempo
     * pode variar dependendo da sequência de gaps utilizada. Uma sequência comum é dividir o gap
     * por 2 a cada iteração, mas outras sequências podem ser empregadas para otimizar ainda mais o
     * algoritmo.</p>
     *
     * @param arr O array de números inteiros a ser ordenado.
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Começa com um grande gap, então reduz o gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Faz um gapped insertion sort para esse gap tamanho
            for (int i = gap; i < n; i++) {
                // Guarda o elemento atual em uma variável temporária
                int temp = arr[i];

                // Desloca os elementos do array até o local correto para o elemento temporário
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Coloca temp na sua posição correta
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // test_vetor_10_decrescente(100);
        // test_vetor_100_decrescente(100);
        // test_vetor_1000_decrescente(100);
        // test_vetor_1000000_decrescente();
        // test_vetor_1000000000_decrescente();

        // test_vetor_10_aleatorio(100);
        // test_vetor_100_aleatorio(100);
        test_vetor_1000_aleatorio(100);
        // test_vetor_1000000_aleatorio();
        // test_vetor_1000000000_aleatorio();
    }

    public static void test_vetor_10_aleatorio(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateRandom(10, 0, 10);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 10);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 10);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 1);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy10.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy11);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy10);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_10_aleatorio");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_100_aleatorio(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateRandom(100, 0, 100);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 100);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 100);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 10);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy9.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy10);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy11);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_100_aleatorio");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_1000_aleatorio(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateRandom(1_000, 0, 1_000);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 1000);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 1000);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 100);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy10.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy11);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy10);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_1000_aleatorio");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_1000000_aleatorio(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateRandom(1_000_000, 0, 1_000_000);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 1_000_000);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 1_000_000);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 10);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy9.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy10);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy11);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_1000000_aleatorio");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_1000000000_aleatorio(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateRandom(1_000_000_000, 0, 1_000_000_000);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 1_000_000_000);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 1_000_000_000);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 10);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy9.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy10);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy11);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_1000000000_aleatorio");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_10_decrescente(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateDescendingRandom(10, 0, 10);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 10);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 10);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 1);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy9.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy10);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy11);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_10_decrescente");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_100_decrescente(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateDescendingRandom(100, 0, 100);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 100);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 100);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 10);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy9.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy10);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy11);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_100_decrescente");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_1000_decrescente(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateDescendingRandom(1_000, 0, 1_000);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 1_000);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 1_000);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 10);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy9.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy10);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy11);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_1000_decrescente");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_1000000_decrescente(int ciclos) {
        long totalRuntime1 = 0, totalRuntime2 = 0, totalRuntime3 = 0, totalRuntime4 = 0, totalRuntime5 = 0;
        long totalRuntime6 = 0, totalRuntime7 = 0, totalRuntime8 = 0, totalRuntime9 = 0, totalRuntime10 = 0, totalRuntime11 = 0;

        for (int i = 0; i < ciclos; i++) {
            int[] arrOriginal = generateDescendingRandom(1_000_000, 0, 1_000_000);

            int[] arrCopy1 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy2 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy3 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy4 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy5 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy6 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy7 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy8 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy9 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy10 = Arrays.copyOf(arrOriginal, arrOriginal.length);
            int[] arrCopy11 = Arrays.copyOf(arrOriginal, arrOriginal.length);

            long start1 = System.nanoTime();
            selectionSort(arrCopy1);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            bubbleSort(arrCopy2);
            long end2 = System.nanoTime();

            long start3 = System.nanoTime();
            mergeSort(arrCopy3);
            long end3 = System.nanoTime();

            long start4 = System.nanoTime();
            heapSort(arrCopy4);
            long end4 = System.nanoTime();

            long start5 = System.nanoTime();
            insertionSort(arrCopy5);
            long end5 = System.nanoTime();

            long start6 = System.nanoTime();
            countingSort(arrCopy6, 1_000_000);
            long end6 = System.nanoTime();

            long start7 = System.nanoTime();
            radixSort(arrCopy7, 1_000_000);
            long end7 = System.nanoTime();

            long start8 = System.nanoTime();
            bucketSort(arrCopy8, 10);
            long end8 = System.nanoTime();

            long start9 = System.nanoTime();
            quickSort(arrCopy9, 0, arrCopy9.length - 1);
            long end9 = System.nanoTime();

            long start10 = System.nanoTime();
            shellSort(arrCopy10);
            long end10 = System.nanoTime();

            long start11 = System.nanoTime();
            dualPivotQuickSort(arrCopy11);
            long end11 = System.nanoTime();

            totalRuntime1 += (end1 - start1);
            totalRuntime2 += (end2 - start2);
            totalRuntime3 += (end3 - start3);
            totalRuntime4 += (end4 - start4);
            totalRuntime5 += (end5 - start5);
            totalRuntime6 += (end6 - start6);
            totalRuntime7 += (end7 - start7);
            totalRuntime8 += (end8 - start8);
            totalRuntime9 += (end9 - start9);
            totalRuntime10 += (end10 - start10);
            totalRuntime11 += (end11 - start11);
        }

        long avgRuntime1 = totalRuntime1 / ciclos;
        long avgRuntime2 = totalRuntime2 / ciclos;
        long avgRuntime3 = totalRuntime3 / ciclos;
        long avgRuntime4 = totalRuntime4 / ciclos;
        long avgRuntime5 = totalRuntime5 / ciclos;
        long avgRuntime6 = totalRuntime6 / ciclos;
        long avgRuntime7 = totalRuntime7 / ciclos;
        long avgRuntime8 = totalRuntime8 / ciclos;
        long avgRuntime9 = totalRuntime9 / ciclos;
        long avgRuntime10 = totalRuntime10 / ciclos;
        long avgRuntime11 = totalRuntime11 / ciclos;

        System.out.println("test_vetor_1000000_decrescente");
        System.out.printf("Média do tempo de execução do método selectionSort:       %d ns%n", avgRuntime1);
        System.out.printf("Média do tempo de execução do método bubbleSort:          %d ns%n", avgRuntime2);
        System.out.printf("Média do tempo de execução do método mergeSort:           %d ns%n", avgRuntime3);
        System.out.printf("Média do tempo de execução do método heapSort:            %d ns%n", avgRuntime4);
        System.out.printf("Média do tempo de execução do método insertionSort:       %d ns%n", avgRuntime5);
        System.out.printf("Média do tempo de execução do método countingSort:        %d ns%n", avgRuntime6);
        System.out.printf("Média do tempo de execução do método radixSort:           %d ns%n", avgRuntime7);
        System.out.printf("Média do tempo de execução do método bucketSort:          %d ns%n", avgRuntime8);
        System.out.printf("Média do tempo de execução do método quickSort:           %d ns%n", avgRuntime9);
        System.out.printf("Média do tempo de execução do método shellSort:           %d ns%n", avgRuntime10);
        System.out.printf("Média do tempo de execução do método dualPivotQuickSort:  %d ns%n", avgRuntime11);
    }

    public static void test_vetor_1000000000_decrescente() {
    }
}
