package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * Aplicação para calcular notas e pesos de atividades.
 */
public class App {

  /**
   * Método principal da aplicação.
   *
   * @param args Argumentos da linha de comando.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a quantidade de atividades para cadastrar:");
    int quantidadeAtividades = Integer.parseInt(scanner.nextLine());

    int[] pesos = new int[quantidadeAtividades];
    int[] notas = new int[quantidadeAtividades];
    int count = 0;

    while (count < quantidadeAtividades) {
      System.out.println("Digite o nome da atividade " + (count + 1) + ":");
      String nomeAtividade = scanner.nextLine();

      System.out.println("Digite o peso da atividade " + (count + 1) + ":");
      int pesoAtividade = Integer.parseInt(scanner.nextLine());

      System.out.println("Digite a nota obtida para " + nomeAtividade + ":");
      int notaAtividade = Integer.parseInt(scanner.nextLine());

      pesos[count] = pesoAtividade;
      notas[count] = pesoAtividade * notaAtividade;

      count++;
    }

    if (total(pesos) > 100) {
      System.out.println("O peso total das atividades não pode ser maior que 100.");
      System.exit(0);
    }

    int notaFinal = notaFinal(notas);
    if (notaFinal >= 85) {
      System.out.println("Parabéns! Você alcançou " + notaFinal
          + ".0%! E temos o prazer de informar que você obteve aprovação!");
    } else {
      System.out.println(
          "Lamentamos informar que, com base na sua pontuação alcançada neste período, " + notaFinal
              + ".0%, você não atingiu a pontuação mínima necessária para sua aprovação.");
    }
  }

  /**
   * Calcula a nota final com base nas notas obtidas e pesos das atividades.
   *
   * @param notas Notas das atividades.
   * @return A nota final.
   */
  private static int notaFinal(int[] notas) {
    return total(notas) / 100;
  }

  /**
   * Calcula o total de pontos.
   *
   * @param array Um array de inteiros.
   * @return O total de pontos.
   */
  private static int total(int[] array) {
    int sum = 0;
    for (int num : array) {
      sum += num;
    }
    return sum;
  }
}
