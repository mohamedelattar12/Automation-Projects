package DefinitionSteps;

import Page.HomePage;
import Page.LoginPagePOM;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition {
    WebDriver driver = new ChromeDriver();
    LoginPagePOM pomLoginPage =new LoginPagePOM(driver);
    HomePage pomHomePage= new HomePage(driver);

    @Given("^Open the Swag Labs Website$")
    public void openSwagWebsite() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("^Enter \"(.*)\" in the username field on Login Screen$")
    public void enterUserName(String username){
        pomLoginPage.userNAme().sendKeys(username);
    }

    @And("^Enter \"(.*)\" in the password field on Login Screen$")
    public void enterPassword(String password){
        pomLoginPage.passWord().sendKeys(password);
    }

    @And("Press the \"login\" button")
    public void pressLogin(){
        pomLoginPage.passWord().sendKeys(Keys.ENTER);
    }

    @Then("Successful Login")
    public void assertLogin(){
        String expectedUrl= "https://www.saucedemo.com/inventory.html";
        String actualUrl= pomHomePage.pageUrl();
        Assert.assertEquals("home page url",expectedUrl,actualUrl);
    }






    @After
}
