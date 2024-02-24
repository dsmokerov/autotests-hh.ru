package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ApplicantVacancySearchPage {
    @Step("Проверка отображения заголовка страницы поиска")
    public ApplicantVacancySearchPage checkSearchHeader(String title) {
        SelenideElement catalogHeader = $("[data-qa='vacancies-search-header']");
        catalogHeader.shouldHave(text(title));
        return this;
    }
}