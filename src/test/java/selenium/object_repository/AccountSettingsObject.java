package selenium.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eklipsegg.base.BaseObject;

public class AccountSettingsObject extends BaseObject {

    @FindBy(xpath = "//div[@id='cookie-close-icon']")
    public WebElement closeCookieButton;

    @FindBy(xpath = "//div[@class=\"cta-wrapper\"]//div[contains(text(), 'Not Now')]")
    public WebElement notNowNotificationButton;

    public WebElement sectionSocialAccountLabels(int i) {
        return webDriver.findElement(By.xpath("(//div[@class='media-accounts']//div//p)[" + i + "]"));
    }

    @FindBy(xpath = "//div[@class='community-clip-setting']//p[contains(text(), 'Community Settings')]")
    public WebElement communitySettingsLabel;

    @FindBy(xpath = "//div[@class='community-clip-setting']//p[contains(text(), 'Share clips to Community Highlights')]")
    public WebElement shareClipsFieldLabel;

    @FindBy(xpath = "(//span[@class='slider round'])[1]")
    public WebElement shareClipsToggle;

    @FindBy(xpath = "//div[@class='free-user-opt-out-notice-container']")
    public WebElement freeUserPopUpNotice;

    @FindBy(xpath = "//div[@class='free-user-opt-out-notice-container']//h5")
    public WebElement freeUserPopUpNoticeTitle;

    @FindBy(xpath = "(//div[@class='free-user-opt-out-notice-container']//p)[1]")
    public WebElement freeUserPopUpNoticeDescriptions;

    @FindBy(xpath = "//div[@class='free-user-opt-out-notice-container']//button[contains(text(), 'Understood')]")
    public WebElement freeUserPopUpNoticeUnderstoodButton;

    public WebElement sectionProfilePasswordDeleteAccountLabels(int i) {
        return webDriver.findElement(By.xpath("(//div[@class='ek-personal-detail']//p)[" + i + "]"));
    }

    @FindBy(xpath = "//div[@class='ek-personal-detail']//div//div//label[contains(text(), 'Name')]")
    public WebElement nameFieldLabel;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement nameField;

    @FindBy(xpath = "//div[@class='ek-personal-detail']//div//div//label[contains(text(), 'Email')]")
    public WebElement emailFieldLabel;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement emailField;

    @FindBy(xpath = "//div[@class='form-input-detail']//button[contains(text(), 'Save Changes')]")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//div[@class='ek-personal-detail']//div//div//span[contains(text(), 'Password')]")
    public WebElement passwordFieldLabel;

    @FindBy(xpath = "//button[@data-toggle='modal']")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//div[@id='modalChangePassword']")
    public WebElement popUpChangePassword;

    @FindBy(xpath = "//input[@name='currentPassword']")
    public WebElement currentPasswordField;

    @FindBy(xpath = "//input[@name='newPassword']")
    public WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "(//button[contains(text(), 'Save Changes')])[2]")
    public WebElement savePasswordChangesButton;

    @FindBy(xpath = "//div[@aria-labelledby='swal2-title']")
    public WebElement popUpSuccessProfileUpdated;

    @FindBy(xpath = "//div[@aria-labelledby='swal2-title']//h2")
    public WebElement popUpSuccessProfileUpdatedTitle;

    @FindBy(xpath = "//div[@aria-labelledby='swal2-title']//div[contains(text(), 'Your profile has been updated')]")
    public WebElement popUpSuccessProfileUpdatedDescription;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    public WebElement popUpSuccessProfileUpdatedContinueButton;

    @FindBy(xpath = "//div[@class='form-input-detail']//button[contains(text(), 'Delete Account')]")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//div[@class='p-4']")
    public WebElement popUpDeleteAccountForm;

    @FindBy(xpath = "//div[@class='p-4']//h3")
    public WebElement popUpDeleteAccountTitle;

    @FindBy(xpath = "//div[@class='p-4']//p")
    public WebElement popUpDeleteAccountDescription;

    @FindBy(xpath = "(//input[@name='satisfied']//following-sibling::span)[1]")
    public WebElement deleteAccountReason1;

    @FindBy(xpath = "(//input[@name='customer_service']//following-sibling::span)[1]")
    public WebElement deleteAccountReason2;

    @FindBy(xpath = "(//input[@name='recommend']//following-sibling::span)[1]")
    public WebElement deleteAccountReason3;

    @FindBy(xpath = "//div[@class='p-4']//button[contains(text(), 'Continue')]")
    public WebElement deleteAccountContinueButton;

    public WebElement deleteAccountMultipleReasons(int i) {
        return webDriver.findElement(By.xpath("(//input[@name='reason[]']//following-sibling::span)["+ i +"]"));
    }

    @FindBy(xpath = "//div[@class='p-4']//textarea")
    public WebElement deleteAccountCommentField;

    @FindBy(xpath = "//div[@class='p-4']//input[@type='text']")
    public WebElement deleteAccountConfirmationField;

    @FindBy(xpath = "//div[@class='p-4']//button[contains(text(), 'Delete Account')]")
    public WebElement confirmDeleteAccountButton;

    public AccountSettingsObject(WebDriver webDriver) {
        super(webDriver);

        // Init Element
        PageFactory.initElements(webDriver, this);
    }
    
}
