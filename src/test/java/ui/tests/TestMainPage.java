package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка функционала главной страницы")
public class TestMainPage extends TestBase {

    @Test
    @Tag("UI")
    @DisplayName("Проверка промотекста для соискателя")
    public void checkTitleForApplicants() {
        mainPage.openPage();
        mainPage.checkIndexTitle("Работа найдётся для каждого");
    }

    @Test
    @Tag("UI")
    @DisplayName("Проверка смены языка сайта на английский")
    public void checkLanguageSwitcher() {
        mainPage.openPage();
        mainPage.changeLocale("EN");
        mainPage.checkIndexTitle("There's a job for everyone");
    }

    @Test
    @Tag("UI")
    @DisplayName("Проверка смены города")
    public void checkRegionSwitcher() {
        mainPage.openPage();
        mainPage.changeRegion("Краснодар");
        mainPage.checkWorkInCompanyTitle("Работа в компаниях Краснодара");
    }
}