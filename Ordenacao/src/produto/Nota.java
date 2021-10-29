package produto;


public class Nota {
	private String nome;
	private double preco;
	
	Nota(){}
	Nota(String nome, double preco){
		setNome(nome);
		setPreco(preco);
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return this.preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return getNome() + " custa " + getPreco();
	}
	
}

