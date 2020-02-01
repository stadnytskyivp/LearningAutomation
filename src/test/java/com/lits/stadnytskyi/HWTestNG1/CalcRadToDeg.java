package com.lits.stadnytskyi.HWTestNG1;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;

public class CalcRadToDeg {
    private Calculator calculator = new Calculator();

    @Test(dataProvider = "RadToDegData", description = "Verify radians to degrees conversion",
            groups = {"regression", "acceptance"})
    public void testRadToDeg(BigDecimal a, BigDecimal result){
        calculator.setValue(a);
        calculator.convertToDEG();
        int compareResult = calculator.getCurrentAmount().compareTo(result);
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider
    public Object[][] RadToDegData(){
        return new Object[][]{
                {BigDecimal.valueOf(0.05), BigDecimal.valueOf(2.85)},
                {BigDecimal.valueOf(0.10), BigDecimal.valueOf(5.7)},
                {BigDecimal.valueOf(0.25), BigDecimal.valueOf(14.25)},
                {BigDecimal.ZERO, BigDecimal.ZERO}
        };
    }
}
