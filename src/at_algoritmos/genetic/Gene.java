package at_algoritmos.genetic;

public class Gene{

  private String nome;
  private int peso;
  private int valor;  

  public Gene(){}
  
  public Gene(String nome, int peso, int valor) {
	super();
	this.nome = nome;
	this.peso = peso;
	this.valor = valor;
}



public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


  public Gene(int peso){
    this.peso = peso;
  }

  public int getPeso(){
    return this.peso;
  }

  public void setPeso(int peso){
    this.peso = peso;
  }

  @Override
  public String toString(){
    return String.valueOf(this.peso);
  }


}