package pages;

import org.openqa.selenium.By;
import utilities.CommonUtilities;

import static org.junit.Assert.assertTrue;

/**
 * Created by Tinashe.Chinyanga on 15/05/2017.
 */
public class LoginPage extends CommonUtilities {
    //handles accessing the login page functionality
    private static final String baseUrl = "http://the-internet.herokuapp.com";
    private static final String login = "/login";

    public void navigateToLogin(){
        System.out.println("Opening the login page.");
        navigateToUrl(baseUrl + login);
    }

    public String getTitle(){
        return getPageTitle();
    }


    public void enterUsername(){
        System.out.println("Entering username.");
        getElement(By.cssSelector("[name='username']")).sendKeys("tomsmith");
    }

    public void enterPassword(){
        waitForElementToBeDisplayed(By.cssSelector("[name='password']"));
        System.out.println("Entering password.");
        getElement(By.cssSelector("[name='password']")).sendKeys("SuperSecretPassword!");
    }

    public void submitCredentials(){
        waitForElementToBeDisplayed(By.cssSelector("[type='submit'][class='radius']"));
        System.out.println("Submitting credentials to logon.");
        getElement(By.cssSelector("[type='submit'][class='radius']")).click();
    }

    public void verifyPageElements(){
        System.out.println("Verifying default page elements");
        assertTrue(getElement(By.cssSelector("[name='password']")).isDisplayed());
    }

}
