package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLogin extends Base{
    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    @Then("I should be successfully logged in")
    public void iShouldBeSuccessfullyLoggedIn() {
        String ulrAfterLogin = driver.getCurrentUrl();
        assert ulrAfterLogin.contains("/inventory.html");
    }
}
