package com.avanade.treinamento;

import java.util.Scanner;

public class SimpleCalculator {
	
	public static void main(String[] args) {
		
		int firstNumber, secondNumber;
		char operator;
		
		//for taking input from user we have to create scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o primeiro número: ");
		firstNumber = input.nextInt();

		System.out.println("Digite o segundo número: ");
		secondNumber = input.nextInt();
		
		
		System.out.println("Escolha a operação: +, - , * ou /: ");
		operator = input.next().charAt(0);
		
		input.close();
		
		switch (operator) {
		case '+': 
			System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + sum(firstNumber, secondNumber));
			break;
		case '-': 
			System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + sub(firstNumber, secondNumber));
			break;
		case '*': 
			System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + mult(firstNumber, secondNumber));
			break;
		case '/': 
			System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + div(firstNumber, secondNumber));
			break;
		default:
			System.out.println("Argumento inválido");	
			break;
		}
	}
	
	
	public static int sum (int x, int y) {
		int result = x + y;
		return result;	
	}	
	
	public static int sub (int x, int y) {
		int result = x - y;
		return result;	
	}
	
	public static int mult (int x, int y) {
		int result = x * y;
		return result;	
	}
	
	public static double div (int x, int y) {
		double result = y != 0 ? x / y : 0;
		return result;	
	}
	
}

