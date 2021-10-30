package nota;

public class Nota {
	private String aluno;
	private int valor;
	
	public Nota(String aluno, int valor) {
		this.aluno = aluno;
		this.valor = valor;
	}
	
	public String getAluno() {
		return this.aluno;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	@Override
	public String toString() {
		return getAluno() + " - Nota: " + getValor();
	}
}
