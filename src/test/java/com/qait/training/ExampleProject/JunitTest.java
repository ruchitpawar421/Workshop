package com.qait.training.ExampleProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class JunitTest {
	int a = 3;
	int b = 5;
	float c = 0;

	@Before
	public void beforeSuite() {
		System.out.println("This function runs before a suite is invoked");
	}

	@After
	public void afterSuite() {
		System.out.println("This function runs after a suite is invoked");
	}

	@Test
	public void add() {
		c = a + b;
		Assert.assertTrue("Sum of 2 positive nos. must not be less than 0", c > 0);
	}

	@Test
	public void divide() {
		c = a / b;
		Assert.assertTrue("Value should be greater than 0. Denominator should be less than numerator", c > 0);
	}
}
