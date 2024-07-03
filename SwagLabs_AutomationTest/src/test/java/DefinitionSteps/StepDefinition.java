package DefinitionSteps;

import Page.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
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
    LoginPagePOM pomLoginPage = new LoginPagePOM(driver);
    HomePage pomHomePage = new HomePage(driver);
    YourCart pomYourCart = new YourCart(driver);
    CheckoutYourInformation pomCheckout = new CheckoutYourInformation(driver);
    CheckoutOverview pomCheckoverview=new CheckoutOverview(driver);
    CheckoutComplete pomComplete=new CheckoutComplete(driver);

    @Given("^Open the Swag Labs Website$")
    public void openSwagWebsite() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @When("^Enter \"(.*)\" in the username field on Login Screen$")
    public void enterUserName(String username) {
        pomLoginPage.userNAme().sendKeys(username);
    }

    @And("^Enter \"(.*)\" in the password field on Login Screen$")
    public void enterPassword(String password) {
        pomLoginPage.passWord().sendKeys(password);
    }

    @And("Press the \"login\" button")
    public void pressLogin() {
        pomLoginPage.passWord().sendKeys(Keys.ENTER);
    }

    @Then("Successful Login")
    public void assertLogin() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = pomHomePage.pageUrl();
        Assert.assertEquals("home page url", expectedUrl, actualUrl);
    }

    @When("^Press the sorting drop down$")
    public void pressSortingDropMenu() {
        pomHomePage.sortingDropDown().click();
    }

    @And("^choose Name A to Z$")
    public void NameAtoZPress() {
        pomHomePage.nameAtoZ().click();
    }

    @Then("^Products are sorted from A to Z successfully$")
    public void assertSortfromAtoZ() {
        Assert.assertTrue(pomHomePage.nameAtoZ().isSelected());
        String s1 = pomHomePage.fistProduct().getText();
        String s2 = pomHomePage.secondProduct().getText();
        String s3 = pomHomePage.thirdProduct().getText();

        int compareResult1 = s1.compareTo(s2);
        int compareResult2 = s2.compareTo(s3);
        Assert.assertTrue(compareResult1 < 0 && compareResult2 < 0);
    }

    @When("^press Add to cart button for Sauce Labs Backpack$")
    public void addSauceLabsBackpack() {
        pomHomePage.sauceLabsBackpackAdd().click();
    }

    @Then("cart number increases by {string}")
    public void assertCartnumber(String cartNumber) {
        Assert.assertTrue(pomHomePage.cartNumber().getText().contains(cartNumber));
    }

    @When("Press on the cart icon on the top right of the page")
    public void cartIconPress() {
        pomHomePage.cartIcon().click();
    }

    @Then("Redirection to the cart page")
    public void cartpageAssert() {
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals("cartPageurl", expectedUrl, actualResult);
        String expectedTitle = "Your Cart";
        String actualTitle = pomYourCart.cartPageTitle().getText();
        Assert.assertEquals("cart page title", expectedTitle, actualTitle);
    }

    @When("Press Check out button")
    public void checkOutPress() {
        pomYourCart.checkOut().click();
    }

    @Then("Redirection to Checkout: Your Information")
    public void checkoutInformationRedirectionAssert() {
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualUrl);
    }

    @When("Insert first name {string} , Last name {string} and Postal code {string}")
    public void enterNameLastnamePostalcode(String name, String lastNAme, String postalCode) {
        pomCheckout.firstnameField().sendKeys(name);
        pomCheckout.lastnameField().sendKeys(lastNAme);
        pomCheckout.postalcodeField().sendKeys(postalCode);
    }

    @And("Click Contiune")
    public void clickContinue() {
        pomCheckout.continuebutton().click();
    }

    @Then("Redirection to Checkout: Overview")
    public void assertRedirection(){
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        String actualUrl=pomCheckoverview.pageUrl();
        Assert.assertEquals("checkout overview page url",actualUrl,expectedUrl);
    }

    @And("Check price 29.99")
    public void assertPrice(){
        String expectedprice = "29.99";
        String actualprice = pomCheckoverview.totalprice().getText();
        Assert.assertTrue(actualprice.contains(expectedprice));
    }

    @When("Press Finish")
    public void pressFisish(){
        pomCheckoverview.finish().click();
    }

    @Then("Check Checkout: Complete!")
    public void checkCompleteTitle(){
        String expectedTitle="Checkout: Complete!";
        String actualTitle=pomComplete.pageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @And("check Thank you for your order!")
    public void thankyouAssert(){
        String expectedThank="Thank you for your order!";
        String actualThank=  pomComplete.thankYouMessage();
        Assert.assertTrue(actualThank.contains(expectedThank));
    }

    @AfterStep
    public void afterStep() throws InterruptedException {
        Thread.sleep(500);
    }

    @After
    public void after() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
