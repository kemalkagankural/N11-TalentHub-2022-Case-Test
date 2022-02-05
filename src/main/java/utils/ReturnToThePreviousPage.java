package utils;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ReturnToThePreviousPage extends BasePage {
    public ReturnToThePreviousPage(WebDriver driver) {
        super(driver);
    }
    //Return to The Previous Page Methods
    public void doubleBack(){
        for(int i=0;i<2;i++){
            driver.navigate().back();
        }
    }
}
