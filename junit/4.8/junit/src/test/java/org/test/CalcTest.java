package org.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class CalcTest {
	@Test
	public void testAdd() {
		Calc calc = new Calc();
		int expected = 5;
		int actual = calc.add(2, 3);
		assertThat(actual, is(expected));
	}

	@Test
	public void testDivide() {
		Calc calc = new Calc();
		float expected = 1.5f;
		float actual = calc.divide(3, 2);
		assertThat(actual, is(expected));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDivideError(){
		
		Calc calc = new Calc();
		calc.divide(1, 0);
	}
	
	@Ignore
	public void testIgnore(){
	
		fail("this test code is under construction.");
	}
}