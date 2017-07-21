package utils;

import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Properties;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

// CSV
// Properties
// XML

public class FileIO {

    static String TARGET_FOLDER = "target";
    static String DATA_RESOURCES = "src/main/resources/data/staging/";
    static String PROD_DATA_RESOURCES = "src/main/resources/data/production/";
    static String CONFIG_FILE = System.getProperty("config");
    static String PROPERTIES = "src/main/resources/" + (( CONFIG_FILE == null ) ? "default" : CONFIG_FILE) + ".properties";

    public static String getConfigProperty(String fieldName){
        String fileLocation = PROPERTIES;
        String result   = null;

        try {
            //open file
            File file = new File(fileLocation);
            //open input stream to read file
            FileInputStream fileInput = new FileInputStream(file);
            //create Properties object
            Properties properties = new Properties();
            //load properties from file
            properties.load(fileInput);
            //close file
            fileInput.close();
            //get property by name
            result = properties.getProperty(fieldName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Config was not found");
        } catch (IOException e) {
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Config was not opened");
        } catch (Exception e){
            e.printStackTrace();
            ReporterManager.Instance.fatalFail("Field was not found: " + fieldName);
        }
        return result;
    }



/*
    //function to get URL field from different types of data sources
    public static String getItemFromSource(String sourceType, String itemName) {

        switch (sourceType){
            case "XML":
                return getItemFromXML(itemName);
            case "XML_XPATH":
                return getItemFromXML_UsingXpath(itemName);
            case "CSV":
                return getItemFromCSV(itemName);
            case "Properties":
                return getItemFromProperties(itemName);
            default:
                return "";
        }

    }

    //retrieve field from Properties file
    // using Properties object
    private static String getItemFromProperties(String fieldName) {
        String fileLocation = propertiesFile;
        String result   = null;

        try {
            //open file
            File file = new File(fileLocation);
            //open input stream to read file
            FileInputStream fileInput = new FileInputStream(file);
            //create Properties object
            Properties properties = new Properties();
            //load properties from file
            properties.load(fileInput);
            //close file
            fileInput.close();
            //get property by name
            result = properties.getProperty(fieldName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    //retrieve field from CSV

    private static String getItemFromCSV(String fieldName) {
        String fileLocation = CSVFile;
        String result   = null;

        String[] items;

        String separator=",";

        try {

            //open file using BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));

            //read file line by line
            for(String line; (line = br.readLine()) != null; ) {
                //split line using separator
                items = line.split(separator);
                //if first element in array (first column) = fieldName
                if (items[0].equals(fieldName)){
                    //return item
                    result=items[1];
                }
            }
            //close filed
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    //get value from XML
    //using DocumentBuilderFactory, DocumentBuilder and Document objects
    private static String getItemFromXML(String fieldName) {
        String fileLocation = XMLFile;
        String result   = null;

        try {
            //open file
            File fXmlFile = new File(fileLocation);
            //create factory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //create new builder using factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //create new document parsing XML file
            Document doc = dBuilder.parse(fXmlFile);

            //get list of "elements"
            NodeList nList = doc.getElementsByTagName("item");
            //iterate through list of elements
            for (int temp = 0; temp < nList.getLength(); temp++) {
                //get "elements" node
                Node nNode = nList.item(temp);
                //transform Node into Element
                Element eElement = (Element) nNode;

                //if first 'element' has value = to fieldName
                if (eElement.getElementsByTagName("name").item(0).getTextContent().equals(fieldName) )
                    //return first 'value' field
                    result = eElement.getElementsByTagName("value").item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // get field from XML
    // based on tutorial: http://viralpatel.net/blogs/java-xml-xpath-tutorial-parse-xml/

    private static String getItemFromXML_UsingXpath(String fieldName) {

        String fileLocation = XMLFile;
        String result   = null;

        try {
            //open file
            File fXmlFile = new File(fileLocation);
            //create factory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //create new builder using factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //create new document parsing XML file
            Document doc = dBuilder.parse(fXmlFile);

            //create xpath object from factory
            XPath xPath = XPathFactory.newInstance().newXPath();

            //prepare xpath
            //get 'value' field inside of first 'element' with type='url'
            String expression = "//element[@type='" + fieldName + "']/value";

            //read a string value from doc using xpath
            result = xPath.compile(expression).evaluate(doc);

        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
*/

    public static String takeScreenshot(WebDriver driver){
            return takeScreenshot(driver, String.valueOf(System.currentTimeMillis()));
    }

    public static String takeScreenshot(WebDriver driver, String name){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = name + "screen.png";
        try {
            FileUtils.copyFile(file, new File(TARGET_FOLDER + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    public static String getDataFile(String filename){
        if (FileIO.getConfigProperty("EnvType").equals("PROD"))
            return PROD_DATA_RESOURCES + filename;
        else
            return DATA_RESOURCES + filename;
    }
}

