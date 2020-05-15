package com.avanade.arquivo.exception;

import java.sql.SQLException;

public class BancoDadosException extends Exception{

	private static final long serialVersionUID = 6110513036482539445L;

	//Posso nao passar nada
	public BancoDadosException() {
		super();
	}

	// Posso passar uma msg e uma excecao
	public BancoDadosException(String message, Throwable cause) {
		super(message, cause);
	}

	//Posso passar so uma msg
	public BancoDadosException(String message) {
		super(message);
	}

	//Posso passar outra excecao
	public BancoDadosException(Throwable cause) {
		super(cause);
	}
	
	

}
