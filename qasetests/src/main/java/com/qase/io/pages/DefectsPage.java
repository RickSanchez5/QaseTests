package com.qase.io.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DefectsPage {
    @FindBy(xpath = "//h1[.='Defects']")
    public SelenideElement defectsHeader;

    @FindBy(xpath = "//a[.='Create new defect']")
    public SelenideElement createNewDefectBtn;

    @FindBy(id = "title")
    public SelenideElement defectTitle;

    @FindBy(className = "ProseMirror")
    public SelenideElement defectResult;

    @FindBy(xpath = "//div[@id='severityGroup']/div/div/div")
    public SelenideElement defectPrioritySelector;

    @FindBy(xpath = "//div[.='Normal']")
    public SelenideElement defectPriorityNormal;

    @FindBy(xpath = "//button[.='Create defect']")
    public SelenideElement saveDefectBtn;

    @FindBy(xpath = "//a[.='defect-2-title']")
    public SelenideElement cardName;

    public void checkDefectsPage(){
        defectsHeader.shouldBe(Condition.visible);
        createNewDefectBtn.shouldBe(Condition.visible);
    }

    public void clickCreateNewDefect(){
        createNewDefectBtn.click();
    }

    public void setDefectPriorityNormal(){
        defectPrioritySelector.click();
        defectPriorityNormal.click();
    }

    public void addNewDefect(String issueName, String issueDesc){
        defectTitle.click();
        defectTitle.sendKeys(issueName);

        defectResult.click();
        defectResult.sendKeys(issueDesc);
        setDefectPriorityNormal();
        saveDefectBtn.click();
    }

    public void checkDefectAdded(String issueName){
        cardName.shouldBe(Condition.text(issueName));
    }
}

