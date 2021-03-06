package com.lits.stadnytskyi.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorParametrizedTest {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "data")
    public void testAddTwoNumbers(BigDecimal a, BigDecimal b, BigDecimal result) {

        // WHEN
        calculator.setValue(a);
        calculator.add(b);

        // THEN
       // Assert.assertEquals(calculator.getCurrentAmount(), result);
        int compareResult = result.compareTo(calculator.getCurrentAmount());
        Assert.assertEquals(compareResult,0);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {BigDecimal.valueOf(1.5),BigDecimal.valueOf(1.5),BigDecimal.valueOf(3.0)},
                {BigDecimal.valueOf(-1.5),BigDecimal.valueOf(1.5),BigDecimal.valueOf(0.0)},
                {BigDecimal.valueOf(2.5),BigDecimal.ZERO,BigDecimal.valueOf(2.5)},
                {BigDecimal.valueOf(1000000000),BigDecimal.valueOf(1.5),BigDecimal.valueOf(1000000001.5)},
                //{BigDecimal.valueOf(-9.143),BigDecimal.valueOf(0.143),BigDecimal.valueOf(-9.0)},
        };
    }

}
