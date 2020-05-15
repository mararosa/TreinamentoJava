package com.avanade.arquivo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.avanade.arquivo.componentes.StringBuilderLines;
import com.avanade.arquivo.dao.PessoaDao;
import com.avanade.arquivo.exception.BancoDadosException;
import com.avanade.arquivo.model.PessoaModel;


public class ExportaDadosFormatados extends AbstractExportarAquivo {

	/**
	 *  Define a extensao do arquivo, neste caso eh txt
	 */
	@Override
	protected String getExtensaoArquivo() {
	
		return "txt";
	}

	/**
	 *  Cria e formata os dados.
	 * @throws BancoDadosException 
	 */
	@Override
	protected StringBuilder getConteudo() {
		StringBuilderLines sbl = new StringBuilderLines();
		PessoaDao pessoaDao = new PessoaDao();
		
		List<PessoaModel> lst;
		try {
			lst = pessoaDao.listarPessoas();
			for (PessoaModel pessoa : lst) {
			    int id = pessoa.getCodigo();
			    String padCodigo = StringUtils.leftPad(String.valueOf(id), 5, '0');
			    
			    String nome = pessoa.getNome();
			    String padNome = StringUtils.rightPad(nome, 30, ' ');
			    
			    String endereco = pessoa.getEndereco();
			    String padEndereco = StringUtils.rightPad(endereco, 50, ' ');
			    
			    String linha = padCodigo;
			    linha += padNome;
			    linha += padEndereco;
			    
			    sbl.appendLine(linha);
			    System.out.println("==========FOR   "+ sbl.getContent());
			}
			
			 return sbl.getContent();
			
		} catch (BancoDadosException ex) {
			ex.printStackTrace();
		}
		
		//FIXME O que eu deveria retornar aqui?
		return null;
	}

}


