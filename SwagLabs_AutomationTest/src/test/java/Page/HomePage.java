package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver= null;

    public HomePage(WebDriver driver){
        this.driver= driver;
    }

    public String pageUrl(){
        return driver.getCurrentUrl();
    }




}

