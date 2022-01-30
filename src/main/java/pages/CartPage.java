package pages;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By chartPageLocator=By.cssSelector("section.basket.box.box--medium:nth-child(3) > h3.box__title:nth-child(1)");
    By chartBtnLocator=By.className("myBasket");
    By popupLocator=By.cssSelector("div.content div.btnHolder > span.btn.btnBlack");


    public void goToCart(){
        chartBTN().click();
        Helper.waitFor(1);
        popupBTN().click();
    }


    public boolean isCartPage() {
        return isDisplayed(chartPageLocator);
    }
    public WebElement chartBTN(){return driver.findElement(chartBtnLocator);}
    public WebElement popupBTN(){return driver.findElement(popupLocator);}
}
