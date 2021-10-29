package produto;

public class SelectionSort {
	public static void main(String[] args) {
		Produto[] produtos = new Produto[5];
		produtos[0] = new Produto("Lamborghini", 1000000);
		produtos[1] = new Produto("Jipe", 46000);
		produtos[2] = new Produto("Brasília", 16000);
		produtos[3] = new Produto("Smart", 46000);
		produtos[4] = new Produto("Fusca", 17000);
		selectionSort(produtos, produtos.length);
		//insertionSort(produtos, produtos.length);
		imprime(produtos);
	}

	public static int buscaMenor(Produto[] produtos, int inicio, int termino) {
		int maisBarato = inicio;
		for (int atual = inicio; atual < termino; atual++) {
			if (produtos[atual].getPreco() < produtos[maisBarato].getPreco())
				maisBarato = atual;
		}
		return maisBarato;
	}

	public static void selectionSort(Produto[] produtos, int quantidadeElementos) {
		for (int atual = 0; atual < quantidadeElementos - 1; atual++) {
			System.out.println("Estou na casinha " + atual);
			int menor = buscaMenor(produtos, atual, quantidadeElementos);
			troca(produtos, atual, menor);
		}
	}

	public static void insertionSort(Produto [] produtos, int quantidadeElementos) {
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
	
	public static void troca(Produto[] produtos, int primeiro, int segundo) {
		System.out.println("Estou trocando o " + primeiro + " com o " + segundo);
		Produto primeiroProduto = produtos[primeiro];
		Produto segundoProduto = produtos[segundo];
	    System.out.println("Estou trocando " + primeiroProduto.getNome() + " com " + segundoProduto.getNome());
		produtos[primeiro] = segundoProduto;
		produtos[segundo] = primeiroProduto;
	}
	
	public static void imprime(Produto[] produtos) {
		for (Produto produto : produtos) {
			System.out.println(produto.getPreco());
		}
	}

}
