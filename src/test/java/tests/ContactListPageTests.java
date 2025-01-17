package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListPageTests {

    private WebDriver driver;

    // Set up the WebDriver
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update the path to your ChromeDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Optional implicit wait
        driver.manage().window().maximize();
    }

    // Test method to verify the visibility of the "Log In" button
    public void verifyLogoutButtonVisible() {
        try {
            // Navigate to the page where the button is expected
            driver.get("https://your-application-url.com"); // Replace with your application URL
            
            // Wait explicitly for the element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Log In']")));

            // Verify the button is displayed
            if (loginButton.isDisplayed()) {
                System.out.println("The 'Log In' button is visible.");
            } else {
                System.err.println("The 'Log In' button is not visible.");
            }
        } catch (TimeoutException e) {
            System.err.println("The 'Log In' button was not found within the timeout period.");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.err.println("The 'Log In' button is not present on the page.");
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.err.println("A WebDriver exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Tear down the WebDriver
            tearDown();
        }
    }

    // Clean up and close the browser
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Main method to run the test
    public static void main(String[] args) {
        ContactListPageTests tests = new ContactListPageTests();
        tests.setUp();
        tests.verifyLogoutButtonVisible();
    }
}
