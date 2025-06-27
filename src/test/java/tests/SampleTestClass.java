package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class SampleTestClass extends BaseTest {

    @Test
    public void searchProductTest() {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("iPhone");
    }
}