package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactListPage {
    private WebDriver driver;

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoutButtonVisible() {
        try {
            System.out.println("Waiting for Logout button to be visible...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));
            System.out.println("Logout button found.");
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            System.out.println("Logout button is not visible: " + e.getMessage());
            return false;
        }
    }
}
