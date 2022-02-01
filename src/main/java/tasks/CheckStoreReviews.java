package tasks;

import com.opencsv.exceptions.CsvException;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;


import java.io.IOException;

public class CheckStoreReviews extends BasePage {

    By storereviewLocator=By.xpath("//body/div[@id='wrapper']/div[@id='contentSellerShop']/div[1]/section[2]/div[2]/div[1]/ul[1]/li[2]/div[1]/h3[1]/a[1]");
    By totalreviewsLocator = new By.ByCssSelector("span.selectedReview:nth-child(1)");
    By sstore=By.xpath("//*[@class=\"letters\"]/span[22]");
    By secondone=By.cssSelector("ul:nth-child(3) li:nth-child(2) > a:nth-child(1)");
    By storepage=By.cssSelector("div.sallerInfo.cPoint");

    public CheckStoreReviews(WebDriver driver) {
        super(driver);
    }

    public void checkReviews() throws IOException, CsvException {
        clickStarToS().click();
        Helper.waitFor(1);
        Helper.readToCSV();
        clickSecondOne().click();
        Helper.waitFor(1);
        seeStorePage().click();
        findStoreReview().click();
        Helper.waitFor(1);
       if(isOnReviewResult()){
           System.out.println("Number of comments made=>" +" "+ seeReviewResult().getText());
        }
        else{
            System.out.println("No comments found!");

        }
    }

    public WebElement clickStarToS(){return driver.findElement(sstore);}
    public WebElement clickSecondOne(){return  driver.findElement(secondone);}
    public WebElement seeStorePage(){return driver.findElement(storepage);}
    public WebElement findStoreReview(){return driver.findElement(storereviewLocator);}
    public WebElement seeReviewResult() {return driver.findElement(totalreviewsLocator);}
    public boolean isOnReviewResult() {return isDisplayed(totalreviewsLocator);}
}
