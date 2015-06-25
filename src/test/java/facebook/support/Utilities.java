package facebook.support;

import facebook.pages.App;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utilities 
{ 
    public static char[] commonLD = "abcdefghijklmnopqrstuvwxyz0123456789abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    
    public static void wait_visible(String type, String element)
    {
        switch (type) 
        {
            case "id":  App.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
                break;
            case "xpath":  App.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
                break;
            case "class":  App.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
                break;
            case "css":  App.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
                break;
            default: System.out.print("Please provide a type of following: id, xpath, class, css");
                break;
        }
    }
    
    public static void wait_invisible(String type, String element)
    {
        switch(type)
        {
            case "id": App.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(element)));
                break;
            default: System.out.println("Please provide a type of following: id");
                break;
        }
    }
}