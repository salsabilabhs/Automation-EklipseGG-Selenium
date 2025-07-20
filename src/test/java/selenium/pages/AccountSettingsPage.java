package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import com.eklipsegg.base.BasePage;
import selenium.object_repository.AccountSettingsObject;
import selenium.object_repository.HomeObject;

public class AccountSettingsPage extends BasePage {

    public AccountSettingsObject accountSettingsObject;
    public HomeObject homeObject;

    public void closeCookiesAndNotifications() {
        wait.until(e-> accountSettingsObject.notNowNotificationButton.isDisplayed());
        wait.until(e-> accountSettingsObject.closeCookieButton.isDisplayed());
        accountSettingsObject.closeCookieButton.click();
        accountSettingsObject.notNowNotificationButton.click();
    }

    public void verifySocialAccountLabels() {
        // List of Social Accounts Name
        List<String> expectedTexts = Arrays.asList(
            "Connected Account",
            "Twitch",
            "Youtube",
            "Facebook",
            "Kick",
            "Rumble",
            "Add More Socials To Your Profile",
            "TikTok",
            "Discord Settings",
            "Discord Account",
            "Eklipse Bot"
        );

        for (int i = 0; i < expectedTexts.size(); i++) {
            String actualText = accountSettingsObject.sectionSocialAccountLabels(i + 1).getText().trim(); // i+1 karena XPath dimulai dari 1
            String expectedText = expectedTexts.get(i);
            Assert.assertEquals(actualText, expectedText, "Label " + expectedText + " is incorrect.");
        }
    }

    public void verifyCommunitySettingsLabels() {
        Assert.assertEquals(accountSettingsObject.communitySettingsLabel.getText(), "Community Settings",
        "Community Settings label is incorrect.");
        Assert.assertEquals(accountSettingsObject.shareClipsFieldLabel.getText(), "Share clips to Community Highlights",
        "Share clips field label is incorrect.");
    }

    public void verifyProfilePasswordAccountRemovalLabels() {
        // List of Profile, Password, and Delete Account Labels
        List<String> expectedTexts = Arrays.asList(
            "Profile settings",
            "Password",
            "Account Removal"
        );

        for (int i = 0; i < expectedTexts.size(); i++) {
            String actualText = accountSettingsObject.sectionProfilePasswordDeleteAccountLabels(i + 1).getText().trim(); // i+1 karena XPath dimulai dari 1
            String expectedText = expectedTexts.get(i);
            Assert.assertEquals(actualText, expectedText, "Label " + expectedText + " is incorrect.");
        }
    }

    public void verifyFieldsLabels() {
        Assert.assertEquals(accountSettingsObject.nameFieldLabel.getText(), "Name", "Name field label is incorrect.");
        Assert.assertEquals(accountSettingsObject.emailFieldLabel.getText(), "Email", "Email field label is incorrect.");
        Assert.assertEquals(accountSettingsObject.passwordFieldLabel.getText(), "Password", "Password field label is incorrect.");
    }

    public void switchOffShareClipsToggle() {
        accountSettingsObject.shareClipsToggle.click();
    }

    public void verifyPopUpNoticeisDisplayed() {
        accountSettingsObject.freeUserPopUpNotice.isDisplayed();
        Assert.assertEquals(accountSettingsObject.freeUserPopUpNoticeTitle.getText(), "Uh-oh, you are limited to change this option",
        "Free User Pop Up Notice Title is incorrect.");
        Assert.assertEquals(accountSettingsObject.freeUserPopUpNoticeDescriptions.getText(), "As a Free users, Eklipse automatically shares your generated clips with our community to help others discover great moments. If you wish to opt-out, please upgrade to a paid plan.",
        "Free User Pop Up Notice Description is incorrect.");
        Assert.assertTrue(accountSettingsObject.freeUserPopUpNoticeUnderstoodButton.isDisplayed(), "Free User Pop Up Notice Understood Button is not displayed.");
    }

    public void clickFreeUserPopUpNoticeUnderstoodButton() {
        accountSettingsObject.freeUserPopUpNoticeUnderstoodButton.click();
    }

    public void editProfileName(String name) {
        accountSettingsObject.nameField.isDisplayed();
        accountSettingsObject.nameField.clear();
        accountSettingsObject.nameField.sendKeys(name);
        accountSettingsObject.saveChangesButton.click();
    }

    public void verifyPopUpSuccessIsDisplayed() {
        wait.until(e -> accountSettingsObject.popUpSuccessProfileUpdated.isDisplayed());
        Assert.assertTrue(accountSettingsObject.popUpSuccessProfileUpdated.isDisplayed(), "Pop up confirmation is not displayed.");
        Assert.assertEquals(accountSettingsObject.popUpSuccessProfileUpdatedTitle.getText(), "Updated Profile",
        "Pop up confirmation title is incorrect.");
        Assert.assertEquals(accountSettingsObject.popUpSuccessProfileUpdatedDescription.getText(), "Your profile has been updated",
        "Pop up confirmation description is incorrect.");

        accountSettingsObject.popUpSuccessProfileUpdatedContinueButton.click();
    }

