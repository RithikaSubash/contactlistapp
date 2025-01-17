package pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[text()='Log In']");

    // Login Method
    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement loginBtn = driver.findElement(loginButton);

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public WebElement getLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
    }
    
    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("email")); // Assuming the email input field has an id of "email"
        emailField.sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password")); // Assuming the password input field has an id of "password"
        passwordField.sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        loginButton.click();
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        driver.quit();
    }

    public void clickLoginButton(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Enter login credentials
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
            emailInput.sendKeys(email);

            WebElement passwordInput = driver.findElement(passwordField);
            passwordInput.sendKeys(password);

            // Click the login button
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginBtn.click();
        } catch (Exception e) {
            throw new RuntimeException("Login failed: " + e.getMessage(), e);
        }
    }

}






