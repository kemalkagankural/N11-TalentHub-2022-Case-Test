package tasks;

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

    public  void scrollDown(){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
    }

    public void productPrice(){
      String a= String.valueOf(getAllProducts().get(0).getAttribute("value").charAt(0));
      String a1=String.valueOf(getAllProducts().get(0).getAttribute("value").charAt(1));
      String b= String.valueOf(getAllProducts().get(1).getAttribute("value").charAt(0));
      String b1= String.valueOf(getAllProducts().get(1).getAttribute("value").charAt(1));
      int i= Integer.parseInt(b+b1);
      int j = Integer.parseInt(a+a1);
      if(i<j){
          scrollDown();
          spinnerUp().get(1).click();
          Helper.waitFor(3);
      }else{
          System.out.println("You dont add one more to cheaper one");
          spinnerUp().get(0).click();
      }
    }

    public void buyProduct(){
        buyBtn().click();
        Helper.waitFor(1);
        buyGuest().click();
        Helper.waitFor(1);
        typeMail("nargizkoshka@lersptear.com");
        Helper.waitFor(1);
    }


    public void typeMail(String text) {
        type(mailAreaLocator , text);
        click(submitButtonLocator);
    }




    public List<WebElement> getAllProducts(){
        return findAll(priceProduct);
    }
    public List<WebElement> spinnerUp(){
        return findAll(spinnerUpLocator);
    }
    public WebElement buyBtn(){return driver.findElement(buyBTNLocator);}
    public WebElement buyGuest(){return driver.findElement(buyGuestLocator);}

}
