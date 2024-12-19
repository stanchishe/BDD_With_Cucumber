package org.example;

import gherkin.lexer.Ca;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {
    private static Calculator calculator;
    private int int1;
    private int int2;
    private int result;

    @Before
    public static void init() {
        calculator = new Calculator();
    }

    @Given("the numbers {int} and {int}")
    public void the_numbers_and(Integer int1, Integer int2) {
        this.int1 = int1;
        this.int2 = int2;
    }
    @When("a sum of them is produced")
    public void a_sum_of_them_is_produced() {
        result = calculator.addition(int1, int2);
    }
    @Then("the result should be {int}")
    public void the_result_should_be(Integer expectedResult) {
        Assertions.assertEquals(expectedResult, result, "The addition failed!");
    }

    @When("a result of the subtraction is produced")
    public void a_result_of_the_subtraction_is_produced() {
        result = calculator.subtraction(int1, int2);
    }
    @Then("the subtraction result should be {int}")
    public void the_subtraction_result_should_be(Integer expectedResult) {
        Assertions.assertEquals(expectedResult, result, "The subtraction failed!");
    }
}
