package at_algoritmos.program;

import java.util.ArrayList;
import java.util.Arrays;

import at_algoritmos.dijkstraOLD.ArestaOLD;
import at_algoritmos.dijkstraOLD.TabelaOLD;
import at_algoritmos.dijkstraOLD.VerticeOLD;

public class DijkstraMainOld {

	public static void main(String[] args) {
		VerticeOLD v1 = new VerticeOLD("A");
	    VerticeOLD v2 = new VerticeOLD("B");
	    VerticeOLD v3 = new VerticeOLD("C");
	    VerticeOLD v4 = new VerticeOLD("D");
	    VerticeOLD v5 = new VerticeOLD("E");

	    v1.getVizinhos().add(new ArestaOLD(7,v2));
	    v1.getVizinhos().add(new ArestaOLD(8,v3));
	    v1.getVizinhos().add(new ArestaOLD(1,v4));

	    v2.getVizinhos().add(new ArestaOLD(7,v1));
	    v2.getVizinhos().add(new ArestaOLD(2,v3));
	    v2.getVizinhos().add(new ArestaOLD(3,v5));

	    v3.getVizinhos().add(new ArestaOLD(8,v1));
	    v3.getVizinhos().add(new ArestaOLD(2,v2));
	    v3.getVizinhos().add(new ArestaOLD(4,v4));
	    v3.getVizinhos().add(new ArestaOLD(1,v5));

	    v4.getVizinhos().add(new ArestaOLD(1,v1));
	    v4.getVizinhos().add(new ArestaOLD(4,v3));
	    v4.getVizinhos().add(new ArestaOLD(5,v5));
	    
	    v5.getVizinhos().add(new ArestaOLD(3,v2));
	    v5.getVizinhos().add(new ArestaOLD(1,v3));
	    v5.getVizinhos().add(new ArestaOLD(5,v4));

	    ArrayList<VerticeOLD> naoVisitado = new ArrayList<>(Arrays.asList(v1, v2, v3, v4, v5));

	    ArrayList<VerticeOLD> visitado = new ArrayList<>();

	    TabelaOLD t1 = new TabelaOLD(v1, 0, null);
	    TabelaOLD t2 = new TabelaOLD(v2, Integer.MAX_VALUE, null);
	    TabelaOLD t3 = new TabelaOLD(v3, Integer.MAX_VALUE, null);
	    TabelaOLD t4 = new TabelaOLD(v4, Integer.MAX_VALUE, null);
	    TabelaOLD t5 = new TabelaOLD(v5, Integer.MAX_VALUE, null);

	    ArrayList<TabelaOLD> tabelas =new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5));

	    VerticeOLD currentVertice = null;
	     int index = 0;
	    while (naoVisitado.size() > 0){
	      // System.out.println(currentVertice);
	        currentVertice = null;
	        // System.out.println(currentVertice);
	        int menorDistanciaOrigem = Integer.MAX_VALUE;
	        
	        for (TabelaOLD t : tabelas){
	            if(naoVisitado.contains(t.getVertice())){
	              // System.out.println(naoVisitado.contains(t.getVertice()));
	              if(t.getMenorDistanciaDaOrigem() < menorDistanciaOrigem){
	                currentVertice = t.getVertice();
	                
	              }
	            }
	        }        
	        visitado.add(currentVertice);
	        // System.out.println(currentVertice);
	        // System.out.println(naoVisitado.contains(currentVertice));
	        // for (Vertice v : naoVisitado){
	        //   System.out.print(v);
	        // }        
	        
	       

	        int menorDistancia = Integer.MAX_VALUE;
	        ArestaOLD vizinho = null; 
	        for(ArestaOLD v : currentVertice.getVizinhos()){
	          if(naoVisitado.contains(v.getVizinho()) && v.getDistancia() < menorDistancia){
	            menorDistancia = v.getDistancia();
	            vizinho = v;
	          }
	        }
	        System.out.println(vizinho);
	        TabelaOLD tab = new TabelaOLD();
	        for(TabelaOLD t : tabelas){
	          if(t.getVertice() != null && t.getVertice() == vizinho.getVizinho()){
	            tab = t;
	            t.setVerticeAnterior(currentVertice);
	          }
	        }
	        int soma = vizinho.getDistancia();
	        for(TabelaOLD t : tabelas){          
	          if (visitado.contains(t.getVertice())){
	              soma += t.getMenorDistanciaDaOrigem();          
	          }
	        }

	        if(tab.getMenorDistanciaDaOrigem() > soma){
	            tab.setMenorDistanciaDaOrigem(soma);
	        }
	        System.out.println(tab);  
	        index = naoVisitado.indexOf(currentVertice);
	        // System.out.println(index);

	        currentVertice = naoVisitado.remove(index);
	        
	    }

	}

}
