package tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

/*
1. Invalid Product Search Test
Action: Search for a product that doesn’t exist (e.g., "abcdxyz").

Validation: Verify that the "no results" message is displayed.

2. Empty Search Submission
Action: Click on the search button without entering any product.

Validation: Validate that it either shows all products or an appropriate message.

Validation: Validate the error message "Warning: No match for E-Mail Address and/or Password."

3. Contact Us Form Submission Without Required Fields
Action: Submit the Contact Us form without filling in required fields.

Validation: Validate that appropriate validation messages are displayed.



 */
public class NegativeScenarios  extends BaseTest {

    @Description("Invalid Product Search Test")
    @Test
    public void invalidProductSearchTest(){

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.searchCamera();
        searchResultsPage.invalidProductSearch();

        String expectedText = "There is no product that matches the search criteria.";
        String actualText = searchResultsPage.invalidProductSearch();

        Assert.assertEquals(actualText,expectedText, "The mismatch happened!");

    }

    @Description("Empty Search Submission")
    @Test
    public void emptyProductSearchTest(){

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.emptyProductSearch();
        searchResultsPage.invalidProductSearch();

        String expectedText = "There is no product that matches the search criteria.";
        String actualText = searchResultsPage.invalidProductSearch();

        Assert.assertEquals(actualText,expectedText, "The mismatch happened!");

    }

    @Description("Submit the Contact Us form without filling in required fields")
    @Test
    public void invalidContactUsSubmission(){

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.contactUs();
        searchResultsPage.clickOnSubmit();

        String expectedErrorMessage = "Enquiry must be between 10 and 3000 characters!";
        String actualErrorMessage = searchResultsPage.clickOnSubmitErrorMessage();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage, "The error message failed to be matched!");

    }
}
