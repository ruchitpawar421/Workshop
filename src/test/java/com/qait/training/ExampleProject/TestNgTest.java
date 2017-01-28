package com.qait.training.ExampleProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgTest {
  
	int a = 3;
	int b = 5;
	float c = 0;

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This function runs before a suite is invoked");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This function runs after a suite is invoked");
  }
  
  @Test
  public void add() {
	  c = a+b;
	  Assert.assertTrue(c>0, "Sum of 2 positive nos. must not be less than 0");
  }
  
  @Test
  public void divide() {
	  c = a/b;
	  Assert.assertTrue(c>0, "Value should be greater than 0. Denominator should be less than numerator");
  }

}
