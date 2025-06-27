package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
