import factory.DriverFactory;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverUtilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tinashe.Chinyanga on 11/05/2017.
 */
public class LoginTest {
//    should focus only on testing login
    private WebDriver driver = DriverUtilities.getDriver();

    @Test
    public void testLogin(){
        DriverFactory driverFactory = new DriverFactory(DriverUtilities.getDriver());
        driverFactory.loginPage.navigateToLogin();
//        driver.navigate().to("http://192.168.103.85:5555/Web");
        assertThat(driverFactory.loginPage.getTitle(), is(equalTo("The Internet")));

        driverFactory.loginPage.verifyPageElements();

        driverFactory.loginPage.enterUsername();
        driverFactory.loginPage.enterPassword();

        driverFactory.loginPage.submitCredentials();

        System.out.println("Waiting for page to load... ");
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("The Internet"));
        try {
            assertTrue((driver.getTitle().equals("The Internet")));
        }catch (Error e){
            System.out.println("Titles do not match");
        }

        WebElement logoutButton = driver.findElement(By.cssSelector("[class='button secondary radius']"));
        System.out.println("Logging out now...");
        logoutButton.click();

    }

    @After
    public void closeWebdriver(){
        driver.close();
        driver.quit();
    }
}
