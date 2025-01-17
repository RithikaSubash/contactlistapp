package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By loginButton = By.linkText("Log In");
    public boolean isLoginButtonVisible1() {
        try {
            WebElement loginButton = driver.findElement(By.linkText("Log In"));
            return loginButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } 
    } 


    // Wait for the Login button to be visible and return the element
    public WebElement getLoginButton() {
        // Create WebDriverWait with Duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log In")));
    }

    // Wait for the SignUp button to be clickable and return the element
    public WebElement getSignUpButton() {
        // Use Duration to specify timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        return wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up")));
    }

    // Check if the login button is visible
    public boolean isLoginButtonVisible() {
        try {
            return getLoginButton().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Click on the Login button
    public void clickLoginButton() {
        getLoginButton().click();
    }

    // Click on the SignUp button
    public void clickSignUpButton() {
        getSignUpButton().click();
    }
}
