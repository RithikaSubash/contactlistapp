package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageTests {

    private WebDriver driver;
    
    public void setup() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application");

        // Initialize the WebDriver
        driver = new ChromeDriver();

        // Open the website
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.manage().window().maximize();
    }

    // Setup WebDriver and navigate to the website
    public HomePageTests() {
        this.driver = new ChromeDriver();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @Test
    public void verifyLoginButtonVisible() {
        try {
            // Wait for the login button to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

            // Assert the login button is visible
            Assert.assertTrue(loginButton.isDisplayed(), "Login button is not visible");
            System.out.println("Login button is visible. Test Passed.");

        } catch (Exception e) {
            System.out.println("Error occurred in verifyLoginButtonVisible: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public void verifySignUpButtonClickable() {
        try {
            // Wait for the "Sign Up" button to become clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up")));

            // Assert the button is clickable
            Assert.assertTrue(signUpButton.isEnabled(), "Sign Up button is not clickable");
            System.out.println("Sign Up button is clickable. Test Passed.");

        } catch (Exception e) {
            System.out.println("Error occurred in verifySignUpButtonClickable: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void main(String[] args) {
        HomePageTests test = new HomePageTests();
        test.setup();

        // Run test cases
        test.verifyLoginButtonVisible();
        test.verifySignUpButtonClickable();
    }
}
