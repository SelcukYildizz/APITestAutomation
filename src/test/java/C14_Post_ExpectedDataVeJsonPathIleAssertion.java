import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void test01(){

        /*

        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

    Request body
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}

   Expected Response Body
{
"bookingid": 24,
"booking": {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
}
}

         */

  // 1- Endpoint ve request body olustur

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject reztarihleriJson = new JSONObject();

        reztarihleriJson.put("checkin","2021-06-01");
        reztarihleriJson.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid","false");
        requestBody.put("bookingdates", reztarihleriJson);
        requestBody.put("additionalneeds","wi-fi");

        //2- Expected Data oluştur.

        JSONObject expectedData = new JSONObject();

        expectedData.put("bookingid",24);
        expectedData.put("booking",requestBody);

        //3- Request gönderip donen response kaydedilir.

        Response response = given().contentType(ContentType.JSON)   // Post oldugu için bunlar tanıtılır.
                              .when().body(requestBody.toString())
                              .post(url);


        // 4- Assertion
        JsonPath responseJsonPath = response.jsonPath(); // Response u Jsonpath haline getirdik.

        // ilk yazdigimiz expected ===> olusturdugumuz JsonObject : expecteddata
        // ikinci yazilan actusal ====> response : responseJsonPath

        assertEquals(expectedData.getJSONObject("booking").
                get("firstname"),responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").
                get("lastname"),responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").
                get("totalprice"),responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));















    }


}
