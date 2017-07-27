package utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import annotations.TestName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

    public class ReporterManager {

        private static ReporterManager instance;
        public static ReporterManager Instance = (instance != null) ? instance : new ReporterManager();

        ReporterManager(){

        }

        private static Map<Long, ExtentTest> testThread = new HashMap<Long, ExtentTest>();
        private static ExtentReports extent;

        public static Logger logger = LogManager.getLogger(ReporterManager.class);

        private synchronized static ExtentReports getInstance() {
            if (extent == null) {
                extent = new ExtentReports(FileIO.TARGET_FOLDER + File.separator + "Report" + Tools.getCurDateTime() + ".html", true, NetworkMode.ONLINE);
            }
            return extent;
        }


        public synchronized  Map<Long, ExtentTest> startTest(Method m, String testName, String testDescription) {
            Long threadID = Thread.currentThread().getId();

            ExtentTest test = getInstance().startTest(testName, testDescription);
            //test.assignCategory(DriverProvider.getCurrentBrowserName());
            for (String gr : getTestGroups(m)) {
                test.assignCategory(gr);
            }
            testThread.put(threadID, test);
            return testThread;
        }

        public synchronized static ExtentTest report() {
            ExtentTest report = null;
            Long threadID = Thread.currentThread().getId();
            if (testThread.containsKey(threadID)) {
                report = testThread.get(threadID);
            }
            return report;
        }

        public synchronized static void closeTest() {
            getInstance().endTest(report());
        }


        public synchronized static void closeReporter() {
            getInstance().flush();
        }

        public String getTestName(Method m, Object[] data) {
            String testName = null;
            String address = null;

            String[] testGroups = m.getAnnotation(Test.class).groups();
            for (int i = 0; i < testGroups.length; i++) {
                if (testGroups[i].startsWith("http")) {
                    address = testGroups[i];
                }
            }
            if (address != null) {
                testName = "<a href=" + "\"" + address + "\""
                        + "target=_blank alt=This test is linked to test case. Click to open it>"
                        + m.getAnnotation(Test.class).testName() + "</a>";
            } else {
                try{
                    testName = m.getAnnotation(TestName.class).name(); // get name from annotation
                    testName = testName + " - " + data[0].toString(); // add value from first DataProvider parameter ot test name
                }
                catch(Exception e){
                    //no TestName specified
                };

            }

            if (testName == null || testName.equals("")) {
                testName = m.getName();
            }
            return testName;
        }

        private String getTestDescription(Method m) {
            String testDescription = null;
            testDescription = m.getAnnotation(Test.class).description();
            if (testDescription == null || testDescription.equals("")) {
                testDescription = "";
            }
            return testDescription;
        }


        private String[] getTestGroups(Method m) {
            String[] testGroups = m.getAnnotation(Test.class).groups();
            if (testGroups == null || testGroups.equals("")) {
                testGroups[0] = "";
            }
            return testGroups;
        }


        public void startReporting(Method m, Object[] data) {
            startTest(m, getTestName(m, data), getTestDescription(m));
            String testGroups = "";
            for (String gr : getTestGroups(m)) {
                testGroups = testGroups + gr + "; ";
            }
            logger.info(
                    "--------------------------------------------------------------------------------------------------------");
            logger.info("Started test '" + getTestName(m, data) + "' Groups: '" + testGroups.trim() + "'");
        }

        public void stopReporting(){
            closeTest();
        }

        public void stopReporting(ITestResult result) {
            closeTest();

            if (result.getStatus() == ITestResult.FAILURE)
                fail("Test failed", result.getThrowable());
            else if (result.getStatus() == ITestResult.SKIP)
                info("Test skiped");
            else
                pass("Test passed");
        }

        public void info(String details) {
            logger.info(details);
            report().log(LogStatus.INFO, details);
        }

        public void pass(String details) {
            logger.info(details);
            report().log(LogStatus.PASS, details);
        }

        public void fail(String details) {
            String screenshotFile;
            String message = "<pre>" + details + "</pre>";
            logger.error(details);
            try {
                 screenshotFile = FileIO.takeScreenshot(DriverProvider.getDriver());
                 message = message + "<br><a href=\"" + screenshotFile + File.separator + "\" target=_blank alt>"
                        + "SCREENSHOT" + "</a><br>";
            } catch (Exception e){
                // processing of problem with taking screenshot
            }
            report().log(LogStatus.FAIL,  message);
        }

        public void fail(String details, Throwable e) {
            String exceptionString = Tools.getStackTrace(e);
            fail(details + "\n\n" + exceptionString);
        }

        public void fatalFail(String message) {
            logger.error(message);
            report().log(LogStatus.FAIL,  message);
        }
    }