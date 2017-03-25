package cn.domain;

import java.math.BigDecimal;

public class Calculator {
	private String firstNum = "0";
	private String secondNum = "0";
	private char operator = '+';
	private String result;
	public Calculator(String firstNum, String secondNum, char operator) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.operator = operator;
	}
	public String getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}
	public String getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(String secondNum) {
		this.secondNum = secondNum;
	}
	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public void calculate() {
		BigDecimal first = new BigDecimal(firstNum);
		BigDecimal second = new BigDecimal(secondNum);
		switch(operator) {
		case '+':
			result = first.add(second).toString();
			break;
		case '-':
			result = first.subtract(second).toString();
			break;
		case '*':
			result = first.multiply(second).toString();
			break;
		case '/':
			if(second.doubleValue() == 0) {
				throw new RuntimeException("被除数不能为0");
			}
			result = first.divide(second, 10, BigDecimal.ROUND_HALF_UP).toString();
			break;
		}
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
