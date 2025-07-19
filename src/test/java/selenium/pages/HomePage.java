package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.eklipsegg.base.BasePage;
import selenium.object_repository.HomeObject;

public class HomePage extends BasePage {
    
    public HomeObject homeObject;

    public HomePage(WebDriver webDriver, Wait<WebDriver> wait) {
        super(webDriver, wait);
        
        // Initialize the HomeObject with the WebDriver
        this.homeObject = new HomeObject(webDriver);
    }

    public void verifyAccountNavDisplayed() {
        Assert.assertTrue(homeObject.accountNav.isDisplayed(), 
        "Account navigation is not displayed.");
    }

    public void skipPopUp() {
        homeObject.skipPopUpButton.click();
    }

    public void verifyAccountEmail(String expectedEmail) {
        homeObject.accountNav.click();
        System.out.println("Account email: " + homeObject.accountEmail.getText());

        Assert.assertEquals(homeObject.accountEmail.getText(), expectedEmail, 
        "Account email does not match the expected value.");
    }

}
