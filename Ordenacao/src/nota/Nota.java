package nota;

public class Nota {
	private String aluno;
	private double valor;
	private Nota direita;
	private Nota esquerda;
	
	public Nota(String aluno, double valor) {
		this.aluno = aluno;
		this.valor = valor;
		this.direita = null;
		this.esquerda = null;
	}
	
	public String getAluno() {
		return this.aluno;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public Nota getDireita() {
		return this.direita;
	}
	
	public Nota getEsquerda() {
		return this.esquerda;
	}
	
	public void setDireita(Nota direita) {
		this.direita = direita;
	}
	
	public void setEsquerda(Nota esquerda) {
		this.esquerda = esquerda;
	}
	
	@Override
	public String toString() {
		return getAluno() + " - Nota: " + getValor();
	}
}
