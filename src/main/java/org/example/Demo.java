package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("User should be successfully logged in and logged out.");

        // Initiate Selenium WebDriver
        WebDriver driver;

        // Setup chrome browser
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        driver = new ChromeDriver();

        // Go to https://demoqa.com/dynamic-properties
        driver.get("https://demoqa.com/dynamic-properties");

        // Verify "Color change" button is visible
        boolean colorChangeButtonVisible = driver.findElement(By.cssSelector("#colorChange")).isDisplayed();
        if(colorChangeButtonVisible){
            System.out.println("Color change button is visible");
        }else {
            System.out.println("Color change button is NOT visible");
        }

        // Verify "Will enable 5 seconds" button is disabled
        boolean willEnableButton = driver.findElement(By.cssSelector("#enableAfter")).isEnabled();
        if(willEnableButton){
            System.out.println("Will enable is enabled");
        }else {
            System.out.println("Will enable is disabled");
        }

        // verify "will enable 5 seconds" button is enabled after 5 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(6000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#enableAfter"))));

        // verify "Visible after 5 seconds" button is visible after 5 seconds
        FluentWait wait1 = new FluentWait(driver);
        wait1.withTimeout(Duration.ofMillis(6000));
        wait1.pollingEvery(Duration.ofMillis(5000));
        wait1.ignoring(NoSuchElementException.class);

        boolean visibleAfter = driver.findElement(By.cssSelector("#visibleAfter")).isDisplayed();
        if(visibleAfter){
            System.out.println("Visible after button is visible");
        }else {
            System.out.println("Visible after button is NOT visible");
        }

        driver.quit();

    }



}
