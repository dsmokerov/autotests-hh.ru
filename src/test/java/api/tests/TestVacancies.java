package api.tests;

import api.models.VacancyListResponseModel;
import api.models.VacancyListResponseModel.VacancyItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static api.specs.RequestApiSpecs.requestSpec;
import static api.specs.ResponseApiSpecs.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверка запросов по вакансиям")
public class TestVacancies {

    @Tag("API")
    @DisplayName("Проверка статуса ответа метода vacancies")
    @Test
    void checkVacanciesList() {
        step("Проверка статуса ответа метода vacancies", () -> {
            given(requestSpec)
                    .when()
                    .get("/vacancies")
                    .then()
                    .statusCode(200)
                    .spec(responseSpec);
        });
    }

    @Tag("API")
    @DisplayName("Поиск вакансии по поисковому запросу")
    @ParameterizedTest(name = "Поиск вакансии по поисковому запросу {0}")
    @ValueSource(strings = {"Продавец", "Консультант"})
    void checkVacanciesByGivenKeywords(String keyword) {
        step("Поиск вакансий по поисковому запросу", () -> {
            VacancyListResponseModel response = given(requestSpec)
                    .queryParam("text", keyword)
                    .when()
                    .get("/vacancies")
                    .then()
                    .statusCode(200)
                    .spec(responseSpec)
                    .extract()
                    .as(VacancyListResponseModel.class);

            assertThat(response.getItems().length, greaterThan(0));
        });
    }
}