package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {


    @Test
    public void test01(){

     /*
     http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
     request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

     Request Body
      {
      "status": "success",
      "data": {
      "name": “Ahmet",
      "salary": "1230",
      "age": "44",
      "id": 40
      }
      }

      Response Body
      { "status": "success",
      "data": {
      "status": "success",
      "data": {
      "name": “Ahmet",
      "salary": "1230",
      "age": "44",
      "id": 40 }
      },
      "message": "Successfully! Record has been updated."}

      */

        //1- Endpoint ve requestbody hazirlama.

        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestbody = new JSONObject();
        JSONObject dataBilgileri = new JSONObject();

        dataBilgileri.put("name", "Ahmet");
        dataBilgileri.put("salary", "1230");
        dataBilgileri.put("age", "44");
        dataBilgileri.put("id", 40);

        requestbody.put("status", "success");
        requestbody.put("data",dataBilgileri);

        //2- Expected data olustur.

        JSONObject expectedData = new JSONObject();

        expectedData.put("status","success");
        expectedData.put("data",requestbody);
        expectedData.put("message", "Successfully! Record has been updated.");

        //3- Donen response kaydedilir.

        Response response = given().contentType(ContentType.JSON)
                            .when().body(requestbody.toString())
                .put(url);

        //4- Assertion

        JsonPath responseJsonPath = response.jsonPath();

        SoftAssert softassert = new SoftAssert();

        softassert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softassert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));

        softassert.assertEquals(responseJsonPath.get("data.status")
                ,expectedData.getJSONObject("data").get("status"));

        //softassert.assertEquals(responseJsonPath.get("data.data.name")
               // ,expectedData.getJSONObject("data").getJSONObject("data").get("data"));

        softassert.assertEquals(responseJsonPath.get("data.data.id")
                ,expectedData.getJSONObject("data").getJSONObject("data").get("id"));

        softassert.assertEquals(responseJsonPath.get("data.data.salary")
                ,expectedData.getJSONObject("data").getJSONObject("data").get("salary"));








        softassert.assertAll();















    }
}
