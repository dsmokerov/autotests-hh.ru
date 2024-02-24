package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка функционала работодателя")
public class TestEmployer extends TestBase {

    @Test
    @Tag("UI")
    @DisplayName("Проверка промотекста для работодателя")
    public void checkTitleForEmployers() {
        mainPage.openPage();
        mainPage.clickEmployerLink();
        employerMainPage.checkIndexTitle("Разместите вакансию на hh.ru");
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск резюме по профессии")
    public void searchVacanciesByProfession() {
        String search = "QA engineer";
        mainPage.openPage();
        mainPage.clickEmployerLink();
        employerMainPage.searchResumeByText("QA engineer");
        employerSearchPage.checkSearchHeader(search);
    }
}