package utils;

import helper.Helper;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.BasePage;

import java.util.List;


public class BuyProcess extends BasePage {

    public BuyProcess(WebDriver driver) {
        super(driver);
    }
    By priceProduct=By.cssSelector(" div.prodPrice__text:nth-child(2) > input.productPrice");
    By spinnerUpLocator=By.cssSelector("span.spinnerUp.spinnerArrow");
    By buyBTNLocator=By.id("js-buyBtn");
    By buyGuestLocator=By.className("btn-continue");
    JavascriptExecutor js;
    By mailAreaLocator=By.id("guestEmail");
    By submitButtonLocator=By.id("js-guestEmailCheck");
    By paymentBTNLocator=By.id("js-goToPaymentBtn");

    public  void scrollDown(){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
    }

    public void productPrice(){
        String a= (getAllProducts().get(0).getAttribute("value")).replaceAll("\\.","").replace(",","");
        int i= Integer.parseInt(a);
        String b=(getAllProducts().get(1).getAttribute("value")).replaceAll("\\.","").replace(",","");
        int j= Integer.parseInt(b);
     if(j<i){
          scrollDown();
          spinnerUp().get(1).click();
          Helper.waitFor(3);
      }else{
          System.out.println("You dont add one more to cheaper one");
          scrollDown();
          spinnerUp().get(0).click();
          Helper.waitFor(3);
      }
    }

    public void buyProduct(){
        buyBtn().click();
        Helper.waitFor(1);
        buyGuest().click();
        Helper.waitFor(1);
        typeMail("nargizkoshka@gmail.com");
    }


    public void typeMail(String text) {
        type(mailAreaLocator , text);
        click(submitButtonLocator);
    }

    public void payment(){
        paymentBTN().click();
    }

    public WebElement paymentBTN(){return driver.findElement(paymentBTNLocator);}
    public List<WebElement> getAllProducts(){
        return findAll(priceProduct);
    }
    public List<WebElement> spinnerUp(){
        return findAll(spinnerUpLocator);
    }
    public WebElement buyBtn(){return driver.findElement(buyBTNLocator);}
    public WebElement buyGuest(){return driver.findElement(buyGuestLocator);}

}
