package nota;

import java.text.DecimalFormat;
import java.util.Random;

public class TestaMerge {
	public static void main(String[] args) {
		/*
		 * int tamanhoA = 4; int tamanhoB = 5; Nota[] notasA = new Nota[tamanhoA];
		 * Nota[] notasB = new Nota[tamanhoB]; preencher(notasA, "A",tamanhoA);
		 * selectionSort(notasA, tamanhoA); preencher(notasB, "B", tamanhoB);
		 * selectionSort(notasB, tamanhoB); Nota[] notasC = concatena(notasA, notasB);
		 * imprimir(notasC); for(int i = 0; i < notasC.length; i++) {
		 * System.out.println("new Nota(gen"+"+"+i+", " + notasC[i].getValor()+"),"); }
		 */
		String gen = "Genérico ";
		Nota[] notas = { new Nota(gen + 0, 3.6), new Nota(gen + 1, 4.2), new Nota(gen + 2, 8.2), new Nota(gen + 3, 8.4),
				new Nota(gen + 4, 4.5), new Nota(gen + 5, 4.7), new Nota(gen + 6, 4.8), new Nota(gen + 7, 5.2),
				new Nota(gen + 8, 9.8) };
		mergeSort(notas, 0, 5, notas.length);
		imprimir(notas);
	}

	public static double notaRandom(int limitador) {
		Random rand = new Random();
		DecimalFormat df = new DecimalFormat("#0.0");
		double notaRandom = rand.nextDouble() * limitador;
		notaRandom = Double.parseDouble(df.format(notaRandom));
		return notaRandom;
	}

	public static void preencher(Nota[] notas, String nomeGenerico, int quantidadeElementos) {
		for (int i = 0; i < quantidadeElementos; i++) {
			double notaRandom = notaRandom(10);
			notas[i] = new Nota(nomeGenerico + i, notaRandom);
		}
	}

	public static Nota[] concatena(Nota[] notasA, Nota[] notasB) {
		int tamanho = notasA.length + notasB.length;
		Nota[] concatenacao = new Nota[tamanho];
		int atual = 0;
		int atualMeio = 0;
		while (atual < notasA.length) {
			concatenacao[atual] = notasA[atual];
			atual++;
		}
		while (atualMeio < notasB.length) {
			concatenacao[atual] = notasB[atualMeio];
			atualMeio++;
			atual++;
		}
		return concatenacao;
	}

	public static Nota[] mergeSort(Nota[] notasA, Nota[] notasB) {
		int atual = 0;
		int atualA = 0;
		int atualB = 0;
		int total = notasA.length + notasB.length;
		Nota[] resultado = new Nota[total];

		while (atualA < notasA.length && atualB < notasB.length) {
			Nota notaA = notasA[atualA];
			Nota notaB = notasB[atualB];
			if (notaA.getValor() < notaB.getValor()) {
				resultado[atual] = notaA;
				atualA++;
			} else {
				resultado[atual] = notaB;
				atualB++;
			}
			atual++;
		}
		while (atualA < notasA.length) {
			resultado[atual++] = notasA[atualA++];
		}
		while (atualB < notasB.length) {
			resultado[atual] = notasB[atualB];
			atual++;
			atualB++;
		}
		return resultado;
	}

	public static Nota[] mergeSort(Nota[] notas, int inicial, int meio, int termino) {
		int atual = 0;
		int atualA = inicial;
		int atualB = meio;
		Nota[] temporario = new Nota[termino - inicial];
		while (atualA < meio && atualB < termino) {
			Nota notaA = notas[atualA];
			Nota notaB = notas[atualB];
			if (notaA.getValor() < notaB.getValor()) {
				temporario[atual] = notaA;
				atualA++;
			} else {
				temporario[atual] = notaB;
				atualB++;
			}
			atual++;
		}
		while (atualA < meio) {
			temporario[atual] = notas[atualA];
			atualA++;
			atual++;
		}
		while (atualB < temporario.length) {
			temporario[atual] = notas[atualB];
			atualB++;
			atual++;
		}
		for (int contador = 0; contador < atual; contador++) {
			notas[contador + inicial] = temporario[contador];
		}
		return notas;
	}

	public static int buscaMenor(Nota[] notas, int inicio, int termino) {
		int menor = inicio;
		for (int atual = inicio; atual < termino; atual++) {
			if (notas[atual].getValor() < notas[menor].getValor())
				menor = atual;
		}
		return menor;
	}

	public static void selectionSort(Nota[] produtos, int quantidadeElementos) {
		for (int atual = 0; atual < quantidadeElementos - 1; atual++) {
			// System.out.println("Estou na casinha " + atual);
			int menor = buscaMenor(produtos, atual, quantidadeElementos);
			troca(produtos, atual, menor);
		}
	}

	public static void insertionSort(Nota[] notas, int quantidadeElementos) {
		for (int atual = 1; atual < quantidadeElementos; atual++) {
			// System.out.println("Estou na casinha " + atual);
			int analise = atual;
			while (analise > 0 && notas[analise].getValor() < notas[analise - 1].getValor()) {
				troca(notas, analise, analise - 1);
				analise--;
			}
		}
	}

	public static void troca(Nota[] notas, int primeiro, int segundo) {
		// System.out.println("Estou trocando o " + primeiro + " com o " + segundo);
		Nota primeiraNota = notas[primeiro];
		Nota segundaNota = notas[segundo];
		// System.out.println("Estou trocando " + primeiraNota.getAluno() + " com " +
		// segundaNota.getAluno());
		notas[primeiro] = segundaNota;
		notas[segundo] = primeiraNota;
	}

	public static void imprimir(Nota[] notas) {
		for (Nota nota : notas) {
			System.out.println(nota);
		}
	}
}
