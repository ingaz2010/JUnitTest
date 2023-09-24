package com.promineotech.test;

import java.util.Random;

public class TestDemo {
	public int a;
	public int b;
	
	
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		}
		else {
			throw new IllegalArgumentException("Both parameters musst be positive!");
		}
	}
	
	// Method oddOrEven checks if number is Odd Or Even and returns result as a String
	public String oddOrEvenNumber(int a) {
		String result = "";
		if(a%2==0) {
			result = "Even";
		} else {
			result = "Odd";
		}
		return result;
	}
	
	public int randomNumberSquared() {
		int num = getRandomInt();
		return num*num;
	}

	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10)+ 1;
	}


public static void main(String[] args){
	TestDemo testDemo = new TestDemo();
	System.out.println(testDemo.addPositive(5,2));
	System.out.println(testDemo.randomNumberSquared());
	System.out.println(testDemo.oddOrEvenNumber(3));
}
}