import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DropDowns2 {

    private WebDriver Driver = new EdgeDriver();

    @BeforeTest
    public void setUp() {
        Driver.manage().window().maximize();
    }

        //   First testCase : Check passenger number
        @Test(invocationCount = 20)
        public void testCase1 () throws Exception {
//      Navigate to the page
        SoftAssert soft = new SoftAssert();
        Driver.get("https://www.spicejet.com");
//      get the passenger element
        Driver.findElement(By.xpath("//div[text()='Passengers']")).click();
//      print the number of passengers
        System.out.println(Driver.findElement(By.xpath("//div[contains(text(),' Adult')]")).getText());
//      increase passenger to 5 and children to 3 ( default 1 ,0 )
        int i = 1;
        while (i < 5) {
            Driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
            i++;
            Thread.sleep(200);
        }
        for (int j = 1; j <= 3; j++) {
            Driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click();
            Thread.sleep(200);
        }
//////////////////////////////////////////////////////////////////////////
//      Press Done after choose number of passengers
            Thread.sleep(2000);
        Driver.findElement(By.xpath("//div[text()='Done']/..")).click();
        Thread.sleep(200);
//      print the number of passengers
        System.out.println(Driver.findElement(By.xpath("//div[contains(text(),' Adult')]")).getText());
        soft.assertEquals(Driver.findElement(By.xpath("//div[contains(text(),' Adult')]")).getText(), "5 Adults, 3 Children");


//      Choose Trip Type
        System.out.println(Driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[3]/div[2]/div[6]/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div")).getAttribute("style"));
//      choose Passenger Type
        Driver.findElement(By.cssSelector("#main-container > div > div.css-1dbjc4n.r-14lw9ot > div.css-1dbjc4n.r-14lw9ot.r-z2wwpe.r-vgw6uq.r-156q2ks.r-11ict49.r-8uuktl.r-136ojw6 > div.css-1dbjc4n.r-1pcd2l5.r-1uwte3a.r-m611by.r-bnwqim > div:nth-child(6) > div > div.css-1dbjc4n.r-1d09ksm.r-1inuy60.r-m611by > div:nth-child(2) > div > div:nth-child(1) > div > div > div:nth-child(1) > svg > circle")).click();

        soft.assertTrue(Driver.findElement(By.cssSelector("#main-container > div > div.css-1dbjc4n.r-14lw9ot > div.css-1dbjc4n.r-14lw9ot.r-z2wwpe.r-vgw6uq.r-156q2ks.r-11ict49.r-8uuktl.r-136ojw6 > div.css-1dbjc4n.r-1pcd2l5.r-1uwte3a.r-m611by.r-bnwqim > div:nth-child(6) > div > div.css-1dbjc4n.r-1d09ksm.r-1inuy60.r-m611by > div:nth-child(2) > div > div:nth-child(1) > div > div > div:nth-child(1) > svg > g > circle:nth-child(1)")).getAttribute("stroke").contains("#F7941D"));
        Thread.sleep(200);

//      Chooose Currency And Assert It ....
        Driver.findElement(By.xpath("//div[contains(text(),'Currency')]")).click();
        Thread.sleep(200);
        Driver.findElement(By.xpath("//div[contains(text(),'USD')]")).click();
        Thread.sleep(200);
        System.out.println(Driver.findElement(By.xpath("//div[contains(text(),'USD')]")).getText());
        soft.assertEquals(Driver.findElement(By.xpath("//div[contains(text(),'USD')]")).getText(), "USD");

//      Choose DesTination
        Driver.findElement(By.xpath("//div[contains(text(),'From')]")).click();
        Thread.sleep(200);
//      choose from field
        Driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();
        Thread.sleep(200);
//      choose the to field
        Driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[10]")).click();
        Thread.sleep(200);
        //Select go Date
        Driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[4]")).click();
        Thread.sleep(200);
//        select return date
        Driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[2]/div[2]")).click();
        Thread.sleep(200);
        Driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[4]/div[7]/div/div")).click();
        Thread.sleep(200);
        //      press search
        Driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[3]/div[2]/div[7]/div[2]/div")).click();
        System.out.println("Done");

        soft.assertAll();
    }



    @AfterTest
    public void afterTest() throws Exception {
        Thread.sleep(5000);
        Driver.quit();
    }

}
