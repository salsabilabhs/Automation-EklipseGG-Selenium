package selenium.object_repository;

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
    
    @FindBy(xpath = "//button[contains(text(), 'Skip for now')]")
    public WebElement skipPopUpButton;

    public HomeObject(WebDriver webDriver) {
        super(webDriver);

        // Init Element
        PageFactory.initElements(webDriver, this);
    }
}
