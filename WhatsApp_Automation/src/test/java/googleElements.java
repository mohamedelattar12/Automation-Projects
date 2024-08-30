import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleElements {
    WebDriver driver=null;



    public WebElement searchButton(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
    }
}
