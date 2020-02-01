package com.lits.stadnytskyi.HWTestNG1;

import com.lits.calculator.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CalcTestHistoryTest {

    @Test(description = "Verify operations history correctness: add, subtract", dataProvider = "data", groups = {"acceptance", "regression"})
    public void testOperationsHistoryAddSubtract(BigDecimal a, BigDecimal b) {
        Calculator calculator = new Calculator();
        System.out.println("Test history #1");
        calculator.setValue(a);
        BigDecimal c = calculator.add(b);
        calculator.subtract(b);
        List<Operation> expectedResult = Arrays.asList(new AddOperation(a, b), new SubtractOperation(c, b));
        Assert.assertEquals(calculator.getOperationsHistory().toString(), expectedResult.toString());
    }

    @Test(description = "Verify operations history correctness: multiply, divide", dataProvider = "data",  groups = {"regression"})
    public void testOperationHistoryMultiplyDivide(BigDecimal a, BigDecimal b) {
        System.out.println("Test history #2");
        Calculator calculator = new Calculator();
        calculator.setValue(a);
        BigDecimal c = calculator.multiply(b);
        calculator.divide(b);
        List<Operation> expectedResult = Arrays.asList(new MultiplyOperation(a, b), new DivideOperation(c, b));
        Assert.assertEquals(calculator.getOperationsHistory().toString(), expectedResult.toString());
    }

    @DataProvider
    public Object[][] data(Method testMethod) {
        return new Object[][]{
                {BigDecimal.valueOf(35), BigDecimal.valueOf(25)}
        };
    }

}
