package com.avanade.arquivo;

import java.io.IOException;

public class Applicacao {

	/**
	 * Metodo main chama o executar e roda a aplicacao
	 * @param args
	 */
	public static void main(String[] args) {
        AbstractExportarAquivo exporta = new ExportaDadosFormatados();
        System.out.println("Iniciando exportação de arquivo...");
        try {           
            exporta.executar("C:\\temp", "exportacao");
            System.out.println("Exportação concluída com sucesso!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
}
