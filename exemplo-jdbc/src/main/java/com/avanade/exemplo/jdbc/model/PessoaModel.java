package com.avanade.exemplo.jdbc.model;

public class PessoaModel {
	
	//Get e Set sao formas de proteger a classe para que nao acessem os atribut
	private Integer codigo;
	private String nome;
	private String endereco;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
