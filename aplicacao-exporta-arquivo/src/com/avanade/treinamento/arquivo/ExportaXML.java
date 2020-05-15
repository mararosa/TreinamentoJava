package com.avanade.treinamento.arquivo;

import com.avanade.treinamento.arquivo.componentes.StringBuilderLines;

/**
 * Gera somente gera o conteudo, quem cria o arquivo eh o
 * AbstractExportarArquivo.
 * 
 * @author edimara.roberta.rosa
 *
 */
public class ExportaXML extends AbstractExportarArquivo {
	// Implementar exporta XML
	@Override
	protected String getExtensaoArquivo() {
		return "xml";
	}

	/**
	 * Pega uma lista de conteudo
	 * @return um StringBuilder vazio
	 */
	@Override
	protected StringBuilder getConteudo() {
		//Implementa o StringBuilderLine para acessar o metodo appendLine (/n)
		StringBuilderLines sbl = new StringBuilderLines();
		sbl.appendLine("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		sbl.appendLine("<receita nome=\"pão\" tempo_de_preparo=\"5 minutos\" tempo_de_cozimento=\"1 hora\">");
		sbl.appendLine("    <titulo>Pão simples</titulo>");
		sbl.appendLine("    <ingredientes>");
		sbl.appendLine("        <ingrediente quantidade=\"3\" unidade=\"xícaras\">Farinha de Trigo</ingrediente>");
		sbl.appendLine("    </ingredientes>");
		sbl.appendLine("</receita>");
		
		//Nao consigo retrnar o stringbuilder pq nao eh uma instancia do mesmo tipo. 
		// Pq nao consigo fazer extendes, mas tenho dentro do sbl o metodo getContent();
		return sbl.getContent();
	}
}
