package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class SignUpPageTests {

    WebDriver driver;

    public void setup() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application");

        // Initialize the WebDriver
        driver = new ChromeDriver();

        // Open the website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    public void verifySignUpWithMissingFields() {
        try {
            // Wait for the "Sign Up" button to become clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up")));

            // Click the "Sign Up" button
            signUpButton.click();

            // Ensure the page switches properly if a new window/tab opens
            switchToLatestWindow();

            // Verify if the sign-up form is visible
            WebElement signUpForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signupForm")));
            if (signUpForm.isDisplayed()) {
                System.out.println("Sign-up form is visible. Test Passed.");
            } else {
                System.out.println("Sign-up form is not visible. Test Failed.");
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public void verifySignUpWithValidDetails() {
        try {
            // Wait for the "Sign Up" button to become clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up")));

            // Click the "Sign Up" button
            signUpButton.click();

            // Ensure the page switches properly if a new window/tab opens
            switchToLatestWindow();

            // Fill in valid details in the sign-up form
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
            WebElement submitButton = driver.findElement(By.id("submit"));

            usernameField.sendKeys("RithikaSubash");
            passwordField.sendKeys("Rithu2620");
            confirmPasswordField.sendKeys("Rithu2620");

            // Click the submit button
            submitButton.click();

            // Verify successful sign-up (assuming a success message appears)
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
            if (successMessage.isDisplayed()) {
                System.out.println("Sign-up was successful. Test Passed.");
            } else {
                System.out.println("Sign-up failed. Test Failed.");
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private void switchToLatestWindow() {
        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();

        // Switch to the latest window if there's more than one
        for (String handle : allWindows) {
            if (!handle.equals(currentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static void main(String[] args) {
        SignUpPageTests test = new SignUpPageTests();
        test.setup();
        test.verifySignUpWithMissingFields();
        test.verifySignUpWithValidDetails();
    }
}
