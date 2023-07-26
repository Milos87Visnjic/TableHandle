package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayerAccountPage extends BasePage{
    @FindBy(xpath = "//p[contains(@class, 'account')]/span")
    public WebElement loginButton;

    @FindBy(xpath = "//button[contains(@class, 'account')]//span[contains(text(), 'Email')]")
    public WebElement emailButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[contains(@class,'account')]//div")
    public WebElement AvatarInitialsButton;

    @FindBy(xpath = "//div[text()='Player Account']")
    public WebElement PlayerAccountTab;

    @FindBy (xpath = "//h1[contains(@class,'account')]")
    public WebElement PlayerAccountName;

    @FindBy (xpath = "//p[text()='Player Profile']")
    public WebElement PlayerProfileButton;

    @FindBy (xpath="//p[text()='Nafiseh Ghazimoradi']")
    public WebElement PlayerProfileName;



    /**
     * This method enables to click AvatrInitials button.
     */

    public void clickOnTheAvatar() {
        BrowserUtils.waitForClickablility(AvatarInitialsButton, 15);
        AvatarInitialsButton.click();
    }


    /**
     * This method enables to click PlayerProfile button.
     */

    public void PlayerProfileButton(){
        BrowserUtils.waitForClickablility(PlayerProfileButton, 5);
        PlayerProfileButton.click();
    }


    /**
     * This method enables to click Player Account Tab.
     */
    public void PlayerAccountTab () {
        BrowserUtils.waitForClickablility(PlayerAccountTab, 10);
        PlayerAccountTab.click();
    }




    public void logIn(){
        loginButton.click();
        emailButton.click();
        emailInputBox.sendKeys(ConfigurationReader.get("email"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        submitButton.click();}
}
