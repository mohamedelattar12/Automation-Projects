package DefinitionSteps;

import Page.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.bs.A;
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
    CheckoutOverview pomCheckoverview = new CheckoutOverview(driver);
    CheckoutComplete pomComplete = new CheckoutComplete(driver);

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

    @And("choose Name {string}")
    public void NameAtoZPress(String type) {
        switch (type) {
            case "A to Z":
                pomHomePage.nameAtoZ().click();
                break;
            case "Z to A":
                pomHomePage.nameZtoA().click();
                break;
            case "Low to High":
                pomHomePage.nameLowtoHigh().click();
                break;
            case "High to Low":
                pomHomePage.nameHightoLow().click();
                break;
            default:
                Assert.assertTrue("wrong name choose from sort table", false);
        }

    }

    @Then("Products are sorted from {string} successfully")
    public void assertSort(String type) {
        String s1 = pomHomePage.fistProduct().getText();
        double s1Price = Double.parseDouble(pomHomePage.fistProductPrice().getText().replace("$", ""));
        String s2 = pomHomePage.secondProduct().getText();
        double s2Price = Double.parseDouble(pomHomePage.secondProductPrice().getText().replace("$", ""));
        String s3 = pomHomePage.thirdProduct().getText();
        double s3Price = Double.parseDouble(pomHomePage.thirdProductPrice().getText().replace("$", ""));
        int compareResult1 = s1.compareTo(s2);
        int compareResult2 = s2.compareTo(s3);
        int compareResult3 = Double.compare(s1Price, s2Price);
        int compareResult4 = Double.compare(s2Price, s3Price);
//        System.out.println(s1Price+" "+s2Price+" "+s3Price+" "+compareResult3+" "+compareResult4);
        switch (type) {
            case "A to Z":
                Assert.assertTrue("asser a to z selected", pomHomePage.nameAtoZ().isSelected());
                Assert.assertTrue("A to Z assert switch", compareResult1 < 0 && compareResult2 < 0);
                break;
            case "Z to A":
                Assert.assertTrue("assert z to a selected", pomHomePage.nameZtoA().isSelected());
                Assert.assertTrue("Z to A assert Switch", compareResult1 > 0 && compareResult2 > 0);
                break;
            case "Low to High":
                Assert.assertTrue("asser low to high selected", pomHomePage.nameLowtoHigh().isSelected());
                Assert.assertTrue("Low to high switch assert", compareResult3 < 0 && compareResult4 < 0);
                break;
            case "High to Low":
                Assert.assertTrue("assert high to low selected", pomHomePage.nameHightoLow().isSelected());
                Assert.assertTrue("high to low switch assert", compareResult3 > 0 && compareResult4 > 0);
                break;
            default:
                Assert.assertTrue("wrong name choose from sort table", false);
        }

    }


    @When("^press Add to cart button for Sauce Labs Backpack$")
    public void addSauceLabsBackpack() {
        try {
            pomHomePage.sauceLabsBackpackAdd().click();
        }
        catch (Exception e){
            Assert.assertTrue("there is no element for Sauce Labs Backpack",false);
        }
    }

    @And("^press Add to cart button for Sauce Labs Bike Light$")
    public void addSauceLabsBikeLight() {
        pomHomePage.sauceLabsBikeLightAdd().click();
    }

    @And("^press Add to cart button for Sauce Labs Bolt T-Shirt$")
    public void addSauceLabsBoltTShirt() {
        pomHomePage.sauceLabsBoltTShirt().click();
    }

    @And("^press Add to cart button for Sauce Labs Fleece Jacket$")
    public void addSauceLabsFleeceJacket() {
        pomHomePage.sauceLabsFleeceJacket().click();
    }

    @Then("cart number changes to {string}")
    public void assertCartnumber(String cartNumber) {
        Assert.assertTrue(pomHomePage.cartNumber().getText().contains(cartNumber));
    }
    @And("Sauce Labs Backpack image is correct")
    public void checkSauceLabsBackpackImage(){
        String actualImageUrl=pomHomePage.sauceLabsBackpackImage().getAttribute("src");
        String expectedImageUrl="/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";
        Assert.assertTrue(actualImageUrl.contains(expectedImageUrl));
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
    @Then("Refuse Redirection to Checkout: Your Information")
    public void refuseCheckOut(){
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedURL, actualUrl);
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
    @Then("Check the error message is {string}")
    public void checkErrorMessage(String errorMessage){
        String expectedErrorMessage="Error: First Name is required";
        String actualErrorMessage = pomCheckout.errorMessage().getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    @Then("Redirection to Checkout: Overview")
    public void assertRedirection() {
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        String actualUrl = pomCheckoverview.pageUrl();
        Assert.assertEquals("checkout overview page url", actualUrl, expectedUrl);
    }

    @And("Check price {double}")
    public void assertPrice(double price) {
        String expectedprice = String.valueOf(price);
        String actualprice = pomCheckoverview.totalprice().getText();
        Assert.assertTrue(actualprice.contains(expectedprice));
    }

    @When("Press Finish")
    public void pressFisish() {
        pomCheckoverview.finish().click();
    }

    @Then("Check Checkout: Complete!")
    public void checkCompleteTitle() {
        String expectedTitle = "Checkout: Complete!";
        String actualTitle = pomComplete.pageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @And("check Thank you for your order!")
    public void thankyouAssert() {
        String expectedThank = "Thank you for your order!";
        String actualThank = pomComplete.thankYouMessage();
        Assert.assertTrue(actualThank.contains(expectedThank));
    }

    @When("Press on the remove for {string}")
    public void removeProductFromCartPage(String product) {
        switch (product) {
            case "Sauce Labs Bolt T-Shirt":
                pomYourCart.removeSauceLabsBoltTShirt().click();
                break;
            default:
                Assert.assertTrue("wrong name choose from products to remove", false);
        }
    }
    @Then("Assert {string} disappeared")
    public void assertProductDisappearAfterRemove(String product){
        try{
            pomYourCart.removeSauceLabsBoltTShirt();
            Assert.assertTrue("assert fail to remove product",false);
        }
        catch (Exception e){
            Assert.assertTrue("assert should success to remove product",true);
        }
    }

    @AfterStep
    public void afterStep() throws InterruptedException {
        Thread.sleep(10);
    }

    @After
    public void after() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
