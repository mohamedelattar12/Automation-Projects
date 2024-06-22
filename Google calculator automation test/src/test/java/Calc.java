import org.example.CalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Calc {
//    public static void main(String[] args) throws Exception {
        //C:\Users\ahmedroushdy\Desktop\JavaTasks\ElattarProj\src\main\resources
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = null;
        SoftAssert soft = null;
        CalculatorPage calcPage;
        int add=0,sub=1,mul=2,div=3,equal=4;

    @BeforeTest
    public void openBrowser (){
        driver = new ChromeDriver();
        soft = new SoftAssert();
        calcPage = new CalculatorPage(driver);

//        WebElement search = driver.findElement(By.className("gLFyf"));
//        search.sendKeys("Calculator");
//        search.sendKeys(Keys.ENTER);
    }

    @BeforeMethod
    public void nav(){
        calcPage.navigatPOM();
    }

    @Test
    public void testCase1 () throws InterruptedException {

        Thread.sleep(1000);

        calcPage.NumPOM(5).click();  // 5
        calcPage.opPOM(add).click(); // +
        calcPage.NumPOM(4).click();  // 4
        calcPage.opPOM(equal).click(); // =

        String actual = calcPage.resultPOM().getText();
        soft.assertEquals(actual,"9","Addition Fail");
        System.out.println("first assert");
        soft.assertAll();
    }

    @Test
    public void testCase2 () throws InterruptedException {

        Thread.sleep(1000);

        calcPage.NumPOM(5).click();  // 5
        calcPage.opPOM(sub).click(); // -
        calcPage.NumPOM(4).click();  // 4
        calcPage.opPOM(equal).click(); // =

        String actual = calcPage.resultPOM().getText();
        soft.assertEquals(actual,"1","Subtraction Fail");
        System.out.println("second assert");
        soft.assertAll();
    }

    @Test
    public void testCase3 () throws InterruptedException {

        Thread.sleep(1000);

        calcPage.NumPOM(5).click();  // 5
        calcPage.opPOM(mul).click(); // *
        calcPage.NumPOM(4).click();  // 4
        calcPage.opPOM(equal).click(); // =

        String actual = calcPage.resultPOM().getText();
        soft.assertEquals(actual,"20","Multiplication Fail");
        System.out.println("third assert");
        soft.assertAll();
    }

    @Test
    public void testCase4 () throws InterruptedException {

        Thread.sleep(1000);

        calcPage.NumPOM(5).click();  // 5
        calcPage.opPOM(div).click(); // /
        calcPage.NumPOM(4).click();  // 4
        calcPage.opPOM(equal).click(); // =

        String actual = calcPage.resultPOM().getText();
        soft.assertEquals(actual,"1.25","Division Fail");
        System.out.println("fourth assert");
        soft.assertAll();
    }

    @AfterTest
    public void closeBrowser (){
        driver.quit();

    }
//  }
}
