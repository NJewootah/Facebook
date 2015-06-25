package facebook.pages;

import facebook.support.Utilities;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class FriendRequestPage 
{
    private WebDriver driver;
    
    @FindBy(xpath = "//*[@id=\"fbRequestsJewel\"]/a[1]")
    private WebElement toggleFriendRequests;
    @FindBy(xpath = "//*[@id=\"fbRequestsList\"]/div[1]/div[2]/a[1]")
    private WebElement viewAll;
    @FindBy(xpath = "//*[@class=\"phl\"]")
    private WebElement friend_requests;
    
    public FriendRequestPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void load()
    {
        Utilities.wait_visible("xpath", "//*[@id=\"fbRequestsJewel\"]/a[1]");
        toggleFriendRequests.click();
        Utilities.wait_visible("xpath", "//*[@id=\"fbRequestsList\"]/div[1]/div[2]/a[1]");
        viewAll.click();
    }
    
    public void approve(String user)
    {
        Utilities.wait_visible("class", "phl");
        List<WebElement> usernames = friend_requests.findElements(By.xpath(".//a[@data-hovercard] | .//button[@type=\"submit\"]"));
        for (WebElement username: usernames)
        {
            if(username.getText().equals(user))
            {
                int usernameIndex = usernames.indexOf(username);
                int confirmBtnIndex = usernameIndex - 2;
                usernames.get(confirmBtnIndex).click();
                Utilities.wait_visible("xpath", "//span[contains(text(),'Friends')]");
            }
        }
    }
}
