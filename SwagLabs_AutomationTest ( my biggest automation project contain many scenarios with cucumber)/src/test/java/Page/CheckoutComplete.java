package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutComplete {
    WebDriver driver=null;
    public CheckoutComplete(WebDriver driver){
        this.driver=driver;
    }

    public String pageTitle(){
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    }

    public String thankYouMessage(){
        return driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
    }



}
