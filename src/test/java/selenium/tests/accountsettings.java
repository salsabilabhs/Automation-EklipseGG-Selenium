package selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eklipsegg.base.BaseTestSuite;

import selenium.pages.AccountSettingsPage;
import selenium.pages.HomePage;
import selenium.pages.LoginPage;

public class accountsettings extends BaseTestSuite {

    private AccountSettingsPage AccountSettingsPage;
    private LoginPage loginPage;
    private HomePage homePage;
    
    @BeforeSuite
    public void setUp() {
        super.setUp();
        this.openUrl("https://app.eklipse.gg/login");
        this.AccountSettingsPage = new AccountSettingsPage(webDriver, wait);
        this.loginPage = new LoginPage(webDriver, wait);
        this.homePage = new HomePage(webDriver, wait);
    }

    @BeforeTest
    public void doLoginAndNavigateToSettings() throws Exception {
        loginPage.loginValidUser("ishinyeeun@gmail.com", "Test12345");
        homePage.skipPopUp();
        this.openUrl("https://app.eklipse.gg/account");
        AccountSettingsPage.closeCookiesAndNotifications();
    }

    @Test
    public void verifySectionAndFieldLabelsAreDisplayedCorrectly() {
        System.out.println("Verifying Social Account Labels...");
        AccountSettingsPage.verifySocialAccountLabels();

        System.out.println("Verifying Community Settings Labels...");
        AccountSettingsPage.verifyCommunitySettingsLabels();

        System.out.println("Verifying Profile, Password, and Delete Account Labels...");
        AccountSettingsPage.verifyProfilePasswordAccountRemovalLabels();
        AccountSettingsPage.verifyFieldsLabels();
    }

    @Test
    public void verifyFreeMembersCannotSwitchOffShareClipsToCommunityHighlightsToggle() {
        AccountSettingsPage.switchOffShareClipsToggle();
        AccountSettingsPage.verifyPopUpNoticeisDisplayed();
        AccountSettingsPage.clickFreeUserPopUpNoticeUnderstoodButton();

    }

    @Test
    public void verifyProfileNameCanBeUpdatedAndSavedSuccessfully() {
        AccountSettingsPage.editProfileName("Lala");
        AccountSettingsPage.verifyPopUpSuccessIsDisplayed();
        AccountSettingsPage.verifyAccountNameUpdated("Lala");
    }

    @Test
    public void verifyEmailFieldIsDisplayedAndNonEditable() {
        AccountSettingsPage.verifyEmailValueIsDisplayed("ishinyeeun@gmail.com");
        AccountSettingsPage.verifyEmailFieldNonEditable();
    }

    @Test
    public void verifySuccessfulPasswordChangeWithValidInput() {
        AccountSettingsPage.clickChangePasswordButton();
        AccountSettingsPage.changePassword("Test12345", "Test12345");
        AccountSettingsPage.verifyPopUpSuccessIsDisplayed();
    }

}


