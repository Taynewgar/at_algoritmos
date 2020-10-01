package at_algoritmos.program;

import java.util.List;

import at_algoritmos.genetic.Individuo;
import at_algoritmos.genetic.Populacao;

public class GeneticMain {

	public static void main(String[] args) {

		Populacao pop = new Populacao();
		System.out.println(pop);

		System.out.println();		

		pop.ordenarPorAptidao(pop.getIndividuos());
		System.out.println("Ordenado");
		System.out.println(pop);

		System.out.println();	

		boolean funObj = false;

		while (pop.getGeracao() < 25 && funObj == false) {

			List<Individuo> selecInd = pop.selecao(pop.getIndividuos());			
			System.out.println("Selecionados");
			for (Individuo i : selecInd) {
				System.out.print("Individuo #" + i.getIndice() + " ");
				System.out.print(i.imprimir());
				System.out.println(" Aptidão: " + i.getAptidao());
			}

			System.out.println();			

			List<Individuo> newInd = pop.crossover(selecInd);
			
			System.out.println("CrossOver");
			for (Individuo i : newInd) {
				System.out.print("Individuo #" + i.getIndice() + " ");
				System.out.print(i.imprimir());
				System.out.println(" Aptidão: " + i.getAptidao());
			}

			System.out.println();			

			pop.mutacao(newInd);
			System.out.println();
			if (pop.isMutado()) {
				System.out.println("Houve Mutação");
				for (Individuo i : newInd) {
					System.out.print("Individuo #" + i.getIndice() + " ");
					System.out.print(i.imprimir());
					System.out.println(" Aptidão: " + i.getAptidao());
				}
				System.out.println();				
			}

			pop.novaGeracao(newInd);			

			System.out.println();			

			System.out.println(pop);

			funObj = pop.calcFuncaoObjetivo();			
		}
		if (funObj == false) {
			pop.calcSolucaoAproximada();
			System.out.println("Nenhuma solução Ótima Encontrada");
			System.out.println("A melhor solução encontrada foi:");
			System.out.println("Geração: " + pop.getSolucao().getGeracao());
			System.out.println("Índice: " + pop.getSolucao().getIndice());
			System.out.println(pop.getSolucao());
			
		} else {
			System.out.println("Solução Ótima Encontrada!!!");
			System.out.println("Geração: " + pop.getGeracao());
			System.out.println("Índice: " + pop.getSolucao().getIndice());
			System.out.println(pop.getSolucao());
			
		}

	}

}
