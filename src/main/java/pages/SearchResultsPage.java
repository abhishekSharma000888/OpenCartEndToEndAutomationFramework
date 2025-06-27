package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {


    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchResultText() {
        WebElement resultHeader = driver.findElement(By.cssSelector("h1")); // You can customize this locator
        return resultHeader.getText();
    }

    public boolean isIphoneDisplayed() {
        WebElement iphoneElement = driver.findElement(By.xpath("//*[@class=\"caption\"]/h4/a"));
        return iphoneElement.isDisplayed();
    }

    public String getIphoneText() {
        WebElement iphoneElement = driver.findElement(By.xpath("//*[@class=\"caption\"]/h4/a"));
        return iphoneElement.getText();
    }

    public void clickOnProduct(){

        WebElement productClick = driver.findElement(By.xpath("//*[@title=\"iPhone\"]"));
        productClick.click();
    }


    public void addDeviceToTheCart(){

        WebElement addToTheCart = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
        addToTheCart.click();
    }

}
