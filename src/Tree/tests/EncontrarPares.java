package Tree.tests;

import java.util.HashMap;
import java.util.Map;

public class EncontrarPares {

    public static void encontrarPares(int[][] matriz, int soma) {
        Map<Integer, int[]> map = new HashMap<>(); // Mapa para armazenar elementos já verificados

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int valorAtual = matriz[i][j];
                int complemento = soma - valorAtual;

                // Verifica se o complemento já está no mapa
                if (map.containsKey(complemento)) {
                    int[] posComplemento = map.get(complemento);
                    System.out.printf("Par encontrado: %d + %d = %d (Posições: [%d][%d] e [%d][%d])\n",
                            valorAtual, complemento, soma, i, j, posComplemento[0], posComplemento[1]);
                }

                // Adiciona o valor atual e sua posição no mapa
                map.put(valorAtual, new int[]{i, j});
            }
        }
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int soma = 10;
        encontrarPares(matriz, soma);
    }
}
