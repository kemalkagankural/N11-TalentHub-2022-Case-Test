package testRunner;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import utils.CheckStoreReviews;
import utils.StoreList;

import java.io.IOException;


public class Test_Case_1_Store_List extends BaseTest {
    HomePage homePage;
    StoreList storeList;
    CheckStoreReviews checkStoreReviews;


    @Test
    @Order(1)
    public void open_home_page(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        Assertions.assertTrue(homePage.isHomePage() ,
               "Not on home page!");
    }
    @Test
    @Order(2)
    public void move_store_page(){
        storeList = new StoreList(driver);
        storeList.moveToStore();
        Assertions.assertTrue(storeList.isStorePage() ,
                "Not on home page!");
    }
    @Test
    @Order(3)
    public void get_all_store() throws IOException {
    storeList = new StoreList(driver);
    storeList.getAllStoreName();
    }

  @Test
    @Order(4)
    public void check_review_number() throws IOException, CsvException {
        checkStoreReviews = new CheckStoreReviews(driver);
        checkStoreReviews.checkReviews();
        checkStoreReviews.reviewsNumber();
        Assertions.assertTrue(checkStoreReviews.isOnReviewResult(),"Number of comments made for this Store");
    }

}
