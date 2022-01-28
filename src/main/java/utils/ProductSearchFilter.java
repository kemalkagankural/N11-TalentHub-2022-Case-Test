package utils;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;


public class ProductSearchFilter extends BasePage {
    By filtercheckboxLocator = new By.ById("brand-m-Samsung");
    By sortoptionsLocator=By.id("sortingType");
    By freeshippingcheckboxLocator=By.id("freeShippingOption");
    //Select

    public ProductSearchFilter(WebDriver driver) {
        super(driver);
    }

    public void clickFilter() {
        clickCheckbox().click();
        Helper.waitFor(1);
        clickSortOp().click();
        Helper.waitFor(1);
        Select sortselect = new Select(clickSortOp());
        Helper.waitFor(1);
        sortselect.selectByVisibleText("Yorum sayısı");
        Helper.waitFor(1);
        clickFreeShipping().click();
    }


    public WebElement clickCheckbox(){
        return driver.findElement(filtercheckboxLocator);}
    public WebElement clickSortOp(){
        return driver.findElement(sortoptionsLocator);}
    public WebElement clickFreeShipping(){
        return driver.findElement(freeshippingcheckboxLocator);}


}
