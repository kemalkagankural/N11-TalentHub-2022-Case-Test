package testRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import testLogger.TestResultLogger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {

    public WebDriver driver ;
    static final String APP_URL = "https://www.n11.com/";
    static final String HOST_URL = "http://localhost:4444/wd/hub";
    @BeforeAll
    public void setUp(){
        ChromeOptions opt = new ChromeOptions();
        //FirefoxOptions opt=new FirefoxOptions();
        
        try {
            driver = new RemoteWebDriver(new URL(HOST_URL),opt);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(APP_URL);
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }

}
