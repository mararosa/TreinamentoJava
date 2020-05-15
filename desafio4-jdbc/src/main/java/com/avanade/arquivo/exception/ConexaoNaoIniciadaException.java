package com.avanade.arquivo.exception;

public class ConexaoNaoIniciadaException extends RuntimeException{
	
	private static final long serialVersionUID = -456643397780302601L;

/**
 *  Quando nao tem contrutor na classe. Por padrao  colocamos um construtor sem parametro nenhum
 *  Mas no momento que ha um contrutor, mas nao tem o ctor sem parametro. Deve inicializar a classe com ctor que tem parametro
 * 
 */
	public ConexaoNaoIniciadaException() {
		super();
	}
	
	//Contrutor da classe para chamar uma exception especifica
	/**
	 * Contrutor criado utilizando a classe pai (runtimeexception)
	 * chamando um construtor da classe pai
	 * @param mensagem
	 */
	public ConexaoNaoIniciadaException(String mensagem) {
		super(mensagem);
	}
}
