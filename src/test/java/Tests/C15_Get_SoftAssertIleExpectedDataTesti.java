package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {

      @Test
    public void test01(){


       /*
            http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
           gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.


           Response Body
           {
           "status": "success",
           "data": {
                  "id": 3,
                   "employee_name": "Ashton Cox",
                   "employee_salary": 86000,
                   "employee_age": 66,
                   "profile_image": ""
                    },
           "message": "Successfully! Record has been fetched."
           }

        */

           //1- Endpoint ve request body olustur.

          String url = "http://dummy.restapiexample.com/api/v1/employee/3";

          //2- Expected data olustur

          JSONObject expectedData = new JSONObject();
          JSONObject dataBilgileri = new JSONObject();

          dataBilgileri.put("id",3);
          dataBilgileri.put("employee_name","Ashton Cox");
          dataBilgileri.put("employee_salary",86000);
          dataBilgileri.put("employee_age",66);
          dataBilgileri.put("profile_image","");

          expectedData.put("status","success");
          expectedData.put("data",dataBilgileri);
          expectedData.put("message","Successfully! Record has been fetched.");

          System.out.println(expectedData.toString());

          //3- Request gonderilip donen response kayıt edilir.

            Response response = given().when().get(url);


          //4- Assertion

           // Donen response uzerindeki bilgileri daha kolay almak icin
            // response u JsonPath e cast edelim

            JsonPath responseJsonpath = response.jsonPath();

            // Soft Assertion yapmak için obje olusturalim

          SoftAssert softAssert = new SoftAssert();

          softAssert.assertEquals(responseJsonpath.get("status"),expectedData.get("status"));
         // softAssert.assertEquals(responseJsonpath.get("massage"),expectedData.get("message"));
          softAssert.assertEquals(responseJsonpath.get("data.id")
                  ,expectedData.getJSONObject("data").get("id"));
          softAssert.assertEquals(responseJsonpath.get("data.employee_name")
                  ,expectedData.getJSONObject("data").get("employee_name"));
          softAssert.assertEquals(responseJsonpath.get("data.employee_salary")
                  ,expectedData.getJSONObject("data").get("employee_salary"));
          softAssert.assertEquals(responseJsonpath.get("data.profile_image")
                  ,expectedData.getJSONObject("data").get("profile_image"));










          softAssert.assertAll();












      }

}
