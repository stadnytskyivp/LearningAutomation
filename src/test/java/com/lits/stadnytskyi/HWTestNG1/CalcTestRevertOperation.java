package com.lits.stadnytskyi.HWTestNG1;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalcTestRevertOperation {

    @Test(dataProvider = "revertData", groups = {"regression", "acceptance"})
    public void testRevert(BigDecimal a, BigDecimal b, BigDecimal result){
        Calculator calculator = new Calculator();
        System.out.println("Revert starts -->/");
        calculator.setValue(a);
        calculator.multiply(b);
        calculator.subtract(a);
        calculator.revert();
        System.out.println("REVERT TRY");
        Assert.assertEquals(calculator.getCurrentAmount(), result);
        System.out.println("Current amount = "+calculator.getCurrentAmount());
    }

    @DataProvider
    public Object[][] revertData(){
        return new Object[][]{
                {BigDecimal.valueOf(25), BigDecimal.valueOf(4), BigDecimal.valueOf(100)}
        };
    }

}
