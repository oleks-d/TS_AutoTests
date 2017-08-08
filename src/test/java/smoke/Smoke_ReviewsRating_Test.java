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

    String sleepCategory = "SLEEP";

    String sleepURL = "/category/sleep/";


    @Test
    @TestName(name="Items Rating Verification")
    public void smoke_ReviewsRating_Test() throws Exception {

        //init pages
        HomePage home = HomePage.Instance;
        ReviewsRating rating = ReviewsRating.Instance;

        // Open home page and go to help page
        home.open();
        home.header.clickReviewsMenuItem();

        // Test search request and field
        rating.clickOnMattressReviewButton();

        rating.clickOnFiveStarsBar();
        //Assert.assertTrue(rating.clickOnFiveStarsBar(), "Filter bar was not found");
        rating.clickOnFilterFiveStarsButton();
        //Assert.assertTrue(rating.clickOnFilterFiveStarsButton(), "Filter button was not found");
        rating.clickOnFourStarsBar();
        rating.clickOnFilterFourStarsButton();
        rating.clickOnThreeStarsBar();
        rating.clickOnFilterThreeStarsButton();
        rating.clickOnTwoStarsBar();
        rating.clickOnFilterTwoStarsButton();
        rating.clickOnOneStarBar();
        rating.clickOnFilterOneStarButton();




//        Assert.assertTrue(rating.isFilterFiveStarsButtonPresent(), "Filter button was not found");
//        rating.clickOnMonitorReviewButton();
        ////Assert.assertTrue(rating.clickOnThreeStarsBar(), "Filter button was not found");
        //Assert.assertTrue(rating.isFilterFiveStarsButtonPresent(),"Filter button was not found");
//        rating.clickOnFilterThreeStarsButton();
//        rating.clickOnMonitorReviewButton();
//        rating.clickOnFourStarsBar();
//        Assert.assertTrue(rating.isFilterFourStarsButtonPresent(),"Filter button was not found");
//        rating.clickOnFilterFiveStarsButton();





















    }
}
