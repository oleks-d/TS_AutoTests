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
    public final String urlTemplate = "/magazine/category/%s/";
    // magazine categories buttons
    //public final String buttonTemplate = "//ul[@id='menu-main-1']//a[text()='%s']";
    public final String buttonTemplate = "//*[@class='site-widgetized-section section-top']//a[text()='%s']";

        /** UI Mappings */
    By articleLocator = By.cssSelector(".entry-title");

    public MagazinePage(){
        pageURL = "/magazine";
    }

    @Override
    public String getURL() {
        reporter.info("getURL() returned: " + BASE_URL + pageURL + categoryURL);
        return super.getURL() + categoryURL;
    }

    // makes URL category using url template and category name
    public String makeCategoryrUrl(String makeUrlOfMe){
        String newUrl;
        makeUrlOfMe = makeUrlOfMe.toLowerCase();
        if (makeUrlOfMe.contains(" ")){
            String format = makeUrlOfMe.replace(" ", "-");
            newUrl = String.format(urlTemplate, format);
        }else {
            newUrl = String.format(urlTemplate, makeUrlOfMe);
        }
        return newUrl;
    }

    public MagazinePage clickOnCategory(String categoryName){
        By categoryButton = By.xpath(String.format(buttonTemplate, categoryName.toUpperCase()));
        reporter.info("Click on " + categoryButton);
        clickOnElement(categoryButton);
        String newUrl = makeCategoryrUrl(categoryName);
        this.categoryURL = newUrl;
        return this;
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
        reporter.info("getArticleTitles() returned " + listOfTitles.size() + " articles: ");
        return listOfTitles;
    }



}
