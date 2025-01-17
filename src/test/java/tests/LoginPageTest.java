package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    private WebDriver driver;

    public void setup() {
        try {
            // Set the path to ChromeDriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rithika\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } catch (IllegalStateException e) {
            System.err.println("Error initializing WebDriver. Check the ChromeDriver path or version.");
            e.printStackTrace();
        }
    }

    public void verifyLoginWithInvalidCredentials() {
        try {
            driver.get("https://your-application-url.com"); // Replace with your login page URL

            // Locate username and password fields and login button
            WebElement usernameField = driver.findElement(By.id("username")); // Replace with actual ID
            WebElement passwordField = driver.findElement(By.id("password")); // Replace with actual ID
            WebElement loginButton = driver.findElement(By.id("loginButton")); // Replace with actual ID

            // Enter invalid credentials
            usernameField.sendKeys("invalidUser");
            passwordField.sendKeys("invalidPass");
            loginButton.click();

            // Verify error message
            WebElement errorMessage = driver.findElement(By.id("errorMessage")); // Replace with actual ID
            if (errorMessage.isDisplayed()) {
                System.out.println("Error message displayed: " + errorMessage.getText());
            } else {
                System.err.println("Error message not displayed.");
            }
        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
            e.printStackTrace();
        } finally {
            tearDown();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        LoginPageTest test = new LoginPageTest();
        test.setup();
        test.verifyLoginWithInvalidCredentials();
    }
}
