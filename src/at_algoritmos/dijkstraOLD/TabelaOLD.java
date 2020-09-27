package at_algoritmos.dijkstraOLD;
public class TabelaOLD{
  private VerticeOLD vertice;

  private int menorDistanciaDaOrigem;

  private VerticeOLD verticeAnterior;

  public TabelaOLD(){}

  public TabelaOLD(VerticeOLD vertice,int menorDistanciaDaOrigem,VerticeOLD verticeAnterior){
    this.vertice = vertice;
    this.menorDistanciaDaOrigem = menorDistanciaDaOrigem;
    this.verticeAnterior = verticeAnterior;

  }

  public VerticeOLD getVertice(){
    return this.vertice;
  }

  public void setVertice(VerticeOLD vertice){
    this.vertice = vertice;
  }

  public int getMenorDistanciaDaOrigem(){
    return this.menorDistanciaDaOrigem;
  }

  public void setMenorDistanciaDaOrigem(int menorDistanciaDaOrigem){
    this.menorDistanciaDaOrigem = menorDistanciaDaOrigem;
  }

  public VerticeOLD getVerticeAnterior(){
    return this.verticeAnterior;
  }

  public void setVerticeAnterior(VerticeOLD verticeAnterior){
    this.verticeAnterior = verticeAnterior;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(this.vertice.getNome())
      .append(": Menor Distância da Origem: ")
      .append(String.valueOf(this.menorDistanciaDaOrigem))
      .append(".\n")
      .append("Vértice Anterior: ")
      .append(this.vertice.getNome());
    return sb.toString();
  }




}