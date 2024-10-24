package cpa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class LaunchBrowseronRealDevices {

    public static final String AUTOMATE_USERNAME = "your_username";
    public static final String AUTOMATE_ACCESS_KEY = "your_password";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "Test to launch chrome browser on BS"); // test name

        final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        try {
// go to bstackdemo.com
            driver.get("https://www.browserstack.com/");

        } catch (Exception e) {
// print any exception
            System.out.println(e);
        }
// quit the driver
        driver.quit();
    }


}//End of LaunchBrowseronRealDevices
