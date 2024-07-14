import org.json.JSONObject;
import org.junit.Test;

public class C05_JsonObjeOlusturma2 {

    @Test
    public void test1(){

        /*  Bu JSon body sini olusturun :
            {
           "firstname":"Jim",
           "additionalneeds":"Breakfast",
           "bookingdates":{
           "checkin":"2018-01-01",
           "checkout":"2019-01-01"
           },
           "totalprice":111,
           "depositpaid":true,
           "lastname":"Brown"
            }

         */

        // Once inner Json object olusturulur.

        JSONObject dateJsonObject = new JSONObject();

        dateJsonObject.put("checkin","2018-01-01"); // inner Json object, önce bunu yazarız
        dateJsonObject.put("checkout","2019-01-01");

        // Sonra outer Json obje olusturup, yeri gelince inner object i yerine koyalim

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstname","Jim");
        requestBody.put("additionalneeds","Breakfast");
        requestBody.put("bookingdates",dateJsonObject);
        requestBody.put("totalprice",111);
        requestBody.put("depositpaid",true);
        requestBody.put("lastname","Brown");

        System.out.println(requestBody);

        //{"firstname":"Jim",
        // "additionalneeds":"Breakfast",
        // "bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},
        // "totalprice":111,
        // "depositpaid":true,
        // "lastname":"Brown"}

    }

}
