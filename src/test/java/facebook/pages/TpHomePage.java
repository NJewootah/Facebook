package facebook.pages;

import facebook.support.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class TpHomePage 
{
    private WebDriver driver;
    @FindBy(css = ".action-panel-trigger-share")
    private WebElement shareMenu;
    @FindBy(css = ".share-facebook-icon")
    private WebElement facebookShare;
    private String url = "https://www.youtube.com/watch?v=Qn8MJWw1III";
    private String postTitle = "Selenium IDE: Browser Automation Testing Tool";
    private WebElement xhpc_message_text;
    private WebElement __CONFIRM__;
    
    public TpHomePage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void load()
    {
        driver.get(url);
    }
    
    public void share()
    {
        Utilities.wait_visible("css", "#footer-container");
        String defaultWindow = driver.getWindowHandle();
        shareMenu.click();
        Utilities.wait_visible("css", ".share-panel-services");
        facebookShare.click();
        switchWindow();
        submitShare(postTitle);
        Utilities.wait_invisible("id", "__CONFIRM__");
        driver.switchTo().window(defaultWindow);
    }
    
    private void switchWindow()
    {
        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }
    }
    
    private void submitShare(String title)
    {
        xhpc_message_text.sendKeys(title);
        __CONFIRM__.click();
    }
}
