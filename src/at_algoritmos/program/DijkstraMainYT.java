package at_algoritmos.program;

import at_algoritmos.dijkstra.Aresta;
import at_algoritmos.dijkstra.Grafo;

public class DijkstraMainYT {
	
	public static void main(String[] args) {
		
		Aresta[] arestasYT = {
				new Aresta(0, 2, 1),
				new Aresta(0, 3, 4),
				new Aresta(0, 4, 2),
				new Aresta(0, 1, 3),
				new Aresta(1, 3, 2),
				new Aresta(1, 4, 3),
				new Aresta(1, 5, 1),
				new Aresta(2, 4, 1),
				new Aresta(3, 5, 4),
				new Aresta(4, 5, 2),
				new Aresta(4, 6, 7),
				new Aresta(4, 7, 2),
				new Aresta(5, 6, 4),
				new Aresta(6, 7, 5)				
				};
		Aresta[] arestas2= {
				new Aresta(0, 1, 7),
				new Aresta(0, 2, 8),
				new Aresta(0, 3, 1),
				new Aresta(1, 2, 2),
				new Aresta(1, 4, 3),
				new Aresta(2, 3, 4),
				new Aresta(2, 4, 1),
				new Aresta(3, 4, 5)							
				};
		
		
		Grafo grafoYT = new Grafo(arestasYT);
		grafoYT.calcularMenorDistancia();
		
		System.out.println(grafoYT.imprimir());		
		
		System.out.println();
		
		Grafo grafo2 = new Grafo(arestas2);
		grafo2.calcularMenorDistancia();
		
		System.out.println(grafo2.imprimir());	
		
		
		
		}
	
		
	
		
	

}
