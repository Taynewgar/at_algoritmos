package at_algoritmos.dijkstra;

import java.util.ArrayList;

public class Grafo {
	
	private Vertice[] vertices;
	private int numDeVertices;
	private Aresta[] arestas;
	private int numDeArestas;
	
	
	public Grafo(Aresta[] arestas) {
		
		this.arestas = arestas;
		
		// Aqui instanciamos o array de vertices baseado no numero de arestas
		this.numDeVertices = calcularNumDeVertices(arestas);
		this.vertices = new Vertice[this.numDeVertices];
		
		for (int i = 0; i < this.numDeVertices; i++) {
			this.vertices[i] = new Vertice();
		}
		
		// aqui iremos adicionar todas as arestas aos vertices, sendo que cada uma delas será adicionada a 2 vértices
		// origem e destino
		
		this.numDeArestas = this.arestas.length;
		
		for (int arestaParaAdicionar = 0; arestaParaAdicionar < this.numDeArestas; arestaParaAdicionar++) {
			
			//pega a aresta a adicionar da lista de arestas, recupera qual seu Vertice de origem e adiciona ao vertice
			//daquele índice esta aresta. 
			this.vertices[arestas[arestaParaAdicionar].getIndiceVerticeOrigem()].getArestas().add(arestas[arestaParaAdicionar]);
			//faz a mesma coisa que fez para adicionar o vertice de origem, mas com o vertice de destino.
			this.vertices[arestas[arestaParaAdicionar].getIndiceVerticeDestino()].getArestas().add(arestas[arestaParaAdicionar]);
		}
		
		
		
		
	}

	public Vertice[] getVertices() {
		return vertices;
	}
	public int getNumDeVertices() {
		return numDeVertices;
	}
	public Aresta[] getArestas() {
		return arestas;
	}
	public int getNumDeArestas() {
		return numDeArestas;
	}
	
	private int calcularNumDeVertices(Aresta[] arestas2) {
		
		// o calculo do numero de vertices se baseia nos vértices contidos nas arestas previamente criadas, sendo que sempre será
		// o maior numero entre vertices de origem e destino + 1;
		int numDeVertices = 0;
		
		for (Aresta a : this.arestas) {
			if(a.getIndiceVerticeDestino() > numDeVertices) 
				numDeVertices = a.getIndiceVerticeDestino();
			if(a.getIndiceVerticeOrigem() > numDeVertices)
				numDeVertices = a.getIndiceVerticeOrigem();
		}
		
		numDeVertices++;		
		
		return numDeVertices;
	}
	
	public void calcularMenorDistancia() {		
		// Aqui vemos o primeiro passo do algoritmo que é setar a distancia do primeiro vértice (que é a própria origem)
		// à origem como 0; 
		this.vertices[0].setDistanciaDaOrigem(0);
		int proximoVertice = 0;		
		// segundo passo: visitamos cada vértice
		for (int i = 0; i < this.vertices.length; i++) {
			// terceiro passo: visitamos cada aresta do vertice atual
			ArrayList<Aresta> arestasDoVerticeAtual = this.vertices[proximoVertice].getArestas();
			for (int arestaLigada = 0; arestaLigada < arestasDoVerticeAtual.size(); arestaLigada++) {				
				//recuperamos o vertice vizinho:
				int indiceDoVizinho = arestasDoVerticeAtual.get(arestaLigada).getIndiceDoVizinho(proximoVertice);				
				//Aqui realizamos a primeira verificação: se o vertice não foi visitado. Só faremos alguma ação 
				//caso não tenha sido visitado
				if(!this.vertices[indiceDoVizinho].getVisitado()) {
					// aqui somamos a distancia da origem do vertice atual com o comprimento da aresta atual ao vizinho.
					int tentativa = this.vertices[proximoVertice].getDistanciaDaOrigem() 
							+ arestasDoVerticeAtual.get(arestaLigada).getComprimento();					
					// se o calculo anterior somar um valor menor do que a distancia à origem do vertice vizinho, 
					// atualizamos essa distancia 
					if(tentativa < vertices[indiceDoVizinho].getDistanciaDaOrigem()) {
						vertices[indiceDoVizinho].setDistanciaDaOrigem(tentativa);
					}
				}				
			}			
			// Marcamos o vertice atual como visitado após ter checado seus vizinhos.
			vertices[proximoVertice].setVisitado(true);			
			// aqui calculamos qual vai ser o proximo vertice a ser visitado
			proximoVertice = getVerticeMaisProximo();			
		}		
	}
	
	private int getVerticeMaisProximo() {
		//setamos 2 flags para servir de base
		int indiceVerticeSalvo = 0;
		int distanciaSalva = Integer.MAX_VALUE;		
		//criamos um laço que vai recuperar a distancia da origem dos vertices e compara-la com nossa flag.
		// Se o vertice n estiver visitado e a distancia da origem atual for menor que a da flag, atualizamos as 2 flags. 
		for (int i = 0; i < this.vertices.length; i++) {
			int distanciaAtual = this.vertices[i].getDistanciaDaOrigem();
			if (!this.vertices[i].getVisitado() && distanciaAtual < distanciaSalva) {
				indiceVerticeSalvo = i;
				distanciaSalva = distanciaAtual;
			}
		}	 		
		return indiceVerticeSalvo;
	}
	
	public String imprimir() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Número de Vértices: ")
		.append(this.numDeVertices)
		.append("\n")
		.append("Número de Arestas: ")
		.append(this.numDeArestas)
		.append("\n");
		
		for (int i = 0; i < this.vertices.length; i++) {
			sb.append("\n").append("A menor distância do Vértice 0 ao vértice ")
			.append(i)
			.append(" é: ")
			.append(this.vertices[i].getDistanciaDaOrigem());
		}		
		return sb.toString();		
	}
	
	
	

}
