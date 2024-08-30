import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {

    public WebElement number1(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[1]/div/div"));
    }

    public WebElement number2(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[2]/div/div"));
    }

    public WebElement plus(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[4]/div/div"));
    }

    public WebElement result(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
    }

    public WebElement equal(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));
    }

}
