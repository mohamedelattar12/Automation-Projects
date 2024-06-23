import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Pom {
    WebDriver driver =null;

    Pom(WebDriver driver){
        this.driver = driver;
    }

    public WebElement Add(){
        return driver.findElement(By.id("add_btn"));
    }

    public WebElement confirmationMessage(){
        return driver.findElement(By.id("confirmation"));
    }



}
