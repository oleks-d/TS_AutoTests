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

    By xFiveStarsButton = By.xpath(".//span[contains(.,'5 Stars')]");
    By xFourStarsButton = By.xpath(".//span[contains(.,'4 Stars')]");
    By xThreeStarsButton = By.xpath(".//span[contains(.,'3 Stars')]");
    By xTwoStarsButton = By.xpath(".//span[contains(.,'2 Stars')]");
    By xOneStarButton = By.xpath(".//span[contains(.,'1 Star')]");


    // Non clicked Histogram Filters

    By fiveStarsFilterHistogram = By.xpath(".//*[@class='pr-histogram-5Stars  pr-histogram-stars']");
    By fourStarsFilterHistogram = By.xpath(".//*[@class='pr-histogram-4Stars  pr-histogram-stars']");
    By threeStarsFilterHistogram = By.xpath(".//*[@class='pr-histogram-3Stars  pr-histogram-stars']");
    By twoStarsFilterHistogram = By.xpath(".//*[@class='pr-histogram-2Stars  pr-histogram-stars']");
    By oneStarFilterHistogram = By.xpath(".//*[@class='pr-histogram-1Stars  pr-histogram-stars']");


    // Clicked Histogram Filters

    By fiveStarsFilterHistogramClicked = By.xpath(".//*[@class='pr-histogram-5Stars  pr-histogram-stars pr-hist-filter-5']");
    By fourStarsFilterHistogramClicked = By.xpath(".//*[@class='pr-histogram-4Stars  pr-histogram-stars pr-hist-filter-4']");
    By threeStarsFilterHistogramClicked = By.xpath(".//*[@class='pr-histogram-3Stars  pr-histogram-stars pr-hist-filter-3']");
    By twoStarsFilterHistogramClicked = By.xpath(".//*[@class='pr-histogram-2Stars  pr-histogram-stars pr-hist-filter-2']");
    By oneStarFilterHistogramClicked = By.xpath(".//*[@class='pr-histogram-1Stars  pr-histogram-stars pr-hist-filter-1']");


    // Reting reviews locators

    By rated5outOf5stars = By.xpath(".//span[contains(.,'Rated 5 out of 5 stars')]");
    By rated4outOf5stars = By.xpath(".//span[contains(.,'Rated 4 out of 5 stars')]");
    By rated3outOf5stars = By.xpath(".//span[contains(.,'Rated 3 out of 5 stars')]");
    By rated2outOf5stars = By.xpath(".//span[contains(.,'Rated 2 out of 5 stars')]");
    By rated1outOf5stars = By.xpath(".//span[contains(.,'Rated 1 out of 5 stars')]");


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


    // Filter bar methods (Unnecessary)

//    public boolean filterBarsAvailabilityVerification(){
//        reporter.info("Checking filter bars for availability");
//        return isElementPresentAndDisplay(filterBar5)
//                && isElementPresent(filterBar4)
//                && isElementPresent(filterBar3)
//                && isElementPresent(filterBar2)
//                && isElementPresent(filterBar1);
//    }



    // Filter Bar methods

    public void clickOnFiveStarsBar(){ //ver. 1
        if(findElement(filterBar5).getText().contains("0")) {
            reporter.info("0 reviews found. Can't click on 5 stars filter bar");
        }
        else{
            findElement(filterBar5).click();
            reporter.info("Click on 5 stars filter bar");
        }
    }

    public void clickOnFourStarsBar(){ //ver. 1
        if(findElement(filterBar4).getText().contains("0")) {
            reporter.info("0 reviews found. Can't click on 4 stars filter bar");
        }
        else{
            findElement(filterBar4).click();
            reporter.info("Click on 4 stars filter bar");
        }
    }

    public void clickOnThreeStarsBar(){ //ver. 1
        if(findElement(filterBar3).getText().contains("0")) {
            reporter.info("0 reviews found. Can't click on 3 stars filter bar");
        }
        else{
            findElement(filterBar3).click();
            reporter.info("Click on 3 stars filter bar");
        }
    }

    public void clickOnTwoStarsBar(){ //ver. 1
        if(findElement(filterBar2).getText().contains("0")) {
            reporter.info("0 reviews found. Can't click on 2 stars filter bar");
        }
        else{
            findElement(filterBar2).click();
            reporter.info("Click on 2 stars filter bar");
        }
    }

    public void clickOnOneStarsBar(){ //ver. 1
        if(findElement(filterBar1).getText().contains("0")) {
            reporter.info("0 reviews found. Can't click on 1 star filter bar");
        }
        else{
            findElement(filterBar1).click();
            reporter.info("Click on 1 star filter bar");
        }
    }



    //  Filter removal methods


    public void removeFiveStarsFilter(){ //ver. 2
        if(isElementPresentAndDisplay(xFiveStarsButton)){
            findElement(xFiveStarsButton).click();
            reporter.info("Click on 5 stars filter button and removing filter");
        }else{
            reporter.info("5 Stars filter removal button was not found");
        }
    }

    public void removeFourStarsFilter(){ //ver. 2
        if(isElementPresentAndDisplay(xFourStarsButton)){
            findElement(xFourStarsButton).click();
            reporter.info("Click on 4 stars filter button and removing filter");
        }else{
            reporter.info("4 Stars filter removal button was not found");
        }
    }

    public void removeThreeStarsFilter(){ //ver. 2
        if(isElementPresentAndDisplay(xThreeStarsButton)){
            findElement(xThreeStarsButton).click();
            reporter.info("Click on 3 stars filter button and removing filter");
        }else{
            reporter.info("3 Stars filter removal button was not found");
        }
    }

    public void removeTwoStarsFilter(){ //ver. 2
        if(isElementPresentAndDisplay(xTwoStarsButton)){
            findElement(xTwoStarsButton).click();
            reporter.info("Click on 2 stars filter button");
        }else{
            reporter.info("2 Stars filter removal button was not found");
        }
    }

    public void removeOneStarFilter(){ //ver. 2
        if(isElementPresentAndDisplay(xOneStarButton)){
            findElement(xOneStarButton).click();
            reporter.info("Click on 1 stars filter button");
        }else{
            reporter.info("1 Star filter removal button was not found");
        }
    }



    //Filter successful removal verification

    public boolean fiveStarsFilterVerification(){
        if(isElementPresentAndDisplay(xFiveStarsButton)){
            findElement(xFiveStarsButton).getText().contains("5 Stars");
            reporter.info("5 Stars Removal button is still present");
            return false;
        }else {
            reporter.info("5 Stars Removal button is not present");
        }
        return true;
    }

    public boolean fourStarsFilterVerification(){
        if(isElementPresentAndDisplay(xFourStarsButton)){
            findElement(xFourStarsButton).getText().contains("4 Stars");
            reporter.info("4 Stars Removal button is still present");
            return false;
        }else {
            reporter.info("4 Stars Removal button is not present");
        }
        return true;
    }

    public boolean threeStarsFilterVerification(){
        if(isElementPresentAndDisplay(xFiveStarsButton)){
            findElement(xThreeStarsButton).getText().contains("3 Stars");
            reporter.info("3 Stars Removal button is still present");
            return false;
        }else {
            reporter.info("3 Stars Removal button is not present");
        }
        return true;
    }

    public boolean twoStarsFilterVerification(){
        if(isElementPresentAndDisplay(xTwoStarsButton)){
            findElement(xTwoStarsButton).getText().contains("2 Stars");
            reporter.info("3 Stars Removal button is still present");
            return false;
        }else {
            reporter.info("3 Stars Removal button is not present");
        }
        return true;
    }

    public boolean oneStarFilterVerification(){
        if(isElementPresentAndDisplay(xTwoStarsButton)){
            findElement(xTwoStarsButton).getText().contains("1 Star");
            reporter.info("1 Star Removal button is still present");
            return false;
        }else {
            reporter.info("1 Star Removal button is not present");
        }
        return true;
    }


