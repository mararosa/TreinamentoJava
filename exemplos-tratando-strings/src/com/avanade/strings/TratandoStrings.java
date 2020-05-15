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
	       
	    }
}
