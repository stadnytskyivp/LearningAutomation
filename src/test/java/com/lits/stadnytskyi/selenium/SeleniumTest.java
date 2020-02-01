package com.lits.stadnytskyi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void google_search_test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

        // BROWSER == DRIVER
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Java Ref to HTML elem <input name="q" ....... />
        WebElement searchTextBox = driver.findElement(By.name("q"));

        // type into Html input text "Tesla Motors"
        searchTextBox.sendKeys("Tesla Motors");

        // submit search form
        driver.findElement(By.name("btnK")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
