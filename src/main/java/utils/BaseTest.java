package utils;

import listeners.GenerateReport;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;
import utils.DriverProvider;
import utils.ReporterManager;

import java.lang.reflect.Method;


public class BaseTest{

    ReporterManager reporter;

    @BeforeMethod
    public void startTest(Method method) {

        //init reporter
        reporter = ReporterManager.Instance;
        reporter.startReporting(method);

        //init threadlocal driver
        try {
            BasePage.driver.set(DriverProvider.getDriver());
            //BasePage.driver = DriverProvider.getDriver();
        }catch (Exception e){
            reporter.fail("Before test failure", e);
            reporter.stopReporting();
            reporter.closeReporter();
        }

        BasePage.driver().manage().window().maximize();

    }

    @AfterMethod
    public void endTest(ITestResult testResult){

        reporter.stopReporting(testResult);

        BasePage.driver().quit();
        DriverProvider.closeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void flushReporter() {
        reporter.closeReporter();
    }
}
