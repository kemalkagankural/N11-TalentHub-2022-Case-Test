package tasks;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

public class TypeInformation extends BasePage {
    public TypeInformation(WebDriver driver) {
        super(driver);
    }

    By namesurnameLocator= By.id("fullName");
    By phoneLocator=By.id("gsm");
    By idLocator=By.id("shippingAddresstcNO");
    By adressNameLocator=By.id("addressName");
    public Actions actionProvider = new Actions(driver);


    public void typeInformations(String name,String gsm,String id,String adressname) {
        type(namesurnameLocator , name);
        Helper.waitFor(1);
        selectPhone().click();
        type(phoneLocator , gsm);
        Helper.waitFor(1);
        type(idLocator , id);
        Helper.waitFor(1);
        type(adressNameLocator , adressname);
        Helper.waitFor(1);
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



    public WebElement selectPhone(){return driver.findElement(phoneLocator);}
    }
