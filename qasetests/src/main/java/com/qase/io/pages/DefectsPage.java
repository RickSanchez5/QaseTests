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

    @FindBy(xpath = "//div[@class='ProseMirror toastui-editor-contents']")
    public SelenideElement defectResult_container;

    @FindBy(xpath = "//div[@class='ProseMirror toastui-editor-contents ProseMirror-focused']")
    public SelenideElement defectResult_field;

    @FindBy(xpath = "//div[@id='severityGroup']/div/div/div")
    public SelenideElement defectPrioritySelector;

    @FindBy(xpath = "//div[.='Blocker']")
    public SelenideElement defectPriorityBlocker;

    @FindBy(xpath = "//div[.='Critical']")
    public SelenideElement defectPriorityCritical;

    @FindBy(xpath = "//div[.='Major']")
    public SelenideElement defectPriorityMajor;

    @FindBy(xpath = "//div[.='Normal']")
    public SelenideElement defectPriorityNormal;

    @FindBy(xpath = "//div[.='Minor']")
    public SelenideElement defectPriorityMinor;

    @FindBy(xpath = "//div[.='Trivial']")
    public SelenideElement defectPriorityTrivial;

    @FindBy(xpath = "//button[.='Create defect']")
    public SelenideElement saveDefectBtn;

    @FindBy(xpath = "//a[.='title2']")
    public SelenideElement cardName;

    @FindBy(xpath = "//div[@class='dropdown']")
    public SelenideElement btnDropdown;

    @FindBy(xpath = "//a[.='Delete']")
    public SelenideElement deleteDefectBtn;

    @FindBy(xpath = "//button[.='Delete']")
    public SelenideElement confirmDeleteDefectBtn;

    public void checkDefectsPage(){
        defectsHeader.shouldBe(Condition.visible);
        createNewDefectBtn.shouldBe(Condition.visible);
    }

    public void setDefectPriority(String priority){
        defectPrioritySelector.click();
        switch (priority) {
            case "blocker":
                defectPriorityBlocker.click();
                break;
            case "critical":
                defectPriorityCritical.click();
                break;
            case "major":
                defectPriorityMajor.click();
                break;
            case "normal":
                defectPriorityNormal.click();
                break;
            case "minor":
                defectPriorityMinor.click();
                break;
            case "trivial":
                defectPriorityTrivial.click();
                break;
        }
    }

    public void addNewDefect(String cardTitle,String cardResult) {
        createNewDefectBtn.click();
        defectTitle.click();
        defectTitle.sendKeys(cardTitle);

        defectResult_container.click();
        defectResult_field.sendKeys(cardResult);
        setDefectPriority("trivial");
        saveDefectBtn.click();
    }

    public void checkDefectAdded(String defectName){
        cardName.shouldBe(Condition.text(defectName));
    }

    public void deleteDefect(){
        deleteDefectBtn.click();
        confirmDeleteDefectBtn.click();
    }
}

