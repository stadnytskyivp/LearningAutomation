package com.lits.stadnytskyi.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorParametrizedSubtraction {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "dataS")
    public void testSubtractTwoNumbers(BigDecimal a, BigDecimal b, BigDecimal result) {

        calculator.setValue(a);
        calculator.subtract(b);

        int compareResult = result.compareTo(calculator.getCurrentAmount());
        Assert.assertEquals(compareResult,0);
    }

    @DataProvider
    public Object[][] dataS(){
        return new Object[][]{
                {BigDecimal.valueOf(5),BigDecimal.valueOf(3),BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(6),BigDecimal.valueOf(-6),BigDecimal.valueOf(12)},
                {BigDecimal.valueOf(5),BigDecimal.valueOf(5),BigDecimal.valueOf(0)},
                //{BigDecimal.valueOf(5),BigDecimal.valueOf(3),BigDecimal.valueOf(3)},
        };
    }


}
