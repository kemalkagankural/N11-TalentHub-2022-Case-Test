package utils;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreList extends BasePage {

     List<String> storesNames;
    By storePageLocator = By.id("contentSellerList");
    By storeLocator= new By.ByCssSelector(" ul:nth-child(1) > li.hBotMenuItem.hTMItem.hasMenu:nth-child(5)");
    By allStoreLocator= new By.ByCssSelector("a.active:nth-child(1)");
    By storeLettersLocator =  By.xpath("//*[@class=\"letters\"]/span");
    By finAllBtnLocator = new By.ByXPath("//body/div[@id='wrapper']/div[@id='contentSellerList']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[4]");
    private Actions actionProvider = new Actions(driver);

    public StoreList(WebDriver driver) {
        super(driver);
    }


    public boolean isStorePage() {
        return isDisplayed(storePageLocator);
    }

    public  void moveToStore(){
        actionProvider.moveToElement(findStore()).click(findAllStore()).perform();
    }

    public void getAllStoreName() {
        storesNames = new ArrayList<>();
        actionProvider.click(findAllStoreBtn()).perform();
        List <WebElement> alphabet = getAllLetters();
        for(WebElement element:alphabet){
            element.click();
            Helper.waitFor(1);
            for (int i=0;i<getAllStoreNames().size();i++){
                storesNames.add(getAllStoreNames().get(i).getText());
            }
        }
    }
    public void writeStoreNames() throws IOException {
    Helper.writeToCSV(String.valueOf(storesNames));
    }



    public WebElement findStore(){
        return driver.findElement(storeLocator);
    }
    public WebElement findAllStore(){
        return driver.findElement(allStoreLocator);
    }
    public List<WebElement> getAllLetters(){
        return findAll(storeLettersLocator);
    }

    public List<WebElement> getAllStoreNames(){
        By storeNamesLocator = new By.ByXPath("//body/div[@id='wrapper']/div[@id='contentSellerList']/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/ul");
        return findAll(storeNamesLocator);
    }

    public WebElement findAllStoreBtn(){
        return driver.findElement(finAllBtnLocator);
    }

}
