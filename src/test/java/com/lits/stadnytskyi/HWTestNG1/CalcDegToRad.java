package com.lits.stadnytskyi.HWTestNG1;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalcDegToRad {

    private Calculator calculator = new Calculator();

    @Test(dataProvider = "DegToRadData", description = "Verify degrees to radians conversion",
            groups = {"acceptance", "regression"})
    public void testDegToRad(BigDecimal a, BigDecimal result){
        calculator.setValue(a);
        calculator.convertToRAD();
        int compareResult  = calculator.getCurrentAmount().compareTo(result);
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider
    public Object[][] DegToRadData(){
        return new Object[][]{
                {BigDecimal.valueOf(0), BigDecimal.valueOf(0)},
                {BigDecimal.valueOf(180), BigDecimal.valueOf(3.141592653589740)}
        };
    }
}
