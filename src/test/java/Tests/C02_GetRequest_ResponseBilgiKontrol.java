package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgiKontrol {



    @Test
    public void test01(){


        /* https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request

        gonderdigimizde donen Response’un,

        status code’unun                        : 200,
        ve content type’inin                    : application/json; charset=utf-8,
        ve Server isimli Header’in degerinin    :Cowboy,
        ve status Line’in                       : HTTP/1.1 200 OK
        ve response suresinin                   : 5 sn’den kisa oldugunu

        manuel olarak test ediniz.

         */

          // 1- Gerekli bir Body ve Endpoint hazırla.

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected Body olustur.

        // 3- Request gönder ve dönen Response u kaydet.

        Response response = given().when().get(url);
        System.out.println("Status Code  : " +response.getStatusCode());
        System.out.println("Content Type  : " +response.getContentType());
        System.out.println("Server Header Degeri : " +response.getHeader("Server"));
        System.out.println("Status Line Degeri  : " + response.getStatusLine());
        System.out.println("Response Suresi   : " + response.getTime() + "ms");

        // 4-






    }






}
