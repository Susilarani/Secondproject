import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Acer on 17/01/2017.
 */
public class Mystepdefs {


    public WebDriver driver;




    @Before
    public void startbrowser(){
        System.out.println("Open");
        driver=new FirefoxDriver();


       driver.get( "http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MINUTES);
        driver.manage().window().maximize();

    }
    @After
    public void closeandexit() {


        driver.quit();
        System.out.println("Close");

    }


    @Given("^Customer is in homepage$")
    public void customer_is_in_homepage() throws Throwable {
       driver.get("http://demo.nopcommerce.com/");

    }

    @When("^he navigates to registration page$")
    public void he_navigates_to_registration_page() throws Throwable {
        driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();

    }

    @And("^he enter his details$")
    public void he_enter_his_details() throws Throwable {
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Rani");
        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("1");
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("January");
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1990");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("6test@mailinator.com");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("password");
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("password");
        driver.findElement(By.id("register-button")).click();

    }

    @Then("^he should sign up succesfully$")
    public void he_should_sign_up_succesfully() throws Throwable {

       Assert. assertEquals("Your registration completed", driver.findElement(By.cssSelector("div.result")).getText());
      // driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();

    }


}
