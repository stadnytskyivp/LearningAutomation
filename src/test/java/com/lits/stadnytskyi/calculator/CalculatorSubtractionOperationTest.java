package com.lits.stadnytskyi.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.math.BigDecimal;

public class CalculatorSubtractionOperationTest {

    private Calculator calculator = new Calculator();

    @Test(groups = {"calculator","simple-operations","subtract"},
            description = "Verify that subtraction operation is being performed courrect")
    public void testSubtraction() {
        calculator.reset();

        BigDecimal a = BigDecimal.valueOf(10);
        BigDecimal b = BigDecimal.valueOf(0.2);

        calculator.setValue(a);
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        calculator.subtract(b);
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(9.8));
    }
}
