import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {


     @Test
    public void test01(){

         /*
             https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
             yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz

             Response body :
             {
             "userId": 3,
             "id": 22,
             "title": "dolor sint quo a velit explicabo quia nam",
             "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
             um mollitia molestiae aut atque rem suscipitnam impedit esse"
             }

          */

          // 1- Endpoint ve request body olusturma

         String url = "https://jsonplaceholder.typicode.com/posts/22";

         //2- Expected body olusturma

         JSONObject expectedData= new JSONObject();
         expectedData.put("userId",3);
         expectedData.put("id",22);
         expectedData.put("title","dolor sint quo a velit explicabo quia nam");
         expectedData.put("body","eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear\n" +
                 "             um mollitia molestiae aut atque rem suscipitnam impedit esse");



         //3- Request gonder ve donen response u kaydet

         Response response = given().when().get(url);

         //4- Assertion



          //1. Yontem

          /*
         response
                 .then()
                 .assertThat()
                 .body("userId", Matchers.equalTo(3)
                         ,"id",Matchers.equalTo(22)
                         ,"title",Matchers.equalTo("dolor sint quo a velit explicabo quia nam"));

          */

          //2.Yontem

          JsonPath responseJsonpAth = response.jsonPath();

          Assert.assertEquals(expectedData.get("id"),responseJsonpAth.get("id"));
          Assert.assertEquals(expectedData.get("title"),responseJsonpAth.get("title"));
          Assert.assertEquals(expectedData.get("body"),responseJsonpAth.get("body"));
          Assert.assertEquals(expectedData.get("userId"),responseJsonpAth.get("userId"));









     }

}
