package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CommonSteps extends Base{

    @Given("I navigate to {string}")
    public void navigate(String url){
         WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new HtmlUnitDriver();
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get(url);
    }

    @And("I quit the browser")
    public void iQuitTheBrowser() {
        driver.quit();
    }
}
