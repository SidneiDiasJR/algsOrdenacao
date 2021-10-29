package produto;

public class TestaSelectionInsert {
	public static void main(String[] args) {
		Nota[] produtos = new Nota[5];
		produtos[0] = new Nota("Lamborghini", 1000000);
		produtos[1] = new Nota("Jipe", 46000);
		produtos[2] = new Nota("Brasília", 16000);
		produtos[3] = new Nota("Smart", 46000);
		produtos[4] = new Nota("Fusca", 17000);
		selectionSort(produtos, produtos.length);
		//insertionSort(produtos, produtos.length);
		imprime(produtos);
	}

	public static int buscaMenor(Nota[] produtos, int inicio, int termino) {
		int maisBarato = inicio;
		for (int atual = inicio; atual < termino; atual++) {
			if (produtos[atual].getPreco() < produtos[maisBarato].getPreco())
				maisBarato = atual;
		}
		return maisBarato;
	}

	public static void selectionSort(Nota[] produtos, int quantidadeElementos) {
		for (int atual = 0; atual < quantidadeElementos - 1; atual++) {
			System.out.println("Estou na casinha " + atual);
			int menor = buscaMenor(produtos, atual, quantidadeElementos);
			troca(produtos, atual, menor);
		}
	}

	public static void insertionSort(Nota [] produtos, int quantidadeElementos) {
		for(int atual = 1; atual < quantidadeElementos; atual++) {
			System.out.println("Estou na casinha " + atual);
			int analise = atual;
			while(analise > 0 && produtos[analise].getPreco() < produtos[analise-1].getPreco() ) {
				troca(produtos, analise, analise-1);
				analise--;
			}
			imprime(produtos);
		}
	}
	
	public static void troca(Nota[] produtos, int primeiro, int segundo) {
		System.out.println("Estou trocando o " + primeiro + " com o " + segundo);
		Nota primeiroProduto = produtos[primeiro];
		Nota segundoProduto = produtos[segundo];
	    System.out.println("Estou trocando " + primeiroProduto.getNome() + " com " + segundoProduto.getNome());
		produtos[primeiro] = segundoProduto;
		produtos[segundo] = primeiroProduto;
	}
	
	public static void imprime(Nota[] produtos) {
		for (Nota produto : produtos) {
			System.out.println(produto.getPreco());
		}
	}

}
