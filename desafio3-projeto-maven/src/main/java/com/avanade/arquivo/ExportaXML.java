package com.avanade.arquivo;

import com.avanade.arquivo.componentes.StringBuilderLines;

public class ExportaXML extends AbstractExportarAquivo {

	@Override
	protected String getExtensaoArquivo() {
		return "xml";
	}
	
	@Override
	protected StringBuilder getConteudo() {
		StringBuilderLines sbl = new StringBuilderLines();
		sbl.appendLine("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		sbl.appendLine("<receita nome=\"pão\" tempo_de_preparo=\"5 minutos\" tempo_de_cozimento=\"1 hora\">");
		sbl.appendLine("    <titulo>Pão simples</titulo>");
		sbl.appendLine("    <ingredientes>");
		sbl.appendLine("        <ingrediente quantidade=\"3\" unidade=\"xícaras\">Farinha de Trigo</ingrediente>");
		sbl.appendLine("    </ingredientes>");
		sbl.appendLine("</receita>");
		
		return sbl.getContent();
	}
	
	
}
