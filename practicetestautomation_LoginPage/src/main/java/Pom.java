import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Pom {
    WebDriver driver = null;

    Pom(WebDriver driver){
        this.driver= driver;
    }

    public WebElement userName(){
        return driver.findElement(By.xpath("//*[@id=\"username\"]"));
    }

    public WebElement passWord(){
        return driver.findElement(By.xpath("//*[@id=\"password\"]"));
    }

    public WebElement subMit(){
        return driver.findElement(By.xpath("//*[@id=\"submit\"]"));
    }

    public WebElement congratulation(){
        return driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/p[1]/strong"));
    }

    public WebElement logOut(){
        return driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));
    }

    public WebElement errorMessage(){
        return driver.findElement(By.xpath("//*[@id=\"error\"]"));
    }

}
