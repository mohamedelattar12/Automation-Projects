package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutYourInformation {

    WebDriver driver=null;
    public CheckoutYourInformation(WebDriver driver){
        this.driver=driver;
    }

    public WebElement pageTitle(){
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    }

    public WebElement firstnameField(){
        return driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
    }

    public WebElement lastnameField(){
        return driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
    }

    public WebElement postalcodeField(){
        return driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
    }

    public WebElement continuebutton(){
        return driver.findElement(By.xpath("//*[@id=\"continue\"]"));
    }

    public WebElement errorMessage(){
        return driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
    }


}
