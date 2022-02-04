package testRunner;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import utils.ReturnToThePreviousPage;
import utils.BuyProcess;
import utils.ProductDetailPage;
import utils.TypeInformation;

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
        productDetailPage.selectProducts(1);
        returnToThePreviousPage =new ReturnToThePreviousPage(driver);
        returnToThePreviousPage.doubleBack();
        Helper.waitFor(1);
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
        Helper.waitFor(1);
    }
    @Test
    @Order(4)
    public void set_purchase_details() {
        buyProcess = new BuyProcess(driver);
        Helper.waitFor(2);
        buyProcess.productPrice();
        buyProcess.buyProduct();
        Helper.waitFor(2);
    }
    @Test
    @Order(5)
    public void enter_customer_information(){
        typeInformation=new TypeInformation(driver);
        typeInformation.typeInformations("test tester","448076033","38547468106","ev","14.sokak no:62");
        Helper.waitFor(1);
        typeInformation.selectAdressDetails();
        Helper.waitFor(3);
        buyProcess.payment();
        Helper.waitFor(1);
    }
    @Test
    @Order(6)
    public void enter_payment_infomation(){
        Helper.waitFor(1);
        typeInformation.enterPaymentInformation();
        Helper.waitFor(5);
        Assertions.assertTrue(typeInformation.isErrorMessage(),"Your credit card information is false!");
        try {
            if(typeInformation.isErrorMessage()==true){
                System.out.println("Your credit card information is false!");
            }
        }catch (Exception error){
            System.out.println("Not enter credit card information!");
        }
    }
}