package at_algoritmos.genetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import at_algoritmos.quicksort.QuickSort;

public class Populacao {

	private List<Individuo> individuos = new ArrayList<>();
	private static final int tamanhoInicialPopulacao = 20;
	private int geracao = 1;
	private int indiceIndividuo = 1;
	private double taxaRepro = 0.5;
	private double taxaMutacao = 0.5;
	private double probabMutacao = 0.05;
	private Random generator = new Random();
	private Individuo solucao = null;
	private boolean mutado = false;

	public Populacao() {
		this.gerPopInicial();
	}

	public List<Individuo> getIndividuos() {
		return this.individuos;
	}

	public void setIndividuos(List<Individuo> individuos) {
		this.individuos = individuos;
	}

	public int getGeracao() {
		return this.geracao;
	}

	public Individuo getSolucao() {
		return solucao;
	}

	public boolean isMutado() {
		return mutado;
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
			individual.setGeracao(this.geracao);
		}
	}

	public boolean calcFuncaoObjetivo() {
		for (Individuo i : this.individuos) {
			if (i.getValorTotal() > 160 && i.getPesoTotal() <= 80) {				
				this.solucao = i;
				return true;
			}
		}
		return false;
	}
	
	public void calcSolucaoAproximada(){
		for (Individuo i : this.getIndividuos()) {
			if (i.getPesoTotal() <= 80) {
				this.solucao = i;
				break;
			}
		}
	}

	public void ordenarPorAptidao(List<Individuo> individuos) {
		int[] aptidoes = new int[individuos.size()];
		int count = 0;
		for (Individuo i : individuos) {
			aptidoes[count] = i.getAptidao();
			count++;
		}
		QuickSort.quickSort(aptidoes);
		List<Individuo> orderedIndividuos = new ArrayList<>();
		for (int j = aptidoes.length - 1; j >= 0; j--) {
			for (Individuo i : individuos) {
				if (aptidoes[j] == i.getAptidao() && !orderedIndividuos.contains(i)) {
					orderedIndividuos.add(i);
				}
			}
		}
		this.setIndividuos(orderedIndividuos);
	}

	public List<Individuo> selecao(List<Individuo> individuos) {		
		Set<Integer> aleatorios = new LinkedHashSet<Integer>();		   
	    while(aleatorios.size() < (individuos.size()*this.taxaRepro)){
	      aleatorios.add(this.generator.nextInt(individuos.size()));
	    }		
		List<Individuo> selecionados = new ArrayList<Individuo>();		
		Iterator<Integer> it = aleatorios.iterator();		
		while(it.hasNext()) {
			selecionados.add(this.individuos.get(it.next()));
		}
		return selecionados;
	}

	public List<Individuo> crossover(List<Individuo> selecInd) {
		List<Individuo> newInd = new ArrayList<>();

		for (int i = 0; i < selecInd.size(); i += 2) {

			Individuo n1 = new Individuo();
			n1.setIndice(this.indiceIndividuo++);
			n1.setGeracao(this.geracao);
			Individuo n2 = new Individuo();
			n2.setIndice(this.indiceIndividuo++);
			n2.setGeracao(this.geracao);
			int selecGenes = this.generator.nextInt(4) + 1;
			for (int j = 0; j < selecInd.get(i).getObjetos().length; j++) {
				if (j < selecGenes) {
					n1.getObjetos()[j] = selecInd.get(i + 1).getObjetos()[j];
					n2.getObjetos()[j] = selecInd.get(i).getObjetos()[j];
				} else {
					n1.getObjetos()[j] = selecInd.get(i).getObjetos()[j];
					n2.getObjetos()[j] = selecInd.get(i + 1).getObjetos()[j];
				}
			}
			newInd.addAll(Arrays.asList(n1, n2));
		}
		return newInd;
	}

	public void mutacao(List<Individuo> newInd) {
		this.mutado = false;
		int num = this.generator.nextInt(1001);
		if (num < (int) (1000 * probabMutacao)) {
			this.mutado = true;
			List<Individuo> mutados = newInd.subList(0, (int) (newInd.size() * taxaMutacao));
			int selecGenes = this.generator.nextInt(5) + 1;			
			for (Individuo ind : mutados) {
				for (int i = 0; i < selecGenes; i++) {
					if (ind.getObjetos()[i] == 0) {
						ind.getObjetos()[i] = 1;
					} else {
						ind.getObjetos()[i] = 0;
					}
					;
				}
			}

		}
	}

	public void novaGeracao(List<Individuo> newInd){
    Set<Integer> aleatorios = new HashSet<Integer>();
   
    while(aleatorios.size() < 10){
      aleatorios.add(this.generator.nextInt(30));
      
    }
    this.geracao++;
    for (Individuo i : newInd){
      i.decodificacao();
    }
    this.getIndividuos().addAll(newInd);
    this.ordenarPorAptidao(this.getIndividuos());

    ArrayList<Individuo> removeList = new ArrayList<Individuo>();
    for (Individuo ind : this.getIndividuos()){
    	if (aleatorios.contains(this.getIndividuos().indexOf(ind))) {
    		removeList.add(ind);
    	}      
    }
    this.getIndividuos().removeAll(removeList);    

  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Geração #").append(this.geracao).append("\n\n");
		for (Individuo i : this.individuos) {
			sb.append("Individuo #").append(String.valueOf(i.getIndice())).append(" ");
			sb.append(i.imprimir());
			sb.append(" Aptidão: ").append(String.valueOf(i.getAptidao())).append("\n");
		}
		return sb.toString();
	}

	public String imprimirDetalhes() {
		StringBuilder sb = new StringBuilder();

		sb.append("Geração #").append(this.geracao).append("\n\n");
		for (Individuo i : this.individuos) {
			sb.append("Indivíduo #").append(i.getIndice()).append("\n").append(i);
		}
		return sb.toString();
	}
}