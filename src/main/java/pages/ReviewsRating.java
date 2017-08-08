package pages;

import org.openqa.selenium.By;


public class ReviewsRating extends BasePage {

    private static ReviewsRating instance;
    public static ReviewsRating Instance = (instance != null) ? instance : new ReviewsRating();

    public ReviewsRating() {
        pageURL = "/reviews";
    }

    /**
     * Common elements
     **/

    public PageHeader header = PageHeader.Instance;

    /**
     * UI Mappings
     */

    //Review Top bar items

    By topBarMattress = By.xpath(".//*[@class='top-bar']/li[1]/a");
    By topBarMonitor = By.xpath(".//*[@class='top-bar']/li[2]/a");
    By topBarComforter = By.xpath(".//*[@class='top-bar']/li[3]/a");
    By topBarFoamPillow = By.xpath(".//*[@class='top-bar']/li[4]/a");
    By topBarPlushPillow = By.xpath(".//*[@class='top-bar']/li[5]/a");
    By topBarSheets = By.xpath(".//*[@class='top-bar']/li[6]/a");
    By topBarProtector = By.xpath(".//*[@class='top-bar']/li[7]/a");
    By topBarDrapes = By.xpath(".//*[@class='top-bar']/li[8]/a");


    //Rating filter items

    By filterBar5 = By.xpath(".//*[@class='pr-review-snapshot-histogram']/ul/li[1]");
    By filterBar4 = By.xpath(".//*[@class='pr-review-snapshot-histogram']/ul/li[2]");
    By filterBar3 = By.xpath(".//*[@class='pr-review-snapshot-histogram']/ul/li[3]");
    By filterBar2 = By.xpath(".//*[@class='pr-review-snapshot-histogram']/ul/li[4]");
    By filterBar1 = By.xpath(".//*[@class='pr-review-snapshot-histogram']/ul/li[5]");

    /*  Old Xpath version
    By filterBarFiveStars = By.xpath(".//*[@class='pr-review-snapshot-histogram']//li[1]");  // Other ver By.xpath(".//p[contains(.,'5 Stars')]");
    By filterBarFourStars = By.xpath(".//*[@class='pr-review-snapshot-histogram']//li[2]");
    By filterBarThreeStars = By.xpath(".//*[@class='pr-review-snapshot-histogram']//li[3]");
    By filterBarTwoStars = By.xpath(".//*[@id='pr-review-snapshot']/section/section[*]/div/ul/li[4]/div");
    By filterBarOneStar = By.xpath(".//*[@id='pr-review-snapshot']/section/section[*]/div/ul/li[5]/div");
    */


    // Applied filter buttons

    By filterFiveStarsButton = By.xpath(".//span[contains(.,'5 Stars')]");
    By filterFourStarsButton = By.xpath(".//span[contains(.,'4 Stars')]");
    By filterThreeStarsButton = By.xpath(".//span[contains(.,'3 Stars')]");
    By filterTwoStarsButton = By.xpath(".//span[contains(.,'2 Stars')]");
    By filterOneStarButton = By.xpath(".//span[contains(.,'1 Star')]");



    /**
     * Page Methods
     */

    //  Top menu bar methods

    public ReviewsRating clickOnMattressReviewButton() {
        reporter.info("Click on Mattress review button");
        findElement(topBarMattress).click();
        return this;
    }

    public ReviewsRating clickOnMonitorReviewButton() {
        reporter.info("Click on Monitor review button");
        findElement(topBarMonitor).click();
        return this;
    }

    public ReviewsRating clickOnComforterReviewButton() {
        reporter.info("Click on Comforter review button");
        findElement(topBarComforter).click();
        return this;
    }

    public ReviewsRating clickOnFoamPillowReviewButton() {
        reporter.info("Click on Foam Pillow review button");
        findElement(topBarFoamPillow).click();
        return this;
    }

    public ReviewsRating clickOnPlushPillowReviewButton() {
        reporter.info("Click on Plush Pillow review button");
        findElement(topBarPlushPillow).click();
        return this;
    }

