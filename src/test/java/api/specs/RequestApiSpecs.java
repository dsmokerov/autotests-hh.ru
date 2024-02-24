package api.specs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static api.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequestApiSpecs {
    public static final String baseUri = "https://api.hh.ru";

    public static RequestSpecification requestSpec = with()
            .log()
            .all()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri(baseUri);
}
