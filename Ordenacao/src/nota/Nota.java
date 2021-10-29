package nota;

public class Nota {
	private String aluno;
	private double valor;
	
	public Nota(String aluno, double valor) {
		this.aluno = aluno;
		this.valor = valor;
	}
	
	public String getAluno() {
		return this.aluno;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	@Override
	public String toString() {
		return getAluno() + " - Nota: " + getValor();
	}
}
