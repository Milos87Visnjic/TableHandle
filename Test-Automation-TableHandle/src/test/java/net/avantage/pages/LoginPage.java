package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends BasePage{
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
    public WebElement avatar;

    /**
     * provides entering email and password, and then submit.
     */
    public void logIn(String email){
        BrowserUtils.waitForClickablility(loginButton,5);
        loginButton.click();
        emailButton.click();
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        submitButton.click();
    }

    public void verifyAvatarOrAvatarInitials(){
        try {
            Assert.assertTrue(avatar.isDisplayed());
        }catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(avatarInitials.isDisplayed());
        }
    }
}
