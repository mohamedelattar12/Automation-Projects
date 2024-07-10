package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String pageUrl() {
        return driver.getCurrentUrl();
    }

    ////////////////////////////////////
    public WebElement sortingDropDown() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
    }

    public WebElement nameAtoZ() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]"));
    }

    public WebElement nameZtoA() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]"));
    }

    public WebElement nameLowtoHigh() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]"));
    }

    public WebElement nameHightoLow() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]"));
    }

    ////////////////////////////////////
    public WebElement fistProduct() {
        return driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]"));
    }

    public WebElement secondProduct() {
        return driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[2]"));
    }

    public WebElement thirdProduct() {
        return driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[2]"));
    }

    /////////////////////////////////////////////////////////////////////////////////
    public WebElement sauceLabsBackpackAdd() {
        return driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
    }
    public WebElement sauceLabsBackpackImage() {
        return driver.findElement(By.xpath("//*[@id=\"item_4_img_link\"]/img"));
    }
    public WebElement sauceLabsBikeLightAdd() {
        return driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
    }

    public WebElement sauceLabsBoltTShirt() {
        return driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
    }

    public WebElement sauceLabsFleeceJacket() {
        return driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public WebElement cartNumber() {
        return driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
    }

    public WebElement cartIcon() {
        return driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
    }

    public WebElement cartPageTitle() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    }

    public WebElement fistProductPrice() {
        return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div"));
    }

    public WebElement secondProductPrice() {
        return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div"));
    }

    public WebElement thirdProductPrice() {
        return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/div"));
    }

    public WebElement searchField() {
        return null;
    }

}

