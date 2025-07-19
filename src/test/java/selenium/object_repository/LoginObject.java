package selenium.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eklipsegg.base.BaseObject;

public class LoginObject extends BaseObject {

    // Locators for the login page elements
    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Sign In')]")
    public WebElement loginButton;

    @FindBy(xpath= "//div[@role='dialog']")
    public WebElement popUpError;

    @FindBy(xpath = "//div//h2[contains(text(), 'Login Failed')]")
    public WebElement errorText;

    @FindBy(xpath = "//div[contains(text(), 'Your account or password is incorrect. Reset or change your password.')]")
    public WebElement errorDescription;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    public WebElement continueButton;

    public LoginObject(WebDriver webDriver) {
        super(webDriver);

        // Init Element
        PageFactory.initElements(webDriver, this);
    }
}
