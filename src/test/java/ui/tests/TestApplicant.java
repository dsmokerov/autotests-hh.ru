package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка функционала соискателя")
public class TestApplicant extends TestBase {

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий соискателем по профессии")
    public void searchVacanciesByProfession() {
        String search = "Junior-тестировщик";
        mainPage.openPage();
        mainPage.searchVacanciesByText(search);
        applicantVacancySearchPage.checkSearchHeader(search);
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий соискателем по компании")
    public void searchVacanciesByCompany() {
        String search = "Сбербанк";
        mainPage.openPage();
        mainPage.searchVacanciesByText(search);
        applicantVacancySearchPage.checkSearchHeader(search);
    }
}