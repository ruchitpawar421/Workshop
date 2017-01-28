package com.qait.training.ExampleProject;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTest {
	
	int a = 0;
	int b = 0;
	float c = 0;
	
  @Given("^The values of first and second numbers are (\\d+) and (\\d+) respectively$")
  public void given(int arg1, int arg2) throws Throwable {
	  a = arg1;
	  b = arg2;
  }

  @When("Adding first and second numbers")
  public void whenAdd() throws Throwable {
	  c = a + b;
  }

  @When("Multiplying first and second numbers")
  public void whenMultiply() throws Throwable {
	  c = a * b;
  }

  @Then("^Sum of (\\d+) numbers is greater then (\\d+)$")
  public void thenSum(int arg1, int arg2) throws Throwable {
	  Assert.assertTrue("Sum is not greater than "+ arg2, arg1>arg2);
  }

  @Then("^Product of (\\d+) numbers is greater then (\\d+)$")
  public void thenProduct(int arg1, int arg2) throws Throwable {
	  Assert.assertTrue("Product is not greater than "+ arg2, arg1>arg2);
  }

}
