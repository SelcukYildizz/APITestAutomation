import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C01_GetRequest_ResponseBodyYazdirma {


    @Test
    public void get01(){

      // 1- Request Body ve End Point hazirlama

     String url = "https://restful-booker.herokuapp.com/booking/10" ;



      // 2- Expected Data hazirlama



      // 3- Request gönderip dönen response u kaydetme.

        Response response = given().when().get(url);
        response.prettyPrint();

      // 4- Assertion



    }











}
