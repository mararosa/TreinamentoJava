package com.avanade.arquivo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avanade.arquivo.config.GlobalConfig;
import com.avanade.arquivo.dao.GerenciaConexao;


public class Aplicacao {

	// Declara o log. Declara sempre uma vez em cada classe private static
	private static final Logger LOG = LoggerFactory.getLogger(Aplicacao.class);
	// Constante para status d System.exit
	private static final int COD_ERRO_APP = 10;

	public static void main(String[] args) {

		LOG.info("Iniciando aplicaçao JDBC...");
		Aplicacao aplicacao = new Aplicacao();
		aplicacao.iniciar();
	}

	private void iniciar() {
		// Carregar as configuracoes
		try {
			GlobalConfig.carregarConfiguracao();
		} catch (Exception ex) {
			LOG.error("Falha ao carregar configurações", ex);
			System.exit(COD_ERRO_APP);
		}

		// Conectando com o banco de dados
		try {
			GerenciaConexao.openConnection();
		} catch (Exception ex) {
			LOG.error("Falha ao conectar com o banco de dados", ex);
			System.exit(COD_ERRO_APP);
		}
		
		ExportarListaPessoas();
	}

	/**
	 * chama o executar e roda a aplicacao
	 */
	private void ExportarListaPessoas() {
		AbstractExportarAquivo exporta = new ExportaDadosFormatados();
		System.out.println("Iniciando exportação de arquivo...");
		try {
			exporta.executar("C:\\temp", "exportacao");
			System.out.println("Exportação concluída com sucesso!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
