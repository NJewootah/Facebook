package facebook.steps;

import facebook.pages.App;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class HomePageSteps 
{
    @Given("^I am logged in as \"([^\"]*)\"$")
    public void I_am_logged_in_as(String user) 
    {
        if(user.equals("Nini"))
        {
            App.loginPage.enterCredentials("ninistudies@gmail.com");
        }
        else
        {
            System.out.println("Please provide an existing facebook user");
        }
    }

    @When("^I am on the home page$")
    public void I_am_on_the_home_page() 
    {
        App.homePage.load();
    }

    @Then("^I should see my friend's \"([^\"]*)\"$")
    public void I_should_see_my_friend_s(String content)
    {
        switch(content)
        {
            case "posted status": App.homePage.findPost("Testing this awesome status");
                break;
            case "shared photo": App.homePage.findPost("Selenium IDE: Browser Automation Testing Tool"); 
                break;
            default: System.out.println("Content type is invalid");
                break;
        }
    }
}

