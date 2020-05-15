package com.avanade.treinamento.pluralsight;

public class CalculatorArray {
	
	public static void main(String[] args) {
		double[] leftVals = {100, 25, 225, 11};
		double[] rightVals = {50, 92, 17, 3};
		char[] opCodes = {'d', 'a', 's', 'm'};
		double[] results = new double[opCodes.length];
		
		for(int i = 0; i < opCodes.length; i++) {
			//this switch statement is very tightly tied to these arrays, which means we're very hard to use this code for any other scenario. Should break the code out into a separate method.
			switch (opCodes[i]) { 
				case 'a':
					results[i] = leftVals[i] + rightVals[i];
					break;
				case 's':
					results[i] = leftVals[i] - rightVals[i];
					break;
				case 'm':
					results[i] = leftVals[i] * rightVals[i];
					break;
				case 'd':
					results[i] = leftVals[i] != 0 ? leftVals[i] / rightVals[i] : 0;
					break;
				default:
					System.out.println("Invalid opcode: " + opCodes[i]);
					results[i] = 0;
					break;
			}
		}
		for (double currentResult : results)
		System.out.println(currentResult);
	}

}
