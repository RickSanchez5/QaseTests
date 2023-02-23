import com.codeborne.selenide.Configuration;
import com.qase.io.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.CardData;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;


public class FirstTests {

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1600x1000";
    }
/*
    @Test
    public void loginAsRegisteredUser() throws Exception {
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin("forEducationBelov@yandex.ru");
        loginPage.enterPassword("ViVaLaFreedom");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
    }

    @Test
    public void openProjects(){
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin("forEducationBelov@yandex.ru");
        loginPage.enterPassword("ViVaLaFreedom");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
    }
*/
    @Test
    public void createCard(){
        CardData defect = new CardData("title2","desc1");
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin("forEducationBelov@yandex.ru");
        loginPage.enterPassword("ViVaLaFreedom");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        DefectsPage defectsPage = projectDashboardPage.openDefects();
        defectsPage.checkDefectsPage();
        defectsPage.clickCreateNewDefect();
        defectsPage.addNewDefect(defect.getCardName(), defect.getCardDescription());
        defectsPage.checkDefectAdded(defect.getCardName());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        closeWindow();
    }
}

