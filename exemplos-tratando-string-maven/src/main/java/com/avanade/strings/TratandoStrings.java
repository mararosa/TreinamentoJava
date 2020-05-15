package com.avanade.strings;

import org.apache.commons.lang3.StringUtils;

public class TratandoStrings {
   
	//Metodos strings sempre retornam uma estancia de outra string
	
	    public static void main(String[] args) {
	        
	        String s1 = "  João Paulo   ";
	        System.out.println("exemplo 1 = " + s1.charAt(0));
	        
	        char c = s1.trim().charAt(0);
	        System.out.println("exemplo 2 = " + c);
	        
	        String s2 = null;
	        String temp = StringUtils.trim(s2);
	        System.out.println(temp);     
	        
	        String strAbbreviate = StringUtils.abbreviate(s1.trim(),  9);
	        System.out.println(strAbbreviate);
	        
	        String nome = "Pedro Augusto de Abreu Cascalhavel";
	        
	        String[] nomes = StringUtils.split(nome, " ");
	        
	        //Posso fazer uma serie de validacoes. If nome == null, nome.tamanho verificar tamanho do array
	        //Sempre esperado fazer validacoes antes de usar qualquer tipo de variavel
	        StringBuilder nomeExibir = new StringBuilder();
	        nomeExibir.append(nomes[0]);
	        nomeExibir.append(" ");
	        //tamanho do meu array eh um numero inteiro, entao para pegar a ultima posicao devo fazer tamaho - 1
	        int tamanhoNomes = nomes.length;
	        nomeExibir.append(nomes[tamanhoNomes - 1]);
	        
	        System.out.println(nome);
	        System.out.println(nomeExibir);
	    }
}
