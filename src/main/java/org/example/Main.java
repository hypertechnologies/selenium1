package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("User should be successfully logged in and logged out.");

        // Initiate Selenium WebDriver
        WebDriver driver;

        // Setup chrome browser
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        // Open a chrome browser
        driver = new ChromeDriver();
        
        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        // Navigate to the url https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // Enter standard_user in the username field
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");

        // Enter password secret_sauce
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

        // Click on login button
        driver.findElement(By.cssSelector("#login-button")).click();

        // Verify checkout icon is visible
        boolean checkoutIconDisplayed = driver.findElement(By.cssSelector("#shopping_cart_container > a")).isDisplayed();
        if(checkoutIconDisplayed){
            System.out.println("Icon is displayed");
        }else {
            System.out.println("Icon is NOT displayed");
        }

        // Logout
        // Explicit wait
        // Wait for hamburger menu to be clickable untill 5000 milliseconds.
        // It will keep checking every 500 milliseconds to the clickability until the time out of 5000 milliseconds.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#react-burger-menu-btn"))));

        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();

        // Fluent Wait
        FluentWait wait1 = new FluentWait(driver);
        wait1.withTimeout(Duration.ofMillis(10000));
        wait1.pollingEvery(Duration.ofMillis(2000));
        wait1.ignoring(ElementNotInteractableException.class);

        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();

        // Wait 5 seconds
        Thread.sleep(5000);
        // Close the browser
        driver.quit();

    }

}
