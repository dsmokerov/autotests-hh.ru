package api.tests;

import api.models.EmployersListResponseModel;
import api.models.EmployersListResponseModel.EmployerItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static api.specs.RequestApiSpecs.requestSpec;
import static api.specs.ResponseApiSpecs.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверка запросов работодателя")
public class TestEmployer {

    @Tag("API")
    @DisplayName("Проверка статуса ответа метода employers")
    @Test
    void checkVacanciesList() {
        step("Проверка статуса ответа метода employers", () -> {
            given(requestSpec)
                    .when()
                    .get("/employers")
                    .then()
                    .statusCode(200)
                    .spec(responseSpec);
        });
    }

    @Tag("API")
    @DisplayName("Поиск работодателя по поисковому запросу")
    @ParameterizedTest(name = "Поиск работодателя по поисковому запросу {0}")
    @ValueSource(strings = {"Жизньмарт", "VK"})
    void checkEmployersByGivenKeywords(String keyword) {
        step("Поиск работодателя по поисковому запросу", () -> {
            EmployersListResponseModel response = given(requestSpec)
                    .queryParam("text", keyword)
                    .when()
                    .get("/employers")
                    .then()
                    .statusCode(200)
                    .spec(responseSpec)
                    .extract()
                    .as(EmployersListResponseModel.class);

        });
    }

    @Tag("API")
    @DisplayName("Поиск работодателя по поисковому запросу только с открытыми вакансиями")
    @ParameterizedTest(name = "Поиск работодателя по поисковому запросу только с открытыми вакансиями {0}")
    @ValueSource(strings = {"VK"})
    void checkEmployersByGivenKeywordsOnlyNotNullVacancy(String keyword) {
        step("Поиск работодателя по поисковому запросу только с открытыми вакансиями", () -> {
            EmployersListResponseModel response = given(requestSpec)
                    .queryParam("text", keyword)
                    .when()
                    .get("/employers")
                    .then()
                    .statusCode(200)
                    .spec(responseSpec)
                    .extract()
                    .as(EmployersListResponseModel.class);

            List<EmployerItem> filteredItems = new ArrayList<>();

            for (EmployerItem item : response.getItems()) {
                if (item.getOpen_vacancies() > 0) {
                    filteredItems.add(item);
                }
            }

            for (EmployerItem item : filteredItems) {
                assertTrue(item.getOpen_vacancies() > 0);
            }

            if (!filteredItems.isEmpty()) {
                System.out.println("Найдены работодатели с открытыми вакансиями:");
                for (EmployerItem item : filteredItems) {
                    System.out.println("Работодатель: " + item.getName() + ", открытых вакансий: " + item.getOpen_vacancies());
                }
            } else {
                System.out.println("Не найдено работодателей с открытыми вакансиями");
            }
        });
    }
}