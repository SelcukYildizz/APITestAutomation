import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.net.Socket;

public class C10_JsonPathKullanimi {

  @Test
    public void test01(){

      JSONObject kisiBilgileriJsonObj = new JSONObject();

      JSONObject adresJsonObj = new JSONObject();

      JSONArray telefonBilgileriArr = new JSONArray(); // İki adet tel bilgisi var, o yüzden array,
      JSONObject cepTelefonuJsonObj = new JSONObject();
      JSONObject evTelefonuJsonObj = new JSONObject();



      adresJsonObj.put("streetAddress","naist street");
      adresJsonObj.put("city","Nara");
      adresJsonObj.put("postalCode","630-0192");

      cepTelefonuJsonObj.put("type","iphone");
      cepTelefonuJsonObj.put("number","0123-4567-8888");

      evTelefonuJsonObj.put("type","home");
      evTelefonuJsonObj.put("number","0123-4567-8910");

      telefonBilgileriArr.put(cepTelefonuJsonObj);
      telefonBilgileriArr.put(evTelefonuJsonObj);

      kisiBilgileriJsonObj.put("firstName","John");
      kisiBilgileriJsonObj.put("lastName","doe");
      kisiBilgileriJsonObj.put("age",26);
      kisiBilgileriJsonObj.put("adress",adresJsonObj);
      kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArr);

    System.out.println(kisiBilgileriJsonObj);

    System.out.println("firstName" + kisiBilgileriJsonObj.get("firstName")); // John

    System.out.println("cadde : " + kisiBilgileriJsonObj
            .getJSONObject("adress")
            .get("streetAddress"));

















  }



}
