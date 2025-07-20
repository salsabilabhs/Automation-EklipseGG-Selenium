package selenium.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eklipsegg.base.BaseTestSuite;

import selenium.pages.AccountSettingsPage;
import selenium.pages.HomePage;
import selenium.pages.LoginPage;

public class deleteaccount extends BaseTestSuite {
    
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
        loginPage.loginValidUser("yusda@email.com", "Test12345");
        // homePage.skipPopUp();
        this.openUrl("https://app.eklipse.gg/account");
        AccountSettingsPage.closeCookiesAndNotifications();
    }

    @Test
    public void verifySuccessfulDeleteAccountWhenInputsAreValid() throws Exception {
        AccountSettingsPage.clickDeleteAccountButton();
        AccountSettingsPage.selectDeleteAccountReasonOnStep1();
        AccountSettingsPage.clickContinueOnPopUpDeletionAccount();
        AccountSettingsPage.inputDeleteAccountReasonOnStep2(3, "just a testing!");
        AccountSettingsPage.clickContinueOnPopUpDeletionAccount();
        AccountSettingsPage.inputDeleteAccountReasonOnStep3("DELETE");
        AccountSettingsPage.clickConfirmDeleteAccountButton();
    }
}
