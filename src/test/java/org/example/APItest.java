package org.example;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APItest {
    @Test
    public void getTestOpenUrl(){
        given().log().uri().
                when().get("https://megatop.by/")
                .then().statusCode(200);
    }
    @Test
    public void getTestSearchSneakers() {
        given().log().all().
                when().get("https://megatop.by/api/v1/search/process?query=X-PLODE&city=&limit=40&device=desktop").
                then().statusCode(200).
                body("products[0].name", equalTo("Кеды X-Plode 1189000035"));
    }
}
