package HashMap;

public class HashMapLinkedListUnorderedTest {

    public static void main(String[] args) {
        testPutAndGet();
        testPutUpdatesValue();
        testRemove();
        testSizeAndIsEmpty();
        testRedimensionamento();
        testClear();
        testContainsKey();
        testClone();
    }

    public static void testPutAndGet() {
        HashMapLinkedListUnordered<String, String> map = new HashMapLinkedListUnordered<>();
        map.put("chave1", "valor1");
        map.put("chave2", "valor2");

        if (!"valor1".equals(map.get("chave1")))
            System.err.println("testPutAndGet failed: expected 'valor1', got " + map.get("chave1"));
        if (!"valor2".equals(map.get("chave2")))
            System.err.println("testPutAndGet failed: expected 'valor2', got " + map.get("chave2"));


        if (map.get("chaveInexistente") != null) System.err.println("testPutAndGet failed: expected null, got " + map.get("chaveInexistente"));
        else System.out.println("testPutAndGet passed");
    }

    public static void testPutUpdatesValue() {
        HashMapLinkedListUnordered<String, String> map = new HashMapLinkedListUnordered<>();
        map.put("chave1", "valor1");
        map.put("chave1", "valorAtualizado");

        if (!"valorAtualizado".equals(map.get("chave1"))) System.err.println("testPutUpdatesValue failed: expected 'valorAtualizado', got " + map.get("chave1"));
        else System.out.println("testPutUpdatesValue passed");
    }

    public static void testRemove() {
        HashMapLinkedListUnordered<String, String> map = new HashMapLinkedListUnordered<>();
        map.put("chave1", "valor1");
        map.put("chave2", "valor2");

        String removedValue = map.remove("chave1");
        if (!"valor1".equals(removedValue)) System.err.println("testRemove failed: expected 'valor1', got " + removedValue);

        if (map.get("chave1") != null) System.err.println("testRemove failed: expected null, got " + map.get("chave1"));
        else System.out.println("testRemove passed");
    }

    public static void testSizeAndIsEmpty() {
        HashMapLinkedListUnordered<String, String> map = new HashMapLinkedListUnordered<>();
        if (!map.isEmpty()) System.err.println("testSizeAndIsEmpty failed: expected empty map");
        if (!map.isEmpty()) System.err.println("testSizeAndIsEmpty failed: expected size 0, got " + map.size());


        map.put("chave1", "valor1");
        map.put("chave2", "valor2");

        if (map.isEmpty()) System.err.println("testSizeAndIsEmpty failed: expected non-empty map");

        if (map.size() != 2) System.err.println("testSizeAndIsEmpty failed: expected size 2, got " + map.size());
        else System.out.println("testSizeAndIsEmpty passed");
    }

    public static void testRedimensionamento() {
        HashMapLinkedListUnordered<Integer, String> map = new HashMapLinkedListUnordered<>(2, 0.2f, 0.75f);

        map.put(1, "um");
        map.put(2, "dois");
        map.put(3, "três"); // Deve acionar o redimensionamento

        if (!"um".equals(map.get(1)))
            System.err.println("testRedimensionamento failed: expected 'um', got " + map.get(1));
        if (!"dois".equals(map.get(2)))
            System.err.println("testRedimensionamento failed: expected 'dois', got " + map.get(2));
        if (!"três".equals(map.get(3)))
            System.err.println("testRedimensionamento failed: expected 'três', got " + map.get(3));
        else System.out.println("testRedimensionamento passed");

    }

    public static void testClear() {
        HashMapLinkedListUnordered<String, String> map = new HashMapLinkedListUnordered<>();
        map.put("chave1", "valor1");
        map.put("chave2", "valor2");

        map.clear();
        if (!map.isEmpty()) System.err.println("testClear failed: expected empty map after clear");
        if (!map.isEmpty()) System.err.println("testClear failed: expected size 0 after clear, got " + map.size());
        if (map.get("chave1") != null) System.err.println("testClear failed: expected null after clear, got " + map.get("chave1"));
        else System.out.println("testClear passed");
    }

    public static void testClone() {
        HashMapLinkedListUnordered<String, String> map = new HashMapLinkedListUnordered<>();
        map.put("chave1", "valor1");
        map.put("chave2", "valor2");

        @SuppressWarnings("unchecked")
        HashMapLinkedListUnordered<String, String> clonedMap = (HashMapLinkedListUnordered<String, String>) map.clone();
        if (!"valor1".equals(clonedMap.get("chave1")))
            System.err.println("testClone failed: expected 'valor1', got " + clonedMap.get("chave1"));
        if (!"valor2".equals(clonedMap.get("chave2")))
            System.err.println("testClone failed: expected 'valor2', got " + clonedMap.get("chave2"));
        clonedMap.put("chave1", "novoValor");
        if (!"valor1".equals(map.get("chave1")))
            System.err.println("testClone failed: original map changed unexpectedly");

        if (!"novoValor".equals(clonedMap.get("chave1"))) System.err.println("testClone failed: expected 'novoValor', got " + clonedMap.get("chave1"));
        else System.out.println("testClone passed");
    }

    public static void testContainsKey() {
        HashMapLinkedListUnordered<String, String> map = new HashMapLinkedListUnordered<>();
        map.put("chave1", "valor1");

        if (!map.containsKey("chave1")) System.out.println("testContainsKey failed: expected true, got false");


        System.out.println(map.containsKey("chaveInexistente")
                ? "testContainsKey failed: expected false, got true"
                : "testContainsKey passed");
    }
}

