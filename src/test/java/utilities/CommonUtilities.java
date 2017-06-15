package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

/**
 * Created by Tinashe.Chinyanga on 12/05/2017.
 */
public abstract class CommonUtilities {
    public WebDriver driver;
    private WebDriverWait wait;

    public CommonUtilities(){
        driver = DriverUtilities.getDriver();
    }

    public void navigateToUrl(String URL){
        System.out.println("Navigating to: " + URL);
        try{
            driver.navigate().to(URL);
        }catch (Exception navigationException){
            System.out.println("Could not access: " + URL);
            throw new TestException("Unable to load URL");
        }
    }

    public String getPageTitle(){
        try{
            System.out.print(String.format("The page title is: %s\n", driver.getTitle()));
            return driver.getTitle();
        }catch (Exception pageTitleExeception){
            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
        }
    }

    public WebElement getElement(By selector){
        try{
            return driver.findElement(selector);
        }catch (Exception getElementException){
            System.out.println(String.format("Element %s does not exist. Proceeding as is.", selector));
        }
        return null;
    }

    public void waitForElementToBeDisplayed(By selector){
        try {
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        }catch (Exception elementNotDisplayed){
            throw new NoSuchElementException(String.format("The following element; %s, was not loaded in [%s] seconds", selector, "10".toString()));
        }
    }
}
