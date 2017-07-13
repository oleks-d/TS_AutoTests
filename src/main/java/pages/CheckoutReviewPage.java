package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class CheckoutReviewPage extends BasePage{

    private final static String pageTitle = "";
    private static CheckoutReviewPage instance;
    public static CheckoutReviewPage Instance = (instance != null) ? instance : new CheckoutReviewPage();

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

    By paymentMethodTitle = By.xpath("//div[@class='step-title' and contains(text(),'Payment Method')]");

    /** Page Methods */

    public boolean isPaymentMethodTitleDisplayed(){
        reporter.info("Check Payment method title exists");
        return isElementPresentAndDisplay(paymentMethodTitle);
    }

}
