package utils;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.awt.*;
import java.util.List;

public class ProductDetailPage extends BasePage {

    By addToCartButtonLocator = By.cssSelector("div.product-add-cart > a.btn.btnGrey.addBasketUnify");
    By addedToCartNotificationLocator=By.cssSelector("span.basketTotalNum");



    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }
    public boolean isOnCart() {
        return isDisplayed(addedToCartNotificationLocator);
    }
    public void addToCart() {
        click(addToCartButtonLocator);
    }




    public void selectProducts(int i){
        getAllProducts(i).click();
        Helper.waitFor(2);
        addToCart();
        Helper.waitFor(2);
    }


    public WebElement getAllProducts(int i){
        By allProductsLocator =By.cssSelector(" li.column:nth-child("+i+")  div.columnContent:nth-child(2) div.pro > a.plink");
        return driver.findElement(allProductsLocator);
    }

}
