package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class EmployerMainPage {

    @Step("Страница содержит промотекст для работодателя")
    public EmployerMainPage checkIndexTitle(String title) {
        $("div[data-qa='employer-index-title']").shouldHave(text(title));
        return this;
    }

    @Step("Поиск резюме по фразе {0}")
    public EmployerMainPage searchResumeByText(String text) {
        $("[data-qa='employer-index-search-input']").setValue(text).pressEnter();
        return this;
    }


}