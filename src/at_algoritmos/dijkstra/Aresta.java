package at_algoritmos.dijkstra;

public class Aresta {
	
	private int indiceVerticeOrigem;
	private int indiceVerticeDestino;
	private int comprimento;
	
	public Aresta(int indiceVerticeOrigem, int indiceVerticeDestino, int comprimento) {
		super();
		this.indiceVerticeOrigem = indiceVerticeOrigem;
		this.indiceVerticeDestino = indiceVerticeDestino;
		this.comprimento = comprimento;
	}

	public int getIndiceVerticeOrigem() {
		return indiceVerticeOrigem;
	}

	public int getIndiceVerticeDestino() {
		return indiceVerticeDestino;
	}

	public int getComprimento() {
		return comprimento;
	}
	
	//Esse método nos informa o vértice vizinho, dado 1 dos vértices dessa aresta.
	public int getIndiceDoVizinho(int indiceVertice) {
		if (this.indiceVerticeOrigem == indiceVertice) {
			return this.indiceVerticeDestino;
		} else {
			return this.indiceVerticeOrigem;
		}
	}
	
	

}
