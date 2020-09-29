package at_algoritmos.program;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import at_algoritmos.troco.TrocoDinamico;
import at_algoritmos.troco.TrocoGulosoRecursivo;

public class TrocoMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Escolha qual rodar:\n1)Recursivo/Guloso\n2)Dinâmico\n3)Sair");

		int escolha = sc.nextInt();
		while (escolha != 3) {
			switch (escolha) {
			case 1:
				rodarGuloso();
				break;
			case 2:
				rodarDinamico();
				break;

			default:
				break;
			}
			System.out.println("Escolha qual rodar:\n1)Recursivo/Guloso\n2)Dinâmico\n3)Sair");
			escolha = sc.nextInt();
		}

	}

	private static void rodarGuloso() {
		LinkedHashMap<Double, Integer> granaHash = new LinkedHashMap<Double, Integer>() {
			private static final long serialVersionUID = 1L;

			{
				put(0.01, 0);
				put(0.05, 0);
				put(0.10, 0);
				put(0.25, 0);
				put(0.50, 0);
				put(1.00, 0);
				put(2.00, 0);
				put(5.00, 0);
				put(10.00, 0);
				put(20.00, 0);
				put(50.00, 0);
				put(100.00, 0);
			}
		};

		double[] grana = { 0.01, 0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00 };

		Double quantia = 188.91;

		TrocoGulosoRecursivo.fazerTrocoHash(granaHash, quantia);
		System.out.println("Troco recursivo de " + quantia + ": ");

		Double soma = 0.0;
		for (Double k : granaHash.keySet()) {
			if (k < 1.0) {
				System.out.println(k + ": " + granaHash.get(k) + " Moeda(s)");
			} else {
				System.out.println(k + ": " + granaHash.get(k) + " Nota(s)");
			}
			soma += Math.round((granaHash.get(k) * k) * 100.0) / 100.0;
		}

		System.out.println();
		System.out.println("Soma das moedas e notas: " + soma);

	}

	private static void rodarDinamico() {
		int[] moedas = { 1, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000, 10000 };
		int[] moedasAT = { 1, 5, 10, 25, 21 };

		int valor = 18891;
		int valorAT = 63;

		int[][] tabela = TrocoDinamico.fazerTrocoDinamico(moedas, valor);
		int[][] tabelaAT = TrocoDinamico.fazerTrocoDinamico(moedasAT, valorAT);

		System.out.println();

		System.out.print("Número mínimo de moedas: ");
		System.out.println(TrocoDinamico.numeroDeMoedas(tabela));

		ArrayList<Integer> moedasUsadas = TrocoDinamico.moedasUsadas(tabela, moedas, valor);

		System.out.println(TrocoDinamico.imprimirMoedas(moedas, moedasUsadas));
		
		System.out.println();
		
		System.out.println(imprimirTabela(valorAT, tabelaAT, moedasAT));

		System.out.print("Número mínimo de moedasdo AT: ");
		System.out.println(TrocoDinamico.numeroDeMoedas(tabelaAT));

		ArrayList<Integer> moedasUsadasAT = TrocoDinamico.moedasUsadas(tabelaAT, moedasAT, valorAT);

		System.out.println(TrocoDinamico.imprimirMoedas(moedasAT, moedasUsadasAT));
	}

	private static String imprimirTabela(int valor, int[][] tabela, int[] moedas) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int i = 0; i < valor + 1; i++) {
			sb.append(i + " ");
		}
		sb.append("\n");
		for (int i = 0; i < tabela.length; i++) {
			sb.append(moedas[i]).append(" ");
			for (int j = 0; j < tabela[i].length; j++) {
				sb.append(tabela[i][j]).append(" ");

			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
