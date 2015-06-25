package facebook;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.junit.Cucumber;

import facebook.pages.App;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty", "html:target/cucumber"})
public class RunTests 
{
    private static WebDriver driver;
    public static App app;
    
    @BeforeClass
    public static void setUp()
    {
        driver = new FirefoxDriver();
        app = new App(driver);
        
        App.loginPage.load();
        //App.loginPage.enterCredentials("ninitests@gmail.com", "Pass123w");//Neermal
        //App.taskbar.search("Nini Tests");
        //App.profilePage.add_friend();
        //App.loginPage.enterCredentials("ninistudies@gmail.com", "Pass123w");//Nini
        //App.friendRequestPage.load();
        //App.friendRequestPage.approve("Neermal Tests");
        //App.loginPage.enterCredentials("ninitests@gmail.com", "Pass123w");//Neermal
        //App.profilePage.load("Neermal");
        //App.profilePage.postStatus("Testing this awesome status");
        //App.tpHomePage.load();
        //App.tpHomePage.share();
        //App.loginPage.load();
    }
    
    @AfterClass
    public static void tearDown() 
    {
        App.loginPage.enterCredentials("ninitests@gmail.com", "Pass123w");//Neermal
        App.profilePage.load("Neermal");
        App.profilePage.deletePost("Testing this awesome status");
        //App.profilePage.load("Neermal");
        //App.profilePage.deletePost("Selenium IDE: Browser Automation Testing Tool");
        



        // Require friends profile id to navigate straight to profile to improve robustness
        //App.taskbar.search("Neermal Tests");
        //App.profilePage.unfriend();
        //----------------------------------------------------------------------------------
       
        //driver.quit();
    }
}