package util;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class UserData {
    /*
    //a[@innertext='Войти']

    /div[@innertext='Сменить аккаунт']

    id="identifierId"    name="identifier"

    //div[@id='identifierNext']

    name="password"

    //div[@id='passwordNext']


    */


    @FindBy(xpath = "//a[.='Войти']")
    public SelenideElement btnJoin;

    @FindBy(xpath = "//div[.='Сменить аккаунт']")
    public SelenideElement changeAccount;

    @FindBy(id = "identifierId")
    public SelenideElement login;

    @FindBy(xpath = "//div[@id='identifierNext']")
    public SelenideElement btnNext;

    @FindBy(name = "password")
    public SelenideElement password;

    @FindBy(xpath = "//div[@id='passwordNext']")
    public SelenideElement loginBtn;

    public void setBtnJoin(){
        btnJoin.click();
    }

    public void setChangeAccount(){
        changeAccount.click();
    }

    public void enterLogin(String userLogin) {
        login.click();
        login.clear();
        login.sendKeys(userLogin);
    }

    public void setBtnNext(){
        btnNext.click();
    }

    public void enterPassword(String userPassword) {
        password.click();
        password.clear();
        password.sendKeys(userPassword);
    }

    public PostPage clickLoginBtn() {
        loginBtn.click();
        return page(PostPage.class);
    }

}