    public void verifyAccountNameUpdated(String name) {
        homeObject.accountNav.click();
        Assert.assertEquals(homeObject.accountName.getText(), name, 
        "Account name in the Profile is not updated.");

    }

    public void verifyEmailValueIsDisplayed(String email) {
        accountSettingsObject.emailField.isDisplayed();
        Assert.assertEquals(accountSettingsObject.emailField.getAttribute("value"), email, 
        "Email field value is not displayed correctly.");
    }

    public boolean isEmailFieldNonEditable() {
        return accountSettingsObject.emailField.getAttribute("readonly") != null;
    }

    public void verifyEmailFieldNonEditable() {
        Assert.assertTrue(isEmailFieldNonEditable(), "Email field must be non-editable");
    }

    public void clickChangePasswordButton() {
        accountSettingsObject.changePasswordButton.isDisplayed();
        accountSettingsObject.changePasswordButton.click();
        wait.until(e-> accountSettingsObject.popUpChangePassword.getAttribute("class").contains("show"));
    }

    public void changePassword(String currentPassword, String newPassword) {
        accountSettingsObject.currentPasswordField.isDisplayed();
        accountSettingsObject.newPasswordField.isDisplayed();
        accountSettingsObject.confirmPasswordField.isDisplayed();
        accountSettingsObject.changePasswordButton.isDisplayed();
        
        accountSettingsObject.currentPasswordField.sendKeys(currentPassword);
        accountSettingsObject.newPasswordField.sendKeys(newPassword);
        accountSettingsObject.confirmPasswordField.sendKeys(newPassword);
        accountSettingsObject.savePasswordChangesButton.click();
    }

    public void clickDeleteAccountButton() {
        accountSettingsObject.deleteAccountButton.isDisplayed();
        accountSettingsObject.deleteAccountButton.click();
        
        wait.until(e -> accountSettingsObject.popUpDeleteAccountForm.isDisplayed());
        Assert.assertTrue(accountSettingsObject.popUpDeleteAccountForm.isDisplayed(), "Delete Account Form is not displayed.");
        Assert.assertEquals(accountSettingsObject.popUpDeleteAccountTitle.getText(), "Account Deletion",
        "Account Deletion Form title is incorrect.");
        Assert.assertEquals(accountSettingsObject.popUpDeleteAccountDescription.getText(), 
        "We're sorry to see you go. Before you proceed with deleting your Eklipse account, we would appreciate it if you could take a moment to provide us with some feedback. Your input is valuable in helping us improve.",
        "Account Deletion Form description is incorrect.");
    }

    public void selectDeleteAccountReasonOnStep1() {
        Assert.assertTrue(accountSettingsObject.deleteAccountReason1.isDisplayed(), "Delete Account Reason 1 is not displayed.");
        Assert.assertTrue(accountSettingsObject.deleteAccountReason2.isDisplayed(), "Delete Account Reason 2 is not displayed.");
        Assert.assertTrue(accountSettingsObject.deleteAccountReason3.isDisplayed(), "Delete Account Reason 3 is not displayed.");

        accountSettingsObject.deleteAccountReason1.click();
        accountSettingsObject.deleteAccountReason2.click();
        accountSettingsObject.deleteAccountReason3.click();
    }

    public void clickContinueOnPopUpDeletionAccount() {
        Assert.assertTrue(accountSettingsObject.deleteAccountContinueButton.isDisplayed(), 
        "Continue button is not displayed.");
        accountSettingsObject.deleteAccountContinueButton.click();
    }

    public void inputDeleteAccountReasonOnStep2(int x, String feedback) {
        Assert.assertTrue(accountSettingsObject.deleteAccountCommentField.isDisplayed(),
        "Delete Account Comment Field is not displayed.");

        for (int i = 0; i < x; i++) {
            accountSettingsObject.deleteAccountMultipleReasons(i + 1).click();
        }

        accountSettingsObject.deleteAccountCommentField.clear();
        accountSettingsObject.deleteAccountCommentField.sendKeys(feedback);
    }

    public void inputDeleteAccountReasonOnStep3(String confirm) {
        Assert.assertTrue(accountSettingsObject.deleteAccountConfirmationField.isDisplayed(),
        "Delete Account Confirmation Field is not displayed.");
        
        accountSettingsObject.deleteAccountConfirmationField.sendKeys(confirm);
    }

    public void clickConfirmDeleteAccountButton() throws Exception{
        Assert.assertTrue(accountSettingsObject.confirmDeleteAccountButton.isDisplayed(),
        "Delete Account Button on pop up Deletion Account is not displayed.");

        accountSettingsObject.confirmDeleteAccountButton.click();
        Thread.sleep(Duration.ofSeconds(5).toMillis()); // Wait for the deletion process to complete
        webDriver.getCurrentUrl().contains("https://eklipse.gg/we-will-miss-you/");
    }



    public AccountSettingsPage(WebDriver webDriver, Wait<WebDriver> wait) {
        super(webDriver, wait);
        
        // Initialize the LoginObject with the WebDriver
        this.accountSettingsObject = new AccountSettingsObject(webDriver);
        this.homeObject = new HomeObject(webDriver);
    }
    
}
