package at_algoritmos.program;

import java.util.List;

import at_algoritmos.genetic.Individuo;
import at_algoritmos.genetic.Populacao;

public class GeneticMain {

	

	public static void main(String[] args) {
		
		Populacao pop = new Populacao();
		
		List<Individuo> ind = pop.getIndividuos();
		
		for (Individuo i : ind) {
			System.out.print("Individuo #" + i.getIndice() + " ");
			System.out.println(i.imprimir());
		}
		System.out.println();
		
		System.out.println(pop);

	}

}
