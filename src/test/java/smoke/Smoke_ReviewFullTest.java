package smoke;

import annotations.TestName;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ReviewsPage;
import utils.BaseTest;
import org.testng.Assert;

/*
Created by Arsen Shliapskiy 07/20/17
 */

public class Smoke_ReviewFullTest extends BaseTest {

    @Test
    @TestName(name="Add review test") // UNDER CONSTRUCTION
    public void Smoke_Review ()throws Exception {

        HomePage home = HomePage.Instance;

        //open home page and goes to 'Reviews' page
        home.open();
            home.header.clickReviewsMenuItem();

        ReviewsPage r = ReviewsPage.Instance;

        //Actions on Review page

        r.clickOnWriteReview();
        r.enterLocation();
        //Assert.assertTrue(r.getYourLocationText().contains("New York"));
        r.selectDropDownList();
        r.chooseRating();
        r.inputHeadline();
        r.inputComment();
        r.inputName();
        r.inputEmail();
        r.submitReview();

    }


}
