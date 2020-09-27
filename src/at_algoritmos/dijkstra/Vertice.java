package at_algoritmos.dijkstra;

import java.util.ArrayList;

public class Vertice {
	
	private int distanciaDaOrigem = Integer.MAX_VALUE;
	
	private boolean visitado;
	
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();

	public int getDistanciaDaOrigem() {
		return distanciaDaOrigem;
	}

	public void setDistanciaDaOrigem(int distanciaDaOrigem) {
		this.distanciaDaOrigem = distanciaDaOrigem;
	}

	public boolean getVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}
	
	

}
