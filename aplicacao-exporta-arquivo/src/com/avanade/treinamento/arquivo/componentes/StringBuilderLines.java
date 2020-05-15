package com.avanade.treinamento.arquivo.componentes;

/**
 * Nao posso herdar do StringBuilder pq ele eh final, entao criarei componentes(contents).
 * @author edimara.roberta.rosa
 *
 */
public class StringBuilderLines {
	
//	public static void main(String[] args) {
//		StringBuilderLines sbl = new StringBuilderLines();
//		sbl.getContent().append("abc");
//	}
	
	//Cria atributo chamado conteudo
	private StringBuilder content;
	
	//Se eu quisesse fazer com int, nao preciso criar um novo, posso usar appendLine como sbrecarga
	// Returns the string representation of the int argument.
	public void appendLine(int i ) {
		appendLine(String.valueOf(i));
	}
	
	//Add uma linha (\n)
	public void appendLine(String str) {
		//Nao permite que a string seja nula. Nao permite add nada nule dentro do StringBuilder
		if (str == null) {
			return;
		}
		//Faz o tratamento do criar, se ja for nulo. Pq com o content pode ser que nao tenha criado ainda
		getContent().append(str);
		getContent().append("\n");
	}
	
	//Da acesso ao content, mas nao deixa setar o content
	//Getcontent da acesso ao StringBuilder
	public StringBuilder getContent() {
		if (content == null) {
			content = new StringBuilder();
		}
		return content;
	}
	
	

}
