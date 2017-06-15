package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Tinashe.Chinyanga on 12/05/2017.
 */
public abstract class DriverUtilities {
    public static WebDriver chromeDriver, ieDriver, firefoxDriver;

//    @BeforeSuite(alwaysRun = true)
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
//        chromeDriver = new ChromeDriver();
//    }

    public static WebDriver getDriver(){
        if(chromeDriver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
            chromeDriver = new ChromeDriver();
        }
        return chromeDriver;
    }

    public static WebDriver getIeDriver(){
        if(ieDriver == null){
            System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriver\\IEDriverServer.exe");
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            ieDriver = new InternetExplorerDriver(caps);
        }
        return ieDriver;
    }

    public static WebDriver getFirefoxDriver(){
        if(firefoxDriver == null){
            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Geckodriver\\geckodriver.exe");
            firefoxDriver = new FirefoxDriver();
        }
        return firefoxDriver;
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        chromeDriver.close();
        System.out.println("Closed driver, ending automated test");
        chromeDriver.quit();
    }
}
