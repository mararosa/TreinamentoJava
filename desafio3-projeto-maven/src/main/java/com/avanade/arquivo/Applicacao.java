package com.avanade.arquivo;

import java.io.IOException;

public class Applicacao {

	/**
	 * Metodo main chama o executar e roda a aplicacao
	 * @param args
	 */
	public static void main(String[] args) {
        AbstractExportarAquivo exporta = new ExportaDadosFormatados();
        System.out.println("Iniciando exporta��o de arquivo...");
        try {           
            exporta.executar("C:\\temp", "exportacao");
            System.out.println("Exporta��o conclu�da com sucesso!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
}
