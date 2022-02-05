package utils;


import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import java.io.IOException;


public class CheckStoreReviews extends BasePage {
  //Web element Locators
   By storeLocator= By.cssSelector("#p-465951773 .sallerName");
    By storereviewLocator=By.xpath("//body/div[@id='wrapper']/div[@id='contentSellerShop']/div[1]/section[2]/div[2]/div[1]/ul[1]/li[2]/div[1]/h3[1]/a[1]");
    By totalreviewsLocator = new By.ByCssSelector("span.selectedReview:nth-child(1)");

    public CheckStoreReviews(WebDriver driver)  {
        super(driver);
    }

    public void checkReviews() throws IOException {
        Helper.waitFor(1);
        seeStorePage().click();
        findStoreReview().click();
        Helper.waitFor(1);
    }

    public void reviewsNumber(){
        if(isOnReviewResult()){
            System.out.println("Number of comments made=>" +" "+ seeReviewResult().getText());
        }
        else{
            System.out.println("No comments found!");
        }
    }

    // Find Web Elements Methods
    public WebElement seeStorePage(){return driver.findElement(storeLocator);}
    public WebElement findStoreReview(){return driver.findElement(storereviewLocator);}
    public WebElement seeReviewResult() {return driver.findElement(totalreviewsLocator);}
    public boolean isOnReviewResult() {return isDisplayed(totalreviewsLocator);}
}
