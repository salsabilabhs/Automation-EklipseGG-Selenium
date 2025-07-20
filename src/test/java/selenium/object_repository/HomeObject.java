package selenium.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eklipsegg.base.BaseObject;

public class HomeObject extends BaseObject {

    @FindBy(xpath = "(//ul[@class='nav-account nav'])[2]")
    public WebElement accountNav;

    @FindBy(xpath = "//small[@class='role-name']")
    public WebElement accountEmail;

    @FindBy(xpath = "(//div[@class=\"user-info\"]//span[@class=\"full-name\"])[1]")
    public WebElement accountName;
    
    @FindBy(xpath = "//button[contains(text(), 'Skip for now')]")
    public WebElement skipPopUpButton;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li//a[@href='/home']")
    public WebElement menuHome;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li//a//span[contains(text(), 'Clip Library')]")
    public WebElement menuClipLibrary;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li//div[@id='submenu-1']")
    public WebElement submenuClipLibrary;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li//a[@href='/edited-clip/ai-edit']//span[contains(text(), 'Edits')]")
    public WebElement menuEdits;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li//div[@id='submenu-2']")
    public WebElement submenuEdits;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li//a[@href='/content-planner']")
    public WebElement menuContentPublisher;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li//a[@href='/tiktok-backup']//span[contains(text(), 'Time-saving Tools')]")
    public WebElement menuTimeSavingTools;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li//div[@id='submenu-4']")
    public WebElement submenuTimeSavingTools;

    @FindBy(xpath = "//div[@aria-label='Import Streams - Add new Twitch, Tiktok, YT or Kick!']")
    public WebElement actionStreams;

    @FindBy(xpath = "//div[@aria-label='[object Object] - Edit your clips using AI!']")
    public WebElement actionAIEdit;

    @FindBy(xpath = "//div[@aria-label='Convert to Vertical - Turn your videos into TikTok format']")
    public WebElement actionConvertToVertical;

    @FindBy(xpath = "//div[@aria-label='Share - Post and Schedule your clips']")
    public WebElement actionShare;

    @FindBy(xpath = "//div[@aria-label='[object Object] - Game and clip privately']")
    public WebElement actionPrivateStream;

    @FindBy(xpath = "//div[@class='col px-4']//h3")
    public WebElement sectionGiveawayTitle;

    @FindBy(xpath = "//div[@class='col px-4']//div//p")
    public WebElement sectionGiveawayDescription;

    @FindBy(xpath = "//div[@class='hypegame-container']//div//h4")
    public WebElement sectionPremiumExclusiveGamesTitle;

    @FindBy(xpath = "//div[@class='community-highlight-container']//h3")
    public WebElement sectionCommunityHighlightsTitle;

    @FindBy(xpath = "//div[@class='tutorial-playlist-container']//h4")
    public WebElement sectionTutorialTitle;

    // @FindBy(xpath = "//ul[@class='sidebar-menu']//li//a//span[contains(text(), '+ memberCategory +')]")
    // public WebElement MemberCategory;

    public WebElement MemberCategory(String memberCategory) {
        return webDriver.findElement(By.xpath("//ul[@class='sidebar-menu']//li//a//span[contains(text(), '" + memberCategory + "')]"));
    }

    @FindBy(xpath = "//div[@class='sidebar-submenu']")
    public WebElement cardUpgrade;

    @FindBy(xpath = "//div[@class='sidebar-submenu']//p")
    public WebElement cardUpgradeText;

    @FindBy(xpath = "//div[@class='sidebar-submenu']//button")
    public WebElement cardUpgradeButton;

    @FindBy(xpath = "//div[@class='live-container']//button")
    public WebElement unlockWithPremiumButton;

    public HomeObject(WebDriver webDriver) {
        super(webDriver);

        // Init Element
        PageFactory.initElements(webDriver, this);
    }
}
