package at_algoritmos.dijkstraOLD;

public class ArestaOLD{

  private int distancia;

  private VerticeOLD vizinho;

  public ArestaOLD(int distancia, VerticeOLD vizinho){
    this.distancia = distancia;
    this.vizinho = vizinho;
  }

  public int getDistancia(){
    return this.distancia;
  }

  public void setDistancia(int distancia){
    this.distancia = distancia;
  }

  public VerticeOLD getVizinho(){
    return this.vizinho;
  }

  public void setVizinho(VerticeOLD vizinho){
    this.vizinho = vizinho;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(this.vizinho.getNome())
      .append(": Distância de ")
      .append(String.valueOf(this.distancia));
    return sb.toString();
  }

}
