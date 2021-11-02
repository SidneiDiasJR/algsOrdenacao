package nota;

public class TestaAlfabetica {
	public static void main(String[] args) {
		String[] nomes = {"David", "Dário", "Gabriel", "Luan", "Oldevan" ,"Sidnei", "Fabiana", "Fernanda", "Layane", "Rubi"};
		String[] nomes2 = {"Razor", "Xiao", "Klee", "Kazuha", "Xiangling", "Bennett", "Raiden", "Sara"};
		int indice = buscar(nomes, "Dário");
		quickSort(nomes, 0, nomes.length);
		imprimirNomes(nomes);
		/*if(indice >= 0)
			System.out.println("Encontrei o nome no indice " + indice);
		else
			System.out.println("Não encontrei o nome na lista.");*/
	}
	
	public static int buscar(String[] nomes, int de, int ate, String busca) {
		if(de > ate)
			return -1;
		int meio = (de+ate)/2;
		String nome = nomes[meio];
		if(busca.compareTo(nome) == 0)
			return meio;
		if(busca.compareTo(nome) < 0)
			return buscar(nomes, de, meio-1, busca);
		return buscar(nomes, meio+1, ate, busca);
	}
	
	public static int buscar(String[] nomes, String busca) {
		return buscar(nomes, 0, nomes.length-1, busca);
	}
	public static void quickSort(String[] nomes, int de, int ate) {
		int quantidadeElementos = ate-de;
		if(quantidadeElementos > 1) {
			int posicaoPivo = particionar(nomes, de, ate);
			quickSort(nomes, de, posicaoPivo);
			quickSort(nomes, posicaoPivo+1, ate);
		}
	}
	public static void mergeSort(String[] nomes, int inicio, int termino) {
		int quantidadeElementos = termino - inicio;
		if(quantidadeElementos > 1) {
			int meio = (inicio+termino)/2;
			mergeSort(nomes, inicio, meio);
			mergeSort(nomes, meio, termino);
			intercalar(nomes, inicio, meio, termino);
		}
	}
	public static int particionar(String[] nomes, int inicio, int termino) {
		int menores = 0;
		String pivo = nomes[termino-1];
		for(int analise = 0; analise < termino-1; analise++) {
			String atual = nomes[analise];
			if(atual.compareTo(pivo) < 0) {
				trocar(nomes, analise, menores);
				menores++;
			}
		}
		trocar(nomes, termino-1, menores);
		return menores;
	}
	
	public static void trocar(String[] nomes, int de, int para) {
		String nome1 = nomes[de];
		String nome2 = nomes[para];
		nomes[de] = nome2;
		nomes[para] = nome1;
	}
	
	public static void intercalar(String[] nomes, int inicio, int meio, int termino) {
		int atual = 0;
		int atual1 = inicio;
		int atual2 = meio;
		int tamanho = termino - inicio;
		String[] temporaria = new String[tamanho];
		while (atual1 < meio && atual2 < termino) {
			String nome1 = nomes[atual1];
			String nome2 = nomes[atual2];
			if(nome1.compareTo(nome2) < 0) {
				temporaria[atual] = nome1;
				atual1++;
			} else {
				temporaria[atual] = nome2;
				atual2++;
			}
			atual++;
		}
		while(atual1 < meio) {
			temporaria[atual] = nomes[atual1];
			atual1++;
			atual++;
		}
		while(atual2 < termino) {
			temporaria[atual] = nomes[atual2];
			atual2++;
			atual++;
		}
		for(int contador = 0; contador < atual; contador++) {
			nomes[contador+inicio] = temporaria[contador];
		}
	}
	public static void imprimirNomes(String[] nomes) {
		System.out.println();
		for(String nome : nomes) {
			System.out.println(nome);
		}
	}
}
