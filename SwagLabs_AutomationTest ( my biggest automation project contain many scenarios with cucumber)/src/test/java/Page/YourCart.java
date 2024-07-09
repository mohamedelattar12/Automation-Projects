package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCart {
    WebDriver driver=null;

    public YourCart(WebDriver driver){
        this.driver=driver;
    }

    public WebElement removeSauceLabsBoltTShirt(){
        return driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]"));
    }


    public WebElement checkOut(){
        return driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
    }

    public WebElement cartPageTitle(){
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    }

}
