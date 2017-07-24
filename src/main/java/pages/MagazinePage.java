package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * Created by viktorlisniak on 7/19/17.
 */

public class MagazinePage extends BasePage {
        private static MagazinePage instance;
        public static MagazinePage Instance = (instance != null) ? instance : new MagazinePage();
        public String categoryURL = "";

    // URLs of magazine categories
    public final String urlTemplate = "/category/%s/";
    //or
    public final String sleepCategory_URL       = "/category/sleep/";
    public final String healCategory_URL        = "/category/heal/";
    public final String playCategory_URL        = "/category/play/";
    public final String inBegWithCategory_URL   = "/category/in-bed-with/";

    // magazine categories buttons
    public final String buttonTemplate = "//ul[@id='menu-main-1']//a[text()='%s']";
    //or
    public final By sleepCategory      = By.xpath("//ul[@id='menu-main-1']//a[text()='SLEEP']");
    public final By healCategory       = By.xpath("//ul[@id='menu-main-1']//a[text()='HEAL']");
    public final By playCategory       = By.xpath("//ul[@id='menu-main-1']//a[text()='PLAY']");
    public final By InBedWithCategory  = By.xpath("//ul[@id='menu-main-1']//a[text()='PLAY']");


        /** UI Mappings */
    By articleLocator = By.cssSelector(".entry-title");

    public MagazinePage(){
        pageURL = "/magazine";
    }

    @Override
    public String getURL() {
        reporter.info("The requested URL is: " + BASE_URL + pageURL + categoryURL);
        return BASE_URL + pageURL + categoryURL;
    }

    public void clickOnCategory(String categoryName){
        By categoryButton;
        String newUrl;
        if (categoryName.contains(" ")){

        }
        categoryButton = By.xpath(String.format(buttonTemplate, categoryName.toUpperCase()));
        reporter.info("Click on " + categoryButton);
        clickOnElement(categoryButton);
        newUrl = String.format(urlTemplate, categoryName.toLowerCase());
        reporter.info("Url changed from " + this.BASE_URL + this.pageURL + " to " + this.getURL());
        categoryURL = newUrl;
    }

    public int getArticlesQty(){
        List<WebElement> list = MagazinePage.findElements(articleLocator);
        reporter.info("getArticlesQty() returned: " +  String.valueOf(list.size()));
        return list.size();
    }

    public List<String> getArticleTitles(){
        List<WebElement> listOfElemets = MagazinePage.findElements(articleLocator);
        List<String> listOfTitles = new ArrayList<>();
        listOfElemets.stream().forEach(x-> listOfTitles.add(x.getText()));
        reporter.info("Articles found: ");
        listOfTitles.stream().forEach(x-> reporter.info(x));
        return listOfTitles;
    }

    public void clickOnSleepCategory(){
        reporter.info("Click on " + sleepCategory);
        clickOnElement(sleepCategory);
        categoryURL = sleepCategory_URL;
    }

    public void clickOnHealCategory(){
        reporter.info("Click on " + healCategory);
        clickOnElement(healCategory);
        categoryURL = healCategory_URL;
    }



}
