package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class EmployerSearchPage {

    @Step("Проверка отображения заголовка страницы поиска")
    public EmployerSearchPage checkSearchHeader(String title) {
        SelenideElement catalogHeader = $("h1[data-qa='bloko-header-3']");
        catalogHeader.shouldHave(text(title));
        return this;
    }
}
