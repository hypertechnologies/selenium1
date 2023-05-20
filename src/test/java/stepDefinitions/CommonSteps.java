package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps extends Base{

    @Given("I navigate to {string}")
    public void navigate(String url){
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @And("I quit the browser")
    public void iQuitTheBrowser() {
        driver.quit();
    }
}
