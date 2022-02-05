package utils;

import com.opencsv.exceptions.CsvException;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.io.IOException;

public class SelectSecondStore extends BasePage {
    public SelectSecondStore(WebDriver driver) throws IOException, CsvException {
        super(driver);
    }


    By sstore=By.xpath("//*[@class=\"letters\"]/span[22]");
    String second=Helper.readToCSV("s").replaceAll("\\[","").replace("]","");
    public void selectSecondStore(){
       clickStarToS().click();
        Helper.waitFor(1);
        driver.get("https://www.n11.com/arama?s="+second+"");
        Helper.waitFor(5);
    }

    public WebElement clickStarToS(){return driver.findElement(sstore);}


}
