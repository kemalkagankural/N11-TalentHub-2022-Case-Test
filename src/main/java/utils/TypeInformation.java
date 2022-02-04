package utils;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class TypeInformation extends BasePage {
    public TypeInformation(WebDriver driver) {
        super(driver);
    }

    By namesurnameLocator= By.id("fullName");
    By phoneLocator=By.id("gsm");
    By idLocator=By.id("shippingAddresstcNO");
    By adressNameLocator=By.id("addressName");
    By adressDetailsLocator=By.id("addressDetail");
    By errorMessageLocator=By.cssSelector(".alertWrapper:nth-child(1) > .alertLine--error");
    public boolean isErrorMessage() {
        return isDisplayed(errorMessageLocator);
    }



    public void typeInformations(String name,String gsm,String id,String adressname,String adressdetails) {
        Helper.waitFor(1);
        type(namesurnameLocator , name);
        Helper.waitFor(1);
        selectPhone().click();
        type(phoneLocator , gsm);
        Helper.waitFor(1);
        type(idLocator , id);
        Helper.waitFor(1);
        type(adressNameLocator , adressname);
        Helper.waitFor(1);
        type(adressDetailsLocator,adressdetails);
    }
    public  void selectAdressDetails(){
        driver.findElement(By.id("cityId")).click();
        Helper.waitFor(2);
        WebElement dropdown = driver.findElement(By.id("cityId"));
        Helper.waitFor(2);
        dropdown.findElement(By.xpath("//option[. = 'Bursa']")).click();
        Helper.waitFor(2);
        driver.findElement(By.id("districtId")).click();
        WebElement dropdown1 = driver.findElement(By.id("districtId"));
        Helper.waitFor(2);
        dropdown1.findElement(By.xpath("//option[. = 'Karacabey']")).click();
        Helper.waitFor(2);
        driver.findElement(By.id("neighbourhoodId")).click();
        WebElement dropdown2 = driver.findElement(By.id("neighbourhoodId"));
        Helper.waitFor(2);
        dropdown2.findElement(By.xpath("//option[. = 'Drama']")).click();
    }

    public void enterPaymentInformation(){
        // 1 | click | css=.cardNumberInput:nth-child(3) |
        driver.findElement(By.cssSelector(".cardNumberInput:nth-child(3)")).click();
        //Timeout
        Helper.waitFor(1);
        // 2 | type | css=.cardNumberInput:nth-child(3) | 5197
        driver.findElement(By.cssSelector(".cardNumberInput:nth-child(3)")).sendKeys("5197");
        //Timeout
        Helper.waitFor(1);
        // 3 | type | css=.cardNumberInput:nth-child(4) | 5310
        driver.findElement(By.cssSelector(".cardNumberInput:nth-child(4)")).sendKeys("5310");
        //Timeout
        Helper.waitFor(1);
        // 4 | type | css=.cardNumberInput:nth-child(5) | 7344
        driver.findElement(By.cssSelector(".cardNumberInput:nth-child(5)")).sendKeys("7344");
        //Timeout
        Helper.waitFor(1);
        // 5 | type | css=.cardNumberInput:nth-child(6) | 0626
        driver.findElement(By.cssSelector(".cardNumberInput:nth-child(6)")).sendKeys("0626");
        //Timeout
        Helper.waitFor(1);
        // 6 | type | id=cardOwnerName | Nathalie Helms
        driver.findElement(By.id("cardOwnerName")).sendKeys("Nathalie Helms");
        //Timeout
        Helper.waitFor(1);
        // 7 | click | id=expireMonth |
        driver.findElement(By.id("expireMonth")).click();
        //Timeout
        Helper.waitFor(1);
        // 8 | select | id=expireMonth | label=12
        WebElement dropdown1 = driver.findElement(By.id("expireMonth"));
        dropdown1.findElement(By.xpath("//option[contains(text(),'12')]")).click();
        //Timeout
        Helper.waitFor(1);
        // 9 | click | id=expireYear |
        driver.findElement(By.id("expireYear")).click();
        //Timeout
        Helper.waitFor(1);
        // 10 | select | id=expireYear | label=2026
        WebElement dropdown = driver.findElement(By.id("expireYear"));
        dropdown.findElement(By.xpath("//option[contains(text(),'2026')]")).click();
        //Timeout
        Helper.waitFor(1);
        // 11 | click | id=securityCode |
        driver.findElement(By.id("securityCode")).click();
        //Timeout
        Helper.waitFor(1);
        // 12 | type | id=securityCode | 588
        driver.findElement(By.id("securityCode")).sendKeys("588");
        //Timeout
        Helper.waitFor(1);
        // 13 | click | css=.formfield:nth-child(1) > .svgIcon |
        driver.findElement(By.cssSelector(".formfield:nth-child(1) > .svgIcon")).click();
        //Timeout
        Helper.waitFor(1);
        // 14 | click | css=#js-paymentBtn > span |
        driver.findElement(By.cssSelector("#js-paymentBtn > span")).click();
        Helper.waitFor(5);
    }


 // driver.findElement(By.id("creditCardTabPanel")).click();
    public WebElement selectPhone(){return driver.findElement(phoneLocator);}

    }
