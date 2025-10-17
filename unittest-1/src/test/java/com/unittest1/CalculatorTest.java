package com.unittest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.unittest1.model.Calculator;


@SpringBootTest
public class CalculatorTest {
	
	@Test
	public void testAdd() {
		int expectedValue = 30;
		Calculator c = new Calculator();
		int actualValue = c.add(10, 20);
		Assertions.assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testMul() {
		int expectedValue = 20;
		Calculator c = new Calculator();
		int actualValue = c.mul(10, 2);
		Assertions.assertEquals(expectedValue, actualValue);
	}
	
	

}
