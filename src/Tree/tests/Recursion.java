package Tree.tests;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Recursion {

    public static void main(String[] args) {
        int inicial = 0;
        int limite = 20;

        IntStream.range(inicial, limite).mapToObj(i -> "Fatorial de " + i + " = " + fatorial(BigInteger.valueOf(i))).forEach(System.out::println);
        IntStream.range(inicial, limite).mapToObj(i -> "Fatorial de " + i + " = " + fatorial((long) i)).forEach(System.out::println);
        IntStream.range(inicial, limite).mapToObj(i -> "Fatorial de " + i + " = " + fatorial((double) i)).forEach(System.out::println);
        IntStream.range(inicial, limite).mapToObj(i -> "Fatorial de " + i + " = " + fatorial(i)).forEach(System.out::println);
    }

    //Interativo
    public static BigInteger fatorial2(int n) {
        BigInteger fat = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            fat = fat.multiply(BigInteger.valueOf(i));
        return fat;
    }

    public static BigInteger fatorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) return BigInteger.ONE;
        else return n.multiply(fatorial(n.subtract(BigInteger.ONE)));
    }

    public static Double fatorial(Double n) {
        if (n == 0) return 1.0;
        else return n * fatorial(n - 1);
    }

    public static Long fatorial(Long n) {
        if (n == 0) return 1L;
        else return n * fatorial(n - 1);
    }

    public static int fatorial(int n) {
        if (n == 0) return 1;
        else return n * fatorial(n - 1);
    }
}
