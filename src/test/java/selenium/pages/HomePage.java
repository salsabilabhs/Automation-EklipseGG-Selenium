package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.eklipsegg.base.BasePage;
import selenium.object_repository.HomeObject;

public class HomePage extends BasePage {
    
    public HomeObject homeObject;
    String actualText;

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

    public void verifySidebarMenuLabelsDisplayed() {
        Assert.assertTrue(homeObject.menuHome.isDisplayed(), "Home menu is not displayed.");
        Assert.assertTrue(homeObject.menuClipLibrary.isDisplayed(), "Clip Library menu is not displayed.");
        // Assert.assertTrue(homeObject.submenuClipLibrary.isDisplayed(), "Clip Library submenu is not displayed.");
        Assert.assertTrue(homeObject.menuEdits.isDisplayed(), "Edits menu is not displayed.");
        // Assert.assertTrue(homeObject.submenuEdits.isDisplayed(), "Edits submenu is not displayed.");
        Assert.assertTrue(homeObject.menuContentPublisher.isDisplayed(), "Content Publisher menu is not displayed.");
        Assert.assertTrue(homeObject.menuTimeSavingTools.isDisplayed(), "Time-saving Tools menu is not displayed.");
        // Assert.assertTrue(homeObject.submenuTimeSavingTools.isDisplayed(), "Time-saving Tools submenu is not displayed.");
    }

    public void verifySidebarMenuWordings() {
        Assert.assertEquals(homeObject.menuHome.getText(), "Home", "Home menu wording is incorrect.");
        Assert.assertEquals(homeObject.menuClipLibrary.getText(), "Clip Library", "Clip Library menu wording is incorrect.");
        Assert.assertEquals(homeObject.menuEdits.getText(), "Edits", "Edits menu wording is incorrect.");
        Assert.assertEquals(homeObject.menuContentPublisher.getText(), "Content Publisher", "Content Publisher menu wording is incorrect.");
        Assert.assertEquals(homeObject.menuTimeSavingTools.getText(), "Time-saving Tools", "Time-saving Tools menu wording is incorrect.");
    }

    public void verifyStreamsButtonWordings() {
        actualText = homeObject.actionStreams.getText();
        Assert.assertTrue(actualText.contains("Import Streams"),"Text does not contain 'Import Streams'");
        Assert.assertTrue(actualText.contains("Add new Twitch, Tiktok, YT or Kick!"),"Text does not contain 'Add new Twitch, Tiktok, YT or Kick!'");
    }

    public void verifyAIEditButtonWordings() {
        actualText = homeObject.actionAIEdit.getText();
        Assert.assertTrue(actualText.contains("AI Edit"),"Text does not contain 'AI Edit'");
        Assert.assertTrue(actualText.contains("Edit your clips using AI!"),"Text does not contain 'Edit your clips using AI!'");
    }

    public void verifyConvertToVerticalButtonWordings() {
        actualText = homeObject.actionConvertToVertical.getText();
        Assert.assertTrue(actualText.contains("Convert to Vertical"),"Text does not contain 'Convert to Vertical'");
        Assert.assertTrue(actualText.contains("Turn your videos into TikTok format"),"Text does not contain 'Turn your videos into TikTok format'");
    }

    public void verifyShareButtonWordings() {
        actualText = homeObject.actionShare.getText();
        Assert.assertTrue(actualText.contains("Share"),"Text does not contain 'Share'");
        Assert.assertTrue(actualText.contains("Post and Schedule your clips"),"Text does not contain 'Post and Schedule your clips'");
    }

    public void verifyPrivateStreamButtonWordings() {
        actualText = homeObject.actionPrivateStream.getText();
        Assert.assertTrue(actualText.contains("Private Stream"),"Text does not contain 'Private Stream");
        Assert.assertTrue(actualText.contains("Game and clip privately"),"Text does not contain 'Game and clip privately'");
    }

    public void verifySectionGiveawayWordings() {
        Assert.assertEquals(homeObject.sectionGiveawayTitle.getText(), "🚨 GIVEAWAY ALERT 🚨", 
        "GIVEAWAY ALERT title is incorrect.");
        Assert.assertEquals(homeObject.sectionGiveawayDescription.getText(), "Choose between a 4K webcam, 4k capture card, or microphone, 3 winners will be selected! Take our quiz to win!",
        "GIVEAWAY ALERT description is incorrect.");
    }

    public void verifySectionExclusiveGamesWordings() {
        Assert.assertEquals(homeObject.sectionPremiumExclusiveGamesTitle.getText(), "Premium Exclusive Games",
        "Section Premium Exclusive Games title is incorrect.");
    }

    public void verifySectionCommunityHighlightsWordings() {
        Assert.assertEquals(homeObject.sectionCommunityHighlightsTitle.getText(), "Community Highlights",
        "Section Community Highlights title is incorrect.");
    }

    public void verifySectionTutorialWordings() {
        Assert.assertEquals(homeObject.sectionTutorialTitle.getText(), "Tutorial",
        "Section Tutorial title is incorrect.");
    }

    public void verifyMemberCategoryDisplayed(String memberCategory) {
         WebElement memberCategoryElement = homeObject.MemberCategory(memberCategory);
        Assert.assertTrue(memberCategoryElement.isDisplayed(), "Member Category is not displayed.");
        Assert.assertEquals(memberCategoryElement.getText(), memberCategory, "Member Category text is incorrect.");
    }

    public void verifyCardUpgradeDisplayed() {
        Assert.assertTrue(homeObject.cardUpgrade.isDisplayed(), "Card Upgrade is not displayed.");
        Assert.assertEquals(homeObject.cardUpgradeText.getText(), "Upgrade to Premium Plan have more benefits and more", 
        "Card Upgrade text is incorrect.");
        Assert.assertTrue(homeObject.cardUpgradeButton.isDisplayed(), "Card Upgrade button is not displayed.");
    }

    public void clickPrivateStreamButton() {
        homeObject.actionPrivateStream.click();
        // Additional logic can be added here to verify the action taken after clicking the button
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://app.eklipse.gg/live-stream", 
        "Private Stream button is not directed to https://app.eklipse.gg/live-stream");
    }

    public void verifyUnlockWithPremiumButtonDisplayed() {
        Assert.assertTrue(homeObject.unlockWithPremiumButton.isDisplayed(), "Unlock with Premium button is not displayed.");
        Assert.assertEquals(homeObject.unlockWithPremiumButton.getText(), "Unlock with Premium", 
        "Unlock with Premium button text is incorrect.");
    }

}
