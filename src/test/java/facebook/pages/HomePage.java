package facebook.pages;

import facebook.support.Utilities;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.By;

public class HomePage 
{
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"pagelet_bluebar\"]//a[contains(text(), 'Home')]")
    private WebElement home;
    
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void load()
    {
        Utilities.wait_visible("xpath", "//*[@id=\"pagelet_bluebar\"]//a[contains(text(), 'Home')]");
        home.click();
    }
    
    public void findPost(String message)
    {
        Utilities.wait_visible("css", "._5pbx.userContent");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //List<WebElement> postElements = driver.findElements(By.cssSelector("._5pbx.userContent"));
        //Assert.assertEquals(true, postMatch(message,postElements));
    }
    
    private boolean postMatch(String message, List<WebElement> elementList)
    {
        boolean match = false;
        for(WebElement post:elementList)
        {
            if(post.getText().equals(message))
            {
                match = true;
            }
        }
        return match;
    }
}