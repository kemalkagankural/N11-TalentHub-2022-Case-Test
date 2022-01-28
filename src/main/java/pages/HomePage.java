package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    SearchBox searchBox ;
    By acceptCookiesLocator =  By.xpath("//body/div[@id='cookieUsagePopIn']/span[1]");
    By homePageLocator= By.cssSelector("div.content:nth-child(4) > div.container");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }
    public boolean isHomePage() {
        return isDisplayed(homePageLocator);
    }




    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }
}
