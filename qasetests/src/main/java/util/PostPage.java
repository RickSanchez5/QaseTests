package util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class PostPage {
    ///a[@innertext='Почта']
    @FindBy(xpath = "//a[.='Почта']")
    public SelenideElement btnEmail;

    @FindBy(xpath = "//header[@id='gb']")
    public SelenideElement headerGoogle;

    public void setBtnEmail(){
        btnEmail.click();
    }

    public void checkUserAuthorized() {
        headerGoogle.shouldBe(Condition.visible);
    }
}


