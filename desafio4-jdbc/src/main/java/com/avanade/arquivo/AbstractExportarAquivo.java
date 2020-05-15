package com.avanade.arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe abstrata que efetua o controle da cria��o do arquivo 
 * 
 * @author Mara
 */
public abstract class AbstractExportarAquivo {

	/**
	 * Tipos de string para valida��o e exibi��o correta de mensagem
	 */
	private enum TipoString {PARAMETRO, METODO}
	
	/**
	 * Recupera a extens�o para cria��o do arquivo
	 * @return Uma String com a extens�o do arquivo
	 */
	protected abstract String getExtensaoArquivo();
	
	/**
	 * Conteudo que ser� salvo no arquivo
	 * 
	 * @return Um StringBuilder com o conte�do do arquivo
	 */
	protected abstract StringBuilder getConteudo();
	
	private void validarStringParametro(String valor, String descricao) {
		validarString(valor, TipoString.PARAMETRO, descricao);
	}
	
	/** 
	 * Valida se o StringBuilder est� null, diferente de null converte em string 
	 * e implementa validarStringMetodo para fazer o tratamento de erro.
	 * @param valor 
	 * @param descricao  um string com a descricao do metodo
	 */
	private void validarStringMetodo(StringBuilder valor, String descricao) {
		String strValor = null;
		if (valor != null) {
			strValor = valor.toString();
		}

		validarStringMetodo(strValor, descricao);
	}
	
	/**
	 * Valida String para n�o aceitar null
	 * @param valor
	 * @param descricao
	 */
	private void validarStringMetodo(String valor, String descricao) {
		validarString(valor, TipoString.METODO, descricao);
	}
	
	
	private void validarString(String valor, TipoString tipo, String descricao) {
		
		String descricaoTipo = TipoString.PARAMETRO.equals(tipo) ? "Par�metro" : "M�todo";
		if (valor == null || valor.trim().isEmpty()) {
			throw new RuntimeException("O " + descricaoTipo + " de [" + descricao + "] n�o pode ser nulo ou vazio");
		}
	}
	
	/**
	 *  Metodo que valida 
	 * @param caminho
	 * @param nome
	 * @throws IOException
	 */
	private void validarValores(String caminho, String nome) throws IOException {
		
		validarStringParametro(caminho, "caminho");
		validarStringParametro(nome, "nome");
		validarStringMetodo(getExtensaoArquivo(), "getExtensaoArquivo()");
		validarStringMetodo(getConteudo(), "getExtensaoArquivo()");
		
	}
	
	/**
	 *  Executa a exportacao do arquivo caso exista o caminho e permissao de escrita.
	 * @param caminho
	 * @param nome
	 * @throws IOException
	 */
	public void executar(String caminho, String nome) throws IOException {
		validarValores(caminho, nome);
		
		File dir = new File(caminho);
		if (!dir.exists()) {
			throw new FileNotFoundException("Caminho informado n�o encontrado [" + caminho + "]");
		}
		
		if (!dir.canWrite()) {
			throw new FileNotFoundException("Sem permiss�o de escrita no caminho informado [" + caminho + "]");
		}
		
		// Exemplo de concatena��o de string utilizando um StringBuilder
		StringBuilder sbCaminho = new StringBuilder();
		sbCaminho.append(caminho);
		sbCaminho.append(File.separator);
		sbCaminho.append(nome);
		sbCaminho.append(".");
		sbCaminho.append(getExtensaoArquivo());
		
		String caminhoArquivo = sbCaminho.toString();
		File arquivo = new File(caminhoArquivo);
		
		if (arquivo.exists()) {
			throw new IOException("Aquivo informado para gera��o j� existe [" + caminhoArquivo + "]");
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
		writer.write(getConteudo().toString());
		writer.close();
	}
	
	
}
