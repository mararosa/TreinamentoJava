package com.avanade.treinamento.arquivo;

import java.io.IOException;

public class Aplicacao {

	// Exporta um arquivo do tipo xml
	public static void main(String[] args) {
		AbstractExportarArquivo exporta = new ExportaXML();
		System.out.println("Iniciando exportação doarquivo...");
		try {
//Executa o arquivo, para isso precisa receber o caminho e nome do arquivo
			exporta.executar("C:\\Development\\TreinamentoJava\\aplicacao-exporta-arquivo\\temp", "receita");
			System.out.println("Exportação concluida com sucesso!");
		} catch (IOException ex) {
			System.err.println("Falha ao executar o arquivo"); //tratamento de erro quando vai para o user
			ex.printStackTrace();
		}
	}
}
