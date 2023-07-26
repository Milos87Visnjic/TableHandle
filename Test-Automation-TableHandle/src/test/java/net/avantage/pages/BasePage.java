package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    @FindBy(css = "button#onetrust-accept-btn-handler")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//span[text()='Yes']")
    public WebElement yesButton;

    @FindBy(xpath = "//button[contains(@class,'account')]//img")
    public WebElement avatar;

    @FindBy(xpath = "(//button[contains(@class,'account')]//div)[1]")
    public WebElement avatarInitials;

    @FindBy(xpath = "//button[@aria-label='open drawer']")
    public WebElement hamburgerMenu;

    /**
     * provides accepting all cookies
     */
    public void acceptCookies(){
        BrowserUtils.waitForVisibility(acceptAllCookies, 60);
        acceptAllCookies.click();
    }

    /**
     * provides accepting +18 age question.
     */
    public void acceptAge(){
        BrowserUtils.waitForClickablility(yesButton,5);
        BrowserUtils.clickWithJS(yesButton);
    }

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}