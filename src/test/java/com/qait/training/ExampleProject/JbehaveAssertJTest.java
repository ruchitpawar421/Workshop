package com.qait.training.ExampleProject;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.assertj.core.api.Assertions.*;

public class JbehaveAssertJTest {

	int a = 0;
	int b = 0;
	float c = 0;

	@Given("The values of first and second numbers are $arg1 and $arg2 respectively")
	public void given(@Named("arg1") int arg1, @Named("arg2") int arg2) {
		a = arg1;
		b = arg2;
	}

	@When("Adding first and second numbers")
	public void whenAdd() {
		c = a + b;
	}

	@When("Multiplying first and second numbers")
	public void whenMultiply() {
		c = a * b;
	}

	@Then("Sum of $arg1 numbers is greater then $arg2")
	public void thenSum(@Named("arg1") int arg1, @Named("arg2") int arg2) {
		assertThat(arg1).isGreaterThan(arg2);
	}

	@Then("Product of $arg1 numbers is greater then $arg2")
	public void thenProduct(@Named("arg1") int arg1, @Named("arg2") int arg2) {
		assertThat(arg1).isGreaterThan(arg2);
	}

}
