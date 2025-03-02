package Tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestapi extends BaseUrlJsonPlaceholder {

    /*
        Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
        edin

        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve “title” degerinin
        “optio dolor molestias sit” oldugunu test edin

        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
        null oldugunu test edin

        */

    @Test
    public void test01(){

        /*
         1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
        edin

         */

        //-1 Endpoint ve rquestbody hazirlama

        specJsonPlaceholder.pathParam("pp1","posts");

        //2- Expected Data olustur

        //-3 Requesti gonder ve donen response u kaydet.

        Response response = given()
                                  .when().spec(specJsonPlaceholder)
                                  .get("/{pp1}");

        //4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.hasSize(100));



    }

    @Test
    public void test02(){

        /*

        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve “title” degerinin
        “optio dolor molestias sit” oldugunu test edin

         */

        //1- Endpoint ve requestbody olustur.

        specJsonPlaceholder.pathParams("pp1","posts","pp2","44");

        //2- Expected Data olustur

        //3-  Requesti gonder ve donen response u kaydet.

                Response response = given()
                                         .when().spec(specJsonPlaceholder)
                        .get("/{pp1}/{pp2}");


        //4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("optio dolor molestias sit"));

    }

    @Test
    public void test03(){

        /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
        null oldugunu test edin

         */

        //1- Endpoint ve requestbody olustur.

        specJsonPlaceholder.pathParams("pp1","posts","pp2","50");

        //2- Expected Data olustur

        //3-  Requesti gonder ve donen response u kaydet.

        Response response = given()
                .when().spec(specJsonPlaceholder)
                .delete("/{pp1}/{pp2}");

        response.prettyPrint();


        //4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("body",Matchers.nullValue());









    }
}
