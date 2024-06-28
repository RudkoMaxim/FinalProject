package org.example;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APItest {
    @Test
    public void getTestOpenUrl(){
        given().log().all().headers("Content-Type","application/json").headers("Accept","*/*").
                when().get("https://megatop.by/")
                .then().statusCode(200);
    }
    @Test
    public void getTestSearchByModelId() {
        given().log().all().contentType(ContentType.JSON).
                when().get("https://megatop.by/api/v1/search?query=0797000405&device=desktop").
                then().statusCode(200).
                body("products[0].name", equalTo("Кроссовки X-Plode 0797000405"));
    }
}
