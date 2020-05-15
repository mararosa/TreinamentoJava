package com.avanade.arquivo.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nao quero que minha class globalconfig seja estedida, por isso ela eh final.
 * 
 * @author edimara.roberta.rosa
 *
 */
public final class GlobalConfig {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalConfig.class);

	// Arquivo de configuracao deve sempre estar na raiz do projeto
	private static final String ARQUIVO_CONFIG = "./config.properties";

	private static final String MODELO_EXIBE_CHAVE = " {} = {} ";

	private static final int TAM_LINHA_LOG = 20;

	// Crio as chaves dos properties, para nao precisar ficar escrevend0
	private static final String CHAVE_CONFIG_DB_DRIVER = "db.driver";
	private static final String CHAVE_CONFIG_DB_URL = "db.url";
	private static final String CHAVE_CONFIG_DB_USUARIO = "db.usuario";
	private static final String CHAVE_CONFIG_DB_SENHA = "db.senha";

	// Nao quero que ngm consigo atribuir valor para as variaveis
	private static String dbDriver;
	private static String dbURL;
	private static String dbUsuario;
	private static String dbSenha;

	/**
	 * O contrutor privado impede que seja criada uma instancia da classe Tudo na
	 * classe eh estatico, entao nao eh necessario instanciar (dar new).
	 */
	private GlobalConfig() {
	}

	// Metodo vai carregar a configuracao. Lanca uma excecao se nao conseguir
	// carregar a configuracao
	public static void carregarConfiguracao() throws Exception {

		// {} paramentrizacao, subustitui o ARQUIVO_CONFIG
		LOG.info("Carregando arquivo de configuração: {}", ARQUIVO_CONFIG);

		// Arquivo que acha o arquivo de configuracao.
		// Contrutor recebe o caminho para o arquivo
		File arquivoConfig = new File(ARQUIVO_CONFIG);
		if (!arquivoConfig.exists()) {
			throw new IOException("Arquivo [" + arquivoConfig.getAbsolutePath() + "] não encontrado");
		}

		LOG.info("Arquivo de configuração: {} encontrado", ARQUIVO_CONFIG);

		// Classe para fazer leitura. Uma instancia com dados de localizacao e
		// propriedades do arquivo
		Properties config = new Properties();
		config.load(new FileReader(arquivoConfig));

		// Uma vez que consegui fazer a leitura do properties eu consigo fazer a leitura
		// do conteudo do arquivo passando as chaves (chaveconfig)
		dbDriver = ParametroPorChave(config, CHAVE_CONFIG_DB_DRIVER);
		dbURL = ParametroPorChave(config, CHAVE_CONFIG_DB_URL);
		dbUsuario = ParametroPorChave(config, CHAVE_CONFIG_DB_USUARIO);
		dbSenha = config.getProperty(CHAVE_CONFIG_DB_SENHA);

		LOG.info("Configurações carregadas com sucesso");
//			LOG.info("=======================");
		LOG.info(StringUtils.leftPad("", TAM_LINHA_LOG, "="));
		LOG.info(MODELO_EXIBE_CHAVE, CHAVE_CONFIG_DB_DRIVER, dbDriver);
		LOG.info(MODELO_EXIBE_CHAVE, CHAVE_CONFIG_DB_URL, dbURL);
		LOG.info(MODELO_EXIBE_CHAVE, CHAVE_CONFIG_DB_USUARIO, dbUsuario);
		LOG.info(MODELO_EXIBE_CHAVE, CHAVE_CONFIG_DB_SENHA, dbSenha);
		// Pega uma string vazia e preenche com = 20 vezes
		LOG.info(StringUtils.leftPad("", TAM_LINHA_LOG, "="));
	}

	// Metodo recebe arquivo de configuracao (para saber de onde pega a
	// configuracao) e chave
	private static String ParametroPorChave(Properties config, String chave) {
		String valor = config.getProperty(chave);
		// Verifica se o valor eh nulo
		if (StringUtils.trimToEmpty(valor).isEmpty()) {
			throw new RuntimeException("Chave de configuração não informada ou vazia [" + chave + "]");
		}
		return valor;
	}

	public static String getDbDriver() {
		return dbDriver;
	}

	public static String getDbURL() {
		return dbURL;
	}

	public static String getDbUsuario() {
		return dbUsuario;
	}

	public static String getDbSenha() {
		return dbSenha;
	}

}
