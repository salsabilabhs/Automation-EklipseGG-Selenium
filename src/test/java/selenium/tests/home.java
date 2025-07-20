package selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eklipsegg.base.BaseTestSuite;
import selenium.pages.HomePage;
import selenium.pages.LoginPage;

public class home extends BaseTestSuite {
    
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeSuite
    public void setUp() {
        super.setUp();
        this.openUrl("https://app.eklipse.gg/login");
        this.loginPage = new LoginPage(webDriver, wait);
        this.homePage = new HomePage(webDriver, wait);
    }

    @BeforeTest
    public void doLogin() throws Exception {
        loginPage.loginValidUser("ishinyeeun@gmail.com", "Test12345");
        homePage.skipPopUp();
    }

    @Test
    public void verifySidebarMenuLabelsDisplayCorrectText() {
        homePage.verifySidebarMenuLabelsDisplayed();
        homePage.verifySidebarMenuWordings();
    }

    @Test(priority = 1)
    public void verifyMainActionButtonLabelsDisplayCorrectText() {
        homePage.verifyStreamsButtonWordings();
        homePage.verifyAIEditButtonWordings();
        homePage.verifyConvertToVerticalButtonWordings();
        homePage.verifyShareButtonWordings();
        homePage.verifyPrivateStreamButtonWordings();
    }

    @Test(priority = 2)
    public void verifySectionHeadersDisplayCorrectText() {
        homePage.verifySectionGiveawayWordings();
        homePage.verifySectionExclusiveGamesWordings();
        homePage.verifySectionCommunityHighlightsWordings();
        homePage.verifySectionTutorialWordings();
    }

    @Test(priority = 3)
    public void verifyUserStatusAndUpgradeButtonsAreLabeledProperly() {
        homePage.verifyMemberCategoryDisplayed("Free Member");
        homePage.verifyCardUpgradeDisplayed();
    }

    @Test(priority = 4)
    public void checkUpgradeRestrictionIfLoginAsFreeMember() {
        homePage.clickPrivateStreamButton();
        homePage.verifyUnlockWithPremiumButtonDisplayed();
    }
}
