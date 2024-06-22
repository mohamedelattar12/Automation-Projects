package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
    WebDriver driver;
    String[] num = {"bkEvMb","N10B9","lVjWed","KN1kY","xAP7E","Ax5wH","abcgof","rk7bOd","T7PMFe","XoxYJ"};
    String[] op = {"XSr6wc","pPHzQc","YovRWb","WxTTNd","Pt8tGc"};
//  + --> 0
//  - --> 1
//  * --> 2
//  / --> 3
//  = --> 4

    public CalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigatPOM(){
        driver.navigate().to("https://www.google.com.eg/search?q=calculator");
    }

    public WebElement NumPOM(int index){
        return driver.findElement(By.cssSelector("div[jsname=\"" + num[index] + "\"]"));
    }

    public WebElement opPOM(int index){
        return driver.findElement(By.cssSelector("div[jsname=\"" + op[index] + "\"]"));
    }

    public WebElement resultPOM(){
        return driver.findElement(By.cssSelector("div[jsname=\"zLiRgc\"]"));
    }

}
