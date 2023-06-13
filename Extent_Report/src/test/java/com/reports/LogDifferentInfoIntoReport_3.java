package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class LogDifferentInfoIntoReport_3 {
    public static void main(String[] args) throws Exception{
      /*
      Log different info into the report
      - Text - Bold, Italic
      - XML
      - JSON
      - Collection Data (List, Set, Map)
      - Highlight any message
      - Exception

       */

        String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";

        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReport1.html");			// relative path with the string & if only report name > will create the report on the project directory
        extentReports.attachReporter(sparkReporter); 												// attaching spark reporter to the Extent reporter engine.


       /*
       Send beautiful text to Report ( Bold + Italic )
        */

        extentReports.createTest("Text based Test")
                .log(Status.INFO, "Generic text")                  // this is normal
                .log(Status.INFO, "<b>BOLD format</b>")           // surround the text with <b> tag just like html > BOLD
                .log(Status.INFO, "<i>Italic format</i>")          // surround with <i> for ITALIC text > go html font formatting
                .log(Status.INFO,"<b><i>Bold & Italic</i></b>");        // bold + Italic



        /*
        Send XML & JSON data into Report
         */

        String xmlData = "<menu id=\"file\" value=\"File\">\n" +
                "    <popup>\n" +
                "        <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
                "        <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
                "        <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
                "    </popup>\n" +
                "</menu>";

        String jsonData = "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";

        // pass overloaded method to format the code in the report

        extentReports.createTest("XML based test")
                .log(Status.INFO, MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));

        extentReports.createTest("JSON based test")
                .log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));





        /*
        PAss Collection Data (List, Set, Map) to the report
         */

        List<String> list = new ArrayList<>();
        list.add("Fahad");
        list.add("Kader");
        list.add("Jahan");

        Map<Integer, String > mapData = new LinkedHashMap<>();
        mapData.put(101, "Fahad");
        mapData.put(102, "Kader");
        mapData.put(103, "Jahan");

        Set<Integer> set = mapData.keySet();                                // directly taking the map keys to the SET

        // putting the List to the report
        extentReports.createTest("List Data Test")
                .log(Status.INFO, MarkupHelper.createOrderedList(list));


        // putting the MAP to the report
        extentReports.createTest("Map Data Test")
                .log(Status.INFO, MarkupHelper.createOrderedList(mapData));         // or use .info()  --> easier


        // putting the SET to the report
        extentReports.createTest("Set Data Test")
                .log(Status.INFO, MarkupHelper.createOrderedList(set));



        /*
        Highlight any Log event
         */

        extentReports.createTest("Highlight Log Test")
                .info("Not colored message")
                .info(MarkupHelper.createLabel("This is colored message", ExtentColor.AMBER));                 // Pass any text or string to highlight



        /*
        Log Exception
         */

        try {
            int i = 5 / 0;
        }catch (Exception e){

            extentReports.createTest("Exception 1").info(e);
            extentReports.createTest("Exception 2").fail(e);
        }

        Throwable t = new RuntimeException("This is a custom exception");

        extentReports.createTest("Exception 3").info(t);
        //extentReports.createTest("Exception 4").pass(t);






















        /*
        Flush & open report
         */


        // when we are done with the reporting > need to use flush
        extentReports.flush();

        // open the report after run ->  Automatically by java using - default browser
        Desktop.getDesktop().browse(new File("testReport1.html").toURI());
    }

}
