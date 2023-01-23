package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**Implementa Classe Principal.*/

public class Principal {

  /**Gerencia sistema de votação.*/

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    short opcaoDePessoaCandidata;
  
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
  
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcaoDePessoaCandidata = scan.nextShort();
    
      if (opcaoDePessoaCandidata == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidato = scan.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = scan.nextInt();
      
        gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    } while (opcaoDePessoaCandidata != 2);
    
    short opcaoDeEleitora;
    
    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcaoDeEleitora = scan.nextShort();

      if (opcaoDeEleitora == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitora = scan.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitora = scan.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitora, cpfEleitora);
      }
    } while (opcaoDeEleitora != 2);
    
    short opcaoDeVotacao;
    
    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      opcaoDeVotacao = scan.nextShort();
      
      if (opcaoDeVotacao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfVotacao = scan.next();
        System.out.print("Entre com o número da pessoa candidata:");
        int numeroVotacao = scan.nextInt();
        
        gerenciamentoVotacao.votar(cpfVotacao, numeroVotacao);
      }
      
      if (opcaoDeVotacao == 2) {
        gerenciamentoVotacao.mostrarResultado();
      }
      
      if (opcaoDeVotacao == 3) {
        gerenciamentoVotacao.mostrarResultado();
      }
    } while (opcaoDeVotacao != 3);
    scan.close();
  }
}
