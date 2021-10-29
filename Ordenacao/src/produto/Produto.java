package produto;


public class Produto {
	private String nome;
	private double preco;
	
	Produto(){}
	Produto(String nome, double preco){
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

