package com.avanade.treinamento;

import java.util.Scanner;

/**
* Efetua calculos operacoes matematicas com base em valores recebidos pelo input
*
* @author Mara Rosa
*/
public class CalculadoraConsole {

	private Scanner userInput; // scanner declarado no corpo da classe
	private int expression;

	public static void main(String[] args) {
		CalculadoraConsole calc = new CalculadoraConsole(); // Iniciando a classe da calculadora
		calc.calculatorInit(); // Inicializaçao
	}

	/**
	* Efetuar a inicializacao da aplicacao
	*/
	private void calculatorInit() {
		// inicializar Scanner para captura de dados digitados pelo usuario
		userInput = new Scanner(System.in); // utiliza o input do sistema operacional

		try {

			printMathExpressionsMenu();
			askExpression();

		} finally {
			userInput.close(); // sempre que finaliza o programa, o scanner sera fechado
		}

	}

	private void askExpression() {

		expression = 0; // nao posso ter valor na expression quando solicito o method askExpression
		String strExpression = userInput.next(); // le o que o usuario digitou

		if (!checkNumber(strExpression)) {

			printMessage("\nOperacao invalida");

			printMathExpressionsMenu();
			askExpression();

		} else {

			expression = Integer.valueOf(strExpression);
			checkExpression();
		}
	}

	private void checkExpression() {

		if (expression < 1 || expression > 5) {

			printMessage("\nOperacao invalida.");

			printMathExpressionsMenu();
			askExpression();

		} else if (expression == 5) {

			System.out.println("Adeus ;( ");
			System.exit(0);

		} else {

			askValues();

		}
	}

	private void askValues() {

		int firstNumber = askNumber(1);
		int secondNumber = askNumber(2);

		if (expression == 4 && secondNumber == 0) {

			printMessage("\nInvalido! Divisao por zero");
			askValues();
			return;

		}

		executeCalculation(firstNumber, secondNumber);

		printMessage("Calculo efetuado com sucesso! ");

		printMathExpressionsMenu();
		askExpression();

	}

	
	private void executeCalculation(int firstNumber, int secondNumber) {
		
		switch (expression) {
			case 1: {
			
			addition(firstNumber, secondNumber);
			break;
		    }
			case 2: {
				
				subtraction(firstNumber, secondNumber);
				break;
			}
			case 3: {
				
				multiplication(firstNumber, secondNumber);
				break;
			}
			case 4: {
				
				division(firstNumber, secondNumber);
				break;
			}
	
		 }

	}

	private int askNumber(int position) {
		String identification = (position == 1 ? "primeiro" : "segundo");

		System.out.print("Digite o " + identification + " numero: ");
		String strNumber = userInput.next();

		if (!checkNumber(strNumber)) {

			printMessage("Numero invalido, tente novamente");
			return askNumber(position);

		} else {

			int number = Integer.valueOf(strNumber);
			return number;
		}
	}

	/**
	 * Imprime mensagem personalidade, de acordo com o metodo chamado.
	 */
	private void printMessage(String message) {

		System.out.println(message);
		System.out.println("[ENTER] para continuar");
		userInput.nextLine();
		userInput.nextLine();
	}

	/**
	 * Imprime o menu de operacoes matematicas
	 */
	private void printMathExpressionsMenu() {
		System.out.println("--------------------------");
		System.out.println("CALCULADORA");
		System.out.println("--------------------------");
		System.out.println();
		System.out.println("Operacoes: \n 1. Adicao \n 2. Subtração \n 3. Multiplicacao \n 4. Divisao \n 5. Sair \n");
		System.out.print("Selecione uma operacao: ");

	}

	/**
	 * Verifica se a string informada pelo usuario é um número válido
	 * 
	 * @param strNumero String com o número a ser validados
	 * @return Se é um número válido <code>true</code>, senão <code>false</code>
	 */
	private boolean checkNumber(String strNumber) {
		try {
			Integer.valueOf(strNumber);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	/**
	 * Efetua a soma dos numeros informados
	 * 
	 * @param firstNumber  Primeiro valor
	 * @param secondNumber Segundo valor
	 */
	private void addition(int firstNumber, int secondNumber) {
		int result = firstNumber + secondNumber;
		System.out.println("Adicao");
		System.out.println("=============");
		System.out.println(firstNumber + " + " + secondNumber + " = " + result);

	}

	/**
	 * Efetua a subtracao dos numeros informados
	 * 
	 * @param firstNumber  Primeiro valor
	 * @param secondNumber Segundo valor
	 */
	private void subtraction(int firstNumber, int secondNumber) {
		int result = firstNumber - secondNumber;
		System.out.println("Subtracao");
		System.out.println("=============");
		System.out.println(firstNumber + " - " + secondNumber + " = " + result);

	}

	/**
	 * Efetua a multiplicacao dos numeros informados
	 * 
	 * @param firstNumber  Primeiro valor
	 * @param secondNumber Segundo valor
	 */
	private void multiplication(int firstNumber, int secondNumber) {
		int result = firstNumber * secondNumber;
		System.out.println("Multiplicacao");
		System.out.println("=============");
		System.out.println(firstNumber + " * " + secondNumber + " = " + result);

	}

	/**
	 * Efetua a divisao dos numeros informados
	 * 
	 * @param firstNumber  Primeiro valor
	 * @param secondNumber Segundo valor
	 */
	private void division(int firstNumber, int secondNumber) {
		double result = firstNumber / secondNumber;
		System.out.println("Divisao");
		System.out.println("=============");
		System.out.println(firstNumber + " / " + secondNumber + " = " + result);

	}

}
