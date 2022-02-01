package testRunner;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import tasks.ReturnToThePreviousPage;
import tasks.BuyProcess;
import tasks.ProductDetailPage;
import tasks.TypeInformation;

public class Test_Case_2_Search_Product extends BaseTest {
    HomePage homePage ;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    ReturnToThePreviousPage returnToThePreviousPage;
    CartPage cartPage;
    BuyProcess buyProcess;
    TypeInformation typeInformation;

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
        productDetailPage.selectProducts(2);
        returnToThePreviousPage =new ReturnToThePreviousPage(driver);
        returnToThePreviousPage.doubleBack();
        Helper.waitFor(1);
        productDetailPage.selectProducts(5);
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
        Helper.waitFor(1);
    }
    @Test
    @Order(4)
    public void buy_the_products(){
        buyProcess=new BuyProcess(driver);
        Helper.waitFor(2);
        buyProcess.productPrice();
        buyProcess.buyProduct();
        Helper.waitFor(2);
        typeInformation=new TypeInformation(driver);
        typeInformation.typeInformations("test tester","448076033","38547468106","ev");
        Helper.waitFor(1);
        typeInformation.selectAdressDetails();
    }
}
