package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * App.
 */
public class App {

  private static int quantidadeAtividades;
  //  private static String[] atividades;
  private static int[] pesos;
  private static int[] notas;

  private static int count = 0;

  /**
   * Metodo main.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a quantidade de atividades para cadastrar:");
    quantidadeAtividades = Integer.parseInt(scanner.nextLine());

    //    atividades = new String[quantidadeAtividades];
    App.pesos = new int[quantidadeAtividades];
    App.notas = new int[quantidadeAtividades];

    cadastraAtividade(scanner);

  }

  private static void cadastraAtividade(Scanner scanner) {
    while (count < quantidadeAtividades) {
      System.out.println("Digite o nome da atividade " + (count + 1) + ":");
      String nomeAtividade = scanner.nextLine();

      System.out.println("Digite o peso da atividade " + (count + 1) + ":");
      int pesoAtividade = Integer.parseInt(scanner.nextLine());

      System.out.println("Digite a nota obtida para " + nomeAtividade + ":");
      int notaAtividade = Integer.parseInt(scanner.nextLine());

      //      atividades[count] = nomeAtividade;
      App.pesos[count] = pesoAtividade;
      App.notas[count] = pesoAtividade * notaAtividade;

      App.count++;
    }
    if (total(pesos) > 100) {
      System.out.println("O peso total das atividades não pode ser maior que 100.");
      System.exit(0);
    }

    if (notaFinal() >= 85) {
      System.out.println("Parabéns! Você alcançou " + notaFinal() + '%'
          + "! E temos o prazer de informar que você obteve aprovação!");
    } else {
      System.out.println(
          "Lamentamos informar que, com base na sua pontuação alcançada neste período, "
              + notaFinal()
              + ", você não atingiu a pontuação mínima necessária para sua aprovação.");
    }
  }

  private static int notaFinal() {
    return App.total(App.notas) / 100;
  }

  /**
   * Peso total int.
   *
   * @param array the array
   * @return the int
   */
  private static int total(int[] array) {
    int sum = 0;
    for (int num : array) {
      sum += num;
    }
    return sum;
  }

}