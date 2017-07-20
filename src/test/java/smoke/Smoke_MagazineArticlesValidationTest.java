package smoke;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MagazinePage;
import pages.PageHeader;
import utils.BaseTest;

/**
 * Created by viktorlisniak on 7/20/17.
 */
public class Smoke_MagazineArticlesValidationTest extends BaseTest {


    @Test
    @TestName(name="Foam Pillow Workflow test")
    public void smokeMagazineArticlesValidation(){

        HomePage home = HomePage.Instance;

        home.open();
        MagazinePage magazinePage = home.header.clickOnMagazineItem();

        Assert.assertTrue(magazinePage.isPageLoaded(), "Magazine page is not loaded");




    }
}
