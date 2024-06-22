import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.InputEvent;

public class main {
    private WebDriver driver = new ChromeDriver();
    protected int time=100;
    private final int count = 2;

    @BeforeTest
    public void OpenBrowser() {
//        System.setProperty("webdriver.chrome.driver","\"G:\\engineering\\courses\\Software_testing\\Java\\chromedriver-win32\\chromedriver.exe\"");
    }

    // test1 : test the Add function for Google calculator
    @Test(invocationCount = count)
    public void Add() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
//      get the link to the calculator
        driver.get("https://www.google.com/search?q=calculator&oq=calculator&gs_lcrp=EgZjaHJvbWUyEQgAEEUYORhDGLEDGIAEGIoFMgcIARAAGIAEMgwIAhAAGBQYhwIYgAQyCggDEAAYsQMYgAQyBwgEEAAYgAQyBwgFEAAYgAQyBwgGEAAYgAQyBwgHEAAYgATSAQg0MTQxajBqMagCALACAQ&sourceid=chrome&ie=UTF-8");
//      get the element of the fisrt calc button
        WebElement b1 = driver.findElement(By.cssSelector("div[jsname=\"T7PMFe\"][class=\"XRsWPe AOvabd\"]")); // 8
//      get the element of the second calc button
        WebElement b2 = driver.findElement(By.cssSelector("div[jsname=\"XoxYJ\"]"));   //9
//      get the element of the Equal calc button
        WebElement bE = driver.findElement(By.cssSelector("div[jsname=\"Pt8tGc\"]"));  // Equal
//      get the element of the Add calc button
        WebElement bA = driver.findElement(By.cssSelector("div[jsname=\"XSr6wc\"]"));  // add
//      get the display screen result
        WebElement result = driver.findElement(By.cssSelector("div[jsname=\"zLiRgc\"]")); // display
//      Perform actions
        b1.click();
        Thread.sleep(time);
        bA.click();
        Thread.sleep(time);
        b2.click();
        Thread.sleep(time);
        bE.click();
        Thread.sleep(time);
        //////////////////////////////////////////////
        String expectedResult = "17";
        String actualResult = result.getText();
//      assert the result is correct
        softAssert.assertTrue(actualResult.contains(expectedResult), "testCase1");
        softAssert.assertAll();

    }

    //    test2: assertion the multiple function 8*9
    @Test(invocationCount = count)
    public void multiply() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
//        get the calc link
        driver.get("https://www.google.com/search?q=calculator&oq=calculator&gs_lcrp=EgZjaHJvbWUyEQgAEEUYORhDGLEDGIAEGIoFMgcIARAAGIAEMgwIAhAAGBQYhwIYgAQyCggDEAAYsQMYgAQyBwgEEAAYgAQyBwgFEAAYgAQyBwgGEAAYgAQyBwgHEAAYgATSAQg0MTQxajBqMagCALACAQ&sourceid=chrome&ie=UTF-8");
//        get the first number button
        WebElement b1 = driver.findElement(By.cssSelector("div[jsname=\"T7PMFe\"][class=\"XRsWPe AOvabd\"]")); // 8
//        get the second number element
        WebElement b2 = driver.findElement(By.cssSelector("div[jsname=\"XoxYJ\"]"));   //9
//        fet the Equal button
        WebElement bE = driver.findElement(By.cssSelector("div[jsname=\"Pt8tGc\"]"));  // Equal
//        get the multiple element
        WebElement bM = driver.findElement(By.cssSelector("#rso > div.ULSxyf > div > div > div > div.card-section > div > div > div.SKWP2e > div > table.ElumCf > tbody > tr:nth-child(3) > td:nth-child(4) > div > div"));  // multiply
//        get the display result element
        WebElement result = driver.findElement(By.cssSelector("div[jsname=\"zLiRgc\"]")); // display

//      perform actions
        b1.click();
        Thread.sleep(time);
        bM.click();
        Thread.sleep(time);
        b2.click();
        Thread.sleep(time);
        bE.click();
        Thread.sleep(time);

        String actualResult = result.getText();
        String expectedResult = "72";
//      assert that the answer is correct
        soft.assertTrue(actualResult.contains(expectedResult), "testCase2 right answer");
//        assert that the display contain 8x9=
        soft.assertTrue(driver.findElement(By.cssSelector("span[jsname=\"ubtiRe\"]")).getText().contains("8 × 9 ="), "testCase2 result screen displayed correctly");

        soft.assertAll();
    }


    @Test(invocationCount = count)
    public void substract() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
