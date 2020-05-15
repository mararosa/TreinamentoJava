package com.avanade.exemplo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avanade.exemplo.jdbc.config.GlobalConfig;
import com.avanade.exemplo.jdbc.dao.GerenciaConexao;
import com.avanade.exemplo.jdbc.dao.PessoaDao;
import com.avanade.exemplo.jdbc.exception.BancoDadosException;

public class AplicacaoJdbc {

	// Declara o log. Declara sempre uma vez em cada classe private static
	private static final Logger LOG = LoggerFactory.getLogger(AplicacaoJdbc.class);

	// Constante para status d System.exit
	private static final int COD_ERRO_APP = 10;
	
	public static void main(String[] args) {
		
		LOG.info("Iniciando aplicaçao JDBC...");
		AplicacaoJdbc aplicacao = new AplicacaoJdbc();
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
		
		//TODO Remover metodo na implementacao final
		consultarPessoa();
	}
	
	//TODO deletar so testar db
	private void consultarPessoa() {
		
		//Executar a classe
		PessoaDao pessoaDao = new PessoaDao();
		try {
			pessoaDao.consultaPorCodigo(1);
		} catch (BancoDadosException ex) {
			//pego a msg da excessao e imprimo o codigo da ex
			LOG.error(ex.getMessage(), ex);
		}
	}
}
