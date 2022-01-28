package testRunner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductsPage;

public class Test_Case_2_Search_Product extends BaseTest {
    HomePage homePage ;
    ProductsPage productsPage;

    @Test
    @Order(1)
    public void search_a_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage= new ProductsPage(driver);
        homePage.searchBox().search("ayfon");
        Assertions.assertTrue(productsPage.isOnProductPage(),
                "Not on products page!");
    }
}
