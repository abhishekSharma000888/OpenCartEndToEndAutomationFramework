package tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class PositiveScenarios extends BaseTest {

    /*
    1. Valid Product Search Test
Search for a valid product (e.g., "iPhone")

Validate that the product appears in the search results.

2. Navigate to Product Page and Validate
Click on a product from the search results.

Validate that the product page loads and the correct product name is displayed.

3. Add Product to Cart and Validate Cart
Add the product to the cart from the product page.

Navigate to the cart page.

Validate that the correct product is added to the cart.

4. Navigate to Login Page
From the home page, go to My Account → Login.

Validate that the login page is loaded successfully.

Validate that the page title is "Account Login" or similar.

5. Contact Us Page Navigation
Click on Contact Us link from the footer or menu.

Validate that the contact page loads with the correct header.

6. Check Cart from Home Page
After adding a product to the cart, go to the home page.

Click on the cart button (top right).

Validate that the cart preview shows the correct product.


     */

    @Description("Valid Product Search Test")
    @Test
    public void validProductSearchTest() {

        HomePage homePage = new HomePage(driver);
        homePage.searchIphone();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        // Verify the iPhone is displayed
        Assert.assertTrue(searchResultsPage.isIphoneDisplayed(), "The iPhone is not displayed in the search results!");

        // Verify the product text matches
        String expectedIphoneText = "iPhone";
        String actualIphoneText = searchResultsPage.getIphoneText();

        Assert.assertEquals(actualIphoneText, expectedIphoneText, "The product name does not match!");
    }


    @Description("Validate click on a product from the search results and verify URL")
    @Test
    public void validateClickOnAProduct() {

        HomePage homePage = new HomePage(driver);
        homePage.searchIphone();

        // Validate search result URL
        String expectedSearchUrl = "https://awesomeqa.com/ui/index.php?route=product/search&search=iphone";
        String actualSearchUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualSearchUrl.toLowerCase(), expectedSearchUrl.toLowerCase(), "Search result URL does not match!");

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickOnProduct();

        // Validate product detail URL using 'contains' to handle additional parameters
        String expectedProductUrl = "https://awesomeqa.com/ui/index.php?route=product/product&product_id=40";
        String actualProductUrl = driver.getCurrentUrl();

        // Assert that the core product URL is present
        Assert.assertTrue(actualProductUrl.contains(expectedProductUrl), "Product detail URL does not match the expected core structure!");

        searchResultsPage.addDeviceToTheCart();
    }




}
