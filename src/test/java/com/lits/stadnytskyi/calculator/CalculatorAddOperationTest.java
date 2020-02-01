package com.lits.stadnytskyi.calculator;

import com.lits.calculator.Calculator;
import com.lits.calculator.Operation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class CalculatorAddOperationTest {

    private Calculator calculator = new Calculator();

    @Test(groups = {"calculator","simple-operations","add"},
            description = "Verify that add operation is being performed courrect")
    public void testAdd(){
        calculator.reset();

        // GIVEN
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.2);
        // WHEN
        calculator.setValue(a);
        // THEN
        Assert.assertEquals(calculator.getCurrentAmount(),a);
        // WHEN
        calculator.add(b);

        //List<Operation> operationsHistory

        // THEN
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.3));
    }

    //@Test(expectedExceptions = {AssertionError.class})
    @Test
    public void testMultiply(){
        calculator.reset();

        BigDecimal a = BigDecimal.valueOf(10);
        BigDecimal b = BigDecimal.valueOf(0.2);

        calculator.setValue(a);
        Assert.assertEquals(calculator.getCurrentAmount(),a);

        calculator.multiply(b);
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(2.0));
    }

}
