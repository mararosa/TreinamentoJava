package com.avanade.treinamento.pluralsight;

public class CalculatorMethod {

	public static void main(String[] args) {
		double[] leftVals = { 100, 25, 225, 11 };
		double[] rightVals = { 50, 92, 17, 3 };
		char[] opCodes = { 'd', 'a', 's', 'm' };
		double[] results = new double[opCodes.length];

		if(args.length == 0) {
		for (int i = 0; i < opCodes.length; i++) {
			results[i] = execute(opCodes[i], leftVals[i], rightVals[i]); 
		}

		for (double currentResult : results)
			System.out.println(currentResult);
	} else if(args.length == 3)
		handleCommandLine(args);
	else
		System.out.println("Please provide an operation code and 2 numeric values");
	}
	
	public static void handleCommandLine(String[] args) {
		char opCode = args[0].charAt(0);
		double leftVal = Double.parseDouble(args[1]);
		double rightVal = Double.parseDouble(args[2]);
		double result = execute(opCode, leftVal, rightVal);
		System.out.println(result);
	}

	static double execute(char opCode, double leftVal, double rightVal) {
		double result;
		switch (opCode) {
			case 'a':
				result = leftVal + rightVal;
				break;
			case 's':
				result = leftVal - rightVal;
				break;
			case 'm':
				result = leftVal * rightVal;
				break;
			case 'd':
				result = leftVal != 0 ? leftVal / rightVal : 0;
				break;
			default:
				System.out.println("Invalid opcode: " + opCode);
				result = 0;
				break;
				
		}
		return result;
		
	}

}
