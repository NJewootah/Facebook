package facebook.pages;

import facebook.support.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProfilePage 
{
    private WebDriver driver;
    @FindBy(xpath = "//button[contains(text(),'Add Friend')]")
    private WebElement addFriendBtn;
    @FindBy(xpath = "//*[@id=\"pagelet_timeline_recent\"]//span[contains(text(),'Status')]")
    private WebElement statusTab;
    @FindBy(xpath = "//*[@id=\"mentionsInput\"]//textarea")
    private WebElement statusTextArea;
    @FindBy(xpath = "//*[@class=\"lastCapsule\"]//button[contains(text(),'Post')]")
    private WebElement PostBtn;
    @FindBy(xpath = "//a[@data-unref=\"bd_profile_button\"]")
    private WebElement FriendsBtn;
    @FindBy(css = ".layerConfirm")
    private WebElement confirmDelete;
    private int postIndex;
    
    public ProfilePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void add_friend()
    {
        Utilities.wait_visible("id", "pagelet_escape_hatch");
        addFriendBtn.click();
        Utilities.wait_visible("xpath", "//button[contains(text(),'Friend request sent')]");
    }
    
    public void unfriend()
    {
        Utilities.wait_visible("xpath", "//a[@data-unref=\"bd_profile_button\"]");
        FriendsBtn.click();
        Utilities.wait_visible("id", "friendFlyoutContent");
        List<WebElement> friendOptions = driver.findElements(By.xpath("//*[@id=\"friendFlyoutContent\"]//a"));
        for(WebElement option:friendOptions)
        {
            if(option.getText().equals("Unfriend"))
            {
                option.click();
                break;
            }
        }
        Utilities.wait_visible("xpath", "//button[contains(text(),'Add Friend')]");
    }
    
    public void load(String firstname)
    {
        Utilities.wait_visible("xpath", "//*[@id=\"pagelet_bluebar\"]//span[contains(text()," + firstname + ")]");
        driver.findElement(By.xpath("//*[@id=\"pagelet_bluebar\"]//span[contains(text()," + firstname + ")]")).click();
    }
    
    public void postStatus(String message)
    {
        Utilities.wait_visible("xpath", "//*[@id=\"pagelet_timeline_recent\"]//span[contains(text(),'Status')]");
        statusTab.click();
        statusTextArea.sendKeys(message);
        PostBtn.click();
        Utilities.wait_visible("xpath", "//*[contains(text(), \"" + message + "\")]");
    }
    
    public void deletePost(String message)
    {
        getStoryOptions(message);
        clickDelete();
        Utilities.wait_visible("css", ".layerConfirm");
        confirmDelete.click();
    }
    
    //Finds the story options of a specific status
    public void getStoryOptions(String message)
    {
        Utilities.wait_visible("css", "._5pbx.userContent");
        List<WebElement> posts = driver.findElements(By.xpath("//div[contains(@class, 'userContent') and contains(@class, '_5pbx')]"));
        for(WebElement post:posts)
        {
            if(post.getText().equals(message))
            {
                postIndex = posts.indexOf(post);
            }
        }
        List<WebElement> opts = driver.findElements(By.xpath("//a[@aria-label=\"Story options\"]"));
        opts.get(postIndex).click();
    }
    
    public void clickDelete()
    {
        /*List<WebElement> storyOpts = driver.findElements(By.cssSelector("._54nh"));
        for(WebElement story:storyOpts)
        {
            if(story.getText().equals("Delete"))
            {
                story.click();
            }
        }*/
        Utilities.wait_visible("css", "li._54ni:nth-child(8) > a:nth-child(1)");
        WebElement delete = driver.findElement(By.cssSelector("li._54ni:nth-child(8) > a:nth-child(1)"));
        delete.click();
    }
}
