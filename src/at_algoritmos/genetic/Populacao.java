package at_algoritmos.genetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Populacao {

	private List<Individuo> individuos = new ArrayList<>();
	private static final int tamanhoInicialPopulacao = 20;
	private int geracao = 1;
	private int indiceIndividuo = 1;


	public Populacao() {
		this.gerPopInicial();
	}

	public List<Individuo> getIndividuos() {
		return this.individuos;
	}

	

	public void gerPopInicial() {
		Random generator = new Random();
		for (int i = 0; i < Populacao.tamanhoInicialPopulacao; i++) {
			Individuo individual = new Individuo();
			
			for (int j = 0; j < Individuo.getTamanhoindividuo(); j++) {
				individual.getObjetos()[j] = generator.nextInt(2);
			}
			individual.decodificacao();
			this.individuos.add(individual);
			individual.setIndice(this.indiceIndividuo++);
		}
	}

	public boolean calcFuncaoObjetivo(){
	      for (Individuo i : this.individuos) {
	    	  if (i.getValorTotal() > 175 && i.getPesoTotal() < 80) {
	    		  return true;
	    	  }
	      }
	      return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Geração #").append(this.geracao).append("\n\n");
		for (Individuo i : this.individuos) {
			sb.append("Indivíduo #").append(i.getIndice()).append("\n").append(i);

			
		}
		return sb.toString();
	}

}