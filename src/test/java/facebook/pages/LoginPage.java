package facebook.pages;

import facebook.RunTests;
import facebook.support.Utilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
    private WebElement email;
    private WebElement pass;
    private WebDriver driver;
    private String url = "http://facebook.com";
    
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void load()
    {
        driver.get(url);
    }
    
    public void enterCredentials(String username, String password)
    {
        if(driver.findElements(By.id("email")).size() == 0)
        {
            RunTests.app.taskbar.logout();
        }
        Utilities.wait_visible("id", "email");
        submitLogin(username,password);
    }
    
    private void submitLogin(String username, String password)
    {
        email.sendKeys(username);
        pass.sendKeys(password);
        pass.sendKeys(Keys.RETURN);
    }
}
