package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**Classe que Gerencia Votação.*/

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;
  
  private boolean verificaCpfEleitora(String cpf) {
    for (PessoaEleitora eleitor : pessoasEleitoras) {
      String cpfEleitor = eleitor.getCpf();
      if (cpfEleitor.equals(cpf)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean verificaNumeroCandidato(int numero) {
    for (PessoaCandidata candidato : pessoasCandidatas) {
      int numeroCandidato = candidato.getNumero();
      if (numeroCandidato == numero) {
        return true;
      }
    }
    return false;
  }
  
  /** Método para Cadastrar Pessoas Candidatas. */
  
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (!pessoasCandidatas.isEmpty()) {
      boolean  numeroVerificado = verificaNumeroCandidato(numero);
      if (numeroVerificado == true) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }
    
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }
  
  /** Método para Cadastrar Pessoa Eleitora.*/
  
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean verificarCpfEleitor = verificaCpfEleitora(cpf);
    if (verificarCpfEleitor) {
      System.out.println("Pessoa eleitora já cadastrada!");
    }
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }
  
  /**Método de Votação.*/
  
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }
    
    for (PessoaCandidata candidato : pessoasCandidatas) {
      int numeroCandidato = candidato.getNumero();
      if (numeroCandidato == numeroPessoaCandidata) {
        candidato.receberVoto();
        totalVotos += 1;
        cpfComputado.add(cpfPessoaEleitora);
        return;
      }
    }
  }
  
  /**Método para Mostrar Resultado.*/
  
  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }
    for (int i = 0; i < pessoasCandidatas.size(); i += 1) {
      String nome = pessoasCandidatas.get(i).getNome();
      int votos = pessoasCandidatas.get(i).getVotos();
      System.out.print("Nome" + nome + "-" + votos + "votos" + "("
          + this.calcularPorcentagemVotos(i) + "%" + ")");

    }
  }
  
  private double calcularPorcentagemVotos(int indicePessoaCandidata) {
    PessoaCandidata candidato = pessoasCandidatas.get(indicePessoaCandidata);
    int votosRecebidos = candidato.getVotos();
    double porcentagemDeVotos = (double) votosRecebidos / (double) this.totalVotos;
    double porcentagemTotal = this.arredondarVotos(porcentagemDeVotos);
    return porcentagemTotal;
  }
  
  private double arredondarVotos(double porcentagemDeVotos) {
    return Math.round(porcentagemDeVotos * 100.0);
  }
}
