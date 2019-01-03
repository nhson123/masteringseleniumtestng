package com.masteringselenium.effectivePageObjects;

import com.masteringselenium.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Package: com.masteringselenium.effectivePageObjects
 * Generated by: Hoang.Son.Nguyen
 * Generated at: 03.01.2019 2019
 */
public class LoginPageFactory {
    LoginPageFactory() throws Exception {
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }
    @CacheLookup
    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading']")
    private WebElement authenText;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement email;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    private WebElement pwd;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']//span")
    private WebElement signInBtn;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'There is 1 error')]")
    private WebElement loginError;

    public boolean authenTextDisplay(){
        return authenText.isDisplayed();
    }
    public boolean signInClickable(){
        return signInBtn.isEnabled();
    }
    public LoginPageFactory enterEmail(){
        email.sendKeys("son000@trash-mail.com");
        return this;
    }
    public LoginPageFactory enterPWD(){
        pwd.sendKeys("son000");
        return this;
    }
    public LoginPageFactory failLogin() throws Exception {
        pwd.sendKeys("son000");
        signInBtn.click();
        return new LoginPageFactory();
    }
    public LoggedPageFactory susseccLogin() throws Exception {
        email.sendKeys("son000@trash-mail.com");
        pwd.sendKeys("son000");
        signInBtn.click();
        return new LoggedPageFactory();
    }

    public boolean loginErrorVisible(){
        return loginError.isDisplayed();
    }

}
