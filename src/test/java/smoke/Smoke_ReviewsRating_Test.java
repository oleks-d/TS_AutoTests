package smoke;

import annotations.TestName;
import entities.CategoryEntity;
import org.jsoup.Connection;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * Created by obohachuk on 7/28/17.
 */
public class Smoke_ReviewsRating_Test extends BaseTest {

    @Test
    @TestName(name="Items Rating Verification")
    public void smoke_ReviewsRating_Test() throws Exception {

        //init pages
        HomePage home = HomePage.Instance;
        ReviewsRating rating = ReviewsRating.Instance;

        // Open home page and go to reviews page
        home.open();
        home.header.clickReviewsMenuItem();

        // Clicking on product item section
        rating.clickOnMattressReviewButton();

        //Filter bars verification (Unnecessary)
        //Assert.assertTrue(rating.filterBarsAvailabilityVerification(), "Filter bar buttons were not found");

        //Clicking on 5 Stars bar
        rating.clickOnFiveStarsBar();
        Assert.assertTrue(rating.isFiveStarsReviewPresent(), "Assert: 5 stars reviews are not found");
        rating.removeFiveStarsFilter();
        Assert.assertTrue(rating.fiveStarsFilterVerification(), "Assert: 5 stars filter button was not clicked");

        //Clicking on 4 Stars bar
        rating.clickOnFourStarsBar();
        Assert.assertTrue(rating.isFourStarsReviewPresent(), "Assert: 4 stars reviews are not found");
        rating.removeFourStarsFilter();
        Assert.assertTrue(rating.fourStarsFilterVerification(), "Assert: 4 stars filter button was not clicked");

        //Clicking on 3 Stars bar
        rating.clickOnThreeStarsBar();
        Assert.assertTrue(rating.isThreeStarsReviewPresent(), "Assert: 3 stars reviews are not found");
        rating.removeThreeStarsFilter();
        Assert.assertTrue(rating.threeStarsFilterVerification(), "Assert: 3 stars filter button was not clicked");

        //Clicking on 2 Stars bar
        rating.clickOnTwoStarsBar();
        Assert.assertTrue(rating.isTwoStarsReviewPresent(), "Assert: 2 stars reviews are not found");
        rating.removeTwoStarsFilter();
        Assert.assertTrue(rating.twoStarsFilterVerification(), "Assert: 2 stars filter button was not clicked");

        //Clicking on 1 Star bar
        rating.clickOnOneStarsBar();
        Assert.assertTrue(rating.isOneStarReviewPresent(), "Assert: 1 star reviews are not found");
        rating.removeOneStarFilter();
        Assert.assertTrue(rating.oneStarFilterVerification(), "Assert: 1 star filter button was not clicked");

    }
}