//    public boolean twoStarsFilterVerification(){ // OLD
//        isElementPresentAndDisplay(twoStarsFilterHistogram);
//        reporter.info("2 Stars Bar is found and active. Filter removed successfully");
//        return true;
//    }

//    public boolean clickOnFilterFiveStarsButton(){ //Ver 1 OLD
//
//        if (isElementPresentAndDisplay(filterFiveStarsButton)) {
//            reporter.info("Five Stars Button is found");
//            findElement(filterFiveStarsButton).click();
//            reporter.info("Click on 5 stars filter button");
//        }else{
//            reporter.info("Five Stars Filter Button is not found");
//        }
//        return false;
//    }


    // Reviews verification

    public boolean isFiveStarsReviewPresent(){ //TODO playing with returns in case no active button or reviews
        if(findElement(filterBar5).getText().contains("0")){
            reporter.info("5 Stars Reviews are not found. 0 reviews");
        } else{
            isElementPresentAndDisplay(rated5outOf5stars);
            reporter.info("5 Stars Reviews are found");
        }
        return true;
    }

    public boolean isFourStarsReviewPresent(){ //TODO playing with returns in case no active button or reviews
        if(findElement(filterBar4).getText().contains("0")){
            reporter.info("4 Stars Reviews are not found. 0 reviews");
        } else{
            isElementPresentAndDisplay(rated4outOf5stars);
            reporter.info("4 Stars Reviews are found");
        }
        return true;
    }

    public boolean isThreeStarsReviewPresent(){ //TODO playing with returns in case no active button or reviews
        if(findElement(filterBar3).getText().contains("0")){
            reporter.info("3 Stars Reviews are not found. 0 reviews");
        } else{
            isElementPresentAndDisplay(rated3outOf5stars);
            reporter.info("3 Stars Reviews are found");
        }
        return true;
    }

    public boolean isTwoStarsReviewPresent(){ //TODO playing with returns in case no active button or reviews
        if(findElement(filterBar2).getText().contains("0")){
            reporter.info("2 Stars Reviews are not found. 0 reviews");
        } else{
            isElementPresentAndDisplay(rated2outOf5stars);
            reporter.info("2 Stars Reviews are found");
        }
        return true;
    }

    public boolean isOneStarReviewPresent(){ //TODO playing with returns in case no active button or reviews
        if(findElement(filterBar1).getText().contains("0")){
            reporter.info("1 Star Reviews are not found. 0 reviews");
        } else{
            isElementPresentAndDisplay(rated1outOf5stars);
            reporter.info("1 Star Reviews are found");
        }
        return true;
    }

//    public boolean isOneStarReviewPresent(){ //OLD
//        isElementPresentAndDisplay(rated1outOf5stars);
//        reporter.info("One Star Reviews are found");
//        return true;
//    }

}


