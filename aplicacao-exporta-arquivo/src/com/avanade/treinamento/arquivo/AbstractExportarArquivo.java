package com.avanade.treinamento.arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Coloco todo a logica exportar arquivo aqui dentro. Dentro da classe abstrata, mas o
 * conteudo que vem na lista eh indiferente
 * 
 * @author edimara.roberta.rosa
 */
public abstract class AbstractExportarArquivo {

	// Cria entidades de tipos. Tipos de string para validacao e exibicao correta de msg
	private enum TipoString {
		PARAMETRO, METODO
	}

	/**
	 * Recupera a extensao para criacao do arquivo
	 * @return uma string com a extensao do arquivo
	 */
	protected abstract String getExtensaoArquivo();

	/**
	 * Conteudo que sera salvo no arquivo.
	// StringBuilder eh uma forma de manipular Strings
	 * @return uma StringBuilder com o conteudo do arquivo
	 */
	protected abstract StringBuilder getConteudo();

	// Valida apenas os parametros para nao precisar especificar toda vez no validar
	// valores
	private void validarStringParametro(String valor, String descricao) {
		validarString(valor, TipoString.PARAMETRO, descricao);
	}

	// Recebe o stringBuilder, o metodo getconteudo nao eh uma String, entao
	// precisamos pegar o stringbuilder e converter para string antes de validar String
	private void validarStringMetodo(StringBuilder valor, String descricao) {
		String strValor = null; 
		if (valor != null) {
			strValor = valor.toString();
		}
		
		validarStringMetodo(strValor, descricao);
	}

	// Valida apenas os metodos String para nao precisar especificar toda vez no validar
	// valores
	private void validarStringMetodo(String valor, String descricao) {
		validarString(valor, TipoString.METODO, descricao);
	}

	/**
	 * Metodo para fazer validacoes, de todos os parametros e metodos, ao inves de
	 * fazer um if para cada um.
	 * 
	 * @param valor     O que recebe no caminho ou nome
	 * @param descricao O que eh (se nome ou caminho)
	 * @param tipo      Descreve o tipo, se parametro ou metodo
	 * @return
	 */
	private void validarString(String valor, TipoString tipo, String descricao) {
		// Na descricaoTipo eh decidido o tipo (se parametro ou metodo)
		String descricaoTipo = TipoString.PARAMETRO.equals(tipo) ? "Parâmetro" : "Método";
		if (valor == null || valor.trim().isEmpty()) {
			throw new RuntimeException("O " + descricaoTipo + "de [" + descricao + "] não pode ser nulo ou vazio");
		}
	}

	/**
	 * Faz validacoes.
	 * 
	 * @private pq nao posso deixar que outras clases chamem. Essa validacao eh
	 *          interna.
	 * @throws valida as informacoes
	 */
	private void validarValores(String caminho, String nome) throws IOException {
		// Chama o metodo validar strings e descreve o que sera valor e descricao
		validarStringParametro(caminho, "caminho");
		validarStringParametro(nome, "nome");
		validarStringMetodo(getExtensaoArquivo(), "getExtensaoArquivo()");
		validarStringMetodo(getConteudo(), "getExtensaoArquivo()");
	}

	/**
	 * Executa onde criara o arquivo e qual sera o nome do arquivo
	 * 
	 * @param caminho Recebe o caminho do arquivo
	 * @param nome    Recebe o nome do arquivo
	 * @error IOException diz ao metodo que a execucacao pode gerar um erro
	 */
	public void executar(String caminho, String nome) throws IOException {
		// Chama o metodo validarValores
		validarValores(caminho, nome);
		//Vai ser um diretorio. Verifica se o diretorio existe. Se nao existe lanca um erro.
		File dir = new File(caminho);
		if (!dir.exists()) {
			throw new FileNotFoundException(" Caminho informado nao encontrado [" + caminho + "]");
		}
		// Verifica se pode escrever no diretorio. Se nao puder, nao criara um arquivo no dir.
		if (!dir.canWrite()) {
			throw new FileNotFoundException(" Sem permissao de escrita no caminho informado[" + caminho + "]");
		}
		
		// Pega o caminho e concatena com o nome
//		String caminhoArquivo = caminho + File.separator + nome + "." + getExtensaoArquivo();
		//Exmplo de concatecao utilizando um StringBuilder
		StringBuilder sbCaminho = new StringBuilder();
		sbCaminho.append(caminho);
		sbCaminho.append(File.separator);
		sbCaminho.append(nome);
		sbCaminho.append(".");
		sbCaminho.append(getExtensaoArquivo());
		
		String caminhoArquivo = sbCaminho.toString();
		
		//Cria o arquivo
		File arquivo = new File(caminhoArquivo);
		
		//Caso o arqivo ja exista, lança uma excecao
		if (arquivo.exists()) {
			throw new IOException("Arquivo informado para geraçao ja existe [" + caminhoArquivo + "]");
		}
		
		//Cria o arquivo Pega o conteudo que esta no getConteudo, trasnforma em string e gera o arquivo.
		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
		writer.write(getConteudo().toString());
		writer.close();
	}

}
