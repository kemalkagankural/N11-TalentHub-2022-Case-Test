package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BasePage {

    public WebDriver driver ;


    public BasePage(WebDriver driver){
        this.driver = driver ;
    }

    // Those are web driver methods.I create like that because I can use every where.
    public WebElement find(By locator){return driver.findElement(locator);}
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void type(By locator , String text){
        find(locator).sendKeys(text);
    }
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    public Boolean isEnabled(By locator){return find(locator).isEnabled();}
}
