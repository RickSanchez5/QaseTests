package com.qase.io.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDashboardPage {

    @FindBy(xpath = "//h1[.='DEMO repository']")
    public SelenideElement projectOverview;

    @FindBy(xpath = "//span[.='Defects']")
    public SelenideElement defectsLink;

    public void checkProjectDashboardPage() {
        projectOverview.shouldBe(Condition.visible);
    }

    public DefectsPage openDefects() {
        defectsLink.click();
        return Selenide.page(DefectsPage.class);
    }
}


