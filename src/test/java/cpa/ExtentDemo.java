package cpa;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.File;
import java.io.IOException;

public class ExtentDemo {
    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\TestReport\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }
    @Test
    public void extentReportsDemo() throws IOException {
        //System.setProperty("webdriver.chrome.driver", "D:SubmittalExchange_TFSQAAutomation3rdpartychromechromedriver.exe");
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "E:\\D\\DDrive\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://www.google.co.in");
        if(driver.getTitle().equals("Google"))
        {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed");
        }

        if(driver.getTitle().equals("test"))
        {
            test.log(LogStatus.PASS, "This is title test");
        }
        else
        {
            //test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
        }
    }
    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }

    public static String capture(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //File Dest = new File("src/../BStackImages/" + System.currentTimeMillis() + ".png");
        File Dest = new File(System.getProperty("user.dir")+"\\TestReport\\BugImages\\" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }
}
