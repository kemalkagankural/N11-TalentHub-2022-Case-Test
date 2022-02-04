
package testRunner;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import utils.ProductSearchFilter;
import pages.ProductsPage;

public class Test_Case_3_Search_Filtering extends BaseTest {

    HomePage homePage ;
    ProductsPage productsPage;
    ProductSearchFilter productSearchFilter;


    @Test
    @Order(1)
    public void search_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage= new ProductsPage(driver);
        homePage.searchBox().search("telefon");
        Assertions.assertTrue(productsPage.isOnProductPage(),
                "Not on products page!");
    }
    @Test
    @Order(2)
    public void filter_to_search() throws InterruptedException {
        productSearchFilter= new ProductSearchFilter(driver);
        productSearchFilter.clickFilter();
        Assertions.assertTrue(productsPage.isOnProductPage(),
                "Not on products page!");
        Helper.waitFor(1);
    }



}

