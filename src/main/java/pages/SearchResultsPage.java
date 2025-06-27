package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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


    public void addProductToTheCart(){

        WebElement addToTheCart = driver.findElement(By.xpath("//button[@id='button-cart']"));
        addToTheCart.click();

    }

    public void clickOnCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Wait for the cart button to be visible and click
        WebElement cartButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']"))
        );
        cartButton.click();

        // Wait for the 'View Cart' button to be visible and click
        WebElement viewCartButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='https://awesomeqa.com/ui/index.php?route=checkout/cart']/strong"))
        );
        viewCartButton.click();
    }

    public void clickOnMyAccount(){

        WebDriverWait MyAccountWait = new WebDriverWait(driver,Duration.ofSeconds(2));
        WebElement MyAccountTab = MyAccountWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top\"]/div/div/ul/li[2]/a")));

        MyAccountTab.click();

        WebElement loginButton = driver.findElement(By.xpath("//*[@href=\"https://awesomeqa.com/ui/index.php?route=account/login\"]"));
        loginButton.click();


        }

    public String LoginPageValidation() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement loginPageHeading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New Customer']"))
        );

        Assert.assertTrue(loginPageHeading.isDisplayed(), "Login Page is not displayed correctly!");

        return driver.getCurrentUrl();
    }




}


