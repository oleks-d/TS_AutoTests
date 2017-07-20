package pages;

import org.openqa.selenium.By;
import sun.plugin.javascript.navig.Link;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by viktorlisniak on 7/19/17.
 */
public class MagazinePage extends BasePage {
        private static MagazinePage instance;
        public static MagazinePage Instance = (instance != null) ? instance : new MagazinePage();

    public MagazinePage(){
        pageURL = "/magazine";
    }

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */
        By InBedWithHannahCheng = By.xpath("//a[@href='https://www.tomorrowsleep.com/magazine/in-bed-with-hannah-cheng/' and contains(text(),'In Bed With Hannah Cheng')]");

        String article1 = "In Bed With Hannah Cheng";

    //Map<String, String> mapArticles = new HashMap<>();


    public By getArticle(){
        return InBedWithHannahCheng;
    }








}
