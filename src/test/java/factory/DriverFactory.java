package factory;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

/**
 * Created by Tinashe.Chinyanga on 15/05/2017.
 */
public class DriverFactory {
    public LoginPage loginPage;

    public DriverFactory(WebDriver webDriver){
        loginPage = new LoginPage();
    }
}
