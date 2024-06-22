import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLogin{
    WebDriver driver = new EdgeDriver();
    Pom pom=new Pom(driver);
    SoftAssert soft = new SoftAssert();
    int time =50;

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void PositiveLogInTest() throws Exception{
//        Send "student" in user name field
        pom.userName().sendKeys("student");
        Thread.sleep(time);
//        Send "Password123" in password field
        pom.passWord().sendKeys("Password123"); Thread.sleep(time);
//        Press Submit button
        pom.subMit().click(); Thread.sleep(time);
//        make a string contain the expected new url
        String expectedNewPageUrl = "practicetestautomation.com/logged-in-successfully/";
//        make a string contain the atual new url
        String atualNewPageUrl = driver.getCurrentUrl();
//        assert the new Url
        soft.assertTrue(atualNewPageUrl.contains(expectedNewPageUrl),"New page url assert");
//        make a string contain the expected congratulation message
        String expectedCongratulation1 = "Congratulations";
        String expectedCongratulation2 = "successfully logged in";
//        make a string contain the actual congratulation message
        String actualCongratulation = pom.congratulation().getText();
//        Assert the congratulation message
        soft.assertTrue(actualCongratulation.contains(expectedCongratulation1)||actualCongratulation.contains(expectedCongratulation2),"congratulation message assert");
//        Assert Logout button is displayed
        soft.assertTrue(pom.logOut().isDisplayed(),"log out is displayed assert");
        soft.assertAll();;
    }

    @Test
    public void negativeUserNameTest() throws InterruptedException {
//        Send "incorrectUser" in user name field
        pom.userName().sendKeys("incorrectUser");Thread.sleep(time);
//        Send "Password123" in password field
        pom.passWord().sendKeys("Password123");Thread.sleep(time);
//        Press Submit button
        pom.subMit().click();Thread.sleep(time);
//      Veryfy error message is displayed
        soft.assertTrue(pom.errorMessage().isDisplayed(), "error message is displayed");
//        Error message expected result
        String expectedErrormessage = "Your username is invalid!";
//        Error message actual result
        String actualErrormessage = pom.errorMessage().getText();
//        Assert the error message
        soft.assertTrue(actualErrormessage.contains(expectedErrormessage));
        soft.assertAll();
    }

    @Test
    public void negativePasswordTest() throws InterruptedException {
//        Send "student" in user name field
        pom.userName().sendKeys("student");Thread.sleep(time);
//        Send "incorrectPassword" in password field
        pom.passWord().sendKeys("incorrectPassword");Thread.sleep(time);
//        Press Submit button
        pom.subMit().click();Thread.sleep(time);
//      Veryfy error message is displayed
        soft.assertTrue(pom.errorMessage().isDisplayed(), "error message is displayed");
//        Error message expected result
        String expectedErrormessage = "Your password is invalid!";
//        Error message actual result
        String actualErrormessage = pom.errorMessage().getText();
//        Assert the error message
        soft.assertTrue(actualErrormessage.contains(expectedErrormessage),"assert error message");
        soft.assertAll();
    }

    @AfterTest
    public void afterTest()throws Exception{
        Thread.sleep(5000);
        driver.quit();
    }

}
