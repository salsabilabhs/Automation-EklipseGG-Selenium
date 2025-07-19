package selenium.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.eklipsegg.base.BaseTestSuite;
import selenium.pages.LoginPage;
import selenium.pages.HomePage;

public class login extends BaseTestSuite {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeSuite
    public void setUp() {
        super.setUp();
        this.openUrl("https://app.eklipse.gg/login");
        this.loginPage = new LoginPage(webDriver, wait);
        this.homePage = new HomePage(webDriver, wait);
    }

    // @BeforeClass
    // public void navigateToLoginPage() {
    //     webDriver.get("https://app.eklipse.gg/login"); // Replace with the actual login URL
    // }


    @Test
    public void verifyLoginWithValidEmailAndPassword() throws Exception {
        // Fill in the email and password fields
        loginPage.fillTheEmail("ishinyeeun@gmail.com");
        loginPage.fillThePassword("Test12345");
        // Click the login button
        loginPage.clickLoginBtn();
        //Verify the login was successful
        loginPage.verifyUrl();
        homePage.skipPopUp();
        homePage.verifyAccountNavDisplayed();
        homePage.verifyAccountEmail("ishinyeeun@gmail.com");
    }

    @Test
    public void verifyLoginWithInvalidEmail() throws Exception {
        loginPage.fillTheEmail("test@gmail.com");
        loginPage.fillThePassword("Test12345");
        loginPage.clickLoginBtn();
        // Verify the pop-up error is displayed
        loginPage.verifyPopUpErrorDisplayed();
    }

    // @Test
    public void verifyLoginWithInvalidPassword() throws Exception {
        loginPage.fillTheEmail("ishinyeeun@gmail.com");
        loginPage.fillThePassword("Haha12345");
        loginPage.clickLoginBtn();
        // Verify the pop-up error is displayed
        loginPage.verifyPopUpErrorDisplayed();
    }

    @Test
    public void clickLoginWithEmptyFields() throws Exception {
        loginPage.clearEmailField();
        loginPage.clearPasswordField();
        loginPage.clickLoginBtn();
        // Verify the pop-up error is displayed
        loginPage.verifyEmailFieldErrorMessage();
        loginPage.verifyPasswordFieldErrorMessage();
    }

    @Test
    public void clickLoginWhenEmailFieldIsEmpty() throws Exception {
        loginPage.fillThePassword("Test12345");
        loginPage.clearEmailField();
        loginPage.clickLoginBtn();
        // Verify the pop-up error is displayed
        loginPage.verifyEmailFieldErrorMessage();
    }
    
    @Test
    public void clickLoginWhenPasswordFieldIsEmpty() throws Exception {
        loginPage.fillTheEmail("ishinyeeun@gmail.com");
        loginPage.clearPasswordField();
        loginPage.clickLoginBtn();
        // Verify the pop-up error is displayed
        loginPage.verifyPasswordFieldErrorMessage();
    }

    @AfterTest
    public void afterTest() {
        // Add any cleanup code if necessary
        loginPage.clearEmailField();
        loginPage.clearPasswordField();
        this.openUrl("https://app.eklipse.gg/login");
    }

    // @AfterSuite
    public void tearDown() {
        super.tearDown();
    }
}
