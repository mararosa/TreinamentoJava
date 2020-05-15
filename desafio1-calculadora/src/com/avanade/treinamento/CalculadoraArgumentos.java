package com.avanade.treinamento;

import java.util.ArrayList;
import java.util.List;

/**
* Efetuar calculos matematicos com base em valores recebido em parametros na inicializacao
*
* @author Rodrigo Tavares
* @author Edimara Rosa
*/
public class CalculadoraArgumentos {
	private static final int NUMERO_ARGUMENTOS_CALCULO = 3;
	private static final List<String> LISTA_OPERACOES = new ArrayList<String>();
	
	private static final String OPER_ADICAO = "a";
	private static final String OPER_SUBTRACAO = "s";
	private static final String OPER_MULTIPLICACAO = "m";
	private static final String OPER_DIVISAO = "d";
	
	static {
		// Inicializar lista de operacoes
		LISTA_OPERACOES.add(OPER_ADICAO);
		LISTA_OPERACOES.add(OPER_SUBTRACAO);
		LISTA_OPERACOES.add(OPER_MULTIPLICACAO);
		LISTA_OPERACOES.add(OPER_DIVISAO);
	}
	
	public static void main(String[] args) {
		//Validacao dos argumentos
		if (args.length != NUMERO_ARGUMENTOS_CALCULO) {
			imprimirInstrucoes();
			return;
		}
		
		//Iniciando classe da calculadora
		CalculadoraArgumentos calc = new CalculadoraArgumentos();
		
		//Carrega argumentos informadoes
		String strNum1 = args[0];
		String strNum2 = args[1];
		String strOperacao = args[2];
		
		//Inicializa�ao
		calc.iniciaCalculadora(strNum1, strNum2, strOperacao.toLowerCase());
	}
	
	/**
	 * * Imprime instrucoes para execucao da aplicacao
	 */
	public static void imprimirInstrucoes() {
		System.out.println("Calculadora com argumentos");
		System.out.println("Usar: ");
		System.out.println("java CalculadoraArgumentos [numero1] [numero2] [operacao] ");
		
	}
	
	public static void imprimirOperacoesDisponiveis() {
		System.out.println("Operacoes disponiveis: a = adicao, s = subtracao, m = multiplicacao, d = divisao");
	}
	
	/**
	 * Efetua a inicializacao da calculadora
	 *
	 * @param strNum1  String contendo o primeiro n�mero para c�lculo
	 * @param strNum2     String contendo o segundo n�mero para c�lculo
	 * @param strOperacao Tipo de opera��es que devem ser: a = adicao, s =
	 *                    subtracao, m = multipicacao, d = divisao
	 */
	private void iniciaCalculadora(String strNum1, String strNum2, String strOperacao) {
		if (!validarNumero(strNum1)) {
			System.err.println("Primeiro valor n�o � um n�mero v�lido [valor = " + strNum1 + "]");
			return;
		}
		
		if (!validarNumero(strNum2)) {
			System.err.println("Segundo valor n�o � um n�mero v�lido [valor = " + strNum2 + "]");
			return;
		}
		
		if (!LISTA_OPERACOES.contains(strOperacao)) {
			System.err.println("Terceiro parametro n�o � uma opera��o v�lida [valor = " + strOperacao + "]");
			imprimirOperacoesDisponiveis();
			return;
		}
		
		int num1 = Integer.valueOf(strNum1);
		int num2 = Integer.valueOf(strNum2);

		if (strOperacao.equals(OPER_DIVISAO) && num2 == 0) {
			System.err.println("Segundo valor n�o pode ser zero para uma divis�o");
			return;
		}
		
		if (OPER_ADICAO.equals(strOperacao)) {
			adicao(num1, num2);
		}
		if (OPER_SUBTRACAO.equals(strOperacao)) {
			subtracao(num1, num2);
		}
		if (OPER_MULTIPLICACAO.equals(strOperacao)) {
			multiplicacao(num1, num2);
		}
		if (OPER_DIVISAO.equals(strOperacao)) {
			divisao(num1, num2);
		}
		
	}

	/**
	 * Verifica se a string informada � um n�mero v�lido
	 * 
	 * @param strNumero String com o n�mero a ser validados
	 * @return Se � um n�mero v�lido <code>true</code>, sen�o <code>false</code>
	 */
	private boolean validarNumero(String strNumero) {
		try {
			Integer.valueOf(strNumero);
			return true;
		} catch (NumberFormatException ex) {
			
			return false;
		}
	}
	
	/**
	 * Efetua a soma dos numeros informados
	 * @param num1 Primeiro valor
	 * @param num2 Segundo valor
	 */
	private void adicao(int num1, int num2) {
		int vtotal = num1 + num2;
		System.out.println("Adicao");
		System.out.println("=============");
		System.out.println(num1 + " + " + num2 + " = " + vtotal);
		
	}
	private void subtracao(int num1, int num2) {
		int vtotal = num1 - num2;
		System.out.println("Subtracao");
		System.out.println("=============");
		System.out.println(num1 + " - " + num2 + " = " + vtotal);
		
	}
	private void multiplicacao(int num1, int num2) {
		int vtotal = num1 * num2;
		System.out.println("Multiplicacao");
		System.out.println("=============");
		System.out.println(num1 + " * " + num2 + " = " + vtotal);
		
	}
	private void divisao(int num1, int num2) {
		double vtotal = num1 / num2;
		System.out.println("Divisao");
		System.out.println("=============");
		System.out.println(num1 + " / " + num2 + " = " + vtotal);
		
	}


}