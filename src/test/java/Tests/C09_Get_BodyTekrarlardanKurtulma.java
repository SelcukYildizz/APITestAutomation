package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_BodyTekrarlardanKurtulma {


    @Test
    public void test01(){

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
        donen Response’un,


        status code’unun 200,
        ve content type’inin application-json,
        ve response body’sindeki
        "firstname“in, "Susan",
        ve "lastname“in, "Jackson",
        ve "totalprice“in, 100 den kucuk oldugu,
        ve "depositpaid“in, false,
        ve "additionalneeds“in, bos bırakılmamıs


        oldugunu test edin

         */

        //1- Endpoint ve ReqestBody hazırlamak.

        String url = "https://restful-booker.herokuapp.com/booking/551";

        //2- Expected Data olustur

        //3- Request gnderip dönen Response u kaydet.

        Response response = given().when().get(url);

        //4- Assertion,
        /* 1. Assertion Yontemi;


        response.prettyPrint();

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Susan"))
                .body("lastname",Matchers.equalTo("Jackson"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo(false))
                .body("additionalneeds",Matchers.notNullValue());
        */

        // 2. Assertion yontemi

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Susan"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", lessThan(1000),
                        "depositpaid",equalTo(false),
                        "additionalneeds",notNullValue());











    }



}
