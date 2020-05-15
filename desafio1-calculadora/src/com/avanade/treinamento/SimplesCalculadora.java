package com.avanade.treinamento;

import java.util.Scanner;

public class SimplesCalculadora {

public static void main(String[] args) {
		
		int firstNumber = 0;
		int secondNumber = 0;
		char operator;
		double result = 0.0;
		
		//for taking input from user we have to create scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o primeiro n�mero: ");
		firstNumber = input.nextInt();

		System.out.println("Digite o segundo n�mero: ");
		secondNumber = input.nextInt();
		
		
		System.out.println("Escolha a opera��o: +, - , * ou /: ");
		operator = input.next().charAt(0);
		
		input.close();
		
		switch (operator) {
		case '+':
			result = firstNumber + secondNumber;
			break;
			
		case '-':
			result = firstNumber - secondNumber;
			break;
			
		case '*':
			result = firstNumber * secondNumber;
			break;
			
		case '/':
			result = secondNumber != 0 ? firstNumber / secondNumber : 0;
			break;
			
		default:
			System.out.println("Argumento inv�lido");	
			break;
		}
		
		System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
	}
}
