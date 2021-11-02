package nota;

public class ArvoreBinaria {
	private Nota raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}
	
	public Nota getRaiz() {
		return this.raiz;
	}
	
	public void setRaiz(Nota raiz) {
		this.raiz = raiz;
	}
	
	public void inserir(Nota arvore, Nota novaNota) {
		if (novaNota.getValor() > arvore.getValor()) {
			if (arvore.getDireita() == null) {
				arvore.setDireita(novaNota);
			} else {
				inserir(arvore.getDireita(), novaNota);
			}
		} else {
			if (arvore.getEsquerda() == null) {
				arvore.setEsquerda(novaNota);
			} else {
				inserir(arvore.getEsquerda(), novaNota);
			}
		}
	}
	public void heapSort(Nota atual) {
		if(atual != null) {
			heapSort(atual.getEsquerda());
			System.out.println(atual);
			heapSort(atual.getDireita());
		}
	}
}