    public ReviewsRating clickOnSheetsReviewButton() {
        reporter.info("Click on Sheets review button");
        findElement(topBarSheets).click();
        return this;
    }

    public ReviewsRating clickOnProtectorReviewButton() {
        reporter.info("Click on Protector review button");
        findElement(topBarProtector).click();
        return this;
    }

    public ReviewsRating clickOnDrapesReviewButton() {
        reporter.info("Click on Drapes review button");
        findElement(topBarDrapes).click();
        return this;
    }



    // Filter bar methods


    public boolean clickOnFiveStarsBar(){
        isElementPresent(filterBar5);
        if(findElement(filterBar5).getText().contains("0")) {
            reporter.info("No reviews found. Can't click on filter bar");
        }
        else{
            findElement(filterBar5).click();
            reporter.info("Click on 5 stars filter bar");
        }
        return true;
    }


    public boolean clickOnFourStarsBar(){
        isElementPresent(filterBar4);
        if(findElement(filterBar4).getText().contains("0")) {
            reporter.info("No reviews found. Can't click on filter bar");
        }
        else{
            findElement(filterBar4).click();
            reporter.info("Click on 4 stars filter bar");
        }
        return true;
    }


    public boolean clickOnThreeStarsBar(){
        isElementPresent(filterBar3);
        if(findElement(filterBar3).getText().contains("0")) {
            reporter.info("No reviews found. Can't click on filter bar");
        }
        else{
            findElement(filterBar3).click();
            reporter.info("Click on 3 stars filter bar");
        }
        return true;
    }

    public boolean clickOnTwoStarsBar(){
        isElementPresent(filterBar2);
        if(findElement(filterBar2).getText().contains("0")) {
            reporter.info("No reviews found. Can't click on filter bar");
        }
        else{
            findElement(filterBar2).click();
            reporter.info("Click on 2 stars filter bar");
        }
        return true;
    }


    public boolean clickOnOneStarBar(){
        isElementPresent(filterBar1);
        if(findElement(filterBar1).getText().contains("0")) {
            reporter.info("No reviews found. Can't click on filter bar");
        }
        else{
            findElement(filterBar1).click();
            reporter.info("Click on 1 star filter bar");
        }
        return true;
    }



    //  Filter removal methods


    public boolean clickOnFilterFiveStarsButton(){

        if (isElementPresentAndDisplay(filterFiveStarsButton)) {
            reporter.info("Five Stars Button is found");
            findElement(filterFiveStarsButton).click();
            reporter.info("Click on 5 stars filter button");
        }else{
            reporter.info("Five Stars Filter Button is not found");
        }
        return false;
    }

    public boolean clickOnFilterFourStarsButton(){

        if (isElementPresentAndDisplay(filterFourStarsButton)) {
            reporter.info("Four Stars Button is found");
            findElement(filterFourStarsButton).click();
            reporter.info("Click on 4 stars filter button");
        }else{
            reporter.info("Four Stars Filter Button is not found");
        }
        return false;
    }

    public boolean clickOnFilterThreeStarsButton(){

        if (isElementPresentAndDisplay(filterThreeStarsButton)) {
            reporter.info("Three Stars Button is found");
            findElement(filterThreeStarsButton).click();
            reporter.info("Click on 3 stars filter button");
        }else{
            reporter.info("Three Stars Filter Button is not found");
        }
        return false;
    }


    public boolean clickOnFilterTwoStarsButton(){

        if (isElementPresentAndDisplay(filterTwoStarsButton)) {
            reporter.info("Two Stars Button is found");
            findElement(filterTwoStarsButton).click();
            reporter.info("Click on 2 stars filter button");
        }else{
            reporter.info("Two Stars Filter Button is not found");
        }
        return false;
    }

    public boolean clickOnFilterOneStarButton(){

        if (isElementPresentAndDisplay(filterOneStarButton)) {
            reporter.info("One Stars Button is found");
            findElement(filterOneStarButton).click();
            reporter.info("Click on 1 star filter button");
        }else{
            reporter.info("One Stars Filter Button is not found");
        }
        return false;
    }

}


