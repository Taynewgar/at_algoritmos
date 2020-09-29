package at_algoritmos.troco;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TrocoDinamico {

	public static int[][] fazerTrocoDinamico(int[] grana, int quantia) {

		int[][] tabela = new int[grana.length][quantia + 1];

		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j <= quantia; j++) {
				if (i == 0) {
					tabela[i][j] = j / grana[i];
				} else if (grana[i] > j) {
					tabela[i][j] = tabela[i - 1][j];
				} else {
					tabela[i][j] = Math.min(tabela[i - 1][j], (1 + tabela[i][j - grana[i]]));
				}
			}
		}

		return tabela;
	}

	public static int numeroDeMoedas(int[][] tabela) {
		return tabela[tabela.length - 1][tabela[tabela.length - 1].length - 1];
	}

	public static ArrayList<Integer> moedasUsadas(int[][] tabela, int[] grana, int quantia) {
		ArrayList<Integer> moedas = new ArrayList<Integer>();
		int linha = tabela.length - 1;
		int coluna = tabela[tabela.length - 1].length - 1;

		for (int i = linha - 1; i >= 0; i--) {
			while (tabela[i][coluna] != tabela[i + 1][coluna]) {
				moedas.add(grana[i + 1]);
				coluna = coluna - grana[i + 1];
			}
		}

		while (coluna < grana[1] && coluna > 0) {
			moedas.add(grana[0]);
			coluna -= grana[0];
		}
		return moedas;

	}

	public static String imprimirMoedas(int[] grana, ArrayList<Integer> moedasUsadas) {
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<Integer, Integer> moedas = new LinkedHashMap<>();
		for (int m : grana) {
			moedas.put(m, 0);
		}
		for (Integer m : moedasUsadas) {
			for (Integer k : moedas.keySet()) {
				if (k.equals(m)) {					
					moedas.put(k, moedas.get(k) + 1);
				}
			}
		}
		for (Integer k : moedas.keySet()) {			
			sb.append(String.format("%.2f", (double) k/100.0 )).append(": ").append(String.valueOf(moedas.get(k))).append("\n");
		}
		return sb.toString();
	}

}
