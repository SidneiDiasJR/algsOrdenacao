package nota;

import java.text.DecimalFormat;
import java.util.Random;

public class TestaSort {
	public static void main(String[] args) {
		int quantidadeElementos = 100000;
		Nota[] notas = new Nota[quantidadeElementos];
		preencherLista(notas, "A", quantidadeElementos);
		imprimirLista(notas);
		//insertionSort(notas, quantidadeElementos);
		//selectionSort(notas, quantidadeElementos);
		mergeSort(notas, 0, quantidadeElementos);
		imprimirLista(notas);
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

	public static void intercalar(Nota[] notas, int inicio, int meio, int termino) {
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
	
	public static void insertionSort(Nota [] notas, int quantidadeElementos) {
		for(int atual = 1; atual < quantidadeElementos; atual++) {
			int analise = atual;
			while(analise > 0 && notas[analise].getValor() < notas[analise-1].getValor() ) {
				trocarElementos(notas, analise, analise-1);
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
	
	public static void trocarElementos(Nota[] notas, int primeira, int segunda) {
		Nota primeiraNota = notas[primeira];
		Nota segundaNota = notas[segunda];
		notas[primeira] = segundaNota;
		notas[segunda] = primeiraNota;
	}

	public static void imprimirLista(Nota[] notas) {
		System.out.println("\n");
		for (Nota nota : notas) {
			System.out.println(nota);
		}
	}

	public static double gerarNota(int limitador) {
		Random rand = new Random();
		DecimalFormat df = new DecimalFormat("#0.0");
		double notaRandom = rand.nextDouble() * limitador;
		notaRandom = Double.parseDouble(df.format(notaRandom));
		return notaRandom;
	}

	public static void preencherLista(Nota[] notas, String nomeGenerico, int quantidadeElementos) {
		for (int i = 0; i < quantidadeElementos; i++) {
			double notaRandom = gerarNota(10);
			notas[i] = new Nota(nomeGenerico + i, notaRandom);
		}
	}
}
