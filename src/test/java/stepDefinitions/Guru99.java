package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Guru99 extends Base {
    @When("I select quantity")
    public void iSelectQuantity() throws InterruptedException {
        WebElement dropdownquantity = driver.findElement(By.cssSelector("select[name='quantity']"));
        Select select = new Select(dropdownquantity);
        select.selectByIndex(1);
//        select.selectByVisibleText("8");
//        select.selectByValue("5");

        Thread.sleep(5000);
    }

    @And("I click on BUY NOW option")
    public void iClickOnBUYNOWOption() {
        driver.findElement(By.cssSelector(".special")).click();
    }

    @Then("I need to fill payment process form")
    public void iNeedToFillPaymentProcessForm() {
        driver.findElement(By.cssSelector("#card_nmuber")).sendKeys("0123456987896542");

        WebElement dropdownmonth = driver.findElement(By.cssSelector("#month"));
        Select select1 = new Select(dropdownmonth);
        select1.selectByIndex(4);

        WebElement dropdownyear = driver.findElement(By.cssSelector("#year"));
        Select select2 = new Select(dropdownyear);
        select2.selectByIndex(7);

        driver.findElement(By.cssSelector("#cvv_code")).sendKeys("123");
    }

    @When("I click PAY option")
    public void iClickPAYOption() {
        driver.findElement(By.cssSelector(".special")).click();
    }

    @Then("I should see payment success screen")
    public void iShouldSeePaymentSuccessScreen() {
//        String txt = driver.findElement(By.cssSelector("#three h2")).getText();
//        assert txt.contains("successfull");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#three h2")));
    }
}