package com.calculator.calculator;

public class Calculator {

	private double operandOne;
	private double operandTwo;
	private char operation;
	private double result; 
	
	public Calculator() {
		this(0, 0, '+');
	}
	
	public Calculator(double operandOne, double operandTwo, char operation) {
		this.operandOne = operandOne;
		this.operandTwo = operandTwo;
		this.operation = operation;
		this.result = 0;
	}
	
	public void performOperation() {
		if(operation == '+') {
			this.result = operandOne + operandTwo;
		} else if(operation == '-') {
			this.result = operandOne - operandTwo;
		}
	}
	
	public void setOperandOne(double num) {
		this.operandOne = num;
	}
	
	public void setOperandTwo(double num) {
		this.operandTwo = num;
	}
	
	public void setOperation(char operator) {
		this.operation  = operator;
	}
	
	public void getResults() {
		System.out.println(this.result);
	}
	
	
}
