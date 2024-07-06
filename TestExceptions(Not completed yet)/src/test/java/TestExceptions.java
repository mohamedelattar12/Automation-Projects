import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestExceptions {
    WebDriver driver= new EdgeDriver();
    Pom pom = new Pom(driver);
    SoftAssert soft= new SoftAssert();

    @BeforeMethod
    public void beforeTest(){
//    Open page
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @Test
    public void noSuchElementException() throws Exception{
//        Click Add button
        pom.Add().click();
//        Verify Row 2 input field is displayed
       try{
           if(!pom.confirmationMessage().isDisplayed()){
               throw new NoSuchElementException("Row 2 input field not found!");
           }
       }
       catch (Exception e){
           e.printStackTrace();
        }
        soft.assertAll();
    }

    @Test(invocationCount = 10)
    public void elementNotInteractableException() throws InterruptedException {
//        Click Add button
    pom.Add().click();
//  Wait for the second row to load
        int x=0;
        while(true){
            if ( pom.confirmationMessage().isDisplayed() || x==1000 ){
                break;
            } else {
                Thread.sleep(1);
                x++;
            }
        }
        System.out.println(x);
        soft.assertTrue(pom.confirmationMessage().isDisplayed(),"confirmation message");


        soft.assertAll();
    }


    @AfterTest
    public void afterTest()throws Exception{
        Thread.sleep(500);
        driver.quit();
    }

}
