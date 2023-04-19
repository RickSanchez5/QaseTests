package com.qase.io.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    @FindBy(xpath = "//a[.='Demo Project']")
    public SelenideElement projectLink;

    @FindBy(xpath = "//a[.='Projects']")
    public SelenideElement myProjectsLink;

    public void checkUserAuthorized() {
        projectLink.shouldBe(Condition.visible);
    }

    public ProjectsPage openMyProjects(){
        myProjectsLink.click();
        return Selenide.page(ProjectsPage.class);
    }
}

