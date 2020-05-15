package com.avanade.arquivo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.avanade.arquivo.componentes.StringBuilderLines;
import com.avanade.arquivo.data.PersonData;

public class ExportaDadosFormatados extends AbstractExportarAquivo {

	/**
	 *  Define a extensao do arquivo, neste caso eh txt
	 */
	@Override
	protected String getExtensaoArquivo() {
	
		return "txt";
	}

	/**
	 *  Gera uma lista de pessoas com id nome e endereco
	 * @return
	 */
	private List<PersonData> gerarDadosPessoa() {

		List<PersonData> list = new ArrayList<PersonData>();
		
		//A cada interaçao é contada como uma pessoa dentro do array
		for (int i = 1; i <= 100; i++) {

			PersonData pessoa = new PersonData();

			pessoa.setId(i);

			pessoa.setNome("Pessoa Número: " + i);

			pessoa.setEndereco("Rua da pessoa: " + i);
			
			//Adiciona a pessoa na lista 
			list.add(pessoa);
		}
		
		return list;

	}

	/**
	 *  Cria e formata os dados.
	 */
	@Override
	protected StringBuilder getConteudo() {
		
		StringBuilderLines sbl = new StringBuilderLines();
		List<PersonData> lst = gerarDadosPessoa();
		for (PersonData pessoa : lst) {
		    int id = pessoa.getId();
		    String padId = StringUtils.leftPad(String.valueOf(id), 5, '0');
		    
		    String nome = pessoa.getNome();
		    String padNome = StringUtils.rightPad(nome, 30, ' ');
		    
		    String endereco = pessoa.getEndereco();
		    String padEndereco = StringUtils.rightPad(endereco, 50, ' ');
		    
		    String linha = padId;
		    linha += padNome;
		    linha += padEndereco;
		    
		    //
		    sbl.appendLine(linha);
		}
		return sbl.getContent();
	}

}
