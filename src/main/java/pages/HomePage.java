package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void searchIphone() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@placeholder=\"Search\"]"));
        searchBox.clear();
        searchBox.sendKeys("iPhone");

        WebElement searchButton = driver.findElement(By.xpath("//*[@class=\"input-group-btn\"]"));
        searchButton.click();
    }

    public void contactUs(){

        WebElement contactUs = driver.findElement(By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a"));

        contactUs.click();
    }

    public String contactUsHeaderText(){

        WebDriverWait contactUsHeaderTextWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement contactUsHeaderText = contactUsHeaderTextWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1")));

        return contactUsHeaderText.getText();

    }

    public void searchCamera() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@placeholder=\"Search\"]"));
        searchBox.clear();
        searchBox.sendKeys("camera");

        WebElement searchButton = driver.findElement(By.xpath("//*[@class=\"input-group-btn\"]"));
        searchButton.click();
    }

    public void emptyProductSearch(){

        WebElement searchButton = driver.findElement(By.xpath("//*[@class=\"input-group-btn\"]"));
        searchButton.click();
    }

}
