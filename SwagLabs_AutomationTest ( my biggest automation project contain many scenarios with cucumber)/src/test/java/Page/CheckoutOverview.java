package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverview {
    WebDriver driver=null;
    public CheckoutOverview(WebDriver driver){
        this.driver=driver;
    }

    public WebElement pageTitle(){
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    }

    public String pageUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement totalprice(){
        return driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]"));
    }

    public WebElement finish(){
        return driver.findElement(By.xpath("//*[@id=\"finish\"]"));
    }


}
