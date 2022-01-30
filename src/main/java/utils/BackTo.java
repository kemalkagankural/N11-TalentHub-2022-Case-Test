package utils;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BackTo extends BasePage {
    public BackTo(WebDriver driver) {
        super(driver);
    }

    public void doubleBack(){
        for(int i=0;i<2;i++){
            driver.navigate().back();
        }
    }
}
