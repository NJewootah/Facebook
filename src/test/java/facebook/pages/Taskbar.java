package facebook.pages;

import facebook.support.Utilities;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class Taskbar 
{
    private WebDriver driver;
    private WebElement q;
    private WebElement userNavigationLabel;
    List<WebElement> accountSettings;
    @FindBy(xpath = "//input[@value=\"Log out\"]")
    private WebElement logout;
    
    public Taskbar(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void search(String term)
    {
        q.sendKeys(term);
        q.sendKeys(Keys.RETURN);
    }
    
    public void logout()
    {
        userNavigationLabel.click();
        getLogoutBtn();
    }
    
    private void getLogoutBtn()
    {
        char[] alphabet = Utilities.commonLD;
        mainloop:
        for(char i:alphabet)
        {
            accountSettings = driver.findElements(By.xpath("//*[@id=\"js_" + i + "\"]//a"));
            if(accountSettings.size() != 0)
            {
                System.out.print(i);
                for(WebElement settings:accountSettings)
                {
                    if(settings.getText().equals("Log out"))
                    {
                        settings.click();
                        break mainloop;
                    }
                }
            }
            else if(i == 9)
            {
                logout.click();
                System.out.println("Value Logout");//Checking if this fails a logout attempt
            }
        }
    }
}
