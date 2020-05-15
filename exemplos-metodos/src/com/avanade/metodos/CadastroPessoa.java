package com.avanade.metodos;

public class CadastroPessoa {
	
	public static void main(String[] args) {
		CadastroPessoa cad = new CadastroPessoa();
		cad.cadastrar("Helena Silva");
		cad.cadastrar("Joaquim Ferreira", false);
		cad.cadastrar("Leandro Thome", 1);
	}

	//Ex, tenho um atribut de classe chamada nome
	private String nome;
	private String cpf;
	private String endereco;
	private String cidade;
	private String estado;
	private boolean ativo;
	
	public void cadastrar (String nome) {
		cadastrar(nome, null, null, null, null, true);
	}
	public void cadastrar (String nome, int ativo) {		
		boolean b = (ativo == 1);	
		cadastrar(nome, b);
	}
	public void cadastrar (String nome, boolean ativo) {
		cadastrar(nome, null, null, null, null, ativo);
	}

	
	//Tenho um parametro do metodo chamado nome
	public void cadastrar (String nome, String cpf, String endereco, String cidade, String estado, boolean ativo) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.ativo = ativo;
	}
	
	public void imprimirConsole() {
		System.out.println(nome);
	}
}
