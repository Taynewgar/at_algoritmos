package at_algoritmos.program;

import java.util.LinkedHashMap;

import at_algoritmos.troco.TrocoDinamico;
import at_algoritmos.troco.TrocoGulosoRecursivo;

public class TrocoMain {

	public static void main(String[] args) {
		
//		LinkedHashMap<Double, Integer> granaHash = new LinkedHashMap<Double, Integer>() {
//			private static final long serialVersionUID = 1L;
//
//		{
//			put(0.01, 0);
//			put(0.05, 0);
//			put(0.10, 0);
//			put(0.25, 0);
//			put(0.50, 0);
//			put(1.00, 0);
//			put(2.00, 0);
//			put(5.00, 0);
//			put(10.00, 0);
//			put(20.00, 0);
//			put(50.00, 0);
//			put(100.00, 0);			
//		}};
// 
//		double[] grana = {0.01, 0.05, 0.10, 0.25, 0.50,1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00};
//		
//		Double quantia = 188.91;	
//		
//		TrocoGulosoRecursivo.fazerTrocoHash(granaHash, quantia);
//		System.out.println("Troco recursivo de " + quantia + ": ");
//		
//		
//		Double soma = 0.0;
//		for (Double k : granaHash.keySet()) {
//			if(k < 1.0) {
//				System.out.println(k + ": " + granaHash.get(k) + " Moeda(s)");
//			}else {
//				System.out.println(k + ": " + granaHash.get(k) + " Nota(s)");
//			}
//			soma += Math.round((granaHash.get(k) * k)*100.0)/100.0;
//		}
//		
//		System.out.println();
//		System.out.println("Soma das moedas e notas: " + soma);
		
		int[] moedas = {1,5,6,9};
		
		int valor = 10;
		
		int[][] tabela = TrocoDinamico.fazerTrocoDinamico(moedas, valor);
		
		System.err.println("  0 1 2 3 4 5 6 7 8 9 10");
		for (int i = 0; i < tabela.length; i++) {
			System.err.print(moedas[i] + " ");
			for (int j = 0; j < tabela[i].length; j++) {								
					System.out.print(tabela[i][j] + " ");
				
			}
			System.out.println();
		}	
		
		System.out.println();
		
		System.out.println(tabela[moedas.length-1][valor]);
		
		System.out.println(tabela[tabela.length-1][tabela[tabela.length-1].length-1]);
		
		System.out.println(TrocoDinamico.moedasUsadas(tabela, moedas, valor));

	}

}
