package smoke;

import annotations.TestName;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ReviewsPage;
import utils.BaseTest;
import pages.PageHeader;
import pages.BasePage;

/*
Created by noname
 */

public class Smoke_ReviewValidation extends BaseTest {

    @Test
    @TestName
    public void Smoke_Review ()throws Exception {

        //init pages
        HomePage home = HomePage.Instance;
        //ReviewsPage review = ReviewsPage.Instance;

        //open home page and go to reviews page
        home.open();
        home.header.clickOnReviewsMenuItem();


    }


}
