package facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App 
{
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static Taskbar taskbar;
    public static ProfilePage profilePage;
    public static FriendRequestPage friendRequestPage;
    public static TpHomePage tpHomePage;
    public static WebDriverWait wait;
    
    public App(WebDriver driver)
    {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        taskbar = new Taskbar(driver);
        profilePage = new ProfilePage(driver);
        friendRequestPage = new FriendRequestPage(driver);
        tpHomePage = new TpHomePage(driver);
        wait = new WebDriverWait(driver, 10);
    }
}
