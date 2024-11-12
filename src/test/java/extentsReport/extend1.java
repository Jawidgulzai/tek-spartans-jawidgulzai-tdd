package extentsReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
import java.util.List;

public class extend1 {
    public static void main(String[] args) throws IOException {
// Engine
        ExtentReports extentReports = new ExtentReports();
// class to generate open source
        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String path = System.getProperty("user.dir")
                + "/src/test/resources/configs/{env}-config.properties" + "Report" + randomNumber + ".html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        extentReports.attachReporter(sparkReporter);
// to create a new test
        extentReports.createTest("test1");
        extentReports.createTest("test2");
        extentReports.createTest("test3");
        extentReports.createTest("test4");
        extentReports.createTest("test5");
// log levels
        extentReports.createTest("test1").log(Status.INFO, "infor")
//bold
// .log(Status.INFO, "<b>infor</b>")
                .log(Status.PASS, "pass")
                .log(Status.FAIL, "fail")
                .log(Status.WARNING, "warning")
                .log(Status.SKIP, "skip")
                .log(Status.INFO, "info")
                .log(Status.FAIL, "Fail");
// order of Log level Fail, skip, warning, pass, info
// ===============================================================
// how to pass XML and Json data
        String Xml = " <menu id=\"file\" value=\"File\">\n" +
                " <popup>\n" +
                " <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
                " <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
                " <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
                " </popup>\n" +
                "</menu>";
        String Json = "{\"menu\": {\n" +
                " \"id\": \"file\",\n" +
                " \"value\": \"File\",\n" +
                " \"popup\": {\n" +
                " \"menuitem\": [\n" +
                " {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                " {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                " {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                " ]\n" +
                " }\n" +
                "}}";
// if we add it direct way we don't see the whole report
        extentReports.createTest("test1").info(Xml);
        extentReports.createTest("test2").info(Json);

// how to handle it
        extentReports.createTest("test3").info(MarkupHelper.createCodeBlock(Xml, CodeLanguage.XML));
        extentReports.createTest("test4").log(Status.INFO, MarkupHelper.createCodeBlock(Json, CodeLanguage.JSON));
// List, Map And set
        Map<Integer, String> mapData = new HashMap<>();
        mapData.put(1, "Mike");
        mapData.put(2, "asdf");
        mapData.put(3, "asdf");
        mapData.put(4, "Ahmdfgad");
        mapData.put(5, "dfg");
        mapData.put(6, "dfg");

        Set<Integer> setDat = new HashSet<>();
        setDat.add(123);
        setDat.add(1234);
        setDat.add(233454344);
        setDat.add(1345342453);
        setDat.add(233454534);
        setDat.add(233455344);
        List<String> ListDat = new ArrayList<>();
        ListDat.add("Ahmad Kabir");
        ListDat.add("Jamshid");
        ListDat.add("Yousef");
        ListDat.add("Ahmad Kabir");
        ListDat.add("Jamshid");
        ListDat.add("Yousef");

        extentReports.createTest("list test number 1").info(MarkupHelper.createOrderedList(ListDat));
        extentReports.createTest("list").info(MarkupHelper.createUnorderedList(ListDat));
        extentReports.createTest("set").log(Status.INFO, MarkupHelper.createUnorderedList(setDat));
        extentReports.createTest("set").log(Status.INFO, MarkupHelper.createOrderedList(setDat));
        extentReports.createTest("Map").log(Status.INFO, MarkupHelper.createOrderedList(mapData));
        extentReports.createTest("Map").log(Status.INFO, MarkupHelper.createUnorderedList(mapData));
// Highlight text
        extentReports.createTest("not highlighted").log(Status.INFO, "Something to show ");
        extentReports.createTest("Highlighted").log(Status.INFO, MarkupHelper.createLabel("TekSchool is located in Virgina", ExtentColor.GREEN));
// exception log
        try {
            int a = 5 / 0;
        } catch (Exception e) {
            extentReports.createTest("Exception test")
                    .fail(e);
        }
        Throwable t = new RuntimeException("This iis a custom Exception");
        extentReports.createTest("Exception test 2")
                .fail(t);
        extentReports.flush();
        Desktop.getDesktop().browse(new File(path).toURI());
    }
}