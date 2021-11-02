package nota;

import java.text.DecimalFormat;

public class TestaSort {
	public static void main(String[] args) {
		int quantidadeElementos = 100000;
		//Nota[] notas = new Nota[quantidadeElementos];
		//preencherLista(notas, "A", quantidadeElementos);

		
		//selectionSort(notas, quantidadeElementos);
		
		//mergeSort(notas, 0, quantidadeElementos);
		// quickSort(notas, 0, quantidadeElementos);
		//imprimirLista(notas);
		/*int busca = buscar(notas, 1);
		if (busca >= 0)
			System.out.println("Encontrei o valor no indice " + busca);
		else
			System.out.println("Não encontrei o valor");*/
		//imprimirLista(notas);
		ArvoreBinaria notasB = new ArvoreBinaria();
		notasB.setRaiz(new Nota("Raíz", gerarNota(10)));
		for(int i = 0; i < quantidadeElementos; i++) {
			String aluno = "A"+i;
			double valor = gerarNota(10);
			Nota novaNota = new Nota(aluno, valor);
			notasB.inserir(notasB.getRaiz(), novaNota);
		}
		notasB.heapSort(notasB.getRaiz());
	}	
	private static int buscaBinaria(Nota[] notas, int de, int ate, int valor) {
		/*for (int atual = de; atual < ate; atual++) {
			if (notas[atual].getValor() == valor) {
				return atual;
			}
		}
		return -1;*/
		if (de > ate)
			return -1;
		int meio = (de + ate) / 2;
		Nota nota = notas[meio];
		if (valor == nota.getValor())
			return meio;
		if (valor < nota.getValor())
			return buscaBinaria(notas, de, meio - 1, valor);
		return buscaBinaria(notas, meio + 1, ate, valor);
	}

	private static int buscaBinaria(Nota[] notas, int valor) {
		return buscaBinaria(notas, 0, notas.length - 1, valor);
	}
	
	private static void quickSort(Nota[] notas, int de, int ate) {
		int quantidadeElementos = ate - de;
		if (quantidadeElementos > 1) {
			int posicaoPivo = particionar(notas, de, ate);
			quickSort(notas, de, posicaoPivo);
			quickSort(notas, posicaoPivo + 1, ate);
		}
	}

	private static int particionar(Nota[] notas, int inicio, int termino) {
		int menores = 0;
		Nota pivo = notas[termino - 1];
		for (int analisando = 0; analisando < termino - 1; analisando++) {
			Nota atual = notas[analisando];
			if (atual.getValor() <= pivo.getValor()) {
				trocar(notas, analisando, menores);
				menores++;
			}
		}
		trocar(notas, termino - 1, menores);
		return menores;
	}

	private static void trocar(Nota[] notas, int de, int para) {
		Nota nota1 = notas[de];
		Nota nota2 = notas[para];
		notas[de] = nota2;
		notas[para] = nota1;
	}

	private static void mergeSort(Nota[] notas, int inicio, int termino) {
		int quantidade = termino - inicio;
		if (quantidade > 1) {
			int meio = (inicio + termino) / 2;
			mergeSort(notas, inicio, meio);
			mergeSort(notas, meio, termino);
			intercalar(notas, inicio, meio, termino);
		}
	}

	public static void intercalar(Nota[] notas, int inicio, int meio, 
			int termino) {
		int atual = 0;
		int atual1 = inicio;
		int atual2 = meio;
		Nota[] temporario = new Nota[termino - inicio];
		while (atual1 < meio && atual2 < termino) {
			Nota nota1 = notas[atual1];
			Nota nota2 = notas[atual2];
			if (nota1.getValor() < nota2.getValor()) {
				temporario[atual] = nota1;
				atual1++;
			} else {
				temporario[atual] = nota2;
				atual2++;
			}
			atual++;
		}
		while (atual1 < meio) {
			temporario[atual] = notas[atual1];
			atual1++;
			atual++;
		}
		while (atual2 < temporario.length) {
			temporario[atual] = notas[atual2];
			atual2++;
			atual++;
		}
		for (int contador = 0; contador < atual; contador++) {
			notas[contador + inicio] = temporario[contador];
		}
	}

	public static void selectionSort(Nota[] notas, int quantidadeElementos) {
		for (int atual = 0; atual < quantidadeElementos - 1; atual++) {
			int menor = buscarMenor(notas, atual, quantidadeElementos);
			trocarElementos(notas, atual, menor);
		}
	}

	public static void insertionSort(Nota[] notas, int quantidadeElementos) {
		for (int atual = 1; atual < quantidadeElementos; atual++) {
			int analise = atual;
			while (analise > 0 && notas[analise].getValor() < notas[analise - 1].getValor()) {
				trocarElementos(notas, analise, analise - 1);
				analise--;
			}
		}
	}

	public static int buscarMenor(Nota[] notas, int inicio, int termino) {
		int menor = inicio;
		for (int atual = inicio; atual < termino; atual++) {
			if (notas[atual].getValor() < notas[menor].getValor())
				menor = atual;
		}
		return menor;
	}

	public static void trocarElementos(Nota[]notas, int primeira, int segunda){
		Nota primeiraNota = notas[primeira];
		Nota segundaNota = notas[segunda];
		notas[primeira] = segundaNota;
		notas[segunda] = primeiraNota;
	}

	public static void imprimirLista(Nota[] notas) {
		for (Nota nota : notas) {
			System.out.println(nota);
		}
		System.out.println("\n");
	}

	public static double gerarNota(int limitador) {
		DecimalFormat df = new DecimalFormat("#.##");
		double numRandom = Math.random() * limitador;
		numRandom = Double.parseDouble(df.format(numRandom));
		return numRandom;
	}

	public static void preencherLista(Nota[] notas, String nomeGenerico, 
			int quantidadeElementos) {
		for (int i = 0; i < quantidadeElementos; i++) {
			double notaRandom = gerarNota(10);
			notas[i] = new Nota(nomeGenerico + i, notaRandom);
		}
	}
}
