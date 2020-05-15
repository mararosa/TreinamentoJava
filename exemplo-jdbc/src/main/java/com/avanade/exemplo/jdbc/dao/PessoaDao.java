package com.avanade.exemplo.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.avanade.exemplo.jdbc.exception.BancoDadosException;
import com.avanade.exemplo.jdbc.model.PessoaModel;

/**
 * DAO = DATA ACESS OBJECT PessoaDao faz as consultas no banco para retornar o
 * que eu preciso.
 * 
 * @author edimara.roberta.rosa
 *
 */
public class PessoaDao {

	// Fazendo consulta pelo campo codigo da pessoa
	public PessoaModel consultaPorCodigo(Integer codigo) throws BancoDadosException {

		try {
			
			// Capturei minha conexao. Fiz minha conexao, que ja esta alinhada em outra classe
			Connection conn = GerenciaConexao.getConnection();

			// Criar uma consulta no banco de dados com o JDBC no Java. Primeiro tem que
			// criar uma query
			StringBuilder sql = new StringBuilder();
			sql.append("select codigo ");
			sql.append("	 , nome ");
			sql.append("	 , endereco ");
			sql.append("  from Pessoa ");
			sql.append(" where codigo = " + codigo);

			Statement st = conn.createStatement();
			// Resultado da consulta. ResultSet retorna um array com os dados da tabela.
			// Entao preciso dizer o que ele deve retornar
			ResultSet rs = st.executeQuery(sql.toString());

			// Se nao tem first eh pq nao tem resultado
			if (!rs.next()) {
				return null;
			}

			int collum = 1;

			// Collum++ nao preciso me preocupar q numero esta, sei que minha coluna comeca
			// do 1
			Integer rsCodigo = rs.getInt(collum++);
			String rsNome = rs.getString(collum++);
			String rsEndereco = rs.getString(collum++);

			// Tenho que retornar um pessoaModel, entao eu crio uma pessoa
			PessoaModel pessoa = new PessoaModel();
			// OU posso fazer assim direto
			// pessoa.setCodigo(rs.getInt("codigo"));
			pessoa.setCodigo(rsCodigo);
			pessoa.setNome(rsNome);
			pessoa.setEndereco(rsEndereco);

			//Preenchi os dados na tabela e agora retorno pessoa. Retornei o objeto model.
			return pessoa;
			
		} catch (SQLException ex) {
			//Descrevo o meu erro, mas tambem coloco o ex, que mostra qual foi a causa do erro, em que lugar deu problema
			throw new BancoDadosException("Errro ao consultar tabela Pessoa "
					+ "[codigo = " + codigo + "]", ex.getCause()); 
		}
		
	}

}
