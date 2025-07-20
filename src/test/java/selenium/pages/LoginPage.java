package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;

import com.eklipsegg.base.BasePage;
import selenium.object_repository.LoginObject;


public class LoginPage extends BasePage {

    public LoginObject loginObject;

    public LoginPage(WebDriver webDriver, Wait<WebDriver> wait) {
        super(webDriver, wait);
        
        // Initialize the LoginObject with the WebDriver
        this.loginObject = new LoginObject(webDriver);
    }

    public void fillTheEmail(String email) {
        loginObject.emailField.sendKeys(email);
    }

    public void fillThePassword(String password) {
        loginObject.passwordField.sendKeys(password);
    }

    public void clearEmailField() {
        loginObject.emailField.clear();
    }

    public void clearPasswordField() {
        loginObject.passwordField.clear();
    }

    public void clickLoginBtn() throws Exception {
        loginObject.loginButton.click();
        Thread.sleep(Duration.ofSeconds(3).toMillis());
    }

    public void loginValidUser(String email, String password) throws Exception {
        fillTheEmail(email);
        fillThePassword(password);
        clickLoginBtn();
    }

    public void verifyUrl() {
        // Implement verification logic here, e.g., checking for a successful login message or redirect
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://app.eklipse.gg/home", 
        "URL tidak sesuai setelah login.");
        // This method can be expanded based on the application's behavior after a successful login
    }

    public void verifyPopUpErrorDisplayed() {
        Assert.assertTrue(loginObject.popUpError.isDisplayed(), 
        "Pop-up error is not displayed.");
        Assert.assertTrue(loginObject.errorText.getText().contains("Login Failed"), 
        "Error text is not as expected.");
        Assert.assertTrue(loginObject.errorDescription.getText().contains("Your account or password is incorrect. Reset or change your password."),
        "Error description is not as expected.");
        Assert.assertTrue(loginObject.continueButton.isDisplayed(), 
        "Continue button is not displayed.");
        loginObject.continueButton.click();
    }

    public void verifyEmailFieldErrorMessage() {
        String actualMsg = (String) js.executeScript("return arguments[0].validationMessage;", loginObject.emailField);
        Assert.assertEquals(actualMsg, "Please fill out this field.", 
        "Email field validation message is incorrect.");
    }

    public void verifyPasswordFieldErrorMessage() {
        String actualMsg = (String) js.executeScript("return arguments[0].validationMessage;", loginObject.passwordField);
        Assert.assertEquals(actualMsg, "Please fill out this field.", 
        "Password field validation message is incorrect.");
    }
    
}
