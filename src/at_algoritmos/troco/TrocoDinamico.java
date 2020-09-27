package at_algoritmos.troco;

import java.util.ArrayList;

public class TrocoDinamico {
	
	public static int[][] fazerTrocoDinamico(int[] grana, int quantia) {
		
		int[][] tabela = new int[grana.length][quantia+1];		
		
		for (int i = 0; i < tabela.length; i++) {
			for(int j = 0; j <= quantia; j++) {
				if (i == 0) {
					tabela[i][j] = j/grana[i];
				}
				else if(grana[i] > j) {
					tabela[i][j] = tabela[i-1][j];					
				} else {
					tabela[i][j] = Math.min(tabela[i-1][j], (1 + tabela[i][j - grana[i]]));
				}
			}
		}			
		
		return tabela;
	}
	
	public static ArrayList<Integer> moedasUsadas(int[][] tabela, int[] grana, int quantia) {
		ArrayList<Integer> moedas = new ArrayList<Integer>();
		int count = 1;
		int linha = tabela.length-1;
		int coluna = tabela[tabela.length-1].length-1;
		int moeda = 0;
		
		
		for (int i = linha; linha >= 0; i--) {
			
			if (tabela[i] )
			
		}
	
		
		return moedas;
		
		
	}

}
