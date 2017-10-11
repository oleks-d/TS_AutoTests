package smoke;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ReviewsRating;
import utils.BaseTest;

public class Smoke_ReviewBrowsing_Test extends BaseTest{

    @Test
    @TestName(name = "Browse through review pages")
    public void browseThroughReviewPages() throws Exception {
        //init pages
        HomePage home = HomePage.Instance;
        ReviewsRating rating = ReviewsRating.Instance;

        // Open home page and go to reviews page
        home.open();
        home.header.clickReviewsMenuItem();

        // Clicking on product item section
        rating.clickOnMattressReviewButton();
        Assert.assertTrue(rating.productReviewsAreDisplayed());
        rating.browseThroughReviewPages();

        rating.clickOnMonitorReviewButton();
        Assert.assertTrue(rating.productReviewsAreDisplayed());
        rating.browseThroughReviewPages();

        rating.clickOnComforterReviewButton();
        Assert.assertTrue(rating.productReviewsAreDisplayed());
        rating.browseThroughReviewPages();

        rating.clickOnFoamPillowReviewButton();
        Assert.assertTrue(rating.productReviewsAreDisplayed());
        rating.browseThroughReviewPages();

        rating.clickOnPlushPillowReviewButton();
        Assert.assertTrue(rating.productReviewsAreDisplayed());
        rating.browseThroughReviewPages();

        rating.clickOnSheetsReviewButton();
        Assert.assertTrue(rating.productReviewsAreDisplayed());
        rating.browseThroughReviewPages();

        rating.clickOnProtectorReviewButton();
        Assert.assertTrue(rating.productReviewsAreDisplayed());
        rating.browseThroughReviewPages();

        rating.clickOnDrapesReviewButton();
        Assert.assertTrue(rating.productReviewsAreDisplayed());
        rating.browseThroughReviewPages();
    }
}
