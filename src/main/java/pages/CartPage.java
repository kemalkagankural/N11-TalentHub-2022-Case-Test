package pages;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    // Locators
    By chartBtnLocator=By.className("myBasket");
    By popupLocator=By.cssSelector("div.content div.btnHolder > span.btn.btnBlack");

    //This is go to Cart method
    public void goToCart(){
        chartBTN().click();
        Helper.waitFor(1);
        popupBTN().click();
    }


    public WebElement chartBTN(){return driver.findElement(chartBtnLocator);}
    public WebElement popupBTN(){return driver.findElement(popupLocator);}
}
