import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WhatsappChat {

    WebDriver driver= new EdgeDriver();
    googleElements gElements = new googleElements();
    CalculatorPage calculatorPage= new CalculatorPage();

    @BeforeMethod
    public void beforeEverytest(){
        driver.get("https://www.google.com/");
        gElements.searchButton(driver).sendKeys("calculator");
        gElements.searchButton(driver).sendKeys(Keys.ENTER);
    }

    @Test
    public void checkAddition(){
        calculatorPage.number1(driver).click();
        calculatorPage.plus(driver).click();
        calculatorPage.number2(driver).click();
        calculatorPage.equal(driver).click();
        String expectedResult="3";
        String actualResult= calculatorPage.result(driver).getText();
        Assert.assertEquals(expectedResult,actualResult,"assertion for ADD");
    }


@AfterTest
    public void end()  {
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){}
        driver.quit();
}
}
