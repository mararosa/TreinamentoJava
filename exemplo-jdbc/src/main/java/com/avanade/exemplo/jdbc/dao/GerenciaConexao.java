package com.avanade.exemplo.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avanade.exemplo.jdbc.AplicacaoJdbc;
import com.avanade.exemplo.jdbc.config.GlobalConfig;
import com.avanade.exemplo.jdbc.exception.ConexaoNaoIniciadaException;

/**
 * Faz conexao com o banco de dados
 * 
 * @final Pq eh uma classe que nao pode ser estendida
 * @author edimara.roberta.rosa
 *
 */
public final class GerenciaConexao {

	// Declara o log. Declara sempre uma vez em cada classe private static
	private static final Logger LOG = LoggerFactory.getLogger(GerenciaConexao.class);

	private static Connection connection;

	/**
	 * O contrutor privado impede que seja criada uma instancia da classe Tudo na
	 * classe eh estatico, entao nao eh necessario instanciar (dar new).
	 */
	private GerenciaConexao() {
	}

	// Cria um getter para a conexao. Para quando precisar da conexao. Utilizar esse
	// metodo
	public static Connection getConnection() {
		if (connection == null) {
			throw new ConexaoNaoIniciadaException(
					"Conexão com o banco não foi iniciada. Verifique se o método [openConnection] foi executado.");
		}
		return connection;
	}

	/**
	 * @return
	 * @throws Exception Lança um erro caso haja erro na conexao com o banco de
	 *                   dados dados
	 */
	public static void openConnection() throws Exception {

		// Cria um log
		LOG.info("Iniciando conexão HSQLDB");

		// Faz a carga do driver do banco de dados
		Class.forName(GlobalConfig.getDbDriver());
		// Diz o caminho do arquivo - Cria o banco
		connection = DriverManager.getConnection(GlobalConfig.getDbURL(), GlobalConfig.getDbUsuario(),
				GlobalConfig.getDbSenha());

		// Verifica se fez a Conexao. Acesso ao bancoS
		String status = connection.isClosed() ? "NOK" : "OK";
		LOG.info("Conexão efetuada com sucesso [status = {}]", status);
	}

	public static boolean isActive() {
		if (connection == null) {
			return false;
		}
		
		try {
			return !connection.isClosed();
			
		} catch (SQLException ex) {
			return false;
		}

	}
}
