package ui.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import ui.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ui.helpers.Attachments;
import ui.pages.*;

public class TestBase {
    MainPage mainPage = new MainPage();
    ApplicantVacancySearchPage applicantVacancySearchPage = new ApplicantVacancySearchPage();
    EmployerMainPage employerMainPage = new EmployerMainPage();
    EmployerSearchPage employerSearchPage = new EmployerSearchPage();

    public static String env = System.getProperty("env");
    @BeforeAll
    static void beforeAll() {
        WebDriverProvider provider = new WebDriverProvider();
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    void clearCookies() {
        Selenide.clearBrowserCookies();
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }
}