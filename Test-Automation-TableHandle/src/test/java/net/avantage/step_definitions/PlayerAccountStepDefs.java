package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.LoginPage;
import net.avantage.pages.PlayerAccountPage;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import org.junit.Assert;

public class PlayerAccountStepDefs {
    PlayerAccountPage playerAccountPage = new PlayerAccountPage();
    LoginPage loginPage = new LoginPage();
    String email = ConfigurationReader.get("email");


    @Given("User navigates to Game Portal Page")
    public void user_navigates_to_game_portal_page() {
        Driver.get().navigate().to(ConfigurationReader.get("url_Avantage"));

    }
    @Given("User accepts all cookies and age questions")
    public void user_accepts_all_cookies_and_age_questions() {playerAccountPage.acceptCookies();
        playerAccountPage.acceptAge();

    }
    @Given("User logs in")
    public void user_logs_in() {loginPage.logIn(email);
        System.out.println("Logged in successflully");
    }
    @When("User clicks on Avatar or user's credentials")
    public void user_clicks_on_avatar_or_user_s_credentials() {
    playerAccountPage.clickOnTheAvatar();
    System.out.println("Avatar was clicked");
    }
    @Then("User's name on the Player Account should be correct")
    public void user_s_name_on_the_player_account_should_be_correct() {
        System.out.println(playerAccountPage.PlayerAccountName.getText());
        Assert.assertEquals(ConfigurationReader.get("playerName"),playerAccountPage.PlayerAccountName.getText());
        System.out.println("User name on the PlayerAccount OKay");
    }
    @Then("User clicks on Player's Profile")
    public void user_clicks_on_player_s_profile() {
     playerAccountPage.PlayerProfileButton();

    }
    @Then("The user's name and the name in Player Profile should be equal")
    public void the_user_s_name_and_the_name_in_player_profile_should_be_equal() {
        System.out.println(playerAccountPage.PlayerProfileName.getText());
        Assert.assertEquals(ConfigurationReader.get("playerProfileName"),playerAccountPage.PlayerProfileName.getText());

    }


    @And("User clicks on Player Account Tab")
    public void userClicksOnPlayerAccountTab() {
    playerAccountPage.PlayerAccountTab();
    }
}