//        get the calc link
        driver.get("https://www.google.com/search?q=calculator&oq=calculator&gs_lcrp=EgZjaHJvbWUyEQgAEEUYORhDGLEDGIAEGIoFMgcIARAAGIAEMgwIAhAAGBQYhwIYgAQyCggDEAAYsQMYgAQyBwgEEAAYgAQyBwgFEAAYgAQyBwgGEAAYgAQyBwgHEAAYgATSAQg0MTQxajBqMagCALACAQ&sourceid=chrome&ie=UTF-8");
//        get the first number button
        WebElement b1 = driver.findElement(By.cssSelector("div[jsname=\"T7PMFe\"][class=\"XRsWPe AOvabd\"]")); // 8
//        get the second number element
        WebElement b2 = driver.findElement(By.cssSelector("div[jsname=\"XoxYJ\"]"));   //9
//        fet the Equal button
        WebElement bE = driver.findElement(By.cssSelector("div[jsname=\"Pt8tGc\"]"));  // Equal
//        get the subtraction element
        WebElement bM = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[4]/div/div"));  // substract
//        get the display result element
        WebElement result = driver.findElement(By.cssSelector("div[jsname=\"zLiRgc\"]")); // display

//      perform actions
        b1.click();
        Thread.sleep(time);
        bM.click();
        Thread.sleep(time);
        b2.click();
        Thread.sleep(time);
        bE.click();
        Thread.sleep(time);

        String actualResult = result.getText();
        String expectedResult = "-1";
//      assert that the answer is correct
        soft.assertTrue(actualResult.contains(expectedResult), "testCase2 right answer");
//        assert that the display contain 8 - 9 =
        soft.assertTrue(driver.findElement(By.cssSelector("span[jsname=\"ubtiRe\"]")).getText().contains("8 - 9 ="), "testCase2 result screen displayed correctly");

        soft.assertAll();
    }

    @Test(invocationCount = count)
    public void devide() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
//        get the calc link
        driver.get("https://www.google.com/search?q=calculator&oq=calculator&gs_lcrp=EgZjaHJvbWUyEQgAEEUYORhDGLEDGIAEGIoFMgcIARAAGIAEMgwIAhAAGBQYhwIYgAQyCggDEAAYsQMYgAQyBwgEEAAYgAQyBwgFEAAYgAQyBwgGEAAYgAQyBwgHEAAYgATSAQg0MTQxajBqMagCALACAQ&sourceid=chrome&ie=UTF-8");
//        get the first number button
        WebElement b1 = driver.findElement(By.cssSelector("div[jsname=\"T7PMFe\"][class=\"XRsWPe AOvabd\"]")); // 8
//        get the second number element
        WebElement b2 = driver.findElement(By.cssSelector("div[jsname=\"XoxYJ\"]"));   //9
//        fet the Equal button
        WebElement bE = driver.findElement(By.cssSelector("div[jsname=\"Pt8tGc\"]"));  // Equal
//        get the devide element
        WebElement bM = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[4]/div/div"));  // devide
//        get the display result element
        WebElement result = driver.findElement(By.cssSelector("div[jsname=\"zLiRgc\"]")); // display

//      perform actions
        b1.click();
        Thread.sleep(time);
        bM.click();
        Thread.sleep(time);
        b2.click();
        Thread.sleep(time);
        bE.click();
        Thread.sleep(time);

        String actualResult = result.getText();
        String expectedResult = "0.88888888888";
//      assert that the answer is correct
        soft.assertTrue(actualResult.contains(expectedResult), "testCase2 right answer");
//        assert that the display contain 8 ÷ 9 =
        soft.assertTrue(driver.findElement(By.cssSelector("span[jsname=\"ubtiRe\"]")).getText().contains("8 ÷ 9 ="), "testCase2 result screen displayed correctly");

        soft.assertAll();
    }


    @AfterTest
    public void close() throws Exception {
        Thread.sleep(1500);
        driver.quit();
//        // Create an instance of Robot class
//        Robot robot = new Robot();
//
//        // Get the screen size
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int height = screenSize.height;
//        int width = screenSize.width;
//        System.out.println(width);
//        System.out.println(height);
//
//        // Move the mouse to the edge down of the screen
//        robot.mouseMove((int)(970/1.25) , (int)(1060/1.25));
//        Thread.sleep(100);
//        // Perform a left-click
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(100);
//        // Move the mouse to the middle of the screen
//        robot.mouseMove(width/2 , height/2);
//
//        // Perform a right-click
//        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
//        Thread.sleep(100);
    }

}
