package org.test;

public class Calc {
	public int add(int a, int b) {
		return a + b;
	}

	public float divide(int a, int b) {
		
		if(b==0) throw new IllegalArgumentException("can't dived by zero.");
		
		return (float) a / (float) b;
	}
}