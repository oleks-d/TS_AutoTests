package smoke;

import annotations.TestName;
import entities.CategoryEntity;
import org.testng.Assert;
import org.testng.Reporter;
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
public class Smoke_MagazineCategoriesValidationTest extends BaseTest {

    String sleepCategory = "SLEEP";
    String healCategory = "HEAL";
    String playCategory = "PLAY";
    String inBedWithCategory = "IN BED WITH";

    String sleepURL = "/magazine/category/sleep/";
    String healURL = "/magazine/category/heal/";
    String playURL = "/magazine/category/play/";
    String inBedWithURL = "/magazine/category/in-bed-with/";


    @Test
    @TestName(name="Magazine Categories Verification")
    public void smokeMagazineArticlesValidation() throws Exception {

        // get Entities data from files
        CategoryEntity sleepEntity      = EntitiesFactory.getCategory(FileIO.getDataFile("Default_Magazine_Sleep_Category.json"));
        CategoryEntity healEntity       = EntitiesFactory.getCategory(FileIO.getDataFile("Default_Magazine_Heal_Category.json"));
        CategoryEntity playEntity       = EntitiesFactory.getCategory(FileIO.getDataFile("Default_Magazine_Play_Category.json"));
        CategoryEntity inBedWithEntity  = EntitiesFactory.getCategory(FileIO.getDataFile("Default_Magazine_InBedWith_Category.json"));

        HomePage home = HomePage.Instance;

        //open home page
        home.open();

        // navigate to MAGAZINE page
        MagazinePage magazinePage = home.header.clickOnMagazineItem();
        // check if page is loaded
        Assert.assertTrue(magazinePage.isPageLoaded(), "Magazine page is not loaded");


        // navigate to SLEEP category
        magazinePage.clickOnCategory(sleepCategory);
        // check if page is loaded
        Assert.assertTrue(magazinePage.isPageLoaded(), magazinePage.getURL()+ " page is not loaded");
        // check if URL is correct
        Assert.assertEquals(magazinePage.getURL(), MagazinePage.BASE_URL + magazinePage.pageURL + sleepURL);
        // check if there are as many articles as expected (comparing to entity)
        //Assert.assertEquals(magazinePage.getArticlesQty(), sleepEntity.getArticles().size());

        // navigate to MAGAZINE page
        home.header.clickOnMagazineItemMagPage();


        // navigate to HEAL category
        magazinePage.clickOnCategory(healCategory);
        // check if page is loaded
        Assert.assertTrue(magazinePage.isPageLoaded(), magazinePage.getURL()+ " page is not loaded");
        // check if URL is correct
        Assert.assertEquals(magazinePage.getURL(), MagazinePage.BASE_URL + magazinePage.pageURL + healURL);
        // check if there are as many articles as expected (comparing to entity)
        //Assert.assertEquals(magazinePage.getArticlesQty(), healEntity.getArticles().size());


        // navigate to MAGAZINE page
        home.header.clickOnMagazineItemMagPage();


        // navigate to PLAY category
        magazinePage.clickOnCategory(playCategory);
        // check if page is loaded
        Assert.assertTrue(magazinePage.isPageLoaded(), magazinePage.getURL()+ " page is not loaded");
        // check if URL is correct
        Assert.assertEquals(magazinePage.getURL(), MagazinePage.BASE_URL + magazinePage.pageURL + playURL);
        // check if there are as many articles as expected, comparing to file
        //Assert.assertEquals(magazinePage.getArticlesQty(), playEntity.getArticles().size());

        // navigate to MAGAZINE page
        home.header.clickOnMagazineItemMagPage();


        // navigate to IN BED WITH category
        magazinePage.clickOnCategory(inBedWithCategory);
        // check if page is loaded
        Assert.assertTrue(magazinePage.isPageLoaded(), magazinePage.getURL()+ " page is not loaded");
        // check if URL is correct
        Assert.assertEquals(magazinePage.getURL(), MagazinePage.BASE_URL + magazinePage.pageURL + inBedWithURL);
        // check if there are as many articles as expected (comparing to entity)
        //Assert.assertEquals(magazinePage.getArticlesQty(), inBedWithEntity.getArticles().size());


    }
}
