package smoke;

import annotations.TestName;
import entities.CategoryEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MagazinePage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import java.util.List;

/**
 * Created by viktorlisniak on 7/20/17.
 */
public class Smoke_MagazineArticlesValidationTest extends BaseTest {


    @Test
    @TestName(name="Magazine Articles Verification")
    public void smokeMagazineArticlesValidation() throws Exception {

        CategoryEntity category = EntitiesFactory.getCategory(FileIO.getDataFile("Default_Sleep_Magazine_Category.json")); // get category data from file

        HomePage home = HomePage.Instance;

        home.open();

        MagazinePage magazinePage = home.header.clickOnMagazineItem();
        Assert.assertTrue(magazinePage.isPageLoaded(), "Magazine page is not loaded");


        magazinePage.clickOnSleepCategory();
        magazinePage.clickOnCategory("sleep");
        Assert.assertTrue(magazinePage.isPageLoaded(), magazinePage.getURL()+ " page is not loaded");
        Assert.assertEquals(magazinePage.getURL(), MagazinePage.BASE_URL + magazinePage.pageURL+magazinePage.categoryURL);

        // read from json
        // category.getArticles().stream().forEach(x -> System.out.println("Article name: " + x.getTitle()));

        magazinePage.getArticleTitles();

        Assert.assertEquals(magazinePage.getArticlesQty(), category.getArticles().size());


















    }
}
