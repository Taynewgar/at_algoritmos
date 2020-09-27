package at_algoritmos.genetic;

public class Individuo {

	private int[] objetos;
	private static final int tamanhoIndividuo = 5;
	private int aptidao;
	private static final int tamanhoMochila = 80;
	private int valorTotal;
	private int pesoTotal;
	private int indice;
	private int geracao = 1;
	

	private Gene[] genes = { new Gene("Sacola", 10, 15), new Gene("Mala de Viagem", 40, 90),
			new Gene("Cão de Pelúcia", 26, 50), new Gene("Bolsa de Mão", 32, 60), new Gene("Bola de Futebol", 8, 12) };

	public Individuo() {
		this.objetos = new int[tamanhoIndividuo];
	}

	public int[] getObjetos() {
		return objetos;
	}

	public void setObjetos(int[] objetos) {
		this.objetos = objetos;
	}

	public int getAptidao() {
		return aptidao;
	}

	public void setAptidao(int aptidao) {
		this.aptidao = aptidao;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(int pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public Gene[] getGenes() {
		return genes;
	}

	public void setGenes(Gene[] genes) {
		this.genes = genes;
	}

	public static int getTamanhoindividuo() {
		return tamanhoIndividuo;
	}

	public static int getTamanhomochila() {
		return tamanhoMochila;
	}
	
	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public void decodificacao() {
		for (int i = 0; i < this.objetos.length; i++) {

			if (objetos[i] > 0) {
				this.pesoTotal += genes[i].getPeso();
				this.valorTotal += genes[i].getValor();
			}
		}
		
		this.aptidao = this.valorTotal;

	}
	
	public String imprimir() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for(int i : objetos) {
			sb.append(String.valueOf(i)).append(", ");
		}
		sb.append("]");
		
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < objetos.length; i++) {
			if (objetos[i] > 0) {
				sb.append("Nome: ").append(genes[i].getNome())
				.append(" Peso: ")
				.append(String.valueOf(genes[i].getPeso()))
				.append(" Valor: ")
				.append(String.valueOf(genes[i].getValor()))
				.append("\n");
			}
		}

		sb.append("Peso Total: ")
		.append(this.pesoTotal)
		.append("\nValor Total: ")
		.append(this.valorTotal)
		.append("\nAptidão: ")
		.append(this.aptidao)
		.append("\n\n");

		return sb.toString();

	}

}