package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Tools {


    public static String getCurDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    public static String getStackTrace(Throwable problem) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        problem.printStackTrace(printWriter);
        return result.toString();
    }

    public static String getRandomUserEmail() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_");
        return sdf.format(new Date(System.currentTimeMillis())) + String.valueOf(System.currentTimeMillis()).substring(10,13) + "@gmail.com";
    }

    public static float convertStringPriceToFloat(String strPrice){
        return Float.valueOf(strPrice.replace("$","").replace(",",""));
    }
}
