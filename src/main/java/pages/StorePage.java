package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StorePage extends BasePage {


    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void getURL(String s){ driver.get("https://www.n11.com/magaza/"+s+"");}
}
