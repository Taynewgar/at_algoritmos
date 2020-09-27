package at_algoritmos.dijkstraOLD;
import java.util.ArrayList;
import java.util.List;

public class VerticeOLD{

  private String nome;

  private List<ArestaOLD> vizinhos = new ArrayList<>();

  public VerticeOLD(String nome){
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public List<ArestaOLD> getVizinhos(){
    return this.vizinhos;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Vértice ")
    .append(this.nome)
    .append(":")
    .append("\n")
    .append("Vizinhos:")
    .append("\n");
    for (ArestaOLD r : this.vizinhos){
      sb.append(r)
      .append("\n");
    }
    return sb.toString();

  }

}