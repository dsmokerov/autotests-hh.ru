package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    @Step("Открыта главная страница")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Клик по ссылке 'Работодателям'")
    public MainPage clickEmployerLink() {
        SelenideElement link = $("a[data-qa='mainmenu_employer']");
        if (link.exists()) {
            link.click();
        }
        return this;
    }

    @Step("Выбран язык {0}")
    public MainPage changeLocale(String locale) {
        $("[data-qa='change-locale-" + locale + "']").scrollIntoView(true).click();
        return this;
    }

    @Step("Выбираем город {0}")
    public MainPage changeRegion(String city) {
        $("[data-qa='mainmenu_areaSwitcher']").click();
        $("[data-qa='area-switcher-welcome']").click();
        $(byText(city)).click();
        return this;
    }

    @Step("Страница содержит промотекст для соискателя")
    public MainPage checkIndexTitle(String title) {
        $("h3[data-qa='bloko-header-3']").shouldHave(text(title));
        return this;
    }

    @Step("Отображаются вакансии для города {0}")
    public MainPage checkWorkInCompanyTitle(String title) {
        $("a[data-qa='index__work-in-company-header']").shouldHave(text(title));
        return this;
    }

    @Step("Поиск по фразе {0}")
    public MainPage searchVacanciesByText(String text) {
        $("[data-qa='search-input']").setValue(text).pressEnter();
        return this;
    }
}
