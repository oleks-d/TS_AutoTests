package smoke;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.CheckoutReviewPage;
import pages.FaqPage;
import pages.HomePage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static pages.BasePage.scrollToElement;

/**
 * Created by obohachuk on 19.07.17
 */

public class Smoke_FAQ_FullTest extends BaseTest {

    // Search requests
    String searchrequest = "pillow";
    //String searchrequest = "mattress";
    //String searchrequest = "comforter";

    @Test
    @TestName(name = "FAQ Test")
    public void smoke_FAQ_FullTest() throws Exception {


        // Init pages
        HomePage home = HomePage.Instance;
        FaqPage faq = FaqPage.Instance;

        // Open home page and go to help page
        home.open();
        home.header.clickFaqMenuItem();

        // Test search request and field
        faq.clickOnFaqSearchField();
        faq.sendSearchRequest(searchrequest);
        faq.clickOnFaqSearchButton();
        Assert.assertTrue(faq.getSearchRequestText().contains(searchrequest), "Request failed");
        faq.open();

        // Test FAQ sections
        faq.clickOnfaqOurMattress();
        Assert.assertTrue(faq.getFaqMattressText().contains("Our Mattress"), "Failed to open");
        faq.open();

        faq.clickOnfaqSleepSystem();
        Assert.assertTrue(faq.getFaqSleepSystemText().contains("Sleep System"), "Failed to open");
        faq.open();

        faq.clickOnfaqSleeptracker();
        Assert.assertTrue(faq.getFaqSleeptrackerText().contains("Sleeptracker"), "Failed to open");
        faq.open();

        faq.clickOnfaqPurchasing();
        Assert.assertTrue(faq.getFaqPurchasingText().contains("Purchasing"), "Failed to open");
        faq.open();

        faq.clickOnfaqShipping();
        Assert.assertTrue(faq.getFaqShippingText().contains("Shipping"), "Failed to open");
        faq.open();

        faq.clickOnfaqReturnsAndWarranty();
        Assert.assertTrue(faq.getFaqReturnsAndWarrantyText().contains("Returns & Warranty"), "Failed to open");
        faq.open();

        // Verify Support chat window for persistence
        faq.clickOnfaqChatSupport();
//        Assert.assertTrue(faq.getFaqChatSupportInputWindow().contains("Send Message"), "Failed to open");
//        faq.open();

    }
}