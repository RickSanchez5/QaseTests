package com.qase.io.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(id = "inputEmail")
    public SelenideElement login;
    @FindBy(id = "inputPassword")
    public SelenideElement password;
    @FindBy(id = "btnLogin")
    public SelenideElement loginBtn;

    public void enterLogin(String userLogin) {
        login.click();
        login.clear();
        login.sendKeys(userLogin);
    }

    public void enterPassword(String userPassword) {
        password.click();
        password.clear();
        password.sendKeys(userPassword);
    }

    public DashboardPage clickLoginBtn() {
        loginBtn.click();
        return page(DashboardPage.class);
    }
}
