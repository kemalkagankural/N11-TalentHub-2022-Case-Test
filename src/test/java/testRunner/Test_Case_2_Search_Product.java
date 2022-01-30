package testRunner;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import utils.BackTo;
import utils.ProductDetailPage;

public class Test_Case_2_Search_Product extends BaseTest {
    HomePage homePage ;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    BackTo backTo;
    CartPage cartPage;

    @Test
    @Order(1)
    public void search_a_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage= new ProductsPage(driver);
        homePage.searchBox().search("ayfon");
        Helper.waitFor(1);
        Assertions.assertTrue(productsPage.isOnProductPage(),
                "Not on products page!");
        try {
            if(productsPage.isOnProductPage()==true){
                System.out.println("You are in product page after search.");
            }
        }catch (Exception error){
            System.out.println("Not on products page!");
        }
    }
    @Test
    @Order(2)
    public void add_products_to_cart(){
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.selectProducts(1);
        backTo=new BackTo(driver);
        backTo.doubleBack();
        Helper.waitFor(3);
        productDetailPage.selectProducts(28);
        Assertions.assertTrue(productDetailPage.isOnCart(),"Not add a product!");
        try {
            if(productDetailPage.isOnCart()==true){
                System.out.println("You add to products");
            }
        }catch (Exception error){
            System.out.println("Not add products!");
        }
    }
    @Test
    @Order(3)
    public void  check_to_cart(){
        cartPage=new CartPage(driver);
        cartPage.goToCart();
        Helper.waitFor(5);
        Assertions.assertTrue(cartPage.isCartPage(),"Not add a product!");
        try {
            if(cartPage.isCartPage()==true){
                System.out.println("You are on Cart Page");
            }
        }catch (Exception error){
            System.out.println("Not on Cart Page!");
        }

    }
    @Test
    @Order(4)
    public void buy_the_products(){

    }
}
